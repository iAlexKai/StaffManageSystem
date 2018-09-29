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

public class addAttendance extends JFrame implements ActionListener{
	JLabel JL = new JLabel("添加员工考勤信息");
	
	JLabel JLSid = new JLabel("工号");
	JTextField JTSid = new JTextField();
	
	JLabel JLLate = new JLabel("迟到次数");
	JTextField JTLate = new JTextField();
	
	JLabel JLAbsent = new JLabel("旷工次数");
	JTextField JTAbsent = new JTextField();
	
	JLabel JLAxtra = new JLabel("加班次数");
	JTextField JTExtra = new JTextField();
	
	JButton JBAdd = new JButton("添加");
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
	
	public addAttendance() {
		this.setTitle("添加员工信息");
		this.setLayout(null);
	
		JL.setFont(new java.awt.Font("宋体", Font.PLAIN, 19));
		JL.setBounds(100,30,200,40);
		this.add(JL);
		
		JLSid.setBounds(100, 80, 100, 20);
		this.add(JLSid);
		JTSid.setBounds(200, 80, 80, 20);
		this.add(JTSid);
		
		JLLate.setBounds(100, 120, 100, 20);
		this.add(JLLate);
		JTLate.setBounds(200, 120, 80, 20);
		this.add(JTLate);
		
		JLAbsent.setBounds(100, 160, 100, 20);
		this.add(JLAbsent);
		JTAbsent.setBounds(200, 160, 80, 20);
		this.add(JTAbsent);
		
		JLAxtra.setBounds(100, 200, 100, 20);
		this.add(JLAxtra);
		JTExtra.setBounds(200, 200, 80, 20);
		this.add(JTExtra);
		
		JBAdd.setBounds(100, 250, 50, 20);
		this.add(JBAdd);
		JBAdd.addActionListener(this);
		
		JBClear.setBounds(200, 250, 50, 20);
		this.add(JBClear);
		JBClear.addActionListener(this);
		
		this.setBounds(320, 220, 420, 350);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBClear) {
			JTSid.setText("");
			JTLate.setText(""); 
			JTAbsent.setText("");
			JTExtra.setText("");
		}
		if(e.getSource() == JBAdd) {
			// get the information
			String sSid = JTSid.getText();
			String sLate = JTLate.getText();
			String sAbsent = JTAbsent.getText();
			String sShenfen = JTExtra.getText();
			
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
				if (result_set.next()) 
					JOptionPane.showMessageDialog(null, "此工号对应的员工考勤已存在，请重新输入！");
				else {
					sql = "insert into attendance_info values('"+sSid+"', '"+sLate+"', '"+sAbsent+"', '"+sShenfen+"')";
					// 执行sql语句，并获得返回值
					int sqlResult = statement.executeUpdate(sql);
					if (sqlResult > 0) {
						JOptionPane.showMessageDialog(null, "添加成功！");
						JTSid.setText("");
						JTLate.setText(""); 
						JTAbsent.setText("");
						JTExtra.setText("");
						
					}
					else 
						JOptionPane.showMessageDialog(null, "添加失败...");
				}
						
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		
	}

}
