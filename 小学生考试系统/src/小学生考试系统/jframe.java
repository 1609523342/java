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
	public static void logins() {
		jframe f = new jframe();
	}
	static JLabel countdowns;
	static JFrame frame;
	public void shownumber() {

	}
	public  void successlogin(String name,String major,String Class) {
		boolean context = login.checklogin(name, major, Class);
		if(context) {
			GUIscreen();
		}
		else {
			JOptionPane.showMessageDialog(null, "请将信息填写完整", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
	public  void GUIscreen() {
		List<JPanel>list = new ArrayList<>();
		List<Object>answer_exam = new ArrayList<>();
		List<JTextField>tf_exam = new ArrayList<>();
		
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(600, 250,500,500);

		JLabel countdowns = new JLabel();
		countdowns.setBounds(200, 13, 200, 31);
		frame.getContentPane().add(countdowns);
		Thread times_Thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					countdown(5400, countdowns);
			}
			
		});
		times_Thread.start();
		
		

		
		
		JPanel panel_exam = new JPanel();
		CardLayout cardlayout = new CardLayout();
		panel_exam.setLayout(cardlayout);
		
		
		JLabel lblNewLabel = new JLabel("第一题");
		lblNewLabel.setBounds(10, 7, 173, 31);
		panel_exam.add(lblNewLabel);
		
		JLabel label = new JLabel("第二题");
		label.setBounds(10, 57, 173, 31);
		panel_exam.add(label);
		
		JLabel label_1 = new JLabel("第三题");
		label_1.setBounds(10, 107, 173, 31);
		panel_exam.add(label_1);
		
		JLabel label_2 = new JLabel("第四题");
		label_2.setBounds(10, 157, 173, 31);
		panel_exam.add(label_2);
		
		JLabel label_3 = new JLabel("第五题");
		label_3.setBounds(10, 207, 173, 31);
		panel_exam.add(label_3);
		
		JTextField textField = new JTextField();
		textField.setBounds(258, 7, 112, 31);
		panel_exam.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(258, 57, 112, 31);
		panel_exam.add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(258, 107, 112, 31);
		panel_exam.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(258, 157, 112, 31);
		panel_exam.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(258, 207, 112, 31);
		panel_exam.add(textField_4);
		
		
		JButton b1 = new JButton("首页");
		b1.setBounds(10, 286, 121, 29);
		frame.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.first(panel_exam);
			}
		});
		
		
		JButton b2 = new JButton("上一页");
		b2.setBounds(129, 286, 121, 29);
		frame.getContentPane().add(b2);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.previous(panel_exam);
			}
			
		});
		
		JButton b3 = new JButton("下一页");
		b3.setBounds(245, 286, 121, 29);
		frame.getContentPane().add(b3);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.next(panel_exam);}
		});
		
		
		JButton b4 = new JButton("尾页");
		b4.setBounds(363, 286, 121, 29);
		frame.getContentPane().add(b4);
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.last(panel_exam);
			}
		});
		frame.setVisible(true);
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
}
