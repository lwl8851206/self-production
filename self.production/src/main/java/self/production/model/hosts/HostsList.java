package self.production.model.hosts;

import java.util.List;

public class HostsList {
	private int count;
	private List hostsList;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List getHostsList() {
		return hostsList;
	}

	public void setHostsList(List hostsList) {
		this.hostsList = hostsList;
	}

	public HostsList(int count, List hostsList) {
		// TODO Auto-generated constructor stub
		this.count = count;
		this.hostsList = hostsList;
	}

}
