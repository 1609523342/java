package 小学生考试系统;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jframe extends JFrame{
	JTextField names;
	JTextField majors;
	JTextField Classes;
	JLabel countdowns;
	JFrame frame;
	List<JPanel>panellist = new ArrayList<>();
	List<JTextField>answerlist = new ArrayList<>();
	List<JLabel>subjectlist = new ArrayList<>();
	List<String>rightkey = new ArrayList<>();
	/*
	 * 登录界面
	 */
	public jframe() {
		this.setBounds(800, 400,350,150);
		this.setTitle("广州市X小学数学考试自动系统");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		JLabel name = new JLabel("姓名");
		name.setFont(new Font("楷体",Font.BOLD,15));
		JTextField names = new JTextField();
		names.setColumns(23);
		JLabel major = new JLabel("专业");
		major.setFont(new Font("楷体",Font.BOLD,15));
		JTextField majors = new JTextField();
		majors.setColumns(23);
		JLabel Class = new JLabel("班级");
		Class.setFont(new Font("楷体",Font.BOLD,15));
		JTextField Classes = new JTextField();
		Classes.setColumns(23);
		JButton began = new JButton("开始考试");
		c.add(name);
		c.add(names);
		c.add(major);
		c.add(majors);
		c.add(Class);
		c.add(Classes);
		c.add(began);
		began.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				successlogin(names.getText(), majors.getText(),Classes.getText());
			}
		});
		this.setVisible(true);
	}
	/*
	 * 登录信息不完整提示框
	 */
	public  void successlogin(String name,String major,String Class) {
		boolean context = login.checklogin(name, major, Class);
		if(context) {
			GUIscreen();
		}
		else {
			JOptionPane.showMessageDialog(null, "请将信息填写完整", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * 产生试题以及存储正确答案
	 */
	public void showsubject() {
		for(int a = 0;a<50;a++) {
			math maths = new math();
			maths.number();
			JLabel subject = new JLabel(maths.printnumber());
			subjectlist.add(subject);
			rightkey.add(String.valueOf(maths.g));
		}
	}
	
	/*
	 * 考试界面
	 */
	public  void GUIscreen() {
		int y_subject= 0;
		int y_answer=0;
		int panel_number = 0;
		showsubject();
		//创建主页面
		JFrame frame = new JFrame("广州市X小学数学考试自动系统");
		frame.getContentPane().setLayout(null);
		frame.setBounds(600, 250,510,400);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		//创建计时页面以及实现新线程接口
		JLabel countdowns = new JLabel();
		countdowns.setBounds(20, 325, 140, 26);
		frame.getContentPane().add(countdowns);
		Thread times_Thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					countdown(5400, countdowns);
			}
			
		});
		times_Thread.start();//线程启动
		
		//创建卡式结构主页面
		JPanel panel_main = new JPanel();
		panel_main.setBounds(10, 10, 474, 259);
		CardLayout cardlayout = new CardLayout();
		panel_main.setLayout(cardlayout);
		c.add(panel_main);
		for(int a=0;a<10;a++) {
			JPanel cardpanel = new JPanel();
			panellist.add(cardpanel);
		}
		for(int b=0;b<50;b++) {
			JLabel label = subjectlist.get(b);
			label.setBounds(79,y_subject, 136, 29);
			JTextField answer = new JTextField();
			answer.setBounds(269, y_answer, 136, 29);
			answerlist.add(answer);
			y_subject+=50;
			y_answer+=50;
			panellist.get(panel_number).setLayout(null);
			panellist.get(panel_number).add(label);
			panellist.get(panel_number).add(answer);
			if((b+1)%5==0&&b!=49) {
				y_subject=0;
				y_answer=0;
				panel_number++;
			}
		}
		for(int d = 0;d<panellist.size();d++) {
			panel_main.add(panellist.get(d));
		}
		
		
		
		
		JButton b1 = new JButton("首页");
		b1.setBounds(10, 286, 121, 29);
		frame.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.first(panel_main);
			}
		});
		
		
		JButton b2 = new JButton("上一页");
		b2.setBounds(129, 286, 121, 29);
		frame.getContentPane().add(b2);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.previous(panel_main);
			}
			
		});
		
		JButton b3 = new JButton("下一页");
		b3.setBounds(245, 286, 121, 29);
		frame.getContentPane().add(b3);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.next(panel_main);}
		});
		
		
		JButton b4 = new JButton("尾页");
		b4.setBounds(363, 286, 121, 29);
		frame.getContentPane().add(b4);
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.last(panel_main);
			}
		});
		JButton submit = new JButton("提交");
		submit.setBounds(218, 325, 130, 26);
		frame.getContentPane().add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				times_Thread.interrupt();
				
			}
		});
		frame.setVisible(true);
	}
	/*
	 * 考试结束之后的结果显示界面和历史界面
	 */
	public void after_test() {
		JFrame frame = new JFrame("广州市X小学数学考试自动系统");
		frame.getContentPane().setLayout(null);
		frame.setBounds(600, 250,510,400);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
 	public static  void countdown(int endtime, JLabel countdowns1){
		StringBuilder times = new StringBuilder();
		while(endtime>0){
			endtime--;				
			int hour = endtime/60/60%60;
			int minute = endtime/60%60;
			int second = endtime%60;
			times.append("还剩");
			times.append(hour);
			times.append("小时");
			times.append(minute);
			times.append("分钟");
			times.append(second);
			times.append("秒");
			countdowns1.setText(times.toString());
			countdowns1.updateUI();
			times = new StringBuilder();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
	public String getresult() {
		int b = 0;
		for(int a = 0;a<50;a++) {
			if(answerlist.get(a).getText()==rightkey.get(a)) {
				b++;
			}
			else {
				continue;
			}
		}
		String score = String.valueOf(b*2);
		return score;
	}
	public void save_information() {
		login login = new login(names.getText(),majors.getText(),Classes.getText(),getresult());
	}
}
