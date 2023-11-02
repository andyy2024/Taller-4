package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VentanaGanaste extends JDialog {
	
    public VentanaGanaste(Principal principal) {
        super(principal, "uwu", true);
        
        setSize(300, 100);
        
        setResizable(false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 3;

        setLocation(x, y);
        
        Color cuteYellow = new Color(255,253,141);
        Color cutePurple = new Color(207, 159, 255);
        
    	JPanel panel = new JPanel();
        panel.setBackground(cutePurple);
        
        JLabel label1 = new JLabel("GANASTE!!");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
       
        JButton button = new JButton("Aceptar");
        
        Border whiteLineBorder = BorderFactory.createLineBorder(Color.WHITE, 2, true);
        button.setBorder(whiteLineBorder);
		button.setBackground(Color.PINK);
		button.setFont(new Font("Arial", Font.BOLD, 16));
		button.setForeground(Color.WHITE);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose(); 
            }
        });

        add(button, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    
}
