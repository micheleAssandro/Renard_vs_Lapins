package it.unicam.cs.mpgc.rpg129041.Renard_vs_Lapins;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteLoader {

    public static BufferedImage load(String path) {
        try {
            return ImageIO.read(SpriteLoader.class.getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException("Errore caricamento sprite: " + path);
        }
    }
}