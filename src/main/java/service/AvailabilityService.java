package service;
import java.util.List;
import dao.AvailabilityDao;
import exception.DBException;
import model.Availability;
import validator.AdminValidator;

public class AvailabilityService {
	AdminValidator validator = new AdminValidator();
	AvailabilityDao availabilitydao = new AvailabilityDao();
	Availability details = new Availability();
	
	public List<Availability> stockView() throws Exception {
        List<Availability> list = null;
        try {
            list = availabilitydao.viewStock();
        } catch (DBException e) {
            e.printStackTrace();
        }
        return list;
    }

	public void setCan(int cans) {
	   try {
		   Availability value =availabilitydao.getStock();
		   int val=value.getAvailability_List();
		   System.out.println(cans);
		   System.out.println(val);
		  int value2 = val + cans;
		  System.out.println(value2);
		availabilitydao.admin1(value2);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}