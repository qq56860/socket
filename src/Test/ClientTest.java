package Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.midi.Receiver;

public class ClientTest {

	public static void main(String[] args) throws IOException {
		
		
		while(true){	
			Socket sc=new Socket("127.0.0.1",8000);
			//创建Socket对象，指明需要连接的服务器的地址和端口号
			
			send(sc);
			receive(sc);
		}
		
	}
	
	
	public static void send(Socket sc) throws IOException{
		DataOutputStream dos =new DataOutputStream(sc.getOutputStream());
		System.out.println("输入---");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		//连接建立后，通过输出流想服务器端发送请求信息
		
		String str=br.readLine();
		dos.writeUTF(str);

		//sc.shutdownOutput();
		//br.close();
		sc.shutdownOutput();
		//dos.close();
		//sc.close();
	}
	
	
	
	public static void receive(Socket sc) throws IOException{	
		DataInputStream dis=new DataInputStream(sc.getInputStream());		
		//通过输入流获取服务器响应的信息
		
		String str=dis.readUTF();
		System.out.println("服务端发送---"+str);
		
		sc.shutdownInput();
		//关闭响应资源
		
		
		//dis.close();
		//ss.close();
		//sc.close();
		
	}
}
