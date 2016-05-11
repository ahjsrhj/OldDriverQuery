package cn.imrhj.olddriverquery.view.iface;

import cn.imrhj.olddriverquery.adapter.SearchAdapter;

/**
 * Created by rhj on 16/5/6.
 */
public interface SearchFragmentInterface extends BaseInterface{
    void setAdapter(SearchAdapter adapter);

    void showLoading();

    void hideLoading();
}
