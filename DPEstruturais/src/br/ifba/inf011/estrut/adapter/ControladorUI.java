package br.ifba.inf011.estrut.adapter;

import javax.swing.*;
import java.awt.*;

public class ControladorUI {
	
	private JFrame frame;
	private Controlador controlador;
	
	public ControladorUI() {
		this.asm();
		this.controlador = new Controlador(25, 0.75);
	}
	
	
    public void asm() {

        //Creating the Frame
        this.frame = new JFrame("Controlador");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton ativar = new JButton("Ativar");
        JButton inativar = new JButton("Inativar");
        JButton recuperar = new JButton("Recuperar");
        ativar.addActionListener((e)->controlador.ativar());
        inativar.addActionListener((e)->controlador.inativar());
        recuperar.addActionListener((e)->controlador.restaurar());
        panel.add(ativar);
        panel.add(inativar);
        panel.add(recuperar);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        this.frame.getContentPane().add(BorderLayout.SOUTH, panel);
        this.frame.getContentPane().add(BorderLayout.NORTH, mb);
        this.frame.getContentPane().add(BorderLayout.CENTER, ta);
    }
    
    public void run() {
    	this.frame.setVisible(true);
    }
    
    public static void main(String[] args) {
		(new ControladorUI()).run();
	}
}
