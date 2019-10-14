package service;
import dao.WaterDao;
import dao.WaterDaoImp;
import exception.DBException;
import java.sql.SQLException;
import dao.AvailabilityDao;
import model.Availability;
import model.OrderDetails;
import model.ReserveDetails;

public class CanService {
	int id ;
	WaterDaoImp waterdao = new WaterDao();
	Availability stock = new Availability();
	AvailabilityDao dao = new AvailabilityDao();
	
	public int orderCan(OrderDetails details) throws SQLException, DBException {	
		 waterdao.quantity(details);
		  id = waterdao.findByOrderId(details);
		 try {
			Availability availableStock=dao.getStock();
			int value=details.getQuantyList();
			int value1=availableStock.getAvailability_List()-value;
			dao.admin1(value1);
			String status = "Ordered";
			 details.setStatus(status);
			waterdao.status(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
 
  public int reserveCan(ReserveDetails details) {
				try {
					waterdao.reserve(details);
				    id = waterdao.findByReserveId(details);
					Availability availableStock=dao.getStock();
					int value=details.getReservedList();
					int value1=availableStock.getAvailability_List()-value;
					dao.admin1(value1);
					String status = "Reserved... Order Pending";
					 details.setStatus(status);
					waterdao.review(details);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return id;
  }
  }
