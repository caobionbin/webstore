package com.risen.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.risen.common.pojo.EUIDataGridResult;
import com.risen.common.utils.Result;
import com.risen.pojo.TbItemParam;
import com.risen.service.ItemParamService;

/**
 * 商品规格参数模板管理
 * @author sen
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Resource
	private ItemParamService itemParamService;
	
	/**
	 * 获取规格参数模板列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EUIDataGridResult getItemParamList(Integer page,Integer rows){
		EUIDataGridResult result =itemParamService.getItemParamList(page, rows);
		return result;
	}
	
	/**
	 * 根据商品分类 查询规格参数模板
	 * @param itemCatId
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public Result getItemParamByCid(@PathVariable Long itemCatId){
		Result result = itemParamService.getItemParamByCid(itemCatId);
		return result;
		
	}
	
	/**
	 * 新增规格参数模板
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public Result insertItemParam(@PathVariable long cid,String paramData){
		//创建pojo对象
		TbItemParam itemParam=new TbItemParam();
		//设置属性值
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		//调用service完成数据插入
		Result result = itemParamService.insertItemParam(itemParam);
		//返回结果
		return result;
	}
}
