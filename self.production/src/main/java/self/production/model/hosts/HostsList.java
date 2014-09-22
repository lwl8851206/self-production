package self.production.model.hosts;

import java.util.List;

public class HostsList {
	private int count;
	private List hostsList;
	private String owner;
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

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

	public HostsList(String owner, int count, List hostsList) {
		// TODO Auto-generated constructor stub
		this.owner = owner;
		this.count = count;
		this.hostsList = hostsList;
	}

}
