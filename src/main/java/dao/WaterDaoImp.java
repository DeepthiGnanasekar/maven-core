package dao;
import model.OrderDetails;
import model.ReserveDetails;

public interface WaterDaoImp {

	public int findavailability();
	
	public void quantity(OrderDetails ordercan);
	
	public int findByOrderId(OrderDetails ordercan);
	
	public void reserve(ReserveDetails reservecan);

	public int findByReserveId(ReserveDetails reservecan);
	
	public void reserveu(ReserveDetails reservecan);
	
	public void reserve1(ReserveDetails reservecan);
	
	public void status(OrderDetails ordercan);
	
	public void review(ReserveDetails reservecan);

}