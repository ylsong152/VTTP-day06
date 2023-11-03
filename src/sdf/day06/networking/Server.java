package sdf.day06.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static final int PORT = 3000;
    
    public static void main(String[] args) throws Exception {
        // Create server and bind to port 3000
        System.out.printf("Listening on port %d...\n", PORT);
        ServerSocket server = new ServerSocket(PORT);

        //Wait for client connection to arrive
        while (true) {
            System.out.println("Waiting for client connection");
            Socket client = server.accept();

            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            String line = br.readLine();
            System.out.printf("Got a message: %s\n", line);
            line = line.toUpperCase();

            OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            // Add \n to flush the line
            bw.write(line + "\n");

            bw.flush();
            is.close();
            os.close();
            
            System.out.printf("Got a client connection: %d\n", client.getLocalPort());
        }
            
        //server.close();
    }
}
