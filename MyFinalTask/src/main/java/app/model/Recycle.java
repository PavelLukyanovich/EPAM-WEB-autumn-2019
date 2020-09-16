package app.model;

import java.sql.Date;

public class Recycle {

    private Integer id;
    private String fileName;
    private String userName;
    private String description;
    private Date createDate;
    private boolean state;

    public Recycle() {

    }

    public Recycle(String description, Date createDate, boolean state, String userName, String fileName) {
        this.description = description;
        this.createDate = createDate;
        this.state = state;
        this.userName = userName;
        this.fileName = fileName;

    }

    public Recycle(String fileName, String userName, String description, Date createDate, boolean state) {
        this.fileName = fileName;
        this.userName = userName;
        this.description = description;
        this.createDate = createDate;
        this.state = state;
    }

    public Recycle(Integer id, String description, Date createDate, boolean isDone, String userName, String fileName) {
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
        Recycle other = (Recycle) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
