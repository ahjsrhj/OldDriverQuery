package cn.imrhj.olddriverquery.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.theme.Theme;
import cn.imrhj.olddriverquery.utlis.PreUtils;

/**
 * Activity的基类
 * Created by rhj on 16/5/4.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onPreCreate();
    }

    private void onPreCreate() {
        Theme theme = PreUtils.getCurrentTheme(this);
        switch (theme) {
            case Blue:
                setTheme(R.style.BlueTheme);
                break;
            case Red:
                setTheme(R.style.RedTheme);
                break;
            case Brown:
                setTheme(R.style.BrownTheme);
                break;
            case Green:
                setTheme(R.style.GreenTheme);
                break;
            case Purple:
                setTheme(R.style.PurpleTheme);
                break;
            case Teal:
                setTheme(R.style.TealTheme);
                break;
            case Pink:
                setTheme(R.style.PinkTheme);
                break;
            case DeepPurple:
                setTheme(R.style.DeepPurpleTheme);
                break;
            case Orange:
                setTheme(R.style.OrangeTheme);
                break;
            case Indigo:
                setTheme(R.style.IndigoTheme);
                break;
            case LightGreen:
                setTheme(R.style.LightGreenTheme);
                break;
            case Lime:
                setTheme(R.style.LimeTheme);
                break;
            case DeepOrange:
                setTheme(R.style.DeepOrangeTheme);
                break;
            case Cyan:
                setTheme(R.style.CyanTheme);
                break;
            case BlueGrey:
                setTheme(R.style.BlueGreyTheme);
                break;
        }
    }
}
