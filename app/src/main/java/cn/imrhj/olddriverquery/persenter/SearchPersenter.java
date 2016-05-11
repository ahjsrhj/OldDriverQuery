package cn.imrhj.olddriverquery.persenter;


import android.content.Context;
import android.view.View;

import com.socks.library.KLog;


import java.util.List;

import cn.imrhj.olddriverquery.App;
import cn.imrhj.olddriverquery.adapter.SearchAdapter;
import cn.imrhj.olddriverquery.model.duowan_entity.DetailUserInfo;
import cn.imrhj.olddriverquery.model.entity.ListUserBase;
import cn.imrhj.olddriverquery.model.entity.UserBase;
import cn.imrhj.olddriverquery.model.iface.GameServiceInterface;
import cn.imrhj.olddriverquery.network.HttpMethods;
import cn.imrhj.olddriverquery.view.iface.ItemClickListener;
import cn.imrhj.olddriverquery.view.iface.SearchFragmentInterface;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * SearchFragment 的
 * Created by rhj on 16/5/6.
 */
public class SearchPersenter implements ItemClickListener {
    private final GameServiceInterface mGameService;
    private final SearchFragmentInterface mFragment;
    private final SearchAdapter mAdapter;

    public SearchPersenter(SearchFragmentInterface fragment) {
        this.mGameService = HttpMethods.getInstance();
        this.mFragment = fragment;
        this.mAdapter = new SearchAdapter(App.mContext);
        this.mAdapter.setOnItemClickListener(this);

        mFragment.setAdapter(mAdapter);
    }

    public void searchUserBase(String username) {
        KLog.d(": 开始查找");
        mAdapter.cleanData();
        mFragment.showLoading();

        mGameService.getUserBase(username, new Subscriber<ListUserBase>() {
            @Override
            public void onCompleted() {

                mFragment.hideLoading();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ListUserBase listUserBase) {
                mAdapter.add(listUserBase);
            }
        });
    }

    private void showMessage(String msg) {
        mFragment.showMessage(msg);
    }

    @Override
    public void onItemClick(View view, int position) {
        KLog.d(": " + position);
        ListUserBase userBase = mAdapter.getUser(position);
        mGameService.getDetailUserInfo(userBase.getArea(), userBase.getName(), new Action1<DetailUserInfo>() {
            @Override
            public void call(DetailUserInfo detailUserInfo) {
                KLog.d(": " + detailUserInfo.toString());
            }
        });


    }
}
