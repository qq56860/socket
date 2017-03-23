package ThreadSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketThread extends Thread {
	private Socket sc;
	
	public SocketThread(Socket sc){
		this.sc=sc;
	}
	public void run(){
		try {
			System.out.println(Thread.currentThread().getId());
			
			receive(sc);
			
			send(sc);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private void receive(Socket sc) throws IOException{
		//获取输入流中客户端请求信息
		DataInputStream dis=new DataInputStream(sc.getInputStream());
		
		String str = dis.readUTF();//dataOutputStream 的方法~~使用utf-8编码
		System.out.println("客户端发送-----"+str);
//		String str1 = dis.readLine();
//		System.out.println("str1="+str1);
		
//		sc.shutdownInput();
	}
	
	public void send(Socket sc) throws IOException{
		
		System.out.println("请输入发送内容-----");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str1=br.readLine();
		
		//IO流发送
		DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
		dos.writeUTF(str1);
		
		
//		sc.shutdownOutput();
	}
	
}
