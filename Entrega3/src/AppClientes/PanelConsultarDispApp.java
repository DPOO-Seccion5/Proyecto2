package AppClientes;
import javax.swing.*;

import Interfaz.VentanaInicio;
import modelo.*;
import modelo.Cliente;
import modelo.Cobros;
import modelo.ConductorExtra;
import modelo.DatosPago;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelConsultarDispApp extends JPanel {
	 private JPanel cardPanel;
	 private CardLayout cardLayout;
	 
	 public PanelConsultarDispApp(JPanel cardPanel, CardLayout cardLayout,VentanaInicio ventanaInicio) {
		 this.cardPanel = cardPanel;
	     this.cardLayout = cardLayout;
	     //Titulo
	     setLayout(new BorderLayout());
	     JPanel titlePanel = new JPanel();
	     titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	     JLabel titleLabel = new JLabel("Consulta Vehiculos por Sede");
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		 titleLabel.setHorizontalAlignment(JLabel.CENTER);
	     titlePanel.add(titleLabel);
	     
	     
	     
	     add(titlePanel, BorderLayout.NORTH);
	     
	     
	     //ElegirSede
	     JPanel optionsPanel = new JPanel(new GridLayout(3, 1)); // Two rows and two columns
	        
	     //Sede 
	     JPanel optionGroup4 = new JPanel();
	        optionGroup4.setLayout(new BoxLayout(optionGroup4, BoxLayout.LINE_AXIS));
	        JLabel labelComponent4 = new JLabel("Sede:   ");
	        JComboBox<String> comboBox4 = new JComboBox<>();
	        comboBox4.setPreferredSize(new Dimension(20, 30));
	        comboBox4.addItem("SedeNorte");
	        comboBox4.addItem("SedeSur");
	        comboBox4.addItem("SedeOriente");
	        
	        
	        optionGroup4.add(labelComponent4);
	        optionGroup4.add(comboBox4);
	        optionsPanel.add(optionGroup4);
	        
	        //Fechas
	        JTextField usernameField = new JTextField(15);
	        JPanel usernamePanel = new JPanel();
	        usernamePanel.add(new JLabel("Fecha de Recogida : "));
	        usernamePanel.add(usernameField);
	        optionsPanel.add(usernamePanel);
	        JTextField fecha2Field = new JTextField(15);
	        JPanel fecha2Panel = new JPanel();
	        fecha2Panel.add(new JLabel("Fecha de devolucion : "));
	        fecha2Panel.add(fecha2Field);
	        optionsPanel.add(fecha2Panel);
	        
	        
	        add(optionsPanel, BorderLayout.CENTER);
	        
	        // Third Panel (South)
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	        JButton sendButton = new JButton("Enviar");
	        buttonPanel.add(sendButton);
	        sendButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String sede = (String) comboBox4.getSelectedItem();
					String fechaRec = usernameField.getText();
					String fechaDev = fecha2Field.getText();
					JOptionPane.showMessageDialog(null, sede+","+fechaRec+","+fechaDev);
					PanelMostrarDisp mostDispPanel = new PanelMostrarDisp(cardPanel, cardLayout,ventanaInicio,sede);
	                cardPanel.add(mostDispPanel,"mostDisp");
	                cardLayout.show(cardPanel, "mostDisp");
				} });
	        add(buttonPanel,BorderLayout.SOUTH);

	 }
	 
}
