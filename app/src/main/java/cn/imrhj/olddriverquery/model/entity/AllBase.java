package cn.imrhj.olddriverquery.model.entity;

/**
 * Created by rhj on 16/5/10.
 */
public class AllBase<T> {
    private int retCode;
    private String msg;
    private String ukey;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
