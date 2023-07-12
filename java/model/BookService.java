package model;

public class BookService {
	private int bid,cid,sid,serviceman_id;
	private String booking_status,payment_status;
	
	
	public int getServiceman_id() {
		return serviceman_id;
	}

	public void setServiceman_id(int serviceman_id) {
		this.serviceman_id = serviceman_id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "BookService [bid=" + bid + ", cid=" + cid + ", sid=" + sid + ", serviceman_id=" + serviceman_id
				+ ", booking_status=" + booking_status + ", payment_status=" + payment_status + "]";
	}
	
}
