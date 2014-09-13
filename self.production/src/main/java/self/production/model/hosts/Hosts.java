package self.production.model.hosts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import self.production.util.CmdExec;
import self.production.util.CmdReceiver;
import self.production.util.FileUtil;

/**
 * Hosts相关操作
 * 
 * @author long
 * 
 */
public class Hosts {
	private String hostsOwner = null;
	private List<String> hostsList = new ArrayList<String>();

	public static String CONFIGBASEDIR = "";

	public Hosts() {
		// TODO Auto-generated constructor stub
	}

	public Hosts(String hostsOwner) {
		this.hostsOwner = hostsOwner;
		CONFIGBASEDIR = this.getClass().getResource("/").getPath();
	}

	/**
	 * 返回指定用户的hosts列表
	 * 
	 * @return
	 */
	public List<String> getHostsList() {
		String path = CONFIGBASEDIR + this.hostsOwner;
		hostsList = FileUtil.getFilesInDir(path);
		return hostsList;
	}

	/**
	 * 为某个用户增加某个hosts
	 * 
	 * @param hosts
	 * @param hostsContent
	 */
	public void createHosts(String hosts, String hostsContent) {
		FileUtil.editFile(CONFIGBASEDIR + this.hostsOwner, hosts, hostsContent);
	}

	/**
	 * 为某个用户删除指定的hosts
	 * 
	 * @param hosts
	 */
	public void deleteHosts(String hosts) {
		FileUtil.removeFile(CONFIGBASEDIR + this.hostsOwner, hosts);
	}

	/**
	 * 获取hosts文件的内容
	 * 
	 * @param hosts
	 * @return
	 */
	public String getHostsContent(String hosts) {
		return FileUtil.readFile(CONFIGBASEDIR + this.hostsOwner, hosts);
	}

	/**
	 * 编辑hosts文件内容
	 * 
	 * @param hosts
	 * @param hostsContent
	 */
	public void editHostsContent(String hosts, String hostsContent) {
		FileUtil.editFile(CONFIGBASEDIR + this.hostsOwner, hosts, hostsContent);
	}

	/**
	 * 拷贝hosts文件
	 * 
	 * @param from
	 * @param hosts
	 */
	public void copyHosts(String from, String hosts) {
		if (hosts.contains(","))
/*			CmdExec.exec(CmdExec.COPY_MULTI_CMD, CONFIGBASEDIR + from, hosts,
					CONFIGBASEDIR + this.hostsOwner);*/
			CmdReceiver.receivedCmd("LOCAL_COPY_MULTI_CMD", CONFIGBASEDIR + from, hosts,
					CONFIGBASEDIR + this.hostsOwner).exec();
		else
/*			CmdExec.exec(CmdExec.COPY_ONE_CMD, CONFIGBASEDIR + from, hosts,
					CONFIGBASEDIR + this.hostsOwner);*/
			CmdReceiver.receivedCmd("LOCAL_COPY_ONE_CMD", CONFIGBASEDIR + from, hosts,
					CONFIGBASEDIR + this.hostsOwner).exec();
	}

}
