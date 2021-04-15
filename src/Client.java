import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket conection = new Socket("127.0.0.1", 2001);
        DataInputStream input = new DataInputStream(conection.getInputStream());
        DataOutputStream output = new DataOutputStream(conection.getOutputStream());

        String line;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Type mensage: ");
            line = keyboard.readLine();
            System.out.println("Sended mensage");
            output.writeUTF(line);
            System.out.println("Waiting response");
            line = input.readUTF();
            if (line.equalsIgnoreCase("LEAVE")) {
                System.out.println("Disconected");
                break;
            }
            System.out.println(line);
        }

    }

}