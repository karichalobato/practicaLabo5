/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Thread.AnimalTread;


public class ventana extends JFrame{
    private JLabel[] labels;
    private JButton inicio, reiniciar;
    private String[] nombres = {"canguro", "tortuga", "dragon"};

    public ventana() {
        super("Carrera de Animales");
        initialComponents();
    }

    public void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        reiniciar = new JButton("Reiniciar");
        Container contains = getContentPane();

        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i] + ".gif")));
            labels[i].setBounds(10, (i * 220) + 10, 200, 200);
            contains.add(labels[i]);
        }

        reiniciar.setBounds(575, 0, 100, 30);
        inicio.setBounds(10, 0, 100, 30);
        contains.add(inicio);
        contains.add(reiniciar);

        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalTread canguro = new AnimalTread("canguro", labels[0].getX(), labels[0].getY(), 510, labels[0]);
                AnimalTread tortuga = new AnimalTread("tortuga", labels[1].getX(), labels[1].getY(), 510, labels[1]);
                AnimalTread dragon = new AnimalTread("Dragon", labels[2].getX(), labels[2].getY(), 510, labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {

                    labels[i].setLocation(10, (i * 220));
                }
              
            }
        });

        setSize(700, 650);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

}
    

