/*
 * MainMenu.java
 *
 * Created on __DATE__, __TIME__
 */

package com.cdw.java.recipe.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.cdw.java.recipe.dao.CookDAO;
import com.cdw.java.recipe.dao.MaterialDAO;
import com.cdw.java.recipe.dao.RecipeDAO;
import com.cdw.java.recipe.dao.UserDAO;
import com.cdw.java.recipe.dao.Impl.CookDAOImpl;
import com.cdw.java.recipe.dao.Impl.MaterialDAOImpl;
import com.cdw.java.recipe.dao.Impl.RecipeDAOImpl;
import com.cdw.java.recipe.dao.Impl.UserDAOImpl;
import com.cdw.java.recipe.pojo.Recipe;

/**
 *
 * @author  __USER__
 */
public class MainMenuFrame extends javax.swing.JFrame {
	private String nickName;
	UserDAO userDAO = new UserDAOImpl();
	RecipeDAO recipeDAO = new RecipeDAOImpl();
	MaterialDAO materialDAO = new MaterialDAOImpl();
	CookDAO cookDAO = new CookDAOImpl();
	Function fnc = new Function();

	/** Creates new form MainMenu */
	public MainMenuFrame(String nickName) {
		this();
		this.nickName = nickName;

	}

	public MainMenuFrame() {

		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel9 = new javax.swing.JPanel();
		jbtUpLoad = new javax.swing.JButton();
		jbtDel = new javax.swing.JButton();
		jbtUpdate = new javax.swing.JButton();
		jbtShowMy = new javax.swing.JButton();
		jbtShowAll = new javax.swing.JButton();
		jbtSearch = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();

		jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 176,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 521,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel9.setBorder(new javax.swing.border.MatteBorder(null));

		jbtUpLoad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jbtUpLoad.setForeground(new java.awt.Color(0, 0, 204));
		jbtUpLoad.setText("\u4e0a\u4f20\u83dc\u54c1");
		jbtUpLoad.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtUpLoadMouseClicked(evt);
			}
		});

		jbtDel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jbtDel.setForeground(new java.awt.Color(0, 0, 255));
		jbtDel.setText("\u5220\u9664\u6211\u7684\u83dc\u54c1");
		jbtDel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtDelMouseClicked(evt);
			}
		});

		jbtUpdate.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jbtUpdate.setForeground(new java.awt.Color(0, 0, 255));
		jbtUpdate.setText("\u4fee\u6539\u6211\u7684\u83dc\u54c1");
		jbtUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtUpdateMouseClicked(evt);
			}
		});
		jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtUpdateActionPerformed(evt);
			}
		});

		jbtShowMy.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jbtShowMy.setForeground(new java.awt.Color(0, 0, 204));
		jbtShowMy.setText("\u67e5\u770b\u6211\u7684\u83dc\u54c1");
		jbtShowMy.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtShowMyMouseClicked(evt);
			}
		});

		jbtShowAll.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jbtShowAll.setForeground(new java.awt.Color(0, 0, 255));
		jbtShowAll.setText("\u67e5\u770b\u6240\u6709\u83dc\u54c1");
		jbtShowAll.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtShowAllMouseClicked(evt);
			}
		});

		jbtSearch.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jbtSearch.setForeground(new java.awt.Color(0, 0, 204));
		jbtSearch.setText("\u641c\u7d22\u83dc\u54c1");
		jbtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtSearchMouseClicked(evt);
			}
		});

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton1.setForeground(new java.awt.Color(255, 0, 0));
		jButton1.setText("\u9000\u51fa");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout
				.setHorizontalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGap(223, 223, 223)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jbtSearch,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE)
														.addComponent(
																jbtUpLoad,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE)
														.addComponent(
																jbtShowMy,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE)
														.addComponent(
																jbtUpdate,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE)
														.addComponent(
																jbtDel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE)
														.addComponent(
																jbtShowAll,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																193,
																Short.MAX_VALUE))
										.addGap(262, 262, 262)));
		jPanel9Layout
				.setVerticalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGap(16, 16, 16)
										.addComponent(
												jbtShowAll,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												53,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(26, 26, 26)
										.addComponent(
												jbtDel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												54,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(29, 29, 29)
										.addComponent(
												jbtUpdate,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												53,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(37, 37, 37)
										.addComponent(
												jbtShowMy,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												47,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(38, 38, 38)
										.addComponent(
												jbtUpLoad,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												48,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(35, 35, 35)
										.addComponent(
												jbtSearch,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												28, Short.MAX_VALUE)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												48,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel9, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		ExitsFrame exitsFrame = new ExitsFrame();
		exitsFrame.setTitle("提示");
		exitsFrame.setVisible(true);

	}

	private void jbtUpLoadMouseClicked(java.awt.event.MouseEvent evt) {
		UploadFrame uploadFrame = new UploadFrame(nickName);
		uploadFrame.setTitle("上传菜品");
		uploadFrame.setVisible(true);

	}

	private void jbtShowMyMouseClicked(java.awt.event.MouseEvent evt) {

		ShowMyFrame showMyFrame = new ShowMyFrame(nickName);
		List<Recipe> recipeList = fnc.ShowMy(nickName);
		if (!recipeList.isEmpty()) {
			showMyFrame.ReadList(nickName);
			showMyFrame.setTitle("我的菜品");
			showMyFrame.setVisible(true);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "你还未上传任何菜品!");
		}
	}

	private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {

		UpdateFrame updateFrame = new UpdateFrame(nickName);
		List<Recipe> recipeList = fnc.ShowMy(nickName);
		if (!recipeList.isEmpty()) {
			updateFrame.setTitle("修改我的菜品");
			updateFrame.ReadList(nickName);
			updateFrame.setVisible(true);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "你还未上传任何菜品!");
		}
	}

	private void jbtDelMouseClicked(java.awt.event.MouseEvent evt) {

		DelFrame delFrame = new DelFrame(nickName);
		List<Recipe> recipeList = fnc.ShowMy(nickName);
		if (!recipeList.isEmpty()) {
			delFrame.setTitle("删除我的菜品");
			delFrame.DelList();
			delFrame.setVisible(true);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "你还未上传任何菜品!");
		}
	}

	private void jbtSearchMouseClicked(java.awt.event.MouseEvent evt) {

		SearchFrame searchFrame = new SearchFrame(nickName);
		searchFrame.setTitle("搜索菜品");
		searchFrame.setVisible(true);
		this.setVisible(false);
	}

	//点击所有菜品列表按钮,显示ShowAll界面
	private void jbtShowAllMouseClicked(java.awt.event.MouseEvent evt) {
		ShowAllFrame showAllFrame = new ShowAllFrame(nickName);
		showAllFrame.setTitle("所有菜品列表");
		showAllFrame.ReadList();
		showAllFrame.setVisible(true);
		this.setVisible(false);
	}

	private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenuFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JButton jbtDel;
	private javax.swing.JButton jbtSearch;
	private javax.swing.JButton jbtShowAll;
	private javax.swing.JButton jbtShowMy;
	private javax.swing.JButton jbtUpLoad;
	private javax.swing.JButton jbtUpdate;
	// End of variables declaration//GEN-END:variables

}