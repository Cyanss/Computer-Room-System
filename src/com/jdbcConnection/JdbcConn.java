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
					 JOptionPane.showMessageDialog(null, "载入配置失败！"+ e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
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
				// JOptionPane.showMessageDialog(null, "驱动加载成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "驱动类未找到，注意：驱动包是否导入!"+ e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			} 
				String url="jdbc:oracle:thin:@"+ip+":"+port+":"+dbname; 
			try {
			con = DriverManager.getConnection(url,username,password);	
			states=true;
				// JOptionPane.showMessageDialog(null, "数据库链接成功，配置项无异常！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				
				 JOptionPane.showMessageDialog(null, "数据库链接失败，配置项有异常,请检查是否安装了数据库！\n" + e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
				 if(e.getMessage()!=null){
						states=false;
				 }
			} 
		}
		if(dbtype.equalsIgnoreCase("mysql")){
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
				// JOptionPane.showMessageDialog(null, "驱动加载成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "驱动类未找到，注意：驱动包是否导入!"+ e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			} 
				String url ="jdbc:mysql://"+ip+":"+port+"/"+dbname+"?user="+username+"&password="+password+"&useUnicode=true&characterEncoding=utf-8" ;
		try {
				con = DriverManager.getConnection(url);
				states=true;
				 //JOptionPane.showMessageDialog(null, "数据库链接成功，配置项无异常！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "数据库链接失败，配置项有异常,请检查是否安装了数据库！\n" + e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
				 if(e.getMessage()!=null){
				states=false;
				 }
			} 
		}
		if(dbtype.equalsIgnoreCase("sqlserver")){
		try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// JOptionPane.showMessageDialog(null, "驱动加载成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "驱动类未找到，注意：驱动包是否导入!"+ e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			} 
			String url="jdbc:microsoft:sqlserver://"+ip+":"+port+";DatabaseName="+dbname; 
		try {
				con= DriverManager.getConnection(url,username,password);
				states=true;
				//JOptionPane.showMessageDialog(null, "数据库链接成功，配置项无异常！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "数据库链接失败，配置项有异常,请检查是否安装了数据库！\n" + e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
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
				// JOptionPane.showMessageDialog(null, "关闭数据库成功！" , "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "关闭数据库失败，"+e.getMessage() , "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(rs != null){
			try {
				rs.close();
				 //JOptionPane.showMessageDialog(null, "关闭数据库成功！" , "提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "关闭数据库失败，"+e.getMessage() , "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

