package cn.imrhj.olddriverquery.model.entity;

import java.util.List;

/**
 * Created by rhj on 16/5/6.
 */
public class UserBaseExten {

    /**
     * data : [{"area_id":14,"qquin":"U661578216205866723","icon_id":0,"name":"你卜认识我","level":26,"tier":255,"queue":255,"win_point":0},{"area_id":22,"qquin":"U14650767493973371205","icon_id":11,"name":"你卜认识我","level":15,"tier":255,"queue":255,"win_point":0},{"area_id":6,"qquin":"U14650767493973371205","icon_id":5,"name":"你卜认识我","level":2,"tier":255,"queue":255,"win_point":0},{"area_id":5,"qquin":"U14650767493973371205","icon_id":2,"name":"你卜认识我","level":1,"tier":255,"queue":255,"win_point":0},{"area_id":1,"qquin":"U14650767493973371205","icon_id":5,"name":"你卜认识我","level":2,"tier":255,"queue":255,"win_point":0},{"area_id":12,"qquin":"U14650767493973371205","icon_id":20,"name":"你卜认识我","level":6,"tier":255,"queue":255,"win_point":0},{"area_id":9,"qquin":"U14650767493973371205","icon_id":19,"name":"你卜认识我","level":4,"tier":255,"queue":255,"win_point":0},{"area_id":3,"qquin":"U14650767493973371205","icon_id":12,"name":"你卜认识我","level":7,"tier":255,"queue":255,"win_point":0},{"area_id":8,"qquin":"U14650767493973371205","icon_id":19,"name":"你卜认识我","level":9,"tier":255,"queue":255,"win_point":0},{"area_id":11,"qquin":"U661578216205866723","icon_id":31,"name":"你卜认识我","level":4,"tier":255,"queue":255,"win_point":0},{"area_id":25,"qquin":"U661578216205866723","icon_id":548,"name":"你卜认识我","level":17,"tier":255,"queue":255,"win_point":0},{"area_id":13,"qquin":"U15533730202975066132","icon_id":2,"name":"你卜认识我","level":2,"tier":255,"queue":255,"win_point":0},{"area_id":10,"qquin":"U4497571728490627109","icon_id":13,"name":"你卜认识我","level":30,"tier":255,"queue":255,"win_point":0}]
     * retCode : 0
     * msg :
     * ukey : U9677745137772290168
     */

    private int retCode;
    private String msg;
    private String ukey;
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

    private List<UserBase> data;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public List<UserBase> getData() {
        return data;
    }

    public void setData(List<UserBase> data) {
        this.data = data;
    }


}
