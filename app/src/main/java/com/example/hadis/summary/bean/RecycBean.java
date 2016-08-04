package com.example.hadis.summary.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author hadis on 16.4.13.
 */
public class RecycBean implements Serializable {

    /**
     * status : 1
     * message : ok
     * data : {"count":"27","data2":[{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/27","id":"27","is_top":"1","is_public":"1","name":"【之间名医说】适量饮酒是否对肝脏有影响","vmemo":"@","vsource":"之间医疗","abstract2":"适量饮酒是否对肝脏有影响","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=221696254942df5b9abe9e2d6054135e","keys":"谭向龙,酒精肝","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/26","id":"26","is_top":"0","is_public":"1","name":"【之间名医说】患有胆道疾病可以吃肉吗","vmemo":"@","vsource":"之间医疗","abstract2":"患有胆道疾病可以吃肉吗","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=b18bd36d6394d88669ac7476e36ad77c","keys":"谭向龙,胆结石,胆囊炎","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/25","id":"25","is_top":"0","is_public":"1","name":"【之间名医说】关于肝囊肿治疗的情况分类","vmemo":"@","vsource":"之间医疗","abstract2":"关于肝囊肿治疗的情况分类","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=26e0bd194d409b550e7ea2c892f7128e","keys":"谭向龙,肝囊肿,微创手术","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/24","id":"24","is_top":"0","is_public":"1","name":"【之间名医说】肝脏转氨酶指数升高的具体原因","vmemo":"@","vsource":"之间医疗","abstract2":"肝脏转氨酶指数升高的具体原因","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=40b71c61ff9a2cfa3e2932a35579a7f8","keys":"谭向龙,转氨酶,食品安全","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/23","id":"23","is_top":"1","is_public":"1","name":"【之间名医说】乔布斯并非死于胰腺癌","vmemo":"@","vsource":"之间医疗","abstract2":"乔布斯并非死于胰腺癌","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=0375e9cec51d1519b548b55f9a9c0146","keys":"谭向龙,胰腺内分泌肿瘤,胰腺癌,乔布斯","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/22","id":"22","is_top":"1","is_public":"1","name":"【之间名医说】肝癌的成因和预防","vmemo":"@","vsource":"之间医疗","abstract2":"肝癌的成因和预防","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=0c7922a0efb139e765ae207a98d5a92c","keys":"谭向龙,肝癌,肝炎,肝癌防治","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/21","id":"21","is_top":"0","is_public":"1","name":"【之间名医说】积极预防腹部手术后遗症","vmemo":"@","vsource":"之间医疗","abstract2":"积极预防腹部手术后遗症","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=e9610ab7b042601af605beee9b6df5e2","keys":"谭向龙,腹部手术,肠粘连,肠梗阻","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/20","id":"20","is_top":"0","is_public":"1","name":"【之间名医说】胆固醇结晶与胆囊息肉的诊断与治疗","vmemo":"@","vsource":"之间医疗","abstract2":"胆固醇结晶与胆囊息肉的诊断与治疗","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=9077cebb5213063169646ec2ad48a702","keys":"谭向龙,胆囊息肉,胆固醇结晶,胆囊","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/19","id":"19","is_top":"0","is_public":"1","name":"【之间名医说】什么情况下不适合作保胆取石手术","vmemo":"@","vsource":"之间医疗","abstract2":"什么情况下不适合作保胆取石手术","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=e2b6146e3ae04aca594166f52d27455a","keys":"谭向龙,胆结石,保胆取石","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/18","id":"18","is_top":"0","is_public":"1","name":"【之间名医说】不良饮食结构与胰腺疾病的关系","vmemo":"@","vsource":"之间医疗","abstract2":"不良饮食结构与胰腺疾病的关系","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=af7ed53dc49e60a3534c496f7fad7c92","keys":"谭向龙,胰腺癌,饮食防癌","vprice":"0.00"}]}
     * errorcode : 0
     */

    private int status;
    private String message;
    /**
     * count : 27
     * data2 : [{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/27","id":"27","is_top":"1","is_public":"1","name":"【之间名医说】适量饮酒是否对肝脏有影响","vmemo":"@","vsource":"之间医疗","abstract2":"适量饮酒是否对肝脏有影响","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=221696254942df5b9abe9e2d6054135e","keys":"谭向龙,酒精肝","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/26","id":"26","is_top":"0","is_public":"1","name":"【之间名医说】患有胆道疾病可以吃肉吗","vmemo":"@","vsource":"之间医疗","abstract2":"患有胆道疾病可以吃肉吗","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=b18bd36d6394d88669ac7476e36ad77c","keys":"谭向龙,胆结石,胆囊炎","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/25","id":"25","is_top":"0","is_public":"1","name":"【之间名医说】关于肝囊肿治疗的情况分类","vmemo":"@","vsource":"之间医疗","abstract2":"关于肝囊肿治疗的情况分类","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=26e0bd194d409b550e7ea2c892f7128e","keys":"谭向龙,肝囊肿,微创手术","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/24","id":"24","is_top":"0","is_public":"1","name":"【之间名医说】肝脏转氨酶指数升高的具体原因","vmemo":"@","vsource":"之间医疗","abstract2":"肝脏转氨酶指数升高的具体原因","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=40b71c61ff9a2cfa3e2932a35579a7f8","keys":"谭向龙,转氨酶,食品安全","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/23","id":"23","is_top":"1","is_public":"1","name":"【之间名医说】乔布斯并非死于胰腺癌","vmemo":"@","vsource":"之间医疗","abstract2":"乔布斯并非死于胰腺癌","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=0375e9cec51d1519b548b55f9a9c0146","keys":"谭向龙,胰腺内分泌肿瘤,胰腺癌,乔布斯","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/22","id":"22","is_top":"1","is_public":"1","name":"【之间名医说】肝癌的成因和预防","vmemo":"@","vsource":"之间医疗","abstract2":"肝癌的成因和预防","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=0c7922a0efb139e765ae207a98d5a92c","keys":"谭向龙,肝癌,肝炎,肝癌防治","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/21","id":"21","is_top":"0","is_public":"1","name":"【之间名医说】积极预防腹部手术后遗症","vmemo":"@","vsource":"之间医疗","abstract2":"积极预防腹部手术后遗症","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=e9610ab7b042601af605beee9b6df5e2","keys":"谭向龙,腹部手术,肠粘连,肠梗阻","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/20","id":"20","is_top":"0","is_public":"1","name":"【之间名医说】胆固醇结晶与胆囊息肉的诊断与治疗","vmemo":"@","vsource":"之间医疗","abstract2":"胆固醇结晶与胆囊息肉的诊断与治疗","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=9077cebb5213063169646ec2ad48a702","keys":"谭向龙,胆囊息肉,胆固醇结晶,胆囊","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/19","id":"19","is_top":"0","is_public":"1","name":"【之间名医说】什么情况下不适合作保胆取石手术","vmemo":"@","vsource":"之间医疗","abstract2":"什么情况下不适合作保胆取石手术","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=e2b6146e3ae04aca594166f52d27455a","keys":"谭向龙,胆结石,保胆取石","vprice":"0.00"},{"url":"http://doctor.ubetween.cn/video/detail/v/app/id/18","id":"18","is_top":"0","is_public":"1","name":"【之间名医说】不良饮食结构与胰腺疾病的关系","vmemo":"@","vsource":"之间医疗","abstract2":"不良饮食结构与胰腺疾病的关系","vcatid":"1","order_list":"0","img_url":"http://img.pic.ubetween.cn/?f=af7ed53dc49e60a3534c496f7fad7c92","keys":"谭向龙,胰腺癌,饮食防癌","vprice":"0.00"}]
     */

    private DataBean data;
    private String errorcode;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public static class DataBean implements Serializable {
        private String count;

        private List<Data2Bean> data2;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<Data2Bean> getData2() {
            return data2;
        }

        public void setData2(List<Data2Bean> data2) {
            this.data2 = data2;
        }

        /**
         * url : http://doctor.ubetween.cn/video/detail/v/app/id/27
         * id : 27
         * is_top : 1
         * is_public : 1
         * name : 【之间名医说】适量饮酒是否对肝脏有影响
         * vmemo : @
         * vsource : 之间医疗
         * abstract2 : 适量饮酒是否对肝脏有影响
         * vcatid : 1
         * order_list : 0
         * img_url : http://img.pic.ubetween.cn/?f=221696254942df5b9abe9e2d6054135e
         * keys : 谭向龙,酒精肝
         * vprice : 0.00
         */
        public static class Data2Bean implements Serializable {
            private String url;
            private String id;
            private String is_top;
            private String is_public;
            private String name;
            private String vmemo;
            private String vsource;
            private String abstract2;
            private String vcatid;
            private String order_list;
            private String img_url;
            private String keys;
            private String vprice;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIs_top() {
                return is_top;
            }

            public void setIs_top(String is_top) {
                this.is_top = is_top;
            }

            public String getIs_public() {
                return is_public;
            }

            public void setIs_public(String is_public) {
                this.is_public = is_public;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getVmemo() {
                return vmemo;
            }

            public void setVmemo(String vmemo) {
                this.vmemo = vmemo;
            }

            public String getVsource() {
                return vsource;
            }

            public void setVsource(String vsource) {
                this.vsource = vsource;
            }

            public String getAbstract2() {
                return abstract2;
            }

            public void setAbstract2(String abstract2) {
                this.abstract2 = abstract2;
            }

            public String getVcatid() {
                return vcatid;
            }

            public void setVcatid(String vcatid) {
                this.vcatid = vcatid;
            }

            public String getOrder_list() {
                return order_list;
            }

            public void setOrder_list(String order_list) {
                this.order_list = order_list;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getKeys() {
                return keys;
            }

            public void setKeys(String keys) {
                this.keys = keys;
            }

            public String getVprice() {
                return vprice;
            }

            public void setVprice(String vprice) {
                this.vprice = vprice;
            }
        }
    }
}
