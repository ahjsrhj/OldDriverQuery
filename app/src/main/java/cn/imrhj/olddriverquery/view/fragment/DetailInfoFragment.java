package cn.imrhj.olddriverquery.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.adapter.DetailInfoAdapter;
import cn.imrhj.olddriverquery.adapter.SearchAdapter;
import cn.imrhj.olddriverquery.base.BaseFragment;
import cn.imrhj.olddriverquery.model.duowan_entity.DetailUserInfo;
import cn.imrhj.olddriverquery.model.duowan_entity.Hero;
import cn.imrhj.olddriverquery.model.entity.ListHeroBean;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by rhj on 16/5/11.
 */
public class DetailInfoFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.iv_detail_fragment_avatar)
    RoundedImageView ivDetailFragmentAvatar;
    @BindView(R.id.tv_detail_fragment_level)
    TextView tvDetailFragmentLevel;
    @BindView(R.id.tv_detail_fragment_zhandouli)
    TextView tvDetailFragmentZhandouli;
    @BindView(R.id.iv_detail_fragment_star)
    ImageView ivDetailFragmentStar;
    @BindView(R.id.tv_detail_fragment_good)
    TextView tvDetailFragmentGood;
    @BindView(R.id.rv_fragment_detail)
    RecyclerView rvFragmentDetail;
    @BindView(R.id.tv_detail_fragment_record)
    TextView tvDetailFragmentRecord;

    private DetailUserInfo mDetailUserInfo;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_detail_info;
    }

    @Override
    public void initView() {
        rvFragmentDetail.setLayoutManager(new LinearLayoutManager(getActivity()));
        ivDetailFragmentStar.setOnClickListener(this);

        if (mDetailUserInfo != null) {
            tvDetailFragmentLevel.setText("Lv " + mDetailUserInfo.getPlayerInfo().getLevel());
            tvDetailFragmentGood.setText(mDetailUserInfo.getPlayerInfo().getGood());
            tvDetailFragmentZhandouli.setText(mDetailUserInfo.getPlayerInfo().getZhandouli());
            tvDetailFragmentRecord.setText(mDetailUserInfo.getRecord().getRecord());

            ImageLoader.getInstance().loadImage(mDetailUserInfo.getPlayerInfo().getPortrait(),
                    new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                            ivDetailFragmentAvatar.setImageBitmap(loadedImage);
                        }
                    });

            List<ListHeroBean> data = new ArrayList<>();
            for (Hero.HerostrBean herostrBean : mDetailUserInfo.getHero().getHerostr()) {
                data.add(new ListHeroBean(herostrBean.getAttr().getSrc(), herostrBean.getAttr().getTitle()));
            }

            DetailInfoAdapter adapter = new DetailInfoAdapter(data, getActivity());
            AnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
            animationAdapter.setDuration(1300);
            animationAdapter.setInterpolator(new OvershootInterpolator(1f));
            animationAdapter.setFirstOnly(false);
            rvFragmentDetail.setAdapter(animationAdapter);

        }


    }

    public void setDetailUserInfo(DetailUserInfo userInfo) {
        this.mDetailUserInfo = userInfo;
    }

    @Override
    public void onClick(View v) {
        v.setBackground(getResources().getDrawable(R.drawable.ic_star));
    }
}
