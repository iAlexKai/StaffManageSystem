package chartTest;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
	ChartPanel frame1;
/*	public static void main(String args[]) {
		JFrame frame = new JFrame("Java数据统计图");
		new BarChart();
		frame.setLayout(new GridLayout(2,2,10,10));
		ChartPanel chart = new BarChart().getChartPanel();
		frame.add(chart);
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}
*/	
	private static int maleAmount;
	private static int famaleAmount;
	
	static String sql = "";
	// driver engine
	static String jd = "com.mysql.cj.jdbc.Driver";
	// url
	static String url = "jdbc:mysql://127.0.0.1:3306/staff_info?useSSL=false";
	// user-name
	static String user = "root";
	// pass-word
	static String password = "wsad1234";
	// connection
	static Connection connection = null;
	
	
	public BarChart() {
		getSexAmount();
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createBarChart3D(
							"性别分布",  //title
							"性别",  //目录轴标签
							"数量",  //数据轴标签//
							dataset, //数据集
							PlotOrientation.VERTICAL, 
							false,    // 图例显示, 简单柱形图必须为false
							false,   // 是否生成工具
							false    // 是否生成url链接
							);
		// 配置
		CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
		CategoryAxis domainAxis=plot.getDomainAxis(); //水平底部列表  
		domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));//水平底部标题  
		domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));//垂直标题  
		ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	//	chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); // 图例字体
		chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
	
		frame1 = new ChartPanel(chart, true);
			
	}
	
	
	
	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//int maleAmount = getMaleAmount(), famaleAmount = getFamaleAmount();
		dataset.addValue(maleAmount, "男", "男"); 
		dataset.addValue(famaleAmount, "女", "女"); 
		/*dataset.addValue(400, "1", "栗子"); 
		dataset.addValue(100, "1", "橙子"); 
		dataset.addValue(200, "1", "苹果"); 
		*/
		return dataset;
	}
	
	public ChartPanel getChartPanel() {
		return frame1;
	}

	public static void getSexAmount() {
		sql = "select sex, count(sex) from basic_info group by sex";
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
				JOptionPane.showMessageDialog(null, "数据库统计性别个数失败");
			else {
				maleAmount = result_set.getInt(2); // 获取第一列的值
				result_set.next();
				famaleAmount = result_set.getInt(2); 
				System.out.println(String.valueOf(maleAmount) + " " +  String.valueOf(famaleAmount));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	
}


