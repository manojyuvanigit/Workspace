package Pack;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class TicketBooking extends HomePage
{
	public String coachPreference;
	public String bearthPreference;	
	public String name;
	public int age;
	public String gender;
	public int pnr;
	public TicketBooking()
	{
		
	}
	public void getDetails()
	{
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Coach Preference :");
		coachPreference=s.next();
		System.out.println("Enter the Bearth Preference(L,M,U,SL,SU) :");
		bearthPreference=s.next();
		System.out.println("Enter the Name :");
		name=s.next();
		System.out.println("Enter the Age :");
		age=s.nextInt();
		System.out.println("Enter the Gender :");
		gender=s.next();
		if(age>60)
		{
			bearthPreference="L";
		}
		ArrayList<String> details=new ArrayList<>();
		details.add(name);
		details.add(String.valueOf(age));
		details.add(gender);
		details.add(coachPreference);
		details.add(bearthPreference);
		if((Variables.countTicket<=1))
		{
			details.add("CNF");
			Variables.countTicket++;
			Random r=new Random();
			pnr=r.nextInt(10000000);
			details.add(String.valueOf(pnr));
			System.out.println("PNr Number :"+pnr);
			System.out.println("Ticket Booked !");
		    Variables.ticketsCnf.put(Variables.count++,details);
		    Variables.ticketsPnr.put(pnr,"CNF");
		  
			
		}
		else if(Variables.countRac<=1) 
		{
			details.add("RAC");
			Variables.countRac++;
			Random r=new Random();
			pnr=r.nextInt(10000000);
			details.add(String.valueOf(pnr));
			System.out.println("PNr Number :"+pnr);
			System.out.println("Ticket Booked !");
		    Variables.ticketsRac.put(Variables.count++,details);
		    Variables.ticketsPnr.put(pnr,"RAC");
		   
		}
		else if(Variables.countWaitingTicket<=1)
		{
			details.add("WL");
			Variables.countWaitingTicket++;
			Random r=new Random();
			pnr=r.nextInt(10000000);
			details.add(String.valueOf(pnr));
			System.out.println("PNR Number :"+pnr);
			System.out.println("Ticket Booked !");
		    Variables.ticketsWl.put(Variables.count++,details);
		    Variables.ticketsPnr.put(pnr,"WL");
		    
		}
		else
		{
			System.out.println("No Tickets Available");
		}
	}
	public  void recursion()
	{
		HomePage obj=new HomePage();
		obj.welcomeText();
		obj.navigation();
	}
	public static void main(String args[])
	{
		
	}
}
