
      
    import java.io.File;      

import java.io.FileInputStream;      
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
      

import java.util.HashMap;
import java.util.logging.Logger;

    import org.apache.commons.net.ftp.FTPClient;      
import org.apache.commons.net.ftp.FTPFile;  
import org.apache.commons.net.ftp.FTPReply;      
import org.apache.commons.net.nntp.NewGroupsOrNewsQuery;
          
    /**  
     * @author   
     * 
     * @title Ftp 
     * @Description :  FTP 上传下载工具类  
     * @time 2013-11-27   
     */  
    public class Ftp {        
             
        private  FTPClient ftp;        
        /**    
         *     
         * @param path 上传到ftp服务器哪个路径下       
         * @param addr 地址    
         * @param port 端口号    
         * @param username 用户名    
         * @param password 密码    
         * @return    
         * @throws Exception    
         */      
       public  boolean connect(String path,String addr,int port,String username,String password) throws Exception {        
            boolean result = false;        
            ftp = new FTPClient();  
            ftp.setControlEncoding("GBK");
            int reply;        
            ftp.connect(addr,port);        
            ftp.login(username,password);        
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);        
            reply = ftp.getReplyCode();        
            if (!FTPReply.isPositiveCompletion(reply)) {        
                ftp.disconnect();        
                return result;        
            }        
            ftp.changeWorkingDirectory(path);        
            result = true;        
            return result;        
        }        
          
          
          
        /**  
         * @author   
         * @class  ItemFtp  
         * @title  upload  
         * @Description :   
         * @time 2013 2013-11-27  
         * @return void  
         * @exception :(Error note)  
         * @param file 上传的文件或文件夹  
         * @param path 上传的文件的路径   
         * @throws Exception  
         */  
        public void upload(File file , String path) throws Exception{     
              
            System.out.println( " file.isDirectory() : " + file.isDirectory()  );  
              
            if(file.isDirectory()){             
                ftp.makeDirectory(file.getName());                  
                ftp.changeWorkingDirectory(file.getName());        
                String[] files = file.list();               
                for (int i = 0; i < files.length; i++) {        
                    File file1 = new File(file.getPath()+"\\"+files[i] );        
                    if(file1.isDirectory()){        
                        upload(file1 , path );        
                        ftp.changeToParentDirectory();        
                    }else{                      
                        File file2 = new File(file.getPath()+"\\"+files[i]);        
                        FileInputStream input = new FileInputStream(file2);        
                        ftp.storeFile(file2.getName(), input);        
                        input.close();                              
                    }                   
                }        
            }else{        
                File file2 = new File(file.getPath());      
                  
                System.out.println( " file.getPath() : " + file.getPath()  + " | file2.getName() : " + file2.getName() );  
                  
                InputStream input = new FileInputStream(file2);     
                   
                ftp.changeWorkingDirectory(path);     
                ftp.storeFile(file2.getName(), input);        
                  
                input.close();  //关闭输入流  
                ftp.logout();  //退出连接  
            }        
        }      
          
          
             
        /**  
         * @author   
         * @class  ItemFtp  
         * @title  download  
         * @Description : FPT 下载文件方法  
         * @time 2013 2013-11-27  
         * @return void  
         * @exception :(Error note)  
         * @param reomvepath 下载的文件的路径   
         * @param fileName  下载的文件名   
         * @param localPath 下载的文件本地路径  
         * @throws Exception  
         */  
        @SuppressWarnings("unused")  
        public void download(String reomvepath , HashMap<String,Course> kb, String localPath  ) throws Exception{     
        	System.out.println("执行下载");
                ftp.changeWorkingDirectory(reomvepath); 
                //ftp.listFiles()假死的暂时处理方法
                ftp.enterLocalPassiveMode();
             // 列出该目录下所有文件  
                FTPFile[] fs = ftp.listFiles(); 
                
                // 遍历所有文件，找到指定的文件  
                for (FTPFile ff : fs) {  
                	System.out.println(ff.getName());
                	for(Course course:kb.values()){
                		if(ff.getName().equals(course.getCourseTeacher())){
                			ftp.changeWorkingDirectory(course.getCourseTeacher());
                			FTPFile[] kbs=ftp.listFiles();
                			for (FTPFile kbf : kbs) {  
                			//	System.out.println(kbf.getName());
                				if(kbf.getName().indexOf(course.getCourseName())>1){
                					System.out.println(kbf.getName());
                					File file=new File(localPath+"\\"+kbf.getName());
                					if(kbf.isDirectory()){
                						file.mkdir();
                					}
                					downLoadFile(ftp, kbf.getName(), file.getPath(), "");
                					//根据绝对路径初始化文件  
                                  //  File localFile = new File(localPath + "\\" + ff.getName());  
                                    // 输出流  
                                   // OutputStream is = new FileOutputStream(localFile);  
                                    // 下载文件  
                                  //  ftp.retrieveFile(kbf.getName(), is);  
                                  //  System.out.println("下载成功!"); 
                                   // is.close(); 
                					System.out.println("---------------");
                				}
                			}
                			
                		}
                		ftp.changeWorkingDirectory(reomvepath);
                	}
                       
                    //    
                }  
                  
                ftp.logout();  //退出连接  
                  
        }   
        
        private void downLoadFile(FTPClient ftp, String remote, String local, String validate)  
        {  
        	
        	System.out.println(remote+"    "+local);
            try  
            {  
       
                // 转到指定下载目录  
                ftp.changeWorkingDirectory(remote);  
       
                FTPFile[] files = ftp.listFiles();  
       
                for (FTPFile file : files)  
                {  
                	System.out.println(file.getName());
                	if(file.getName().indexOf("资料")==-1){
                    if (file.isDirectory()&&!file.getName().equals(".")&&!file.getName().equals("..")) 
                    {  
                        downLoadFile(ftp, file.getName() , local + "\\" + file.getName(),  
                                validate);  
                    }  
                    else  if(!file.getName().equals(".")&&!file.getName().equals(".."))
                    {   
                        File localFile = new File(local + "\\" +file.getName());  
       
                        if (!localFile.getParentFile().exists())  
                        {  
                            localFile.getParentFile().mkdirs();  
                        }  
                        
                        if(!localFile.exists()){
                        	localFile.createNewFile();
                        }
                        
                            // 输出 
                            OutputStream is = new FileOutputStream(localFile);  
                            // 下载文件
                            ftp.retrieveFile(file.getName(), is);  
       
                            is.close();  
                          
       
                    }  
                }  
                }
                ftp.changeToParentDirectory();
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
       
        }     
          
       public static void main(String[] args) throws Exception{      
               
           Ftp t = new Ftp();      
            
           boolean lianjie = t.connect("//", "211.80.196.1", 21, "download", "download");      
          System.out.println( "连接 ：" + lianjie +"dsfddf" );  
            
          //上传  
    //      File file = new File("d:\\test.txt");    
    //      t.upload(file , "E:\\ftptest\\mulu");    
            
          //下载  
          //t.download1("//", "", ""); 
            
            
       }      
    }   
