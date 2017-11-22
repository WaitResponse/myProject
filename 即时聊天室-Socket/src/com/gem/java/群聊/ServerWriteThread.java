package com.gem.java.х╨ад;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWriteThread extends Thread {
	private Socket socket;
	private String msg;
	public ServerWriteThread(Socket socket,String msg){
		this.socket=socket;
		this.msg=msg;
	}
	public void run(){		
		OutputStream os=null;
		PrintWriter pw=null;
		try {
			os = socket.getOutputStream();
			pw=new PrintWriter(os);
			
			pw.println(msg);
			pw.flush();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
}
