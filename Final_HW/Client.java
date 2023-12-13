 import java.io.*;
 import java.net.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 public class Client extends JFrame implements ActionListener {
  // Text fields for receiving weight and height
  private JTextField weightTextField = new JTextField();
  private JTextField heightTextField = new JTextField();
  
 
   // Text area to display contents
   private JTextArea jta = new JTextArea();
 
   // IO streams
   private DataOutputStream outputToServer;
   private DataInputStream inputFromServer;
 
   public static void main(String[] args) {
     new Client();
   }
 
   public Client() {
     // Panel p to hold the labels and text fields
     JPanel p = new JPanel(new GridLayout(2, 2)); // 2 rows, 2 columns
     p.add(new JLabel("Enter weight in kilograms:"));
     p.add(weightTextField);
     p.add(new JLabel("Enter height in meters:"));
     p.add(heightTextField);

     getContentPane().setLayout(new BorderLayout());
     getContentPane().add(p, BorderLayout.NORTH);
     getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

     // Register listener for both text fields
     weightTextField.addActionListener(this);
     heightTextField.addActionListener(this);

     setTitle("Client");
     setSize(500, 300);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);

 
     try {
       // Create a socket to connect to the server
       Socket socket = new Socket("localhost", 8000);
       // Socket socket = new Socket("130.254.204.36", 8000);
       // Socket socket = new Socket("drake.Armstrong.edu", 8000);
 
       // Create an input stream to receive data from the server
       inputFromServer = new DataInputStream(
         socket.getInputStream());
 
       // Create an output stream to send data to the server
       outputToServer =
         new DataOutputStream(socket.getOutputStream());
     }
     catch (IOException ex) {
       jta.append(ex.toString() + '\n');
     }
   }
 
   public void actionPerformed(ActionEvent e) {
     String actionCommand = e.getActionCommand();
     if (e.getSource() instanceof JTextField) {
       try {
         // Get the weight and height from the text field
         double weightInKilograms = Double.parseDouble(weightTextField.getText().trim());
         double heightInMeters = Double.parseDouble(heightTextField.getText().trim());

 
         // Send the bmi to the server
         outputToServer.writeDouble(weightInKilograms);
         outputToServer.writeDouble(heightInMeters);
         outputToServer.flush();
 
         // Get bmi from the server
         double bmi = inputFromServer.readDouble();
 

         // Display to the text area
         jta.append("Weight is " + weightInKilograms + "Kg" + "\n");
         jta.append("Height is " + heightInMeters + " Meters" + "\n");
         jta.append("BMI received from the server is " + bmi + "\n");
       }


       catch (NumberFormatException | IOException ex) {
         System.err.println(ex);
       } finally {
        try {
            // Close resources in the finally block
            if (outputToServer != null) outputToServer.close();
            if (inputFromServer != null) inputFromServer.close();
            // Note: Consider closing the socket as well if it's not needed anymore
        } catch (IOException ex) {
            System.err.println(ex);
        }
         }
     }
   }
 }