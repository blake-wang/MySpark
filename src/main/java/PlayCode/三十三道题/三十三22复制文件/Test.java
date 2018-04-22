package PlayCode.三十三道题.三十三22复制文件;package ��ʮ��22�����ļ�;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	/**
	 * ����һ���ļ��е���һ��Ŀ¼��.

	�����ļ���,������Ҫ�뵽�ݹ�.��Ϊ�ļ�����һ�����Ŀ¼.
	���,��εݹ���?�ݹ�ʲô?��Ȼ,ֻ�����ļ��е�ʱ��ŵݹ�,��ô�ж����ļ��л����ļ����Ǳ�Ҫ��.���ļ��о͵ݹ�,���ļ���������д.
	�ٴ�,�ļ��е��������ļ�������.���߶���Ҫ�ھ��ļ����ƺ����ļ�·������.������Ҫ֪��,�����ļ���ͨ��listFiles�����һ���ļ�ʱ��,��ʱ��,���Ǿ�Ҫ�뵽,
	���ļ��к;��ļ��е�·���Ѿ����һ����.

	˼��:
	������ѵ�������¾��ļ����ļ��е�·�����ͬ������.ÿ��listFiles֮��,�¾��ļ����ļ��о�����һ����εĲ��,������β�����һ����β�,ֻҪ֪��  --
	���ļ����ƺ����ļ�·������  -- �Ϳ�����.
	 * @throws IOException 
	*/


	public static void main(String[] args) throws IOException {
		File oldFile = new File("G:\\�����");
		File newFile = new File("F:\\");
		MyCopy(oldFile,newFile);
	}
	public static void MyCopy(File oldFile,File newFile) throws IOException{
		if(!oldFile.exists()){
			System.out.println("�ļ�������");
		}
		File f = new File(newFile.getPath()+"\\"+oldFile.getName());
		System.out.println("f:"+f);
		f.mkdir();
		File[] files = oldFile.listFiles();
		for (File file : files) {
			if(file.isDirectory()){
				MyCopy(file,f);
			}else{
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f.getPath()+"\\"+file.getName()));
				int b = 0;
				while((b=bis.read())!=-1){
					bos.write(b);
				}
				bis.close();
				bos.close();
				System.out.println(file.getName()+"������ɣ�");
			}
		}
	}
}
