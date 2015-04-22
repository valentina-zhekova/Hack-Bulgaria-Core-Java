/*
 * Don't work on linux cause pop up has functionallity for windows...
 * */

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

import com.nitido.utils.toaster.Toaster;

public class EyesRest {

    public static void main(String[] args) {
        Toaster toasterManager = new Toaster();
        toasterManager.showToaster("JToaster Hello World!");
        toasterManager.setToasterWidth(200);
        toasterManager.setToasterHeight(200);
        //toasterManager.setToasterIcon(); // ???????
        toasterManager.setToasterColor(Color.blue);
        
        /*BufferedImage img = null;
        try {
            img = ImageIO.read(new File("strawberry.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        toasterManager.setBackgroundImage(img);*/
        toasterManager.setStep(0);
        toasterManager.setDisplayTime(2);
    }
}
