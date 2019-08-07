/**   
 * Copyright © 2019 公司名. 八维
 * 
 * @Title: FlowerMapper.java 
 * @Prject: gejiahui-week1
 * @Package: com.gejiahui.mapper 
 * @Description: TODO
 * @author:  葛家辉  
 * @date: 2019年8月6日 上午8:50:55 
 * @version: V1.0   
 */
package com.gejiahui.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gejiahui.bean.Flower;

/** 
 * @ClassName: FlowerMapper 
 * @Description: TODO
 * @author: 葛家辉
 * @date: 2019年8月6日 上午8:50:55  
 */
public interface FlowerMapper {

	/** 
	 * @Title: getList 
	 * @Description: TODO
	 * @param f
	 * @return
	 * @return: List<Flower>
	 */
	List<Flower> getList(Flower f);

	/** 
	 * @Title: getFlowerByid 
	 * @Description: 查看页面
	 * @param fid
	 * @return
	 * @return: Flower
	 */
	@Select("select * from flower f ,type t where f.tid = t.tid and f.fid = #{fid}")
	Flower getFlowerByid(Integer fid);

	/** 
	 * @Title: getType 
	 * @Description: TODO
	 * @return
	 * @return: List<Flower>
	 */
	@Select("select * from type")
	List<Flower> getType();

	/** 
	 * @Title: add 
	 * @Description: TODO
	 * @param f
	 * @return
	 * @return: int
	 */
	@Insert("insert into flower set fname=#{fname},intro=#{intro},tid=#{tid}")
	int add(Flower f);

	/** 
	 * @Title: update 
	 * @Description: TODO
	 * @param f
	 * @return
	 * @return: int
	 */
	@Update("update flower set fname=#{fname},intro=#{intro},tid=#{tid} where fid = #{fid}")
	int update(Flower f);

	/** 
	 * @Title: del 
	 * @Description: TODO
	 * @param fid
	 * @return
	 * @return: int
	 */
	@Delete("delete from flower where fid = #{fid}")
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
