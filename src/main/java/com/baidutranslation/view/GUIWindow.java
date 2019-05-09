package com.baidutranslation.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class GUIWindow {
	public static void main(String[] args) {
		//Frame--
		Frame f = new Frame();//创建一个窗体。
		f.setTitle("百度翻译");//设置窗体的标题
		f.setSize(300, 300);//尺寸：300*300px
		f.setLocationRelativeTo(null);//窗体水平、垂直居中。
		//f.setResizable(false);//设置窗体边框不可拉伸。
		//设置点击窗体关闭时退出程序。
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//退出程序。
				System.exit(0);
			}
		});
		//Panel
		Panel p = new Panel();//创建中间容器。
		p.setLayout( new BorderLayout( ));//设置中间容器的布局管理器为：BorderLayout
		f.add( p );//将中间容器放入顶层容器。
		
		Button b1 = new Button("翻译");
		TextField input = new TextField( 20);//单行输入框。
		TextArea textarea = new TextArea( );//多行
		//先用一个面板，将输入框和按钮放到一起。
			Panel innerp = new Panel();
			innerp.add(input);//
			innerp.add(b1);//将按钮添加到面板中
		//再将内部面板，放入外部面板的北边。
		p.add(innerp, "North");
		p.add( textarea,"Center" );//将文本狂添加到面板中:中部。
		f.setVisible(true);//设置窗体可见。
		
		//绑定事件
		b1.addActionListener( e->{
			 //调用翻译接口。
			String q = input.getText();//获取输入框的文字。
			try {
				String rs = BaiduTranslateUtils.getFY(q, "en", "zh");
				textarea.setText(rs );//把翻译结果放到文本狂中
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
}
