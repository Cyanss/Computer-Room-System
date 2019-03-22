package com.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.jdbcConnection.JdbcConn;
import com.objectinfo.Appointment;
public class Service {
		String existEORRE="Table 'test.appointment' doesn't exist";
	
		private Statement 	st;
		private ResultSet  rs=null;
		private String mysql;
		private Appointment ap;
		public Appointment getAp() {
			return ap;
		}
		public ResultSet getRs() {
			return rs;
		}
		public void setRs(ResultSet rs) {
			this.rs = rs;
		}
		public void setAp(Appointment ap) {
			this.ap = ap;
		}
		public  boolean getConnectionInfo() {
			boolean bool=false;
			JdbcConn.getConnection();		 
					if(JdbcConn.isStates()){
						bool=true;
					}else{
						bool=false;
					}	
		JdbcConn.close();
		return bool;
		}
		public boolean getAppointmentInfo() {
			boolean bool =true;
			Connection dbconnection = JdbcConn.getConnection();
				 mysql="SELECT state FROM appointment where state=1";			 
					 try {
						st = dbconnection.createStatement(); 
						 rs = st.executeQuery(mysql);
							if(rs.next()){
								bool= false;
							}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						 JOptionPane.showMessageDialog(null, "查询表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
						if(e.getMessage().equals(existEORRE)){
							bool=true;
						}
					}
				 JdbcConn.close();
				return bool;
				
		}
		public void setAppointment(int t,int w,int d,int r,String s, String c,String n,String p) throws SQLException{
			Connection dbconnection = JdbcConn.getConnection();
			st = dbconnection.createStatement();
			
			mysql="INSERT INTO appointment(TIME,WEEK,DATE,Room,School,Class,NAME,PhoneNumber,State)VALUES("
					+ t+ ","+ w+ ","+ d+ ","+ r+ ",'"+ s+ "','"+ c+ "','"+ n+ "','"+ p+ "',1)";
	
				st.executeUpdate(mysql);
				JdbcConn.close();
		}
		public void setAppointment_1() throws SQLException{
			Connection  dbconnection = JdbcConn.getConnection();
			st = dbconnection.createStatement();
			
			mysql="INSERT INTO appointment(State)VALUES(1)";
				st.executeUpdate(mysql);
				JdbcConn.close();
		}
		public void getAppointment(){

			Connection	dbconnection = JdbcConn.getConnection();
		
			try {
				st = dbconnection.createStatement();
				
				mysql="SELECT Time ,Week ,Date ,Room ,Name ,School  ,Class , PhoneNumber ,State  FROM appointment WHERE TIME=1";

				rs=st.executeQuery(mysql);
				
				
					ap=new Appointment();
				while(rs.next()){
					
					ap.setTime(rs.getInt("Time"));
					ap.setWeek(rs.getInt("Week"));
					ap.setDate(rs.getInt("Date"));
					ap.setRoom(rs.getInt("Room"));
					ap.setName(rs.getString("Name"));
					ap.setSchool(rs.getString("School"));
					ap.setClasses(rs.getString("Class"));
					ap.setPhoneNumber(rs.getString("PhoneNumber"));
					ap.setState(rs.getInt("State"));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				 JOptionPane.showMessageDialog(null, "查询表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}
		public void getAppointment_1(int t,int w,int d,int r){

			Connection	dbconnection = JdbcConn.getConnection();
		
			try {
				st = dbconnection.createStatement();
				
				mysql="SELECT a.State FROM appointment a WHERE a.Time ="+ t+ " AND a.Week="+ w+ " AND a.Date="+ d+ " AND a.Room="+ r;
				rs=st.executeQuery(mysql);
				ap=new Appointment();
				while(rs.next()){
					ap.setState(rs.getInt("a.State"));
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				 JOptionPane.showMessageDialog(null, "查询表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}
		public void getAppointment_2(int t,int w,int d,int r){

			Connection	dbconnection = JdbcConn.getConnection();
		
			try {
				st = dbconnection.createStatement();
				
				mysql="SELECT   a.School,a.Class,a.Name,a.PhoneNumber  FROM appointment a WHERE a.Time ="+ t+ " AND a.Week="+ w+ " AND a.Date="+ d+ " AND a.Room="+ r;
				rs=st.executeQuery(mysql);
				ap=new Appointment();
				while(rs.next()){				
					ap.setSchool(rs.getString("a.School"));
					ap.setClasses(rs.getString("a.Class"));
					ap.setName(rs.getString("a.Name"));
					ap.setPhoneNumber(rs.getString("a.PhoneNumber"));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				 JOptionPane.showMessageDialog(null, "查询表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}
		public void deleteAppointment(int t,int w,int d,int r){

			Connection	dbconnection = JdbcConn.getConnection();
		
			try {
				st = dbconnection.createStatement();
				
				mysql="DELETE FROM appointment  WHERE Time ="+ t+ " AND Week="+ w+ " AND Date="+ d+ " AND Room="+ r;
				st.executeUpdate(mysql);
		
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				 JOptionPane.showMessageDialog(null, "删除表单信息失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}
		public void getAppointment_3(int t,int w,int d,int r){

			Connection	dbconnection = JdbcConn.getConnection();
		
			try {
				st = dbconnection.createStatement();
				
				mysql="SELECT a.State FROM appointment a WHERE a.Time ="+ t+ " AND a.Week="+ w+ " AND a.Date="+ d+ " AND a.Room="+ r;
				rs=st.executeQuery(mysql);
				ap=new Appointment();
				while(rs.next()){
					ap.setState(rs.getInt("a.State"));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				 JOptionPane.showMessageDialog(null, "查询表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}   
		public void getAppointment_4(int t,int w,int d,int r){
			Connection	dbconnection = JdbcConn.getConnection();	
			try {
				st = dbconnection.createStatement();		
				mysql="SELECT   a.Class FROM appointment a WHERE a.Time ="+ t+ " AND a.Week="+ w+ " AND a.Date="+ d+ " AND a.Room="+ r;
				rs=st.executeQuery(mysql);
				ap=new Appointment();
				while(rs.next()){				
					ap.setClasses(rs.getString("a.Class"));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				 JOptionPane.showMessageDialog(null, "查询表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}
		public void createAppointmet() throws SQLException{
			Connection	dbconnection = JdbcConn.getConnection();
			st = dbconnection.createStatement();
			try{
			mysql=" CREATE TABLE appointment ( "+
					"TIME INT(20) UNSIGNED COMMENT '周次',"+
					"WEEK INT(20) UNSIGNED COMMENT '期次',"+
					"DATE INT(20) UNSIGNED COMMENT '节次',"+
					"Room INT(20) UNSIGNED COMMENT '机房', "+
					"School VARCHAR(20)  COMMENT '院系',"+
					"Class VARCHAR(20)  COMMENT '班级',"+
					"NAME VARCHAR(20)  COMMENT '预约人',"+
					"PhoneNumber VARCHAR(20)  COMMENT '电话号码',"+
					"State INT(20) UNSIGNED DEFAULT  0  COMMENT '预约状态'"+
					")";
				st.executeUpdate(mysql);
				setAppointment_1();
			}catch(Exception e){
				 JOptionPane.showMessageDialog(null, "创建表单失败！"+e.getMessage(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			JdbcConn.close();
		}	
}
