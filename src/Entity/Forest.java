package Entity;

import TileMap.Background;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import lastlong.GamePanel;

public class Forest {
    
    private Background B1;
    private Background B2;
    private Background B3;
    private Background B4;
    private Background B5;
    private Background B6;
    private Background B7;
    private Background B8;
    private Background B9;
    private Background B10;
    private Background B11;
    private Background B12;


    
    public void Forest(){
        
        B1 = new Background("/Resources/Backgrounds/stage1,2,5,7,8,11.png", 1);
//        B2 = new Background("/Resources/Backgrounds/stage1,2,5,7,8,11.png",1);
//        B3 = new Background("/Resources/Backgrounds/stage3,9.png",1);
//        B4 = new Background("/Resources/Backgrounds/stage4.png",1);
//        B5 = new Background("/Resources/Backgrounds/stage1,2,5,7,8,11.png",1);
//        B6 = new Background("/Resources/Backgrounds/stage6.png",1);
//        B7 = new Background("/Resources/Backgrounds/stage1,2,5,7,8,11.png",1);
//        B8 = new Background("/Resources/Backgrounds/stage1,2,5,7,8,11.png",1);
//        B9 = new Background("/Resources/Backgrounds/stage3,9.png",1);
//        B10 = new Background("/Resources/Backgrounds/stage10.png",1);
//        B11 = new Background("/Resources/Backgrounds/stage1,2,5,7,8,11.png", 1);
        B1.setPosition(0,0);
        
        
    }
    
    public void update(){
//        B12.update();
//        B11.update();
//        B10.update();
//        B9.update();
//        B8.update();
//        B7.update();
//        B6.update();
//        B5.update();
//        B4.update();
//        B3.update();
//        B2.update();
        B1.update();

    }
    
    public void draw(Graphics2D g){
//        B12.draw(g);
//        B11.draw(g);
//        B10.draw(g);
//        B9.draw(g);
//        B8.draw(g);
//        B7.draw(g);
//        B6.draw(g);
//        B5.draw(g);
//        B4.draw(g);
//        B3.draw(g);
//        B2.draw(g);
        B1.draw(g);

    }
}
