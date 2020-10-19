package GameState;

import TileMap.Background;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;

public class IntroState extends GameState {
    
    
    private Background logo;
    private int alpha;
    private int ticks = 0;
	
    private final int FADE_IN = 60;
    private final int LENGTH = 200;
    private final int FADE_OUT = 60;
    
    public IntroState(GameStateManager gsm) {
        this.gsm = gsm;
        try {
		logo = new Background("/Resources/Backgrounds/logo.png", 1);
                logo.setPosition(0, 0);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
        
    }
        
    public void update() {
        logo.update();
        ticks++;
        if(ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if(alpha < 0) alpha = 0;
        }
        if(ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if(alpha > 255) alpha = 255;
        }
        if(ticks > FADE_IN + LENGTH + FADE_OUT) {
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
    }
        
    public void draw(Graphics2D g) {
        
        logo.draw(g);
	g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
	g.setColor(new Color(0, 0, 0, alpha));
	g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }
        
    public void keyPressed(int k){
        if(k == KeyEvent.VK_SPACE){
            gsm.setCurrentState(GameStateManager.MENUSTATE);
        }
    }
    
    public void keyReleased(int k){
        
    }
    

}
