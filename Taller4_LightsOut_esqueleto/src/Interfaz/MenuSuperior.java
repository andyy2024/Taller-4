package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.metal.MetalRadioButtonUI;

public class MenuSuperior extends JPanel implements ActionListener {
	
	Principal principal;
	
	private JLabel tamaño;
	private JComboBox<String> tamaños;
	
	private JLabel dificultad;
	
	private JLabel facilLabel;
	private JRadioButton facilButton;
	
	private JLabel medioLabel;
	private JRadioButton medioButton;
	
	private JLabel dificilLabel;
	private JRadioButton dificilButton;

	
	public MenuSuperior(Principal principal) {
		
		this.principal = principal;
		
		setBackground(Color.PINK);
		
		setForeground(Color.PINK);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		tamaño = new JLabel("Tamaño: ");
		formatLabel(tamaño);
		add(tamaño);
			
		tamaños = new JComboBox<>();
		tamaños.addItem("5x5");
		tamaños.addItem("7x7");
		tamaños.addItem("10x10");
		tamaños.setActionCommand("NEWSIZE");
		tamaños.addActionListener(this);
		
		Color cuteYellow = new Color(255,253,141);
        Color cutePurple = new Color(207, 159, 255);
//		tamaños.setBackground(cuteYellow);
//		tamaños.setForeground(cuteYellow);
		Border whiteLineBorder = BorderFactory.createLineBorder(Color.WHITE, 2, true);
		tamaños.setBorder(whiteLineBorder);
		tamaños.setRenderer(new DefaultListCellRenderer() {
        	@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {                    
        		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
        		
                Color cuteYellow = new Color(255,253,141);
                Color cutePurple = new Color(207, 159, 255);
                
                if (index % 2 == 0) {
                    label.setBackground(cuteYellow); 
                } else {
                    label.setBackground(cutePurple); 
                }
                
                setFont(new Font("Arial", Font.BOLD, 14));
                setForeground(Color.WHITE);

                setBorder(new EmptyBorder(5, 5, 5, 5));

                return this;
            }
        });
		
		tamaños.setUI(new BasicComboBoxUI() {
			@Override
		    protected JButton createArrowButton() {
		        JButton arrowButton = super.createArrowButton();
		        arrowButton.setIcon(new ImageIcon("./data/flechita.png")); // Replace with your custom icon
		        arrowButton.setBackground(Color.WHITE); // Set the background color of the arrow button

		        return arrowButton;	
		}});
		add(tamaños);
		
		
		add(Box.createRigidArea(new Dimension(10, 0)));
		
		dificultad = new JLabel("Dificultad: ");
		formatLabel(dificultad);
		add(dificultad);
		
		facilButton = new JRadioButton();
		facilButton.setActionCommand("FACIL");
		facilButton.addActionListener(this);
		formatButton(facilButton);
		add(facilButton);
		facilButton.setSelected(true); //por defecto debe estar facil la dificultad
		facilLabel = new JLabel("Facil");
		formatLabel(facilLabel);
		add(facilLabel);
		
		medioButton = new JRadioButton();
		medioButton.setActionCommand("MEDIO");
		medioButton.addActionListener(this);
		formatButton(medioButton);
		add(medioButton);
		medioLabel = new JLabel("Medio");
		formatLabel(medioLabel);
		add(medioLabel);
		
		dificilButton = new JRadioButton();
		dificilButton.setActionCommand("DIFICIL");
		dificilButton.addActionListener(this);
		formatButton(dificilButton);
		add(dificilButton);
		dificilLabel = new JLabel("Dificil");
		formatLabel(dificilLabel);
		add(dificilLabel);
		
		ButtonGroup group = new ButtonGroup();
        group.add(facilButton);
        group.add(medioButton);
        group.add(dificilButton);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if (grito.equals("FACIL")) {
			principal.setDificultad(Principal.FACIL);
			
		} else if (grito.equals("MEDIO")) {
			principal.setDificultad(Principal.MEDIO);
			
		} else if (grito.equals("DIFICIL")) {
			principal.setDificultad(Principal.DIFICIL);
			
		} else if (grito.equals("NEWSIZE")) {
			String size = (String) tamaños.getSelectedItem();
			
			if (size.equals("5x5")) {
				principal.setBoardSize(5);
				
			} else if (size.equals("7x7")) {
				principal.setBoardSize(7);
				
			} else if (size.equals("10x10")) {
				principal.setBoardSize(10);
			}
			
		} 
		
	}
	
	public void formatButton(JRadioButton button) {
		
		button.setForeground(Color.BLUE);
		button.setBackground(Color.PINK);
	}
	
public void formatLabel(JLabel label) {
		
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setForeground(Color.WHITE);
	}

	

}
