package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEmpleado extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;

	public PanelEmpleado(JPanel cardPanel, CardLayout cardLayout) {
   	 
   	 	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
    	setLayout(new BorderLayout());

        // Title Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Empleado");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Button Panel (Center)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        // Add rigid area to push the button to the center
        buttonPanel.add(Box.createVerticalGlue());

        // Create Buscar Vehiculo
        JButton crearReservaButton = new JButton("Buscar Vehiculo");
        Font buttonFont = crearReservaButton.getFont();
        crearReservaButton.setFont(buttonFont.deriveFont(20f));
        crearReservaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        crearReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	
            	cardLayout.show(cardPanel, "panelBuscarVehi");
            }
        });
        
        JButton returnButton = new JButton("Devolverse");
        Font buttonFont3 = returnButton.getFont();
        returnButton.setFont(buttonFont3.deriveFont(20f));
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                	cardLayout.show(cardPanel, "mainPanel");
                
               
            }
        });

        
        
        buttonPanel.add(crearReservaButton);
        
        JLabel titleLabel2 = new JLabel("    ");
        buttonPanel.add(titleLabel2);
        
     //  Create Añadir/Borrar Vehiculo
        JButton anadiryretirarcarrosbtn = new JButton("Añadir/Borrar Vehiculo");
        Font buttonFont2 = anadiryretirarcarrosbtn.getFont();
        anadiryretirarcarrosbtn.setFont(buttonFont.deriveFont(20f));
        anadiryretirarcarrosbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        anadiryretirarcarrosbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	
            	cardLayout.show(cardPanel, "panelABVehi");
            }
        });
        
        buttonPanel.add(anadiryretirarcarrosbtn);
        JLabel titleLabel3 = new JLabel("    ");
        buttonPanel.add(titleLabel3);
        buttonPanel.add(returnButton);
        // Add another rigid area to maintain center alignment
        buttonPanel.add(Box.createVerticalGlue());

        add(buttonPanel, BorderLayout.CENTER);
     }

   
}