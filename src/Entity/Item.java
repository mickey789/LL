package Entity;

import TileMap.TileMap;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Item extends MapObject{

    private ArrayList<BufferedImage[]> sprites;
    private final int[] numFrames = { 1};
    
    private static final int IDLE = 0;
    
    public Item(TileMap tm){
        super(tm);
        
        width = 65;
        height = 54;
        //cwidth = 20;
        //cheight = 20;
        
        //load Sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/rock1.png"));
            
            sprites = new ArrayList<BufferedImage[]>();
            
            for(int i = 0; i < 1; i++){
                BufferedImage[] bi = new BufferedImage[numFrames[i]];
                for(int j = 0; j < numFrames[i]; j++){
                    bi[j] = spritesheet.getSubimage(j * width, i * height, width, height);
                }
                 sprites.add(bi);
            }  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        animation = new Animation();
        currentAction = IDLE;
        animation.setFrames(sprites.get(IDLE));
        
        
    }
    
    public void update(){
        //update position
            setPosition(xtemp, ytemp);
            animation.update();
        
        
    }
    
    public void draw(Graphics2D g){
        setMapPosition();
        if(blockItem == 0){
        g.drawImage(animation.getImage(), (int) (x + xmap) - width / 2, (int) (y + ymap - height / 2), null);
        }
    }
    
    public void delete(){
        blockItem++;
           }
}
