package Interfaz;

import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class CuadriculaLuces extends JPanel implements MouseListener {
	
	Principal principal;
	Tablero tablero;
	boolean[][]cuadricula;
	
	public CuadriculaLuces(Principal principal) {
		
		this.principal = principal;
		setBackground(Color.PINK);
		addMouseListener(this);
		this.tablero = principal.tablero ;
		cuadricula = tablero.darTablero();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Color cutePurple = new Color(207, 159, 255);
		Color cuteYellow = new Color(255,253,141);
		
		int gridSize = Principal.gameSize/cuadricula.length;
		
		for (int i = 0; i < cuadricula.length; i++)
			for (int ii = 0; ii < cuadricula.length; ii++) {
				boolean lightOn = cuadricula[i][ii] ;
				if (lightOn) {
					 Point2D start = new Point2D.Float(ii*gridSize, i*gridSize); // Starting point of the gradient
					 Point2D end = new Point2D.Float((float)start.getX()+gridSize, (float)start.getY()+gridSize);
					 GradientPaint gradient = new GradientPaint(start, cutePurple, end, cuteYellow);
					 g2d.setPaint(gradient);
					
				} else {
					Point2D start = new Point2D.Float(ii*gridSize, i*gridSize); // Starting point of the gradient
					Point2D end = new Point2D.Float((float)start.getX()+gridSize, (float)start.getY()+gridSize);
					GradientPaint gradient = new GradientPaint(start, Color.BLACK, end, Color.WHITE);
					g2d.setPaint(gradient);
				}
				
				RoundRectangle2D.Double rectangle = new  RoundRectangle2D.Double(ii*gridSize,i*gridSize,gridSize,gridSize,20,20);
				g2d.fill(rectangle);
				g2d.draw(rectangle);
			} 
	}
	
	public void changeBoard(Tablero tablero) {
		this.tablero = tablero;
		this.cuadricula = tablero.darTablero();
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		principal.jugar(casilla[0], casilla[1]);
		repaint();
	}
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
		int ladoTablero = cuadricula.length;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero;
		int anchoCasilla = anchoPanelTablero / ladoTablero;
		int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
		return new int[] { fila, columna };
	}
	
	@Override
    public Dimension getPreferredSize() {
        // Set the preferred width and height of your panel here
        return new Dimension(Principal.gameSize, Principal.gameSize); // Replace with your desired dimensions
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
