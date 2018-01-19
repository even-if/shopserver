package cn.edu.neu.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.Goods;
import cn.edu.neu.model.Stock;

public interface GoodsMapper {

	List<Goods> getGoodsByCate(Page<Goods> page);

	List<Goods> getNewGoods();

	List<Goods> getSalesGoods();

	List<Goods> getGoodsByKeyword(Page<Goods> page);

	Goods getGoodsDetailById(String goodsId);

	Goods getGoodsSizesById(String goodsId);

	Goods getGoodsColorsById(String goodsId);
	
	List<Goods> getGoodsListByIds(String[] goodsId);
}
