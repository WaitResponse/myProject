package com.gem.xianzhi.Biz;

import java.util.List;

import com.gem.xianzhi.pojo.News;

public interface NewsBiz {
	
	//1.���ݹؼ��֣�ÿҳ��¼����ǰҳ����ȡ�����б�(desc)
	List<News>getNewsList(String keyword, int pageSize,int classifyId, int pageNum);
	
	//2.���ݹؼ��֣�ÿҳ��¼����ǰҳ����ȡ�����б�(asc)
	List<News>getNewsListAsc(String keyword, int pageSize,int classifyId, int pageNum);
	
	List<News>getNewsList(String keyword, int pageSize,int pageNum);
	
	int getNewsCount(String keyword , int pageSize);
	
	//3.���ݹؼ��֣�ÿҳ��¼��ȡ��ҳ��
	int getNewsCount(String keyword , int pageSize ,int classifyId);
		
	//4.��������id��ȡ����
	News getNews(int newsId);
	
	//5.��������Idɾ������
	void delNews(int newsId);
	
	//6.ǰ̨��ҳ��ȡ�����б�
	List<News>getNewsList();
	//6.��������
	void addNews(News news);
	//7.��������
	void update(News news);
	
	//8.��ȡ���������б�(���ݷ������ҵ�6������,b)
	List<News>hotNewsList();
	
	//9.ǰ̨����
	List<News> getNewsList(String keyword);
	
	//10.�����û�Id��ȡ�û�����������
	List<News>getfabuNewsList(int userId);
}
