package com.sb.hyh.po;
// Generated 2016-6-17 10:55:29 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OpenapiShenqing generated by hbm2java
 */
@Entity
@Table(name = "OPENAPI_SHENQING", schema = "NEW_BPP")
public class OpenapiShenqing implements java.io.Serializable {

	private String id;
	private String yxtywlsh;
	private String sqh;
	private long sort;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private String remarks;
	private char delFlag;
	private String sjbbh;
	private String sxbm;
	private String sxmc;
	private String blbm;
	private String zrsj;
	private Date sqsj;
	private String cltjfs;
	private String sqrlx;
	private String sqrmc;
	private String sqrdz;
	private String sqrzjlx;
	private String sqdwzjhm;
	private String lxrxm;
	private String lxrzjlx;
	private String lxrzjhm;
	private String lxrsjh;
	private String lxrdh;
	private String lxrdzyx;
	private String bz;
	private String byzda;
	private String byzdb;

	public OpenapiShenqing() {
	}

	public OpenapiShenqing(String id, String yxtywlsh, long sort, char delFlag, String sjbbh, String sxbm, String sxmc,
			String blbm, String zrsj, Date sqsj, String cltjfs, String sqrlx, String sqrmc) {
		this.id = id;
		this.yxtywlsh = yxtywlsh;
		this.sort = sort;
		this.delFlag = delFlag;
		this.sjbbh = sjbbh;
		this.sxbm = sxbm;
		this.sxmc = sxmc;
		this.blbm = blbm;
		this.zrsj = zrsj;
		this.sqsj = sqsj;
		this.cltjfs = cltjfs;
		this.sqrlx = sqrlx;
		this.sqrmc = sqrmc;
	}

	public OpenapiShenqing(String id, String yxtywlsh, String sqh, long sort, String createBy, Date createDate,
			String updateBy, Date updateDate, String remarks, char delFlag, String sjbbh, String sxbm,
			String sxmc, String blbm, String zrsj, Date sqsj, String cltjfs, String sqrlx, String sqrmc,
			String sqrdz, String sqrzjlx, String sqdwzjhm, String lxrxm, String lxrzjlx, String lxrzjhm, String lxrsjh,
			String lxrdh, String lxrdzyx, String bz, String byzda, String byzdb) {
		this.id = id;
		this.yxtywlsh = yxtywlsh;
		this.sqh = sqh;
		this.sort = sort;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.remarks = remarks;
		this.delFlag = delFlag;
		this.sjbbh = sjbbh;
		this.sxbm = sxbm;
		this.sxmc = sxmc;
		this.blbm = blbm;
		this.zrsj = zrsj;
		this.sqsj = sqsj;
		this.cltjfs = cltjfs;
		this.sqrlx = sqrlx;
		this.sqrmc = sqrmc;
		this.sqrdz = sqrdz;
		this.sqrzjlx = sqrzjlx;
		this.sqdwzjhm = sqdwzjhm;
		this.lxrxm = lxrxm;
		this.lxrzjlx = lxrzjlx;
		this.lxrzjhm = lxrzjhm;
		this.lxrsjh = lxrsjh;
		this.lxrdh = lxrdh;
		this.lxrdzyx = lxrdzyx;
		this.bz = bz;
		this.byzda = byzda;
		this.byzdb = byzdb;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, length = 64)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "YXTYWLSH", nullable = false, length = 64)
	public String getYxtywlsh() {
		return this.yxtywlsh;
	}

	public void setYxtywlsh(String yxtywlsh) {
		this.yxtywlsh = yxtywlsh;
	}

	@Column(name = "SQH", length = 64)
	public String getSqh() {
		return this.sqh;
	}

	public void setSqh(String sqh) {
		this.sqh = sqh;
	}

	@Column(name = "SORT", nullable = false, precision = 10, scale = 0)
	public long getSort() {
		return this.sort;
	}

	public void setSort(long sort) {
		this.sort = sort;
	}

	@Column(name = "CREATE_BY", length = 64)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "UPDATE_BY", length = 64)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "REMARKS")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "DEL_FLAG", nullable = false, length = 1)
	public char getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(char delFlag) {
		this.delFlag = delFlag;
	}

	@Column(name = "SJBBH", nullable = false, length = 100)
	public String getSjbbh() {
		return this.sjbbh;
	}

	public void setSjbbh(String sjbbh) {
		this.sjbbh = sjbbh;
	}

	@Column(name = "SXBM", nullable = false, length = 9)
	public String getSxbm() {
		return this.sxbm;
	}

	public void setSxbm(String sxbm) {
		this.sxbm = sxbm;
	}

	@Column(name = "SXMC", nullable = false, length = 200)
	public String getSxmc() {
		return this.sxmc;
	}

	public void setSxmc(String sxmc) {
		this.sxmc = sxmc;
	}

	@Column(name = "BLBM", nullable = false, length = 2)
	public String getBlbm() {
		return this.blbm;
	}

	public void setBlbm(String blbm) {
		this.blbm = blbm;
	}

	@Column(name = "ZRSJ", nullable = false, length = 200)
	public String getZrsj() {
		return this.zrsj;
	}

	public void setZrsj(String zrsj) {
		this.zrsj = zrsj;
	}

	@Column(name = "SQSJ", nullable = false)
	public Date getSqsj() {
		return this.sqsj;
	}

	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}

	@Column(name = "CLTJFS", nullable = false, length = 20)
	public String getCltjfs() {
		return this.cltjfs;
	}

	public void setCltjfs(String cltjfs) {
		this.cltjfs = cltjfs;
	}

	@Column(name = "SQRLX", nullable = false, length = 2)
	public String getSqrlx() {
		return this.sqrlx;
	}

	public void setSqrlx(String sqrlx) {
		this.sqrlx = sqrlx;
	}

	@Column(name = "SQRMC", nullable = false, length = 200)
	public String getSqrmc() {
		return this.sqrmc;
	}

	public void setSqrmc(String sqrmc) {
		this.sqrmc = sqrmc;
	}

	@Column(name = "SQRDZ", length = 500)
	public String getSqrdz() {
		return this.sqrdz;
	}

	public void setSqrdz(String sqrdz) {
		this.sqrdz = sqrdz;
	}

	@Column(name = "SQRZJLX", length = 2)
	public String getSqrzjlx() {
		return this.sqrzjlx;
	}

	public void setSqrzjlx(String sqrzjlx) {
		this.sqrzjlx = sqrzjlx;
	}

	@Column(name = "SQDWZJHM", length = 50)
	public String getSqdwzjhm() {
		return this.sqdwzjhm;
	}

	public void setSqdwzjhm(String sqdwzjhm) {
		this.sqdwzjhm = sqdwzjhm;
	}

	@Column(name = "LXRXM", length = 100)
	public String getLxrxm() {
		return this.lxrxm;
	}

	public void setLxrxm(String lxrxm) {
		this.lxrxm = lxrxm;
	}

	@Column(name = "LXRZJLX", length = 2)
	public String getLxrzjlx() {
		return this.lxrzjlx;
	}

	public void setLxrzjlx(String lxrzjlx) {
		this.lxrzjlx = lxrzjlx;
	}

	@Column(name = "LXRZJHM", length = 50)
	public String getLxrzjhm() {
		return this.lxrzjhm;
	}

	public void setLxrzjhm(String lxrzjhm) {
		this.lxrzjhm = lxrzjhm;
	}

	@Column(name = "LXRSJH", length = 14)
	public String getLxrsjh() {
		return this.lxrsjh;
	}

	public void setLxrsjh(String lxrsjh) {
		this.lxrsjh = lxrsjh;
	}

	@Column(name = "LXRDH", length = 14)
	public String getLxrdh() {
		return this.lxrdh;
	}

	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}

	@Column(name = "LXRDZYX", length = 100)
	public String getLxrdzyx() {
		return this.lxrdzyx;
	}

	public void setLxrdzyx(String lxrdzyx) {
		this.lxrdzyx = lxrdzyx;
	}

	@Column(name = "BZ", length = 100)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "BYZDA", length = 100)
	public String getByzda() {
		return this.byzda;
	}

	public void setByzda(String byzda) {
		this.byzda = byzda;
	}

	@Column(name = "BYZDB", length = 100)
	public String getByzdb() {
		return this.byzdb;
	}

	public void setByzdb(String byzdb) {
		this.byzdb = byzdb;
	}

}
