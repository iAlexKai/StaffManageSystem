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

public class modifyAttendance extends JFrame implements ActionListener{
	JLabel JL = new JLabel("修改出勤信息");
	
	JLabel JLSid = new JLabel("工号");
	JTextField JTSid = new JTextField();
	
	JLabel JLName = new JLabel("迟到次数");
	JTextField JTName = new JTextField();
	
	JLabel JLAge = new JLabel("旷工次数");
	JTextField JTAge = new JTextField();
	
	JLabel JLShenfen = new JLabel("加班次数");
	JTextField JTShenfen = new JTextField();
	
	JButton JBAdd = new JButton("确认");
	JButton JBClear = new JButton("清空");
	
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
	
	public modifyAttendance() {
		this.setTitle("修改考勤信息");
		this.setLayout(null);
	
		JL.setFont(new java.awt.Font("宋体", Font.PLAIN, 19));
		JL.setBounds(100,30,200,40);
		this.add(JL);
		
		JLSid.setBounds(100, 80, 100, 20);
		this.add(JLSid);
		JTSid.setBounds(200, 80, 80, 20);
		this.add(JTSid);
		
		JLName.setBounds(100, 120, 100, 20);
		this.add(JLName);
		JTName.setBounds(200, 120, 80, 20);
		this.add(JTName);
		
		JLAge.setBounds(100, 160, 100, 20);
		this.add(JLAge);
		JTAge.setBounds(200, 160, 80, 20);
		this.add(JTAge);
		
		JLShenfen.setBounds(100, 200, 100, 20);
		this.add(JLShenfen);
		JTShenfen.setBounds(200, 200, 80, 20);
		this.add(JTShenfen);
		
		JBAdd.setBounds(100, 250, 50, 20);
		this.add(JBAdd);
		JBAdd.addActionListener(this);
		
		JBClear.setBounds(200, 250, 50, 20);
		this.add(JBClear);
		JBClear.addActionListener(this);
		
		this.setBounds(320, 220, 420, 350);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBClear) {
			JTSid.setText("");
			JTName.setText(""); 
			JTAge.setText("");
			JTShenfen.setText("");
			
		}
		if(e.getSource() == JBAdd) {
			// get the information
			String sSid = JTSid.getText();
			String sName = JTName.getText();
			String sAge = JTAge.getText();
			String sShenfen = JTShenfen.getText();
			
			
			sql = "select * from attendance_info where sid = '"+sSid+"'";
			
			try {
				Class.forName(jd);
				// connect to database object
				connection = (Connection)DriverManager.getConnection(url, user, password);
				System.out.println("Successfully connected to the database attendance_info");
				// get the data
				java.sql.Statement statement = connection.createStatement();
				java.sql.ResultSet result_set = statement.executeQuery(sql);
				
				// 如果有结果，则给出提示，否则写入数据库
				if (!result_set.next()) 
					JOptionPane.showMessageDialog(null, "此工号员工不存在，请先添加！");
				else {
					sql = "delete from attendance_info where sid='"+sSid+"'";
					statement.executeUpdate(sql);
					sql = "insert into attendance_info values('"+sSid+"', '"+sName+"', '"+sAge+"', '"+sShenfen+"')";
					// 执行sql语句，并获得返回值
					int sqlResult = statement.executeUpdate(sql);
					if (sqlResult > 0) {
						JOptionPane.showMessageDialog(null, "修改成功！");
						JTSid.setText("");
						JTName.setText(""); 
						JTAge.setText("");
						JTShenfen.setText("");
						
					}
					else 
						JOptionPane.showMessageDialog(null, "修改失败...");
				}
						
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		
	}

}
