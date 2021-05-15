package edu.sber.printer;

import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.diogonunes.jcdp.color.api.Ansi;

public class Printer {
    private final String white = "WHITE";
    private final String black = "BLACK";
    private final String path;;

    public Printer(String path)  {
        this.path = path;
        try {
            printImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printImage() throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        int height = image.getHeight();
        int width = image.getWidth();
        String str;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int color = image.getRGB(i, j);
                if (color == 0) {
                    str = Ansi.PREFIX +  Ansi.BColor.valueOf(this.white) + Ansi.POSTFIX;
                } else {
                    str = Ansi.PREFIX + Ansi.BColor.valueOf(this.black) + Ansi.POSTFIX;
                }
                System.out.print(str + "  ");
            }
            System.out.println(Ansi.PREFIX + Ansi.BColor.NONE + Ansi.POSTFIX);
        }
    }
}
