package cn.imrhj.olddriverquery.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.adapter.SearchAdapter;
import cn.imrhj.olddriverquery.base.BaseFragment;
import cn.imrhj.olddriverquery.persenter.SearchPersenter;
import cn.imrhj.olddriverquery.view.iface.SearchFragmentInterface;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by rhj on 16/5/6.
 */
public class SearchFragment extends BaseFragment implements View.OnClickListener, SearchFragmentInterface{

    @BindView(R.id.fs_et_username)
    TextInputEditText fsEtUsername;
    @BindView(R.id.fs_btn_search)
    Button fsBtnSearch;
    @BindView(R.id.fs_rv_content)
    RecyclerView fsRvContent;

    private SearchPersenter mPersenter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView() {
        mPersenter = new SearchPersenter(this);
        fsBtnSearch.setOnClickListener(this);
        fsRvContent.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onClick(View v) {
        String username = fsEtUsername.getText().toString();
        if (username.isEmpty()) {
            username = "你卜认识我";
        }
        mPersenter.searchUserBase(username);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(SearchAdapter adapter) {
        AnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
        animationAdapter.setDuration(1300);
        animationAdapter.setInterpolator(new OvershootInterpolator(1f));
        animationAdapter.setFirstOnly(false);

        fsRvContent.setAdapter(animationAdapter);
    }
}
