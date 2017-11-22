package com.gem.java.х╨ад;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread{
	private Socket socket;
	private List<Socket> socketList;
	public ServerThread(Socket socket,List<Socket> socketList){
		this.socket=socket;
		this.socketList=socketList;
	}
	
	public void run(){
		InputStream is=null;
		
		BufferedReader br=null;
		
		try {
			is=socket.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));	
			
			
			while(true){
				String msg=br.readLine();
				for(Socket socket:socketList){
				if(this.socket!=socket){
					new ServerWriteThread(socket,msg).start();
				}
			}
			}
			
			
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
			
	
		
		
		
	}
	
	
	
	
}
