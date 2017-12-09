import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class ser {

	public static void main(String[] args) throws IOException {
		ser s1 = new ser();
		s1.send();
		}
	public void send()throws IOException{
		int maxThreads = 100;
		clientThread [] threads = new clientThread[maxThreads];
		int number,temp;
		ServerSocket s1 = new ServerSocket(001);
		while(true){
		Socket ss = s1.accept();
		for(int i =0;i<maxThreads;i++){
			if(threads[i] == null){
				(threads[i]=new clientThread(ss,threads)).start();
				break;
			}
			}
		
	}



	}

}









