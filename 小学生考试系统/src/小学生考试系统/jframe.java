package 小学生考试系统;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class jframe extends JFrame {
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
				login.successlogin(names.getText(), majors.getText(),Classes.getText());
			}
		});
		this.setVisible(true);
		
	}
	public static void logins() {
		jframe f = new jframe();
	}
}
