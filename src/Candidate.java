import java.util.*;
public class Candidate
{
	Scanner sc=new Scanner(System.in);
	String voter_id;
	String name;
	String dob;
	int age;
	int wardno;
	String party;
	String area;
	String symbol;
	Candidate()
	{
		voter_id="";
		name="";
		dob="";
		age=0;
		wardno=0;
		area="";
		party="";
		symbol="";
	}
	Candidate(String voter_id,String name,String dob,int age,int wardno,String area,String party,String symbol)
	{
		this.voter_id=voter_id;
		this.name=name;
		this.dob=dob;
		this.age=age;
		this.wardno=wardno;
		this.area=area;
		this.party=party;
		this.symbol=symbol;
	}
	 void toCandidate()throws Exception
	{
		 Connect c=new Connect();
		 c.getConnect();
		 Candidate o=new Candidate();
		 Candidatevalidate ca=new Candidatevalidate();
//		System.out.println("Enter your voter_id number: ");
//		String voter_id=sc.next();
//		Signup s=new Signup();
//		voter_id=s.voteridvalidate(voter_id);
		System.out.println("Standing for PM or CM: ");
		String position=sc.next();
		System.out.println("Enter the Candidate name: ");
		String name=sc.next();
		System.out.println("Enter the dob of the Candidate: ");
		String dob=sc.next();
		System.out.println("Enter the age of the Candidate: ");
		int age=sc.nextInt();
		age=ca.ageValidate(age);
		System.out.println("Enter the WardNumber Between 100 to 120 : ");
		String wardno=sc.next();
		wardno=ca.wardnoValidate(wardno);
		System.out.print("Enter the area: ");
		String area=sc.next();
		area=ca.areaValidate(area);
		System.out.println("Enter the candidate party: ");
		String party=sc.next();
		party=ca.partyValidate(party);
		System.out.println("Enter the Candidate Symbol: ");
		String symbol=sc.next();
		c.insertCandidate(position,name,dob,age,wardno,party,area,symbol);
//		int covai=0;
//		if(area.equalsIgnoreCase("coimbatore"))
//		{
//			covai++;
//		}
//		if(covai>1)
//		{
//			System.out.print("Cant be coimbatore");
//		}
//		else
//		{
//			
//		}
	}
	 void CmCandidate()throws Exception
	 {
		 Connect c=new Connect();
		 c.toDisplayCmCandidate();
	 }
	 void PmCandidate()throws Exception
	 {
		 Connect c=new Connect();
		 c.toDisplayPmCandidate();
	 }
	 
//	 int ageValidate(int age)
//	 {
//		 if(age>21)
//		 {
//			 
//		 }
//		 else
//		 {
//			 System.out.println("Your age should be greater than 21");
//				System.out.println("age: ");
//				age=sc.nextInt();
//				age=ageValidate(age);
//		 }
//		 return age;
//	 }
//	 String areaValidate(String area)
//	 {
//		 if(area.equalsIgnoreCase("coimbatore")||area.equalsIgnoreCase("chennai")||area.equalsIgnoreCase("madurai"))
//		 {
//			 
//		 }
//		 else
//		 {
//			 System.out.println("Area should be Coimbatore,Chennai,madurai ");
//			 System.out.println("Enter the Candidate Area: ");
//			 area=sc.next();
//			 area=areaValidate(area);
//		 }
//		 return area;
//	 }
//	 String partyValidate(String party)
//	 {
//		 if(party.equalsIgnoreCase("BJP")||party.equalsIgnoreCase("CONGRESS"))
//		 {
//			 
//		 }
//		 else
//		 {
//			 System.out.println("Parties should be BJP or Congress ");
//			 System.out.println("Enter the Candidate party: ");
//			 party=sc.next();
//			 party=partyValidate(party);
//		 }
//		 return party;
//	 }
//	 public static void main(String[] args)
//	 {
//		 Candidate obj=new Candidate();
//		 obj.toCandidate(null, null, null, 0, 0, null, null, null);
//	 }
	
	 
	}
