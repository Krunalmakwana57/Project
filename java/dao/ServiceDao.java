package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.DbDoc;

import connection.DBConnectivity;
import model.Serviceman_Services;

public class ServiceDao {
	public static void insertService(Serviceman_Services s) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="insert into services(serviceman_id,stype,car_model,sprice,s_duration) values(?,?,?,?,?)";
			PreparedStatement pst  = cn.prepareStatement(sql);
			pst.setInt(1, s.getSer_id());
			pst.setString(2, s.getStype());
			pst.setString(3, s.getCar_model());
			pst.setInt(4, s.getSprice());
			pst.setString(5, s.getDuration());
			pst.executeUpdate();
			System.out.println("services stored");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Serviceman_Services> getServicesBySid(int id){
		List<Serviceman_Services> list = new ArrayList<Serviceman_Services>();
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from services where serviceman_id=?";
			PreparedStatement pst  = cn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet sr = pst.executeQuery();
			while(sr.next()) {
				Serviceman_Services s = new Serviceman_Services();
				s.setSid(sr.getInt("service_id"));
				s.setSer_id(sr.getInt("serviceman_id"));
				s.setStype(sr.getString("stype"));
				s.setCar_model(sr.getString("car_model"));
				s.setSprice(sr.getInt("sprice"));
				s.setDuration(sr.getString("s_duration"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Serviceman_Services getSingleServiceBySid(int id) {
		Serviceman_Services s = null;
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from services where service_id=?";
			PreparedStatement pst  = cn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet sr = pst.executeQuery();
			if(sr.next()) {
				s = new Serviceman_Services();
				s.setSid(sr.getInt("service_id"));
				s.setSer_id(sr.getInt("serviceman_id"));
				s.setStype(sr.getString("stype"));
				s.setCar_model(sr.getString("car_model"));
				s.setSprice(sr.getInt("sprice"));
				s.setDuration(sr.getString("s_duration"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public static void udpateService(Serviceman_Services s) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="update services set stype=?,car_model=?,sprice=?,s_duration=? where service_id=?";
			PreparedStatement pst  = cn.prepareStatement(sql);
			pst.setString(1, s.getStype());
			pst.setString(2, s.getCar_model());
			pst.setInt(3, s.getSprice());
			pst.setString(4, s.getDuration());
			pst.setInt(5, s.getSid());
			pst.executeUpdate();
			System.out.println("services updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteService(int id) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="delete from services where service_id=?";
			PreparedStatement pst  = cn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("services deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Serviceman_Services> getAllServices(){
		List<Serviceman_Services> list = new ArrayList<Serviceman_Services>();
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from services";
			PreparedStatement pst  = cn.prepareStatement(sql);
			ResultSet sr = pst.executeQuery();
			while(sr.next()) {
				Serviceman_Services s = new Serviceman_Services();
				s.setSid(sr.getInt("service_id"));
				s.setSer_id(sr.getInt("serviceman_id"));
				s.setStype(sr.getString("stype"));
				s.setCar_model(sr.getString("car_model"));
				s.setSprice(sr.getInt("sprice"));
				s.setDuration(sr.getString("s_duration"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
