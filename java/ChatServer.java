import java.net.*;
import java.io.*;
public class ChatServer{
public static void main(String[] args) throws IOException{
ServerSocket serverSocket=null;
int port =9999;
try{
serverSocket=new ServerSocket(port);
}catch(IOException e){
System.err.println("Could not listen on port :"+port);
System.exit(1);
}
Socket clientSocket=null;
System.out.println("Waiting for connection....");
try{
clientSocket=serverSocket.accept();
}catch(IOException e){
System.err.println("Accept failed");
System.exit(1);
}
System.out.println("connected successfully");
System.out.println("Waiting for input...");
PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
String inputLine=" ";
System.out.println("Enter a text:");
BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in));
String outputLine=" ";
while((inputLine=in.readLine())!=null){
if(inputLine.equals("Bye")){
System.exit(1);
}
else
{
System.out.println("Client says: "+inputLine);
outputLine=stdIn.readLine();
out.println(outputLine);
}
in.close();
out.close();
clientSocket.close();
}
}
}


