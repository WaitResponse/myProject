package com.gem.kfc.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gem.kfc.dao.AddressDAO;
import com.gem.kfc.dao.CartItemDAO;
import com.gem.kfc.dao.GoodsDAO;
import com.gem.kfc.dao.OrderBeanDAO;
import com.gem.kfc.dao.OrderItemDAO;
import com.gem.kfc.dao.Impl.AddressDAOImpl;
import com.gem.kfc.dao.Impl.CartItemDAOImpl;
import com.gem.kfc.dao.Impl.GoodsDAOImpl;
import com.gem.kfc.dao.Impl.OrderBeanDAOImpl;
import com.gem.kfc.dao.Impl.OrderItemDAOImpl;
import com.gem.kfc.pojo.CartItem;
import com.gem.kfc.pojo.Goods;
import com.gem.kfc.pojo.Order;
import com.gem.kfc.pojo.OrderItem;
import com.gem.kfc.pojo.User;
import com.gem.kfc.pojo.UserAddress;
import com.opensymphony.xwork2.ActionContext;

public class CartAction {
	private int addr;
	private int gid;
	public String cartInfo(){

		User user=(User)ActionContext.getContext().getSession().get("currUser");
		CartItemDAO cartItemDAO=new CartItemDAOImpl();

		Set<CartItem>cartItemSet=cartItemDAO.getCartItem(user.getId());
		Map<Integer,CartItem> cartItemMap = new HashMap<Integer,CartItem>();
		for(CartItem cartItem : cartItemSet){
			cartItemMap.put(cartItem.getGoods().getId(), cartItem);
		}
		ActionContext.getContext().getSession().put("cartItemMap", cartItemMap);
		//��ת�����ﳵ����ҳ��
		return "cart_detail";
	}
	public String pay(){

		//1.��ȡ��ǰ���ﳵ��Ϣ
		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		
		Map<Integer,CartItem>cartItemMap=(Map<Integer,CartItem>)ActionContext.getContext().getSession().get("cartItemMap");
		//����һ��������������
		Order orderBean=new Order();
		User user=(User)ActionContext.getContext().getSession().get("currUser");
		orderBean.setUser(user);
		orderBean.setOrderDate(new Date());

		Collection<CartItem> cartItems=cartItemMap.values();
		int orderMoney=0;
		for(CartItem cartItem:cartItems){
			orderMoney=orderMoney+cartItem.getCount()*cartItem.getGoods().getPrice();
		}
		orderBean.setMoney(orderMoney);
		orderBean.setAddress(new UserAddress(addr));
		//���������ϣ���ʼ�������ݿ�
		OrderBeanDAO orderDAO=new OrderBeanDAOImpl();
		orderBean=orderDAO.addOrderBean(orderBean);//��ʱ��orderBeanֻ��id
		//�򶩵��������붩����Ϣ
		for(CartItem ci:cartItems){
			OrderItem oi=new OrderItem();//�����������ѭ�������ʾ�ж�����������
			oi.setGoods(ci.getGoods());
			oi.setCount(ci.getCount());
			oi.setOrder(orderBean);

			OrderItemDAO orderItemDAO =new OrderItemDAOImpl();
			boolean flag=orderItemDAO.addOrderItem(oi);
			//��������������ɹ�������ն�Ӧ��CartItem��Ϣ
			if(flag){
				cartItemDAO.delCartItem(ci.getGoods().getId());//������Ϊ��add_cart�а�û��Id�Ĺ��������CartItemMap������ֻ�ܸ�����ƷIDɾ��
			}
		}			
		return "main_page";
	}
	public String prePay(){
		User user=(User)ActionContext.getContext().getSession().get("currUser");

		//2.�����û� ��ַ
		AddressDAO addressDAO=new AddressDAOImpl();
		Set<UserAddress>address=addressDAO.getAddress(user.getId());
		ActionContext.getContext().getSession().put("address",address);

		return "to_pay";
	}
	public String toAddCart(){

		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		GoodsDAO goodsDAO=new GoodsDAOImpl();
		User user=(User)ActionContext.getContext().getSession().get("currUser");
		//1.��ȡ��ƷId,Ȼ����ʾ���ﳵ

		Object obj=ActionContext.getContext().getSession().get("cartItemMap");//sessoinû��cartItemMap,����Ϊnull
		Map<Integer,CartItem>cartItemMap=null;
		if(obj==null){
			cartItemMap=new HashMap<Integer,CartItem>();//Ϊ�մ���һ��cartItemMap
		}else{
			cartItemMap=(Map<Integer,CartItem>)obj;
		}
		if(cartItemMap.containsKey(gid)){//�жϹ��ﳵ���Ƿ���ڶ�Ӧ��ƷId����Ʒ��������ڻ�ȡ��Ӧ�Ĺ����
			CartItem cartItem=cartItemMap.get(gid);
			cartItem.setCount(cartItem.getCount()+1);//�����������һ
			cartItemDAO.updateCartItem(cartItem);//���޸ĺ�Ĺ�����������ݿ�
		}else{//�����ڶ�Ӧ�Ĺ����
			CartItem cartItem=new CartItem();//����һ�����ѵ�ǰ�Ĺ�������Է����ڴ�
			Goods goods=new Goods(gid);
			cartItem.setGoods(goods);
			cartItem.setCount(1);
			cartItem.setUser(user);

			cartItem=cartItemDAO.addCartItem(cartItem);//���ڴ��еĹ�����������ݿ�
			cartItemMap.put(gid,cartItem);//���ڴ��еĹ�������빺�ﳵ
		}
		//�����ݿ����δ���˵Ĺ�����Ϣ
		Set<CartItem>cartItemSet=cartItemDAO.getCartItem(user.getId());
		cartItemMap=new HashMap<Integer,CartItem>();//����һ�����ﳵ
		for(CartItem cartItem:cartItemSet){
			cartItemMap.put(cartItem.getGoods().getId(),cartItem);
		}
		ActionContext.getContext().getSession().put("cartItemMap", cartItemMap);

		return "cart_detail";
	}
	public String delCart(){
		HttpServletResponse response =ServletActionContext.getResponse();
		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		User user=(User)ActionContext.getContext().getSession().get("currUser");
		boolean flag=cartItemDAO.delCartItem(gid);//�����ݿ���ɾ�����������¼
		if(flag){//���ɾ���ɹ������¹��ﳵ			
			Map<Integer,CartItem>cartItemMap=new HashMap<Integer,CartItem>();
			Set<CartItem>cartItemSet=cartItemDAO.getCartItem(user.getId());
			for(CartItem cartItem:cartItemSet){
				cartItemMap.put(cartItem.getGoods().getId(),cartItem);
			}
			ActionContext.getContext().getSession().put("cartItemMap",cartItemMap);
			return "cart_detail";
		}else{
			PrintWriter out;
			try{
				out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('ɾ��ʧ��!')");
				out.println("window.location.href='cart_detail.jsp';");
				out.println("</script>");
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}

	public int getAddr() {
		return addr;
	}
	public void setAddr(int addr) {
		this.addr = addr;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}

}
