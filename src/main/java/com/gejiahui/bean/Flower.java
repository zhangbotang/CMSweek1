/**   
 * Copyright © 2019 公司名. 八维
 * 
 * @Title: Flower.java 
 * @Prject: gejiahui-week1
 * @Package: com.gejiahui.bean 
 * @Description: TODO
 * @author:  葛家辉  
 * @date: 2019年8月6日 上午8:48:06 
 * @version: V1.0   
 */
package com.gejiahui.bean;

import java.io.Serializable;

/** 
 * @ClassName: Flower 
 * @Description: TODO
 * @author: 葛家辉
 * @date: 2019年8月6日 上午8:48:06  
 */
public class Flower implements Serializable{
	
	private Integer fid;
	private String fname;
	private String intro;
	private Integer tid;
	private String tname;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Flower [fid=" + fid + ", fname=" + fname + ", intro=" + intro + ", tid=" + tid + ", tname=" + tname
				+ "]";
	}
	
	
}
