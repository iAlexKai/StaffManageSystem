package infoManage;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Contract_info extends MainPage {

	JButton JBAdd = new JButton("新增");
	JButton JBDelete = new JButton("删除");
	JButton JBModify = new JButton("修改");
	JLabel JLid = new JLabel("合同号： ");  // 变量命名中L表示Label
	JLabel JLname = new JLabel("员工工号： ");
	JTextField JTid = new JTextField(6);  // 变量命名中T表示Text
	JTextField JTname = new JTextField(6);
	JButton JBSearchId = new JButton("合同号查询");
	JButton JBSearchName = new JButton("工号查询");
	
	JPanel subPanel = null;
	// 默认表格和主体表格
	DefaultTableModel tableModel = null;
	JTable table = null;
	JPanel tablePanel = null;
	Vector columnName = null;
	
	String sql = "";
	// driver engine
	String jd = "com.mysql.cj.jdbc.Driver";
	// url
	String url = "jdbc:mysql://127.0.0.1:3306/staff_info?useSSL=false";  // 注意数据库名字的修改
	// user-name
	String user = "root";
	// pass-word
	String password = "wsad1234";
	// connection
	Connection connection = null;
	public Contract_info() {
		subPanel = new JPanel();
		//subPanel.setLayout(new FlowLayout());
		//subPanel.setBounds(0, 50, 180, 100);
		
		JBAdd.setBounds(20, 60, 60, 20);
		JBDelete.setBounds(80, 60, 60, 20);
		
		JLid.setBounds(10, 100, 50, 20);
		//JTid.setSize(120, 20);
		//JTdepartment.setSize(120, 20);
		this.setLayout(new FlowLayout());;
		subPanel.add(JBAdd);
		subPanel.add(JBDelete);
		subPanel.add(JBModify);
		subPanel.add(JLid);
		subPanel.add(JTid);
		subPanel.add(JBSearchId);
		subPanel.add(JLname);
		subPanel.add(JTname);
		subPanel.add(JBSearchName);
		this.add(subPanel);
		JBAdd.addActionListener(this);
		JBDelete.addActionListener(this);
		JBModify.addActionListener(this);
		JBSearchId.addActionListener(this);
		JBSearchName.addActionListener(this);
		
		// 获得表格各行数据
		Vector rowData = PutinStorage.getRows("staff_info", "contract_info");
		// 获得表格表头数据
		columnName = PutinStorage.getHead("staff_info", "contract_info");
		// 新建表格
		tableModel = new DefaultTableModel(rowData, columnName);	
		table = new JTable(tableModel);
		
		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll);
	
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBAdd) {
			new addContract();
		}
		
		if(e.getSource() == JBDelete) {
			new deleteContract();
		}
		
		if(e.getSource() == JBModify) {
			new modifyContract(); 
		}
		
		if(e.getSource() == basic_info) { // 点击后切换到basic_info卡片
			this.setVisible(false);
			new Basic_info();
			
		}
		
		if(e.getSource() == attendance_info) {
			this.setVisible(false);
			new Attendance_info();
		}
		
		if(e.getSource() == salary_info) {
			this.setVisible(false);
			new Salary_info();
		}
		
		if(e.getSource() == lesson_info) {
			this.setVisible(false);
			new Lesson_info();
		}
		
		if(e.getSource() == contract_info) {
			this.setVisible(false);
			new Contract_info();
		}
		
		if(e.getSource() == real_estate_info) {
			this.setVisible(false);
			new Real_estate_info();
		}	
		
		// 按工号查询 显示搜索结果展示表格在界面主题
		if(e.getSource() == JBSearchId) { 
			String sSid = JTid.getText();
			sql = "select * from contract_info where cid = '"+sSid+"'";
			try {
				Class.forName(jd);
				// connect to database object
				connection = (Connection)DriverManager.getConnection(url, user, password);
				System.out.println("Successfully connected to the database basic_info");
				// get the data
				java.sql.Statement statement = connection.createStatement();
				java.sql.ResultSet result_set = statement.executeQuery(sql);
				
				// 如果有结果，则给出提示，否则写入数据库
				if (!result_set.next()) 
					JOptionPane.showMessageDialog(null, "找不到此号对应的合同！");
				else {
					Vector rows = new Vector();
					
					ResultSetMetaData rsmd = result_set.getMetaData();
					
					do{
						rows.addElement(getNextRow(result_set,rsmd));	
					}while(result_set.next());
					
					tableModel.setDataVector(rows, columnName);
					table.updateUI();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		if(e.getSource() == JBSearchName) { 
			String sName = JTname.getText();
			sql = "select * from contract_info where staff_id = '"+sName+"'";
			try {
				Class.forName(jd);
				// connect to database object
				connection = (Connection)DriverManager.getConnection(url, user, password);
				System.out.println("Successfully connected to the database basic_info");
				// get the data
				java.sql.Statement statement = connection.createStatement();
				java.sql.ResultSet result_set = statement.executeQuery(sql);
				
				// 如果有结果，则给出提示，否则写入数据库
				if (!result_set.next()) 
					JOptionPane.showMessageDialog(null, "找不到此人的合同！");
				else {
					Vector rows = new Vector();
					
					ResultSetMetaData rsmd = result_set.getMetaData();
					
					do{
						rows.addElement(getNextRow(result_set,rsmd));	
					}while(result_set.next());
					
					tableModel.setDataVector(rows, columnName);
					table.updateUI();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
	
	// 得到数据库中下一行数据
		private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
			Vector currentRow = new Vector();
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
			}
			return currentRow;
		}
	
}

