package com.gem.java.˽��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	private Socket socket;
	Scanner input =new Scanner(System.in);
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
		InputStream is=null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw=null;//��Ա���������ʼ��
		try {
			is = socket.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));
			
			os=socket.getOutputStream();
			pw=new PrintWriter(os);
			
			
			new ServerWriteMsgThread(pw,"������˵:���ӳɹ�!").start();
			
			new ServerReadMsgThread(br).start();
			
			while(true){
				String msgsend=input.nextLine();
				new ServerWriteMsgThread(pw,msgsend).start();
				if("byebye".equals(msgsend)){
					break;
				}
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
