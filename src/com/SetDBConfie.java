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

import com.jdbcConnection.SetSystemProperty;
import com.objectinfo.DBInfo;
import com.service.Service;
//���ݿ����ô���		
	public class SetDBConfie {
		final String nations[]={"mysql","oracle","sqlserver"};
		static JComboBox<?> jcb=new JComboBox<Object>();
		final SetTime s=new SetTime();
		DBInfo dbInfo=new DBInfo();
		Service service=new Service();
		SetSystemProperty sp=new SetSystemProperty();
		public DBInfo getDbInfo() {
			return dbInfo;
		}
		public void setDbInfo(DBInfo dbInfo) {
			this.dbInfo = dbInfo;
		}
		void SetJframe() throws ParseException ,SQLException{
				final JFrame jFrame = new JFrame("   �������ƹ�����");
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				jFrame.setBounds(((int)dimension.getWidth() - 220) / 2, ((int)dimension.getHeight() - 320) / 2, 440, 330);
				jFrame.setResizable(false);
				jFrame.setLayout(null);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dbInfo.setDBState(false);
				
				JLabel label= new JLabel("���ݿ�����");//����
				label.setFont(new   java.awt.Font("����",   1,   18));
				label.setForeground(Color.red);
				label.setBounds(160, 10, 150, 30);
				jFrame.add(label);
				JLabel label1= new JLabel("���ݿ����ͣ�");
				label1.setFont(new   java.awt.Font("����",   1,   16));
				label1.setBounds(40, 50, 120, 30);
				jFrame.add(label1);	
				jcb=new JComboBox<Object>(nations);
				jcb.setMaximumRowCount(3);
				jcb.setFont(new   java.awt.Font("����",   1,   15));
				jcb.setBounds(145, 55, 120, 24);
				jFrame.add(jcb);
				
				JLabel label2= new JLabel("�Ƽ�ʹ��MySQL");
				label2.setForeground(Color.blue);
				label2.setBounds(290, 50, 120, 30);
				jFrame.add(label2);
				
				JLabel label3= new JLabel("���ݿ�˿ڣ�");
				label3.setFont(new   java.awt.Font("����",   1,   16));
				label3.setBounds(40, 80, 120, 30);
				jFrame.add(label3);	
				final JTextField text = new JTextField("3306");
				text.setFont(new   java.awt.Font("����",   1,   14));
				text.setBounds(145, 85, 120, 23);
				jFrame.add(text);
				JLabel label4= new JLabel("MySQLĬ�϶˿�");
				label4.setForeground(Color.blue);
				label4.setBounds(290, 80, 120, 30);
				jFrame.add(label4);
				JLabel label5= new JLabel("���ݿ� I P��");
				label5.setFont(new   java.awt.Font("����",   1,   16));
				label5.setBounds(40, 110, 120, 30);
				jFrame.add(label5);	
				final JTextField text1 = new JTextField("localhost");
				text1.setFont(new   java.awt.Font("����",   1,   14));
				text1.setBounds(145, 115, 120, 23);
				jFrame.add(text1);
				JLabel label6= new JLabel("MySQLĬ������IP");
				label6.setForeground(Color.blue);
				label6.setBounds(290, 110, 120, 30);
				jFrame.add(label6);
				JLabel label7= new JLabel("���ݿ��˻���");
				label7.setFont(new   java.awt.Font("����",   1,   16));
				label7.setBounds(40, 140, 120, 30);
				jFrame.add(label7);	
				final JTextField text2 = new JTextField("root");
				text2.setFont(new   java.awt.Font("����",   1,   14));
				text2.setBounds(145, 145, 120, 23);
				jFrame.add(text2);
				JLabel label8= new JLabel("MySQLĬ���˻���");
				label8.setForeground(Color.blue);
				label8.setBounds(290, 140, 120, 30);
				jFrame.add(label8);
				JLabel label9= new JLabel("���ݿ����룺");
				label9.setFont(new   java.awt.Font("����",   1,   16));
				label9.setBounds(40, 170, 120, 30);
				jFrame.add(label9);
				final JTextField text3 = new JTextField();
				text3.setFont(new   java.awt.Font("����",   1,   14));
				text3.setBounds(145, 175, 120, 23);
				jFrame.add(text3);
				JLabel label10= new JLabel("MySQLĬ������Ϊ��");
				label10.setForeground(Color.blue);
				label10.setBounds(290, 170, 120, 30);
				jFrame.add(label10);
				JLabel label11= new JLabel("���ݿ����ƣ�");
				label11.setFont(new   java.awt.Font("����",   1,   16));
				label11.setBounds(40, 200, 120, 30);
				jFrame.add(label11);
				final JTextField text4= new JTextField("test");
				text4.setFont(new   java.awt.Font("����",   1,   14));
				text4.setBounds(145, 205, 120, 23);
				jFrame.add(text4);
				JLabel label12= new JLabel("Ĭ������test���ݿ�");
				label12.setForeground(Color.blue);
				label12.setBounds(290, 200, 120, 30);
				jFrame.add(label12);
				
				JButton button_xieru = new JButton("��������");
				button_xieru.setBounds(10, 250, 90, 25);
				
				JButton button_queding = new JButton("��������");
				button_queding.setBounds(120, 250, 90, 25);
									
				JButton button_moren = new JButton("Ĭ������");
				button_moren.setBounds(230, 250, 90, 25);
									
				JButton button_tuichu = new JButton("�˳�����");
				button_tuichu.setBounds(330,250, 90, 25);
				button_xieru.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						dbInfo.setDbtype((String)jcb.getSelectedItem());
						dbInfo.setPort(text.getText());
						dbInfo.setIp(text1.getText());
						dbInfo.setUsername(text2.getText());
						dbInfo.setPassword(text3.getText());
						dbInfo.setDbname(text4.getText());
						sp.setMysql(dbInfo.getDbtype(),dbInfo.getPort() , dbInfo.getIp(), dbInfo.getUsername(), dbInfo.getPassword(), dbInfo.getDbname());					
						JOptionPane.showMessageDialog(null, "���ݿ����ñ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);							
					}							
				});
	
				button_queding.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(service.getConnectionInfo()){
							JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);	
							dbInfo.setDBState(true);
						}else{
							JOptionPane.showMessageDialog(null, "���ݿ�����ʧ�ܣ��������������ݿ⣡", "��ʾ", JOptionPane.INFORMATION_MESSAGE);								
						}
					}							
				});
				button_moren.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						text.setText("3306");
						text1.setText("localhost");
						text2.setText("root");
						text3.setText("");
						text4.setText("test");
					}							
				});
				button_tuichu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							jFrame.dispose();
					}
				});
				jFrame.add(button_xieru);
				jFrame.add(button_queding);
				jFrame.add(button_moren);
				jFrame.add(button_tuichu);
				String path1 = ".\\images\\peizhi.jpg";//��ӱ���
				ImageIcon  image= new ImageIcon(path1); 
				JLabel label13= new JLabel(image);
				label13.setBounds(0, 0, 440, 330);
				jFrame.add(label13);
				jFrame.setVisible(true);
			}
}


