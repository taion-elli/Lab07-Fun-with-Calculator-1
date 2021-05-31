import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * A user interface for the calculator. It can display Hexadecimal numbers.
 * @author Elisa
 * @version 31/05/2021
 *
 */

public class UserInterfaceHex extends UserInterface {
	
	public UserInterfaceHex(CalcEngine engine) {
		super(engine);
		
	}
	
	/**
	 * Make a frame that displays the numbers from 0 to F in Hexadecimal 
	 * and the same operators from its superclass method
	 * @author Elisa
	 */
	@Override
	protected void makeFrame() {
		
		frame = new JFrame(calc.getTitle());
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
			addButton(buttonPanel, "A");
			addButton(buttonPanel, "B");
			addButton(buttonPanel, "C");
			addButton(buttonPanel, "+");
			
			addButton(buttonPanel, "D");
			addButton(buttonPanel, "E");
			addButton(buttonPanel, "F");
			addButton(buttonPanel, "-");
			
			addButton(buttonPanel, "7");
			addButton(buttonPanel, "8");
			addButton(buttonPanel, "9");
			addButton(buttonPanel, "del");
			
			addButton(buttonPanel, "4");
			addButton(buttonPanel, "5");
			addButton(buttonPanel, "6");
			addButton(buttonPanel, "?");
			
			addButton(buttonPanel, "1");
			addButton(buttonPanel, "2");
			addButton(buttonPanel, "3");
			addButton(buttonPanel, "*");
			
			addButton(buttonPanel, "%");
			addButton(buttonPanel, "0");
			addButton(buttonPanel, "/");
			addButton(buttonPanel, "=");
			
			contentPane.add(buttonPanel, BorderLayout.CENTER);
			
			status = new JLabel(calc.getAuthor());
			contentPane.add(buttonPanel, BorderLayout.SOUTH);
			
			frame.pack();
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if(command.equals("0") ||
		           command.equals("1") ||
		           command.equals("2") ||
		           command.equals("3") ||
		           command.equals("4") ||
		           command.equals("5") ||
		           command.equals("6") ||
		           command.equals("7") ||
		           command.equals("8") ||
		           command.equals("9") ||
		           command.equals("A") ||
		           command.equals("B") ||
		           command.equals("C") ||
		           command.equals("D") ||
		           command.equals("E") ||
		           command.equals("F")) {
			
			//the 16 here makes the method parseInt convert the command from hex -> dec
			int number = Integer.parseInt(command, 16);
			calc.numberPressed(number);
		}
		else if(command.equals("+")) {
            calc.plus();
        }
        else if(command.equals("-")) {
            calc.minus();
        }
        //check if * was pressed -Elisa
        else if(command.equals("*")) {
        	calc.multiply();
        }
        //check if / was pressed -Elisa
        else if(command.equals("/")) {
        	calc.divide();
        }
        //check if % was pressed -Elisa
        else if(command.equals("%")) {
        	calc.modulo();
        }
        else if(command.equals("=")) {
            calc.equals();
        }
        else if(command.equals("del")) {
            calc.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
			redisplay();
		
		           
		
	}
	
	@Override
	protected void redisplay() {
		int hexInput = calc.getDisplayValue();
		
		display.setText("" + Integer.toHexString(hexInput).toUpperCase());
		}
	}
	
	


