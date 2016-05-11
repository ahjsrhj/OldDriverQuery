package cn.imrhj.olddriverquery.model.entity;

import android.graphics.Bitmap;

/**
 * Created by rhj on 16/5/11.
 */
public class ListHeroBean {
    private String src;
    private String title;
    private Bitmap heroIcon;

    public ListHeroBean(String src, String title) {
        this.src = src;
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getHeroIcon() {
        return heroIcon;
    }

    public void setHeroIcon(Bitmap heroIcon) {
        this.heroIcon = heroIcon;
    }
}
