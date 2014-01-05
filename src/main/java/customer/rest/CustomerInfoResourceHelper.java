package customer.rest;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.InputValidationException;
import core.ServiceBase;
import customer.dao.CustomerDAO;
import customer.dataobjects.CustomerDO;
@Component
public class CustomerInfoResourceHelper extends ServiceBase{
	
	@Autowired
	CustomerDAO customerDAO;
	int customerId;
	CustomerDO outputCustomerDO;

	@Override
	protected void validate() throws InputValidationException{
		// TODO customerID should be of 4 digits only
		if(customerId<1000 || customerId>9999){
			throw new InputValidationException("Customer ID should be of four digits.");
		}
	}

	@Override
	protected void inputMapping() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeImpl() {
		// TODO Auto-generated method stub
		outputCustomerDO = customerDAO.getCustomerInfo(customerId);
	}

	@Override
	protected void outputMapping() {
		// TODO Auto-generated method stub
		
	}

	protected void setCustomerId(int customerId){
		this.customerId = customerId;
	}

	@Override
	public Object getOutput() {
		// TODO Auto-generated method stub
		try {
			this.execute();
		} 
		catch (InputValidationException inputValidationException){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		//return Response.ok(outputCustomerDO).build();
		//return Response.status(200).entity(outputCustomerDO).build();
		return outputCustomerDO;
	}

}