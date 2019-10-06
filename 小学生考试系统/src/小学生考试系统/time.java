package 小学生考试系统;

public class time {
	static int endtime = 90*60;
	 public static void countdown(){
		 while(endtime>0){
			 endtime--;
			 try {
				Thread.sleep(1000);
				int hour = endtime/60/60%60;
				int minute = endtime/60%60;
				int second = endtime%60;
				System.out.println("还剩"+hour+"小时"+minute+"分钟"+second+"秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
}
