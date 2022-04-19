import java.net.*;
import java.io.*;
public class Server{
	public static void main(String args[])throws IOException{
		ServerSocket serversocket=null;
		int port=5555;
		try{
			serversocket=new ServerSocket(port);
		}
		catch(IOException e){
			System.out.println("could not listen on port"+port);
			
		}
		Socket clientsocket=null;
		System.out.println("Server ready to accept connections");
		try{
			clientsocket=serversocket.accept();
			
		}
		catch(IOException e){
			System.out.println("Accept failed");
			System.exit(1);
		}
		System.out.println("Connection Successful");
		System.out.println("Waiting for input");
		PrintWriter out2=new PrintWriter(clientsocket.getOutputStream(),true);
		BufferedReader in=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
		String inputLine;
		while((inputLine=in.readLine())!=null)
		{
			System.out.println("client says:"+inputLine);
			out2.println(inputLine);
			if(inputLine.equals("quit"))
				break;
		}
		out2.close();
		in.close();
		clientsocket.close();
		
	}
}
