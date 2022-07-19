
package pack;

import java.sql.*;


public class Database {
    
    static String name="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/nelson";
    static String username="root";
    static String password="NELSON22";
    
public static Connection myconnection(){
    Connection con = null;
    
    try{
        Class.forName(name).newInstance();
        con=DriverManager.getConnection(url,username,password);
    }catch(Exception e){
        System.out.println(e);
    }
    return con;
}
public static int savedata(Student st){
    Connection con = myconnection();
    int i = 0;
    try{
        String sql = "insert into nelson.Register values(?,?,?)";
        PreparedStatement prst = con.prepareStatement(sql);
        prst.setString(1, st.getName());
        prst.setString(2, st.getEmail());
        prst.setString(3, st.getPassword());
        
        i=prst.executeUpdate(); 
    
    }catch(Exception e){
        System.out.println(e);
    }
        return i;
}
}
