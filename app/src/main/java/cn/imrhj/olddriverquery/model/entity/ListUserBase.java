package cn.imrhj.olddriverquery.model.entity;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.socks.library.KLog;

import java.util.Comparator;

/**
 * SearchFragment显示结果的实体类
 * Created by rhj on 16/5/8.
 */
public class ListUserBase {
    private Bitmap bitmap;    //头像
    private String name;
    private String nameAndLevel;    //名称和等级
    private String area;            //大区
    private String tier;            //段位


    private int avaterId;           //头像ID
    private int areaId;             //大区ID
    private String qquin;

    public ListUserBase(String name, int avaterId,int areaId, String qquin, String nameAndLevel, String area, String tier) {
        this.name = name;
        this.avaterId = avaterId;
        this.areaId = areaId;
        this.qquin = qquin;
        this.nameAndLevel = nameAndLevel;
        this.area = area;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQquin() {
        return qquin;
    }

    public void setQquin(String qquin) {
        this.qquin = qquin;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getNameAndLevel() {
        return nameAndLevel;
    }

    public void setNameAndLevel(String nameAndLevel) {
        this.nameAndLevel = nameAndLevel;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getAvaterId() {
        return avaterId;
    }

    public void setAvaterId(int avaterId) {
        this.avaterId = avaterId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}
