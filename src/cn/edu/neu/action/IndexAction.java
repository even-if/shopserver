package cn.edu.neu.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.neu.model.Category;
import cn.edu.neu.model.Goods;
import cn.edu.neu.service.CateService;
import cn.edu.neu.service.GoodsService;

@Controller
public class IndexAction extends BaseAction{
	@Autowired
	private CateService cateService;
	@Autowired
	private GoodsService goodsService;

	
	@RequestMapping("/index")
	public String getIndexPage(Map<String,List> m){
		System.out.println("indexaction");
		List<Category> cates=cateService.getAllCates();
		List<Goods> newGoods=goodsService.getNewGoods();
		List<Goods> salesGoods=goodsService.getSalesGoods();
		m.put("cates", cates);
		m.put("newGoods",newGoods);
		m.put("salesGoods", salesGoods);
		System.out.println("aa"+m);
		return "home";
	}
}
