import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Whatappclient{

    Socket s;
    DataOutputStream dout;
    DataInputStream din;
    BufferedReader br;
    public Whatappclient(){ // constructer
     try {
           s=new Socket("localhost", 4444);
           dout=new DataOutputStream(s.getOutputStream());
           br=new BufferedReader(new InputStreamReader(System.in));
     } catch (IOException e) {
    e.printStackTrace();
       
     }
     Runnable r2=()->{   // first thread for input data 
try {
    System.out.println("input is start");
    String str="";
    while(!str.equals("stop")){
str=br.readLine();
dout.writeUTF(str);
dout.flush();
    }
    dout.close();
    s.close();
} catch (IOException e) {
    System.out.println("connection is closed ");
}
     };
     new Thread(r2).start();

     // thread 2

     Runnable r1=()->{  // second thread for reading the data
try {
    System.out.println("client reader");
    din=new DataInputStream(s.getInputStream());
    String str2="";
    while(true){
        str2=din.readUTF();
        System.out.println("Server : "+str2);
    }

} catch (IOException e) {
  
     System.out.println("connection is closed ");
}
     };
     new Thread(r1).start();
    }
    public static void main(String... args){
        System.out.println("client is start");
        new Whatappclient();
    }
}