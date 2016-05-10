package cn.imrhj.olddriverquery.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.adapter.BattleAdapter;
import cn.imrhj.olddriverquery.base.BaseFragment;

/**
 * 战斗数据界面
 * Created by rhj on 16/5/4.
 */
public class BattleFragment extends BaseFragment {


    @BindView(R.id.rv_fragment_battle)
    RecyclerView rvFragmentBattle;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_battle;
    }

    @Override
    public void initView() {
        rvFragmentBattle.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFragmentBattle.setAdapter(new BattleAdapter(getActivity()));

    }

}
