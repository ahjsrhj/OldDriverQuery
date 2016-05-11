package cn.imrhj.olddriverquery.model.duowan_entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rhj on 16/5/11.
 */
public class Hero {

    /**
     * message : 1
     * herostr : [{"nodetype":1,"tag":"img","attr":{"src":"http://img.lolbox.duowan.com/champions/Lulu_40x40.jpg","alt":"仙灵女巫 11 次 点击查看相关比赛","title":"仙灵女巫 11次"},"children":null,"nodes":null,"parent":null,"_":{"0":192,"2":[0,0,0],"3":[["                             ","",""],["                             ","",""],["                             ","",""]],"7":""},"tag_start":5479},{"nodetype":1,"tag":"img","attr":{"src":"http://img.lolbox.duowan.com/champions/Skarner_40x40.jpg","alt":"水晶先锋 7 次 点击查看相关比赛","title":"水晶先锋 7次"},"children":null,"nodes":null,"parent":null,"_":{"0":199,"2":[0,0,0],"3":[["                             ","",""],["                             ","",""],["                             ","",""]],"7":""},"tag_start":5992},{"nodetype":1,"tag":"img","attr":{"src":"http://img.lolbox.duowan.com/champions/Velkoz_40x40.jpg","alt":"虚空之眼 7 次 点击查看相关比赛","title":"虚空之眼 7次"},"children":null,"nodes":null,"parent":null,"_":{"0":206,"2":[0,0,0],"3":[["                             ","",""],["                             ","",""],["                             ","",""]],"7":""},"tag_start":6504},{"nodetype":1,"tag":"img","attr":{"src":"http://img.lolbox.duowan.com/champions/Fizz_40x40.jpg","alt":"潮汐海灵 5 次 点击查看相关比赛","title":"潮汐海灵 5次"},"children":null,"nodes":null,"parent":null,"_":{"0":213,"2":[0,0,0],"3":[["                             ","",""],["                             ","",""],["                             ","",""]],"7":""},"tag_start":7011},{"nodetype":1,"tag":"img","attr":{"src":"http://img.lolbox.duowan.com/champions/Teemo_40x40.jpg","alt":"迅捷斥候 3 次 点击查看相关比赛","title":"迅捷斥候 3次"},"children":null,"nodes":null,"parent":null,"_":{"0":220,"2":[0,0,0],"3":[["                             ","",""],["                             ","",""],["                             ","",""]],"7":""},"tag_start":7518}]
     */

    private String message;
    /**
     * nodetype : 1
     * tag : img
     * attr : {"src":"http://img.lolbox.duowan.com/champions/Lulu_40x40.jpg","alt":"仙灵女巫 11 次 点击查看相关比赛","title":"仙灵女巫 11次"}
     * children : null
     * nodes : null
     * parent : null
     * _ : {"0":192,"2":[0,0,0],"3":[["                             ","",""],["                             ","",""],["                             ","",""]],"7":""}
     * tag_start : 5479
     */

    private List<HerostrBean> herostr;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HerostrBean> getHerostr() {
        return herostr;
    }

    public void setHerostr(List<HerostrBean> herostr) {
        this.herostr = herostr;
    }

    public static class HerostrBean {
        private int nodetype;
        private String tag;
        /**
         * src : http://img.lolbox.duowan.com/champions/Lulu_40x40.jpg
         * alt : 仙灵女巫 11 次 点击查看相关比赛
         * title : 仙灵女巫 11次
         */

        private AttrBean attr;
        private Object children;
        private Object nodes;
        private Object parent;
        /**
         * 0 : 192
         * 2 : [0,0,0]
         * 3 : [["                             ","",""],["                             ","",""],["                             ","",""]]
         * 7 :
         */

        @SerializedName("_")
        private Bean value;
        private int tag_start;

        public int getNodetype() {
            return nodetype;
        }

        public void setNodetype(int nodetype) {
            this.nodetype = nodetype;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public AttrBean getAttr() {
            return attr;
        }

        public void setAttr(AttrBean attr) {
            this.attr = attr;
        }

        public Object getChildren() {
            return children;
        }

        public void setChildren(Object children) {
            this.children = children;
        }

        public Object getNodes() {
            return nodes;
        }

        public void setNodes(Object nodes) {
            this.nodes = nodes;
        }

        public Object getParent() {
            return parent;
        }

        public void setParent(Object parent) {
            this.parent = parent;
        }

        public Bean getValue() {
            return value;
        }

        public void setValue(Bean value) {
            this.value = value;
        }

        public int getTag_start() {
            return tag_start;
        }

        public void setTag_start(int tag_start) {
            this.tag_start = tag_start;
        }

        public static class AttrBean {
            private String src;
            private String alt;
            private String title;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class Bean {
            @SerializedName("0")
            private int value0;
            @SerializedName("7")
            private String value7;
            @SerializedName("2")
            private List<Integer> value2;
            @SerializedName("3")
            private List<List<String>> value3;

            public int getValue0() {
                return value0;
            }

            public void setValue0(int value0) {
                this.value0 = value0;
            }

            public String getValue7() {
                return value7;
            }

            public void setValue7(String value7) {
                this.value7 = value7;
            }

            public List<Integer> getValue2() {
                return value2;
            }

            public void setValue2(List<Integer> value2) {
                this.value2 = value2;
            }

            public List<List<String>> getValue3() {
                return value3;
            }

            public void setValue3(List<List<String>> value3) {
                this.value3 = value3;
            }
        }
    }
}
