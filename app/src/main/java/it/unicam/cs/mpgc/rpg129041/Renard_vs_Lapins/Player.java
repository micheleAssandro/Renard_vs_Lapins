package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player {

    int x = 100, y = 100;
    int speed = 4;

    BufferedImage[] walkDown;
    int frameIndex = 0;
    int frameCounter = 0;

    boolean up, down, left, right;

    int tileSize;

    public Player(int tileSize) {
        this.tileSize = tileSize;
        loadSprites();
    }

    private void loadSprites() {
        //C:\Users\miche\Desktop\Uni\metodologie\progettoMetodologie\app\src\main\resources\monkey.png
        BufferedImage sheet = SpriteLoader.load("/monkey.png");

        int frameWidth = 32;
        int frameHeight = 32;

        walkDown = new BufferedImage[3];

        for (int i = 0; i < 3; i++) {
            walkDown[i] = sheet.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);
        }
    }

    public void update() {
        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;

        if (up || down || left || right) {
            frameCounter++;
            if (frameCounter > 10) {
                frameIndex = (frameIndex + 1) % walkDown.length;
                frameCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(walkDown[frameIndex], x, y, tileSize, tileSize, null);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_S -> down = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_D -> right = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_S -> down = false;
            case KeyEvent.VK_A -> left = false;
            case KeyEvent.VK_D -> right = false;
        }
    }
}