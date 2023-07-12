package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnectivity;
import model.Customer;
import model.ServiceMan;

public class CustomerDao {
	public static void insertCusotmer(Customer s) {
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="insert into customer(name,contact,address,email,password) values(?,?,?,?,?)";
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
			String sql="select * from customer where email=?";
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
	public static Customer customerLogin(Customer s) {
		Customer s1 = null;
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from customer where email=? and password=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs  =pst.executeQuery();
			if(rs.next()) {
				s1 = new Customer();
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
	public static Customer getCustomerById(int id) {
		Customer s1 = null;
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql="select * from customer where id=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs  =pst.executeQuery();
			if(rs.next()) {
				s1 = new Customer();
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
	public static List<Customer> getAllCustomer(){
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection cn = DBConnectivity.crateConnection();
			String sql = "select * from customer";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Customer c1 = new Customer();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setContact(rs.getLong("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPassword(rs.getString("password"));
				list.add(c1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}