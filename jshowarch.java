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
