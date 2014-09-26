package self.production.service;

import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

public class SessionService {
	private static String OWNER = null;
	private static HashMap<String, String> SERVERMAP = null;
	private static String[] SERVERKEYS = null;
	public SessionService() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 从session中获取访问者的ipss
	 * @param session
	 * @return
	 */
	public static String getOwner(HttpSession session) {
		if (OWNER == null) {
			OWNER = (String) session.getAttribute("owner");
		}
		return OWNER;
	}
	
	/**
	 * 根据server对应的键值从servermap中获取server
	 * @param session
	 * @param serverKey
	 * @return
	 */
	public static String  getServer(HttpSession session, String serverKey) {
		return getServerMap(session).get(serverKey);
	}
	
	/**
	 * 获取访问者的可用服务器列表
	 * @param session
	 * @return
	 */
	public static HashMap<String, String> getServerMap(HttpSession session) {
		if (SERVERMAP == null)
			SERVERMAP = (HashMap<String, String>)(session.getAttribute("controllservermap"));
		return SERVERMAP;
	}
	
	/**
	 * 获取访问者的服务器键值
	 * @param session
	 * @return
	 */
	public static String [] getServerKeys(HttpSession session) {
		if (SERVERKEYS == null) {
			HashSet<String> set = (HashSet<String>) (getServerMap(session).keySet());
			SERVERKEYS = new String[set.size()];
			set.toArray(SERVERKEYS);
		}
		return SERVERKEYS;
	}

}
