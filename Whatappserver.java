import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Whatappserver{
    ServerSocket sc;
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    BufferedReader br;

    public Whatappserver(){ // constructer 
       try {
        System.out.println("server is waiting....");
        sc=new ServerSocket(4444);
        s=sc.accept();
        System.out.println("connection establised");
       } catch (IOException e) {
       
       }
       Runnable r1=()->{  // first thread for reading data
  try {
    System.out.println("reader start");
    String str="";
    din=new DataInputStream(s.getInputStream());
    while(true){
        str=din.readUTF();
        System.out.println("Client : "+str);
    }
  } catch (IOException e) {
   
    System.out.println("connection is terminated");
  }
       };
       new Thread(r1).start();

       // thread 2
       Runnable r2=()->{ // second thread for writing the data
try {
    System.out.println("server  writer start");
    String str2="";
    dout=new DataOutputStream(s.getOutputStream());
    br=new BufferedReader(new InputStreamReader(System.in));
    while(!str2.equals("stop")){
        str2=br.readLine();
        dout.writeUTF(str2);
        dout.flush();
    }
    dout.close();
    s.close();
} catch (IOException e) {
    System.out.println("connection is closed");
}
       };
       new Thread(r2).start();
    }
    public static void main(String... args){
        System.out.println("server is start");
new Whatappserver();
    }
}
