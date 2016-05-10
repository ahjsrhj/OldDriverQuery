package cn.imrhj.olddriverquery.theme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.socks.library.KLog;

import cn.imrhj.olddriverquery.App;
import cn.imrhj.olddriverquery.utlis.ColorUiInterface;

/**
 * Created by rhj on 16/5/6.
 */
public class ColorEditText extends EditText implements ColorUiInterface{

    int[][] states = new int[][] {
            new int[] {-android.R.attr.state_active},
            new int[] { android.R.attr.state_active},

    };

    public ColorEditText(Context context) {
        super(context);
    }

    public ColorEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        KLog.d(": setTheme" + App.themeColor);
        this.setHintTextColor(App.themeColor);
        this.setDrawingCacheBackgroundColor(App.themeColor);
        int[] colors = new int[] {
                App.themeColor,
                App.themeColor,
        };

        this.setHintTextColor(new ColorStateList(states, colors));
    }
}
