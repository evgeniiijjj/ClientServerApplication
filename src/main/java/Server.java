import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Thread(new Client()).start();
        try (ServerSocket serverSocket = new ServerSocket(8085)
             ; Socket clientSocket = serverSocket.accept()
             ; PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
             ; BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted");
            out.println("Write your name");
            final String name = in.readLine();
            out.println("Are you child?");
            String resp = in.readLine();
            if (resp.equalsIgnoreCase("yes"))
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            if (resp.equalsIgnoreCase("no"))
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
