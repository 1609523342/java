package 小学生考试系统;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class djh {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					djh window = new djh();
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
	public djh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		CardLayout card=new CardLayout();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 414, 123);
		frame.getContentPane().add(panel);
		panel.setLayout(card);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 20, 99, 21);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 70, 99, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(192, 20, 99, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(192, 70, 99, 21);
		panel.add(label_2);
		
		JButton button_1 = new JButton("首页");
		button_1.setBounds(117, 189, 93, 23);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1){
					card.first(panel);
				}
			}
		});
		
		JButton button = new JButton("上一页");
		button.setBounds(25, 189, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_3 = new JButton("下一页");
		button_3.setBounds(300, 189, 93, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_2 = new JButton("尾页");
		button_2.setBounds(208, 189, 93, 23);
		frame.getContentPane().add(button_2);
	}
}
