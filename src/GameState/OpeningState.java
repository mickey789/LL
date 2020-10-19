package GameState;

import TileMap.Background;
import java.awt.Color;
import java.awt.event.KeyEvent;
import lastlong.GamePanel;

public class OpeningState extends GameState{
    
    private Background bg;
    
    private int alpha;
    private int ticks = 0;
	
    private final int FADE_IN = 100;
    private final int LENGTH = 200;
    private final int FADE_OUT = 60;
    
    public OpeningState(GameStateManager gsm)
    {
        this.gsm = gsm;      
        bg = new Background("/Resources/Backgrounds/Opening.png",1);
    }
    
    public void update()
    {
        bg.update();
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
            gsm.setCurrentState(GameStateManager.FIRSTSTATE);
        }
    }
    
    public void draw(java.awt.Graphics2D g)
    {

        bg.draw(g);

	g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
	g.setColor(new Color(0, 0, 0, alpha));
	g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        
    }
    
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_ENTER){
            gsm.setCurrentState(GameStateManager.FIRSTSTATE);
        }
    }
    
    
    public void keyReleased(int k){
        
    }
    
}
