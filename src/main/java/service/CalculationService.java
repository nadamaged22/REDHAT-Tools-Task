package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJB.CalculationEJB;
import databasemodel.Calculation;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/")
public class CalculationService {
	@Inject
	private CalculationEJB EJB;
	
	public CalculationService() {}
	@Path("calc")
    @POST
    public Response calculate (Calculation calc) {
		int result=0;
		switch(calc.getOperation()) {
		case "+":
			 result=calc.getnumber1()+calc.getnumber2();
			 break;
		case "-":
			result=calc.getnumber1()-calc.getnumber2();
			break;
			
		case "*":
			result=calc.getnumber1()*calc.getnumber2();
			break;
			
		case "/":
			if(calc.getnumber2()==0) {
				 throw new IllegalArgumentException("Can't divide by zero"); 
			}
			 result=calc.getnumber1()/calc.getnumber2();
			 break;
		}
		EJB.InsertCalculation(calc);
		 return new Response(result);
	}
	 @Path("calculations")
	    @GET
	    public List<Calculation> getAllCalculations() {
	        return EJB.Retreive();
	    }
	
	

}
