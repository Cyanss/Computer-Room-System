package com;			
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;	

import com.objectinfo.PasswordState;
//���봰��
public class Jframe5 {
		private  PasswordState pS=new PasswordState();
		final SetTime s=new SetTime();
		final	String	password=s.getData();	
			Jframe5(){
				pS.setPasswordState(true);
			}
			public PasswordState getpS() {
				return pS;
			}
			public void setpS(PasswordState pS) {
				this.pS = pS;
			}
			void SetJframe5(){
				final JFrame jFrame = new JFrame("   �������ƹ�����");
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				jFrame.setBounds(((int)dimension.getWidth() - 220) / 2, ((int)dimension.getHeight() - 320) / 2, 300, 170);
				jFrame.setResizable(false);
				jFrame.setLayout(null);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JLabel label = new JLabel("ȷ��Ȩ��");//����
				label.setFont(new   java.awt.Font(null,   1,   22));
				label.setForeground(Color.red);
				label.setBounds(100, 5, 200, 30);
				jFrame.add(label);
				JLabel label_riqi= new JLabel("���ڣ�"+s.getDate());
				label_riqi.setBounds(140, 25, 150, 30);
				jFrame.add(label_riqi);
				JLabel label1 = new JLabel("���������룺");
				label1.setBounds(30, 50, 100, 30);
				jFrame.add(label1);
				final JPasswordField text1 = new JPasswordField();
				text1.setBounds(120, 55, 150, 25);
				jFrame.add(text1);

				JButton button1 = new JButton("ȷ��");
				button1.setBounds(50, 90, 70, 25);
				
				JButton button2 = new JButton("ȡ��");
				button2.setBounds(170,90, 70, 25);
				button1.addActionListener(new ActionListener(){
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
					
						if(text1.getText().length()==0){
							JOptionPane.showMessageDialog(null, "���������룡", "��ʾ", JOptionPane.INFORMATION_MESSAGE);							
						} else if(text1.getText().equalsIgnoreCase(password)){
								JOptionPane.showMessageDialog(null, "������ȷ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								pS.setPasswordState(false);
								jFrame.dispose();
							}
						else{
								JOptionPane.showMessageDialog(null, "�����������������", "��ʾ", JOptionPane.ERROR_MESSAGE);
								pS.setPasswordState(true);
								text1.setText("");
							}
						
					}
				});
				button2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						pS.setPasswordState(true);
						jFrame.dispose();
					}
					});
				jFrame.add(button1);
				jFrame.add(button2);
				String path1 = ".\\images\\mima.jpg";//��ӱ���
				ImageIcon  image= new ImageIcon(path1); 
				JLabel label11 = new JLabel(image);
				label11.setBounds(0, 0, 293, 170);
				jFrame.add(label11);
				jFrame.setVisible(true);
			}
	}

