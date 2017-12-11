package base.json;

/**
 * Created by bigdata on 17-11-22.
 */
public class GameRule {

    /**
     * content : {"operatime":"2017-07-19 17:20:01","rolechgype":"1","roleid":"12923556610888","rolelevel":null,"rolename":"郦凝","roletype":"神剑","status":"1"}
     * title : {"exectime":"2017-07-19 17:20:01","gameid":"","gamelevel":"","imei":"8FCB0C49-B05A-4186-8E6B-ACFE35CA289B","ip":"182.134.206.133","lid":"","logclass":"BI_ROLE","model":"iPhone 6 (A1549/A1586)","network":"wifi","os":"10.3.2","roleid":"12923556610888","rolelevel":"1","servarea":"ly3009","servareaname":"朋友玩#542服 长虹贯日","tid":"","userid":"jidong_594fcdbec3957f679e70eeedb8cb52cd","userlevel":"1","usertype":"","ver":"10.3.2"}
     */

    private ContentBean content;
    private TitleBean title;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public TitleBean getTitle() {
        return title;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public static class ContentBean {
        /**
         * operatime : 2017-07-19 17:20:01
         * rolechgype : 1
         * roleid : 12923556610888
         * rolelevel : null
         * rolename : 郦凝
         * roletype : 神剑
         * status : 1
         */

        private String operatime;
        private String rolechgype;
        private String roleid;
        private Object rolelevel;
        private String rolename;
        private String roletype;
        private String status;

        public String getOperatime() {
            return operatime;
        }

        public void setOperatime(String operatime) {
            this.operatime = operatime;
        }

        public String getRolechgype() {
            return rolechgype;
        }

        public void setRolechgype(String rolechgype) {
            this.rolechgype = rolechgype;
        }

        public String getRoleid() {
            return roleid;
        }

        public void setRoleid(String roleid) {
            this.roleid = roleid;
        }

        public Object getRolelevel() {
            return rolelevel;
        }

        public void setRolelevel(Object rolelevel) {
            this.rolelevel = rolelevel;
        }

        public String getRolename() {
            return rolename;
        }

        public void setRolename(String rolename) {
            this.rolename = rolename;
        }

        public String getRoletype() {
            return roletype;
        }

        public void setRoletype(String roletype) {
            this.roletype = roletype;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class TitleBean {
        /**
         * exectime : 2017-07-19 17:20:01
         * gameid :
         * gamelevel :
         * imei : 8FCB0C49-B05A-4186-8E6B-ACFE35CA289B
         * ip : 182.134.206.133
         * lid :
         * logclass : BI_ROLE
         * model : iPhone 6 (A1549/A1586)
         * network : wifi
         * os : 10.3.2
         * roleid : 12923556610888
         * rolelevel : 1
         * servarea : ly3009
         * servareaname : 朋友玩#542服 长虹贯日
         * tid :
         * userid : jidong_594fcdbec3957f679e70eeedb8cb52cd
         * userlevel : 1
         * usertype :
         * ver : 10.3.2
         */

        private String exectime;
        private String gameid;
        private String gamelevel;
        private String imei;
        private String ip;
        private String lid;
        private String logclass;
        private String model;
        private String network;
        private String os;
        private String roleid;
        private String rolelevel;
        private String servarea;
        private String servareaname;
        private String tid;
        private String userid;
        private String userlevel;
        private String usertype;
        private String ver;

        public String getExectime() {
            return exectime;
        }

        public void setExectime(String exectime) {
            this.exectime = exectime;
        }

        public String getGameid() {
            return gameid;
        }

        public void setGameid(String gameid) {
            this.gameid = gameid;
        }

        public String getGamelevel() {
            return gamelevel;
        }

        public void setGamelevel(String gamelevel) {
            this.gamelevel = gamelevel;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getLogclass() {
            return logclass;
        }

        public void setLogclass(String logclass) {
            this.logclass = logclass;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String network) {
            this.network = network;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getRoleid() {
            return roleid;
        }

        public void setRoleid(String roleid) {
            this.roleid = roleid;
        }

        public String getRolelevel() {
            return rolelevel;
        }

        public void setRolelevel(String rolelevel) {
            this.rolelevel = rolelevel;
        }

        public String getServarea() {
            return servarea;
        }

        public void setServarea(String servarea) {
            this.servarea = servarea;
        }

        public String getServareaname() {
            return servareaname;
        }

        public void setServareaname(String servareaname) {
            this.servareaname = servareaname;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUserlevel() {
            return userlevel;
        }

        public void setUserlevel(String userlevel) {
            this.userlevel = userlevel;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }
    }
}
