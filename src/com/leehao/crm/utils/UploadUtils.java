package com.leehao.crm.utils;

import java.util.UUID;

/** 
 * @author fanleehao
 * @date 创建时间：2019年1月22日 下午2:17:26 
 * @desc 文件上传，目录和文件名冲突问题
 **/
public class UploadUtils {
	//文件名问题
	public static String getRandomFileName(String filename) {
		int lastIndexOf = filename.lastIndexOf(".");
		String extention = filename.substring(lastIndexOf);
		return UUID.randomUUID().toString().replace("-", "") + extention;
	}
	
	//构建目录
	
	public static String getRandomFloderName(String filename) {
		//哈希+右移算法，产生16的8次方个目录
		int hashCode = filename.hashCode();
		int d1 = hashCode & 0xf;  //1级目录
		int hascode2 = hashCode >>> 4;
		int d2 = hascode2 & 0xf;  //2级目录
		return "/" + d1 + "/" + d2;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getRandomFileName("a.txt"));
	}
}
