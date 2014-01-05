package customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.DBConnection;
import customer.dataobjects.CustomerDO;

/**
 * @author GAURANGP
 *
 */
@Component
public class CustomerDAO {
	@Autowired
	DBConnection dbConnection;
	
	/**
	 * Currently this method doesn't talk to DB. 
	 * It returns data only when customerID is either '1234' or '5678'  
	 * @param customerId
	 * @return
	 */
	public CustomerDO getCustomerInfo(int customerId){
		if(customerId==1234){
			CustomerDO customerDO = dummyMethodToGetCustomerDO(customerId, "Smit", "Karve Nagar", "Pune", 111111);
			return customerDO;
		}
		if(customerId==5678){
			CustomerDO customerDO = dummyMethodToGetCustomerDO(customerId, "Khwahish", "Magarpatta", "Pune", 222222);
			return customerDO;
		}
		return null;
	}
	
	private CustomerDO dummyMethodToGetCustomerDO(int id, String name, String address, String city, int pinCode){
		CustomerDO customerDO = new CustomerDO();
		customerDO.setId(id);
		customerDO.setName(name);
		customerDO.setAddress(address);
		customerDO.setCity(city);
		customerDO.setPinCode(pinCode);
		return customerDO;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
}