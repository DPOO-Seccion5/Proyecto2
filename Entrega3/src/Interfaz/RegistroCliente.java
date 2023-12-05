package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroCliente extends JPanel{
	 private JTextField[] textFields;
	 private JLabel infoLabel;
	 private JTextField[] textFieldsLicencia;
	 private JTextField[] textFieldsPago;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private VentanaInicio ventanaInicio;

 public RegistroCliente(JPanel cardPanel, CardLayout cardLayout) {
	 
	 this.cardPanel = cardPanel;
     this.cardLayout = cardLayout;
	 
     this.ventanaInicio = new VentanaInicio();
     
 	 ventanaInicio.cargar_datos();
     
	 setLayout(new BorderLayout());
	 

     // Title Label
     JLabel titleLabel = new JLabel("Registrese como Cliente");
     titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
     titleLabel.setHorizontalAlignment(JLabel.CENTER);
     add(titleLabel, BorderLayout.NORTH);

     // Panel for text boxes and button
     JPanel inputPanel = new JPanel(new GridLayout(11, 1));

     // Create an array of text fields and labels
     textFields = new JTextField[6];
     textFieldsLicencia= new JTextField[3];
     textFieldsPago= new JTextField[4];
     String[] data = {
         "Nombre", "Fecha de nacimiento", "Documento", "Nacionalidad", "Username",
         "Clave"};
     String[] pago = { "Numero de Tarjeta", "Fecha de Vencimiento", "CVC", "Nombre del Titular"};
     String[] licencia= {"Numero de Licencia","Pais","Fecha de Expedicion"};
     
     for (int i = 0; i < data.length; i++) {
         JLabel label = new JLabel(data[i] + ": ");
         textFields[i] = new JTextField(8); // Smaller text fields
         JPanel fieldPanel = new JPanel(new BorderLayout());
         fieldPanel.add(label, BorderLayout.WEST);
         fieldPanel.add(textFields[i], BorderLayout.CENTER);
         inputPanel.add(fieldPanel);
     }
     JLabel pagoLabel = new JLabel("Datos de Pago:");
     inputPanel.add(pagoLabel);
     
     JLabel espacioLabel = new JLabel("         ");
     inputPanel.add(espacioLabel);
     
     for (int i = 0; i < pago.length; i++) {
         JLabel label = new JLabel(pago[i] + ": ");
         textFieldsPago[i] = new JTextField(10); // Smaller text fields
         JPanel fieldPanel = new JPanel(new BorderLayout());
         fieldPanel.add(label, BorderLayout.WEST);
         fieldPanel.add(textFieldsPago[i], BorderLayout.CENTER);
         inputPanel.add(fieldPanel);
     }
     JLabel pagoLabel2 = new JLabel("Datos de Licencia:");
     inputPanel.add(pagoLabel2);
     
     JLabel espacioLabel2 = new JLabel("         ");
     inputPanel.add(espacioLabel2);
     
     for (int i = 0; i < licencia.length; i++) {
         JLabel label = new JLabel(licencia[i] + ": ");
         textFieldsLicencia[i] = new JTextField(10); // Smaller text fields
         JPanel fieldPanel = new JPanel(new BorderLayout());
         fieldPanel.add(label, BorderLayout.WEST);
         fieldPanel.add(textFieldsLicencia[i], BorderLayout.CENTER);
         inputPanel.add(fieldPanel);
     }
     
     
     
     // Button to send information with a smaller size
     JButton sendButton = new JButton("Enviar");
     sendButton.setPreferredSize(new Dimension(100, 30)); // Smaller button
     
     
     
     sendButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 String numeroTarjeta = (String)textFieldsPago[0].getText();
             String fechaVencimiento = (String)textFieldsPago[1].getText();
             String nombreTitular = (String)textFieldsPago[2].getText();
             String cvc = (String)textFieldsPago[3].getText();
             
             String nombre = (String)textFields[0].getText();
             String fechaNacimiento= (String)textFields[1].getText();
             String numID =(String)textFields[2].getText();
             String nacionalidad= (String)textFields[3].getText();
             String username = (String)textFields[4].getText();
             String password = (String)textFields[5].getText();
             
             String numeroLicencia = (String)textFieldsLicencia[0].getText();
             String paisExpedicion = (String)textFieldsLicencia[1].getText();
             
        	 ventanaInicio.registroCliente(nombre, numID, fechaNacimiento, nacionalidad, username, password, numeroLicencia, paisExpedicion, numeroTarjeta, fechaVencimiento, nombreTitular, cvc);
          	 ventanaInicio.cargar_datos();
        	 JOptionPane.showMessageDialog(null, nombre+ numID+ fechaNacimiento+ nacionalidad+ username+ password+ numeroLicencia+ paisExpedicion+ numeroTarjeta+ fechaVencimiento+ nombreTitular+ cvc);
             cardLayout.show(cardPanel, "panelIU");
         }
     });
     
     	JButton returnButton = new JButton("Devolverse");
     	Dimension buttonSize2 = new Dimension(100, 50); // Adjust the button size
     	returnButton.setPreferredSize(buttonSize2);
     	returnButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             	
             	cardLayout.show(cardPanel, "mainPanel");
             	
            
         }
     	});
     	
     
     JLabel label3 = new JLabel("             ");
     inputPanel.add(label3);
     inputPanel.add(returnButton);
     inputPanel.add(sendButton);

     add(inputPanel, BorderLayout.CENTER);

     // Label to display the entered information
     infoLabel = new JLabel("Information will be shown here");
     infoLabel.setVerticalAlignment(SwingConstants.CENTER);
     add(infoLabel, BorderLayout.SOUTH);
 }
 
}
