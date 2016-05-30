package com.sb.hyh.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 数据Entity类
 */
@MappedSuperclass
public abstract class DataEntity<T> extends BaseEntity<T>implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 显示
	 */
	public static final String SHOW = "1";
	/**
	 * 隐藏
	 */
	public static final String HIDE = "0";
	/**
	 * 是
	 */
	public static final String YES = "1";
	/**
	 * 否
	 */
	public static final String NO = "0";

	/**
	 * 删除标记（0:正常;1:删除;2:审核;)
	 */
	public static final String FIELD_DEL_FLAG = "delFlag";
	/**
	 * 删除标记（0:正常;1:删除;2:审核;)
	 */
	public static final char DEL_FLAG_NORMAL = '0';
	/**
	 * 删除标记（0:正常;1:删除;2:审核;)
	 */
	public static final char DEL_FLAG_DELETE = '1';
	/**
	 * 删除标记（0:正常;1:删除;2:审核;)
	 */
	public static final char DEL_FLAG_AUDIT = '2';

	/**
	 * 创建者
	 */
	private String createBy;
	// private User createBy;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 更新者
	 */
	private String updateBy;
	// private User updateBy;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 删除标记（0:正常;1:删除;2:审核;)
	 */
	private Character delFlag;
	/**
	 * 备注
	 */
	private String remarks;

	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	@Override
	@PrePersist
	public void prePersist() {
		/*
		 * User user = UserUtils.getUser(); if
		 * (StringUtils.isNotBlank(user.getId())){ this.updateBy = user;
		 * this.createBy = user; }
		 */
		super.prePersist();
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}

	/**
	 * preUpdate.
	 */
	@PreUpdate
	public void preUpdate() {
		/*
		 * User user = UserUtils.getUser(); if
		 * (StringUtils.isNotBlank(user.getId())){ this.updateBy = user; }
		 */
		this.updateDate = new Date();
	}

	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "create_by")
	 * 
	 * @NotFound(action = NotFoundAction.IGNORE) public User getCreateBy() {
	 * return createBy; }
	 * 
	 * public void setCreateBy(User createBy) { this.createBy = createBy; }
	 */

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="update_by")
	 * 
	 * @NotFound(action = NotFoundAction.IGNORE) public User getUpdateBy() {
	 * return updateBy; }
	 * 
	 * public void setUpdateBy(User updateBy) { this.updateBy = updateBy; }
	 */

	// @Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	// @DateBridge(resolution = Resolution.DAY)
	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "DEL_FLAG")
	@NotNull
	// @Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	public Character getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

	@Column(name = "UPDATE_BY")
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "CREATE_BY")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
}
