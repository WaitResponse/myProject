/*
 * DetailFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.cdw.java.recipe.Client;

import java.net.Socket;

/**
 *
 * @author  __USER__
 */
public class DetailFrame extends javax.swing.JFrame {
	private int rid;

	public DetailFrame(int rid) {
		this();
		this.rid = rid;
	}

	/** Creates new form DetailFrame */
	public DetailFrame() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtRname = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtMaterial = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtCook = new javax.swing.JTextArea();
		jbtReturn01 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setForeground(new java.awt.Color(0, 153, 153));
		jLabel1.setText("\u540d\u79f0");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel2.setForeground(new java.awt.Color(0, 153, 153));
		jLabel2.setText("\u914d\u6599");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel3.setForeground(new java.awt.Color(0, 153, 153));
		jLabel3.setText("\u505a\u6cd5");

		txtRname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		txtRname.setForeground(new java.awt.Color(255, 0, 0));

		txtMaterial.setColumns(20);
		txtMaterial.setFont(new java.awt.Font("Monospaced", 0, 18));
		txtMaterial.setForeground(new java.awt.Color(153, 0, 204));
		txtMaterial.setRows(5);
		jScrollPane1.setViewportView(txtMaterial);

		txtCook.setColumns(20);
		txtCook.setFont(new java.awt.Font("Monospaced", 0, 18));
		txtCook.setForeground(new java.awt.Color(204, 0, 204));
		txtCook.setRows(5);
		jScrollPane2.setViewportView(txtCook);

		jbtReturn01.setText("\u8fd4\u56de");
		jbtReturn01.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbtReturn01MouseClicked(evt);
			}
		});
		jbtReturn01
				.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent evt) {
					
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
																.addGap(175,
																		175,
																		175)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel3))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jScrollPane2)
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						460,
																						Short.MAX_VALUE)
																				.addComponent(
																						txtRname)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(398,
																		398,
																		398)
																.addComponent(
																		jbtReturn01,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		103,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(171, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														txtRname,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(77, 77, 77)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel2)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														166,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(43, 43, 43)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														186,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jbtReturn01,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										43, Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jbtReturn01MouseClicked(java.awt.event.MouseEvent evt) {
		this.setVisible(false);
	}

	/**
	 * @param args the command line arguments
	 */
	public void Showdetail(String rname, String material, String cook) {
		this.txtRname.setText(rname);
		this.txtMaterial.setText(material);
		this.txtCook.setText(cook);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DetailFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jbtReturn01;
	private javax.swing.JTextArea txtCook;
	private javax.swing.JTextArea txtMaterial;
	private javax.swing.JTextField txtRname;
	// End of variables declaration//GEN-END:variables

}