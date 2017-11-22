package com.gem.kfc.actions;

import java.util.Set;

import com.gem.kfc.dao.CategoryDAO;
import com.gem.kfc.dao.GoodsDAO;
import com.gem.kfc.dao.Impl.CategoryDAOImpl;
import com.gem.kfc.dao.Impl.GoodsDAOImpl;
import com.gem.kfc.pojo.Category;
import com.gem.kfc.pojo.Goods;
import com.opensymphony.xwork2.ActionContext;


public class IndexAction {
	
	private Category category=new Category();


	public String index(){
		CategoryDAO categoryDAO=new CategoryDAOImpl();
		Set<Category> categories=categoryDAO.getCategories();
		ActionContext.getContext().getSession().put("categories",categories);

		//��ȡ������Ʒ���������Ʒ
		GoodsDAO goodsDAO=new GoodsDAOImpl();
		Set<Goods>goodses=goodsDAO.getGoods();
		ActionContext.getContext().getSession().put("goodses", goodses);
		

		return "success";
	}
	public String preMain(){
		GoodsDAO goodsDAO=new GoodsDAOImpl();
		Set<Goods>goodsSet=(category.getId()==0?goodsDAO.getGoods():goodsDAO.getGoods(category.getId()));
		ActionContext.getContext().getSession().put("goodses", goodsSet);
		
		return "main";		
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
