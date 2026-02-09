package Pack;
import java.io.*;
import java.util.*;
public class HomePage 
{
	public static void main(String args[])
	{
		HomePage obj=new HomePage();
		obj.welcomeText();
		obj.navigation();
	}
	void welcomeText()
	{
		System.out.println("*********WELCOME TO INDIAN RAILWAYS*********\n");
		System.out.println("Please Select the Services:");
		System.out.println("1 -> Book Ticket");
		System.out.println("2 -> Cancel Ticket");
		System.out.println("3 -> Print Booked Ticket");
		System.out.println("4 -> Print Available Ticket");
	}
	public void navigation() 
	{
		int serviceNo=0;
		System.out.println(">>");
		Scanner s=new Scanner(System.in);
		serviceNo=s.nextInt();
		TicketBooking obj=new TicketBooking();
		PrintTicket obj1=new PrintTicket();
		switch(serviceNo)
		{
			case 1:
				obj.getDetails();
				obj.recursion();
				break;
			case 2:
			new CancelTicket().cancel() ;
			    obj.recursion();
				break;
			case 3:
				obj1.print();
				obj.recursion();
				break;
			case 4:
				obj1.printAvailableTicket();
				obj.recursion();
				break;
			default:
				System.out.println("Please enter the correct ServiceNo!");
				navigation();
		}
		
	}
}
