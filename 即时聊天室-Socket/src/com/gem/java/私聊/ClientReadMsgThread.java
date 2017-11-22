package com.gem.java.Ë½ÁÄ;

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
				System.out.println("·þÎñÆ÷Ëµ:"+MsgReceived);
				
				if("byebye".equals(MsgReceived)){
					break;
				}
				
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
		}
	}
}

