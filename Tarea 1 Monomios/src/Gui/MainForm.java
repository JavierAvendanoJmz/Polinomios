/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author j4v13
 */
public class MainForm extends JFrame {
    
    Controlador controlador;
    JTextField txtCoeficiente;
    JLabel lblMonomio;
    JTextField txtExponente;
    JButton btnAgregar1;
    JButton btnAgregar2;
    JButton btnLimpiar;
    JButton btnDelete;
    JButton btnDelete2;
    JButton btnResolver;
    JLabel lblPoli1;
    JLabel lblPoli2;
    JLabel lblMensaje;
    JButton btnSimplificar;
    JButton btnSumar;
    JButton btnRestar;
    JButton btnMultiplicar;
    

    public MainForm() {
        super("Polinomios");
        super.setSize(600, 210);
        super.setResizable(false); 
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlador = new Controlador();
        super.add(createPnlAgregar(), BorderLayout.NORTH);
        super.add(createPnlPolinomios(), BorderLayout.CENTER);
        super.add(createPnlBotones(), BorderLayout.SOUTH);
        super.setVisible(true);
    }    
    
    private JPanel createPnlResolver() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  
        btnResolver = new JButton("Ec. 2do Grado");
        btnResolver.setBackground(Color.DARK_GRAY);
        btnResolver.setForeground(Color.WHITE);
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Ecuacion();
            }
        });
        panel.add(btnResolver);
        return panel;
    }
    
    private JPanel createPnlBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  
        btnSimplificar = new JButton("Simplificar y ordenar");
        btnSumar = new JButton("Sumar");
        btnRestar = new JButton("Restar");
        btnMultiplicar = new JButton("Multiplicar");
        btnSimplificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controlador.Simplifica(1);
                lblPoli1.setText("1. " + controlador.Simplifica(1));
                controlador.Simplifica(2);
                lblPoli2.setText("2. " + controlador.Simplifica(2));
            }
        });
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblMensaje.setText(controlador.sumar());
            }
        });
        btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblMensaje.setText(controlador.restar());
            }
        });
        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblMensaje.setText(controlador.multiplicar());
            }
        });
        panel.add(btnSimplificar);
        panel.add(btnSumar);
        panel.add(btnRestar);
        panel.add(btnMultiplicar);
        panel.add(createPnlResolver());
        return panel;
    }
    
    private JPanel createPnlPolinomios() {
        JPanel panelFlow = new JPanel();
        panelFlow.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));  
        
        JPanel pnlAux1 = new JPanel();        
        pnlAux1.setLayout(new FlowLayout());
        JPanel pnlAux2 = new JPanel();
        pnlAux2.setLayout(new FlowLayout());
        JPanel pnlAux3 = new JPanel();
        pnlAux3.setLayout(new FlowLayout());
        
        lblPoli1 = new JLabel("1. ");
        lblPoli2 = new JLabel("2. ");
        lblMensaje = new JLabel();
        btnDelete = new JButton("<");
        btnDelete2 = new JButton("<");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblPoli1.setText("1. "+controlador.borrar(1));
            }
        });
        
        btnDelete2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblPoli2.setText("2. "+controlador.borrar(2));
            }
        });
        
        pnlAux1.add(lblPoli1);
        pnlAux1.add(btnDelete);
        pnlAux2.add(lblPoli2);
        pnlAux2.add(btnDelete2);
        pnlAux3.add(lblMensaje);
        
        panel.add(pnlAux1);
        panel.add(pnlAux2);
        panel.add(pnlAux3);
        panelFlow.add(panel);
        
        return panelFlow;
    }
    
    private JPanel createPnlAgregar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());                
        txtCoeficiente = new JTextField(5);
        lblMonomio = new JLabel("x^");
        txtExponente = new JTextField(5);
        btnAgregar1 = new JButton("Agregar 1");
        btnAgregar2 = new JButton("Agregar 2");
        btnLimpiar = new JButton("Limpiar");
        
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblPoli1.setText("1. ");
                lblPoli2.setText("2. ");
                lblMensaje.setText("Ok");
                controlador.limpiar();                
            }
        });
        btnAgregar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String c = txtCoeficiente.getText();
                String e = txtExponente.getText();
                try {
                    lblPoli1.setText("1. " + controlador.agregar(1, c, e));
                    txtCoeficiente.setText("");
                    txtExponente.setText("");
                    lblMensaje.setText("");
                } catch (Exception ex) {
                    lblMensaje.setText("Error, casilla vacia");
                }
            }
        });
        
        btnAgregar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String c = txtCoeficiente.getText();
                String e = txtExponente.getText();
                try {
                    lblPoli2.setText("2. " + controlador.agregar(2, c, e));
                    txtCoeficiente.setText("");
                    txtExponente.setText("");
                    lblMensaje.setText("");
                } catch (Exception ex) {
                    lblMensaje.setText("Error, casilla vacia");
                }
            }
        });
        
        panel.add(txtCoeficiente);
        panel.add(lblMonomio);
        panel.add(txtExponente);
        panel.add(btnAgregar1);        
        panel.add(btnAgregar2);
        panel.add(btnLimpiar);
        return panel;
    }
}
