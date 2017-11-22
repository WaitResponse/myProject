package com.gem.java.к╫ад;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("10.201.1.231",4396);
		Scanner input=new Scanner(System.in);
		
		InputStream is=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		
		OutputStream os=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(os);
		
		new ClientReadMsgThread(br).start();
		while(true){
			String msgsend=input.nextLine();
			new ClientWriteMsgThread(pw,msgsend).start();
			if("byebye".equals(msgsend)){
				break;
			}
			
		}
		
	}
}
