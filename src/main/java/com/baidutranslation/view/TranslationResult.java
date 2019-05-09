package com.baidutranslation.view;

import java.util.List;

//{"from":"en","to":"zh","trans_result":[{"src":"apple","dst":"\u82f9\u679c"}]}
public class TranslationResult {
	private String from;
	private String to;
	private List<RS> trans_result;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<RS> getTrans_result() {
		return trans_result;
	}
	public void setTrans_result(List<RS> trans_result) {
		this.trans_result = trans_result;
	}
	
	@Override
	public String toString() {
		return "TranslationResult [from=" + from + ", to=" + to + ", trans_result=" + trans_result + "]";
	}
	
	
}
class RS{
	private String src;
	private String dst;
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	@Override
	public String toString() {
		return "RS [src=" + src + ", dst=" + dst + "]";
	}
	
}
