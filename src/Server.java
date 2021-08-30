import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //Trin 1: Lav Server Socket
            ServerSocket serverSocket = new ServerSocket(10002);

            //Trin 2: Få en socket til at lytte på den specifikke port
            System.out.println("Accepting connection on port 1998...");
            Socket socket = serverSocket.accept();
            System.out.println("Connection established" + socket.getRemoteSocketAddress().toString());

            //Trin 3: Streams op og ned
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            //Trin 4: Her kan vi sende og modtage data
            String incomingText = inputStream.readUTF();
            System.out.println("Teksten modtaget: " + incomingText);
            outputStream.writeUTF("Tak for teksten, det er modtaget :)" + incomingText);
            outputStream.flush();

            //Trin 5: Luk forbindelsen
                //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
