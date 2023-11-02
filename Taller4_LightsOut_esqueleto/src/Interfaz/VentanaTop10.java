package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaTop10 extends JDialog {
	
    public VentanaTop10(Principal principal) {
    	super(principal, "TOP 10", true);
    	
        setSize(300, 330);
        
        setResizable(false);
        
        Principal.top10.cargarRecords(new File ("./data/top10.csv"));
        
        Collection<RegistroTop10> registros = Principal.top10.darRegistros();
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        int i = 1;
        for (RegistroTop10 registro : registros) {
        	String spaces = " ";
        	String nombre = registro.darNombre();
        	int puntaje = registro.darPuntos();
        	listModel.addElement(i + ") " + registro.darNombre() + spaces.repeat(8 - nombre.length()) + " " + puntaje);
        	i++;
		}
        
        JList<String> jList = new JList<>(listModel);
        
        Color cutePurple = new Color(207, 159, 255);
		Color cuteYellow = new Color(255,253,141);
        
        jList.setCellRenderer(new DefaultListCellRenderer() {
        	@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {                    
        		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Center the text horizontally and vertically
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
        		
                if (index % 2 == 0) {
                    label.setBackground(cutePurple); // Change the background color for even rows
                } else {
                    label.setBackground(Color.PINK); // Change the background color for odd rows
                }
                
                // You can customize the font and color here
                setFont(new Font("Serif", Font.BOLD, 14));
                setForeground(Color.WHITE);

                // You can also set a border or any other styling you need
                setBorder(new EmptyBorder(5, 5, 5, 5));

                return this;
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(jList);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 3;

        setLocation(x, y);
        
        add(scrollPane);
        
        setVisible(true);
    }
    
}
