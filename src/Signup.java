import java.util.*;
public class Signup {
	Scanner sc=new Scanner(System.in);
	String username;
	String password;
	String Email;
	String dob;
	int age;
	String phone;
	String voter_id;
	Signup()
	{
		username="";
		password="";
		Email="";
		dob="";
		age=0;
		phone="";
		voter_id="";
	}
	Signup(String username,String password,String Email,String dob,int age,String phone,String voter_id)
	{
		this.username=username;
		this.password=password;
		this.Email=Email;
		this.dob=dob;
		this.age=age;
		this.phone=phone;
		this.voter_id=voter_id;
	}
	void Signin()
	{
		System.out.println("Enter your Username: ");
		String username=sc.next();
		System.out.println("Enter your Password: ");
		String password=sc.next();
	}
	String namevalidate(String username)
	{
		if(username.length()>=5)
		{
			System.out.println("Proceed to next");
		}
		else
		{
			System.out.println("Username should contains more than 5 Alphabets");
			System.out.println("Enter the username: ");
			username=sc.next();
			namevalidate(username);
		}
		return username;
	}
	String passvalidate(String password)
	{
		if(password.length()>8)
		{
			//System.out.println("Proceed to next");
		}
		else
		{
			System.out.println("Your password must contain more than 8 Characters");
			System.out.println("Enter Password again: ");
			password=sc.next();
			passvalidate(password);
		}
		int uppercase=0;
		int lowercase=0;
		int num=0;
		int sp=0;
		for(int i=0;i<password.length();i++)
		{
			if(password.charAt(i)>='0'&& password.charAt(i)<='9')
			{
				num++;
			}
			else if(password.charAt(i)>='A'&& password.charAt(i)<='Z')
			{
				uppercase++;
			}
			else if(password.charAt(i)>='a'&& password.charAt(i)<='z')
			{
				lowercase++;
			}
			else
			{
				sp++;
			}
		}
		if(num==0)
		{
			System.out.println("Your Password must contain atleast 1 Number");
			System.out.println("Re-enter your Password: ");
			password=sc.next();
			password=passvalidate(password);
		}
		else if(uppercase==0)
		{
			System.out.println("Your Password must contain atleast 1 Uppercase Character");
			System.out.println("Re-enter your Password: ");
			password=sc.next();
			password=passvalidate(password);
		}
		else if(lowercase==0)
		{
			System.out.println("Your Password must contain atleast 1 Lowercase Character");
			System.out.println("Re-enter your Password: ");
			password=sc.next();
			password=passvalidate(password);
		}
		else if(sp==0)
		{
			System.out.println("Your Password must contain atleast 1 Special_Character");
			System.out.println("Re-enter your Password: ");
			password=sc.next();
			password=passvalidate(password);
		}
		return password;
	}
	String Emailvalidate(String email)
	{
		if(email.contains("@")&& email.contains("."))
		{
			
		}
		else
		{
			System.out.println("Your Email must contains @ and .");
			System.out.println("Re-enter your Email: ");
			email=sc.next();
			email=Emailvalidate(email);
		}
		 if(email.contains("gmail.com"))
		{
			
		}
		 else
		 {
			 System.out.println("Your Email must contains COM");
			 System.out.println("Re-enter your Email: ");
			 email=sc.next();
			 email=Emailvalidate(email); 
		 }
		 return email;
	}
	int agevalidate(int age)
	{
		if(age>17)
		{
			
		}
		else
		{
			System.out.println("Your age should be greater than 18");
			System.out.println("age: ");
			age=sc.nextInt();
			age=agevalidate(age);
		}
		return age;
	}
	String phonevalidate(String phone)
	{
		if(phone.length()>=10)
		{
			
		}
		else
		{
			System.out.println("Your Phone-number Must be 10 Digits ");
			System.out.println("Re-Enter your phone number: ");
			phone=sc.next();
			phone=phonevalidate(phone);
		}
		return phone;
	}
	String voteridvalidate(String voter_id)
	{
		if(voter_id.length()==10)
		{
			
			//System.out.println("SignUp Successfull");
		}
		else
		{
			System.out.println("Enter an valid voter_id Details");
			System.out.println("Enter an voter_id: ");
			voter_id=sc.next();
			voter_id=voteridvalidate(voter_id);
		}
		return voter_id;
	}

}
