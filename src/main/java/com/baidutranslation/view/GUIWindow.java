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
		Frame f = new Frame();//����һ�����塣
		f.setTitle("�ٶȷ���");//���ô���ı���
		f.setSize(300, 300);//�ߴ磺300*300px
		f.setLocationRelativeTo(null);//����ˮƽ����ֱ���С�
		//f.setResizable(false);//���ô���߿򲻿����졣
		//���õ������ر�ʱ�˳�����
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//�˳�����
				System.exit(0);
			}
		});
		//Panel
		Panel p = new Panel();//�����м�������
		p.setLayout( new BorderLayout( ));//�����м������Ĳ��ֹ�����Ϊ��BorderLayout
		f.add( p );//���м��������붥��������
		
		Button b1 = new Button("����");
		TextField input = new TextField( 20);//���������
		TextArea textarea = new TextArea( );//����
		//����һ����壬�������Ͱ�ť�ŵ�һ��
			Panel innerp = new Panel();
			innerp.add(input);//
			innerp.add(b1);//����ť��ӵ������
		//�ٽ��ڲ���壬�����ⲿ���ı��ߡ�
		p.add(innerp, "North");
		p.add( textarea,"Center" );//���ı�����ӵ������:�в���
		f.setVisible(true);//���ô���ɼ���
		
		//���¼�
		b1.addActionListener( e->{
			 //���÷���ӿڡ�
			String q = input.getText();//��ȡ���������֡�
			try {
				String rs = BaiduTranslateUtils.getFY(q, "en", "zh");
				textarea.setText(rs );//�ѷ������ŵ��ı�����
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
}
