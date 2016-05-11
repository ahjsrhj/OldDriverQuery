package cn.imrhj.olddriverquery.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.model.entity.ListHeroBean;

/**
 * Created by rhj on 16/5/11.
 */
public class DetailInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<ListHeroBean> mData;

    public DetailInfoAdapter(List<ListHeroBean> mData, Context context) {
        this.mData = mData;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailInfoViewHolder(
                mLayoutInflater.inflate(R.layout.card_view_detail_info_fragment, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final DetailInfoViewHolder h = (DetailInfoViewHolder) holder;
        final ListHeroBean heroBean = mData.get(position);
        h.tvCardViewDetailInfoTitle.setText(heroBean.getTitle());
        if (heroBean.getHeroIcon() == null) {
            ImageLoader.getInstance().loadImage(heroBean.getSrc(), new SimpleImageLoadingListener() {
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    h.ivCardViewDetailInfoChampionIcon.setImageBitmap(loadedImage);
                    heroBean.setHeroIcon(loadedImage);
                }
            });
        } else {
            h.ivCardViewDetailInfoChampionIcon.setImageBitmap(heroBean.getHeroIcon());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class DetailInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_card_view_detail_info_champion_icon)
        RoundedImageView ivCardViewDetailInfoChampionIcon;
        @BindView(R.id.tv_card_view_detail_info_title)
        TextView tvCardViewDetailInfoTitle;

        public DetailInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
