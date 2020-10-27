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
    private Item item;
   
    
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
        item = new Item(tileMap);
        if(door2 == 1){player.setPosition(275,600);door2 = 0;}
        else if(door1 == 1){player.setPosition(775,600);door1 = 0;}
        else if(door3 == 1){player.setPosition(20,600);door3 = 0;}
        else if(door4 == 1){player.setPosition(950,600);door4 = 0;}
        item.setPosition(0, 0);
 
        System.out.println(door1);
        System.out.println(door2);
        System.out.println(door3);
        
    }
    
    
    
    public void update(){
        B1.update();
        player.update();
        item.update();

    }
    
    public void draw(Graphics2D g){
//        g.setColor(Color.RED);
//        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        B1.draw(g);
        tileMap.draw(g);
        player.draw(g);
        item.draw(g);
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
	if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_ESCAPE){
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
        if(k == KeyEvent.VK_1) item.delete();
        if(player.x > 240 && player.x <316){
            if(k == KeyEvent.VK_ENTER){
               checkDoor1(1);
               player.setWin();

            gsm.setCurrentState(GameStateManager.STATE8);
            
            }
        }
        if(player.x > 730 && player.x <805){
            if(k == KeyEvent.VK_ENTER){
                checkDoor2(1);

            gsm.setCurrentState(GameStateManager.STATE8);
            
            }
        }
        if(player.x >950){
            
                checkDoor3(1);
            gsm.setCurrentState(GameStateManager.STATE3);
            
        }
        if(player.x <20){
            
                checkDoor1(1);
            gsm.setCurrentState(GameStateManager.FIRSTSTATE);
            
        }
        
    }
    
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
	if(k == KeyEvent.VK_RIGHT) player.setRight(false);
    }
    
    
          
}
