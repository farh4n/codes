import java.net.*;
import java.io.*;

public class server
{
	public static void main(String args[])throws IOException{
		ServerSocket serversocket=null;
		int port=1212;
		try{
			serversocket=new ServerSocket(port);
			
		}
		catch(IOException e){
			System.out.println("could not listen on port");
		}
		Socket clientsocket=null;
		System.out.println("connectingg...");
		try{
			clientsocket=serversocket.accept();
			
		}
		catch(IOException e){
			System.out.println("Accept failed");
			System.exit(1);
		}
		System.out.println("Connection Successfull");
		System.out.println("Waiting input");
		
		PrintWriter out=new PrintWriter(clientsocket.getOutputStream(),true);
		BufferedReader in=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
		
		String inputLine;
		
		BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		while((inputLine=in.readLine())!=null){
			System.out.println("Client says:"+inputLine);
			userInput=stdIn.readLine();
			out.println(userInput);
			if(inputLine.equals("quit"))
				break;
				
			
		}
		out.close();
		in.close();
		stdIn.close();
		clientsocket.close();
		serversocket.close();
	}
}
