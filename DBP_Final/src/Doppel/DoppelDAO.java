package Doppel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import magicalGirl.magicalGirl;
public class DoppelDAO {
	final private static String dbname = "test";   // データベース名
	final private static String user = "dbpuser";      // studentにアクセスできるユーザ
	final private static String password = "hogehoge"; // userのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;
    Connection connection;
    String sql ="select * from doppel where girl =?";
    String sql1="insert into doppel values(?,?,?)";
    String sql2="delete from doppel where name=?";
    String sql3 ="select * from doppel";
   Doppel doppel;
    public Doppel getDoppel(magicalGirl magicalgirl){
   	 
   	 try{
   		 Class.forName(driverClassName);
   		 connection = DriverManager.getConnection(url, user, password);
   	PreparedStatement pstm = connection.prepareStatement(sql);
   	pstm.setString(1, magicalgirl.getName());
   	ResultSet resultSet = pstm.executeQuery();
   	while(resultSet.next()){
   		doppel = new Doppel();
   		
   		doppel.setName(resultSet.getString("name"));
   		doppel.setDiscription(resultSet.getString("discription"));
   		doppel.setGirl(resultSet.getString("girl"));
   	}
   	 }catch(Exception e){
   		 e.printStackTrace();
   		 
   	 }
   	 return doppel;
   	 
    }
    
    public boolean check(magicalGirl magicalgirl){
    	boolean result = false;
    	
    	
    	return result;
    }
    
    public void add(Doppel d){
    	try{
      		 Class.forName(driverClassName);
      		 connection = DriverManager.getConnection(url, user, password);
      	PreparedStatement pstm = connection.prepareStatement(sql1);
       pstm.setString(1, d.getName());
       pstm.setString(2, d.getDiscription());
       pstm.setString(3, d.getGirl());
      pstm.executeUpdate();
      pstm.close();
      connection.close();
      	 }catch(Exception e){
      		 e.printStackTrace();
      		 
      	 }
    }
    public void delete(String s){
    	try{
     		 Class.forName(driverClassName);
     		 connection = DriverManager.getConnection(url, user, password);
     	PreparedStatement pstm = connection.prepareStatement(sql2);
      pstm.setString(1, s);
     
     pstm.executeUpdate();
     pstm.close();
     connection.close();
     	 }catch(Exception e){
     		 e.printStackTrace();
     		 
     	 }
   }
    
    public List<Doppel> getList(){
    	List<Doppel>list = new ArrayList<>();
    	Doppel c;
    	try{
     		 Class.forName(driverClassName);
     		 connection = DriverManager.getConnection(url, user, password);
     	PreparedStatement pstm = connection.prepareStatement(sql3);
     ResultSet resultSet = pstm.executeQuery();
     while(resultSet.next()){
    	 c = new Doppel();
    	 c.setName(resultSet.getString("name"));
    	 c.setDiscription(resultSet.getString("discription"));
    	 c.setGirl(resultSet.getString("girl"));
    	 list.add(c);
     }
   
     pstm.close();
     connection.close();
     	 }catch(Exception e){
     		 e.printStackTrace();
     		 
     	 }
    	return list;
    }
	
	
	
}
