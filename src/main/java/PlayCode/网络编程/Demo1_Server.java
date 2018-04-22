package PlayCode.网络编程;package ������;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {

	/**
	 * * 2.����� ����ServerSocket(��Ҫָ���˿ں�)
	 * ����ServerSocket��accept()��������һ���ͻ������󣬵õ�һ��Socket
	 * ����Socket��getInputStream()��getOutputStream()������ȡ�Ϳͻ���������IO��
	 * ���������Զ�ȡ�ͻ��������д�������� ���������д�����ݵ��ͻ��˵�������
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("�������Ѿ��������󶨶˿�12345");
		//���ܿͻ��˵�����
		Socket socket = server.accept();
		//��ȡ�ͻ���������
		InputStream is = socket.getInputStream();
		//��ȡ�ͻ��˵������
		OutputStream os = socket.getOutputStream();
		//��������ͻ���д������
		os.write("�ٶ�һ�����֪��".getBytes());
		byte[] arr = new byte[1024];
		//��ȡ�ͻ��˷�����������
		int len = is.read(arr);
		//������ת�����ַ�������ӡ
		System.out.println(new String(arr,0,len));
		socket.close();
		

	}

}
