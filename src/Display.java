import java.awt.*;

public class Display {

    private int rows;
    private int columns;
    private Colours[][] colours;
    private Robot robot = new Robot();

    public Display() throws AWTException {
        //checking dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        String screen = screenSize.toString();

        int xAxis = Integer.parseInt(screen.substring(screen.indexOf("=")+1, screen.indexOf(",") ) );
        int yAxis = Integer.parseInt(screen.substring(screen.lastIndexOf("=")+1, screen.lastIndexOf("]") ) );

        setColumns(xAxis);
        setRows(yAxis);

        System.out.println("xAxis: " + xAxis);
        System.out.println("yAxis: " + yAxis);

    }



    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    /** getRobot() method
     *
     * @return robot object to be used across classes
     */

    public Robot getRobot() {
        return robot;
    }

    public String toString() {
        return "xAxis: " + getColumns() + " yAxis: " + getRows();
    }

//    public void setUpToString() {
//        System.out.println("setting up... do not touch mouse... calibrating screen pixel dimensions");
//    }
}
