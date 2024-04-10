package com.sathya.servlet;

import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

public class Product {
	private String proId;
	private String proName;
	private double proPrice;
	private String proBrand;
	private String proMadein;
	private Date proMfgDt;
	private Date proExpDt;
	private byte[] proImage;
	private byte[] proAudio;
	private byte[] proVideo;
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProMadein() {
		return proMadein;
	}
	public void setProMadein(String proMadein) {
		this.proMadein = proMadein;
	}
	public Date getProMfgDt() {
		return proMfgDt;
	}
	public void setProMfgDt(Date proMfgDt) {
		this.proMfgDt = proMfgDt;
	}
	public Date getProExpDt() {
		return proExpDt;
	}
	public void setProExpDt(Date proExpDt) {
		this.proExpDt = proExpDt;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	public byte[] getProAudio() {
		return proAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.proAudio = proAudio;
	}
	public byte[] getProVideo() {
		return proVideo;
		
	}
	public void setProVideo(byte[] proVideo) {
		this.proVideo = proVideo;
	}
	
	
}