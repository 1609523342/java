package Сѧ������ϵͳ;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIscreen {
	public GUIscreen() {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(600, 250,600,600);

		JLabel countdowns = new JLabel();
		countdowns.setBounds(365, 13, 198, 31);
		frame.getContentPane().add(countdowns);
		Thread times_Thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					countdown(5400, countdowns);
			}
			
		});
		times_Thread.start();
		frame.setVisible(true);
	}
	public static  void countdown(int endtime, JLabel countdowns1){
		StringBuilder times = new StringBuilder();
		while(endtime>0){
			endtime--;				
			int hour = endtime/60/60%60;
			int minute = endtime/60%60;
			int second = endtime%60;
			times.append("��ʣ");
			times.append(hour);
			times.append("Сʱ");
			times.append(minute);
			times.append("����");
			times.append(second);
			times.append("��");
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
