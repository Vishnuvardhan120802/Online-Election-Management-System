import java.util.*;
import java.sql.*;
public class Voter {
	Scanner sc=new Scanner(System.in);
	String voter_id;
	Voter()
	{
		voter_id="";
	}
	void voter_idname()throws Exception
	{
		System.out.println("Enter your Voter-id number: ");
		String voter_id=sc.next();
		Signup s=new Signup();
		s.voteridvalidate(voter_id);
	}
	void toVote()throws Exception
	{
		Connect c=new Connect();
		c.getConnect();
		boolean b=true;
		while(b)
		{
			System.out.println("Enter 1 for PM Election");
			System.out.println("Enter 2 for CM Election");
			System.out.println("Enter 3 for exit");
			int ch=sc.nextInt();
			sc.nextLine();
			switch(ch)
			{
			case 1:
				
				System.out.println("PM Election");
//				System.out.println("Enter your Voter-id number: ");
//				String voter_id=sc.next();
//				Signup s=new Signup();
//				s.voteridvalidate(voter_id);
//				Voter v=new Voter();
//				v.voter_idname();
				c.toDisplayPmCandidate();
				c.Voters();
				//String party=sc.next();
				c.toCount();
				break;
			case 2:
				System.out.println("CM Election");
//				System.out.println("Enter your Voter-id Number: ");
//				voter_id=sc.next();
//				Signup si=new Signup();
//				si.voteridvalidate(voter_id);
				c.toDisplayCmCandidate();
				c.Voters();
				c.toCmCount();
				break;
			case 3:
				b=false;
				break;
				
				
			}
		}
		
	}
	
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Voter a=new Voter();
		//a.toVote(null);

	}

}
