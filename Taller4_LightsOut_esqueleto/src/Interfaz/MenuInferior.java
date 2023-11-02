package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MenuInferior extends JPanel {
	
	private Principal principal;
	
	private JLabel jugadas;
	
	private JTextField jugadasInt;
	
	private JLabel jugador;
	
	private JTextField jugadorString;
	
	private String jugadorActual;
	
	public MenuInferior(Principal principal) {
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		jugadorActual = principal.jugador;
		
		setBackground(Color.PINK);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jugadas = new JLabel("Jugadas: ");
		jugadas.setFont(new Font("Arial", Font.BOLD, 16));
		jugadas.setForeground(Color.WHITE);
		add(jugadas);
		
		jugadasInt = new JTextField("NewJeans");
		jugadasInt.setBackground(Color.PINK);
		jugadasInt.setFont(new Font("Arial", Font.BOLD, 16));
		jugadasInt.setForeground(Color.WHITE);
		jugadasInt.setEditable(false);
		add(jugadasInt);
		
		add(Box.createRigidArea(new Dimension(10, 0))); // Spacing between buttons
		
		jugador = new JLabel("Jugador: ");
		jugador.setFont(new Font("Arial", Font.BOLD, 16));
		jugador.setForeground(Color.WHITE);
		add(jugador);
		
		jugadorString = new JTextField(jugadorActual);
		jugadorString.setPreferredSize(new Dimension(140, 30));
		jugadorString.setBackground(Color.PINK);
		jugadorString.setFont(new Font("Arial", Font.BOLD, 16));
		jugadorString.setForeground(Color.WHITE);
		jugadorString .setEditable(false);
		add(jugadorString);
	}
	
	public void actualizarJugador(String nombre) {
		jugadorString.setText(nombre);
	}
	
	public void actualizarJugadas(int jugadas) {
		this.jugadasInt.setText(Integer.toString(jugadas));
	}
}
