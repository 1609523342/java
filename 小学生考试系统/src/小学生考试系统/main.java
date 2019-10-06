package 小学生考试系统;

import javax.swing.JLabel;

public class main {

	public static void main(String[] args) {
		int i,j;
		math a = new math();
		for(i=0;i<50;i++){
			while(a.g<0){
				a.number();
			}
			System.out.print(a.a);
			System.out.print(a.symbol[a.d]);
			System.out.print(a.b);
			System.out.print(a.symbol[a.e]);
			System.out.println(a.c);
			a.key[i] = a.g;
			a.g=-1;
		} 
		jframe.logins();
	}
	JLabel[] ab = new JLabel[10];
}
