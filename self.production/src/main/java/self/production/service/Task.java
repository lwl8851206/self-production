package self.production.service;

public interface Task{
	public void run();
	public void check();
	public void setMessage();
	public String getMessage();
	public void setStatus(int status);
	public int getStatus();
}
