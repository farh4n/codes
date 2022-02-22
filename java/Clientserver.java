import java.io.*;
import java.net.*;
public class Clientserver{
public static void main(String[] args) throws IOException{
String serverHostname=new String("localhost");
int port=9999;
System.out.println("Attempting to connect to host"+ serverHostname + "on port" +port);
Socket echoSocket=null;
PrintWriter out=null;
BufferedReader in=null;
try{
echoSocket=new Socket(serverHostname, port);
out=new PrintWriter(echoSocket.getOutputStream(),true);
in=new BufferedReader(new InputStreamReader(
echoSocket.getInputStream()));
} catch(UnknownHostException e){
System.err.println(e);
System.exit(1);
} catch(IOException e){
System.err.println(e);
System.exit(1);
}
BufferedReader stdIn=new BufferedReader(
new InputStreamReader(System.in));
String userInput;
while((userInput=stdIn.readLine()) !=null)
{
out.println(userInput);
System.out.println("Server says:"+in.readLine());
break;
}
out.close();
in.close();
stdIn.close();
}
}
