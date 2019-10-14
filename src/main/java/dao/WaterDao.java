package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import dao.WaterDaoImp;
import model.Availability;
import model.OrderDetails;
import model.ReserveDetails;
import util.ConnectionUtil;

public class WaterDao implements WaterDaoImp {
	Connection con = ConnectionUtil.getConnection();
	PreparedStatement pst = null;
	ReserveDetails reservecan = new ReserveDetails();
	OrderDetails ordercan = new OrderDetails();

	public int findavailability() {
		int availableStock = 0;
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from availability_List";
		PreparedStatement pst = null;
		Availability stock = null;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) 
			{
				stock = new Availability();
				availableStock = rs.getInt("cans_avail");
				Timestamp date = rs.getTimestamp("Date");
				stock.setDate(date.toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return availableStock;
	}

	public void quantity(OrderDetails ordercan) {
		try {
			String sql = "insert into quantity_List(Quantity_List,Mobile_Number) values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, ordercan.getQuantyList());
			pst.setLong(2, ordercan.getNumber());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int findByOrderId(OrderDetails ordercan) {
		String sql ="select id from quantity_List where Mobile_Number =? order by id desc";
		int water=0;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1,ordercan.getNumber());
			pst.executeQuery();
			ResultSet rs = pst.executeQuery();
			if(rs.next()) 
			{
				water = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return water;
	}
	
	public void reserve(ReserveDetails reservecan) {
		try {
			String sql = "insert into reserve_List(Mobile_Number, Reserved_List) values(?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, reservecan.getNumber());
			pst.setInt(2, reservecan.getReservedList());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int findByReserveId(ReserveDetails reservecan) {
		String sql ="select id from reserve_List where Mobile_Number =? order by id desc ";
		int water=0;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1,reservecan.getNumber());
			pst.executeQuery();
			ResultSet rs = pst.executeQuery();
			if(rs.next()) 
			{
				water = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return water;
	}

	public void reserveu(ReserveDetails reservecan) {
		try {
			String sql = "update reserve_List set Reserved_List=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, reservecan.getReservedList());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserve1(ReserveDetails reservecan) {
		try {
			String sql = "update reserve_List set Reserved_Order=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, reservecan.getReservedOrder());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void status(OrderDetails ordercan) {
		try {
			String sql = "update quantity_List set STATUS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ordercan.getStatus());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void review(ReserveDetails reservecan) {
		try {
			String sql = "update reserve_List set STATUS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, reservecan.getStatus());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}