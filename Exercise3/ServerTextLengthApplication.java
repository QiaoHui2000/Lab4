package TCPclientTextLength;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author qiaohui
 *
 */

public class ServerTextLengthApplication {

public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerTextLengthFrame serverFrame = new ServerTextLengthFrame();
		serverFrame.setVisible(true);
		
		// Bind to a port
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		TextLengthCounter textLengthCounter  = new TextLengthCounter ();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Count text length
			String text = "The connection is suscessfull";
			int textLength = textLengthCounter.getTextLength(text);
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current date back to the client
			outputStream.writeInt(textLength);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + textLength);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
}
}
