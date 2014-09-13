package self.production.util;

public abstract class Cmd {
	private String cmdType;
	private String cmd;
	private String[] argss;
	
	public String getCmdType() {
		return cmdType;
	}

	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String[] getArgss() {
		return argss;
	}

	public void setArgss(String[] argss) {
		this.argss = argss;
	}
	
	public Cmd(String cmdType, String cmd, Object args) {
		this.setCmdType(cmdType);
		this.setCmd(cmd);
		this.setArgss((String[])args);
	}

	public abstract boolean exec();
}
