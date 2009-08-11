package de.forsthaus.backend.model;

import java.util.Date;

public class GuestBook implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long gubId = Long.MIN_VALUE;
	private int version;
	private String gubSubject;
	private Date gubDate;
	private String gubUsrname;
	private String gubText;

	public boolean isNew() {
		return (getGubId() == Long.MIN_VALUE);
	}

	public GuestBook() {
	}

	public GuestBook(long gubId, String gubSubject, Date gubDate, String gubUsrname) {
		this.gubId = gubId;
		this.gubSubject = gubSubject;
		this.gubDate = gubDate;
		this.gubUsrname = gubUsrname;
	}

	public GuestBook(long gubId, String gubSubject, Date gubDate, String gubUsrname, String catLongText, String gubText) {
		this.gubId = gubId;
		this.gubSubject = gubSubject;
		this.gubDate = gubDate;
		this.gubUsrname = gubUsrname;
		this.gubText = gubText;
	}

	public long getGubId() {
		return this.gubId;
	}

	public void setGubId(long gubId) {
		this.gubId = gubId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setGubSubject(String gubSubject) {
		this.gubSubject = gubSubject;
	}

	public String getGubSubject() {
		return gubSubject;
	}

	public void setGubDate(Date gubDate) {
		this.gubDate = gubDate;
	}

	public Date getGubDate() {
		return gubDate;
	}

	public void setGubUsrname(String gubUsrname) {
		this.gubUsrname = gubUsrname;
	}

	public String getGubUsrname() {
		return gubUsrname;
	}

	public void setGubText(String gubText) {
		this.gubText = gubText;
	}

	public String getGubText() {
		return gubText;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getGubId()).hashCode();
	}

	public boolean equals(GuestBook guestBook) {
		return getGubId() == guestBook.getGubId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof GuestBook) {
			GuestBook guestBook = (GuestBook) obj;
			return equals(guestBook);
		}

		return false;
	}

}
