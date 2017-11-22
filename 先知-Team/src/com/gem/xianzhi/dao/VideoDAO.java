package com.gem.xianzhi.dao;

import java.util.List;

import com.gem.xianzhi.dao.base.IBaseDAO;
import com.gem.xianzhi.pojo.Video;

public interface VideoDAO extends IBaseDAO<Video> {
	
	//获取热门视频
	List<Video>getHotVideoList();
	
	//搜索视频
	List<Video> getVedioList(String keyword);
}
