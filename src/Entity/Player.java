package Entity;

import TileMap.TileMap;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Player extends MapObject{
        
    //animation
    private ArrayList<BufferedImage[]> sprites;
    private final int[] numFrames = { 1, 7};
    
    //animation actions
    private static final int IDLE = 0;
    private static final int WALKING = 1;
    
    public Player(TileMap tm){
        super(tm);
        
        width = 125;
        height = 278;
        //cwidth = 20;
        //cheight = 20;
        
        moveSpeed = 0.3;
        
        facingRight = true;
        
        //load Sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/player.png"));
            
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
           dx -= 0.3;
        }
        else if(right){
            dx += 0.3;
        }
        else{
            if(dx > 0){
               
                    dx = 0;
               
            }else if(dx < 0){
                
                    dx = 0;
                
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
                width = 125;
            }
        }
        else{
            if(currentAction != IDLE){
                currentAction = IDLE;
                animation.setFrames(sprites.get(IDLE));
                animation.setDelay(400);
                width = 125;
            }
        }
        
        animation.update();
        
        if(left){
            facingRight = true;
        }
        if(right){
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
