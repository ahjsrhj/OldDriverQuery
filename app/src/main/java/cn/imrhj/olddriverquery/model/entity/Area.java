package cn.imrhj.olddriverquery.model.entity;

/**
 * Created by rhj on 16/5/8.
 */
public class Area {

    /**
     * id : 1
     * strid : HN1
     * isp : 电信一
     * name : 艾欧尼亚
     * idc : 东莞东城
     * tcls : 257
     * ob : 1
     */

    private int id;
    private String strid;
    private String isp;
    private String name;
    private String idc;
    private String tcls;
    private String ob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrid() {
        return strid;
    }

    public void setStrid(String strid) {
        this.strid = strid;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public String getTcls() {
        return tcls;
    }

    public void setTcls(String tcls) {
        this.tcls = tcls;
    }

    public String getOb() {
        return ob;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }
}
