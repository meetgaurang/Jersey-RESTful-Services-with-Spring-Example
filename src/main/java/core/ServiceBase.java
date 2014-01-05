package core;

import org.apache.log4j.Logger;


public abstract class ServiceBase {

	protected void validate() throws InputValidationException{
		
	}
	protected void inputMapping(){
		
	}
	protected abstract void executeImpl();
	protected void outputMapping(){
		
	}
	public void execute() throws Exception{
		try{
				Logger.getRootLogger().info("Inside ServiceBase.execute..");
				validate();
				inputMapping();
				executeImpl();
				outputMapping();
		}
		catch(InputValidationException inputValidationException){
			//Do logging..
			//inputValidationException.printStackTrace();
			Logger.getRootLogger().error(inputValidationException.getLocalizedMessage(),inputValidationException);
			throw inputValidationException;
		}
		catch(Exception e){
			//Do logging..
			//e.printStackTrace();
			Logger.getRootLogger().error(e.getLocalizedMessage(),e);
			throw e;
		}
	}
	protected abstract Object getOutput();
}
