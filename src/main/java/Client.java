import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    Scanner scanner = new Scanner(System.in);
    final String host = "netology.homework";
    final int port = 8085;
    public void run() {
        try(Socket clientSocket = new Socket(host, port)
            ; PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ; BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while(true) {
                String resp = in.readLine();
                System.out.println(resp);
                if (resp.startsWith("Welcome")) break;
                resp = scanner.next();
                out.println(resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
