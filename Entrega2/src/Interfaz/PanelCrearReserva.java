package Interfaz;
import javax.swing.*;

import modelo.*;
import modelo.Cliente;
import modelo.Cobros;
import modelo.ConductorExtra;
import modelo.DatosPago;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelCrearReserva extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;

	public PanelCrearReserva(JPanel cardPanel, CardLayout cardLayout,VentanaInicio ventanaInicio) {
    	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        setLayout(new BorderLayout());

        // First Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Reserva");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
	    titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Second Panel (Center)
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1)); // Two rows and two columns
        
        
        //Temporada
        JPanel optionGroup = new JPanel();
        optionGroup.setLayout(new BoxLayout(optionGroup, BoxLayout.LINE_AXIS));
        JLabel labelComponent = new JLabel("Temporada            ");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setPreferredSize(new Dimension(20, 30));
        comboBox1.addItem("Alta");
        comboBox1.addItem("Baja");
       
        optionGroup.add(labelComponent);
        optionGroup.add(comboBox1);
        optionsPanel.add(optionGroup);
        
        //Tipo Vehiculo
        JPanel optionGroup2 = new JPanel();
        optionGroup2.setLayout(new BoxLayout(optionGroup2, BoxLayout.LINE_AXIS));
        JLabel labelComponent2 = new JLabel("Tipo de Vehiculo   ");
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.setPreferredSize(new Dimension(20, 30));
        comboBox2.addItem("suv");
        comboBox2.addItem("van");
        comboBox2.addItem("pequeño");
        comboBox2.addItem("grande");
        
        optionGroup2.add(labelComponent2);
        optionGroup2.add(comboBox2);
        optionsPanel.add(optionGroup2);
        
      //Conductor extra
        JPanel optionGroup3 = new JPanel();
        optionGroup3.setLayout(new BoxLayout(optionGroup3, BoxLayout.LINE_AXIS));
        JLabel labelComponent3 = new JLabel("Conductor extra    ");
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.setPreferredSize(new Dimension(20, 30));
        comboBox3.addItem("No");
        comboBox3.addItem("Si");
        
        optionGroup3.add(labelComponent3);
        optionGroup3.add(comboBox3);
        optionsPanel.add(optionGroup3);
        
      //Sede
        JPanel optionGroup4 = new JPanel();
        optionGroup4.setLayout(new BoxLayout(optionGroup4, BoxLayout.LINE_AXIS));
        JLabel labelComponent4 = new JLabel("Sede devolucion   ");
        JComboBox<String> comboBox4 = new JComboBox<>();
        comboBox4.setPreferredSize(new Dimension(20, 30));
        comboBox4.addItem("SedeNorte");
        comboBox4.addItem("SedeSur");
        comboBox4.addItem("SedeOriente");
        
        
        optionGroup4.add(labelComponent4);
        optionGroup4.add(comboBox4);
        optionsPanel.add(optionGroup4);
        
        add(optionsPanel, BorderLayout.CENTER);
        

        // Third Panel (South)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 String selectedSeason = (String) comboBox1.getSelectedItem();
            	 String selectedTipoVehiculo= (String) comboBox2.getSelectedItem();
            	 String selectedConductorExtra= (String) comboBox3.getSelectedItem();
            	 String selectedSede= (String) comboBox4.getSelectedItem();
            	 
            	 Cliente cliente = ventanaInicio.getCliente();
            	 DatosPago infoTar = cliente.getDatosMetodoPago();
            	 Cobros cobro = new Cobros(infoTar);
            	 String sedeRe = "SedeNorte";
            	 String fecha = "";
            	 String rangoHoras = "";
            	 ArrayList<ConductorExtra> lista = new ArrayList();
            	 if (selectedConductorExtra.equals("si"))
            	 {
            		 String numLic = "";
                	 String pais = "";
                	 String fechaLic = "";
                	 DatosLicencia licencia = new DatosLicencia(numLic,pais,fechaLic);
                	 ConductorExtra x = new ConductorExtra(licencia);
                	 lista.add(x);
            		 
            	 }
            	
  
            	 double precio = ventanaInicio.crearReserva(cliente, selectedTipoVehiculo, sedeRe, selectedSede, cobro, fecha, rangoHoras, selectedSeason, lista);
            	 
            	 PanelConfirmarReserva panelConfirResrva = new PanelConfirmarReserva(cardPanel, cardLayout,precio,selectedTipoVehiculo);
                 cardPanel.add(panelConfirResrva,"panelConfReserva");
            	 
            	 
            	
                 
                 cardLayout.show(cardPanel, "panelConfReserva");
                 
                 
            }
        });
        
        JButton returnButton = new JButton("Devolverse");
        Dimension buttonSize2 = new Dimension(100, 25); // Adjust the button size
        returnButton.setPreferredSize(buttonSize2);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                	cardLayout.show(cardPanel, "panelUsuario");
                
               
            }
        });

        buttonPanel.add(returnButton);
        
        buttonPanel.add(sendButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}