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

public class modifyLesson extends JFrame implements ActionListener{
	JLabel JL = new JLabel("修改培训信息");
	JLabel JLSid = new JLabel("课程号");
	JTextField JTSid = new JTextField();
	
	JLabel JLLate = new JLabel("课程名");
	JTextField JTLate = new JTextField();
	
	JLabel JLAbsent = new JLabel("培训单位");
	JTextField JTAbsent = new JTextField();
	
	JLabel JLAxtra = new JLabel("报名人数");
	JTextField JTExtra = new JTextField();
	
	JLabel JLPlace = new JLabel("培训地点");
	JTextField JTPlace = new JTextField();
	
	JLabel JLStart = new JLabel("开始时间");
	JTextField JTStart = new JTextField();
	
	JLabel JLEnd = new JLabel("结束时间");
	JTextField JTEnd = new JTextField();
	
	JButton JBAdd = new JButton("确认");
	JButton JBClear = new JButton("清空");
	
	String sql = "";
	// driver engine
	String jd = "com.mysql.cj.jdbc.Driver";
	// url
	String url = "jdbc:mysql://127.0.0.1:3306/train_info?useSSL=false";
	// user-name
	String user = "root";
	// pass-word
	String password = "wsad1234";
	// connection
	Connection connection = null;

	public modifyLesson() {
		this.setTitle("修改培训信息");
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
		
		JLPlace.setBounds(100, 240, 100, 20);
		this.add(JLPlace);
		JTPlace.setBounds(200, 240, 80, 20);
		this.add(JTPlace);
		
		JLStart.setBounds(100, 280, 100, 20);
		this.add(JLStart);
		JTStart.setBounds(200, 280, 80, 20);
		this.add(JTStart);
		
		JLEnd.setBounds(100, 320, 100, 20);
		this.add(JLEnd);
		JTEnd.setBounds(200, 320, 80, 20);
		this.add(JTEnd);
		
		
		
		JBAdd.setBounds(100, 370, 50, 20);
		this.add(JBAdd);
		JBAdd.addActionListener(this);
		
		JBClear.setBounds(200, 370, 50, 20);
		this.add(JBClear);
		JBClear.addActionListener(this);
		
		this.setBounds(320, 220, 380, 450);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBClear) {
			JTSid.setText("");
			JTLate.setText(""); 
			JTAbsent.setText("");
			JTExtra.setText("");
			JLPlace.setText("");
			JLStart.setText("");
			JLEnd.setText("");
			
		}
		if(e.getSource() == JBAdd) {
			// get the information
			String sSid = JTSid.getText();
			String sLate = JTLate.getText();
			String sAbsent = JTAbsent.getText();
			String sShenfen = JTExtra.getText();
			String sPlace = JTPlace.getText();
			String sStart = JTStart.getText();
			String sEnd = JTEnd.getText();

			sql = "select * from lesson_info where tid = '"+sSid+"'";
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
					sql = "delete from lesson_info where tid='"+sSid+"'";
					statement.executeUpdate(sql);
					sql = "insert into lesson_info values"
							+ "('"+sSid+"', '"+sLate+"', '"+sAbsent+"', '"+sShenfen+"', '"+sPlace+"', "+sStart+", "+sEnd+")";
					// 执行sql语句，并获得返回值
					int sqlResult = statement.executeUpdate(sql);
					if (sqlResult > 0) {
						JOptionPane.showMessageDialog(null, "修改成功！");
						JTSid.setText("");
						JTLate.setText(""); 
						JTAbsent.setText("");
						JTExtra.setText("");
						JLPlace.setText("");
						JLStart.setText("");
						JLEnd.setText("");
						
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
