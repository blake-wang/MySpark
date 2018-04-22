package PlayCode.网络编程;package ������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo2_Client {


	/**
	 * * 1.�ͻ���
		* ����Socket���ӷ����(ָ��ip��ַ,�˿ں�)ͨ��ip��ַ�Ҷ�Ӧ�ķ�����
		* ����Socket��getInputStream()��getOutputStream()������ȡ�ͷ����������IO��
		* ���������Զ�ȡ����������д��������
		* ���������д�����ݵ�����˵�������
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",12345);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		System.out.println(br.readLine());
		ps.println("���뱨���������Ա");
		System.out.println(br.readLine());
		ps.println("��ޣ������ܲ��ܸ��λ���");
		socket.close();
	}
}
