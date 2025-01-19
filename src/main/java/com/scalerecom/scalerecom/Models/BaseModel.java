package com.scalerecom.scalerecom.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseModel implements Serializable {

    public BaseModel() {
    }

    public BaseModel(long id, Date creationDate, Date updateDate, boolean isDeleted) {
        this.id = id;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.isDeleted = isDeleted;
    }

    //common attributes for the models
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private Date creationDate;
    private Date updateDate;
    private boolean isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isIdDeleted() {
        return isDeleted;
    }

    public void setIdDeleted(boolean idDeleted) {
        this.isDeleted = idDeleted;
    }
}
