package whu.don.exception;

public class RegisterException extends Exception{
	public RegisterException(){
		super();
	}
	
	public RegisterException(String arg0){
		super(arg0);
	}
	
	public RegisterException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public RegisterException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
