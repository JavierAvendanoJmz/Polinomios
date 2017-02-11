/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author j4v13
 */
public class Ecuacion extends JFrame{
    JTextField txtA;
    JTextField txtB;
    JTextField txtC;
    JLabel lblResultado;
    JLabel lblResultado2;
    
    public Ecuacion() {
        super("Ecuacion de 2o grado");
        super.setSize(320, 250);
        super.setLayout(new BorderLayout());
        super.setResizable(false);
        JPanel pnlAux = new JPanel();
        pnlAux.setLayout(new FlowLayout());
        pnlAux.add(new JLabel("Ax2 + Bx + C = 0"));
        super.add(pnlAux, BorderLayout.NORTH);
        super.add(crearPnlCentro(), BorderLayout.CENTER);
        super.add(crearPnlInferior(), BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private JPanel crearPnlInferior() {
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new FlowLayout());
        JButton btnResolver = new JButton("Resolver");
        JPanel pnlResultado = new JPanel();
        pnlResultado.setLayout(new BoxLayout(pnlResultado, BoxLayout.PAGE_AXIS));
        JPanel pnlAux = new JPanel();
        pnlAux.setLayout(new FlowLayout());
        JPanel pnlAux2 = new JPanel();
        pnlAux2.setLayout(new FlowLayout());
        lblResultado = new JLabel(); 
        lblResultado2 = new JLabel();
        pnlAux.add(lblResultado);
        pnlAux2.add(lblResultado2);
        pnlResultado.add(pnlAux);
        pnlResultado.add(pnlAux2);
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double R;
                    Double x;
                    Double a = Double.valueOf(txtA.getText());
                    Double b = Double.valueOf(txtB.getText());
                    Double c = Double.valueOf(txtC.getText());
                    R =  b * b;
                    R = R - 4 *  a * c;
                    if(R < 0) {
                        lblResultado.setText("Sin resultado");
                        lblResultado2.setText("");
                    } else if(R == 0) {                        
                        x = (b * -1) / 2* a;
                        lblResultado.setText("x = "+x+"");
                        lblResultado2.setText("");
                    } else {
                        x = ((-1 * b) + Math.sqrt(R)) / (2 * a);
                        lblResultado.setText("x = "+x+"");
                        x = ((-1 * b) - Math.sqrt(R)) / (2 * a);
                        lblResultado2.setText("x = "+x+"");
                    }
                } catch(Exception ex) {
                    
                }
            }
        });
        pnlPrincipal.add(btnResolver);
        pnlPrincipal.add(pnlResultado);
        return pnlPrincipal;
    }
    
    private JPanel crearPnlCentro() {
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.PAGE_AXIS));
        txtA = new JTextField(5);
        txtB = new JTextField(5);
        txtC = new JTextField(5);
        
        JPanel pnlA = new JPanel();
        JPanel pnlB = new JPanel();
        JPanel pnlC = new JPanel();
        
        pnlA.setLayout(new FlowLayout());
        pnlA.add(new JLabel("A ="));
        pnlA.add(txtA);
        
        pnlB.setLayout(new FlowLayout());
        pnlB.add(new JLabel("B ="));
        pnlB.add(txtB);
        
        pnlC.setLayout(new FlowLayout());
        pnlC.add(new JLabel("C ="));
        pnlC.add(txtC);
        pnlPrincipal.add(pnlA);
        pnlPrincipal.add(pnlB);
        pnlPrincipal.add(pnlC);
        return pnlPrincipal;
   }
}
