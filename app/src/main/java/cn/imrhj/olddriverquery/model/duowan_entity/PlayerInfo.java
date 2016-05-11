package cn.imrhj.olddriverquery.model.duowan_entity;

/**
 * Created by rhj on 16/5/11.
 */
public class PlayerInfo {

    /**
     * message : 1
     * portrait : http://img.lolbox.duowan.com/profileIcon/profileIcon654.jpg
     * level : 30
     * zhandouli : 3187
     * good : 被赞 179 次
     */

    private String message;
    private String portrait;
    private String level;
    private String zhandouli;
    private String good;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getZhandouli() {
        return zhandouli;
    }

    public void setZhandouli(String zhandouli) {
        this.zhandouli = zhandouli;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return message + portrait + level + zhandouli + good;
    }
}
