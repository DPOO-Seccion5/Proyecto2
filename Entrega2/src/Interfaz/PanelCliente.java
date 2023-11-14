package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCliente extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;

	public PanelCliente(JPanel cardPanel, CardLayout cardLayout,VentanaInicio ventanaInicio) {
   	 
   	 	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
    	setLayout(new BorderLayout());

        // Title Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Cliente");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Button Panel (Center)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        // Add rigid area to push the button to the center
        buttonPanel.add(Box.createVerticalGlue());

        // Create Reserva Button
        JButton crearReservaButton = new JButton("Crear Reserva");
        Font buttonFont = crearReservaButton.getFont();
        crearReservaButton.setFont(buttonFont.deriveFont(20f));
        crearReservaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        crearReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	PanelCrearReserva panelCrearReserva= new PanelCrearReserva(cardPanel, cardLayout,ventanaInicio);
                cardPanel.add(panelCrearReserva,"panelCrearReserva");
            
                cardLayout.show(cardPanel, "panelCrearReserva");
            }
        });

        buttonPanel.add(crearReservaButton);
        
        JButton devolverseButton = new JButton("Devolverse");
        Font buttonF2 = crearReservaButton.getFont();
        devolverseButton.setFont(buttonF2.deriveFont(20f));
        devolverseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        devolverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cardLayout.show(cardPanel, "mainPanel");
            }
        });
        
        JLabel titleLabel2 = new JLabel("        ");
        buttonPanel.add(titleLabel2);
        
        
        buttonPanel.add(devolverseButton);
        
        // Add another rigid area to maintain center alignment
        buttonPanel.add(Box.createVerticalGlue());

        add(buttonPanel, BorderLayout.CENTER);
     }

   
}
