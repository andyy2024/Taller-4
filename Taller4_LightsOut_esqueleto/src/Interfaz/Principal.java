package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class Principal extends JFrame implements EventListener {

	MenuSuperior menuSuperior;
	
	MenuInferior menuInferior;
	
	MenuLateral menuLateral;
	
	CuadriculaLuces cuadriculaLuces;
	
	VentanaTop10 ventanaTop10;
	
	VentanaCambiarJugador ventanaCambiarJugador;
	
	VentanaGanaste ventanaGanaste;
	
	Tablero tablero;
	
	String jugador;
	
	int dificultad;
	
	boolean jugando;
	
	public static final int FACIL = 1;
	
	public static final int MEDIO = 4;
	
	public static final int DIFICIL = 5;
	
	public static final int gameSize = 550;
	
	public static final Top10 top10 = new Top10();
	
	public Principal() {
		
		jugando = false;
		dificultad = FACIL; //facil
		jugador = "hanni";
		tablero = new Tablero(5);
		cuadriculaLuces = new CuadriculaLuces(this);
		menuSuperior = new MenuSuperior(this);
		menuInferior = new MenuInferior(this);
		menuLateral = new MenuLateral(this);
		
		setTitle("LIGHTS OUT");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
        BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File("./data/logo.png"));
			Image image = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH) ;
			setIconImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		
		add(menuSuperior,BorderLayout.NORTH);
		add(cuadriculaLuces,BorderLayout.CENTER);
		add(menuLateral,BorderLayout.EAST);
		add(menuInferior,BorderLayout.SOUTH);
		
		pack();
		
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 3;

        setLocation(x, y);
		
		setVisible(true);
		
	}
	
	public void jugar(int fila, int columna) {
		tablero.jugar(fila, columna);
		menuInferior.actualizarJugadas(tablero.darJugadas());
		
		if (jugando) {
			if (tablero.tableroIluminado()) {
				 top10.agregarRegistro(jugador, tablero.calcularPuntaje());
				 cuadriculaLuces.repaint();
				 ventanaGanaste = new VentanaGanaste(this);
				 setBoardSize(tablero.darTablero().length);
			 }
		}
		 
	}
	
	public void mostrarTop10() {
		ventanaTop10 = new VentanaTop10(this);
	}

	public void reiniciar() {
		menuInferior.actualizarJugadas(0);
		tablero.reiniciar();
		cuadriculaLuces.repaint();
	}
	
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad; 
	}

	public void nuevo() {
		
		menuInferior.actualizarJugadas(0);
		jugando = true;
		Tablero newTablero = new Tablero(tablero.darTablero().length);
		this.tablero = newTablero;
		cuadriculaLuces.changeBoard(newTablero);
		tablero.desordenar(dificultad);
		tablero.salvar_tablero();
		cuadriculaLuces.repaint();
	}

	public void cambiarJugador() {
		ventanaCambiarJugador = new VentanaCambiarJugador(this);
		jugador = ventanaCambiarJugador.nombre;
		menuInferior.actualizarJugador(jugador);
	}

	public void setBoardSize(int size) {
			menuInferior.actualizarJugadas(0);
			jugando = false;
			Tablero newTablero = new Tablero(size);
			this.tablero = newTablero;
			cuadriculaLuces.changeBoard(newTablero);
			cuadriculaLuces.repaint();
	}
	
	public static void main(String[] args) {
		
		Principal principal = new Principal();
		
//		int panelWidth = cuadriculaLuces.getWidth();
//		int panelHeight = cuadriculaLuces.getHeight();
//		System.out.println("Panel width: " + panelWidth);
//		System.out.println("Panel height: " + panelHeight);
	}
	
}
