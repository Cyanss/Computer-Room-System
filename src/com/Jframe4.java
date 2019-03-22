package com;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.ExplainSrc.Explain;
import com.objectinfo.Appointment;
import com.service.Service;
public class Jframe4 {
	    final JFrame jFrame = new JFrame("   �������ƹ�����");
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
		final Object[] columnNames = {" ","һ�Ż���","���Ż���","���Ż���","�ĺŻ���","��Ż���","���Ż���","�ߺŻ���"  };   
	    Object[][] rowData = {  
	            { "��һ���",  "", "", "", "", "","", "" },  
	            { "�ڶ����",  "", "", "", "", "","", "" },  
	            { "  ��  ��  ",  "", "", "", "", "","", "" },  
	            { "�������",  "", "", "", "", "","", "" },   
	            { "���Ĵ��",  "", "", "", "", "","", "" },  
	            { "  ��  ��  ",  "", "", "", "", "","", "" },  
	            };  
	    Service service =new Service();
		private Appointment appointment;
		//�ع�JTable������ʹ��Ԫ�񲻿ɱ༭
		DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames); 
		    @SuppressWarnings("serial")
			JTable jtable=new JTable(tableModel){
		         public boolean isCellEditable(int row, int column) { 
		          return false;
		         }
		    };
	void SetJframe4() throws ParseException{

        JPanel panel = new JPanel();  
        panel.setBounds(5, 140, 800, 336);
        GridBagLayout gridbag = new GridBagLayout();  
        GridBagConstraints c = new GridBagConstraints();  
        jFrame.setLayout(gridbag);  
	    if(service.getRs()!=null){
		    service.getAppointment();
	    }

        jtable.getTableHeader().setFont(new   java.awt.Font(null,   1,   18));
        jtable.getTableHeader().setForeground(Color.black);
        JScrollPane jscrollpanel= new JScrollPane(jtable);
        jtable.setFont(new   java.awt.Font(null,   1,   14));
        jtable.setForeground(Color.black);
        jtable.setPreferredScrollableViewportSize(new Dimension(760, 500));// ���ñ��Ĵ�С  
        jtable.setRowHeight(50);// ����ÿ�еĸ߶�Ϊ50  
        jtable.setRowMargin(10);// �����������е�Ԫ��ľ���  
        jtable.setRowSelectionAllowed(false);// ���ÿɷ�ѡ��.Ĭ��Ϊfalse  
        jtable.setShowGrid(true);// �Ƿ���ʾ������  
        jtable.setShowHorizontalLines(true);// �Ƿ���ʾˮƽ��������  
        jtable.setShowVerticalLines(true);// �Ƿ���ʾ��ֱ��������  
        jtable.addMouseListener(new MouseAdapter(){ 
        	public void mouseClicked(MouseEvent e){     //˫���鿴��ϸ��Ϣ
        		Explain exp=new Explain();
    			appointment=new Appointment();
    			appointment.setTime(exp.explainTime((String) jcb.getSelectedItem()));	
    			appointment.setWeek(exp.explainWeek((String) jcb1.getSelectedItem()));
        		if(e.getClickCount() == 2){ 
                      int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //�����λ��
                      int  col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //�����λ�� 
                      int temp=row+1;
                      service.getAppointment_2(appointment.getTime(), appointment.getWeek(),temp , col);
                      if(service.getAp().getSchool()==null){
      					JOptionPane.showMessageDialog(null, " ��   Ԥ   Լ    ��    Ϣ�� ","��ʾ", JOptionPane.INFORMATION_MESSAGE);
      					}else{
      						JOptionPane.showMessageDialog(null, "         Ԥ    Լ     ��     Ϣ��\n"+"Ժ      ϵ��"+service.getAp().getSchool()+"\n"+"��      ����"+service.getAp().getClasses()+"\n"+"Ԥ Լ �ˣ�"+service.getAp().getName()+"\n"+"�� �� �ţ�"+service.getAp().getPhoneNumber(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
      					}
        		}
		      }
		});
        jtable.doLayout();  
        jtable.setBackground(Color.white);  

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtable.setDefaultRenderer(Object.class, tcr);  //���õ�Ԫ�����ݾ���
    	panel.add( jscrollpanel);

        addComponent(jFrame, panel, gridbag, c);  
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds(((int)dimension.getWidth() - 220) / 2, ((int)dimension.getHeight() - 320) / 2, 800, 600);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label_biaoti = new JLabel("��ԭ��ѧԺ��Ϣ����ѧԺ");
		label_biaoti.setFont(new   java.awt.Font(null,   1,   18));
		label_biaoti.setBounds(40, 20, 250, 30);
		jFrame.add(label_biaoti);
		
		JLabel label= new JLabel("�鿴ԤԼ");
		label.setFont(new   java.awt.Font(null,   1,   22));
		label.setForeground(Color.red);
		label.setBounds(350, 40, 150, 30);
		jFrame.add(label);
		JLabel label_riqi= new JLabel("���ڣ�"+s.getDate());
		label_riqi.setFont(new   java.awt.Font(null,   1,   16));
		label_riqi.setBounds(550, 70, 250, 30);
		jFrame.add(label_riqi);
		
		JLabel label_zhouci=new JLabel(" ��  �Σ�"); 
		label_zhouci.setFont(new   java.awt.Font(null,   1,   18));
		label_zhouci.setBounds(20, 100, 100, 40);
		jFrame.add(label_zhouci);
		
		jcb=new JComboBox<Object>(nations4);
		jcb.setMaximumRowCount(3);
		jcb.setFont(new   java.awt.Font(null,   1,   16));
		jcb.setBounds(115, 105, 100, 30);
		jFrame.add(jcb);
		
		JLabel label2 = new JLabel("ʱ �䣺");
		label2.setFont(new   java.awt.Font(null,   1,   18));
		label2.setBounds(230, 100, 100, 40);
		jFrame.add(label2);

		jcb1=new JComboBox<Object>(nations1);
		jcb1.setMaximumRowCount(3);
		jcb1.setFont(new   java.awt.Font(null,   1,   16));
		jcb1.setBounds(305, 105, 100, 30);
		jFrame.add(jcb1);

		JLabel label12= new JLabel("ע��˫����Ԫ��ɲ鿴��ϸ��Ϣ��");
		label12.setFont(new   java.awt.Font(null,   1,   16));
		label12.setForeground(Color.blue);
		label12.setBounds(20, 500, 300, 30);
		jFrame.add(label12);
	
		JButton button1 = new JButton("�鿴");
		button1.setFont(new   java.awt.Font(null,   1,   16));
		button1.setBounds(600, 105, 80, 30);

		JButton button2 = new JButton("����");
		button2.setFont(new   java.awt.Font(null,   1,   16));
		button2.setBounds(700, 105, 80, 30);

		button1.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			for(int i=0;i<6;i++){
				for(int j=1;j<8;j++){
						 jtable.setValueAt(null, i, j);
				}
			}
			Explain exp=new Explain();
			appointment=new Appointment();
			appointment.setTime(exp.explainTime((String) jcb.getSelectedItem()));	
			appointment.setWeek(exp.explainWeek((String) jcb1.getSelectedItem()));
			for(int i=0;i<6;i++){
				for(int j=1;j<8;j++){
					int temp=i+1;
					service.getAppointment_4(appointment.getTime(), appointment.getWeek(),temp , j);
					if(service.getAp().getClasses()!=null){
						 jtable.setValueAt(service.getAp().getClasses(), i, j);
					}
				}
			}	
		}
	});

		button2.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
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

		jFrame.add(button1);
		jFrame.add(button2);
		String path = ".\\images\\xiaohui.gif";//��ӱ���
		ImageIcon background = new ImageIcon(path); 
		JLabel label0 = new JLabel(background);
		label0.setBounds(0, 15, 40, 40);
		jFrame.add(label0);
	
		
		jFrame.setLocationRelativeTo(null);  
		jFrame.setResizable(false);
       
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		jFrame.setVisible(true);  
		String path1 = ".\\images\\chakan.jpg";//��ӱ���
		ImageIcon  image= new ImageIcon(path1); 
		JLabel label11 = new JLabel(image);
		label11.setBounds(0, 0, 800, 600);
		jFrame.add(label11);
    }  
  //�������
    private void addComponent(JFrame frame, JComponent comp,  
        GridBagLayout gridbag, GridBagConstraints c) {
        	gridbag.setConstraints(comp, c);  
        	frame.add(comp);
        
    	} 
}  
