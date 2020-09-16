package app.model;

import java.sql.Date;

public class Tasks {

	private Integer id;
	private String fileName;
	private String userName;
	private String description;
	private Date createDate;
	private boolean state;
	
	protected Tasks() {
		
	}
	
	public Tasks(Integer id, String title, String username, String description, Date createDate, boolean isDone) {
		super();
		this.id = id;
		this.fileName = title;
		this.userName = username;
		this.description = description;
		this.createDate = createDate;
		this.state = isDone;
	}

	public Tasks(String title, String username, String description, Date createDate, boolean isDone) {
		super();
		this.fileName = title;
		this.userName = username;
		this.description = description;
		this.createDate = createDate;
		this.state = isDone;
	}

	public Tasks(Integer id, String description, Date createDate, boolean isDone, String userName, String fileName) {
		this.id = id;
		this.description = description;
		this.createDate = createDate;
		this.state = isDone;
		this.userName = userName;
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String username) {
		this.createDate = createDate;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getfileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
