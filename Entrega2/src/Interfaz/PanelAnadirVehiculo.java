package Interfaz;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAnadirVehiculo extends JPanel{
	 private JTextField[] textFields;
	 private JLabel infoLabel;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private VentanaInicio ventanaInicio;
	 
	public PanelAnadirVehiculo(JPanel cardPanel, CardLayout cardLayout) {
    	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.ventanaInicio = new VentanaInicio();
        
    	ventanaInicio.cargar_datos();
		setLayout(new BorderLayout());

	     // Title Label
	     JLabel titleLabel = new JLabel("Añadir Vehiculo");
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
	     titleLabel.setHorizontalAlignment(JLabel.CENTER);
	     add(titleLabel, BorderLayout.NORTH);

	     // Panel for text boxes and button
	     JPanel inputPanel = new JPanel(new GridLayout(11, 1));

	     // Create an array of text fields and labels
	     textFields = new JTextField[13];
	     String[] data = { "Nombre", "Marca", "Color", "Placa", "Modelo", 
	         "Tipo de Transmision", "Categoria", "Precio", "Tamaño", 
	         "Tarifa Temporada Alta","Tarifa Temporada Baja","Tarifa cambio de sede","Tarifa por conductor adicional"};
	     
	     for (int i = 0; i < data.length; i++) {
	         JLabel label = new JLabel(data[i] + ": ");
	         textFields[i] = new JTextField(8); // Smaller text fields
	         JPanel fieldPanel = new JPanel(new BorderLayout());
	         fieldPanel.add(label, BorderLayout.WEST);
	         fieldPanel.add(textFields[i], BorderLayout.CENTER);
	         inputPanel.add(fieldPanel);
	     }

	     // Button to send information with a smaller size
	     JButton sendButton = new JButton("Enviar");
	     sendButton.setPreferredSize(new Dimension(100, 30)); // Smaller button
	     sendButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             StringBuilder info = new StringBuilder();
	             
	             String nombre = (String)textFields[0].getText();
	             String marca= (String)textFields[1].getText();
	             String color =(String)textFields[2].getText();
	             String placa= (String)textFields[3].getText();
	             String modelo = (String)textFields[4].getText();
	             String tipoTrans = (String)textFields[5].getText();
	             String categoria = (String)textFields[6].getText();
	             double precio = Double.parseDouble((String)textFields[7].getText());
	             String tamaño = (String)textFields[8].getText();
	             double tarAlta = Double.parseDouble((String)textFields[9].getText());
	             double tarBaja = Double.parseDouble((String)textFields[10].getText());
	             double tarSede = Double.parseDouble((String)textFields[11].getText());
	             double tarConAd = Double.parseDouble((String)textFields[12].getText());
	             ventanaInicio.crearVehiculo(nombre, marca, placa, modelo, color, tipoTrans, tipoTrans, categoria, precio, tamaño, tarAlta, tarBaja, tarSede, tarConAd);
	             
	             infoLabel.setText(info.toString());
	             cardLayout.show(cardPanel, "panelEmpleado");
	            
	             // La lista si comienza en nombre y termina en clave
	         }
	     });
	     
	     JButton sendButton2 = new JButton("Devolverse");
	     sendButton2.setPreferredSize(new Dimension(100, 30)); // Smaller button
	     sendButton2.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 cardLayout.show(cardPanel, "panelABVehi");
	         }
	     });


	        JLabel titleLabel2 = new JLabel("    ");
	        inputPanel.add(titleLabel2);
	     
	     inputPanel.add(sendButton2);

	     
	     
	     inputPanel.add(sendButton);

	     add(inputPanel, BorderLayout.CENTER);

	     // Label to display the entered information
	     infoLabel = new JLabel("Information will be shown here");
	     infoLabel.setVerticalAlignment(SwingConstants.CENTER);
	     add(infoLabel, BorderLayout.SOUTH);
		
		
	}
}