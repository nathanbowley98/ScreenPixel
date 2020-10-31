import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.lang.Thread;

/**
 * author: Nathanael Bowley
 * Github: @nathanbowley98
 * detects the color of a specific pixel on the monitor.
 */
public class Screen implements Runnable, KeyListener {
    public JLabel frameLabel;
    private static boolean escape;
    private static JFrame frame;

    public Screen() {
        frame = new JFrame("test");
        frame.setLayout(new FlowLayout());
        frame.setSize(220,90);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("please work");
        button.addKeyListener(this);
        frame.add(button);
        frameLabel = new JLabel("Press a button.");
        frame.setVisible(true);

        escape = false;
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Up")) {
            frameLabel.setText("it worked");
        }
        else {
            frameLabel.setText("idk");
        }
    }

    public static void main(String[] args) throws InterruptedException, AWTException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Screen();
            }
        });

        Display display = new Display();
        Robot robot = display.getRobot();


        while (true) {
            PointerInfo mouse = MouseInfo.getPointerInfo();
            java.awt.Point mousePosition = mouse.getLocation();

            String point = mousePosition.toString();
            String xAxis = point.substring(point.indexOf("=")+1, point.indexOf(",") );
            String yAxis = point.substring(point.lastIndexOf("=")+1, point.lastIndexOf("]") );

            System.out.println("xAxis: " + xAxis + "\n" + "yAxis: " + yAxis);

            Color pixelColor = robot.getPixelColor(Integer.parseInt(xAxis), Integer.parseInt(yAxis));
            System.out.println(pixelColor);

//            if (KeyEvent.KEY_PRESSED() && KeyEvent.VK_O) {
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            }
            //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            Thread.sleep(100);

           // KEY_PRESSED
            //KEY_TYPED (is only generated if a valid Unicode character could be generated.)
            //KEY_RELEASED

            if (getEscape()) {
//                for (int i = 0; i<1000; i++) {
//                    getFrame().setVisible(false);
//                    //updateFrameLabel(i);
//                    getFrame().setVisible(true);
//                }
                getFrame().setVisible(false);
                break;
            }

        }

        //display.toString();

        //Color pixelColor = getPixelColor(int x, int y);
    }


    @Override
    public void run() {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //not using
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //not using
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        System.out.println(keyCode);
        if (keyCode == KeyEvent.VK_L) {
            System.out.println("keyReleased worked so thats cool!");
            setEscape(true);
        }
    }

    public void setEscape(boolean condition) {
        escape = condition;
    }

    public static boolean getEscape() {
        return escape;
    }
    public static JFrame getFrame() {
        return frame;
    }

//    public static void updateFrameLabel(int i) {
//        frameLabel.setText(String.valueOf(i));
//    }


}
