package com;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.ExplainSrc.Explain;
import com.objectinfo.Appointment;
import com.service.Service;
//退订窗口
public class Jframe3 {
	final SetTime s=new SetTime();
	final String nations1[]={"星期一","星期二","星期三","星期四","星期五","星期六","星期日" };
	final String nations2[]={"第一大节","第二大节","  中  午  ","第三大节","第四大节","  晚  上  " };
	final String nations3[]={"08:30-10:05 ","10:35-12:10","12:20-13:40 ","14:00-10:35 ","16:05-17:40","18:30-20:00" };
	final String nations4[]={"第一周","第二周","第三周","第四周","第五周","第六周","第七周","第八周","第九周","第十周","第十一周","第十二周","第十三周","第十四周","第十五周","第十六周","第十七周","第十八周","第十九周","第二十周" };
	final String nations5[]={"一号机房","二号机房","三号机房","四号机房","五号机房","六号机房","七号机房" };
	final String nations6[]={"外  语  系","机械工程系","会  计  系","信息技术系","商  学  系","政法传媒系" };
	static JComboBox<?> jcb=new JComboBox<Object>();
	static JComboBox<?> jcb1=new JComboBox<Object>();
	static JComboBox<?> jcb2=new JComboBox<Object>();
	static JComboBox<?> jcb3=new JComboBox<Object>();
	static JComboBox<?> jcb4=new JComboBox<Object>();
	static JComboBox<?> jcb5=new JComboBox<Object>();
	static JComboBox<?> jcb6=new JComboBox<Object>();
	Jframe5 jframe5=new Jframe5();
	Service service =new Service();
	private Appointment appointment;
	void SetJframe3(){
			final JFrame jFrame = new JFrame("漫步青云工作室");
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setBounds(((int)dimension.getWidth() - 540) / 2, ((int)dimension.getHeight() - 400) / 2,540, 300);
			jFrame.setResizable(false);
			jFrame.setLayout(null);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel label_biaoti = new JLabel("中原工学院信息商务学院");//标题
			label_biaoti.setBounds(40, 5, 200, 30);
			jFrame.add(label_biaoti);
	
			JLabel label= new JLabel("机房退订");
			label.setFont(new   java.awt.Font(null,   1,   22));
			label.setForeground(Color.red);
			label.setBounds(220, 20, 100, 30);
			jFrame.add(label);
			JLabel label_riqi= new JLabel("日期："+s.getDate());
			label_riqi.setBounds(380, 40, 150, 30);
			jFrame.add(label_riqi);
			
			JLabel label_zhouci=new JLabel(" 周 次："); 
			label_zhouci.setFont(new   java.awt.Font("黑体",   1,   18));
			label_zhouci.setBounds(20, 80, 100, 40);
			jFrame.add(label_zhouci);
			
			jcb=new JComboBox<Object>(nations4);
			jcb.setMaximumRowCount(3);
			jcb.setFont(new   java.awt.Font("黑体",   1,   16));
			jcb.setBounds(95, 85, 100, 30);
			jFrame.add(jcb);
			
			JLabel label2 = new JLabel("期次：");
			label2.setFont(new   java.awt.Font("黑体",   1,   18));
			label2.setBounds(230, 80, 100, 40);
			jFrame.add(label2);

			jcb1=new JComboBox<Object>(nations1);
			jcb1.setMaximumRowCount(3);
			jcb1.setFont(new   java.awt.Font("黑体",   1,   16));
			jcb1.setBounds(295, 85, 100, 30);
			jFrame.add(jcb1);
	
			JLabel label_jieci = new JLabel(" 节 次：");
			label_jieci.setFont(new   java.awt.Font("黑体",   1,   18));
			label_jieci.setBounds(20, 140, 100, 40);
			jFrame.add(label_jieci);

			jcb2=new JComboBox<Object>(nations2);
			jcb2.setMaximumRowCount(3);
			jcb2.setFont(new   java.awt.Font("黑体",   1,   16));
			jcb2.setBounds(95, 145, 100, 30);
			jFrame.add(jcb2);
			
			JLabel label_jifang=new JLabel("机房:"); 
			label_jifang.setFont(new   java.awt.Font("黑体",   1,   18));
			label_jifang.setBounds(230, 140, 100, 40);
			jFrame.add(label_jifang);
			
			jcb5=new JComboBox<Object>(nations5);
			jcb5.setMaximumRowCount(3);
			jcb5.setFont(new   java.awt.Font("黑体",   1,   16));
			jcb5.setBounds(295, 145, 100, 30);
			jFrame.add(jcb5);
			
			JButton button3 = new JButton("查询");
			button3.setBounds(440, 80,70, 100);
			button3.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) {
					Explain exp=new Explain();
					appointment=new Appointment();
					appointment.setTime(exp.explainTime((String) jcb.getSelectedItem()));	
					appointment.setWeek(exp.explainWeek((String) jcb1.getSelectedItem()));
					appointment.setDate(exp.explainDate((String) jcb2.getSelectedItem()));
					appointment.setRoom(exp.explainRoom((String) jcb5.getSelectedItem()));
					service.getAppointment_1(appointment.getTime(), appointment.getWeek(), appointment.getDate(), appointment.getRoom());
					JOptionPane.showMessageDialog(null, "查询成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					if(service.getAp().getState()==0){
	
						JOptionPane.showMessageDialog(null, "尚未预约 , 无法退订", "提示", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "已经预约，可以退订", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			JButton button4 = new JButton("退订");
			button4.setBounds(150, 210, 70, 25);
	
			JButton button5 = new JButton("返回");
			button5.setBounds(300, 210, 70, 25);
			
			button4.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Explain exp=new Explain();
					appointment=new Appointment();
					appointment.setTime(exp.explainTime((String) jcb.getSelectedItem()));	
					appointment.setWeek(exp.explainWeek((String) jcb1.getSelectedItem()));
					appointment.setDate(exp.explainDate((String) jcb2.getSelectedItem()));
					appointment.setRoom(exp.explainRoom((String) jcb5.getSelectedItem()));
					service.getAppointment_1(appointment.getTime(), appointment.getWeek(), appointment.getDate(), appointment.getRoom());
					if(service.getAp().getState()==0){
					
					
						JOptionPane.showMessageDialog(null, "尚未预约 , 无法退订！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}else if(jframe5.getpS().isPasswordState()){
							JOptionPane.showMessageDialog(null, "请输验证过信息后再次点击！", "提示", JOptionPane.INFORMATION_MESSAGE);	
							jframe5.SetJframe5();
						}else{
							service.deleteAppointment(appointment.getTime(), appointment.getWeek(), appointment.getDate(), appointment.getRoom());
							JOptionPane.showMessageDialog(null, "退订成功！", "提示", JOptionPane.INFORMATION_MESSAGE);	
						}			
				}
			});
			button5.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) {
					jFrame.dispose();
					Jframe1 jframe1=new Jframe1();
					try {
						jframe1.SetJframe1();
					} catch (ParseException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			});
			jFrame.add(button3);
			jFrame.add(button4);
			jFrame.add(button5);
			String path = ".\\images\\xiaohui.gif";//添加背景
			ImageIcon background = new ImageIcon(path); 
			JLabel label0 = new JLabel(background);
			label0.setBounds(0, 0, 40, 40);
			jFrame.add(label0);
			String path1 = ".\\images\\tuiding.jpg";//添加背景
			ImageIcon  image= new ImageIcon(path1); 
			JLabel label11 = new JLabel(image);
			label11.setBounds(0, 0, 540, 300);
			jFrame.add(label11);
			jFrame.setVisible(true);
		}
}
