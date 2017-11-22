package com.gem.xianzhi.dao;

import java.util.List;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.Video;

public interface VideoDAO extends IBaseDAO<Video> {
	
	//��ȡ������Ƶ
	List<Video>getHotVideoList();
	
	//������Ƶ
	List<Video> getVedioList(String keyword);
}
