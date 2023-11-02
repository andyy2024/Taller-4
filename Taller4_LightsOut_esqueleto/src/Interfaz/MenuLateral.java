package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MenuLateral extends JPanel implements ActionListener {
	
	private Principal principal;
	
	private JButton nuevo;
	
	private JButton reiniciar;
	
	private JButton top10;
	
	private JButton cambiarJugador;

	public MenuLateral(Principal principal) {
		
		this.principal = principal;
		
		setBackground(Color.PINK);
		
		//setLayout(new BorderLayout());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBorder(new EmptyBorder(10, 10, 10, 10)); //PARA PONER MARGENES
		setAlignmentY(Component.TOP_ALIGNMENT); // Set the panel to fill the available vertical space
		
		nuevo = new JButton("NUEVO");
		nuevo.setActionCommand("NUEVO");
		nuevo.addActionListener(this);
		formatButton(nuevo);
		add(nuevo);
			
		reiniciar = new JButton("REINICIAR");
		reiniciar.setActionCommand("REINICIAR");
		reiniciar.addActionListener(this);
		formatButton(reiniciar);
		add(reiniciar);
		
		top10 = new JButton("TOP-10");
		top10.setActionCommand("TOP");
		top10.addActionListener(this);
		formatButton(top10);
		add(top10);
		
		cambiarJugador = new JButton("CAMBIAR JUGADOR");
		cambiarJugador.setActionCommand("CAMBIAR");
		cambiarJugador.addActionListener(this);
		formatButton(cambiarJugador);
		add(cambiarJugador);
		
		
		add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel instruccion = new JLabel("Oprime 'Nuevo' para empezar un");
		instruccion.setFont(new Font("Arial", Font.BOLD, 12));
		instruccion.setForeground(Color.WHITE);
		add(instruccion);
		
		JLabel instruccion2 = new JLabel("nuevo juego!");
		instruccion2.setFont(new Font("Arial", Font.BOLD, 12));
		instruccion2.setForeground(Color.WHITE);
		add(instruccion2);
		
		
	}
	
	public void formatButton(JButton button) {
		//add(Box.createVerticalGlue()); 
		add(Box.createRigidArea(new Dimension(0, 10))); // Spacing between buttons
		
        Dimension preferredSize = new Dimension(200, button.getPreferredSize().height);
        button.setPreferredSize(preferredSize);
        button.setMaximumSize(preferredSize); //for some reason you need to add both for it to work haha
		
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
        Border whiteLineBorder = BorderFactory.createLineBorder(Color.WHITE, 2, true);
        button.setBorder(whiteLineBorder);
		button.setBackground(Color.PINK);
		button.setFont(new Font("Arial", Font.BOLD, 16));
		button.setForeground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if (grito.equals("CAMBIAR")) {
			principal.cambiarJugador();
			
		} else if (grito.equals("TOP")) {
			principal.mostrarTop10();
			
		} else if (grito.equals("REINICIAR")) {
			principal.reiniciar();
			
		} else if (grito.equals("NUEVO")) {
			principal.nuevo();

		}
		
	}
}
