package AppClientes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Interfaz.PanelIncioSesionUsuario;
import Interfaz.RegistroCliente;
import consola.Consola;
import modelo.Cliente;
import procesamiento.Compañia;

public class VentanaInicioApp extends JFrame{
	private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private Consola consola;
    private Compañia compania;
    private ArrayList infoVehiculo;
    private Cliente cliente;
    
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> createAndShowGUI());

	}
	
	
	
	
	private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        Boolean appCliente = true;
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        JPanel mainPanel = createMainPanel();
        cardPanel.add(mainPanel, "mainPanel");
        
        RegistroCliente registroCliente = new RegistroCliente(cardPanel, cardLayout);
        cardPanel.add(registroCliente, "panelRegCli");
        
        PanelIncioSesionUsuario panelIU = new PanelIncioSesionUsuario(cardPanel, cardLayout,appCliente);
        cardPanel.add(panelIU, "panelIU");
        
        
        
        frame.add(cardPanel);
        
        
        frame.setVisible(true);
        
        
	}
	private static JPanel createMainPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());

	    // Create a big title label centered at the top
	    JLabel titleLabel = new JLabel("App Usuarios");
	    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	    titleLabel.setHorizontalAlignment(JLabel.CENTER);
	    mainPanel.add(titleLabel, BorderLayout.NORTH);
	    
 // Create a button panel with Button 1 and Button 2
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton button1 = new JButton("Inicio Sesion");
        JButton button2 = new JButton("Registro Cliente");
       

        // Set the preferred size for the buttons
        Dimension buttonSize = new Dimension(200,30);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        
        button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "panelIU");
				
			}});
        
        button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "panelRegCli");
				
			}});
        buttonPanel.add(button1);

       
        buttonPanel.add(button2);

       
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
		return mainPanel;
	}
	
	
	
}
