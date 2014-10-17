package self.production.service;

public interface ITask extends Runnable{
	public void check();
	public void setMessage(String message);
	public String getMessage();
	public void setStatus(int status);
	public int getStatus();
}
