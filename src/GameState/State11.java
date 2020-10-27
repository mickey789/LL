package GameState;

import java.awt.Graphics2D;
import Entity.*;
import TileMap.TileMap;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;
import GameState.State10;
import TileMap.Background;


public class State11 extends GameState {

    private TileMap tileMap;
    private Background B5;
    private Player player;
    
    //private MouseManager mouseManager;

    public State11(GameStateManager gsm){
        this.gsm = gsm;
        //mouseManager = new MouseManager();
        init();
    }
    
    
    public void init(){
        B5 = new Background("/Resources/Backgrounds/stage_9.png",1);
        B5.setPosition(0,0);
        tileMap = new TileMap(30);
        tileMap.loadTiles("/Resources/Tilesets/grasstileset.gif");
        tileMap.loadMap("/Resources/Maps/FirstState.map");
        tileMap.setPosition(0, 0);
        player = new Player(tileMap);
        if(door1 == 1){player.setPosition(330,600);door1 = 0;}
        else if(door2 == 1){player.setPosition(950,600);door2 = 0;}
        
    }
    
    public void update(){
        B5.update();
        player.update();

    }
    
    public void draw(Graphics2D g){
//        g.setColor(Color.RED);
//        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        B5.draw(g);
        tileMap.draw(g);
        player.draw(g);
        
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
	if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_ESCAPE){
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
        
        if(player.x > 541 && player.x <631){
            if(k == KeyEvent.VK_ENTER){
                checkDoor1(1);
            gsm.setCurrentState(GameStateManager.STATE5);
            }
        }
        if(player.x >950){
            if(k == KeyEvent.VK_ENTER){
                checkDoor5(1);
            gsm.setCurrentState(GameStateManager.STATE9);
            }
        }
    }
    
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
	if(k == KeyEvent.VK_RIGHT) player.setRight(false);
    }
    
    
    
          
}
