package cn.imrhj.olddriverquery.view.activity;

import android.animation.Animator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.oneapm.agent.android.OneApmAgent;

import cn.imrhj.olddriverquery.App;
import cn.imrhj.olddriverquery.R;
import cn.imrhj.olddriverquery.base.BaseActivity;
import cn.imrhj.olddriverquery.base.BaseFragment;
import cn.imrhj.olddriverquery.persenter.MainPersenter;
import cn.imrhj.olddriverquery.theme.Theme;
import cn.imrhj.olddriverquery.utlis.ColorUiUtil;
import cn.imrhj.olddriverquery.utlis.PreUtils;
import cn.imrhj.olddriverquery.utlis.ThemeUtils;
import cn.imrhj.olddriverquery.view.fragment.BattleFragment;
import cn.imrhj.olddriverquery.view.fragment.SearchFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ColorChooserDialog.ColorCallback {



    private MainPersenter mPersenter;
    private FragmentManager mFragmentManager;

    private BaseFragment mBattleFragment = new BattleFragment();
    private BaseFragment mSearchFragment = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mPersenter = new MainPersenter();


        OneApmAgent.init(this.getApplicationContext()).setToken("CC9856C7B53A557599D35DC0890643E990").start();
    }

    /**
     * 初始化View
     */
    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View statusBar = findViewById(R.id.status_bar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            statusBar.setVisibility(View.VISIBLE);
        } else {
            statusBar.setVisibility(View.GONE);
        }

        changeFragment(mSearchFragment);
    }

    private void changeFragment(BaseFragment fragment) {
        mFragmentManager = getFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.content_fragment, fragment);
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_recently_battle) {
            changeFragment(mBattleFragment);
            setTitle(getResources().getString(R.string.recently_battle));

        } else if (id == R.id.nav_persion_info) {
            setTitle(getResources().getString(R.string.persion_info));

        } else if (id == R.id.nav_search_battle) {
            changeFragment(mSearchFragment);
            setTitle(getResources().getString(R.string.search_battle));

        } else if (id == R.id.nav_change_binding) {
            setTitle(getResources().getString(R.string.change_binding));

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            new ColorChooserDialog.Builder(this, R.string.theme)
                    .customColors(R.array.colors, null)
                    .doneButton(R.string.done)
                    .cancelButton(R.string.cancel)
                    .allowUserColorInput(false)
                    .allowUserColorInputAlpha(false)
                    .show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
        if (selectedColor == ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
            return;
        App.themeColor = selectedColor;

        if (selectedColor == ContextCompat.getColor(this, R.color.colorBluePrimary)) {
            setTheme(R.style.BlueTheme);
            PreUtils.setCurrentTheme(this, Theme.Blue);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorRedPrimary)) {
            setTheme(R.style.RedTheme);
            PreUtils.setCurrentTheme(this, Theme.Red);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorBrownPrimary)) {
            setTheme(R.style.BrownTheme);
            PreUtils.setCurrentTheme(this, Theme.Brown);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorGreenPrimary)) {
            setTheme(R.style.GreenTheme);
            PreUtils.setCurrentTheme(this, Theme.Green);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorPurplePrimary)) {
            setTheme(R.style.PurpleTheme);
            PreUtils.setCurrentTheme(this, Theme.Purple);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorTealPrimary)) {
            setTheme(R.style.TealTheme);
            PreUtils.setCurrentTheme(this, Theme.Teal);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorPinkPrimary)) {
            setTheme(R.style.PinkTheme);
            PreUtils.setCurrentTheme(this, Theme.Pink);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorDeepPurplePrimary)) {
            setTheme(R.style.DeepPurpleTheme);
            PreUtils.setCurrentTheme(this, Theme.DeepPurple);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorOrangePrimary)) {
            setTheme(R.style.OrangeTheme);
            PreUtils.setCurrentTheme(this, Theme.Orange);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorIndigoPrimary)) {
            setTheme(R.style.IndigoTheme);
            PreUtils.setCurrentTheme(this, Theme.Indigo);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorLightGreenPrimary)) {
            setTheme(R.style.LightGreenTheme);
            PreUtils.setCurrentTheme(this, Theme.LightGreen);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorDeepOrangePrimary)) {
            setTheme(R.style.DeepOrangeTheme);
            PreUtils.setCurrentTheme(this, Theme.DeepOrange);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorLimePrimary)) {
            setTheme(R.style.LimeTheme);
            PreUtils.setCurrentTheme(this, Theme.Lime);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorBlueGreyPrimary)) {
            setTheme(R.style.BlueGreyTheme);
            PreUtils.setCurrentTheme(this, Theme.BlueGrey);

        } else if (selectedColor == ContextCompat.getColor(this, R.color.colorCyanPrimary)) {
            setTheme(R.style.CyanTheme);
            PreUtils.setCurrentTheme(this, Theme.Cyan);

        }


        final View rootView = getWindow().getDecorView();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);

        final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        if (null != localBitmap && rootView instanceof ViewGroup) {
            final View tmpView = new View(getApplicationContext());
            tmpView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) rootView).addView(tmpView, params);
            tmpView.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    ColorUiUtil.changeTheme(rootView, getTheme());
                    System.gc();
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((ViewGroup) rootView).removeView(tmpView);
                    localBitmap.recycle();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).start();
        }

    }
}
