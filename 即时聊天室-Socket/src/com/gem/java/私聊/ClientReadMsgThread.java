package com.gem.java.˽��;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientReadMsgThread extends Thread{
	private BufferedReader br;
	public ClientReadMsgThread(BufferedReader br){
		this.br=br;
	}
		
		public void run(){
			while(true){
			String MsgReceived=null;
			try {
				MsgReceived = br.readLine();
				System.out.println("������˵:"+MsgReceived);
				
				if("byebye".equals(MsgReceived)){
					break;
				}
				
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
		}
	}
}

