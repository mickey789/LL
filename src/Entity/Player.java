package Entity;

import TileMap.TileMap;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Player extends MapObject{
        
    //animation
    private ArrayList<BufferedImage[]> sprites;
    private final int[] numFrames = { 2, 8};
    
    //animation actions
    private static final int IDLE = 0;
    private static final int WALKING = 1;
    
    public Player(TileMap tm){
        super(tm);
        
        width = 30;
        height = 30;
        cwidth = 20;
        cheight = 20;
        
        moveSpeed = 0.3;
        
        facingRight = true;
        
        //load Sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/Test.gif"));
            
            sprites = new ArrayList<BufferedImage[]>();
            
            for(int i = 0; i < 2; i++){
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
        animation.setDelay(400);
    }
    
    public void getNextPosition(){
        
        //movement
        if(left){
            x -= 5;
        }
        else if(right){
            x += 5;
        }
        else{
            if(x > 0){
                if(x < 0){
                    x = 0;
                }
            }else if(x < 0){
                if(x > 0){
                    x = 0;
                }
            }
        }
    }
    
    public void update(){
        //update position
        getNextPosition();
        checkTileMapCollision();
        setPosition(xtemp, ytemp);
        
        if(left || right){
            if(currentAction != WALKING){
                currentAction = WALKING;
                animation.setFrames(sprites.get(WALKING));
                animation.setDelay(40);
                width = 30;
            }
        }
        else{
            if(currentAction != IDLE){
                currentAction = IDLE;
                animation.setFrames(sprites.get(IDLE));
                animation.setDelay(400);
                width = 30;
            }
        }
        
        animation.update();
        
        if(right){
            facingRight = true;
        }
        if(left){
            facingRight = false;
        }
    }
    
    public void draw(Graphics2D g){
        
        setMapPosition();
        
        //draw player
        if(facingRight){
            g.drawImage(animation.getImage(), (int) (x + xmap) - width / 2, (int) (y + ymap - height / 2), null);
        }
        else{
            g.drawImage(animation.getImage(), (int) (x + xmap) - width / 2 + width, (int) (y + ymap - height / 2), -width, height, null);
        }
    }
    
   
}
