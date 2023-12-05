package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class PanelConfirmarReserva extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;
	private VentanaInicio ventanaInicio;

	public PanelConfirmarReserva(JPanel cardPanel, CardLayout cardLayout, double precio,String categoria, boolean appCliente) {
   	 
   	 	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.ventanaInicio = new VentanaInicio();
        if(appCliente == true) {
        Double descuento = precio*0.1;
        precio=precio-descuento;}
        
        ventanaInicio.cargar_datos();
        
        String nombreCarro = ventanaInicio.nombreCarro(categoria);
        
        setLayout(new BorderLayout());

        // First Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Confirmar Reserva");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Second Panel (Center)
        JPanel infoPanel = new JPanel(new GridLayout(2, 1)); // Two rows and two columns

        // Labels and Text Fields
        JLabel label1 = new JLabel("                     Precio:");
        JTextField textField1 = new JTextField(20);
        textField1.setText(String.valueOf(precio));
        textField1.setEditable(false); // Make the text field uneditable
        textField1.setPreferredSize(new Dimension(200, 25)); // Set a fixed size for the text field

        // Customize the text field's appearance
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.WHITE);

        JLabel label2 = new JLabel("                     Vehiculo:");
        JTextField textField2 = new JTextField(20);
        textField2.setText(nombreCarro);
        textField2.setEditable(false); // Make the text field uneditable
        textField2.setPreferredSize(new Dimension(100, 25)); // Set a fixed size for the text field

        // Customize the text field's appearance
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);

        infoPanel.add(label1);
        infoPanel.add(textField1);
        infoPanel.add(label2);
        infoPanel.add(textField2);

        add(infoPanel, BorderLayout.CENTER);

        // Third Panel (South)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Reserva creada exitosamente!");
            	ventanaInicio.cargar_datos();
            	cardLayout.show(cardPanel, "panelUsuario");
            }
        });
        
        JButton returnButton = new JButton("Devolverse");
        Dimension buttonSize2 = new Dimension(100, 25); // Adjust the button size
        returnButton.setPreferredSize(buttonSize2);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                	cardLayout.show(cardPanel, "panelCrearReserva");
                
               
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
