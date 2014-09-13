package self.production.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

public class ServersUtil {
	private final static String CONFIGFILE = "config.properties";
	private static String PATHTOCONFIG = "";
	private static String CONFIGBASEDIR = "";

	static {
		new ServersUtil();
	}

	private ServersUtil() {
		CONFIGBASEDIR = this.getClass().getResource("/").getPath();
		PATHTOCONFIG = CONFIGBASEDIR + CONFIGFILE;
	}

	/**
	 * 添加服务器，可添加多个
	 * 
	 * @param newServers
	 */
	public static void addServers(String newServers) {
		HashSet<String> servers = getServers();
		String updatedServers = "";
		int oldServerCounts = servers.size();

		servers.addAll(CollectionHelper.stringToHashSet(newServers));
		/*
		 * if (!newServers.contains(",")) servers.add(newServers); else {
		 * String[] newServersArr = newServers.split(","); for (String newServer
		 * : newServersArr) servers.add(newServer); }
		 */

		if (oldServerCounts == servers.size())
			return;

		FileUtil.createDir(CONFIGBASEDIR, servers);
		Iterator<String> ite = servers.iterator();

		while (ite.hasNext()) {
			String addedServer = ite.next();
			if (updatedServers.equals(""))
				updatedServers += "servers=" + addedServer;
			else
				updatedServers += "," + addedServer;
			System.out.println("create folder " + addedServer);
		}

		FileUtil.editFile(CONFIGBASEDIR, CONFIGFILE, updatedServers);
		System.out.println("write content into config.properties:\n"
				+ updatedServers);
	}

	/**
	 * 移除服务器
	 * 
	 * @param serverToBeRemoved
	 */
	public static void removeServers(String serverToBeRemoved) {
		String updatedServers = "";
		HashSet<String> servers = getServers();
		HashSet<String> removedServers = new HashSet<String>();
		HashSet<String> commonSet = null;
		if (servers == null && servers.size() == 0)
			return;

		removedServers = CollectionHelper.stringToHashSet(serverToBeRemoved);
		commonSet = CollectionHelper.intersectionSet(servers, removedServers);

		if (commonSet.size() == 0)
			return;
		// 除去子集合
		servers.removeAll(commonSet);

		FileUtil.removeDir(CONFIGBASEDIR, commonSet);
		Iterator<String> ite = servers.iterator();

		while (ite.hasNext()) {
			String addedServer = ite.next();
			if (updatedServers.equals(""))
				updatedServers += "servers=" + addedServer;
			else
				updatedServers += "," + addedServer;
		}
		FileUtil.editFile(CONFIGBASEDIR, CONFIGFILE, updatedServers);

	}

	/**
	 * 获取服务器列表
	 * 
	 * @return
	 */
	public static HashSet<String> getServers() {
		Properties props = new Properties();
		String[] servers = null;
		HashSet<String> serversSet = new HashSet<String>();

		servers = FileUtil.readProperties(PATHTOCONFIG).getProperty("servers")
				.split(",");
		for (String server : servers) {
			serversSet.add(server);
		}
		FileUtil.createDir(CONFIGBASEDIR, serversSet);
		return serversSet;
	}

}
