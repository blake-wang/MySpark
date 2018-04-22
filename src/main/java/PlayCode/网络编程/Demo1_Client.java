package PlayCode.网络编程;package ������;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo1_Client {

	/**
	 * * 1.�ͻ��� ����Socket���ӷ����(ָ��ip��ַ,�˿ں�)ͨ��ip��ַ�Ҷ�Ӧ�ķ�����
	 * ����Socket��getInputStream()��getOutputStream()������ȡ�ͷ����������IO��
	 * ���������Զ�ȡ����������д�������� ���������д�����ݵ�����˵�������
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		//��ȡ�ͻ���������
		InputStream is = socket.getInputStream();
		//��ȡ�ͻ��˵������
		OutputStream os = socket.getOutputStream();
		byte[] arr = new byte[1024];
		//��ȡ������������������
		int len = is.read(arr);
		//������ת�����ַ�������ӡ
		System.out.println(new String(arr,0,len));
		//�ͻ���������д����
		os.write("ѧϰ����ļ�ǿ��".getBytes());
		socket.close();
		
		

	}

}
