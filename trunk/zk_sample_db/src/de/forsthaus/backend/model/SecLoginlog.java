package de.forsthaus.backend.model;

// Generated 27.02.2009 17:17:12 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * 0 = login failed <br>
 * 1 = login <br>Fs
 */
public class SecLoginlog implements java.io.Serializable {

	private static final long serialVersionUID = -2628240632347849393L;

	private long lglId = Long.MIN_VALUE;
	private String lglLoginname;
	private Date lglLogtime;
	private String lglSessionid;
	private String lglIp;
	private Integer lglStatusid;

	public boolean isNew() {
		return (getLglId() == Long.MIN_VALUE);
	}

	public SecLoginlog() {
	}

	public SecLoginlog(long lglId, String lglLoginname, Date lglLogin, int lglStatusid) {
		this.lglId = lglId;
		this.lglLoginname = lglLoginname;
		this.lglLogtime = lglLogin;
		this.lglStatusid = lglStatusid;
	}

	public SecLoginlog(long lglId, String lglLoginname, Date lglLogtime, String lglSessionid, String lglIp, int lglStatusid) {
		this.lglId = lglId;
		this.lglLoginname = lglLoginname;
		this.lglLogtime = lglLogtime;
		this.lglSessionid = lglSessionid;
		this.lglIp = lglIp;
		this.lglStatusid = lglStatusid;
	}

	public long getLglId() {
		return this.lglId;
	}

	public void setLglId(long lglId) {
		this.lglId = lglId;
	}

	public String getLglLoginname() {
		return this.lglLoginname;
	}

	public void setLglLoginname(String lglLoginname) {
		this.lglLoginname = lglLoginname;
	}

	public Date getLglLogtime() {
		return this.lglLogtime;
	}

	public void setLglLogtime(Date lglLogtime) {
		this.lglLogtime = lglLogtime;
	}

	public String getLglSessionid() {
		return this.lglSessionid;
	}

	public void setLglSessionid(String lglSessionid) {
		this.lglSessionid = lglSessionid;
	}

	public String getLglIp() {
		return this.lglIp;
	}

	public void setLglIp(String lglIp) {
		this.lglIp = lglIp;
	}

	public int getLglStatusid() {
		return this.lglStatusid;
	}

	public void setLglStatusid(int lglStatusid) {
		this.lglStatusid = lglStatusid;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getLglId()).hashCode();
	}

	public boolean equals(SecLoginlog secLoginlog) {
		return getLglId() == secLoginlog.getLglId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecLoginlog) {
			SecLoginlog secLoginlog = (SecLoginlog) obj;
			return equals(secLoginlog);
		}

		return false;
	}
}
