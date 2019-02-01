package magicalGirl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class magicalGirlDAO {
	//データベース関連
	final private static String dbname = "test";   // データベース名
	final private static String user = "dbpuser";      // studentにアクセスできるユーザ
	final private static String password = "hogehoge"; // userのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;
    Connection connection;

    //SQL文
    String sql_select ="select * from magical_girl order by id asc";//魔法少女データ一覧
    String sql_Nselect ="select * from magical_girl where name=?";
    String sql_maxID ="select max(id) from magical_girl where name =?;";
    String sql_update ="select * from magical_girl where id :: integer >? order by id desc";
    String sql_insert1 ="update magical_girl set id=? where id=?";
    String sql_insert2 ="insert into magical_girl values(?,?,?,?,?,?,?,?,0)";
    String sql_checkName ="select * from magical_girl where name =?";
    String sql_checkConnect ="select * from magical_girl where connect =?";
    String sql_checkDoppel ="select * from magical_girl where doppel =?";
    String sql_checkMagia ="select * from magical_girl where magia =?";
    String sql_setID ="select * from magical_girl where id = ?";
    String sql_check="select * from magical_girl where possession='0'";
    String sql_checkh="select * from magical_girl where possession='1' order by id asc";
    String sql_get="update magical_girl set possession='1' where id=?";
    //PreparedStatement
    PreparedStatement prepStmt_S; // SELECT用
    PreparedStatement prepStmt_I; // INSERT用
    PreparedStatement prepStmt_U; // UPDATE用
    PreparedStatement prepStmt_D; // DELETE用
    magicalGirl mg = new magicalGirl();

    public List<magicalGirl> getMG_List(){
    	List<magicalGirl> list = new ArrayList<>();
    	try{
    		Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user,password);
			prepStmt_S = connection.prepareStatement(sql_select);
    		ResultSet result = prepStmt_S.executeQuery();

			while(result.next()){
			mg=new magicalGirl();
			mg.setID(result.getInt("id"));
			mg.setCard(result.getString("card"));
			mg.setName(result.getString("name"));
			mg.setRarity(result.getString("rarity"));
			mg.setAttribute(result.getString("attribute"));
			mg.setConnect(result.getString("connect"));
			mg.setMagia(result.getString("magia"));
			mg.setDoppel(result.getString("doppel"));
			mg.setPossession(result.getInt("possession"));
			list.add(mg);
			}
			result.close();
			connection.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return list;
    }

    public void addM(magicalGirl magicalgirl){
    	if(checkName(magicalgirl) == true){
    	
    	try {
    		Class.forName(driverClassName);
			connection = DriverManager.getConnection(url,user,password);
			prepStmt_S = connection.prepareStatement(sql_maxID);
			prepStmt_S.setString(1, magicalgirl.getName());
			ResultSet resultSet1 = prepStmt_S.executeQuery();
			prepStmt_I = connection.prepareStatement(sql_update);
			prepStmt_D = connection.prepareStatement(sql_insert1);
			while(resultSet1.next()){
			prepStmt_I.setInt(1, resultSet1.getInt(1));
			

			}

			ResultSet resultSet2 = prepStmt_I.executeQuery();
		   
			while(resultSet2.next()){
				System.out.println(resultSet2.getInt(1));
			prepStmt_D.setInt(1, resultSet2.getInt(1)+1);
				prepStmt_D.setInt(2, resultSet2.getInt(1));
				prepStmt_D.executeUpdate();
				
			}
			while(resultSet1.next()){
			prepStmt_U = connection.prepareStatement(sql_insert2);
			prepStmt_U.setInt(1, resultSet1.getInt(1)+1);
			prepStmt_U.setString(2,magicalgirl.getCard());
			prepStmt_U.setString(3, magicalgirl.getName());
			prepStmt_U.setString(4, magicalgirl.getRarity());
			prepStmt_U.setString(5, magicalgirl.getAttribute());
			prepStmt_U.setString(6,magicalgirl.getConnect());
			prepStmt_U.setString(7,magicalgirl.getMagia());
			prepStmt_U.setString(8, magicalgirl.getDoppel());
			prepStmt_U.executeUpdate();
			System.out.println("debag3");
			}
			resultSet1.close();
			resultSet2.close();
			connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	}else{
    		List<magicalGirl> list  = new ArrayList<>();
    		list = getMG_List();
    		try{
    			Class.forName(driverClassName);
    			connection = DriverManager.getConnection(url, user, password);
    			prepStmt_I = connection.prepareStatement(sql_insert2);
    			prepStmt_I.setInt(1, list.size()+1);
    			prepStmt_I.setString(2, magicalgirl.getCard());
    			prepStmt_I.setString(3, magicalgirl.getName());
    			prepStmt_I.setString(4, magicalgirl.getRarity());
    			prepStmt_I.setString(5, magicalgirl.getAttribute());
    			prepStmt_I.setString(6,magicalgirl.getConnect());
    			prepStmt_I.setString(7,magicalgirl.getMagia());
    			prepStmt_I.setString(8, magicalgirl.getDoppel());
    			prepStmt_I.executeUpdate();
    			connection.close();
    		}catch(Exception e){
    			e.printStackTrace();
    		}

    	}

    }

    public boolean checkName(magicalGirl magicalgirl){
    	boolean result = false;
    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(url,user,password);
    		prepStmt_S = connection.prepareStatement(sql_checkName);
    		prepStmt_S.setString(1, magicalgirl.getName());
    		ResultSet resultSet = prepStmt_S.executeQuery();
    		while(resultSet.next()){
    			result = true;
    		}
    		resultSet.close();
    		connection.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}


    	return result;
    }

    public magicalGirl getMG(magicalGirl magicalgirl){
    	try{
    	Class.forName(driverClassName);
		connection = DriverManager.getConnection(url, user,password);
		prepStmt_S = connection.prepareStatement(sql_Nselect);
		 prepStmt_S.setString(1, magicalgirl.getName());
		ResultSet result = prepStmt_S.executeQuery();
       
		while(result.next()){
		mg=new magicalGirl();
		mg.setID(result.getInt("id"));
		mg.setCard(result.getString("card"));
		mg.setName(result.getString("name"));
		mg.setRarity(result.getString("rarity"));
		mg.setAttribute(result.getString("attribute"));
		mg.setConnect(result.getString("connect"));
		mg.setMagia(result.getString("magia"));
		mg.setDoppel(result.getString("doppel"));
		mg.setPossession(result.getInt("possession"));
		}
    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return magicalgirl;
    }
		
    public magicalGirl getMG1(magicalGirl magicalgirl){
    
    try{
    	Class.forName(driverClassName);
    	connection = DriverManager.getConnection(url, user, password);
    	prepStmt_I = connection.prepareStatement(sql_setID);
    	prepStmt_I.setInt(1, magicalgirl.getID());
    	ResultSet result = prepStmt_I.executeQuery();
    	while(result.next()){
    		mg=new magicalGirl();
    		mg.setID(result.getInt("id"));
    		mg.setCard(result.getString("card"));
    		mg.setName(result.getString("name"));
    		mg.setRarity(result.getString("rarity"));
    		mg.setAttribute(result.getString("attribute"));
    		mg.setConnect(result.getString("connect"));
    		mg.setMagia(result.getString("magia"));
    		mg.setDoppel(result.getString("doppel"));
    		mg.setPossession(result.getInt("possession"));
    	}
    }catch(Exception e){
    	e.printStackTrace();
    }
    
    
    return mg;
    }
    
    public List<magicalGirl> getlist(magicalGirl magicalgirl){
    	List<magicalGirl> list = new ArrayList<>();
    	 magicalGirl m = new magicalGirl(); 
    	m = getMG1(magicalgirl);
    	try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
	    	prepStmt_I = connection.prepareStatement(sql_checkName);
	    	prepStmt_I.setString(1, m.getName());
	    	ResultSet result = prepStmt_I.executeQuery();
	    	while(result.next()){
	    		mg=new magicalGirl();
	    		mg.setID(result.getInt("id"));
	    		mg.setCard(result.getString("card"));
	    		mg.setName(result.getString("name"));
	    		mg.setRarity(result.getString("rarity"));
	    		mg.setAttribute(result.getString("attribute"));
	    		mg.setConnect(result.getString("connect"));
	    		mg.setMagia(result.getString("magia"));
	    		mg.setDoppel(result.getString("doppel"));
	    		mg.setPossession(result.getInt("possession"));
	    		list.add(mg);
	    	}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	
    	
    	return list;
    }

    public List<magicalGirl>serchMID(String key){
		List<magicalGirl>keylist=new ArrayList<>();
		List<magicalGirl>list=new ArrayList<>();
		magicalGirlDAO dao=new magicalGirlDAO();
		list=dao.getMG_List();
		for(magicalGirl ms:list){
			if(ms.getName().contains(key)||ms.getMagia().contains(key)||
					ms.getDoppel().contains(key)||ms.getConnect().contains(key)){
				keylist.add(ms);
			}
		}
		return keylist;
	}
    
    public List<magicalGirl>serchA(String key){
		List<magicalGirl>keylist=new ArrayList<>();
		List<magicalGirl>list=new ArrayList<>();
		magicalGirlDAO dao=new magicalGirlDAO();
		list=dao.getMG_List();
		for(magicalGirl ms:list){
			if(ms.getAttribute().contains(key)){
				keylist.add(ms);
			}
		}
		return keylist;
	}
    public List<magicalGirl>serchR(String key){
		List<magicalGirl>keylist=new ArrayList<>();
		List<magicalGirl>list=new ArrayList<>();
		magicalGirlDAO dao=new magicalGirlDAO();
		list=dao.getMG_List();
		for(magicalGirl ms:list){
			if(ms.getRarity().matches(key)){
				keylist.add(ms);
			}
		}
		return keylist;
	}
    
    public magicalGirl serchGirl(magicalGirl magicalgirl){
    	
    	
    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(url, user, password);
    		String sql ="select * from magical_girl where id =?";
    		prepStmt_I = connection.prepareStatement(sql);
    		ResultSet resultSet = prepStmt_I.executeQuery();
    		while(resultSet.next()){
    			mg = new magicalGirl();
    			mg.setName(resultSet.getString("name"));
    			
    		}
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	
    	return mg;
    	
    }
    
    public List<magicalGirl> NothasList(){
    	List<magicalGirl>list=new ArrayList<>();
    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(url, user, password);
    		
    		prepStmt_I = connection.prepareStatement(sql_check);
    		ResultSet resultSet = prepStmt_I.executeQuery();
    		while(resultSet.next()){
    			mg=new magicalGirl();
	    		mg.setID(resultSet.getInt("id"));
	    		mg.setCard(resultSet.getString("card"));
	    		mg.setName(resultSet.getString("name"));
	    		mg.setRarity(resultSet.getString("rarity"));
	    		mg.setAttribute(resultSet.getString("attribute"));
	    		mg.setConnect(resultSet.getString("connect"));
	    		mg.setMagia(resultSet.getString("magia"));
	    		mg.setDoppel(resultSet.getString("doppel"));
	    		mg.setPossession(resultSet.getInt("possession"));
	    		list.add(mg);
    			
    		}
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	
    	return list;
    	
    }
    
    public List<magicalGirl> hasList(){
    	List<magicalGirl>list=new ArrayList<>();
    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(url, user, password);
    		
    		prepStmt_I = connection.prepareStatement(sql_checkh);
    		ResultSet resultSet = prepStmt_I.executeQuery();
    		while(resultSet.next()){
    			mg=new magicalGirl();
	    		mg.setID(resultSet.getInt("id"));
	    		mg.setCard(resultSet.getString("card"));
	    		mg.setName(resultSet.getString("name"));
	    		mg.setRarity(resultSet.getString("rarity"));
	    		mg.setAttribute(resultSet.getString("attribute"));
	    		mg.setConnect(resultSet.getString("connect"));
	    		mg.setMagia(resultSet.getString("magia"));
	    		mg.setDoppel(resultSet.getString("doppel"));
	    		mg.setPossession(resultSet.getInt("possession"));
	    		list.add(mg);
    			
    		}
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	
    	return list;
    	
    }
    
    public void changeFlag(int value){
    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(url, user, password);
    		
    		prepStmt_I = connection.prepareStatement(sql_get);
    		prepStmt_I.setInt(1, value);
    		prepStmt_I.executeUpdate();
    		connection.close();
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    }

    public static void main(String[] args) {
    	/*magicalGirl mg = new magicalGirl();
    	magicalGirlDAO dao = new magicalGirlDAO();
List<magicalGirl>list=new ArrayList<>();
list = dao.getMG_List();
for(magicalGirl m:list){
System.out.println(m.getID()+ "　　　　"+ m.getName()+"　　　　"+m.getRarity());
}
    	*/
    magicalGirlDAO dao = new magicalGirlDAO();
    magicalGirl mg = new magicalGirl();
    List<magicalGirl>list=new ArrayList<>();
    int name =1;
    mg.setID(name);
    dao.getlist(mg);
    for(magicalGirl m:list){
    	System.out.println(m.getName());
    }
    }



}
