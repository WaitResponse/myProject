package com.gem.kfc.dao;

import java.util.Set;

import com.gem.kfc.pojo.CartItem;

public interface CartItemDAO {
	//������ƷId��ȡ���ﳵ��Ϣ
	public Set<CartItem>getCartItem(int uid);
	
	//��ӹ��ﳵ��Ϣ
	public CartItem addCartItem(CartItem cartItem);
	
	//�޸Ĺ��ﳵ��Ϣ
	public boolean updateCartItem(CartItem cartItem);
	
	//ɾ�����ﳵ��Ϣ,������ƷId
	public boolean delCartItem(int gid);
	//���ݹ����Idɾ����Ϣ
	public boolean delCartItemBycid(int cid);
}
