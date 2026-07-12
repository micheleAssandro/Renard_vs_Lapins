package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Image foxImg = loadImage("/fox.png");
    private Image rabbitImg = loadImage("/rabbit.png");

    private GameController game;
    private final int tileSize = 64;

    public GamePanel() {
        this.setPreferredSize(new Dimension(512, 512));
        this.setBackground(Color.BLACK);

        game = new GameController();

        Timer timer = new Timer(500, e -> {
            boolean running = game.step();
            repaint();

            if (!running) {
                Result result = game.getResult("Player1");

                JOptionPane.showMessageDialog(
                        null,
                        "Lapins Alive: " + result.noOfRabbitSurvived +
                        "\nPlayer's WinStatus: " + result.winner,
                        "End of the Match", JOptionPane.INFORMATION_MESSAGE );

                String[] options = {"Rematch", "Exit"};
                JOptionPane pane = new JOptionPane( "Do you want to play again?",
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    JOptionPane.YES_NO_OPTION, null,
                                                    options,
                                                    options[0] );

                JDialog dialog = pane.createDialog(null, "End");
                dialog.setVisible(true);

                Object selectedValue = pane.getValue();

                if (pane.getValue() == null) System.exit(0);
                // confronto con le opzioni switch
                switch ((String)pane.getValue()){
                    case "Rematch":
                        //fermo il timer
                        ((Timer)e.getSource()).stop();

                        //chiudo la finestra corrente
                        Window window = SwingUtilities.getWindowAncestor(this);
                        if (window != null) {
                            window.dispose();
                        }

                        //creo una nuova partita (nuova finestra)
                        SwingUtilities.invokeLater(() -> {
                            new GameFrame();
                        });

                    break;
                    case "Exit":
                        System.exit(0);
                    break;
                    default:
                        System.exit(0);
                    break; }
            }
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Board board = game.getBoard();

        for (int r = 0; r < Board.SIZE; r++) {
            for (int c = 0; c < Board.SIZE; c++) {

                if ((r + c) % 2 == 0) g.setColor(Color.WHITE);
                else g.setColor(Color.GRAY);

                g.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);

                Entity e = board.get(r, c);

                if (e instanceof Fox && foxImg != null) {
                    g.drawImage(foxImg, c * tileSize, r * tileSize, tileSize, tileSize, this);
                }

                if (e instanceof Rabbit && rabbitImg != null) {
                    g.drawImage(rabbitImg, c * tileSize, r * tileSize, tileSize, tileSize, this);
                }
            }
        }
    }

    private Image loadImage(String path) {
        java.net.URL url = getClass().getResource(path);

        if (url == null) {
            System.out.println("Immagine NON trovata: " + path);
            return null;
        }

        return new ImageIcon(url).getImage();
    }
}
