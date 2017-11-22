package com.gem.xianzhi.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.gem.xianzhi.Biz.NewsBiz;
import com.gem.xianzhi.pojo.Classify;
import com.gem.xianzhi.pojo.News;
import com.gem.xianzhi.pojo.User;
import com.opensymphony.xwork2.ActionContext;

public class uploadNewsAction {
	private News news;
	private Classify classify;
	private NewsBiz newsBiz;
	private User user;
	private File image;
	private String imageContentType;
	private String imageFileName;//文件名称
	
	public String upload(){
			User currUser =(User) ActionContext.getContext().getSession().get("currUser");				
		    File destFile = null;
	        //获得图片保存的路径 
	        String savePath = ServletActionContext.getServletContext().getRealPath("/newsPicture");       	       
	        String uuid = UUID.randomUUID().toString();
	        int last = imageFileName.lastIndexOf(".");  
	        String head = imageFileName.substring(0,last)+uuid;//图片名称  
	        String type = imageFileName.substring(last);//图片类型
	        try {
	            InputStream is = new FileInputStream(image);
	            destFile = new File(savePath,head+type);
	            FileUtils.copyFile(image, destFile);   
	            //把图片写入到上面设置的路径里
	            OutputStream os = new FileOutputStream(destFile);
	            byte[] buffer = new byte[400];
	            int length  = 0 ;
	            while((length = is.read(buffer))>0){
	                os.write(buffer, 0, length);
	            }  
	           
	            os.flush();
	            is.close();
	            os.close(); 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      news.setClassify(classify);
	      news.setDate(new Date());
	      news.setVisitCount(0);
	      news.setAudit("未审核");
	      news.setDiscussCount(0);
	      news.setAuthor(currUser);
	      news.setImg("newsPicture/"+head+type); //把图片地址添加到数据库
	      newsBiz.addNews(news);
	      ActionContext.getContext().put("msg", "上传成功!");
	      return "uploadSuccess";	    
	}
	
	
	
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	public NewsBiz getNewsBiz() {
		return newsBiz;
	}
	public void setNewsBiz(NewsBiz newsBiz) {
		this.newsBiz = newsBiz;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}
