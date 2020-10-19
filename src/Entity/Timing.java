package Entity;

import java.util.Timer;
import java.util.TimerTask;

public class Timing {
    
    private Timer timer;
    
    protected int secondsPassed = 0;
    
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask(){
        public void run()
        {
            secondsPassed++;
            System.out.println(secondsPassed);
        }
    };
    
    public void Timing(){
        
    }
    
    public void start()
    {
        myTimer.schedule(task, 1000, 1000);
    }
    
    public void stop()
    {
        myTimer.cancel();
    }
    
    public int seconds()
    {
        return secondsPassed;
    }
}
