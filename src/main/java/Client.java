import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    final String host = "localhost";
    final int port = 8085;
    public void run() {
        try(Socket clientSocket = new Socket(host, port)
            ; PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ; BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("UserName");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
