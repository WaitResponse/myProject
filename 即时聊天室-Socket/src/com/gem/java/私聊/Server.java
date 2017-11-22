package com.gem.java.私聊;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(4396);
		
		while(true){
			Socket socket=server.accept();
			String ipStr=socket.getInetAddress().getHostAddress();
			System.out.println(ipStr+"连上来了");
			new ServerThread(socket).start();
		}
	}
}
