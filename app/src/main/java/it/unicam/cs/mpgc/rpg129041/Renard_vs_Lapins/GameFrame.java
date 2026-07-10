package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Renard vs Lapins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        add(panel);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}