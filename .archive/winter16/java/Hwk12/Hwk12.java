/**
 *  Chris Fenton
 *  Hwk12
 *  2/19/16
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Hwk12 {

  public static void main (String[] args) {
    ross();
    Sound.play();
  } // end main()


  public static void ross() {
    ImagePanel panel = new ImagePanel(new ImageIcon("ross.jpg").getImage());

    JFrame frame = new JFrame();
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }



} // end Hwk12 class
