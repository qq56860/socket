package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.midi.Receiver;
	/*
	 * socket.shutdownoutput  和 关闭流  .close
	 * 
	 * 直接把socket产生的流关闭的话，那么socket也会随之关闭
	 * 一般不用关闭流，直接关闭socket即可
	 * 
	 * 如果执行shutdownOutput()，客户端socket只是处于半关闭状态
	 * 仍然可以和Server端交互，不会产生异常
	 * 
	 * */
public class ServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8000);//创建ServerSocket对象，绑定监听端口
		
		
		while(true){
			Socket sc=ss.accept();//通过accept()方法监听客户端请求
			receive(sc);
			send(sc);
		}
	}
	
	public static void receive(Socket sc) throws IOException{		
		
		DataInputStream dis=new DataInputStream(sc.getInputStream());	
		//连接建立后，通过输入流读取客户端发送的请求信息
		
		String str=dis.readUTF();
		System.out.println("客户发送---"+str);

		sc.shutdownInput();
		//dis.close();
		//sc.close();
		//ss.close();		
	}
	
	
	
	public static void send(Socket sc) throws IOException{
		
		System.out.println("输入---");	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//通过输出流向客户端发送响应信息
		String str1=br.readLine();
		
		DataOutputStream dos =new DataOutputStream(sc.getOutputStream());
		dos.writeUTF(str1);
		
		sc.shutdownOutput();
		//br.close();
		//dos.close();	
		//sc.close();	
	}
	
}
