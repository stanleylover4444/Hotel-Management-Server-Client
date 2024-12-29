package socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

public class SocketServer {
    private ServerSocket serverSocket;
    private ListeningThread listeningThread;

    public SocketServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            listeningThread = new ListeningThread(this, serverSocket);
            listeningThread.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    /*
     * Ready for use.
     */
    @SuppressWarnings({ "removal", "deprecation" })
	public void close() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                listeningThread.stopRunning();
                listeningThread.suspend();
                listeningThread.stop();

                serverSocket.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Vector<ConnectionThread> getConnections() {
        return listeningThread.getConnections();
    }
}