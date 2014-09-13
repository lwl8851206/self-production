package self.production.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class CmdReceiver {
	public static HashMap<String, String> LOCAL_CMD_SETS = new HashMap<String, String>();
	public static HashMap<String, String> SSH_CMD_SETS = new HashMap<String, String>();
	public static String CONFIGBASEDIR = "";
	public static String CMDCONFIG = "cmd.properties";

	static {
		loadCmdConfig();
	}

	/**
	 * 自动加载命令配置
	 */
	public static void loadCmdConfig() {
		Properties props = FileUtil.readProperties(CmdReceiver.class
				.getResource("/").getPath() + CMDCONFIG);
		Set keySet = props.keySet();
		Iterator ite = keySet.iterator();
		while (ite.hasNext()) {
			String key = ite.next().toString();
			if (key.startsWith("LOCAL"))
				LOCAL_CMD_SETS.put(key, props.getProperty(key));
			else
				SSH_CMD_SETS.put(key, props.getProperty(key));
		}
	}

	/**
	 * 根据命令类型决定本地执行或者远程登录执行
	 * 
	 * @param cmdType
	 * @param args
	 * @return
	 */
	public static Cmd receivedCmd(String cmdType, String... args) {
		if (LOCAL_CMD_SETS.containsKey(cmdType)) {
			System.out.printf("key[%S]:value[%s]", cmdType,
					LOCAL_CMD_SETS.get(cmdType));
			return new LocalCmdExec(cmdType, LOCAL_CMD_SETS.get(cmdType), args);
		} else {
			System.out.printf("key[%S]:value[%s]", cmdType, SSH_CMD_SETS.get(cmdType));
			return new SSHCmdExec(cmdType, SSH_CMD_SETS.get(cmdType), args);
		}
	}
}
