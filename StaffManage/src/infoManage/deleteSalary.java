package infoManage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deleteSalary  extends JFrame implements ActionListener{

	JLabel JL = new JLabel("删除工资信息");
	
	JLabel JLSid = new JLabel("员工工号");
	JTextField JTSid = new JTextField();
	
	JLabel JLMonth = new JLabel("工资月份");
	JTextField JTMonth = new JTextField();
	
	JButton JBDelete = new JButton("删除");
	JButton JBClear = new JButton("重输");
	
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
	
	public deleteSalary() {
		this.setTitle("删除工资数据");
		this.setLayout(null);
	
		JL.setFont(new java.awt.Font("宋体", Font.PLAIN, 19));
		JL.setBounds(100,30,200,40);
		this.add(JL);
		
		JLSid.setBounds(100, 80, 100, 20);
		this.add(JLSid);
		JTSid.setBounds(200, 80, 80, 20);
		this.add(JTSid);
		
		JLMonth.setBounds(100, 120, 100, 20);
		this.add(JLMonth);
		JTMonth.setBounds(200, 120, 80, 20);
		this.add(JTMonth);
		
		JBDelete.setBounds(100, 160, 50, 20);
		this.add(JBDelete);
		JBDelete.addActionListener(this);
		
		JBClear.setBounds(200, 160, 50, 20);
		this.add(JBClear);
		JBClear.addActionListener(this);
		
		this.setBounds(320, 220, 380, 220);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBClear) {
			JTSid.setText("");
			JTMonth.setText("");
		}
		if (e.getSource() == JBDelete) {
			String sSid = JTSid.getText();
			String sMonth = JTMonth.getText();
			sql = "select * from salary_info where sid = '"+sSid+"' and month = '"+sMonth+"'";
			
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
					JOptionPane.showMessageDialog(null, "找不到此工号员工，删除失败，请重新输入！");
				else {
					sql = "delete from salary_info where sid = '"+sSid+"' and month = '"+sMonth+"'";  // 注意 delete语句里面没有 *！！！！！
					// 执行sql语句，并获得返回值
					int sqlResult = statement.executeUpdate(sql);
					if (sqlResult > 0) {
						JOptionPane.showMessageDialog(null, "删除成功！");
						JTSid.setText("");
					}
						
					else 
						JOptionPane.showMessageDialog(null, "删除失败...");
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			
		}
		
	}
		
}
	

