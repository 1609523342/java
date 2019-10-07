package 小学生考试系统;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		math a = new math();
		for(i=0;i<50;i++){
			while(a.g<0){
				a.number();
			}
			System.out.println(a.printnumber());
			a.key[i] = a.g;
			a.g=-1;
		} 
		//jframe.logins();
	
		jframe ab = new jframe();
	}

}
