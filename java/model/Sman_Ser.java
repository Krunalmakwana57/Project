package model;

public class Sman_Ser {
	private int sid,ser_id,sprice;
	private String stype,car_model,duration;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSer_id() {
		return ser_id;
	}
	public void setSer_id(int ser_id) {
		this.ser_id = ser_id;
	}
	public int getSprice() {
		return sprice;
	}
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Serviceman_Services [sid=" + sid + ", ser_id=" + ser_id + ", sprice=" + sprice + ", stype=" + stype
				+ ", car_model=" + car_model + ", duration=" + duration + "]";
	}
	
}
