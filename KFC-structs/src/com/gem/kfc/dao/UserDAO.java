package com.gem.kfc.dao;

import com.gem.kfc.pojo.User;

public interface UserDAO {
	User getUser(String loginId,String pwd);//��¼�õ�
	boolean addUser(User user);//ע���õ�
}
