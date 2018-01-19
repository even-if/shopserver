package cn.edu.neu.mapper;

import java.util.List;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.Category;
import cn.edu.neu.model.User;

public interface CateMapper {

	List<Category> getAllCates(Page<Category> page);

	void addCate(Category cate);

	Category getCateById(String cateId);

	



}
