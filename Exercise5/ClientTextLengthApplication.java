package TCPclientTextLength;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author qiaohui
 *
 */

public class ClientTextLengthApplication {
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientTextLengthFrame clientTextLengthFrame = new ClientTextLengthFrame();
		clientTextLengthFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientTextLengthFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		// Display the word length
		int textLength = dis.readInt();
		clientTextLengthFrame.readTextLength(textLength);
		
		// Close all
		dis.close();
		socket.close();

	}
}
