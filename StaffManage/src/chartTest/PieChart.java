package chartTest;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 测试生成报表图形
 *    Created by Jason  2016-7-18  上午7:14:59
 */
public class PieChart {
    /**
     * 提供静态方法：获取报表图形1：饼状图
     * @param title    标题
     * @param datas    数据
     * @param font    字体
     */
 //   public static JFreeChart createPort(String title, Font font){
	JFreeChart chart = null;
	
	int from10_20 = 0, from20_30 = 0, from30_40 = 0, above40 = 0;
	int totalAmount = 0;
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
	
	public PieChart() {
		try {
                //如果不使用Font,中文将显示不出来               
                
                //DefaultPieDataset pds = new DefaultPieDataset();
                DefaultPieDataset pds = getDataSet();
                
               
                /**
                 * 生成一个饼图的图表
                 * 
                 * 分别是:显示图表的标题、需要提供对应图表的DateSet对象、是否显示图例、是否生成贴士以及是否生成URL链接
                 */
                chart = ChartFactory.createPieChart("年龄分布", pds, true, false, true);
                //设置图片标题的字体
                Font font = new Font("新宋体", Font.BOLD, 15);
                chart.getTitle().setFont(font);
     
                //得到图块,准备设置标签的字体
                PiePlot plot = (PiePlot) chart.getPlot();
     
                //设置标签字体
                plot.setLabelFont(font);
     
                //设置图例项目字体
                chart.getLegend().setItemFont(font);
     
                /**
                 * 设置开始角度(弧度计算)
                 * 
                 * 度    0°    30°        45°        60°        90°        120°    135°    150°    180°    270°    360°
                 * 弧度    0    π/6        π/4        π/3        π/2        2π/3    3π/4    5π/6    π        3π/2    2π
                 */
                plot.setStartAngle(new Float(3.14f / 2f));
     
                
                //设置plot的前景色透明度
                plot.setForegroundAlpha(0.7f);
     
                //设置plot的背景色透明度
                plot.setBackgroundAlpha(0.0f);
     
                //设置标签生成器(默认{0})
                //{0}:key {1}:value {2}:百分比 {3}:sum
                plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}岁/{1}人/{2}") );
                
               
                
            } catch (Exception e) {
                e.printStackTrace();
            }
		
  }

		
	private DefaultPieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		sql = "select age from basic_info";
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
				JOptionPane.showMessageDialog(null, "数据库统计年龄失败");
			else {
				do {
					int temp = result_set.getInt(1);
					if (temp < 20) 
						this.from10_20++;
					else if (temp < 30)
						this.from20_30++;
					else if (temp <40)
						this.from30_40++;
					else
						this.above40++;
					totalAmount++;
					//System.out.println(String.valueOf(temp));
				} while(result_set.next());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		dataset.setValue("10~20", this.from10_20);
		dataset.setValue("20~30", this.from20_30);
		dataset.setValue("30~40", this.from30_40);
		dataset.setValue(">40", this.above40);
		return dataset;
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java数据统计图");
 		PieChart chart = new PieChart();
 		//JFreeChart chart = PieChart.createPort("试试看", font);  
 		frame.setLayout(new GridLayout(2,2,10,10));
 		frame.add(new ChartPanel(chart.getChart(), true));
 		frame.setBounds(50, 50, 800, 600);
 		frame.setVisible(true);
                
    }
    
    public JFreeChart getChart() {
    	return this.chart;
    }
    
    public int getTotalAmount() {
    	return this.totalAmount;
    }

	public int getFrom10_20() {
		return from10_20;
	}

	public int getFrom20_30() {
		return from20_30;
	}

	public int getFrom30_40() {
		return from30_40;
	}	

	public int getAbove40() {
		return above40;
	}

 }
