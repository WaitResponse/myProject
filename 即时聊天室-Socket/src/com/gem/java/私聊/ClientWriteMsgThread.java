package com.gem.java.к╫ад;

import java.io.PrintWriter;

public class ClientWriteMsgThread extends Thread{
	private PrintWriter pw;
	private String msgsend;
	public ClientWriteMsgThread(PrintWriter pw,String msgsend){
		this.pw=pw;
		this.msgsend=msgsend;
	}
	
	public void run(){
		pw.println(msgsend);
		pw.flush();
	}
}
