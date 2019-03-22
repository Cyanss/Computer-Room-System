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
//�˶�����
public class Jframe3 {
	final SetTime s=new SetTime();
	final String nations1[]={"����һ","���ڶ�","������","������","������","������","������" };
	final String nations2[]={"��һ���","�ڶ����","  ��  ��  ","�������","���Ĵ��","  ��  ��  " };
	final String nations3[]={"08:30-10:05 ","10:35-12:10","12:20-13:40 ","14:00-10:35 ","16:05-17:40","18:30-20:00" };
	final String nations4[]={"��һ��","�ڶ���","������","������","������","������","������","�ڰ���","�ھ���","��ʮ��","��ʮһ��","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","�ڶ�ʮ��" };
	final String nations5[]={"һ�Ż���","���Ż���","���Ż���","�ĺŻ���","��Ż���","���Ż���","�ߺŻ���" };
	final String nations6[]={"��  ��  ϵ","��е����ϵ","��  ��  ϵ","��Ϣ����ϵ","��  ѧ  ϵ","������ýϵ" };
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
			final JFrame jFrame = new JFrame("�������ƹ�����");
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setBounds(((int)dimension.getWidth() - 540) / 2, ((int)dimension.getHeight() - 400) / 2,540, 300);
			jFrame.setResizable(false);
			jFrame.setLayout(null);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel label_biaoti = new JLabel("��ԭ��ѧԺ��Ϣ����ѧԺ");//����
			label_biaoti.setBounds(40, 5, 200, 30);
			jFrame.add(label_biaoti);
	
			JLabel label= new JLabel("�����˶�");
			label.setFont(new   java.awt.Font(null,   1,   22));
			label.setForeground(Color.red);
			label.setBounds(220, 20, 100, 30);
			jFrame.add(label);
			JLabel label_riqi= new JLabel("���ڣ�"+s.getDate());
			label_riqi.setBounds(380, 40, 150, 30);
			jFrame.add(label_riqi);
			
			JLabel label_zhouci=new JLabel(" �� �Σ�"); 
			label_zhouci.setFont(new   java.awt.Font("����",   1,   18));
			label_zhouci.setBounds(20, 80, 100, 40);
			jFrame.add(label_zhouci);
			
			jcb=new JComboBox<Object>(nations4);
			jcb.setMaximumRowCount(3);
			jcb.setFont(new   java.awt.Font("����",   1,   16));
			jcb.setBounds(95, 85, 100, 30);
			jFrame.add(jcb);
			
			JLabel label2 = new JLabel("�ڴΣ�");
			label2.setFont(new   java.awt.Font("����",   1,   18));
			label2.setBounds(230, 80, 100, 40);
			jFrame.add(label2);

			jcb1=new JComboBox<Object>(nations1);
			jcb1.setMaximumRowCount(3);
			jcb1.setFont(new   java.awt.Font("����",   1,   16));
			jcb1.setBounds(295, 85, 100, 30);
			jFrame.add(jcb1);
	
			JLabel label_jieci = new JLabel(" �� �Σ�");
			label_jieci.setFont(new   java.awt.Font("����",   1,   18));
			label_jieci.setBounds(20, 140, 100, 40);
			jFrame.add(label_jieci);

			jcb2=new JComboBox<Object>(nations2);
			jcb2.setMaximumRowCount(3);
			jcb2.setFont(new   java.awt.Font("����",   1,   16));
			jcb2.setBounds(95, 145, 100, 30);
			jFrame.add(jcb2);
			
			JLabel label_jifang=new JLabel("����:"); 
			label_jifang.setFont(new   java.awt.Font("����",   1,   18));
			label_jifang.setBounds(230, 140, 100, 40);
			jFrame.add(label_jifang);
			
			jcb5=new JComboBox<Object>(nations5);
			jcb5.setMaximumRowCount(3);
			jcb5.setFont(new   java.awt.Font("����",   1,   16));
			jcb5.setBounds(295, 145, 100, 30);
			jFrame.add(jcb5);
			
			JButton button3 = new JButton("��ѯ");
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
					JOptionPane.showMessageDialog(null, "��ѯ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					if(service.getAp().getState()==0){
	
						JOptionPane.showMessageDialog(null, "��δԤԼ , �޷��˶�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "�Ѿ�ԤԼ�������˶�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			JButton button4 = new JButton("�˶�");
			button4.setBounds(150, 210, 70, 25);
	
			JButton button5 = new JButton("����");
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
					
					
						JOptionPane.showMessageDialog(null, "��δԤԼ , �޷��˶���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else if(jframe5.getpS().isPasswordState()){
							JOptionPane.showMessageDialog(null, "������֤����Ϣ���ٴε����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);	
							jframe5.SetJframe5();
						}else{
							service.deleteAppointment(appointment.getTime(), appointment.getWeek(), appointment.getDate(), appointment.getRoom());
							JOptionPane.showMessageDialog(null, "�˶��ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);	
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
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			});
			jFrame.add(button3);
			jFrame.add(button4);
			jFrame.add(button5);
			String path = ".\\images\\xiaohui.gif";//��ӱ���
			ImageIcon background = new ImageIcon(path); 
			JLabel label0 = new JLabel(background);
			label0.setBounds(0, 0, 40, 40);
			jFrame.add(label0);
			String path1 = ".\\images\\tuiding.jpg";//��ӱ���
			ImageIcon  image= new ImageIcon(path1); 
			JLabel label11 = new JLabel(image);
			label11.setBounds(0, 0, 540, 300);
			jFrame.add(label11);
			jFrame.setVisible(true);
		}
}
