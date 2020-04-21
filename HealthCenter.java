
package healthcenter;

import javax.swing.JFrame;

public class HealthCenter {
    
   public static void main( String args[] ) {
        HealthCenterFrame healthFrame = new HealthCenterFrame(); // create MenuFrame
        healthFrame.pack();
        healthFrame.setLocationRelativeTo(null); //Locate the frame at the center of the screen
        healthFrame.setSize( 400, 200 ); // set frame size
        healthFrame.setVisible( true ); // display frame
        healthFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Stop running the program every time the user closes the program
    }
} 