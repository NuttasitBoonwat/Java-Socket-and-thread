import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import java.nio.channels.ServerSocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javax.swing.JFrame;

public class Server extends JFrame {
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectInputStream inStream = null;
	private static final int Chat_Width = 1000;
	private static final int Chat_Height = 600;
	
	JTextArea txt_message = new JTextArea();
	BufferedReader fromClient;
	
	Server() {
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(txt_message),BorderLayout.CENTER);
        setSize(400, 400);
        //txt_message.setFont(new Font("Tahoma", Font.PLAIN, 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        setResizable(false);
        //middle monitor
        setLocationRelativeTo(null);
        setVisible(true);
	}
	public void connect() {
			try {
				serverSocket = new ServerSocket(4445);
				socket = serverSocket.accept();
				txt_message.append("Client Connected\n");
				inStream = new ObjectInputStream(socket.getInputStream());
//				Score score = (Score) inStream.readObject();
//				System.out.println("Object received = " + score);
				fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            while (true){
	                String messageClient = fromClient.readLine();
	                txt_message.append("Message :"+messageClient+"\n");
	            }
				
			} catch (SocketException se) {
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} 
//    	}
	}
    public static void main(String[] args){
        Server game = new Server();
        game.connect();
    }
}
