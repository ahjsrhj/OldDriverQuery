package cn.imrhj.olddriverquery.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.roger.gifloadinglibrary.GifLoadingView;
import com.socks.library.KLog;

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
public class SearchFragment extends BaseFragment implements SearchFragmentInterface, TextView.OnEditorActionListener {

    @BindView(R.id.fs_et_username)
    TextInputEditText fsEtUsername;
    @BindView(R.id.fs_rv_content)
    RecyclerView fsRvContent;

    private SearchPersenter mPersenter;
    private GifLoadingView mGifLoadingView;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView() {
        mPersenter = new SearchPersenter(this);
        fsRvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        mGifLoadingView = new GifLoadingView();
        mGifLoadingView.setImageResource(R.drawable.loading3);
        fsEtUsername.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(
                            getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
            String username = fsEtUsername.getText().toString();
            if (username.isEmpty()) {
                username = "你认识我";
            }
            mPersenter.searchUserBase(username);
            return true;
        }
        return false;
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

    @Override
    public void showLoading() {
        if (!mGifLoadingView.isHidden()) {
            mGifLoadingView.show(getFragmentManager(), "");
        }
    }

    @Override
    public void hideLoading() {
        if (!mGifLoadingView.isVisible()) {
            mGifLoadingView.dismiss();
        }
    }

}
