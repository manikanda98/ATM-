package atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Atm  {
	static	Scanner sc=new Scanner (System.in);
	static Customers custom=new Customers();
	static CustDetails details =new CustDetails();
	static Cashload c =new Cashload();
	static void withdraw(int amt) {
		int bal;
		int f=0;
		for(Customers o:details.getDetails()) {
			System.out.println("Enter your pin:");
			int pin=sc.nextInt();
			bal=o.getBal();
			if(o.getPin()==pin) {
				custom=o;
				System.out.println(details.getDetails().remove(o)); 
				System.out.println(c.getCash()-amt);
				c.remaining_cash(c.getCash()-amt);
				bal-=amt;
				System.out.println(bal);
				custom.setBal(bal);
				//System.out.println("atm cash"+c.getCash());
				System.out.println("Remaining:" + custom.getBal()+"\nThank you! Come Again");
				//	CustDetails.l.add(custom);
				//	System.out.println("Remaining:" + custom);
				break;
			}
			else {
				System.err.println("wrong password! try again later!");	
			}
			f++;

		}

	}
	static void transfer() {
		System.out.print("Enter your account number : ");
		int ac=sc.nextInt();
		for(Customers c:details.getDetails()) {
			int bal;
			if(c.getAccount_number()==ac) {
				System.out.println("Enter your pin:");
				int pin=sc.nextInt();
				if(pin==c.getPin()) { 
					System.out.println("Enter receiver account number:");
					int rac=sc.nextInt();
					System.out.println("Enter the amount:"); 
					int amt=sc.nextInt();
					if(amt>=0 && amt<=c.getBal()) {
						bal= c.getBal()-amt;
						c.setBal(bal);	
					}
					for(Customers c1:details.getDetails()) {
						if(c1.getAccount_number()==rac) {
							int send=	c1.getBal()+amt;
							c1.setBal(send);   
							System.out.println(c1.getBal());
						}}
				}
			}

		}
	}

	static int check(int ac) throws IOException, ClassNotFoundException {
		int bal=0;
		File f1=new File("C:\\Users\\prasa\\OneDrive\\Desktop\\eclipse workspace\\ATM\\text\\Customer.txt");
		FileOutputStream f=new FileOutputStream(f1);
		ObjectOutputStream o1= new ObjectOutputStream(f);	
		for(Customers o:details.getDetails()) {
			if(o.getAccount_number()==ac) {
				bal = o.getBal();
				//System.out.println(o);
			}
			o1.writeObject(o1);

		}
		return bal;
	}
	static void cashLoad() throws IOException, ClassNotFoundException {
		while(true) {

			System.out.print("Enter no. of 2000: ");
			int t=sc.nextInt();
			System.out.println("number of  2000 is "+ t +" : "+ 2000* t);
			System.out.print("Enter no. of 500: ");
			int f=sc.nextInt();
			System.out.println("number of 500 : "+ 500*f ); 
			System.out.print("Enter no. of 100: ");
			int h=sc.nextInt();
			sc.nextLine();
			System.out.println("number of 100 : "+ 100*h );
			System.out.println("Total: "+( 2000*t +500*f + 100*h));
			c.setCash(2000*t +500*f + 100*h);
			System.out.println( c.getCash());	
			System.out.println("Enter exit! to stop \n else continue to proceed! else enter main to go main menu ");
			String s=sc.nextLine();
			if(s.equals("exit")) {
				System.exit(0);
			}
			else  if (s.equals("continue")){
				continue;
			}
			else if(s.equals("main")) {
				menu();
			}
			else {
				System.err.println(">>>>>>>>invalid<<<<<<<<<<<");
				System.out.println("Enter exit! to stop \n else continue to proceed! ");
				String s1=sc.nextLine();
				if(s1.equals("exit")) {
					System.exit(0);
				}
				else  if (s1.equals("continue")){
					continue;
				}
			}

		}
	}
	public static void AtmOperations() throws IOException, ClassNotFoundException {
		while(true) {
			System.out.println();
			System.out.println("1.check balance");
			System.out.println("2.Withdraw money");
			System.out.println("3.transfer money");
			System.out.println("4.check ATM balance");
			System.out.println("5.Main Menu");
			System.out.println("___________________________________");
			switch (sc.nextInt()) {
			case 1:
				System.out.print("Enter your Account number: ");
				System.out.println(check(sc.nextInt()));
				break;
			case 2:{
				System.err.println("Maximum WithDrawal limit for a single transaction is 10,000 ");
				System.out.println();
				System.out.println("Insert your card: ");
				int ac=sc.nextInt();
				try {
					for(Customers o:details.getDetails()) {
						if(o.getAccount_number()==ac) {
							System.out.println("Enter cash: ");
							int amt=sc.nextInt();
							if(amt>=0 && amt<=o.getBal()-amt && amt<c.getCash() && amt>100) {
								withdraw(amt);

								//	System.out.println(c.getCash());

								return;
							}
							else
								System.err.println(">>>>>>>>>>Insufficient Money!<<<<<<<<<<");
							System.out.println();
							break;
						}

					}

				}catch(Exception e){

				}

				break;}

			case 3:{

				transfer(); 
				break;
			}
			case 4:{
				System.out.println(c.getCash());
				break;
			}
			case 5:{
				menu();
			}

			default:
				break;
			}

			//System.out.println(CustDetails.getDetails());
		}
	}
	//	public static void customers() {
	//		CustDetails d=new CustDetails();
	//		for(Customers p:d.getDetails()) {
	//			System.out.println(p);
	//		}
	//	}
	public static void menu() throws IOException, ClassNotFoundException {

		while(true) {
			System.out.println();
			System.out.println("Enter 1 to load cash");
			System.out.println("Enter 2 to get Customer Details");
			System.out.println("Enter 3 to show ATM Operations ");
			System.out.println("___________________________________");
			int c=sc.nextInt();
			switch (c) {
			case 1:
				cashLoad();
				break;
			case 2:{

				File f1=new File("C:\\Users\\prasa\\OneDrive\\Desktop\\eclipse workspace\\ATM\\text\\Customer.txt");
				FileInputStream f=new FileInputStream(f1);
				ObjectInputStream o1= new ObjectInputStream(f);
				details=(CustDetails)o1.readObject();
				for(Customers o:details.getDetails()) {
					System.out.println(o);
				}
				break;
			}
			case 3:
				AtmOperations();
				break;
			default:
				System.err.println("Invalid Option");
				break;
			}


		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File f1=new File("C:\\Users\\prasa\\OneDrive\\Desktop\\eclipse workspace\\ATM\\text\\Customer.txt");
		FileOutputStream f=new FileOutputStream(f1);
		ObjectOutputStream o= new ObjectOutputStream(f);
		o.writeObject(details);
		menu();
		//By Manikandan P
	}
}
