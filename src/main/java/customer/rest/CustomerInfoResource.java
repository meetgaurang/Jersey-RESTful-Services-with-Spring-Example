package customer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import customer.dataobjects.CustomerDO;

@Path("/customer/{customer-id}")
@Component
public class CustomerInfoResource {
	@Autowired
	CustomerInfoResourceHelper customerInfoResourceHelper;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerDO getCustomerInfo(@PathParam("customer-id") int customerId){
		customerInfoResourceHelper.setCustomerId(customerId);
		return (CustomerDO)customerInfoResourceHelper.getOutput();
	}
	
	/*@PUT
	public Response putCustomerInfo(@PathParam("customer-id") int customerId){
		return null;
	}*/
}
