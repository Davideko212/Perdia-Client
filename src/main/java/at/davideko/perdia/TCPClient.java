package at.davideko.perdia;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TCPClient {
    Socket socket;

    public TCPClient(String host, int port) {
        try {
            this.socket = new Socket(host, port);

        } catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    public void write(byte[] text) {
        try {
            OutputStream os = socket.getOutputStream();
            os.write(text);
            //os.close();

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    public byte[] read() {
        byte[] bytes = new byte[0];

        try {
            InputStream in = socket.getInputStream();
            bytes = in.readAllBytes();
            //in.close();

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
            e.printStackTrace();
        }

        return bytes;
    }
}
