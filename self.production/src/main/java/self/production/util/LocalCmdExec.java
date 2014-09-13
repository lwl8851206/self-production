package self.production.util;

import java.io.IOException;
import java.io.InputStream;

public class LocalCmdExec extends Cmd {
	public LocalCmdExec(String cmdType, String cmd, Object args) {
		// TODO Auto-generated constructor stub
		super(cmdType, cmd, args);
	}

	@Override
	public boolean exec() {
		InputStream in = null;
		String str = "";
		int len = 0;
		Process p = null;
		byte[] bt = new byte[1024];
		try {
			if (this.getCmdType().equals("LOCAL_COPY_MULTI_CMD")) {
				String tempCmd = this.getCmd();
				String[] hostsArr = this.getArgss()[1].split(",");
				System.out.println("hosts's length:" + hostsArr.length);
				for (String hosts : hostsArr) {
					tempCmd += String.format(" %s/%s", this.getArgss()[0], hosts);
					
				}
				tempCmd += String.format(" %s/", this.getArgss()[2]);
				p = Runtime.getRuntime().exec(tempCmd);
				System.out.println(tempCmd);
			} else {
				p = Runtime.getRuntime().exec(
						String.format(this.getCmd(), this.getArgss()));
				System.out.println(String.format(this.getCmd(), this.getArgss()));
			}
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
