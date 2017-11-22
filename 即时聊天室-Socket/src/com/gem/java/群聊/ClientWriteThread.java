package com.gem.java.ÈºÁÄ;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriteThread extends Thread{
	private Socket socket;
	Scanner input=new Scanner(System.in);
	public ClientWriteThread(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
		try {
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			
			while(true){
				String IpStr=socket.getInetAddress().getHostAddress();
				String msg=input.nextLine();
				msg=IpStr+"Ëµ"+msg;
				pw.println(msg);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
