package cn.imrhj.olddriverquery.utlis;

/**
 * Created by rhj on 16/5/9.
 */
public class InfoDeal {
    /**
     * 获取用户段位
     * @param tier 段位
     * @param queue 字段位
     * @return
     */
    public static String getTier(int  tier, int queue) {
        String sTier;
        String sQueue;

        switch (tier) {
            case 5:
                sTier = "青铜";
                break;
            case 4:
                sTier = "白银";
                break;
            case 3:
                sTier = "黄金";
                break;
            case 2:
                sTier = "钻石";
                break;
            case 1:
                sTier = "大师";
                break;
            case 0:
                sTier = "王者";
                break;
            default:
                sTier = "无段位";
        }
        switch (queue) {
            case 0:
                sQueue = "I";
                break;
            case 1:
                sQueue = "II";
                break;
            case 2:
                sQueue = "III";
                break;
            case 3:
                sQueue = "IV";
                break;
            case 4:
                sQueue = "V";
                break;
            default:
                sQueue = "";
        }

        return sTier + sQueue;
    }
}
