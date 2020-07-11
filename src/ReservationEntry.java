import java.sql.Date;

public class ReservationEntry {
	int id;
	int bookid;
	String username;
	Date fromDate;
	Date toDate;
	boolean returned;
	
	public ReservationEntry(int id, int bookid, String username, Date fromDate, Date toDate, boolean returned) {
		this.bookid = id;
		this.bookid = bookid;
		this.username = username;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.returned = returned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	
	
}
