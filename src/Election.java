import java.util.*;
import java.sql.*;
public class Election {
	Scanner sc=new Scanner(System.in);
	void toExecute()throws Exception
	{
		Connect c=new Connect();
		c.getConnect();
		boolean b=true;
		while(b)
		{
			System.out.println("\n 1.Signup\n 2.Login\n 3.Admin\n 4.Exit\n ");
			System.out.println("Enter an choice: ");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				Signup s=new Signup();
				System.out.println("Enter Your username: ");
				String username=sc.next();
				username=s.namevalidate(username);
				System.out.println("Your password must 8 characters Long 1Uppercase 1LOwercase 1number 1special Character");
				System.out.println("Enter the Password: ");
				String password=sc.next();
				password=s.passvalidate(password);
				System.out.println("Enter Your Email: ");
				String Email=sc.next();
				Email=s.Emailvalidate(Email);
				System.out.println("Enter your Date-Of-Birth(YYYY-MM-DD): ");
				String dob=sc.next();
				System.out.println("Enter your age: ");
				int age=sc.nextInt();
				age=s.agevalidate(age);
				System.out.println("Enter your Phone-number: ");
				String phone=sc.next();
				phone=s.phonevalidate(phone);
				System.out.println("Enter your Voter_id Number: ");
				String voter_id=sc.next();
				voter_id=s.voteridvalidate(voter_id);
				int id=0;
				//Connect obj=new Connect();
				System.out.println("Signup Successfull!");
				c.insertSignup(username,password,Email,dob,age,phone,voter_id,id);
				//c.agecalculate(username);
				break;
			case 2:
				login l=new login();
				System.out.println("Enter the Voterid Number: ");
				voter_id=sc.next();
				System.out.println("Enter the Password: ");
				password=sc.next();
				System.out.println("Confirm your Password: ");
				String confirmpassword=sc.next();
				if(password.equals(confirmpassword))
				{
					c.loginuserValidate(voter_id,password);
					c.insertloginuser(voter_id, confirmpassword);
					System.out.println("Login Success");
					Voter v=new Voter();
					v.toVote();
				}
				else
				{
					System.out.println("Passoword must be same as above");
					//confirmpassword=sc.next();
					System.out.println("Re-login");
					login lo=new login();
					lo.Loginuser(voter_id, confirmpassword);
				}
				break;
			case 3:
				int count=0;
				Admin obj1=new Admin();
				login la=new login();
				System.out.println("Enter the username: ");
				username=sc.nextLine();
				System.out.println("Enter the Password: ");
				password=sc.nextLine();
				la.getlogin(username,password);
				
				//c.insertAdmin(username, password);
				obj1.Adminusage(username,password);
//				System.out.println("Press 1 for Add candidate ");
//				System.out.println("Press 2 for view Candidates ");
//				System.out.println("press 3 for Exit");
				break;
			case 4:
				System.out.println("Exited ");
				b=false;
				break;
			default:
				System.out.println("Enter an valid choice: ");
				
				toExecute();
			}
			
		}
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Connect c=new Connect();
		c.getConnect();
		Election a=new Election();
		a.toExecute();
	}

}
