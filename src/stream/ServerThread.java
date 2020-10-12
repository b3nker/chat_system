
/***
 * ClientThread
 * Example of a TCP server
 * Date: 14/12/08
 * Authors:
 */

package stream;

import java.io.*;
import java.net.*;

public class ServerThread
        extends Thread {

    private ServerSocket listenerSocket;
    private int port;

    ServerThread(int p) {
        this.port = p;
    }

    /**
     * receives a request from client then accepts the connection

     **/
    @Override
    public void run() {
        try {
            while(true) {
                listenerSocket = new ServerSocket(port);
                Socket client = listenerSocket.accept();
                new ClientThread(client).start();
            }

        } catch (Exception e) {
            System.err.println("Error in ServerThread:" + e);
        }
    }

}





