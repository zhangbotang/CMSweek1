/**   
 * Copyright © 2019 公司名. 八维
 * 
 * @Title: FlowerService.java 
 * @Prject: gejiahui-week1
 * @Package: com.gejiahui.service 
 * @Description: TODO
 * @author:  葛家辉  
 * @date: 2019年8月6日 上午8:50:19 
 * @version: V1.0   
 */
package com.gejiahui.service;

import java.util.List;

import com.gejiahui.bean.Flower;
import com.github.pagehelper.PageInfo;

/** 
 * @ClassName: FlowerService 
 * @Description: TODO
 * @author: 葛家辉
 * @date: 2019年8月6日 上午8:50:19  
 */
public interface FlowerService {

	/** 
	 * @Title: getList 
	 * @Description: 列表展示
	 * @param f
	 * @param pageNum 
	 * @return
	 * @return: PageInfo<Flower>
	 */
	PageInfo<Flower> getList(Flower f, Integer pageNum);

	/** 
	 * @Title: getFlowerByid 
	 * @Description: 查看页面
	 * @param fid
	 * @return
	 * @return: Flower
	 */
	Flower getFlowerByid(Integer fid);

	/** 
	 * @Title: getType 
	 * @Description: TODO
	 * @return
	 * @return: List<Flower>
	 */
	List<Flower> getType();

	/** 
	 * @Title: add 
	 * @Description:添加
	 * @param f
	 * @return
	 * @return: int
	 */
	int add(Flower f);

	/** 
	 * @Title: update 
	 * @Description: TODO
	 * @param f
	 * @return
	 * @return: int
	 */
	int update(Flower f);

	/** 
	 * @Title: del 
	 * @Description: TODO
	 * @param fid
	 * @return
	 * @return: int
	 */
	int del(Integer fid);

	/** 
	 * @Title: dela 
	 * @Description: TODO
	 * @param fids
	 * @return
	 * @return: int
	 */
	int dela(Integer[] fids);

}
