package service;
import java.sql.SQLException;
import dao.UserDao;
import dao.UserDaoImp;
import dao.WaterDao;
import dao.WaterDaoImp;
import exception.DBException;
import model.UserDetails;
import validator.UserValidator;

public class UserService {
UserDaoImp userdao = new UserDao();
	WaterDaoImp waterdao = new WaterDao();
	 UserValidator validator = new UserValidator();
	 UserDetails details = new UserDetails();
     public void register(UserDetails details) throws Exception {
			userdao.register(details);
     }
     public UserDetails login(String phone_number,String setPassword) {
    	 UserDetails details = null;
    	 try {
    		 details = userdao.login(phone_number,setPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return details;
     }
	
}
