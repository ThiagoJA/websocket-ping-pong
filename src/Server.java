import java.net.*;
import java.io.*;

public class Server {

    private static ServerSocket ServerSockets;

    public static void main(String[] args) throws IOException, EOFException {

        ServerSockets = new ServerSocket(2001);

        while (true) {
            System.out.println("Waiting conection ...");
            Socket conection = ServerSockets.accept();
            System.out.println("Conected");
            DataInputStream input = new DataInputStream(conection.getInputStream());
            DataOutputStream output = new DataOutputStream(conection.getOutputStream());
            System.out.println("Waiting mensage");
            String line = input.readUTF();
            System.out.println("Recived mensage :" + line);
            while (line != null && !(line.trim().equalsIgnoreCase("LEAVE"))) {
                if(line.trim().equalsIgnoreCase("lalala")){
                    output.writeUTF("Recived response: " + "lelele");
                    System.out.println("Sended response");
                    line = input.readUTF();
                }
                else {
                    output.writeUTF("Recived response: " + line);
                    line = input.readUTF();
                    System.out.println("Sended response");
                }
            }
            output.writeUTF(line);
            System.out.println("Ended conection");

            conection.close();
        }
    }
}