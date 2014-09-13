package self.production.util;

import java.io.IOException;
import java.io.InputStream;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

public class CmdExec {
	public static final String COPY_ALL_CMD = "cp -fr %s/* %s/";
	public static final String COPY_MULTI_CMD = "cp -f ";
	public static final String COPY_ONE_CMD = "cp -f %s/%s %s/";
	public static final String CHANGE_HOSTS = "";
	public static final String SYNC_SETTTING = "";
	public static final String SYNC_DB_DATA = "";

	/**
	 * 在本服务器执行shell命令
	 * @param cmd
	 * @param args
	 * @return
	 */
	public static boolean exec(String cmd, String... args) {
		InputStream in = null;
		String str = "";
		int len = 0;
		Process p = null;
		byte[] bt = new byte[1024];
		try {
			if (cmd.equals(COPY_MULTI_CMD)) {
				String tempCmd = COPY_MULTI_CMD;
				String[] hostsArr = args[1].split(",");
				for (String hosts : hostsArr) {
					tempCmd += String.format(" %s/%s", args[0], hosts);
				}
				tempCmd += String.format(" %s/", args[2]);
				p = Runtime.getRuntime().exec(tempCmd);
			} else
				p = Runtime.getRuntime().exec(
						String.format(cmd, (String[]) args));

			in = p.getInputStream();
			while ((len = in.read(bt)) != -1)
				str += new String(bt, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
