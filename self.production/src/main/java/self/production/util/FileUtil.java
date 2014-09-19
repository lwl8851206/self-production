package self.production.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class FileUtil {

	public FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 创建文件
	 * @param dir
	 * @param file
	 */
	public static void createFile(String dir, String file) {
		File ddir = new File(dir);
		if (!ddir.exists())
			ddir.mkdir();
		File ffile = new File(ddir, file);
		if(!ffile.exists())
			try {
				ffile.createNewFile();
				System.out.println(dir + file + " is created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * 删除文件
	 * @param dir
	 * @param file
	 */
	public static void removeFile(String dir, String file) {
		File ddir = new File(dir);
		if (!ddir.exists())
			return;
		File ffile = new File(ddir, file);
		if(ffile.exists())
			ffile.delete();		
		System.out.printf("file[%s] is removed from dir[%s]", file, dir);
	}
	
	
	/**
	 *  创建目录
	 * @param dir
	 */
	public static void createDir(String dir) {
		File ddir = new File(dir);
		if (!ddir.exists())
			ddir.mkdir();	
	}

	/**
	 * 批量创建目录
	 * @param dirs
	 */
	public static void createDir(String baseDir, HashSet<String> dirs) {
		Iterator<String> ite = dirs.iterator();
		while (ite.hasNext())
			createDir(baseDir + ite.next());
	}
	
	/**
	 * 删除目录
	 * @param dir
	 */
	public static void removeDir(String dir) {
		File ddir = new File(dir);
		if (ddir.exists())
			ddir.delete();	
	}
	
	/**
	 * 批量删除目录
	 * @param dirs
	 */
	public static void removeDir(String baseDIr, HashSet<String> dirs) {
		Iterator<String> ite = dirs.iterator();
		while (ite.hasNext())
			removeDir(baseDIr + ite.next());
	}
	
	
	/**
	 * 修改文件内容
	 * @param dir
	 * @param file
	 * @param content
	 */
	public static void editFile(String dir, String file, String content) {
		FileWriter os = null;
		System.out.println("dir:" + dir);
		System.out.println("file:" + file);
		System.out.println("content:\n" + content);
			try {
				//无论是否有文件存在，都一定会将内容写入文件
				createFile(dir, file);
				os = new FileWriter(dir + "/" + file);
				System.out.println("write content: " + content);
				os.write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	
	
	/**
	 * 读取文件内容
	 * @param dir
	 * @param file
	 * @return
	 */
	public static String readFile(String dir, String file) {
		File ddir = new File(dir);
		String result = "";
		FileInputStream fi = null;
		if (!ddir.exists())
			return null;
		File ffile = new File(ddir, file);
		if(!ffile.exists())
			return null;
		try {
			fi = new FileInputStream(ffile);
			byte [] buf = new byte[1024];
			int len = 0;
			while ((len = fi.read(buf)) != -1) {
				result += new String(buf, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 返回某个目录下的文件
	 * @param dir
	 * @return
	 */
	public static List<String> getFilesInDir(String dir) {
		List<String> filesList = new ArrayList<String>();
		File f = new File(dir);
		if (!f.exists())
			return null;
		File[] filesArr = f.listFiles();
		if (filesArr.length == 0 && filesArr == null)
			return null;
		for (File ff : filesArr) {
			filesList.add(ff.getName());
		}
		return filesList;
	}
	
	/**
	 * 读取后缀为properties的配置文件
	 * @param file
	 * @return
	 */
	public static Properties readProperties(String file) {
		System.out.printf("try to read file : %s", file);
		Properties props = new Properties();
		FileInputStream fi = null;
		File f = new File(file);
		if (f.exists())
			System.out.println("config file exist");
		else {
			System.out.println("config file not exist");
			return null;
		}
		try {
			fi = new FileInputStream(f);
			props.load(fi);
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return props;
		
	}
	
}
