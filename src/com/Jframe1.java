package com;			
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
//������봰��		
	public 	class Jframe1 {
		final JFrame jFrame1 = new JFrame("   �������ƹ�����");
		
		final SetTime s=new SetTime();
		void SetJframe1() throws ParseException{
				
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				jFrame1.setBounds(((int)dimension.getWidth() - 220) / 2, ((int)dimension.getHeight() - 320) / 2, 360, 260);
				jFrame1.setResizable(false);
				jFrame1.setLayout(null);
				
				jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JLabel label_biaoti = new JLabel("��ԭ��ѧԺ��Ϣ����ѧԺ");
				label_biaoti.setBounds(40, 5, 200, 30);
				jFrame1.add(label_biaoti);
				JLabel label10= new JLabel("_________________________________________________");
				label10.setBounds(5, 11, 360, 30);
				jFrame1.add(label10);
				
				JLabel label= new JLabel("����ԤԼϵͳ");//����
				label.setFont(new   java.awt.Font(null,   1,   22));
				label.setForeground(Color.red);
				label.setBounds(100, 40, 200, 30);
				jFrame1.add(label);
				JButton button_yuyue = new JButton("ԤԼ");
				button_yuyue.setBounds(40, 100, 70, 25);
				
				JButton button_tuiding = new JButton("�˶�");
				button_tuiding.setBounds(240,100, 70, 25);
						
				
				JButton button_chakan = new JButton("�鿴");
				button_chakan.setBounds(80, 140, 70, 25);
				
				
				JButton button_tuichu = new JButton("�˳�");
				button_tuichu.setBounds(200,140, 70, 25);
				JLabel label1= new JLabel("____________________________________");
				label1.setBounds(50, 160, 300, 30);
				jFrame1.add(label1);
				JLabel label2= new JLabel(" Copyright@&copy 2013-2017  ԥICP��12021XX��");
				label2.setBounds(30, 180, 300, 30);
				jFrame1.add(label2);
				JLabel label3= new JLabel("  ��Ȩ����    �������ƹ�����");
				label3.setBounds(90, 200, 300, 30);
				jFrame1.add(label3);
				JLabel label_riqi= new JLabel("���ڣ�"+s.getDate());
				label_riqi.setBounds(200, 70, 150, 30);
				jFrame1.add(label_riqi);
			
				button_yuyue.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							Jframe2  jframe2=new Jframe2();
							jframe2.SetJframe2();
							jFrame1.dispose();
							}							
					});
				button_tuiding.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								Jframe3  jframe3=new Jframe3();
								jframe3.SetJframe3();
								jFrame1.dispose();
						}
					});
				button_chakan.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						Jframe4  jframe4=new Jframe4();
						try {
							jframe4.SetJframe4();
							jFrame1.dispose();
						} catch (ParseException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						}							
				});
				button_tuichu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							jFrame1.dispose();
					}
				});
				jFrame1.add(button_yuyue);
				jFrame1.add(button_tuiding);
				jFrame1.add(button_chakan);
				jFrame1.add(button_tuichu);
				String path = ".\\images\\xiaohui.gif";//��ӱ���
				ImageIcon background = new ImageIcon(path); 
				JLabel label0 = new JLabel(background);
				label0.setBounds(0, 0, 40, 40);
				jFrame1.add(label0);
				String path1 = ".\\images\\index.jpg";//��ӱ���
				ImageIcon  image= new ImageIcon(path1); 
				JLabel label11 = new JLabel(image);
				label11.setBounds(0, 0, 360, 260);
				jFrame1.add(label11);	
				jFrame1.setVisible(true);
			}		
}
