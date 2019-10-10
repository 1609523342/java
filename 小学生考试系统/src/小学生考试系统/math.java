package 小学生考试系统;

import java.util.Random;

public class math {
	int a,b,c,d=0,e=0,f,g=-1;
	int[] key = new int[50];
	int[] answer = new int[50];
	String Formula;
	String[] symbol = {"1","+","-"};
	public void number(){ 
		Random r = new Random();
			a = r.nextInt(101);
			b = r.nextInt(101);
			c = r.nextInt(101);
			d = r.nextInt(3);
			e = r.nextInt(3);
			while((d!=1)&&(d!=2)){
				d = r.nextInt(3);
			}
			while((e!=1)&&(e!=2)){
				e = r.nextInt(3);
			}
			if(symbol[d].equals("+")){
				f=a+b;
			}
			else{
				f=a-b;
			}
			if(symbol[e].equals("+")){
				g=f+c;
			}
			else{
				g=f-c;
			}
	}
	public  String printnumber() {
		StringBuilder printfnumber = new StringBuilder();
		printfnumber.append(a);
		printfnumber.append(symbol[d]);
		printfnumber.append(b);
		printfnumber.append(symbol[e]);
		printfnumber.append(c);
		String a = String.valueOf(printfnumber);
		return a;
	}
}