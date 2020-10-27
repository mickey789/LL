package GameState;

import java.awt.Graphics2D;
import Entity.*;
import TileMap.TileMap;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;
import GameState.FirstState;
import TileMap.Background;
import GameState.State8;
import GameState.GameStateManager;

public class State2 extends GameState {

    private TileMap tileMap;
    private Background B1;
    private Player player;
    GameStateManager currentDoor ;
    
    //private MouseManager mouseManager;

    public State2(GameStateManager gsm){
        this.gsm = gsm;
        //mouseManager = new MouseManager();
        init();
        
    }
    
    
    public void init(){
        B1 = new Background("/Resources/Backgrounds/stage_1,2,5,7,8,11.png", 1);
        B1.setPosition(0,0);
        tileMap = new TileMap(30);
        tileMap.loadTiles("/Resources/Tilesets/grasstileset.gif");
        tileMap.loadMap("/Resources/Maps/FirstState.map");
        tileMap.setPosition(0, 0);
        player = new Player(tileMap);
        player.setPosition(100,600);
 
        System.out.println(currentDoor);
        
//        if(currentDoor = 0){
//
//            player.setPosition(275,600);
//        }
//        else if(currentDoor = 1){
//            
//            player.setPosition(775,600);
//        }
        
    }
    
    
    
    public void update(){
        B1.update();
        player.update();

    }
    
    public void draw(Graphics2D g){
//        g.setColor(Color.RED);
//        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        B1.draw(g);
        tileMap.draw(g);
        player.draw(g);
        
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
	if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_ESCAPE){
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
        
        if(player.x > 244 && player.x <316){
            if(k == KeyEvent.VK_ENTER){
                
//            gsm.setCurrentDoor(GameStateManager.INTROSTATE);
            gsm.setCurrentState(GameStateManager.STATE3);
            
            }
        }
        if(player.x > 730 && player.x <805){
            if(k == KeyEvent.VK_ENTER){
                
//            gsm.setCurrentDoor(GameStateManager.MENUSTATE);
            gsm.setCurrentState(GameStateManager.STATE3);
            
            }
        }
    }
    
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
	if(k == KeyEvent.VK_RIGHT) player.setRight(false);
    }
    
    
    
          
}
