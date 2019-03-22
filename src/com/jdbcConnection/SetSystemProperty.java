package com.jdbcConnection;
import java.io.FileInputStream;   
import java.io.FileNotFoundException;   
import java.io.FileOutputStream;   
import java.io.IOException;   
import java.io.OutputStream;   
import java.util.Properties;   
public class SetSystemProperty  {   
   //属性文件的路径   
	static String profilepath="jdbcConfie.properties";   
	private static Properties props = new Properties();   
    static {   
        try {   
            props.load(new FileInputStream(profilepath));   
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
            System.exit(-1);   
        } catch (IOException e) {          
            System.exit(-1);   
        }   
    }   
    public static void updateProperties(String name,String value) {   
        try {   
            props.load(new FileInputStream(profilepath));   
            OutputStream fos = new FileOutputStream(profilepath);              
            props.setProperty(name, value);   
            props.store(fos, "Update '" + name + "' value");   
        } catch (IOException e) {   
            e.printStackTrace();
        }   
    }   
    public void setMysql(String Dbtype,String Port,String IP,String Username,String Password,String Dbname){
    	updateProperties("dbtype", Dbtype);          
    	updateProperties("ip", IP);   
    	updateProperties("port", Port);   
    	updateProperties("username", Username);
    	updateProperties("password", Password); 
    	updateProperties("dbname", Dbname);  
    }
}   