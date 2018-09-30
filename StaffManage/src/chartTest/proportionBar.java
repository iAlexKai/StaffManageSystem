package chartTest;

import java.awt.Font;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class proportionBar {
	JFrame frame = null;
	ChartPanel frame1 = null;
	public proportionBar(double[] msg) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(msg[0], "二手房", "二手房"); 
		dataset.addValue(msg[1], "商铺外包", "商铺外包"); 
		dataset.addValue(msg[2], "装修", "装修"); 
		dataset.addValue(msg[3], "房屋租赁", "房屋租赁"); 
		dataset.addValue(msg[4], "期房炒作", "期房炒作"); 
		dataset.addValue(msg[5], "项目施工", "项目施工"); 
		dataset.addValue(msg[6], "物业管理", "物业管理"); 
		dataset.addValue(msg[7], "房贷业务", "房贷业务"); 
		dataset.addValue(msg[8], "建材", "建材"); 
		dataset.addValue(msg[9], "土地转让", "土地转让");
		
		JFreeChart chart = ChartFactory.createBarChart3D(
							"市场占有比",  //title
							"业务",  //目录轴标签
							"占比",  //数据轴标签//
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
		
		frame = new JFrame();
		frame1 = new ChartPanel(chart, true);
		frame.add(frame1);
		frame.setBounds(300, 200, 800, 400);
		frame.setVisible(true);
	}
	
	public ChartPanel getChartPanel(){
        return frame1;
    }
	
}
