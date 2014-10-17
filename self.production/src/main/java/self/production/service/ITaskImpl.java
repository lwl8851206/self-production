package self.production.service;

import self.production.util.Cmd;
import self.production.util.CmdReceiver;

public class ITaskImpl implements ITask{
	private String message;
	private int status;
	private Cmd cmd;
	public ITaskImpl(String cmdString) {
		// TODO Auto-generated constructor stub
		cmd = CmdReceiver.receivedCmd(cmdString);
	}

	public void run() {
		// TODO Auto-generated method stub
		this.runCmd(this.cmd);
	}
	
	public void runCmd(Cmd cmd) {
		cmd.exec();
	}

	public void check() {
		// TODO Auto-generated method stub
	}

	public void setMessage(String msg) {
		this.message = msg;
		// TODO Auto-generated method stub
		
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

	public void setStatus(int status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

}
