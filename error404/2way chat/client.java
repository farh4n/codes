import java.net.*;
import java.io.*;

public class client
{
	public static void main(String args[])throws IOException{
		String serverHostName=new String("localhost");
		int port=1212;
		System.out.println("Attemting to connct to host"+serverHostName+"on port"+port);
		
		Socket echosocket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		
		try{
			echosocket=new Socket(serverHostName,port);
			out=new PrintWriter(echosocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(echosocket.getInputStream()));
			
		}
		catch(UnknownHostException e){
			System.err.println(e);
			System.exit(1);
			
		}
		catch(IOException e){
			System.err.println(e);
			System.exit(1);
		}
		BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		while((userInput=stdIn.readLine())!=null){
			out.println(userInput);
			System.out.println("server says:"+in.readLine());
		}
		out.close();
		in.close();
		stdIn.close();
	}
}
