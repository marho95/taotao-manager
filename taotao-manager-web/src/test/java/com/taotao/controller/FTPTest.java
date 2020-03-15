package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {

	@Test
	public void testFtpClient() throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接。默认是21端口
		ftpClient.connect("47.102.125.49", 21);
		//登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "password");
		//上传文件。
		//读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\MarHo\\Pictures\\he.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数：服务器端文档名
		//第二个参数：上传文档的inputStream
		ftpClient.storeFile("hello5.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
		
	}
	
	@Test
	public void testFtpUtil() throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\MarHo\\Pictures\\he.jpg"));
		boolean result = FtpUtil.uploadFile("47.102.125.49", 21, "ftpuser", "password", "/home/ftpuser/www/images", "/2020/02/26", "hello8.jpg", inputStream);
		System.out.println(result);
	}
}
