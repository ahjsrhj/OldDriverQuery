package cn.imrhj.olddriverquery.model.iface;

import android.graphics.Bitmap;

import java.util.List;

import cn.imrhj.olddriverquery.model.entity.ListUserBase;
import cn.imrhj.olddriverquery.model.entity.TokenInfo;
import cn.imrhj.olddriverquery.model.entity.UserBase;
import retrofit2.Callback;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by rhj on 16/5/6.
 */
public interface GameServiceInterface {
    String URL = "http://www.games-cube.com/combat/api/";



    void getToken(Subscriber<TokenInfo> subscriber);


    void getUserBase(String username, Subscriber<ListUserBase> subscriber);

    void getArea(int areaId, Action1<String> action1);


    void getUserIcon(int iconId, Subscriber<Bitmap> subscriber);
}
