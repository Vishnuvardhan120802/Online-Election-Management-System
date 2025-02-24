import java.util.*;
public class login
{
	Scanner sc=new Scanner(System.in);
	String username;
	String password;
//	String confirmpassword;
	login()
	{
		username="";
		password="";
//		confirmpassword="";
	}
	login(String username,String password)
	{
		this.username=username;
		this.password=password;
//		this.confirmpassword=confirmpassword;
	}
	void getlogin(String username,String password)throws Exception
	{
		if(username.equals("vishnu")&& password.equals("Vishnu@12"))
		{
			Admin obj=new Admin();
			System.out.println("Welcome admin"+username+" "+password);
			obj.adminlogin(username, password);
		}
		else
		{
			Connect co=new Connect();
			boolean a=co.loginValidate(username, password);
//			boolean a=false;
			if(a==false) {
				System.out.println("Not a valid user ");
				login l=new login();
				l.Loginuser(username, password);
//				System.out.println("Enter an Username: ");
//				username=sc.next();
//				System.out.println("Enter your password: ");
//				password=sc.next();
				Voter vo=new Voter();
				vo.toVote();
				//co.loginValidate(username, password);
			}
			else if(a==true) {
				Admin adm=new Admin();
				adm.Adminusage(username, password);
			}
		}
//		System.out.println("Enter an Username: ");
		//username=sc.next();
//		System.out.println("Password: ");
		//password=sc.next();
//		System.out.println("Confirm Password: ");
//		confirmpassword=sc.next();
//		if(password.equals(confirmpassword))
//		{
//			//System.out.println("Login Succesfully!");	
//		}
//		else
//		{
//			System.out.println("Password Doesn't Match");
//		}
		System.out.println("Login Successfull");
	}
	void Loginuser(String voter_id,String password)throws Exception
	{
		System.out.println("Enter an voterId Number: ");
		voter_id=sc.next();
		Signup s=new Signup();
		s.voteridvalidate(voter_id);
		System.out.println("Enter an password: ");
		password=sc.next();
		Connect c=new Connect();
		c.loginuserValidate(voter_id, password);
		c.insertloginuser(voter_id, password);
		Voter vo=new Voter();
		vo.toVote();
		
	}
}

//public class login {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		login obj=new login();
//		Scanner sc=new Scanner(System.in);
////		String username=sc.next();
////		String password=sc.next();
////		String Confirmpassword=sc.next();
//		obj.getlogin(null, null, null);

//	}
//
//}
