package GameState;

import java.awt.Graphics2D;
import Entity.*;
import TileMap.TileMap;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;
import TileMap.Background;
import Entity.MapObject;



public class FirstState extends GameState {

    private TileMap tileMap;
    private Background B1;
    private Player player;

    
    
    
    //private MouseManager mouseManager;

    public FirstState(GameStateManager gsm){
        this.gsm = gsm;
        //mouseManager = new MouseManager();
        init();
    }
    
    
    public void init(){
        B1 = new Background("/Resources/Backgrounds/stageTuto.png", 1);
        B1.setPosition(0,0);
        tileMap = new TileMap(30);
        tileMap.loadTiles("/Resources/Tilesets/korb.png");
        tileMap.loadMap("/Resources/Maps/FirstState.map");
        tileMap.setPosition(0, 0);
        player = new Player(tileMap);
        
        if(door1 == 1){player.setPosition(950,600);door1 = 0;}
        else{player.setPosition(100,600);}
        
        System.out.println(door1);
        System.out.println(door2);
        System.out.println(door3);
        
   
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
        if(player.x >950){
            if(k == KeyEvent.VK_ENTER){
                checkDoor3(1);
            gsm.setCurrentState(GameStateManager.STATE2);
        }
        }
    }
    
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
	if(k == KeyEvent.VK_RIGHT) player.setRight(false);
    }
    
    
    
          
}
