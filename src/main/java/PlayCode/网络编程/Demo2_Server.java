package PlayCode.网络编程;package ������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {

	/**
	 * * 2.�����
	* ����ServerSocket(��Ҫָ���˿ں�)
	* ����ServerSocket��accept()��������һ���ͻ������󣬵õ�һ��Socket
	* ����Socket��getInputStream()��getOutputStream()������ȡ�Ϳͻ���������IO��
	* ���������Զ�ȡ�ͻ��������д��������
	* ���������д�����ݵ��ͻ��˵�������
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		ServerSocket server = new ServerSocket(12345);
		while(true){
			final Socket socket = server.accept();
			new Thread(){
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						ps.println("��ӭ��ѯ�������Ա��");
						System.out.println(br.readLine());
						ps.println("������˼��������!");
						System.out.println(br.readLine());
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				};
			}.start();
		}
		
	}

	private static void demo1() throws IOException {
		ServerSocket server = new ServerSocket(12345);
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("��ӭ��ѯ�������Ա");
		System.out.println(br.readLine());
		ps.println("������˼������");
		System.out.println(br.readLine());
		socket.close();
	}
}
