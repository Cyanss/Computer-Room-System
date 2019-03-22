package com;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ExplainSrc.Explain;
import com.objectinfo.Appointment;
import com.objectinfo.PasswordState;
import com.service.Service;
//Ԥ������
public class Jframe2 {
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
	static PasswordState ps;
	Jframe5 jframe5=new Jframe5();
	Service service =new Service();
	private Appointment appointment;
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
		void SetJframe2(){
			final JFrame jFrame2 = new JFrame("�������ƹ�����");
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			jFrame2.setBounds(((int)dimension.getWidth() - 600) / 2, ((int)dimension.getHeight() - 400) / 2,540, 300);
			jFrame2.setResizable(false);
			jFrame2.setLayout(null);
			jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel label_biaoti = new JLabel("��ԭ��ѧԺ��Ϣ����ѧԺ");//����
			label_biaoti.setBounds(40, 5, 200, 30);
			jFrame2.add(label_biaoti);
	
			JLabel label= new JLabel("ԤԼ����");
			label.setFont(new   java.awt.Font(null,   1,   22));
			label.setForeground(Color.red);
			label.setBounds(230, 10, 100, 30);
			jFrame2.add(label);
			
			JLabel label_riqi= new JLabel("���ڣ�"+s.getDate());
			label_riqi.setBounds(380, 10, 150, 30);
			jFrame2.add(label_riqi);
			
			JLabel label_zhouci=new JLabel("�ܴ�:"); 
			label_zhouci.setBounds(20, 40, 50, 30);
			jFrame2.add(label_zhouci);
			
			jcb=new JComboBox<Object>(nations4);
			jcb.setMaximumRowCount(3);
			jcb.setBounds(70, 45, 80, 20);
			jFrame2.add(jcb);
			
			jcb1=new JComboBox<Object>(nations1);
			jcb1.setMaximumRowCount(3);
			jcb1.setBounds(170, 45, 80, 20);
			jFrame2.add(jcb1);
	
			JLabel label2 = new JLabel("ʱ�䣺");
			label2.setBounds(260, 40, 50, 30);
			jFrame2.add(label2);

			jcb2=new JComboBox<Object>(nations2);
			jcb2.setMaximumRowCount(3);
			jcb2.setBounds(300, 45, 95, 20);
			jFrame2.add(jcb2);

			jcb3=new JComboBox<Object>(nations3);
			jcb3.setMaximumRowCount(3);
			jcb3.setBounds(400, 45, 100, 20);
			jFrame2.add(jcb3);
			
			JLabel label_jifang=new JLabel("����:"); 
			label_jifang.setBounds(20, 90, 50, 30);
			jFrame2.add(label_jifang);
			
			jcb5=new JComboBox<Object>(nations5);
			jcb5.setMaximumRowCount(3);
			jcb5.setBounds(70, 95, 80, 20);
			jFrame2.add(jcb5);
			
			JLabel label3 = new JLabel("Ժϵ�༶:");
			label3.setBounds(170, 90, 60, 30);
			jFrame2.add(label3);
			jcb6=new JComboBox<Object>(nations6);
			jcb6.setMaximumRowCount(3);
			jcb6.setBounds(240, 95, 90, 20);
			jFrame2.add(jcb6);
			
			final JTextField text = new JTextField();
			text.setBounds(350, 95, 120, 21);
			jFrame2.add(text);
	
			JButton button_chaxun = new JButton("��ѯ");
			button_chaxun.setBounds(440, 130,70, 24);
			JButton button_chakan = new JButton("�鿴");
			button_chakan.setBounds(440, 160, 70, 25);
			button_chaxun.addActionListener(new ActionListener() 
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
					
					
						JOptionPane.showMessageDialog(null, "��δԤԼ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "�Ѿ�ԤԼ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			
			});
	
			button_chakan.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) {
					Explain exp=new Explain();
					appointment=new Appointment();
					appointment.setTime(exp.explainTime((String) jcb.getSelectedItem()));	
					appointment.setWeek(exp.explainWeek((String) jcb1.getSelectedItem()));
					appointment.setDate(exp.explainDate((String) jcb2.getSelectedItem()));
					appointment.setRoom(exp.explainRoom((String) jcb5.getSelectedItem()));					
					service.getAppointment_2(appointment.getTime(), appointment.getWeek(), appointment.getDate(), appointment.getRoom());
					if(service.getAp().getSchool()==null){
					JOptionPane.showMessageDialog(null, "��δԤԼ���޷��鿴�� ","��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "         Ԥ    Լ     ��     Ϣ��\n"+"Ժ      ϵ��"+service.getAp().getSchool()+"\n"+"��      ����"+service.getAp().getClasses()+"\n"+"Ԥ Լ �ˣ�"+service.getAp().getName()+"\n"+"�� �� �ţ�"+service.getAp().getPhoneNumber(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			
			});
	
			JLabel label4 = new JLabel("Ԥ����:");
			label4.setBounds(20, 140, 100, 30);
			jFrame2.add(label4);
			final JTextField text1 = new JTextField();
			text1.setBounds(70, 145, 80, 20);
			jFrame2.add(text1);
	
			JLabel label5 = new JLabel("�ֻ����룺");
			label5.setBounds(170, 140, 100, 30);
			jFrame2.add(label5);
			final JTextField text2 = new JTextField();
			text2.setBounds(250, 145, 150, 20);
			jFrame2.add(text2);

			JButton button4 = new JButton("ȷ��");
			button4.setBounds(120, 200, 70, 25);
	
			JButton button5 = new JButton("����");
			button5.setBounds(320, 200, 70, 25);
			

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
					if(service.getAp().getState()==1){
					
					
						JOptionPane.showMessageDialog(null, "�Ѿ�ԤԼ���޷�Ԥ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else if(text.getText().length()==0 || text1.getText().length()==0 || text2.getText().length()==0){
						JOptionPane.showMessageDialog(null, "������������Ϣ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);	
					}
					else{
							
							if(jframe5.getpS().isPasswordState()){
								JOptionPane.showMessageDialog(null, "������֤����Ϣ���ٴε����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);	
								jframe5.SetJframe5();
							}else{
								
								appointment.setSchool((String) jcb6.getSelectedItem());
								appointment.setClasses(text.getText());
								appointment.setName(text1.getText());
								appointment.setPhoneNumber(text2.getText());
								try {
									service.setAppointment(appointment.getTime(), appointment.getWeek(), appointment.getDate(), appointment.getRoom(), appointment.getSchool(), appointment.getClasses(), appointment.getName(), appointment.getPhoneNumber());
								} catch (SQLException e1) {
									// TODO �Զ����ɵ� catch ��
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "ԤԼ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);	
							}
						}
					}

			});
			button5.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					jFrame2.dispose();					
					Jframe1 jframe1=new Jframe1();
					try {
						jframe1.SetJframe1();
					} catch (ParseException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}

				}

			});
			jFrame2.add(button_chaxun);
			jFrame2.add(button_chakan);
			jFrame2.add(button4);
			jFrame2.add(button5);
			String path = ".\\images\\xiaohui.gif";//��ӱ���
			ImageIcon background = new ImageIcon(path); 
			JLabel label0 = new JLabel(background);
			label0.setBounds(0, 0, 40, 40);
			jFrame2.add(label0);
			String path1 = ".\\images\\yuyue.jpg";//��ӱ���
			ImageIcon  image= new ImageIcon(path1); 
			JLabel label11 = new JLabel(image);
			label11.setBounds(0, 0, 540, 300);
			jFrame2.add(label11);
			jFrame2.setVisible(true);
		}
}

