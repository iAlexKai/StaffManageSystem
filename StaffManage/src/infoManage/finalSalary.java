package infoManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class finalSalary {
	String sql = "";
	// driver engine
	String jd = "com.mysql.cj.jdbc.Driver";
	// url
	String url = "jdbc:mysql://127.0.0.1:3306/staff_info?useSSL=false";
	// user-name
	String user = "root";
	// pass-word
	String password = "wsad1234";
	// connection
	Connection connection = null;
	
	Vector rowData = null, columnName = null;
	DefaultTableModel tableModel = null;
	JTable table = null;
	
	public finalSalary() {
		rowData = new Vector();
		tableModel = new DefaultTableModel();
		table = new JTable();
		columnName = new Vector();
		columnName.addElement("最终工资");
		columnName.addElement("sid");
		columnName.addElement("基本工资");
		columnName.addElement("月份");
		columnName.addElement("效绩");
		columnName.addElement("部门");
		columnName.addElement("奖金");
		columnName.addElement("税金");
		columnName.addElement("业务量");
		
		sql = "select * from salary_info";
		try {
			Class.forName(jd);
			// connect to database object
			connection = (Connection)DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to the database salary_info");
			// get the data
			java.sql.Statement statement = connection.createStatement();
			java.sql.ResultSet result_set = statement.executeQuery(sql);
			
			// 如果有结果，则给出提示，否则写入数据库
			if (!result_set.next()) 
				JOptionPane.showMessageDialog(null, "计算最终工资时出错");
			else {
				Vector rows = new Vector();			
				ResultSetMetaData rsmd = result_set.getMetaData();
				
				do{
					rows.addElement(getNextRow(result_set,rsmd));	
				}while(result_set.next());
				tableModel.setDataVector(rows, columnName);
				table = new JTable(tableModel);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		JFrame salaryFrame =  new JFrame();
		JScrollPane ageScroll = new JScrollPane(table);
		salaryFrame.add(ageScroll);
		
		salaryFrame.setBounds(320, 220, 800, 600);
		salaryFrame.setVisible(true);
		
	}
	
	// 每行增加最终工资元素，放在最最前面
	/*
	 * 最终工资 = 基本工资 * （1 - tax * 0.01）+ 500 * 效绩 + 奖金
	 * 
	 * rs.getString(2) 基本  （4）效绩  （6）奖金 （7）税
	 * 
	 * 
	 * */
	private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		int basic = Integer.parseInt(rs.getString(2));
		int contribute = Integer.parseInt(rs.getString(4));
		int bonus = Integer.parseInt(rs.getString(6));
		int tax = Integer.parseInt(rs.getString(7));
		double finalSalary = basic * (1 - tax * 0.01) + 500 * contribute + bonus;
		System.out.println("最终工资为" + finalSalary);
		currentRow.addElement(String.valueOf(finalSalary));
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
}
