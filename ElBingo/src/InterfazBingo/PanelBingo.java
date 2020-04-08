/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBingo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Laura
 */
public class PanelBingo extends JPanel implements VistaBingo {
    //nota: faltan las distrubuciones de los cartones
    private JPanel PanelBingo= new JPanel(new GridLayout(3,1));
    private JPanel PanelJugadores = new JPanel(new GridLayout(3,1));;
    private JPanel PanelCartonBingo= new JPanel(new GridLayout(9,10));
    private JPanel panelNumero= new JPanel(new GridLayout(1,2));
    private JButton botonJugar;
    private JPanel PanelJugador1=new JPanel(new BorderLayout());
    private JPanel PanelJugador2=new JPanel(new BorderLayout());
    private JLabel labelJugador1;
    private JLabel labelJugador2;
    private JPanel CartónJugador1=new JPanel(new GridLayout(3,9));
    private JPanel CartónJugador2=new JPanel(new GridLayout(3,9));
    private JPanel PanelGanadores= new JPanel(new GridLayout(2,2));
    private JLabel ganadorlinea;
    private JLabel ganadorBingo;
    private JTextField TextGanadorlinea;
    private JTextField TextGanadorBingo;
    private JTextField TextNumeroSiguiente;
    private JLabel [][] cartonBingo;
    private JLabel [][] cartonJugador1= new JLabel [3][9];
    private JLabel [][] cartonJugador2= new JLabel [3][9];
    private JButton botonSacarNum;
    private ImageIcon imagen;

    public PanelBingo(){
        
        PanelCartonBingo.setBackground(new Color(204, 153, 255));
        PanelCartonBingo.setBorder(new LineBorder(Color.BLACK));
        PanelCartonBingo.setSize(500,400);
        PanelBingo.add(PanelCartonBingo);
        
        TextNumeroSiguiente=new JTextField(3);
        TextNumeroSiguiente.setEditable(false);
        TextNumeroSiguiente.setFont(new Font(Font.SANS_SERIF, Font.BOLD,50));
        TextNumeroSiguiente.setForeground(Color.black);
        TextNumeroSiguiente.setBackground(Color.white);
        TextNumeroSiguiente.setBorder(new LineBorder(Color.BLACK));
        TextNumeroSiguiente.setHorizontalAlignment(JTextField.CENTER);
        botonSacarNum= new JButton("Siguiente");
        botonSacarNum.setEnabled(false);
        botonSacarNum.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        panelNumero.add(botonSacarNum);
        panelNumero.add(TextNumeroSiguiente);
        PanelBingo.add(panelNumero);

        botonJugar= new JButton("Jugar");
        botonJugar.setBorder(new LineBorder(Color.RED));
        botonJugar.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        PanelBingo.add(botonJugar);
        
        
        labelJugador1= new JLabel(JOptionPane.showInputDialog("Introduce nombre jugador1"));
        labelJugador2= new JLabel(JOptionPane.showInputDialog("Introduce nombre jugador2"));
        labelJugador1.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        labelJugador2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        
        PanelJugador1.add(labelJugador1,BorderLayout.NORTH);
        labelJugador1.setHorizontalAlignment(JLabel.CENTER);
        PanelJugador1.add(CartónJugador1,BorderLayout.CENTER);
        CartónJugador1.setBackground(new Color(153, 204, 255));
        PanelJugador1.setBorder(new LineBorder(Color.BLACK));
        PanelJugador1.setBackground(new Color(153, 204, 255));
        PanelJugador2.add(labelJugador2, BorderLayout.NORTH);
        labelJugador2.setHorizontalAlignment(JLabel.CENTER);
        
        PanelJugador2.add(CartónJugador2,BorderLayout.CENTER);
        CartónJugador2.setBackground(new Color(153, 153, 255));
        PanelJugador2.setBorder(new LineBorder(Color.BLACK));
        PanelJugador2.setBackground(new Color(153, 153, 255));
        
        ganadorlinea= new JLabel("El ganador de la linea es: ");
        
        
        ganadorlinea.setHorizontalAlignment(JLabel.CENTER);
        ganadorlinea.setBorder(new LineBorder(Color.BLACK));
        ganadorlinea.setBackground(new Color(229,204,255));
        ganadorlinea.setOpaque(true);
        ganadorlinea.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
        
        ganadorBingo= new JLabel("El ganador del bingo es: ");
        ganadorBingo.setHorizontalAlignment(JLabel.CENTER);
        ganadorBingo.setBorder(new LineBorder(Color.BLACK));
        ganadorBingo.setBackground(new Color(255,204,255));
        ganadorBingo.setOpaque(true);
        ganadorBingo.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
        
        
        TextGanadorlinea= new JTextField(20);
        TextGanadorlinea.setHorizontalAlignment(JLabel.CENTER);
        TextGanadorlinea.setBackground(Color.white);
        TextGanadorlinea.setBorder(new LineBorder(Color.BLACK));
        TextGanadorlinea.setEditable(false);
        TextGanadorlinea.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));

        
        TextGanadorBingo= new JTextField(20);
        TextGanadorBingo.setHorizontalAlignment(JLabel.CENTER);
        TextGanadorBingo.setBackground(Color.white);
        TextGanadorBingo.setBorder(new LineBorder(Color.BLACK));
        TextGanadorBingo.setEditable(false);
        TextGanadorBingo.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        
        PanelGanadores.add(ganadorlinea);
        PanelGanadores.add(TextGanadorlinea);
        PanelGanadores.add(ganadorBingo);
        PanelGanadores.add(TextGanadorBingo);
        
        PanelJugadores.add(PanelJugador1);
        PanelJugadores.add(PanelJugador2);
        PanelJugadores.add(PanelGanadores);
        PanelJugadores.setPreferredSize( new Dimension(450,600));//450,600
        setLayout(new BorderLayout());
        add(PanelBingo, BorderLayout.WEST);
        add(PanelJugadores, BorderLayout.EAST);
        
        imagen = new ImageIcon("src\\InterfazBingo\\Bingo.jpg");
        JLabel labelConImgen= new JLabel(imagen);
        JPanel panelImgen = new JPanel(new BorderLayout());
        panelImgen.add(labelConImgen,BorderLayout.CENTER);
        panelImgen.setBackground(Color.WHITE);
        add(panelImgen,BorderLayout.CENTER);
        panelImgen.add(labelConImgen);
    }
   
    public void controlador(ActionListener ctr){
        botonJugar.addActionListener(ctr);
        botonJugar.setActionCommand("Jugar"); 
        botonSacarNum.addActionListener(ctr);
        botonSacarNum.setActionCommand("Siguiente"); 
    }

   @Override
    public void setContentCartonBingo(int contenido) {
        JLabel cont=new JLabel (Integer.toString(contenido));
        cont.setHorizontalAlignment(JLabel.CENTER);
        //cont.setFont(new Font(Font.SANS_SERIF, Font.BOLD,10));
        //cont.setBorder(new LineBorder(Color.BLACK));
        PanelCartonBingo.add(cont);
        PanelCartonBingo.validate();
    }

    @Override
    public void setContentCartonJugador1(int[][] contenidoCarton1) {
        CartónJugador1.removeAll();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {   
                cartonJugador1[i][j]=new JLabel(Integer.toString(contenidoCarton1[i][j])+"");
                cartonJugador1[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
                cartonJugador1[i][j].setBorder(new LineBorder(Color.BLACK));
                cartonJugador1[i][j].setHorizontalAlignment(JLabel.CENTER);
                cartonJugador1[i][j].setOpaque(true);
                
                cartonJugador1[i][j].setBackground(new Color(255,255,204));
                CartónJugador1.add(cartonJugador1[i][j]);
            }
        }
        CartónJugador1.validate();
    }

    @Override
    public void setContentCartonJugador2(int[][] contenidoCarton2) {
        CartónJugador2.removeAll();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {   
                cartonJugador2[i][j]=new JLabel(Integer.toString(contenidoCarton2[i][j])+"");
                cartonJugador2[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
                cartonJugador2[i][j].setBorder(new LineBorder(Color.BLACK));
                cartonJugador2[i][j].setHorizontalAlignment(JLabel.CENTER);
                cartonJugador2[i][j].setOpaque(true);
                cartonJugador2[i][j].setBackground(new Color(255,255,204));
                CartónJugador2.add(cartonJugador2[i][j]);
            }
        }
        CartónJugador2.revalidate();
    }

    @Override
    public String getNomjugador1() {
        return labelJugador1.getText();
    }

    @Override
    public String getNomjugador2() {
        return labelJugador2.getText();
    }

    @Override
    public void setTextFieldGanadorLinea(String nomGanador) {
        TextGanadorlinea.setText(nomGanador);
        TextGanadorlinea.setBackground(new Color(255, 255, 153));
        TextGanadorlinea.validate();
    }

    @Override
    public void setTextFieldGanadorBingo(String nomGanador) {
        TextGanadorBingo.setText(nomGanador);
        TextGanadorBingo.setBackground(new Color(255, 255, 153));
        TextGanadorBingo.validate();
        JOptionPane.showMessageDialog(null, "FIN DEL JUEGO!");
    }

    @Override
    public void setContentTextSiguiente(int contenido) {
        TextNumeroSiguiente.setText(Integer.toString(contenido));
        TextNumeroSiguiente.validate();
    }

    @Override
    public void setEnabledSiguiente() {
        botonSacarNum.setEnabled(true);
    }
    @Override
    public void setEnabledJugar() {
        botonJugar.setEnabled(false);
    }

}
