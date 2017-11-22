package com.gem.java.群聊;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	public static void main(String[] args) throws IOException {
		List<Socket>socketList=new ArrayList<Socket>();
		ServerSocket server=new ServerSocket(4396);
		
		
		
	
		while(true){
			Socket socket=server.accept();
			socketList.add(socket);
			new ServerWriteThread(socket,"连接成功").start();
			new ServerThread(socket,socketList).start();
		}
		
		
	}
}
