package cn.imrhj.olddriverquery.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.model.entity.ListUserBase;
import cn.imrhj.olddriverquery.network.HttpMethods;
import cn.imrhj.olddriverquery.view.iface.ItemClickListener;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * SearchFragment的显示搜索结果的Adapter
 * Created by rhj on 16/5/6.
 */
public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<ListUserBase> mData;
    private ItemClickListener mListener;



    public SearchAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchListViewHolder(
                mLayoutInflater.inflate(R.layout.card_view_search_fragment, parent, false),
                mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final SearchListViewHolder h = (SearchListViewHolder) holder;
        final ListUserBase userBase = mData.get(position);
        h.tvSeArea.setText(userBase.getArea());
        h.tvSeNameLevel.setText(userBase.getNameAndLevel());
        h.tvSeTier.setText(userBase.getTier());
        if (userBase.getBitmap() != null) {
            h.ivSeAvatar.setImageBitmap(userBase.getBitmap());
        } else {
            if (userBase.getAreaId() > 28) {
                KLog.e(": " + userBase.getNameAndLevel());
            }
            HttpMethods.getInstance().getUserIcon(userBase.getAvaterId(), new Subscriber<Bitmap>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    KLog.e(": 位置:" + position + ", 编号:" + userBase.getAvaterId() + e.getMessage());
                }

                @Override
                public void onNext(Bitmap bitmap) {
                    h.ivSeAvatar.setImageBitmap(bitmap);
                    userBase.setBitmap(bitmap);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void setOnItemClickListener(ItemClickListener listener) {
        mListener = listener;
    }


    public void setData(List<ListUserBase> listUserBases) {
        mData = listUserBases;
        notifyDataSetChanged();
    }

    public void cleanData() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void add(ListUserBase listUserBase) {
        mData.add(0, listUserBase);
        notifyItemInserted(0);
    }

    public ListUserBase getUser(int position) {
        return mData.get(position);
    }

    class SearchListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemClickListener mListener;

        @BindView(R.id.iv_se_avatar)
        RoundedImageView ivSeAvatar;
        @BindView(R.id.tv_se_name_level)
        TextView tvSeNameLevel;
        @BindView(R.id.tv_se_area)
        TextView tvSeArea;
        @BindView(R.id.tv_se_tier)
        TextView tvSeTier;

        SearchListViewHolder(View view, ItemClickListener listener) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
            mListener = listener;
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getLayoutPosition());
            }
        }
    }
}
