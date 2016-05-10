package cn.imrhj.olddriverquery.theme;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import cn.imrhj.olddriverquery.utlis.ColorUiInterface;
import cn.imrhj.olddriverquery.utlis.ViewAttributeUtil;

/**
 * Created by rhj on 16/5/2.
 */
public class ColorToolbar extends Toolbar implements ColorUiInterface{

    private int attr_background = -1;

    public ColorToolbar(Context context) {
        super(context);
    }

    public ColorToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if (attr_background != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_background);
        }
    }
}
