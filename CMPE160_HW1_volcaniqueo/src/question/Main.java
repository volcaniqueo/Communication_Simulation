
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		
		int customerCreationOrder = 0;
		int operatorCreationOrder = 0;
		
		for (int i = 1; i <= N + 1; i++) {
			String myLine = reader.nextLine();
			String[] myOrder = myLine.split("\s");
			if (i == 1)
				continue;
			if (Integer.parseInt(myOrder[0]) == 1) {
				customers[customerCreationOrder] = new Customer(customerCreationOrder, myOrder[1], Integer.parseInt(myOrder[2]), operators[Integer.parseInt(myOrder[3])], Double.parseDouble(myOrder[4]));
				customerCreationOrder++;
			}
			if (Integer.parseInt(myOrder[0]) == 2) {
				operators[operatorCreationOrder] = new Operator(operatorCreationOrder, Double.parseDouble(myOrder[1]), Double.parseDouble(myOrder[2]), Double.parseDouble(myOrder[3]), Integer.parseInt(myOrder[4]));
				operatorCreationOrder++;
			}
			if (Integer.parseInt(myOrder[0]) == 3) {
				customers[Integer.parseInt(myOrder[1])].talk(Integer.parseInt(myOrder[3]), customers[Integer.parseInt(myOrder[2])]);
			}
			if (Integer.parseInt(myOrder[0]) == 4) {
				customers[Integer.parseInt(myOrder[1])].message(Integer.parseInt(myOrder[3]), customers[Integer.parseInt(myOrder[2])]);
			}
			if (Integer.parseInt(myOrder[0]) == 5) {
				customers[Integer.parseInt(myOrder[1])].connection(Double.parseDouble(myOrder[2]));
			}
			if (Integer.parseInt(myOrder[0]) == 6) {
				customers[Integer.parseInt(myOrder[1])].getBill().pay(Double.parseDouble(myOrder[2]));
			}
			if (Integer.parseInt(myOrder[0]) == 7) {
				customers[Integer.parseInt(myOrder[1])].setOperator(operators[Integer.parseInt(myOrder[2])]);
			}
			if (Integer.parseInt(myOrder[0]) == 8) {
				customers[Integer.parseInt(myOrder[1])].getBill().changeTheLimit(Double.parseDouble(myOrder[2]));
			}
			
		}
		
		String talkedMost = customers[0].getName();
		int talkedMinutes = 0;
		String sentMost = customers[0].getName();
		int sentMessages = 0;
		String connectedMost = customers[0].getName();
		double connectedMB = 0.0;
		
		for (Customer myCustomer : customers) {
			if (myCustomer.getTalkingTime() > talkedMinutes) {
				talkedMinutes = myCustomer.getTalkingTime();
				talkedMost = myCustomer.getName();
			}		
		}
		for (Customer myCustomer : customers) {
			if (myCustomer.getNumMessages() > sentMessages) {
				sentMessages = myCustomer.getNumMessages();
				sentMost = myCustomer.getName();
			}		
		}
		for (Customer myCustomer : customers) {
			if (myCustomer.getInternetUsage() > connectedMB) {
				connectedMB = myCustomer.getInternetUsage();
				connectedMost = myCustomer.getName();
			}		
		}
		
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		
		for (Operator myOperator : operators) {
			double roundedUsage = Math.round(myOperator.getProvidedInternetUsage() * 100.0) / 100.0;
			String SroundedUsage = String.format("%.2f", roundedUsage);
			outstream1.println("Operator " + myOperator.getID() + " : " + myOperator.getProvidedTalkingTime() + " " + myOperator.getProvidedNumMessages() + " " + SroundedUsage);
		}
		for (Customer myCustomer : customers) {
			double roundedMoneySpent = Math.round(myCustomer.getBill().getTotalMoneySpent() * 100.0) / 100.0;
			double roundedDebt = Math.round(myCustomer.getBill().getCurrentDebt() * 100.0) / 100.0;
			String SroundedMoneySpent = String.format("%.2f", roundedMoneySpent);
			String SroundedDebt = String.format("%.2f", roundedDebt);
			outstream1.println("Customer " + myCustomer.getID() + " : " + SroundedMoneySpent + " " + SroundedDebt);
		}
		
		outstream1.println(talkedMost + " : " + talkedMinutes);
		outstream1.println(sentMost + " : " + sentMessages);
		double roundedConnectedMB = Math.round(connectedMB * 100.0) / 100.0;
		String SroundedConnectedMB = String.format("%.2f", roundedConnectedMB);
		outstream1.println(connectedMost + " : " + SroundedConnectedMB);
		
		outstream1.close();
		
		
		
		
		
		
		
		
		
		
		
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

