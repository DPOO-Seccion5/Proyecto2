package AppClientes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import Interfaz.VentanaInicio;

public class PanelMostrarDisp extends JPanel{
	private JPanel cardPanel;
	 private CardLayout cardLayout;
	public PanelMostrarDisp(JPanel cardPanel, CardLayout cardLayout,VentanaInicio ventanaInicio, String sede) {
		this.cardPanel = cardPanel;
	     this.cardLayout = cardLayout;
	     
	     ArrayList<String> vehiculos = ventanaInicio.VehiDisponibles(sede);
	     System.out.println(vehiculos);
	     
	     //Titulo
	     setLayout(new BorderLayout());
	     JPanel titlePanel = new JPanel();
	     titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	     JLabel titleLabel = new JLabel("Vehiculos disponibles en "+sede);
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		 titleLabel.setHorizontalAlignment(JLabel.CENTER);
	     titlePanel.add(titleLabel);
	     add(titlePanel, BorderLayout.NORTH);
	     
	     
	     if (vehiculos.isEmpty()) {
	            JLabel emptyLabel = new JLabel("No hay vehículos disponibles.");
	            emptyLabel.setFont(new Font("Arial", Font.BOLD, 16));
	            emptyLabel.setHorizontalAlignment(JLabel.CENTER);
	            add(emptyLabel, BorderLayout.CENTER);
	        } 
	     else {
	     DefaultListModel<String> listModel = new DefaultListModel<>();
	        for (String vehiculo : vehiculos) {
	            listModel.addElement(vehiculo);
	        }

	        JList<String> vehiculosList = new JList<>(listModel);
	        vehiculosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        JScrollPane scrollPane = new JScrollPane(vehiculosList);
	        

	        // Add the scroll pane to the center of the panel
	        add(scrollPane, BorderLayout.CENTER);
	     }
	        
	     // Button panel
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	        JButton returnButton = new JButton("Devolverse");
	        returnButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	cardLayout.show(cardPanel, "panelUsuario");
	            }
	        });

	        
	        buttonPanel.add(returnButton);

	        // Add the button panel to the south of the panel
	        add(buttonPanel, BorderLayout.SOUTH);
	     
	     
		
		
	}

}
