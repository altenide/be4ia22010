/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package j2meserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;

/**
 *
 * @author ernestoexposito
 */
public class SessionManager extends Thread {

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public SessionManager(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream (socket.getInputStream());
        output = new DataOutputStream (socket.getOutputStream());
        this.start();
    }

    @Override
    public void run() {
        // while (true) {
        try {
            DOMGenerator d = DOMGenerator.createDocument();
            System.out.println("sending...");
            d.setRoot("Toto");
            Element e = d.createElement("memory", new String[][]{{"max", "8MB"}, {"current", "3MB"}});
            d.addElement(e);
            byte[] b = d.toString().getBytes();
            output.writeInt(b.length);
            output.flush();
            output.write(b);
            output.flush();
            System.out.println(d.toString());
            int l = input.readInt();
            b = new byte[l];
            System.out.println("receiving...");
            input.read(b);
            System.out.println("finished-bytes:"+b.length);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);

        }
        // }
        try {

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}







