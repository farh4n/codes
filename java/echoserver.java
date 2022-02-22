import java.net.*;
import java.io.*;
public class echoserver
{
	public static void main(String[] args) throws IOException
{
ServerSocket serverSocket =null;
int port =4444;
try
{
	serverSocket=new ServerSocket(port);
}
catch(IOException e)
{
	System.err.println("could not listen on port: "+port);
	System.exit(1);
}
Socket clientSocket=null;
System.out.println("waiting for connection..........");
try
{
	clientSocket= serverSocket.accept();
}
catch(IOException e)
{
	System.err.println("Accept failed");
	System.exit(1);
}
System.out.println("Connection successfull");
System.out.println("waiting for input....");
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
true);
BufferedReader in=new BufferedReader(
new InputStreamReader(clientSocket.getInputStream()));
String inputLine;
while((inputLine=inputLine=in.readLine()) !=null)
{
	System.out.println("Client says: " + inputLine);
	out.println(inputLine);
if(inputLine.equals("quit"))
break;
}
out.close();
in.close();
clientSocket.close();
}
}
