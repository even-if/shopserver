package cn.edu.neu.service;


import java.util.List;
import java.util.Map;

import cn.edu.neu.core.common.Page;

import cn.edu.neu.model.Goods;
import cn.edu.neu.model.Stock;

public interface GoodsService {

	Page<Goods> getGoodsByCate(String cateId,String sort);

	List<Goods> getNewGoods();

	List<Goods> getSalesGoods();

	Page<Goods> getGoodsBySearchKeyword(String keyword,String sort);

	Goods getGoodsDetailById(String goodsId);
	
	Goods getGoodsSizesById(String goodsId);
	
	Goods getGoodsColorsById(String goodsId);

	List<Map<String, Object>> getGoodsListByIds(String[] goodsId,
			String[] size, String[] color, String[] num);
	}
