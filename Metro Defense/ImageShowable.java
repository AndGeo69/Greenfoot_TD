import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImageShowable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageShowable extends Actor
{
    public ImageShowable(Turret turret, int seq) {
        GreenfootImage trt = turret.getImage();
        
        GreenfootImage image = new GreenfootImage(trt.getWidth(), trt.getHeight() * 2 + 30);

        image.setColor(new Color(0, 0, 0, 128));
        Font font = new Font("Arial", true, false, (int)20);
        image.setFont(font);
        image.setColor(Color.WHITE);
        
        trt.scale(50, 50);
        
        image.drawImage(trt, (image.getWidth() - trt.getWidth()) / 2, (image.getHeight() - trt.getHeight()) / 6);
        image.drawString("$ " + turret.price() , (image.getWidth() - trt.getWidth()) / 2, trt.getHeight() * 2);
        image.drawString("'" + String.valueOf(seq) + "'", (image.getWidth() - trt.getWidth()) / 2 + 10, trt.getHeight() * 2 + 30);
        
        setImage(image);
    }
}
