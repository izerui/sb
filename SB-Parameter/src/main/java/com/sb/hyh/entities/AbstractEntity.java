//package com.sb.hyh.entities;
//
//import java.util.Date;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@MappedSuperclass
//public abstract class AbstractEntity {
//    // @Id
//    // @GeneratedValue(generator = "system-uuid")
//    // @GenericGenerator(name = "system-uuid", strategy = "uuid")
//
//    @Id
//    @GeneratedValue
//    private String id;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdTime;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedTime;
//
//    public AbstractEntity() {
//    }
//
//    public AbstractEntity(String id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @PrePersist
//    public void setCreatedTime() {
//        this.createdTime = this.updatedTime = DateTime.now().toDate();
//    }
//
//    @PreUpdate
//    public void setUpdatedTime() {
//        this.updatedTime = DateTime.now().toDate();
//    }
//
//    public Date getCreatedTime() {
//        return createdTime;
//    }
//
//    public void setCreatedTime(Date createdTime) {
//        this.createdTime = createdTime;
//    }
//
//    public Date getUpdatedTime() {
//        return updatedTime;
//    }
//
//    public void setUpdatedTime(Date updatedTime) {
//        this.updatedTime = updatedTime;
//    }
//
//    @Override
//    public int hashCode() {
//        return this.id.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        AbstractEntity abstractEntity = (AbstractEntity) obj;
//        return getId().equals(abstractEntity.getId());
//    }
//
//    public abstract String getModeltype();
//}