package cn.edu.neu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.mapper.GoodsMapper;
import cn.edu.neu.model.Goods;
import cn.edu.neu.model.Stock;
import cn.edu.neu.service.GoodsService;

@Service
@Transactional 
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper mapper;
	
	@Override
	public Page<Goods> getGoodsByCate(String cateId,String sort) {
		// TODO Auto-generated method stub
		Page<Goods> page = new Page<Goods>(15);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("cateId", cateId);
		m.put("sort", sort);
		page.setParams(m);
		List<Goods> goodsList=mapper.getGoodsByCate(page);
		page.setList(goodsList);
		return page;
	}

	@Override
	public List<Goods> getNewGoods() {
		// TODO Auto-generated method stub
		List<Goods> newGoods=mapper.getNewGoods();
		//System.out.println(newGoods);
		return newGoods;
	}

	@Override
	public List<Goods> getSalesGoods() {
		// TODO Auto-generated method stub
		List<Goods> salesGoods=mapper.getSalesGoods();
		System.out.println(salesGoods);
		return salesGoods;
	}

	@Override
	public Page<Goods> getGoodsBySearchKeyword(String keyword,String sort) {
		// TODO Auto-generated method stub
		System.out.println("-------"+sort);
		Page<Goods> page = new Page<Goods>(15);
		String[] keywords=keyword.split(" ");
		
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("keywords", keywords);
		m.put("sort", sort);
		page.setParams(m);
		List<Goods> goodsList=mapper.getGoodsByKeyword(page);
		System.out.println("-------"+goodsList);
		page.setList(goodsList);
		return page;
	}

	@Override
	public Goods getGoodsDetailById(String goodsId) {
		// TODO Auto-generated method stub
		Goods goodsDetail=mapper.getGoodsDetailById(goodsId);		
		System.out.println(goodsDetail);	
		return goodsDetail;
	}
	@Override
	public Goods getGoodsSizesById(String goodsId) {
		// TODO Auto-generated method stub		
		Goods goodsSizes=mapper.getGoodsSizesById(goodsId);
		System.out.println(goodsSizes);
		return goodsSizes;
	}
	@Override
	public Goods getGoodsColorsById(String goodsId) {
		// TODO Auto-generated method stub
		Goods goodsColors=mapper.getGoodsColorsById(goodsId);
		System.out.println(goodsColors);
		return goodsColors;
	}
	
	@Override
	public List<Map<String, Object>> getGoodsListByIds(String[] goodsId,
			String[] size, String[] color, String[] num) {
		// TODO Auto-generated method stub
		List<Goods> goodsInfos=mapper.getGoodsListByIds(goodsId);
		List<Map<String,Object>> goodsList=new ArrayList<Map<String,Object>>();
		for(int i=0;i<goodsId.length;i++){
			Goods g=new Goods();
			g.setGoodsId(Integer.parseInt(goodsId[i]));
			int j=goodsInfos.indexOf(g);
			if(j!=-1){
				Goods goods=goodsInfos.get(j);
				Map<String,Object> m=new HashMap<String,Object>();
				m.put("goodsId", goodsId[i]);
				m.put("goodsName", goods.getGoodsName());
				m.put("goodsPrice", goods.getGoodsPrice());
				m.put("goodsDiscount", goods.getGoodsDiscount());
				m.put("goodsPostalfee", goods.getGoodsPostalfee());
				m.put("goodsPic", goods.getGoodsPic());
				m.put("size", size[i]);
				m.put("color", color[i]);
				m.put("num", num[i]);
				goodsList.add(m);
			}
		}
		return goodsList;
	}
}
