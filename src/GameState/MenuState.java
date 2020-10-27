package GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import TileMap.Background;
import java.awt.Font;
import Audio.AudioPlayer;
import Entity.Timing;

public class MenuState extends GameState {

    private AudioPlayer menuMusic;
    
    private Background bg;
    private Background right1;
    private Background left1;
    
    private int currentChoice = 0;
    private String[] options = {
        "Start",
        "Quit"
    };
    
    private Color titleColor;
    private Font titleFont;
    
    private Font font;
    
    private Timing time;
    
    public MenuState(GameStateManager gsm){
        this.gsm = gsm;
        menuMusic = new AudioPlayer("/Resources/Music/menuMusic.wav");
        menuMusic.playLoop();
        try
        {
            bg = new Background("/Resources/Backgrounds/menu.png", 1);
            
            
            titleColor = new Color(128, 0, 0);
            font = new Font("Century", Font.PLAIN, 40);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        right1 = new Background("/Resources/Backgrounds/stepRight.png", 1);
        left1 = new Background("/Resources/Backgrounds/stepLeft.png", 1);
        
        time = new Timing();
        time.start();
    }
    
    public void update()
    {
        bg.update();  
        right1.update();
        left1.update();
    }
    
    public void draw(Graphics2D g)
    {
        //draw bg
        bg.draw(g);
        
        //draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++)
        {
            if(i == currentChoice){
                g.setColor(Color.RED);
            }
            else{
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], 450, 400 + i * 60);
        }
        
        if(time.seconds() > 29){
            right1.setPosition(900, 700);
            right1.draw(g);
        }
        if(time.seconds() > 30){
            left1.setPosition(850, 650);
            left1.draw(g);
        }
        if(time.seconds() > 31){
            right1.setPosition(900, 550);
            right1.draw(g);
        }
        if(time.seconds() > 32){
            left1.setPosition(830, 500);
            left1.draw(g);
        }
        if(time.seconds() > 33){
            right1.setPosition(890, 400);
            right1.draw(g);
        }
        if(time.seconds() > 34){
            left1.setPosition(820, 350);
            left1.draw(g);
        }
        
        
    }
    
    private void select()
    {
        if(currentChoice == 0){
            time.stop();
            menuMusic.stop();
            gsm.setCurrentState(GameStateManager.OPENINGSTATE);
        }
        
        if(currentChoice == 1){
            System.exit(0);
        }
    }    
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
    }
    
    
    public void keyReleased(int k){
        
    }
    

    
}
