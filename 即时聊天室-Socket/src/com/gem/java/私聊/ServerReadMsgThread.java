package com.gem.java.˽��;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerReadMsgThread  extends Thread{
	private BufferedReader br;
	public ServerReadMsgThread(BufferedReader br){
		this.br=br;
	}
			
		public void run(){
			while(true){
			String MsgReceived=null;
			try{
			MsgReceived =br.readLine();
			System.out.println("�ͻ���˵:"+MsgReceived);
			if("byebye".equals(MsgReceived)){
				break;
			}
			}catch(IOException e){
				e.printStackTrace();
			}
			}
			
		}
	}

