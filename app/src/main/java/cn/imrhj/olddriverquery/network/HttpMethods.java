package cn.imrhj.olddriverquery.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.imrhj.olddriverquery.App;
import cn.imrhj.olddriverquery.api.DuowanService;
import cn.imrhj.olddriverquery.api.GameIconService;
import cn.imrhj.olddriverquery.api.GameService;
import cn.imrhj.olddriverquery.model.duowan_entity.DetailUserInfo;
import cn.imrhj.olddriverquery.model.duowan_entity.Hero;
import cn.imrhj.olddriverquery.model.duowan_entity.PlayerInfo;
import cn.imrhj.olddriverquery.model.duowan_entity.Record;
import cn.imrhj.olddriverquery.model.entity.AllBase;
import cn.imrhj.olddriverquery.model.entity.Area;
import cn.imrhj.olddriverquery.model.entity.CombatBean;
import cn.imrhj.olddriverquery.model.entity.ListUserBase;
import cn.imrhj.olddriverquery.model.entity.TokenInfo;
import cn.imrhj.olddriverquery.model.entity.UserBase;
import cn.imrhj.olddriverquery.model.entity.UserBaseExten;
import cn.imrhj.olddriverquery.model.entity.UserExtInfo;
import cn.imrhj.olddriverquery.model.iface.GameServiceInterface;
import cn.imrhj.olddriverquery.utlis.InfoDeal;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.schedulers.Schedulers;

/**
 * 网络调用方法接口
 * Created by rhj on 16/5/6.
 */
public class HttpMethods implements GameServiceInterface {
    public static final String URL = "http://www.games-cube.com/combat/api/";
    public static final String ICON_URL = "http://ossweb-img.qq.com/images/lol/img/";
    public static final String DUOWAN_URL = "http://API.xunjob.cn/";

    private static HttpMethods mInstance;

    private GameService gameService;
    private GameIconService gameIconService;
    private DuowanService duowanService;
    private List<Area> mAreaLists;


    /**
     * 获取单例,这里使用了DCL方法防止出现单例失效问题
     *
     * @return this
     */
    public static HttpMethods getInstance() {
        return HttpMethodsHandler.httpMethods;
    }

    private static class HttpMethodsHandler {
        private static HttpMethods httpMethods = new HttpMethods();
    }

    private HttpMethods() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        gameService = retrofit.create(GameService.class);
        KLog.d(": initHttpMethods");

        Retrofit iconRetrofit = new Retrofit.Builder()
                .baseUrl(ICON_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        gameIconService = iconRetrofit.create(GameIconService.class);

        Retrofit duowanRetrofit = new Retrofit.Builder()
                .baseUrl(DUOWAN_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        duowanService = duowanRetrofit.create(DuowanService.class);


        getToken();
        KLog.d(": App中的token" + App.token);
        getArea();
    }


    public void getToken() {
        getToken(new Subscriber<TokenInfo>() {
            @Override
            public void onCompleted() {
                KLog.d(": onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                KLog.e(": " + e.getMessage());
            }

            @Override
            public void onNext(TokenInfo tokenInfo) {
                KLog.d(": " + tokenInfo.getKey());
                App.token = tokenInfo.getKey();
            }
        });
    }

    /**
     * 获取Token
     *
     * @param subscriber
     */
    public void getToken(Subscriber<TokenInfo> subscriber) {
        KLog.d(": getToken");
        gameService.getToken(App.USERNAME, App.PASSWORD)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取用户列表
     *
     * @param username   指定用户名
     * @param subscriber 回调函数
     */
    @Override
    public void getUserBase(final String username, Subscriber<ListUserBase> subscriber) {
        Observable<UserBaseExten> observable = null;

        if (App.token != null) {
            observable = gameService.getUserBase(App.token, username)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

        } else {
            observable = gameService.getToken(App.USERNAME, App.PASSWORD)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Func1<TokenInfo, String>() {
                        @Override
                        public String call(TokenInfo tokenInfo) {
                            return tokenInfo.getKey();
                        }
                    })
                    .flatMap(new Func1<String, Observable<UserBaseExten>>() {
                        @Override
                        public Observable<UserBaseExten> call(String s) {
                            return gameService.getUserBase(s, username)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread());
                        }
                    });
        }
        observable.map(new Func1<UserBaseExten, List<UserBase>>() {
            @Override
            public List<UserBase> call(UserBaseExten userBaseExten) {
                return userBaseExten.getData();
            }
        }).map(new Func1<List<UserBase>, List<ListUserBase>>() {
            @Override
            public List<ListUserBase> call(List<UserBase> userBases) {
                Collections.sort(userBases);
                List<ListUserBase> listUserBases = new ArrayList<ListUserBase>();
                for (UserBase userBase : userBases) {
                    ListUserBase listUserBase = new ListUserBase(
                            userBase.getName(),
                            userBase.getIcon_id(),
                            userBase.getArea_id(),
                            userBase.getQquin(),
                            userBase.getName() + " - Lv" + userBase.getLevel(),
                            getArea(userBase.getArea_id()),
                            InfoDeal.getTier(userBase.getTier(), userBase.getQueue()));
                    listUserBases.add(listUserBase);
                }

                return listUserBases;
            }
        }).flatMap(new Func1<List<ListUserBase>, Observable<ListUserBase>>() {
            @Override
            public Observable<ListUserBase> call(List<ListUserBase> listUserBases) {
                return Observable.from(listUserBases);
            }
        }).subscribe(subscriber);
    }

    /**
     * 获取大区名
     *
     * @param areaId
     * @return
     */
    private String getArea(int areaId) {
        for (Area area : mAreaLists) {
            if (areaId == area.getId()) {
                return area.getName();
            }
        }

        return null;
    }

    private void getArea() {
        gameService
                .getArea()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Area>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Area> areas) {
                        mAreaLists = areas;
                    }
                });
    }

    @Override
    public void getArea(final int areaId, Action1<String> action1) {
        if (mAreaLists != null) {
            Observable.from(mAreaLists)
                    .first(new Func1<Area, Boolean>() {
                        @Override
                        public Boolean call(Area area) {
                            return areaId == area.getId();
                        }
                    })
                    .map(new Func1<Area, String>() {
                        @Override
                        public String call(Area area) {
                            return area.getIsp() + ":" + area.getName();
                        }
                    })
                    .subscribe(action1);

        } else {
            gameService.getArea()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(new Func1<List<Area>, Observable<Area>>() {
                        @Override
                        public Observable<Area> call(List<Area> areas) {
                            return Observable.from(areas);
                        }
                    })
                    .first(new Func1<Area, Boolean>() {
                        @Override
                        public Boolean call(Area area) {
                            KLog.d(": " + area.getName());
                            return area.getId() == areaId;
                        }
                    })
                    .map(new Func1<Area, String>() {
                        @Override
                        public String call(Area area) {
                            return area.getIsp() + ":" + area.getName();
                        }
                    })
                    .subscribe(action1);

        }
    }

    @Override
    public void getUserIcon(int iconId, Subscriber<Bitmap> subscriber) {
        if (iconId > 28) {
            return;
        }
        gameIconService.getPlayerIcon(iconId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody responseBody) {
                        return BitmapFactory.decodeStream(responseBody.byteStream());

                    }
                })
                .subscribe(subscriber);
    }

    @Override
    public void getExtInfo(String qquin, int vaid) {
        gameService.getUserExtInfo(App.token, qquin, vaid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<AllBase<UserExtInfo>, UserExtInfo>() {
                    @Override
                    public UserExtInfo call(AllBase<UserExtInfo> userExtInfoAllBase) {
                        return userExtInfoAllBase.getData();
                    }
                })
                .subscribe(new Subscriber<UserExtInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserExtInfo userExtInfo) {
//                        KLog.d(": " + userExtInfo.getItems().size());

                    }
                });
    }

    @Override
    public void getCombatList(String qquin, int vaid, int p) {
        gameService.getCombatList(App.token, qquin, vaid, p)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CombatBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<CombatBean> combatBeen) {
                        KLog.d(": " + combatBeen.size());
                    }
                });
    }

    @Override
    public void getDetailUserInfo(String serverName, String playerName, Subscriber<DetailUserInfo> subscriber) {
        Observable<PlayerInfo> playerInfoObservable = duowanService.getPlayerInfo(serverName, playerName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observable<Record> recordObservable = duowanService.getRecord(serverName, playerName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Record, Record>() {
                    @Override
                    public Record call(Record record) {
                        KLog.e(": " + record.getRecord());


                        StringBuffer buffer = new StringBuffer();
                        String string = record.getRecord();
                        int length = string.length();
                        int pos;
                        while((pos = string.indexOf("%）")) > 0) {
                            buffer.append(string.substring(0, pos + 2));
                            buffer.append("\n");
                            string = string.substring(pos + 2, string.length());
                        }
                        buffer.append(string);
                        record.setRecord(buffer.toString());
                        return record;
                    }
                });
        Observable<Hero> heroObservable = duowanService.getHero(serverName, playerName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable.zip(playerInfoObservable, recordObservable, heroObservable,
                new Func3<PlayerInfo, Record, Hero, DetailUserInfo>() {
            @Override
            public DetailUserInfo call(PlayerInfo playerInfo, Record record, Hero hero) {
                return new DetailUserInfo(playerInfo, record, hero);
            }
        }).subscribe(subscriber);
    }



}

