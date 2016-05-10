package cn.imrhj.olddriverquery;

import android.app.Application;
import android.content.Context;

import com.socks.library.KLog;

import butterknife.ButterKnife;

/**
 * Created by rhj on 16/5/5.
 */
public class App extends Application {

    //// TODO: 16/5/5 去除静态变量,想办法直接获取颜色
    public static int themeColor = 0;

    public static String token;
    public static final String USERNAME = "olddriverquery";
    public static final String PASSWORD = "yf9dzWwk#6yLo&42";

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.LOG_DEBUG);
        ButterKnife.setDebug(BuildConfig.LOG_DEBUG);
        mContext = getApplicationContext();
    }
}
