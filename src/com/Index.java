package com;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import com.service.Service;
public class Index {	
		public static void main(String[] args) throws ParseException, SQLException,MySQLSyntaxErrorException {
			// TODO �Զ����ɵķ������
			Service service =new Service();
			SetDBConfie DBConfie=new SetDBConfie();
			if(service.getConnectionInfo()){
				if(service.getAppointmentInfo()){
					  JOptionPane.showMessageDialog(null, "��ʼ������...", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					  service.createAppointmet();
					  JOptionPane.showMessageDialog(null, "���ݱ������ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
				DBConfie.getDbInfo().setDBState(true);
			}else{
				DBConfie.SetJframe();	
			 }
			if(DBConfie.getDbInfo().isDBState()){
				Jframe1  jframe1=new Jframe1();
				jframe1.SetJframe1();
			}
		}	
}
			
		
	

