package GameState;

public class GameStateManager {
    
    private GameState[] gameStates;
    private int currentState;
    private int previousState;
    
//    public Door[] Door;
    private int currentDoor;
    
    public static final int NUM_STATES = 15;
    public static final int INTROSTATE = 0; 
    public static final int MENUSTATE = 1;
    public static final int OPENINGSTATE = 2; 
    public static final int FIRSTSTATE = 3; 
    public static final int STATE2 = 4;
    public static final int STATE3 = 5;
    public static final int STATE4 = 6;
    public static final int STATE5 = 7;
    public static final int STATE6 = 8;
    public static final int STATE7 = 9;
    public static final int STATE8 = 10;
    public static final int STATE9 = 11;
    public static final int STATE10 = 12;
    public static final int STATE11 = 13;
    public static final int STATE12 = 14;
    
    
    
    public GameStateManager()
    {
        gameStates = new GameState[NUM_STATES];
        setCurrentState(INTROSTATE);  
        
//        Door = new Door[]
    }
//    
//    public void setCurrentDoor(int i){
//        currentDoor = i;
//        if(i == INTROSTATE){
//            currentDoor[i] = new currentDoor(this);
//        }
//        
//        
//    }
    
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
		}else if(i == STATE2) {
			gameStates[i] = new State2(this);
			gameStates[i].update();
		}else if(i == STATE3) {
			gameStates[i] = new State3(this);
			gameStates[i].update();
		}else if(i == STATE4) {
			gameStates[i] = new State4(this);
			gameStates[i].update();
		}else if(i == STATE5) {
			gameStates[i] = new State5(this);
			gameStates[i].update();
		}else if(i == STATE6) {
			gameStates[i] = new State6(this);
			gameStates[i].update();
		}else if(i == STATE7) {
			gameStates[i] = new State7(this);
			gameStates[i].update();
		}else if(i == STATE8) {
			gameStates[i] = new State8(this);
			gameStates[i].update();
		}else if(i == STATE9) {
			gameStates[i] = new State9(this);
			gameStates[i].update();
		}else if(i == STATE10) {
			gameStates[i] = new State10(this);
			gameStates[i].update();
		}else if(i == STATE11) {
			gameStates[i] = new State11(this);
			gameStates[i].update();
		}else if(i == STATE12) {
			gameStates[i] = new State12(this);
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
