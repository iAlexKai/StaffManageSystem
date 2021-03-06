package helloMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;


// 注意，第一次使用mysql没有创建任何数据库的时候，有一个默认的数据库 mysql可用作测试，url should refer to mysql

public class JDBC_Connection {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		// driver engine
		String jd = "com.mysql.cj.jdbc.Driver";
		// connect to MySQL
		//String url = "jdbc:mysql://127.0.0.1:3306/mysql?useSSL=false";
		String url = "jdbc:mysql://127.0.0.1:3306/staff_info?useSSL=false";
		// user-name
		String user = "root";
		// pass-word
		String password = "wsad1234";
		try {
			// load the driver 
			Class.forName(jd); 
			// connect to database object
			connection = (Connection)DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to the database");
			
			// get the data
			java.sql.Statement statement = connection.createStatement();
			java.sql.ResultSet result_set = statement.executeQuery("SELECT id, name, birthday, phoneNumber from staff_basic_table\n" + 
					"where phoneNumber > 0");
			while (result_set.next()) {
				System.out.println(result_set.getString("id") + " " + result_set.getString("name") + " " +  result_set.getString("birthday") 
				+ " " + result_set.getString("phoneNumber"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
            System.out.println("connection fails");
            e.printStackTrace();
		}
		
		
		
		
		if (connection != null) {
			try {
				// shutdown the recource
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

