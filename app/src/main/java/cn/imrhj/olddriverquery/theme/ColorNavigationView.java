package cn.imrhj.olddriverquery.theme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import cn.imrhj.olddriverquery.App;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.utlis.ColorUiInterface;

/**
 * 重写Nagivation以实现动态换肤
 * Created by rhj on 16/5/5.
 */
public class ColorNavigationView extends NavigationView implements ColorUiInterface{

    int[][] states = new int[][] {
            new int[] {-android.R.attr.state_checked},  // unchecked
            new int[] { android.R.attr.state_checked},  // checked
    };



    public ColorNavigationView(Context context) {
        super(context);
    }

    public ColorNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        int[] colors = new int[] {
                ContextCompat.getColor(getContext(), R.color.colorPrimaryText),
                App.themeColor
        };

        ColorStateList list = new ColorStateList(states, colors);
        this.setItemIconTintList(list);
        this.setItemTextColor(list);
    }
}
