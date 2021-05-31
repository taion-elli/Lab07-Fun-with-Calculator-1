package Ü3;
/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class CalculatorHex
{
    private CalcEngine engineDec;
    private CalcEngine engineHex;
    private UserInterface gui;
    
    public static void main(String[] args) {
    	CalculatorHex c = new CalculatorHex();
    }

    /**
     * Create a new calculator and show it.
     */
    public CalculatorHex()
    {
    	engineDec = new CalcEngine();
        engineHex = new HexCalcEngine();
        gui = new UserInterfaceHex(engineHex, engineDec);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
