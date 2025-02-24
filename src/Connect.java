import java.util.*;
import java.sql.*;
public class Connect extends Candidatevalidate {
	Connection con;
	Scanner sc=new Scanner(System.in);
	Connect()throws Exception
	{
		this.con=null;
		getConnect();
	}
	void getConnect()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/Election","root","vishnus");
		//System.out.println(con);
	}
	void insertSignup(String username,String password,String Email,String dob,int age,String phone,String voter_id,int id) throws Exception
	{
		Statement st=con.createStatement();
		st.execute("INSERT INTO Signup VALUES('"+username+"','"+password+"','"+Email+"','"+dob+"','"+age+"','"+phone+"','"+voter_id+"','"+0+"');");
		//System.out.println("Your age: ");
		//st.execute("select year(now())-year(dob) from signup where username='"+username+"';");
	}
//	void agecalculate(String username)throws Exception
//	{
//		//String username=sc.next();
//		String query="select year(now())-year(dob) from signup where username='"+username+"';";
//		Statement st=con.createStatement();
//		int c=st.executeQuery(query);
//		System.out.print(c);
//	}
	//void insertvoter(String )
	void insertAdmin(String username,String password)throws Exception
	{
		Statement st1=con.createStatement();
		st1.execute("INSERT INTO admin VALUES('"+username+"','"+password+"');");
	}
	void insertCandidate(String position,String name,String dob,int age,String wardno,String party,String area,String symbol)throws Exception
	{
		Statement st=con.createStatement();
		st.execute("INSERT INTO candidate VALUES('"+position+"','"+name+"','"+dob+"','"+age+"','"+wardno+"','"+party+"','"+area+"','"+symbol+"');");
		System.out.println("Candidate Addes Successfully!");
		if(position.equalsIgnoreCase("pm")) {
		st.execute("INSERT INTO pmcandidate VALUES('"+party+"','"+area+"','"+symbol+"','"+0+"');");
		}
		else if(position.equalsIgnoreCase("CM"))
		{
		st.execute("INSERT INTO cmcandidate VALUES('"+party+"','"+area+"','"+symbol+"','"+0+"');");
		}
	}
	void insertloginuser(String voter_id,String password)throws Exception
	{
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("select password from signup where voter_id = '"+voter_id+"';");
		String pass="";
		while(rs.next()) {
		pass = rs.getString("password");
		}	
		if(pass.equals(password)) {
		st.execute("INSERT INTO LOGINUSER VALUES('"+voter_id+"','"+password+"');");
		st.execute("INSERT INTO VOTES VALUES('"+voter_id+"','"+0+"');");
		}
		else
		{
			System.out.println("Wrong password");
			System.out.println("RE-enter the password as you provided first: ");
			password = sc.next();
			
			if(pass.equals(password)) {
				st.execute("INSERT INTO LOGINUSER VALUES('"+voter_id+"','"+password+"');");
				}
		}
		//return insertloginuser(voter_id,password);
	}
	 void toDisplay()throws Exception
	 {
		 String query="select * from candidate";
		 Statement st2=con.createStatement();
		 ResultSet rs=st2.executeQuery(query);
		 while(rs.next())
		 {
			 System.out.println("Position: "+rs.getString(1)+" name: "+rs.getString(2)+" dob: "+rs.getString(3)+" age: "+rs.getInt(4)+" ward-no: "+rs.getString(5)+" party: "+rs.getString(6)+" area: "+rs.getString(7)+" Symbol: "+rs.getString(8));
			 System.out.println();
		 }
	}
	 void toDeleteCandidate()throws Exception
	 {
		 System.out.println("Enter an name of the Candidate to delete: ");
		 String name=sc.next();
		 System.out.println("Enter an party of the Candidate to delete: ");
		 String party=sc.next();
		 String query="DELETE FROM CANDIDATE WHERE NAME='"+name+"'AND party='"+party+"';";
		 Statement st=con.createStatement();
		 int count=st.executeUpdate(query);
		 if(count>0)
		 {
			 System.out.println("Deleted Successfully!");
		 }
		 else
		 {
			 System.out.println("No matches found");
		 }
	 }
	 
	 public boolean loginValidate(String username,String password) throws Exception
	  {
		  String name=username;
		  Statement st=con.createStatement();
		  String query="select * from admin where username ='"+name+"' and password ='"+password+"';";
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			String usename=rs.getString(1);
			String pass=rs.getString(2);
			System.out.println(usename);
			System.out.println(pass);
			return true;
		}
		return false;
	  }
	 public boolean loginuserValidate(String voter_id,String password) throws Exception
	  {
		  String voteid=voter_id;
		  Statement st=con.createStatement();
		  String query="select * from signup where voter_id ='"+voteid+"' and password ='"+password+"';";
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			String voterid=rs.getString(1);
			String pass=rs.getString(2);
			System.out.println(voterid);
			System.out.println(pass);
			return true;
		}
		return false;
	  }
	 void toDisplayCandidateparty()throws Exception
	 {
		 String query="select * from candidate ";
		 Statement st3=con.createStatement();
		 ResultSet rs=st3.executeQuery(query);
		 while(rs.next())
		 {
			 System.out.println("Name: "+rs.getString(1)+"Party: "+rs.getString(2));
			 System.out.println();
		 }
		 
	}
	 void toDisplayCmCandidate()throws Exception
	 {
		 System.out.println("Enter your wardno: ");
		 String wardno=sc.next();
		 Connect c=new Connect();
		 c.wardnoValidate(wardno);
		 String query="select name,party,symbol from candidate where position='CM' AND WARDNO='"+wardno+"';";
		 Statement st3=con.createStatement();
		 ResultSet rs=st3.executeQuery(query);
		 while(rs.next())
		 {
			 System.out.println(" Name: "+rs.getString(1)+" Party: "+rs.getString(2)+" symbol: "+rs.getString(3));
			 System.out.println();
		 }
	 }
	 void toDisplayPmCandidate()throws Exception
	 {
		 System.out.println("Enter your wardno: ");
		 String wardno=sc.next();
		 Connect c=new Connect();
		 c.wardnoValidate(wardno);
		 String query="select name,party,symbol from candidate where position='PM' AND WARDNO='"+wardno+"';";
		 Statement st3=con.createStatement();
		 ResultSet rs=st3.executeQuery(query);
		 while(rs.next())
		 {
			 System.out.println(" Name: "+rs.getString(1)+" Party: "+rs.getString(2)+" Symbol: "+rs.getString(3));
			 System.out.println();
		 }
	 }
	 void toCount()throws Exception
	 {
//		 System.out.println("Enter an Your Voter_id: ");
//		 String voter_id=sc.next();
		 System.out.println("Enter Symbol name to vote: ");
		 String symbol=sc.next();
		 System.out.println("Enter a party: ");
		 String party=sc.next();
		 String query="UPDATE pmcandidate SET COUNT=COUNT+1 WHERE SYMBOl='"+symbol+"' AND PARTY='"+party+"';";
//		 String query1="UPDATE votes SET COUNT=COUNT+1 WHERE voter_id='"+voter_id+"'";
		 Statement st=con.createStatement();
//		 Statement st1=con.createStatement();
		 int c=st.executeUpdate(query);
		// c=st1.executeUpdate(query1);
		 if(c==1) {
//			 Statement st1=con.createStatement();
//			 st1.executeUpdate(query);
			 System.out.println("Vote Added Successfully!");
		 }
	 }
	 void toCmCount()throws Exception
	 {
//		 System.out.println("Enter an Your Voter_id: ");
//		 String voter_id=sc.next();
		 System.out.println("Enter symbol you need to vote: ");
		 String symbol=sc.next();
		 System.out.println("Enter a Party: ");
		 String party=sc.next();
		 String query="UPDATE cmcandidate SET COUNT=COUNT+1 WHERE SYMBOL='"+symbol+"'AND PARTY='"+party+"';";
		 Statement st=con.createStatement();
		 int c=st.executeUpdate(query);
		 if(c==1)
		 {
//		 ResultSet rs=st.executeQuery(query);
//		 while(rs.next())
//		 {
//			 System.out.println("You Voted For");
//			 System.out.println(" party: "+rs.getString(1));
//			 System.out.println();
//		 }
//		 {
//			 //String query1="UPDATE votes SET COUNT=COUNT+1 WHERE voter_id='"+voter_id+"'";
////			 Statement st1=con.createStatement();
////			 st1.executeUpdate(query1);
		 System.out.println("Vote Added Successfully!");
	 }
		 //System.out.println("Vote Added Successfully!");
	 }
	 void toDisplaypmresult()throws Exception
	 {
		 String query=" select party,count from pmcandidate where count=(select max(count) from pmcandidate);";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 while(rs.next())
		 {
			 System.out.println("Winner of PM Candidate");
			 System.out.println(" party: "+rs.getString(1)+" vote polled : "+rs.getInt(2));
			 System.out.println();
		 }
	 }
	 void toDisplaycmresult()throws Exception
	 {
		 String query=" select party,count from cmcandidate where count=(select max(count) from cmcandidate);";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 while(rs.next())
		 {
			 System.out.println("Winner of CM Candidate");
			 System.out.println(" party: "+rs.getString(1)+" vote polled: "+rs.getInt(2));
			 System.out.println();
		 }
	 }
	 void Voters()throws Exception
	 {
		 System.out.println("Enter your voter_id: ");
		 String voter_id=sc.next();
		 String query1="UPDATE votes SET COUNT=COUNT+1 WHERE voter_id='"+voter_id+"'";
		 Statement st=con.createStatement();
		 st.executeUpdate(query1);
	 }
//	 void insertvote(String voter_id,int count)throws Exception
//	 {
//		 String query="insert into votes values (voter_id='"+voter_id+'",
//	 }
	 

//		public static void main(String[] args) throws Exception
//		{
//			Connect obj=new Connect();
//			obj.getConnect();
//		}
	}


