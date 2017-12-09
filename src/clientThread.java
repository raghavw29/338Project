import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class clientThread extends Thread {
	 private DataInputStream is = null;
	  private PrintStream os = null;
	  private Socket clientSocket = null;
	  private final clientThread[] threads;
	  private int maxClientsCount;
	//Will be based on user selected stock in the future.Hard Coded for now.
	  static stock [] stocks = new stock[4];
	public clientThread(Socket clientSocket,clientThread[] threads){
		this.clientSocket = clientSocket;
		this.threads = threads;
		maxClientsCount = threads.length;


		
	}
	
	public void run() {
		System.out.println("New thread :" + this.getId());
		makeStocks();
		Scanner sc = null;
		while (true) {
		try {
			sc = new Scanner(clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			int num = sc.nextInt();
			switch (num) {
				case 1:
					choose_stock_for_data();
					break;
				case 2:
					choose_suggested_stock();
					break;
				case 3:
					Scanner sc2 = null;
					PrintStream p = null;
					try {
						p = new PrintStream(clientSocket.getOutputStream());
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.println("Enter Stock Symbol");
					try {
						sc2 = new Scanner(clientSocket.getInputStream());
					} catch (IOException e) {
						e.printStackTrace();
					}
					String stock = sc2.next();
					System.out.println("This is the stock" + stock);
					for(int i =0;i<stocks.length;i++){
						if(stocks[i]!= null) {
							System.out.println(stock + stocks[i].getStockName());
							if(stocks[i].getStockName().equals(stock)) {
								System.out.println(stocks[i].getStockName());
								PrintStream p1 = null;
								try {
									p1 = new PrintStream(clientSocket.getOutputStream());
								} catch (IOException e) {
									e.printStackTrace();
								}
								p1.println( stocks[i].getStockName() + returnData(stocks[i]));
							}
						}
					}

					break;

				default:
					System.out.println("Enter Valid Option");
					break;
			}


		}
	}
	public static void makeStocks(){
		//HardCoded for NOW. This will contain stocks from Yahoo Finance API
		String [] names = new String []{"APPL","GGL","FB","GMP"};
		for (int i =  0; i<names.length;i++){
			stocks[i] = new stock(names[i]);
		}
	}

	public String returnData(stock s1){
		return s1.financials.toString();
	}

	public void choose_stock_for_data(){
		Scanner sc2 = null;
		PrintStream p = null;
		try {
			p = new PrintStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.println("Enter Stock Symbol");
		try {
			sc2 = new Scanner(clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String stock = sc2.next();
		for(int i =0;i<stocks.length;i++){
			if(stocks[i]!= null) {
				if(stocks[i].getStockName().equals(stock)) {
					PrintStream p1 = null;
					try {
						p1 = new PrintStream(clientSocket.getOutputStream());
					} catch (IOException e) {
						e.printStackTrace();
					}
					p1.println(returnData(stocks[i]));
				}
			}
		}
	}



	public void choose_suggested_stock(){
		stockSuggester s1 = new stockSuggester(stocks);
		PrintStream p3 = null;
		try{  p3 = new PrintStream(clientSocket.getOutputStream());
		}
		catch (IOException e){
			e.printStackTrace();
		}
		p3.println("The suggested stock to buy  is " + s1.suggestStock());
	}

}
