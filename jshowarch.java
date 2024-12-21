import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class jshowarch
{
    static int startx = 600;
    static int starty = 200;
    static int width = 400;
    static int height = 200;
    static int fontsize = 30;

    public static void main(String argv[])
    {
      Frame f = new Frame("jshowarch");

      f.addWindowListener(
        new WindowAdapter(){
          public void windowClosing(WindowEvent e){ System.exit(0); }
        }
      );

      try
      {
        if (argv.length > 0)
        {
          // cmd line args need to be: xpos ypos width height fontsize
          // in this order!
          startx = Integer.valueOf(argv[0]);
          System.out.println("argv[0]=" + argv[0]);
          starty = Integer.valueOf(argv[1]);
          System.out.println("argv[1]=" + argv[1]);
          width = Integer.valueOf(argv[2]);
          System.out.println("argv[2]=" + argv[2]);
          height = Integer.valueOf(argv[3]);
          System.out.println("argv[3]=" + argv[3]);
          fontsize = Integer.valueOf(argv[4]);
          System.out.println("argv[4]=" + argv[4]);
        }
      }
      catch(Exception e)
      {
      }

      JPanel p = new JPanel(); 
      p.setLayout(new GridBagLayout());

      JTextField text = new JTextField() {
        @Override public void setBorder(Border border) {
            // No Border
        }
      };
      text.setEditable(false);
      text.setHorizontalAlignment(JTextField.CENTER);
      Color color_transparent = new Color(0, 0, 0, 0);
      text.setBackground(color_transparent);

      String or_arch = System.getProperty("os.arch");

      Font font1 = new Font("Verdana", Font.BOLD, fontsize);
      text.setFont(font1);

      text.setText(or_arch);

      p.add(text, new GridBagConstraints());

      f.add(p);
      f.setLocation(startx, starty);
      f.setSize(width, height);
      f.setVisible(true);
    }
}
