import java.util.*;
public class Candidatevalidate {
	Scanner sc=new Scanner(System.in);
	int age;
	String area;
	String party;
	Candidatevalidate()
	{
		age=0;
		area="";
		party="";
	}
		int ageValidate(int age)
		 {
			 if(age>21)
			 {
				 
			 }
			 else
			 {
				 System.out.println("Your age should be greater than 21");
					System.out.println("age: ");
					age=sc.nextInt();
					age=ageValidate(age);
			 }
			 return age;
		 }
		 String areaValidate(String area)
		 {
			 if(area.equalsIgnoreCase("coimbatore")||area.equalsIgnoreCase("chennai")||area.equalsIgnoreCase("madurai"))
			 {
				 
			 }
			 else
			 {
				 System.out.println("Area should be Coimbatore,Chennai,madurai ");
				 System.out.println("Enter the Candidate Area: ");
				 area=sc.next();
				 area=areaValidate(area);
			 }
			 return area;
		 }
		 String partyValidate(String party)
		 {
			 if(party.equalsIgnoreCase("BJP")||party.equalsIgnoreCase("CONGRESS"))
			 {
				 
			 }
			 else
			 {
				 System.out.println("Parties should be BJP or Congress ");
				 System.out.println("Enter the Candidate party: ");
				 party=sc.next();
				 party=partyValidate(party);
			 }
			 return party;
		 }
		 String wardnoValidate(String wardno)
		 {
			 if(wardno.equalsIgnoreCase("100")||wardno.equalsIgnoreCase("101")||wardno.equalsIgnoreCase("102")||wardno.equalsIgnoreCase("103")||wardno.equalsIgnoreCase("104")||wardno.equalsIgnoreCase("105")||wardno.equalsIgnoreCase("106")||wardno.equalsIgnoreCase("107")||wardno.equalsIgnoreCase("108")||wardno.equalsIgnoreCase("109")||wardno.equalsIgnoreCase("110"))
			 {
				 
			 }
			 else
			 {
				 System.out.println("wardno should be between 100 to 110 ");
				 System.out.println("Enter the wardno: ");
				 wardno=sc.next();
				 wardno=wardnoValidate(wardno); 
			 }
			 return wardno;
		 }
		 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
