package infoManage;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import chartTest.TimeSeriesChart;
import chartTest.proportionBar;

public class Real_estate_info extends MainPage  {

	JPanel subPanel = null;
	JPanel subPanel2 = null;
	JPanel subPanel3 = null;
	JPanel subPanel4 = null;
	JPanel subPanel5 = null;
	JLabel JL1 = new JLabel("二手房： "); 
	JTextField JT1 = new JTextField(3); 
	JLabel JL2 = new JLabel("商铺外包： "); 
	JTextField JT2 = new JTextField(3); 
	JLabel JL3 = new JLabel("装修： "); 
	JTextField JT3 = new JTextField(3); 
	JLabel JL4 = new JLabel("房屋租赁： "); 
	JTextField JT4 = new JTextField(3); 
	JLabel JL5 = new JLabel("期房炒作： "); 
	JTextField JT5 = new JTextField(3); 
	JLabel JL6 = new JLabel("项目施工： "); 
	JTextField JT6 = new JTextField(3); 
	JLabel JL7 = new JLabel("物业管理： "); 
	JTextField JT7 = new JTextField(3); 
	JLabel JL8 = new JLabel("房贷业务： "); 
	JTextField JT8 = new JTextField(3); 
	JLabel JL9 = new JLabel("建材： "); 
	JTextField JT9 = new JTextField(3); 
	JLabel JL10 = new JLabel("土地转让： "); 
	JTextField JT10 = new JTextField(3); 
	JButton JBAdd = new JButton("市场占比");
	
	JLabel JLershou = new JLabel("二手房");
	JLabel JL11 = new JLabel("2013： "); 
	JTextField JT11 = new JTextField(3); 
	JLabel JL12 = new JLabel("2014： "); 
	JTextField JT12 = new JTextField(3); 
	JLabel JL13 = new JLabel("2015： "); 
	JTextField JT13 = new JTextField(3); 
	JLabel JL14 = new JLabel("2016： "); 
	JTextField JT14 = new JTextField(3); 
	JLabel JL15 = new JLabel("2017： "); 
	JTextField JT15 = new JTextField(3);
	
	JLabel JLshangpu = new JLabel("商铺外包");
	JLabel JL16 = new JLabel("2013： "); 
	JTextField JT16 = new JTextField(3); 
	JLabel JL17 = new JLabel("2014： "); 
	JTextField JT17 = new JTextField(3); 
	JLabel JL18 = new JLabel("2015： "); 
	JTextField JT18 = new JTextField(3); 
	JLabel JL19 = new JLabel("2016： "); 
	JTextField JT19 = new JTextField(3); 
	JLabel JL20 = new JLabel("2017： "); 
	JTextField JT20 = new JTextField(3);
	
	JLabel JLzhuangxiu = new JLabel("装修");
	JLabel JL21 = new JLabel("2013： "); 
	JTextField JT21 = new JTextField(3); 
	JLabel JL22 = new JLabel("2014： "); 
	JTextField JT22 = new JTextField(3); 
	JLabel JL23 = new JLabel("2015： "); 
	JTextField JT23 = new JTextField(3); 
	JLabel JL24 = new JLabel("2016： "); 
	JTextField JT24 = new JTextField(3); 
	JLabel JL25 = new JLabel("2017： "); 
	JTextField JT25 = new JTextField(3); 
	
	JLabel JLzulin = new JLabel("房屋租赁");
	JLabel JL26 = new JLabel("2013： "); 
	JTextField JT26 = new JTextField(3); 
	JLabel JL27 = new JLabel("2014： "); 
	JTextField JT27 = new JTextField(3); 
	JLabel JL28 = new JLabel("2015： "); 
	JTextField JT28 = new JTextField(3); 
	JLabel JL29 = new JLabel("2016： "); 
	JTextField JT29 = new JTextField(3); 
	JLabel JL30 = new JLabel("2017： "); 
	JTextField JT30 = new JTextField(3);
	
	JButton JBTurnover = new JButton("营业额");
	
	
	
	
	public Real_estate_info() {
		this.setLayout(new FlowLayout());
		subPanel = new JPanel();
		subPanel.setLayout(new FlowLayout());
		subPanel.add(JL1);
		subPanel.add(JT1);
		subPanel.add(JL2);
		subPanel.add(JT2);
		subPanel.add(JL3);
		subPanel.add(JT3);
		subPanel.add(JL4);
		subPanel.add(JT4);
		subPanel.add(JL5);
		subPanel.add(JT5);
		subPanel.add(JL6);
		subPanel.add(JT6);
		subPanel.add(JL7);
		subPanel.add(JT7);
		subPanel.add(JL8);
		subPanel.add(JT8);
		subPanel.add(JL9);
		subPanel.add(JT9);
		subPanel.add(JL10);
		subPanel.add(JT10);
		subPanel.add(JBAdd);
		
		subPanel2 = new JPanel();
		//subPanel2.setLayout(new GridLayout(6,10));
		subPanel2.setLayout(new FlowLayout());
		subPanel2.add(JLershou);
		subPanel2.add(JL11);
		subPanel2.add(JT11);
		subPanel2.add(JL12);
		subPanel2.add(JT12);
		subPanel2.add(JL13);
		subPanel2.add(JT13);
		subPanel2.add(JL14);
		subPanel2.add(JT14);
		subPanel2.add(JL15);
		subPanel2.add(JT15);
		
		subPanel3 = new JPanel();
		subPanel3.setLayout(new FlowLayout());
		subPanel3.add(JLshangpu);
		subPanel3.add(JL16);
		subPanel3.add(JT16);
		subPanel3.add(JL17);
		subPanel3.add(JT17);
		subPanel3.add(JL18);
		subPanel3.add(JT18);
		subPanel3.add(JL19);
		subPanel3.add(JT19);
		subPanel3.add(JL20);
		subPanel3.add(JT20);
		
		
		subPanel4 = new JPanel();
		//subPanel2.setLayout(new GridLayout(6,10));
		subPanel4.setLayout(new FlowLayout());
		subPanel4.add(JLzhuangxiu);
		subPanel4.add(JL21);
		subPanel4.add(JT21);
		subPanel4.add(JL22);
		subPanel4.add(JT22);
		subPanel4.add(JL23);
		subPanel4.add(JT23);
		subPanel4.add(JL24);
		subPanel4.add(JT24);
		subPanel4.add(JL25);
		subPanel4.add(JT25);
		
		
		subPanel5 = new JPanel();
		subPanel5.setLayout(new FlowLayout());
		subPanel5.add(JLzulin);
		subPanel5.add(JL26);
		subPanel5.add(JT26);
		subPanel5.add(JL27);
		subPanel5.add(JT27);
		subPanel5.add(JL28);
		subPanel5.add(JT28);
		subPanel5.add(JL29);
		subPanel5.add(JT29);
		subPanel5.add(JL30);
		subPanel5.add(JT30);
		subPanel5.add(JBTurnover);
		
		
		this.add(subPanel);
		this.add(subPanel2);
		this.add(subPanel3);
		this.add(subPanel4);
		this.add(subPanel5);
		this.setBounds(100,200,1300,600);
		
		
		JBAdd.addActionListener(this);
		JBTurnover.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBAdd) {
			double[] msg = new double[10];
			msg[0] = Double.parseDouble(JT1.getText());
			msg[1] = Double.parseDouble(JT2.getText());
			msg[2] = Double.parseDouble(JT3.getText());
			msg[3] = Double.parseDouble(JT4.getText());
			msg[4] = Double.parseDouble(JT5.getText());
			msg[5] = Double.parseDouble(JT6.getText());
			msg[6] = Double.parseDouble(JT7.getText());
			msg[7] = Double.parseDouble(JT8.getText());
			msg[8] = Double.parseDouble(JT9.getText());
			msg[9] = Double.parseDouble(JT10.getText());
			//this.add(new proportionBar(msg).getChartPanel());
			new proportionBar(msg);
		}
		
		if(e.getSource() == JBTurnover) {
			double[] msg = new double[20];
			msg[0] = Double.parseDouble(JT11.getText());
			msg[1] = Double.parseDouble(JT12.getText());
			msg[2] = Double.parseDouble(JT13.getText());
			msg[3] = Double.parseDouble(JT14.getText());
			msg[4] = Double.parseDouble(JT15.getText());
			msg[5] = Double.parseDouble(JT16.getText());
			msg[6] = Double.parseDouble(JT17.getText());
			msg[7] = Double.parseDouble(JT18.getText());
			msg[8] = Double.parseDouble(JT19.getText());
			msg[9] = Double.parseDouble(JT20.getText());
			msg[10] = Double.parseDouble(JT21.getText());
			msg[11] = Double.parseDouble(JT22.getText());
			msg[12] = Double.parseDouble(JT23.getText());
			msg[13] = Double.parseDouble(JT24.getText());
			msg[14] = Double.parseDouble(JT25.getText());
			msg[15] = Double.parseDouble(JT26.getText());
			msg[16] = Double.parseDouble(JT27.getText());
			msg[17] = Double.parseDouble(JT28.getText());
			msg[18] = Double.parseDouble(JT29.getText());
			msg[19] = Double.parseDouble(JT30.getText());
			
//			for(int i = 0; i < 20; i++) {
//				System.out.println(msg[i] + "\n");
//			}
			JFrame turnOver = new JFrame("近五年总营业额比较");
			turnOver.add(new TimeSeriesChart(msg).getChartPanel());
			turnOver.setBounds(300, 200, 800, 400);
			turnOver.setVisible(true);
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
	}
	
	
	
}


