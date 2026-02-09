package Pack;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Variables 
{
	public static int count=0;
	public static int countTicket=0;
	public static int countRac=0;
	public static int countWaitingTicket=0;	
	public static LinkedHashMap<Integer,ArrayList<String>> ticketsCnf=new LinkedHashMap<Integer,ArrayList<String>>();
	public static LinkedHashMap<Integer,ArrayList<String>> ticketsRac=new LinkedHashMap<Integer,ArrayList<String>>();
	public static LinkedHashMap<Integer,ArrayList<String>> ticketsWl=new LinkedHashMap<Integer,ArrayList<String>>();
	public static LinkedHashMap<Integer,String> ticketsPnr=new LinkedHashMap<Integer,String>();
}
