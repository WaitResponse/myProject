/*
 * UpdateFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.cdw.java.recipe.Client;

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
public class UpdateFrame extends javax.swing.JFrame {
	private String nickName;
	UserDAO userDAO = new UserDAOImpl();
	RecipeDAO recipeDAO = new RecipeDAOImpl();
	MaterialDAO materialDAO = new MaterialDAOImpl();
	CookDAO cookDAO = new CookDAOImpl();
	Function fnc = new Function();

	/** Creates new form UpdateFrame */
	public UpdateFrame(String nickName) {
		this();
		this.nickName = nickName;
	}

	public UpdateFrame() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		txtList = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();
		jbtSend05 = new javax.swing.JButton();
		jbtReturn05 = new javax.swing.JButton();
		txtUpdateId = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		txtList.setColumns(20);
		txtList.setFont(new java.awt.Font("Monospaced", 0, 18));
		txtList.setForeground(new java.awt.Color(0, 0, 204));
		txtList.setRows(5);
		jScrollPane1.setViewportView(txtList);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setText("\u8bf7\u8f93\u5165\u8981\u4fee\u6539\u7684\u83dc\u54c1\u7f16\u53f7\uff1a");

		jbtSend05.setText("\u786e\u5b9a");
		jbtSend05.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtSend05MouseClicked(evt);
			}
		});

		jbtReturn05.setText("\u8fd4\u56de");
		jbtReturn05.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtReturn05MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(117,
																		117,
																		117)
																.addComponent(
																		jLabel1)
																.addGap(18, 18,
																		18)
																.addComponent(
																		txtUpdateId,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		140,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(87, 87,
																		87)
																.addComponent(
																		jbtSend05)
																.addGap(65, 65,
																		65)
																.addComponent(
																		jbtReturn05))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(66, 66,
																		66)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		795,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(71, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(25, 25, 25)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										382, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										20, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														txtUpdateId,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														34,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jbtReturn05,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														44,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jbtSend05,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														39,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(30, 30, 30)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jbtSend05MouseClicked(java.awt.event.MouseEvent evt) {
		int rid = Integer.valueOf(this.txtUpdateId.getText());
		List<Recipe> recipeList = fnc.ShowMy(nickName);
		boolean flag=false;
		for (Recipe recipe : recipeList) {
			int id = recipe.getId();
			if(rid==id){
				flag=true;
				break;
			}
		}
		if(flag){
		String rname = fnc.getRecipe(rid);
		UpdateFrame1 updateFrame1 = new UpdateFrame1(rid);
		updateFrame1.RecipeName(rname);
		updateFrame1.setTitle(rname);
		updateFrame1.setVisible(true);
	}
	else{
		JOptionPane.showMessageDialog(new JFrame(), "请输入列表中存在的编号!");
	}
	}

	private void jbtReturn05MouseClicked(java.awt.event.MouseEvent evt) {
		MainMenuFrame mainMenuFrame = new MainMenuFrame(nickName);
		mainMenuFrame.setTitle(nickName);
		mainMenuFrame.setVisible(true);
		this.setVisible(false);
	}

	public void ReadList(String uname) {

		List<Recipe> recipeList = fnc.ShowMy(uname);
		StringBuilder stb = new StringBuilder("编号" + "\t" + "名称" + "\t\t\t"
				+ "创建者" + "\t\t" + "上传时间" + "\r\n");
		for (Recipe recipe : recipeList) {
			int id = recipe.getId();
			String name = recipe.getName();
			Date date = recipe.getDate();
			stb.append(id + "\t" + name + "\t\t" + uname + "\t\t" + date
					+ "\r\n");

		}
		this.txtList.setText(stb.toString());
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UpdateFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jbtReturn05;
	private javax.swing.JButton jbtSend05;
	private javax.swing.JTextArea txtList;
	private javax.swing.JTextField txtUpdateId;
	// End of variables declaration//GEN-END:variables

}