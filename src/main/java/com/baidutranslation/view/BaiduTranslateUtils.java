package com.baidutranslation.view;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONObject;
import com.utils.MD5Utils;

public class BaiduTranslateUtils {
	/**英文--》中文。
	 * 传入一个原文。返回原文对应译文。
	 * @param q
	 * @return
	 * @throws Exception
	 */
	public static String getFY(String q,String from,String to) throws Exception {
		String sk = "yAkagL8Ixq_4B6jN0E9q";//秘钥
		//String q = "InputStream";
		//String q = "Reads some number of bytes from the input stream and stores them into the buffer array ";
		//String from = "en";
		//String to = "zh";
		String appid = "20190316000277808";// appid
		String salt = "123456789";
		
		//appid+q+salt+sk 的MD5值
		//(1) appid+q+salt+sk拼接。
		String temp = appid + q + salt + sk;
		//(2) 算出md5值。计算md5之前，temp必须为UTF-8编码
		byte [] bs = temp.getBytes("UTF-8");
		String sign = MD5Utils.md5_32( bs );
		String url_str = "http://api.fanyi.baidu.com/api/trans/vip/translate";
		String send_url = url_str+  "?q="+q+
									"&from="+from+
								    "&to="+to+
								    "&appid="+appid+
								    "&salt="+salt+
								    "&sign="+sign;
		//将拼接完成之后的URL发送出去。
		URL url = new URL(send_url);
		URLConnection conn = url.openConnection();
		//获取翻译结果。
		//翻译结果会被百度翻译服务端，以HTTP响应的方式。
		//放入响应报文。
		conn.setDoInput(true);
		InputStream in = conn.getInputStream();
		byte []datas = new byte[conn.getContentLength()];
		in.read(datas);
		//					编码？ 
		//打印结果。byte []  ==> String
		String rsstr = new String(datas,"GBK");
		Object obj = JSONObject.parse( rsstr );
		//System.out.println(obj);
		
		JSONObject rs = JSONObject.parseObject(rsstr);
		 TranslationResult rr = rs.toJavaObject(TranslationResult.class);
		String yiwen = rr.getTrans_result().get(0).getDst();
		 
		return yiwen;
		 
	}
}
