import java.util.*;
public class Admin {
	String username;
	String password;
//	Admin()
//	{
//		username="";
//		password="";
	//}
	 void adminlogin(String username,String password)throws Exception
	{
		System.out.println("Welcome admin");
		Admin ad=new Admin();
		ad.Adminusage(username, password);
	}
//	public void adminValidate(String username,String password)
//	{
//		if(username.equals("vishnu")&& password.equals("Vishnu@12"))
//		{
//			Admin obj=new Admin();
//			obj.
//			System.out.println("Welcome Admin");
//		}
//		else
//		{
//			System.out.println("Not a valid Admin");
//		}
//	}
	void Adminusage(String username,String password)throws Exception
	{
		//Scanner sc=new Scanner();
		Connect c=new Connect();
		c.getConnect();
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		while(b)
		{
			System.out.println("Press 1 for Add candidate for Election");
			System.out.println("Press 2 for view  Overall Candidates");
			System.out.println("Press 3 for Remove a Candidate");
			System.out.println("Press 4 for view Candidates of PM Election ");
			System.out.println("press 5 for view Candidates of CM Election");
			System.out.println("Press 6 for view PM Results");
			System.out.println("Press 7 for view CM Results");
			System.out.println("press 8 for Exit");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			Candidate obj=new Candidate();
			obj.toCandidate();
			//c.insertCandidate(voter-id,name,dob,age,wardno,party,area,symbol);
			break;
		case 2:
		//Connect co=new Connect();
		c.toDisplay();
		break;
		case 3:
			c.toDeleteCandidate();
			break;
		case 4:
			Candidate ca=new Candidate();
			ca.PmCandidate();
			break;
		case 5:
			Candidate can=new Candidate();
			can.CmCandidate();
			break;
		case 6:
			c.toDisplaypmresult();
			break;
		case 7:
			c.toDisplaycmresult();
			break;
		case 8:
//			System.out.println("Back to login");
			login l=new login();
			b=false;
//			l.Loginuser(username, password);
			//b=false;
			System.exit(0);
			break;
		default:
			System.out.println("Enter an valid choice: ");
			//Adminusage(username,password);
		}
	}
	}

	
//		boolean b=true;
//		
//		while(b)
//		{
//			int c=sc.nextInt();
//			switch(c)
//			{
//			case 1:
//				login a=new login();
//				break;
//			case 2:
//				Admin d=new Admin();
//			}
		}
