package Pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class PrintTicket 
{
	public static LinkedHashMap<Integer,ArrayList<String>> tickets=new LinkedHashMap<Integer,ArrayList<String>>();
	public void print()
	{
		System.out.println("Enter you PNR Number :");
		Scanner s=new Scanner(System.in);
		int pnr=0;
		pnr=s.nextInt();
		boolean isTicket=false;
		for(int i=0;i<Variables.ticketsPnr.size();i++)
		{
			
			if(Variables.ticketsPnr!=null)
			{
				Set<Integer> keySet=Variables.ticketsPnr.keySet();
				Iterator<Integer> value=keySet.iterator();
				while(value.hasNext())
				{
					int tempPnr=value.next();
					if(pnr==tempPnr)
					{
						String pnrStatus=Variables.ticketsPnr.get(tempPnr);
						if(pnrStatus.equals("CNF"))
						{
							tickets=Variables.ticketsCnf;
						}
						else if(pnrStatus.equals("RAC"))
						{
							tickets=Variables.ticketsRac;
						}
						else
						{
							tickets=Variables.ticketsWl;
						}
						isTicket=true;
						break;
					}
					else
					{
						isTicket=false;
					}
					
				}
				
			}
		}
		if(!isTicket)
		{
			System.out.println("The Entered PNR not existing !");
		}
		Set keySet=tickets.keySet();
		Iterator value=keySet.iterator();
		while(value.hasNext())
		{
			ArrayList<String> temp=tickets.get(value.next());
			if(pnr==Integer.valueOf(temp.get(6)))
			{
				System.out.println("************TRAIN TICKET************");
				System.out.println(java.time.LocalDateTime.now());
				System.out.println("____________________________________");
				System.out.println("Name:"+temp.get(0));
				System.out.println("Ticket Status:"+temp.get(5));
				System.out.println("Age:"+temp.get(1));
				System.out.println("Gender:"+temp.get(2));
				System.out.println("Bearth:"+temp.get(3));
				System.out.println("____________________________________");
				System.out.println("PNR Number: "+temp.get(6));
				System.out.println("************************************");
			}
		}
		
	}
	public void printAvailableTicket() 
	{
		System.out.println("************AVAILABLE TRAIN TICKET************");
		System.out.println(java.time.LocalDateTime.now());
		System.out.println("____________________________________");
		System.out.println("Confiremed Bearth:"+(63-Variables.countTicket));
		System.out.println("RAC:"+(18-Variables.countRac));
		System.out.println("Waiting List:"+(10-Variables.countWaitingTicket));
		System.out.println("____________________________________");
		System.out.println("************************************");
		
	}

}
