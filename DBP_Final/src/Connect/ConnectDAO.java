package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import magicalGirl.magicalGirl;

public class ConnectDAO {
	final private static String dbname = "test";   // データベース名
	final private static String user = "dbpuser";      // studentにアクセスできるユーザ
	final private static String password = "hogehoge"; // userのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;
    Connection connection;
    String sql ="select * from connect where girl =?";
    String sql1="insert into connect values(?,?,?)";
    String sql2="delete from connect where name=?";
    String sql3 ="select * from connect";
    Connect connect;
    public Connect getConnect(magicalGirl magicalgirl){
   	 
   	 try{
   		 Class.forName(driverClassName);
   		 connection = DriverManager.getConnection(url, user, password);
   	PreparedStatement pstm = connection.prepareStatement(sql);
   	pstm.setString(1, magicalgirl.getName());
   	ResultSet resultSet = pstm.executeQuery();
   	while(resultSet.next()){
   		connect = new Connect();
   		
   		connect.setName(resultSet.getString("name"));
   		connect.setDiscription(resultSet.getString("discription"));
   		connect.setGirl(resultSet.getString("girl"));
   	}
   	 }catch(Exception e){
   		 e.printStackTrace();
   		 
   	 }
   	 return connect;
   	 
    }
    
    public void add(Connect c){
    	try{
      		 Class.forName(driverClassName);
      		 connection = DriverManager.getConnection(url, user, password);
      	PreparedStatement pstm = connection.prepareStatement(sql1);
       pstm.setString(1, c.getName());
       pstm.setString(2, c.getDiscription());
       pstm.setString(3, c.getGirl());
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
    	
    public List<Connect> getList(){
    	List<Connect>list = new ArrayList<>();
    	Connect c;
    	try{
     		 Class.forName(driverClassName);
     		 connection = DriverManager.getConnection(url, user, password);
     	PreparedStatement pstm = connection.prepareStatement(sql3);
     ResultSet resultSet = pstm.executeQuery();
     while(resultSet.next()){
    	 c = new Connect();
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
