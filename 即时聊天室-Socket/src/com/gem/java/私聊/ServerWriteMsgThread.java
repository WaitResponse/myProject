package com.gem.java.˽��;

import java.io.PrintWriter;

public class ServerWriteMsgThread extends Thread{
	private PrintWriter pw;
	private String msgsend ;
	public ServerWriteMsgThread(PrintWriter pw,String msgsend){
		this.pw=pw;
		this.msgsend=msgsend;
	}
	public void run(){
		pw.println(msgsend);
		pw.flush();
	}
	
}
