package GameState;

public abstract class GameState {
    
    protected GameStateManager gsm;
    protected static int door1 = 0;
    protected static int door2 = 0;
    protected static int door3 = 0;
    protected static int door4 = 0;
    protected static int door5 = 0;
    
    
    public abstract void update();
    public abstract void draw(java.awt.Graphics2D g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
    
    public void checkDoor1(int b) {door1 = b;}
    public void checkDoor2(int b) {door2 = b;}
    public void checkDoor3(int b) {door3 = b;}
    public void checkDoor4(int b) {door4 = b;}
    public void checkDoor5(int b) {door5 = b;}
   
}
