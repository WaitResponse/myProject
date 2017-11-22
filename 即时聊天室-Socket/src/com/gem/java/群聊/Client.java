package com.gem.java.х╨ад;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket=new Socket("10.201.1.231",4396);				
			new ClientWriteThread(socket).start();
			new ClientReaderThread(socket).start();
		
		
	}
}
