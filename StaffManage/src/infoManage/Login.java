package infoManage;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Login extends Frame implements ActionListener{
	JLabel JLUserName = new JLabel("用户名： ");  // 变量命名中L表示Label
	JLabel JLPassword = new JLabel("密  码： ");
	JTextField JTUserName = new JTextField();  // 变量命名中T表示Text
	JPasswordField JPassword = new JPasswordField();
	JButton JBLogin = new JButton("登录");  // 登录
	JButton JBClear = new JButton("清空"); // 清空

	
	public Login(){
		this.setTitle("企业员工管理系统");  
		this.setLayout(null);
		
		JLUserName.setBounds(100, 60, 100, 20); // 标签的大小，位置
		this.add(JLUserName); 
		
		JTUserName.setBounds(200, 60, 120, 20); // 输入框大小和位置
		this.add(JTUserName);
		
		JLPassword.setBounds(100, 120, 60, 20); 
		this.add(JLPassword);
		
		JPassword.setBounds(200, 120, 120, 20);
		this.add(JPassword);
		
		JBLogin.setBounds(230, 200, 60, 20);
		this.add(JBLogin);
		JBLogin.addActionListener(this);
		
		JBClear.setBounds(100, 200, 60, 20);
		this.add(JBClear);
		JBClear.addActionListener(this);
		
		this.setVisible(true);
		this.setBounds(300,200,400,250);
		addWindowListener(new WindowAdapter(){  // 设置关闭窗口的事件监听
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[]) {
		new Login();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBLogin) { // 用户点击了登录
			String name = JTUserName.getText(); // 获取用户名输入
			String password = new String(JPassword.getPassword()); // 获取密码输入
			if (name != null && name.equals("wly") && password != null && password.equals("wly")) { // 只有账号 = wly 密码 = wly时候才可以登录成功
				new MainPage();
				this.setVisible(false); // 登录成功，隐藏该窗口
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码不正确，请重新输入!");
			}
		}
		
		if (e.getSource() == JBClear) {  // 清空输入
			JTUserName.setText("");
			JPassword.setText("");
		}
	}
}
