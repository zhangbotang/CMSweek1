/**   
 * Copyright © 2019 公司名. 八维
 * 
 * @Title: FlowerServiceImpl.java 
 * @Prject: gejiahui-week1
 * @Package: com.gejiahui.service 
 * @Description: TODO
 * @author:  葛家辉  
 * @date: 2019年8月6日 上午8:50:27 
 * @version: V1.0   
 */
package com.gejiahui.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gejiahui.bean.Flower;
import com.gejiahui.mapper.FlowerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
 * @ClassName: FlowerServiceImpl 
 * @Description: TODO
 * @author: 葛家辉
 * @date: 2019年8月6日 上午8:50:27  
 */
@Service
public class FlowerServiceImpl implements FlowerService {

	@Resource
	private FlowerMapper mapper;
	/* (non Javadoc) 
	 * @Title: getList
	 * @Description: 列表展示
	 * @param f
	 * @return 
	 * @see com.gejiahui.service.FlowerService#getList(com.gejiahui.bean.Flower) 
	 */
	@Override
	public PageInfo<Flower> getList(Flower f,Integer pageNum) {
		PageHelper.startPage(pageNum, 4);
		List<Flower> list = mapper.getList(f);
		
		return new PageInfo<Flower>(list);
	}
	
	/* (non Javadoc) 
	 * @Title: getFlowerByid
	 * @Description:查看页面
	 * @param fid
	 * @return 
	 * @see com.gejiahui.service.FlowerService#getFlowerByid(java.lang.Integer) 
	 */
	@Override
	public Flower getFlowerByid(Integer fid) {
		// TODO Auto-generated method stub
		return mapper.getFlowerByid(fid);
	}
	/* (non Javadoc) 
	 * @Title: getType
	 * @Description: 动态追加类型
	 * @return 
	 * @see com.gejiahui.service.FlowerService#getType() 
	 */
	@Override
	public List<Flower> getType() {
		// TODO Auto-generated method stub
		return mapper.getType();
	}
	
	/* (non Javadoc) 
	 * @Title: add
	 * @Description: 添加
	 * @param f
	 * @return 
	 * @see com.gejiahui.service.FlowerService#add(com.gejiahui.bean.Flower) 
	 */
	@Override
	public int add(Flower f) {
		// TODO Auto-generated method stub
		return mapper.add(f);
	}
	
	/* (non Javadoc) 
	 * @Title: update
	 * @Description: TODO
	 * @param f
	 * @return 
	 * @see com.gejiahui.service.FlowerService#update(com.gejiahui.bean.Flower) 
	 */
	@Override
	public int update(Flower f) {
		// TODO Auto-generated method stub
		return mapper.update(f);
	}
	/* (non Javadoc) 
	 * @Title: del
	 * @Description: TODO
	 * @param fid
	 * @return 
	 * @see com.gejiahui.service.FlowerService#del(java.lang.Integer) 
	 */
	@Override
	public int del(Integer fid) {
		// TODO Auto-generated method stub
		return mapper.del(fid);
	}
	/* (non Javadoc) 
	 * @Title: dela
	 * @Description: TODO
	 * @param fids
	 * @return 
	 * @see com.gejiahui.service.FlowerService#dela(java.lang.Integer[]) 
	 */
	@Override
	public int dela(Integer[] fids) {
		// TODO Auto-generated method stub
		return mapper.dela(fids);
	}
}
