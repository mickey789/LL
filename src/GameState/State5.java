package GameState;

import java.awt.Graphics2D;
import Entity.*;
import TileMap.TileMap;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;
import GameState.State4;
import TileMap.Background;


public class State5 extends GameState {

    private TileMap tileMap;
    private Background B3;
    private Player player;
    
    //private MouseManager mouseManager;

    public State5(GameStateManager gsm){
        this.gsm = gsm;
        //mouseManager = new MouseManager();
        init();
    }
    
    
    public void init(){
        B3 = new Background("/Resources/Backgrounds/stage_4.png",1);
        B3.setPosition(0,0);
        tileMap = new TileMap(30);
        tileMap.loadTiles("/Resources/Tilesets/grasstileset.gif");
        tileMap.loadMap("/Resources/Maps/FirstState.map");
        tileMap.setPosition(0, 0);
        player = new Player(tileMap);
        if(door1 == 1){player.setPosition(330,600);door1 = 0;}
        else if(door2 == 1){player.setPosition(0,600);door2 = 0;}
        else if(door3 == 1){player.setPosition(950,600);door3 = 0;}
        
    }
    
    public void update(){
        B3.update();
        player.update();

    }
    
    public void draw(Graphics2D g){
//        g.setColor(Color.RED);
//        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        B3.draw(g);
        tileMap.draw(g);
        player.draw(g);
        
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
	if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_ESCAPE){
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
        
        if(player.x > 283 && player.x <373){
            if(k == KeyEvent.VK_ENTER){
                checkDoor1(1);
            gsm.setCurrentState(GameStateManager.STATE11);
            }
        }
        if(player.x <50){
            if(k == KeyEvent.VK_ENTER){
                checkDoor4(1);
            gsm.setCurrentState(GameStateManager.STATE4);
            }
        }
        if(player.x >950){
            if(k == KeyEvent.VK_ENTER){
                checkDoor3(1);
            gsm.setCurrentState(GameStateManager.STATE6);
            }
        }
    }
    
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
	if(k == KeyEvent.VK_RIGHT) player.setRight(false);
    }
    
    
    
          
}
