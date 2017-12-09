import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.*;
public class cli {

	public static void main(String[] args)throws UnknownHostException,IOException {
		cli c = new cli();
		c.send();
		}



public void send()throws IOException{
	int number,temp;
	Scanner sc = new Scanner(System.in);
	Socket s = new Socket("127.0.0.1",001);
	Scanner sc1 = new Scanner(s.getInputStream());
	System.out.println("Welcome to StockAPP");
	System.out.println("Please Choose one of the following options");
	System.out.println("Enter 1 for Stock Data/n Enter 2 for Stock Suggestor /n Enter 3 for Buy/Sell ");
// We will work on the user selection method to select custom stocks. Right now Stocks are HardCoded.
	while(true){
	System.out.println("");
	int next_opp = sc.nextInt();
	if (next_opp == 1) {
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(next_opp);
		String temp1 = sc1.nextLine();
		System.out.println(temp1);
		System.out.println("");
		Scanner sc2 = new Scanner(System.in);
		String symbol = sc2.nextLine();
		PrintStream p2 = new PrintStream(s.getOutputStream());
		p2.println(symbol);
		Scanner sc3 = new Scanner(s.getInputStream());
		System.out.println(sc3.nextLine());

	}

	if(next_opp==2){
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(next_opp);
		Scanner sc4 = new Scanner(s.getInputStream());
		System.out.println(sc4.nextLine());

	}

	if(next_opp==3){
		Scanner buysell = new Scanner(System.in);
		System.out.println("Enter 1 to buy 2 to sell");
		int byorsell = buysell.nextInt();
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(next_opp);
		String temp1 = sc1.nextLine();
		System.out.println(temp1);
		System.out.println("");
		Scanner sc2 = new Scanner(System.in);
		String symbol = sc2.nextLine();
		PrintStream p2 = new PrintStream(s.getOutputStream());
		p2.println(symbol);
		if(byorsell == 1){
			System.out.println("Stock Bought");
		}
		else
			System.out.println("Stock Sold");
		Scanner sc3 = new Scanner(s.getInputStream());
		System.out.println(sc3.nextLine());


	}
		System.out.println("Enter 1 for Stock Data/n Enter 2 for Stock Suggestor /n Enter 3 for Buy/Sell ");
}

}




}
