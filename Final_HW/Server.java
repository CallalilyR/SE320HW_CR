 import java.io.*;
 import java.net.*;
 import java.util.*;
 import java.awt.*;
 import javax.swing.*;
 
 public class Server extends JFrame {
   // Text area for displaying contents
   private JTextArea jta = new JTextArea();
 
   public static void main(String[] args) {
     new Server();
   }
 
   public Server() {
     // Place text area on the frame
     getContentPane().setLayout(new BorderLayout());
     getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);
 
     setTitle("Server");
     setSize(500, 300);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true); // It is necessary to show the frame here!
 
     try {
       // Create a server socket
       ServerSocket serverSocket = new ServerSocket(8000);
       jta.append("Server started at " + new Date() + '\n');
 
       // Listen for a connection request
       Socket socket = serverSocket.accept();
 
       // Create data input and output streams
       DataInputStream inputFromClient = new DataInputStream(
         socket.getInputStream());
       DataOutputStream outputToClient = new DataOutputStream(
         socket.getOutputStream());
 
       while (true) {
         // Receive weight from the client
         double weightInKilograms = inputFromClient.readDouble();

         // Receive height from the client
         double heightInMeters = inputFromClient.readDouble();
 
         // Compute area
         double bmi = weightInKilograms / (heightInMeters * heightInMeters);
 
         // Send area back to the client
         outputToClient.writeDouble(bmi);
 
         jta.append("weight received from client: " + weightInKilograms + '\n');
         jta.append("height received from client: " + heightInMeters + '\n');
         jta.append("bmi found: " + bmi + '\n');
       }
     }
     catch(IOException ex) {
       System.err.println(ex);
     }
   }
 }