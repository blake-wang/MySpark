package base.JsonParseDemo.GsonDemo;

import java.util.List;

/**
 * Created by bigdata on 18-1-20.
 */
public class UnKnowBean {

    /**
     * addresses : [{"format":"us","type":"work","value":"1234 Main StnSpringfield, TX 78080-1216"},{"format":"us","type":"home","value":"5678 Main StnSpringfield, TX 78080-1316"}]
     * emailaddrs : [{"type":"work","value":"kelly@seankelly.biz"},{"pref":1,"type":"home","value":"kelly@seankelly.tv"}]
     * fullname : Sean Kelly
     * org : SK Consulting
     * telephones : [{"pref":1,"type":"work","value":"+1 214 555 1212"},{"type":"fax","value":"+1 214 555 1213"},{"type":"mobile","value":"+1 214 555 1214"}]
     * urls : [{"type":"work","value":"http://seankelly.biz/"},{"type":"home","value":"http://seankelly.tv/"}]
     */

    private String fullname;
    private String org;
    private List<AddressesBean> addresses;
    private List<EmailaddrsBean> emailaddrs;
    private List<TelephonesBean> telephones;
    private List<UrlsBean> urls;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public List<AddressesBean> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesBean> addresses) {
        this.addresses = addresses;
    }

    public List<EmailaddrsBean> getEmailaddrs() {
        return emailaddrs;
    }

    public void setEmailaddrs(List<EmailaddrsBean> emailaddrs) {
        this.emailaddrs = emailaddrs;
    }

    public List<TelephonesBean> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephonesBean> telephones) {
        this.telephones = telephones;
    }

    public List<UrlsBean> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlsBean> urls) {
        this.urls = urls;
    }

    public static class AddressesBean {
        /**
         * format : us
         * type : work
         * value : 1234 Main StnSpringfield, TX 78080-1216
         */

        private String format;
        private String type;
        private String value;

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class EmailaddrsBean {
        /**
         * type : work
         * value : kelly@seankelly.biz
         * pref : 1
         */

        private String type;
        private String value;
        private int pref;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getPref() {
            return pref;
        }

        public void setPref(int pref) {
            this.pref = pref;
        }
    }

    public static class TelephonesBean {
        /**
         * pref : 1
         * type : work
         * value : +1 214 555 1212
         */

        private int pref;
        private String type;
        private String value;

        public int getPref() {
            return pref;
        }

        public void setPref(int pref) {
            this.pref = pref;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class UrlsBean {
        /**
         * type : work
         * value : http://seankelly.biz/
         */

        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
