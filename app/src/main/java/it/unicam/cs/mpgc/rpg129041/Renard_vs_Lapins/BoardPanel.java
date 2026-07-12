package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class BoardPanel extends JPanel {

    private Board board;
    private final int cellSize = 64;

    private Image foxImage;
    private Image rabbitImage;
    private Image playerImage;

    public BoardPanel(Board board) {
        this.board = board;

        foxImage = loadImage("/fox.png");
        rabbitImage = loadImage("/rabbit.png");
        playerImage = loadImage("/monkey.png");
    }

    private Image loadImage(String path) {
        java.net.URL url = getClass().getResource(path);

        if (url == null) {
            System.out.println("Immagine NON trovata: " + path);
            return null;
        }

        return new ImageIcon(url).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Entity[][] grid = board.getGrid();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                // griglia
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);

                Entity e = grid[row][col];
                if (e != null) {

                    Image img = null;

                    if (e.getType() == EntityType.FOX) {
                        img = foxImage;
                    } else if (e.getType() == EntityType.RABBIT) {
                        img = rabbitImage;
                    } else if (e.getType() == EntityType.PLAYER) {
                        img = playerImage;
                    }

                    if (img != null) {
                        g.drawImage(img,
                                col * cellSize,
                                row * cellSize,
                                cellSize,
                                cellSize,
                                this);
                    } else {
                        // DEBUG → se immagine non caricata
                        System.out.println("IMG NULL per: " + e.getType());
                    }
                }
            }
        }
    }
}
