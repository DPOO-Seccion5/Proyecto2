package Interfaz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistroEmpleado extends JPanel{
	 private JTextField[] textFields;
	 private JLabel infoLabel;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private VentanaInicio ventanaInicio;
	 
	public PanelRegistroEmpleado(JPanel cardPanel, CardLayout cardLayout) {
    	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.ventanaInicio = new VentanaInicio();
        
    	 ventanaInicio.cargar_datos();
		setLayout(new BorderLayout());

	     // Title Label
	     JLabel titleLabel = new JLabel("Registrese como Empleado");
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
	     titleLabel.setHorizontalAlignment(JLabel.CENTER);
	     add(titleLabel, BorderLayout.NORTH);

	     // Panel for text boxes and button
	     JPanel inputPanel = new JPanel(new GridLayout(6, 1));

	     // Create an array of text fields and labels
	     textFields = new JTextField[10];
	     String[] data = {
	         "Nombre", "Fecha de nacimiento", "Documento", "Nacionalidad", "Username",
	         "Clave"};
	     
	     for (int i = 0; i < data.length; i++) {
	         JLabel label = new JLabel(data[i] + ": ");
	         textFields[i] = new JTextField(8); // Smaller text fields
	         JPanel fieldPanel = new JPanel(new BorderLayout());
	         fieldPanel.add(label, BorderLayout.WEST);
	         fieldPanel.add(textFields[i], BorderLayout.CENTER);
	         inputPanel.add(fieldPanel);
	     }
	     add(inputPanel, BorderLayout.CENTER);
	     // Button to send information 
	     
	     JPanel buttonPanel = new JPanel();
	     buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	     
	     JButton sendButton = new JButton("Enviar");
	     sendButton.setPreferredSize(new Dimension(100, 50)); // Smaller button
	     sendButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             StringBuilder info = new StringBuilder();
	            
	             String nombre = (String)textFields[0].getText();
	             String fechaNacimiento= (String)textFields[1].getText();
	             String numID =(String)textFields[2].getText();
	             String nacionalidad= (String)textFields[3].getText();
	             String username = (String)textFields[4].getText();
	             String password = (String)textFields[5].getText();
	             
	             ventanaInicio.registroEmpleado(nombre, username, password, numID, nacionalidad, fechaNacimiento);
	             cardLayout.show(cardPanel, "panelIU");
	             // La lista si comienza en nombre y termina en clave
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

	     buttonPanel.add(returnButton);
	     buttonPanel.add(sendButton);

	     add(buttonPanel, BorderLayout.SOUTH);


		
	}
}
