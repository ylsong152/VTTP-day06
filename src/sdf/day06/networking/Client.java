package sdf.day06.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        // Connection
        System.out.println("Connecting to 127.0.0.1 on port " + Server.PORT);
        Socket socket = new Socket("localhost", 3000);

        System.out.println("Connected to server");
        
        Console cons = System.console();
        String line = cons.readLine("Please enter a message: ");
        
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(line + "\n");
        bw.flush();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        line = br.readLine();
        System.out.printf("Server response: %s\n", line);

        socket.close();
        System.out.println("Socket closed");
    }
}
