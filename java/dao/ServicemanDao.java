package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnectivity;
import model.ServiceMan;

public class ServicemanDao {
	public static void insertServiceman(ServiceMan s) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="insert into serviceman(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3,s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setString(5,s.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from serviceman where email=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static ServiceMan servicemanLogin(ServiceMan s) {
		ServiceMan s1 = null;
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from serviceman where email=? and password=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs  =pst.executeQuery();
			if(rs.next()) {
				s1 = new ServiceMan();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getLong("contact"));
				s1.setAddress(rs.getString("address"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	public static void updateServiceMan(ServiceMan s) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="update serviceman set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3,s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkOldPassword(String email,String op) {
		boolean flag = false;
		
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from serviceman where email=? and password=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void updatePassword(String email,String np) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="update serviceman set password=? where email=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ServiceMan getServicemanById(int id) {
		ServiceMan s1 = null;
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from serviceman where id=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs  =pst.executeQuery();
			if(rs.next()) {
				s1 = new ServiceMan();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getLong("contact"));
				s1.setAddress(rs.getString("address"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	public static List<ServiceMan> getAllServiceMan(){
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from serviceman";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ServiceMan s1 = new ServiceMan();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getLong("contact"));
				s1.setAddress(rs.getString("address"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
				list.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
