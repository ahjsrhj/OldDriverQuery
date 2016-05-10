package cn.imrhj.olddriverquery.utlis;

import android.content.res.Resources;
import android.view.View;

/**
 * 换肤的接口
 * Created by rhj on 16/5/2.
 */
public interface ColorUiInterface {

    View getView();

    void setTheme(Resources.Theme themeId);

}
