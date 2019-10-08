package 小学生考试系统;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class defahgrsagtwsgrw {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					defahgrsagtwsgrw window = new defahgrsagtwsgrw();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public defahgrsagtwsgrw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame("广州市X小学数学考试自动系统");
		frame.setBounds(600, 250,510,400);
		Container c = frame.getContentPane();
		frame.getContentPane().setLayout(null);
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
		panel_main.setBounds(0, 0, 0, 0);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 474, 259);
		frame.getContentPane().add(panel);
		frame.setVisible(true);	}
}
