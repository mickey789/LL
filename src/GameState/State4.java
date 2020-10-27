package GameState;

import java.awt.Graphics2D;
import Entity.*;
import TileMap.TileMap;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;
import GameState.State3;
import TileMap.Background;


public class State4 extends GameState {

    private TileMap tileMap;
    private Background B2;
    private Player player;
    
    //private MouseManager mouseManager;

    public State4(GameStateManager gsm){
        this.gsm = gsm;
        //mouseManager = new MouseManager();
        init();
    }
    
    
    public void init(){
        B2 = new Background("/Resources/Backgrounds/stage_3,9.png",1);
        B2.setPosition(0,0);
        tileMap = new TileMap(30);
        tileMap.loadTiles("/Resources/Tilesets/grasstileset.gif");
        tileMap.loadMap("/Resources/Maps/FirstState.map");
        tileMap.setPosition(0, 0);
        player = new Player(tileMap);
        player.setPosition(100,600);
        
    }
    
    public void update(){
        B2.update();
        player.update();

    }
    
    public void draw(Graphics2D g){
//        g.setColor(Color.RED);
//        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        B2.draw(g);
        tileMap.draw(g);
        player.draw(g);
        
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
	if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_ESCAPE){
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
        
        if(player.x > 103 && player.x < 199){
            if(k == KeyEvent.VK_ENTER){
            gsm.setCurrentState(GameStateManager.STATE5);
            }
        }
        if(player.x > 520 && player.x <622){
            if(k == KeyEvent.VK_ENTER){
            gsm.setCurrentState(GameStateManager.STATE5);
            }
        }
        if(player.x > 814 && player.x <904){
            if(k == KeyEvent.VK_ENTER){
            gsm.setCurrentState(GameStateManager.STATE5);
            }
        }
    }
    
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
	if(k == KeyEvent.VK_RIGHT) player.setRight(false);
    }
    
    
    
          
}
