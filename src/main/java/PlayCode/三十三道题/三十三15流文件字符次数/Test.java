package PlayCode.三十三道题.三十三15流文件字符次数;package ��ʮ��15���ļ��ַ�����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class Test {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("123.txt"));
		TreeMap<Character, Integer> tm = new TreeMap<Character,Integer>();
		String s;
		while ((s = br.readLine()) != null) {
			char[] c = s.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (tm.containsKey(c[i])) {
					tm.put(c[i], tm.get(c[i]) + 1);
				} else {
					tm.put(c[i], 1);
				}
			}
		}
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter("3315.txt"));
		Set<Character> keySet = tm.keySet();
		for (Character character : keySet) {
			bw.write(character + " : " + tm.get(character) + "��.");
		}
		bw.close();
	}
}
