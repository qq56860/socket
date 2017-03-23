package ThreadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
	
		ServerSocket ss=new ServerSocket(8888);//创建serverSocket对象
		System.out.println("~~~server端启动~~~");
	
		try {
			
			while(true){
				
				Socket sc=ss.accept(); //监听客户端请求
				
				new SocketThread(sc).start();
				
			}
			
		} catch (IOException e) {
			System.out.println("client close");
		}
		
		
	}
	
}
