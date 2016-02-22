package tcp;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriquiAppServer {

    ServerSocket ss = null;
    Socket c = null;
    int port = 0;

    public TriquiAppServer() {
        init(5555);
    }

    public TriquiAppServer(int port) {
        init(port);
    }

    private void init(int port) {
        try {
            this.port = port;
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(TriquiAppServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        TriquiTCPserver tss = null;
        System.out.println("TriquiServer.run().listening..." + port);
        while (true) {
            try {
                c = ss.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            tss = new TriquiTCPserver(c);
            tss.run();
        }
    }

    public static void main(String[] args) {
        TriquiAppServer ts = null;
        if (args.length < 1)
            ts = new TriquiAppServer();
        else
            ts = new TriquiAppServer(Integer.parseInt(args[0]));
        ts.run();
    }
}