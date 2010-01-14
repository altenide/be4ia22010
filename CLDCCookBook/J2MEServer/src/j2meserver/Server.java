/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package j2meserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernestoexposito
 */
public class Server extends Thread {

    private String address;
    private int port;
    private ServerSocket ss;

    public Server(String address, int port) throws IOException {
        setAddress(address);
        setPort(port);
        ss = new ServerSocket(port, 10, InetAddress.getByName(address));
        this.start();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("server waiting");
                new SessionManager(ss.accept());
                System.out.println("new cliente!");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server("localhost", 10000);
    }
}
