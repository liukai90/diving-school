package com.drs.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	/**
	 * 
	 * @param multipartFile 接收一个文件
	 * @param pic_path 接收新文件存储路径
	 * @return 返回文件路径及图片名称
	 * @throws Exception
	 */
	//此函数实现图片上传功能，适用于图片不多的小型项目
	public static String pictureUpload(MultipartFile multipartFile,String pic_path)throws Exception{
		
//		
//		String dateFile=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		
		String oldName=multipartFile.getOriginalFilename();
		
		if(multipartFile!=null&&oldName!=null&&oldName!=""){
			
			String newName=UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
			
			File newFile=new File(pic_path+newName);
			
			multipartFile.transferTo(newFile);
			
			return pic_path+newName;
			
			
			
		}
		return null;
	}
	
	/** 
	 * Description: 向FTP服务器上传文件 
	 * @param host FTP服务器hostname 
	 * @param port FTP服务器端口 
	 * @param username FTP登录账号 
	 * @param password FTP登录密码 
	 * @param basePath FTP服务器基础目录
	 * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
	 * @param filename 上传到FTP服务器上的文件名 
	 * @param input 输入流 
	 * @return 成功返回true，否则返回false 
	 */  
	//用于大型电商项目海量图片，需要专门的图片服务器来提高效率
//	public static boolean uploadFile(String host, int port, String username, String password, String basePath,
//			String filePath, String filename, InputStream input) {
//		boolean result = false;
//		FTPClient ftp = new FTPClient();
//		try {
//			int reply;
//			ftp.connect(host, port);// 连接FTP服务器
//			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
//			ftp.login(username, password);// 登录
//			reply = ftp.getReplyCode();
//			if (!FTPReply.isPositiveCompletion(reply)) {
//				ftp.disconnect();
//				return result;
//			}
//			//切换到上传目录
//			if (!ftp.changeWorkingDirectory(basePath+filePath)) {
//				//如果目录不存在创建目录
//				String[] dirs = filePath.split("/");
//				String tempPath = basePath;
//				for (String dir : dirs) {
//					if (null == dir || "".equals(dir)) continue;
//					tempPath += "/" + dir;
//					if (!ftp.changeWorkingDirectory(tempPath)) {
//						if (!ftp.makeDirectory(tempPath)) {
//							return result;
//						} else {
//							ftp.changeWorkingDirectory(tempPath);
//						}
//					}
//				}
//			}
//			//设置上传文件的类型为二进制类型
//			ftp.setFileType(FTP.BINARY_FILE_TYPE);
//			//上传文件
//			if (!ftp.storeFile(filename, input)) {
//				return result;
//			}
//			input.close();
//			ftp.logout();
//			result = true;
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (ftp.isConnected()) {
//				try {
//					ftp.disconnect();
//				} catch (IOException ioe) {
//				}
//			}
//		}
//		return result;
//	}


}
