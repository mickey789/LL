package GameState;

public class GameStateManager {
    
    private GameState[] gameStates;
    private int currentState;
    private int previousState;
    
    public static final int NUM_STATES = 4;
    public static final int INTROSTATE = 0; 
    public static final int MENUSTATE = 1;
    public static final int OPENINGSTATE = 2; 
    public static final int FIRSTSTATE = 3; 
    
    public GameStateManager()
    {
        gameStates = new GameState[NUM_STATES];
        setCurrentState(INTROSTATE);  
    }
    
    public void setCurrentState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == INTROSTATE) {
			gameStates[i] = new IntroState(this);
			gameStates[i].update();
		}
		else if(i == MENUSTATE) {
			gameStates[i] = new MenuState(this);
			gameStates[i].update();
		}
                else if(i == OPENINGSTATE) {
			gameStates[i] = new OpeningState(this);
			gameStates[i].update();
		}
                else if(i == FIRSTSTATE) {
			gameStates[i] = new FirstState(this);
			gameStates[i].update();
		}
	}
    
    public void unloadState(int i) {
	gameStates[i] = null;
    }
    
    public void update()
    {
        if(gameStates[currentState] != null) {
            gameStates[currentState].update();
	}
    }
    
    public void draw(java.awt.Graphics2D g)
    {
        if(gameStates[currentState] != null) {
            gameStates[currentState].draw(g);
	}
    }
    
    public void keyPressed(int k) {
	gameStates[currentState].keyPressed(k);
    }
	
    public void keyReleased(int k) {
	gameStates[currentState].keyReleased(k);
    }
    
    public void handler(){
        
    }
    
}
