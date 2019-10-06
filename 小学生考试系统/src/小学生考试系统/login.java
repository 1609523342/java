package 小学生考试系统;

import javax.swing.JOptionPane;

public class login {
	String name,major,Class;
	int results;
	public login(String name,String major,String Class,int results) {
		this.name = name;
		this.major = major;
		this.Class = Class;
		this.results = results;
	}
	public static boolean checklogin(String name,String major,String Class) {
		if((name.length()==0)||(major.length()==0)||(Class.length()==0)) {
			return false;
		}
		else{
			return true;
		}
	}
	public static void successlogin(String name,String major,String Class) {
		boolean context = checklogin(name, major, Class);
		if(context) {
			time.countdown();
		}
		else {
			JOptionPane.showMessageDialog(null, "请将信息填写完整", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
}
