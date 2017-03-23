package ThreadSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("~~~客户端启动~~~");
		while(true){
			
			try {
				//客户端创建socket对象
				Socket sc=new Socket("127.0.0.1",8888);
				
				send(sc);
				receive(sc);
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
	}
	
	public static void send(Socket sc) throws Exception{
		System.out.println("请输入发送内容---");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
		dos.writeUTF(str);
		
		sc.shutdownOutput();
		
		if(str.equals("END")){
			sc.close();
			throw new Exception("客户端关闭连接");
		}
		
	}
	
	public static void receive(Socket sc) throws IOException{
		DataInputStream dis=new DataInputStream(sc.getInputStream());
		String str1=dis.readUTF();
		System.out.println("服务端发来消息---"+str1);
		
		sc.shutdownInput();
		
	}
	
}
