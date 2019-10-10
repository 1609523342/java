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
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 20, 108, 30);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 73, 108, 30);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 126, 108, 30);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(157, 20, 108, 30);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(157, 73, 108, 30);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(157, 126, 108, 30);
		frame.getContentPane().add(panel_5);
		Thread times_Thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					countdown(5400, countdowns);
			}
			
		});
		times_Thread.start();
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
		frame.setVisible(true);	}
}
