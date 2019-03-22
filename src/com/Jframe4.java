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
	    final JFrame jFrame = new JFrame("   漫步青云工作室");
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
		final Object[] columnNames = {" ","一号机房","二号机房","三号机房","四号机房","五号机房","六号机房","七号机房"  };   
	    Object[][] rowData = {  
	            { "第一大节",  "", "", "", "", "","", "" },  
	            { "第二大节",  "", "", "", "", "","", "" },  
	            { "  中  午  ",  "", "", "", "", "","", "" },  
	            { "第三大节",  "", "", "", "", "","", "" },   
	            { "第四大节",  "", "", "", "", "","", "" },  
	            { "  晚  上  ",  "", "", "", "", "","", "" },  
	            };  
	    Service service =new Service();
		private Appointment appointment;
		//重构JTable方法，使单元格不可编辑
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
        jtable.setPreferredScrollableViewportSize(new Dimension(760, 500));// 设置表格的大小  
        jtable.setRowHeight(50);// 设置每行的高度为50  
        jtable.setRowMargin(10);// 设置相邻两行单元格的距离  
        jtable.setRowSelectionAllowed(false);// 设置可否被选择.默认为false  
        jtable.setShowGrid(true);// 是否显示网格线  
        jtable.setShowHorizontalLines(true);// 是否显示水平的网格线  
        jtable.setShowVerticalLines(true);// 是否显示垂直的网格线  
        jtable.addMouseListener(new MouseAdapter(){ 
        	public void mouseClicked(MouseEvent e){     //双击查看详细信息
        		Explain exp=new Explain();
    			appointment=new Appointment();
    			appointment.setTime(exp.explainTime((String) jcb.getSelectedItem()));	
    			appointment.setWeek(exp.explainWeek((String) jcb1.getSelectedItem()));
        		if(e.getClickCount() == 2){ 
                      int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置
                      int  col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //获得列位置 
                      int temp=row+1;
                      service.getAppointment_2(appointment.getTime(), appointment.getWeek(),temp , col);
                      if(service.getAp().getSchool()==null){
      					JOptionPane.showMessageDialog(null, " 无   预   约    信    息！ ","提示", JOptionPane.INFORMATION_MESSAGE);
      					}else{
      						JOptionPane.showMessageDialog(null, "         预    约     信     息：\n"+"院      系："+service.getAp().getSchool()+"\n"+"班      级："+service.getAp().getClasses()+"\n"+"预 约 人："+service.getAp().getName()+"\n"+"手 机 号："+service.getAp().getPhoneNumber(), "提示", JOptionPane.INFORMATION_MESSAGE);
      					}
        		}
		      }
		});
        jtable.doLayout();  
        jtable.setBackground(Color.white);  

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtable.setDefaultRenderer(Object.class, tcr);  //设置单元格内容居中
    	panel.add( jscrollpanel);

        addComponent(jFrame, panel, gridbag, c);  
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds(((int)dimension.getWidth() - 220) / 2, ((int)dimension.getHeight() - 320) / 2, 800, 600);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label_biaoti = new JLabel("中原工学院信息商务学院");
		label_biaoti.setFont(new   java.awt.Font(null,   1,   18));
		label_biaoti.setBounds(40, 20, 250, 30);
		jFrame.add(label_biaoti);
		
		JLabel label= new JLabel("查看预约");
		label.setFont(new   java.awt.Font(null,   1,   22));
		label.setForeground(Color.red);
		label.setBounds(350, 40, 150, 30);
		jFrame.add(label);
		JLabel label_riqi= new JLabel("日期："+s.getDate());
		label_riqi.setFont(new   java.awt.Font(null,   1,   16));
		label_riqi.setBounds(550, 70, 250, 30);
		jFrame.add(label_riqi);
		
		JLabel label_zhouci=new JLabel(" 周  次："); 
		label_zhouci.setFont(new   java.awt.Font(null,   1,   18));
		label_zhouci.setBounds(20, 100, 100, 40);
		jFrame.add(label_zhouci);
		
		jcb=new JComboBox<Object>(nations4);
		jcb.setMaximumRowCount(3);
		jcb.setFont(new   java.awt.Font(null,   1,   16));
		jcb.setBounds(115, 105, 100, 30);
		jFrame.add(jcb);
		
		JLabel label2 = new JLabel("时 间：");
		label2.setFont(new   java.awt.Font(null,   1,   18));
		label2.setBounds(230, 100, 100, 40);
		jFrame.add(label2);

		jcb1=new JComboBox<Object>(nations1);
		jcb1.setMaximumRowCount(3);
		jcb1.setFont(new   java.awt.Font(null,   1,   16));
		jcb1.setBounds(305, 105, 100, 30);
		jFrame.add(jcb1);

		JLabel label12= new JLabel("注：双击单元格可查看详细信息！");
		label12.setFont(new   java.awt.Font(null,   1,   16));
		label12.setForeground(Color.blue);
		label12.setBounds(20, 500, 300, 30);
		jFrame.add(label12);
	
		JButton button1 = new JButton("查看");
		button1.setFont(new   java.awt.Font(null,   1,   16));
		button1.setBounds(600, 105, 80, 30);

		JButton button2 = new JButton("返回");
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
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		});

		jFrame.add(button1);
		jFrame.add(button2);
		String path = ".\\images\\xiaohui.gif";//添加背景
		ImageIcon background = new ImageIcon(path); 
		JLabel label0 = new JLabel(background);
		label0.setBounds(0, 15, 40, 40);
		jFrame.add(label0);
	
		
		jFrame.setLocationRelativeTo(null);  
		jFrame.setResizable(false);
       
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		jFrame.setVisible(true);  
		String path1 = ".\\images\\chakan.jpg";//添加背景
		ImageIcon  image= new ImageIcon(path1); 
		JLabel label11 = new JLabel(image);
		label11.setBounds(0, 0, 800, 600);
		jFrame.add(label11);
    }  
  //布局设计
    private void addComponent(JFrame frame, JComponent comp,  
        GridBagLayout gridbag, GridBagConstraints c) {
        	gridbag.setConstraints(comp, c);  
        	frame.add(comp);
        
    	} 
}  
