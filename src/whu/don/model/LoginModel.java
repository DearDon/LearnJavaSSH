package whu.don.model;

public class LoginModel {
	public boolean login(String custname, String pwd){
		if(custname.equals("don")&&pwd.equals("123")){
			return true;
		}else{
			return false;
		}
	}
}
