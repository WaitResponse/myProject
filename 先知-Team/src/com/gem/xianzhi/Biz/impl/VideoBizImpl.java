package com.gem.xianzhi.Biz.impl;

import java.util.List;

import com.gem.xianzhi.Biz.VideoBiz;
import com.gem.xianzhi.dao.ReplyDAO;
import com.gem.xianzhi.dao.VideoDAO;
import com.gem.xianzhi.pojo.Video;

public class VideoBizImpl implements VideoBiz {
	private VideoDAO videoDAO;

	public VideoDAO getVideoDAO() {
		return videoDAO;
	}

	public void setVideoDAO(VideoDAO videoDAO) {
		this.videoDAO = videoDAO;
	}

	@Override
	public int uploadVidel(Video video) {
		return (int)videoDAO.add(video);
	}

	@Override
	public List<Video> getVideoList() {
		return videoDAO.loadAll();
	}

	@Override
	public Video getVideo(int videoId) {
		return videoDAO.get(videoId);
	}

	@Override
	public void update(Video video) {
		videoDAO.update(video);		
	}

	@Override
	public List<Video> getHotVideoList() {
		return videoDAO.getHotVideoList();
	}

	@Override
	public List<Video> getVideoList(String keyword) {
		return videoDAO.getVedioList(keyword);
	}
	
	
}
