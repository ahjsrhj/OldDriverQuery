package cn.imrhj.olddriverquery.theme;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;

import com.socks.library.KLog;

import cn.imrhj.olddriverquery.App;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.utlis.ColorUiInterface;

/**
 * Created by rhj on 16/5/6.
 */
public class ColorTextInputLayout extends TextInputLayout implements ColorUiInterface{

    public ColorTextInputLayout(Context context) {
        super(context);
    }

    public ColorTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        KLog.d(": ");
        this.setHintTextAppearance(R.style.RedTheme);
        this.setDrawingCacheBackgroundColor(App.themeColor);
    }
}
