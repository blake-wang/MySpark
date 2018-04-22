package PlayCode.Demo.打印;
//1+2+3+4+5+6+7+8+9+10=55
//21+22+23+24+25+26+27+28+29+30=255
//....
//90+91+..............+100=955
//*/

class Demo1 {
	public static void main(String[] args) {
		int res=0;
		for(int i=1;i<=100;i++){
			if(i%10!=0){
				res+=i;
				System.out.print(i+"+");
			}else{
				res+=i;
				System.out.println(i+"="+res);
				res=0;
			}
		}
	}
}


