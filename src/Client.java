import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.200.130.20", 1972);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());


            while (true) {
                Scanner scanner = new Scanner(System.in);
                outputStream.writeUTF(scanner.nextLine());
                outputStream.flush();
                System.out.println(inputStream.readUTF());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
