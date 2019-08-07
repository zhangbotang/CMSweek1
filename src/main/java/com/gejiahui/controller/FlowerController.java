/**   
 * Copyright © 2019 公司名. 八维
 * 
 * @Title: FlowerController.java 
 * @Prject: gejiahui-week1
 * @Package: com.gejiahui.controller 
 * @Description: TODO
 * @author:  葛家辉  
 * @date: 2019年8月6日 上午8:49:49 
 * @version: V1.0   
 */
package com.gejiahui.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gejiahui.bean.Flower;
import com.gejiahui.service.FlowerService;
import com.github.pagehelper.PageInfo;

/** 
 * @ClassName: FlowerController 
 * @Description: TODO
 * @author: 葛家辉
 * @date: 2019年8月6日 上午8:49:49  
 */
@Controller
public class FlowerController {
	@Resource
	private FlowerService ser;
	
	/**
	 * 
	 * @Title: list 
	 * @Description: 列表展示
	 * @param request
	 * @param f
	 * @return
	 * @return: String
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,Flower f,@RequestParam(defaultValue = "1")Integer pageNum) {
		PageInfo<Flower> pg = ser.getList(f,pageNum);
		
		request.setAttribute("pg", pg);
		request.setAttribute("f", f);
		
		return "list";
		
	}
	/**
	 * 
	 * @Title: look 
	 * @Description: 查看页面
	 * @param fid
	 * @param pageNum
	 * @return
	 * @return: String
	 */
	@RequestMapping("look")
	public String look(Integer fid,Integer pageNum,HttpServletRequest request) {
		Flower f = ser.getFlowerByid(fid);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("f", f);
		return "look";
	}
	/**
	 * 
	 * @Title: toAdd 
	 * @Description: 去添加
	 * @return
	 * @return: String
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		
		return "add";
	}
	
	/**
	 * 
	 * @Title: hx 
	 * @Description: 动态追加类型
	 * @return
	 * @return: List<Flower>
	 */
	@RequestMapping("hx")
	@ResponseBody
	public List<Flower> hx(){
		
		return ser.getType();
	}
	
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("add")
	@ResponseBody
	
	public boolean add(Flower f) {
		
		return ser.add(f)>0;
		
	}
	/**
	 * 
	 * @Title: toUpdate 
	 * @Description: 去修改页面
	 * @param fid
	 * @param pageNum
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Integer fid,Integer pageNum,HttpServletRequest request) {
		Flower f = ser.getFlowerByid(fid);
		List<Flower> type = ser.getType();
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("f", f);
		request.setAttribute("type", type);
		return "update";
	}
	/**
	 * 
	 * @Title: update 
	 * @Description:修改
	 * @param f
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("update")
	@ResponseBody
	public boolean update(Flower f) {
		
		return ser.update(f)>0;
		
	}
	/**
	 * 
	 * @Title: del 
	 * @Description:单删
	 * @param fid
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("del")
	@ResponseBody
	public boolean del(Integer fid) {
		return ser.del(fid)>0;
	}
	
	/**
	 * 
	 * @Title: dela 
	 * @Description: 批量删
	 * @param fids
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("dela")
	@ResponseBody
	public boolean dela(@RequestParam("fids[]") Integer[] fids) {
		return ser.dela(fids)>0;
	}

}
