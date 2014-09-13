package self.production.util;

import java.io.InputStream;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.ConnectionInfo;
import ch.ethz.ssh2.Session;

public class SSHCmdExec extends Cmd {
	private String cmdType;
	private String cmd;
	private String[] argss;

	public SSHCmdExec(String cmdType, String cmd, Object args) {
		// TODO Auto-generated constructor stub
		super(cmdType, cmd, args);
	}

	@Override
	public boolean exec() {
		// TODO Auto-generated method stub
		try {
			Connection con = new Connection("192.168.1.16");
			ConnectionInfo info = con.connect();
			boolean result = con.authenticateWithPassword("long", "l123123");
			Session session = con.openSession();
			session.execCommand("ls -al");
			InputStream in = session.getStdout();
			byte[] bt = new byte[1024];
			int len = 0;
			String str = "";
			while ((len = in.read(bt)) != -1)
				str += new String(bt, 0, len);
			System.out.println(str);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		return true;
	}

}
