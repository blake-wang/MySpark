package PlayCode.三十三道题.三十三09螺旋数组;package ��ʮ��09��������;

public class Test {
	/*9�� дһ��������ӡ�ȳ��Ķ�ά���飬Ҫ���1��ʼ����Ȼ���ɷ��������Ȧ����������ʽ��˳�����С� �磺 n = 4 ���ӡ��
	 1    2    3    4
	 12   13   14   5
	 11   16   15   6
	 10   9    8    7
	 * */


	public static void main(String[] args) {
		//�Ӽ����������0���������õ��������еĶ�ά����
		print(8);


	}
	//�õ������������ֵ����ӡ��ά����
	public static void print(int num){
		//����ȳ��Ķ�ά����
		int[][] arr = new int[num][num];
		int n = arr.length;  
        int count = 0;  
        int max = 0;
        recArr(arr,n,count,max);  
        printArr(arr);	  //ִ�д�ӡ  
	}
	public static void recArr(int[][] arr,int n,int count,int max){  
        //�ݹ��������  
        if(n>0){  
            //���������ֵ  
            int k = 0;  
            //(n-1)*4����ÿһȦ����ֵ��Χ  
            for(int i=0;i<(n-1)*4;i++){  
                //���ϱ߸�ֵ  
                if(i<n-1){  
                    arr[count+0][count+i] = ++max;  
                }  
                //���ұ߸�ֵ  
                else if(i<2*n-2){  
                    arr[count+k++][arr.length-1-count]=++max;  
                }  
                //���±߸�ֵ  
                else if(i<3*n-3){  
                    arr[arr.length-1-count][(k--)+count]=++max;  
                }  
                //����߸�ֵ  
                else if(i<4*n-4){  
                    arr[arr.length-1-(k++)-count][0+count]=++max;     
                }  
            }  
            //��nΪ����ʱ������n=1�����������Ȧֻ��һ����  
            if(n==1){  
                arr[arr.length/2][arr.length/2]=max+1;  
            }  
            //����Ȧ��  
            count++;  
            //�߽�ÿ�μ���������ֵ  
            n -= 2;  
            //�ݹ�  
            recArr(arr,n,count,max);  
        }  
    }  
    //��ӡ��ά����  
    public static void printArr(int[][] arr){  
        //��ά������Ҫ˫��ѭ����ӡ  
        for(int[] ar : arr){  
            for(int a : ar){  
                if(a<10)  
                    System.out.print(" "+a+" ");  
                else  
                    System.out.print(a+" ");  
            }  
            System.out.println();  
        }  
    }  
}


