package Pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class CancelTicket 
{
	public static LinkedHashMap<Integer,ArrayList<String>> tickets=new LinkedHashMap<Integer,ArrayList<String>>();
	public void cancel()
	{
		System.out.println("Enter you PNR Number :");
		Scanner s=new Scanner(System.in);
		Integer pnr=0;
		pnr=s.nextInt();
		boolean isTicket=false;
		Set<Integer> keySet=Variables.ticketsPnr.keySet();
		Iterator<Integer> tempPnr=keySet.iterator();
		while(tempPnr.hasNext())
		{
			if(pnr==tempPnr.next())
			{
				String pnrStatus=Variables.ticketsPnr.get(tempPnr.next());
				Variables.ticketsPnr.remove(tempPnr.next());
				if(pnrStatus.equals("CNF"))
				{
					if(Variables.countTicket==1)
					{
						Set keySet1=Variables.ticketsCnf.keySet();
						Iterator value1=keySet1.iterator();
						while(value1.hasNext())
						{
							ArrayList<String> temp=Variables.ticketsCnf.get(value1.next());
							if(pnr==Integer.valueOf(temp.get(6)))
							{
								temp=Variables.ticketsRac.get(Variables.ticketsRac.keySet().iterator().next());
								temp.add(5, pnrStatus);
								Variables.ticketsRac.remove(Variables.ticketsRac.keySet().iterator().next());
								Variables.ticketsCnf.remove(value1.next());
							    Variables.ticketsCnf.put(Variables.count++,temp);
							    //adding PNR Number
							    Variables.ticketsPnr.put(Integer.valueOf(temp.get(6)),"CNF");
							}
							if(Variables.countRac==1)
							{
								temp=Variables.ticketsWl.get(Variables.ticketsWl.keySet().iterator().next());
							    Variables.ticketsRac.put(Variables.count++,temp);
							}
						}
					}
					else
					{
						Set keySet1=Variables.ticketsCnf.keySet();
						Iterator value1=keySet1.iterator();
						while(value1.hasNext())
						{
							ArrayList<String> temp=Variables.ticketsCnf.get(value1.next());
							if(pnr==Integer.valueOf(temp.get(6)))
							{
								Variables.ticketsCnf.remove(value1.next());
							}
						}
						Variables.countTicket--;
					}
					System.out.println("Ticket Canceled");
				}
				else if(pnrStatus.equals("RAC"))
				{
					if(Variables.countRac==1)
					{
						Set keySet1=Variables.ticketsRac.keySet();
						Iterator value1=keySet1.iterator();
						while(value1.hasNext())
						{
							ArrayList<String> temp=Variables.ticketsRac.get(value1.next());
							if(pnr==Integer.valueOf(temp.get(6)))
							{
								temp=Variables.ticketsWl.get(Variables.ticketsWl.keySet().iterator().next());
								temp.add(5, pnrStatus);
								Variables.ticketsWl.remove(Variables.ticketsWl.keySet().iterator().next());
								Variables.ticketsRac.remove(value1.next());
							    Variables.ticketsRac.put(Variables.count++,temp);
							    //adding PNR Number
							    Variables.ticketsPnr.put(Integer.valueOf(temp.get(6)),"RAC");
							}
							if(Variables.countWaitingTicket==1)
							{
								Variables.countWaitingTicket--;
							}
						}
					}
					else
					{
						Set keySet1=Variables.ticketsRac.keySet();
						Iterator value1=keySet1.iterator();
						while(value1.hasNext())
						{
							ArrayList<String> temp=Variables.ticketsRac.get(value1.next());
							if(pnr==Integer.valueOf(temp.get(6)))
							{
								Variables.ticketsRac.remove(value1.next());
							}
						}
						
						Variables.countRac--;
					}
				}
				else
				{
					Set keySet1=Variables.ticketsWl.keySet();
					Iterator value1=keySet1.iterator();
					while(value1.hasNext())
					{
						ArrayList<String> temp=Variables.ticketsWl.get(value1.next());
						if(pnr==Integer.valueOf(temp.get(6)))
						{
							Variables.ticketsWl.remove(value1.next());
						    //adding PNR Number
						    Variables.ticketsPnr.remove(Integer.valueOf(temp.get(6)));
						}
						
					}
					Variables.countWaitingTicket--;
				}
				isTicket=true;
				break;
			}
			else
			{
				isTicket=false;			
		    }
			
		}
		if(!isTicket)
		{
			System.out.println("The Entered PNR not existing !");
		}
	}
	
	
}
