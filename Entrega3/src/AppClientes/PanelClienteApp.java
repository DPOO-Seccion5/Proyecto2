package AppClientes;

import javax.swing.*;

import Interfaz.PanelCrearReserva;
import Interfaz.VentanaInicio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelClienteApp extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;

	public PanelClienteApp(JPanel cardPanel, CardLayout cardLayout,VentanaInicio ventanaInicio,boolean appCliente) {
   	 
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
            	PanelCrearReserva panelCrearReserva= new PanelCrearReserva(cardPanel, cardLayout,ventanaInicio, appCliente);
                cardPanel.add(panelCrearReserva,"panelCrearReserva");
            
                cardLayout.show(cardPanel, "panelCrearReserva");
            }
        });

        buttonPanel.add(crearReservaButton);
        
        JLabel titleLabel3 = new JLabel("        ");
        buttonPanel.add(titleLabel3);
        
        JButton consultarDispBtn = new JButton("Consultar Disponibilidad");
        Font buttonFont3 = crearReservaButton.getFont();
        consultarDispBtn.setFont(buttonFont3.deriveFont(20f));
        consultarDispBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultarDispBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelConsultarDispApp consultPanel = new PanelConsultarDispApp(cardPanel, cardLayout,ventanaInicio);
                cardPanel.add(consultPanel,"consultarDisp");
                cardLayout.show(cardPanel, "consultarDisp");
            }
        });
        buttonPanel.add(consultarDispBtn);
        
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
