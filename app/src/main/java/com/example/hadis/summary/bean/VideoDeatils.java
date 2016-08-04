package com.example.hadis.summary.bean;

import java.io.Serializable;

/**
 * 名医视频变化接口
 * 
 * @author hadis
 *
 */
public class VideoDeatils implements Serializable {
	// "url": "http://doctor.ubetween.com.cn/video/detail/v/app/id/40",
	// "id": "40",
	// "is_top": "0",
	// "is_public": "1",
	// "name": "【之间名医说】适量饮酒是否对肝脏有影响",
	// "vmemo": "<video controls=\"controls\"
	// src=\"http://static.ubetween.cn/doctor/video/drink_01.mp4\"
	// poster=\"http://img.pic.ubetween.cn/?f=221696254942df5b9abe9e2d6054135e\"
	// autoplay=\"autoplay\"
	// style=\"display:block;width:100%;height:auto;\">
	// 您的浏览器不支持 video 标签。
	// </video>",
	// "vsource": "之间医疗",
	// "abstract2": "适量饮酒是否对肝脏有影响",
	// "vcatid": "2",
	// "order_list": "0",
	// "img_url":
	// "http://img5.pic.ubetween.com.cn/?f=221696254942df5b9abe9e2d6054135e",
	// "keys": "谭向龙,酒精肝",
	// "vprice": "0.00"
	private String url;
	private String id;
	private String name;
	private String vmemo;
	private String vsource;
	private String abstract2;
	private String vcatid;
	private String img_url;
	private String keys;
	private String vprice;
	// --------------------我的账单
	// "tradeid": "250",
	// "trade_no": "2016011821001003870020991843",
	// "out_trade_no": "VIDEO_8_21_145311114280",
	// "subject": "购买视频-野生动物",
	// "fee": "1",
	// "createtime": "1453111142",
	// "paystatus": "1"
	private String tradeid;
	private String trade_no;
	private String out_trade_no;
	private String subject;
	private String fee;
	private String createtime;
	private String paystatus;

	public String getTradeid() {
		return tradeid;
	}

	public void setTradeid(String tradeid) {
		this.tradeid = tradeid;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

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
