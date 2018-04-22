package PlayCode.Demo.打印;
/*
1+2+3+4+5+6+7+8+9+10=55
21+22+23+24+25+26+27+28+29+30=255
....
90+91+..............+100=955
*/

class Demo2 {
	public static void main(String[] args) {
		   
	     for(int i=1;i<=100;i+=10){
			   int sum=0;
			 for(int j=i;j<=(i+9);j++){
				if(j!=(i+9)){
					System.out.print(j+"+");
					sum+=j;
				}
				
				else{
					sum = sum + j;
					System.out.print(j+"="+sum);
				}
				 
			 }System.out.println();
	     }
	}
}
