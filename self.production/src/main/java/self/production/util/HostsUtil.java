package self.production.util;

import java.util.List;

import self.production.model.hosts.Hosts;

public class HostsUtil {
	public HostsUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取某个服务器可供使用的hosts列表
	 * @param hostsOwner
	 * @return
	 */
	public static List<String> getOnesHostsList(String hostsOwner){
		Hosts owner =new Hosts(hostsOwner);
		return  owner.getHostsList();
	}
	
	/**
	 * 在某个服务器下创建hosts
	 * @param hostsOwner
	 * @param hostsContent
	 */
	public static void createHostsForOne(String hostsOwner, String hosts, String hostsContent) {
		Hosts owner = new Hosts(hostsOwner);
		owner.createHosts(hosts, hostsContent);
	}
	
	/**
	 * 删除某个服务器下的某个hosts文件
	 * @param hostsOwner
	 * @param hosts
	 */
	public static void deleteHostsForOne(String hostsOwner, String hosts) {
		Hosts owner = new Hosts(hostsOwner);
		owner.deleteHosts(hosts);
	}
	
	public static String getHostsContent(String hostsOwner, String hosts) {
		Hosts owner = new Hosts(hostsOwner);
		return owner.getHostsContent(hosts);
	}
	
	public static void editHostsContent(String hostsOwner, String hosts, String hostsContent) {
		Hosts owner = new Hosts(hostsOwner);
		owner.editHostsContent(hosts, hostsContent);
	}
	
	public static void copyHosts(String hostsOwner, String from, String hosts) {
		Hosts owner = new Hosts(hostsOwner);
		owner.copyHosts(from, hosts);
	}
	
	
	
}
