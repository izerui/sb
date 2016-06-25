package cms.po;

import cms.po.base.BaseEntity;

public class Catalog extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String folder;
	private int deep;
	private int pid;
	private int pidPath;
	private int sum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPidPath() {
		return pidPath;
	}

	public void setPidPath(int pidPath) {
		this.pidPath = pidPath;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
