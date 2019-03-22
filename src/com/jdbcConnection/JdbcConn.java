package com.jdbcConnection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
public class JdbcConn {
	private static Connection con=null;
	private static ResultSet rs =null;	
	static String profilepath="jdbcConfie.properties";   		
	private static Properties p = new Properties();
	private static boolean  states;
	public static boolean isStates() {
		return states;
	}
	public static void setStates(boolean states) {
		JdbcConn.states = states;
	}
	public static Connection getConnection(){		
			try {
					p.load(new FileInputStream(profilepath));		
				} catch (IOException e) {
					 JOptionPane.showMessageDialog(null, "��������ʧ�ܣ�"+ e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
	               
			String dbtype= p.getProperty("dbtype");
			String dbname = p.getProperty("dbname");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String ip = p.getProperty("ip");
			String port =p.getProperty("port");
			
		if(dbtype.equalsIgnoreCase("oracle")){
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// JOptionPane.showMessageDialog(null, "�������سɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "������δ�ҵ���ע�⣺�������Ƿ���!"+ e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} 
				String url="jdbc:oracle:thin:@"+ip+":"+port+":"+dbname; 
			try {
			con = DriverManager.getConnection(url,username,password);	
			states=true;
				// JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ������������쳣��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				
				 JOptionPane.showMessageDialog(null, "���ݿ�����ʧ�ܣ����������쳣,�����Ƿ�װ�����ݿ⣡\n" + e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				 if(e.getMessage()!=null){
						states=false;
				 }
			} 
		}
		if(dbtype.equalsIgnoreCase("mysql")){
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
				// JOptionPane.showMessageDialog(null, "�������سɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "������δ�ҵ���ע�⣺�������Ƿ���!"+ e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} 
				String url ="jdbc:mysql://"+ip+":"+port+"/"+dbname+"?user="+username+"&password="+password+"&useUnicode=true&characterEncoding=utf-8" ;
		try {
				con = DriverManager.getConnection(url);
				states=true;
				 //JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ������������쳣��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "���ݿ�����ʧ�ܣ����������쳣,�����Ƿ�װ�����ݿ⣡\n" + e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				 if(e.getMessage()!=null){
				states=false;
				 }
			} 
		}
		if(dbtype.equalsIgnoreCase("sqlserver")){
		try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// JOptionPane.showMessageDialog(null, "�������سɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "������δ�ҵ���ע�⣺�������Ƿ���!"+ e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} 
			String url="jdbc:microsoft:sqlserver://"+ip+":"+port+";DatabaseName="+dbname; 
		try {
				con= DriverManager.getConnection(url,username,password);
				states=true;
				//JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ������������쳣��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "���ݿ�����ʧ�ܣ����������쳣,�����Ƿ�װ�����ݿ⣡\n" + e.getMessage(), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				 if(e.getMessage()!=null){
						states=false;
				 }
			} 
		}
		return con;		
		}
	public static void close(){
		if(con != null){
			try {
				con.close();
				// JOptionPane.showMessageDialog(null, "�ر����ݿ�ɹ���" , "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "�ر����ݿ�ʧ�ܣ�"+e.getMessage() , "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(rs != null){
			try {
				rs.close();
				 //JOptionPane.showMessageDialog(null, "�ر����ݿ�ɹ���" , "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "�ر����ݿ�ʧ�ܣ�"+e.getMessage() , "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

