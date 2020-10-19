package lastlong;

import javax.swing.JFrame;

public class LastLong {

    public static void main(String[] args) {

        JFrame window = new JFrame("Last Long");
        window.setTitle("Last Long");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setContentPane(new GamePanel());
        
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
    
}
