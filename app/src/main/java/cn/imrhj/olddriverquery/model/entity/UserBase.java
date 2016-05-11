package cn.imrhj.olddriverquery.model.entity;

import com.socks.library.KLog;

/**
 * Created by rhj on 16/5/6.
 */
public class UserBase implements Comparable<UserBase> {

    /**
     * area_id : 14
     * qquin : U661578216205866723
     * icon_id : 0
     * name : 你卜认识我
     * level : 26
     * tier : 255
     * queue : 255
     * win_point : 0
     */

    private int area_id;
    private String qquin;
    private int icon_id;
    private String name;
    private int level;
    private int tier;
    private int queue;
    private int win_point;

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getQquin() {
        return qquin;
    }

    public void setQquin(String qquin) {
        this.qquin = qquin;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getWin_point() {
        return win_point;
    }

    public void setWin_point(int win_point) {
        this.win_point = win_point;
    }

    @Override
    public int compareTo(UserBase another) {
        KLog.d(": sort" + this.getArea_id() + this.getName() + " | " + another.getArea_id() + another.getName());
        return  another.getArea_id() - this.getArea_id();
    }
}
