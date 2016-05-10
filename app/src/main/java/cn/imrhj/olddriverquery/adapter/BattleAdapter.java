package cn.imrhj.olddriverquery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.imrhj.olddriverquery.R;

/**
 * Created by rhj on 16/5/6.
 */
public class BattleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> mData = new ArrayList<>();

    public BattleAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        for (int i = 0; i < 20; i++) {
            mData.add("我是数据 " + i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.header_view_battle_fragment, parent, false));
        } else {
            return new NormalViewHolder(mLayoutInflater.inflate(R.layout.card_view_battle_fragment, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalViewHolder) {
            NormalViewHolder h = (NormalViewHolder) holder;
            h.tvBtType.setText(mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bt_avatar)
        ImageView ivBtAvatar;
        @BindView(R.id.tv_bt_type)
        TextView tvBtType;

        public NormalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.header_avatar)
        ImageView headerAvatar;
        @BindView(R.id.header_username)
        TextView headerUsername;
        @BindView(R.id.header_user_level)
        TextView headerUserLevel;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
