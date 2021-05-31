package Ü3;

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
 * 
 * @author Elisa
 * @version 31/05/2021
 *
 */

public class UserInterfaceHex extends UserInterface {

	private boolean hex = true;
	private JPanel contentPane;

	public UserInterfaceHex(CalcEngine engineHex, CalcEngine engineDec) {
		super(engineHex, engineDec); 
	}

	/**
	 * Make a frame that displays the numbers from 0 to F in Hexadecimal and the
	 * same operators from its superclass method
	 * 
	 * @author Elisa
	 */
	@Override
	protected void makeFrame() {

		frame = new JFrame(calc.getTitle());

		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = getButtonPenel();

		contentPane.add(buttonPanel, BorderLayout.CENTER);

		// status = new JLabel(calc.getAuthor());
		// contentPane.add(buttonPanel, BorderLayout.SOUTH);

		frame.pack();
	}

	private JPanel getButtonPenel() {
		JPanel buttonPanel;
		if (hex) {
			buttonPanel = new JPanel(new GridLayout(6, 4));
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
			addButton(buttonPanel, "DEL");

			addButton(buttonPanel, "4");
			addButton(buttonPanel, "5");
			addButton(buttonPanel, "6");
			addButton(buttonPanel, "DEC");

			addButton(buttonPanel, "1");
			addButton(buttonPanel, "2");
			addButton(buttonPanel, "3");
			addButton(buttonPanel, "x");

			addButton(buttonPanel, "%");
			addButton(buttonPanel, "0");
			addButton(buttonPanel, ":");
			addButton(buttonPanel, "=");
		} else {
			buttonPanel = new JPanel(new GridLayout(5, 4));
			addButton(buttonPanel, "7");
			addButton(buttonPanel, "8");
			addButton(buttonPanel, "9");
			addButton(buttonPanel, "DEL");

			addButton(buttonPanel, "4");
			addButton(buttonPanel, "5");
			addButton(buttonPanel, "6");
			addButton(buttonPanel, "HEX");

			addButton(buttonPanel, "1");
			addButton(buttonPanel, "2");
			addButton(buttonPanel, "3");
			// add button for * -Elisa
			addButton(buttonPanel, "x");

			addButton(buttonPanel, "0");
			addButton(buttonPanel, "+");
			addButton(buttonPanel, "-");
			addButton(buttonPanel, "=");

			addButton(buttonPanel, ":");
			addButton(buttonPanel, "%");
		}

		return buttonPanel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (hex) {
			if (command.equals("0") || 
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
				command.equals("F"))
			{
				// the 16 here makes the method parseInt convert the command from hex -> dec
				int number = Integer.parseInt(command, 16);
				calc.numberPressed(number);
			} 
			else if (command.equals("+")) {
				calc.plus();
			} 
			else if (command.equals("-")) {
				calc.minus();
			}
			// check if * was pressed -Elisa
			else if (command.equals("x")) {
				calc.multiply();
			}
			// check if / was pressed -Elisa
			else if (command.equals(":")) {
				calc.divide();
			}
			// check if % was pressed -Elisa
			else if (command.equals("%")) {
				calc.modulo();
			} 
			else if (command.equals("=")) {
				calc.equals();
			} 
			else if (command.equals("DEL")) {
				calc.clear();
			} 
			else if (command.equals("DEC")) {
				switchSystem();
			}

		} else {
			// super.actionPerformed(event);
			if (command.equals("0") || 
				command.equals("1") || 
				command.equals("2") || 
				command.equals("3") || 
				command.equals("4") || 
				command.equals("5") || 
				command.equals("6") || 
				command.equals("7") || 
				command.equals("8") ||
				command.equals("9")) 
			{
				int number = Integer.parseInt(command);
				calc2.numberPressed(number);
			} 
			else if (command.equals("+")) {
				calc2.plus();
			} else if (command.equals("-")) {
				calc2.minus();
			}
			// check if * was pressed -Elisa
			else if (command.equals("x")) {
				calc2.multiply();
			}
			// check if / was pressed -Elisa
			else if (command.equals(":")) {
				calc2.divide();
			}
			// check if % was pressed -Elisa
			else if (command.equals("%")) {
				calc2.modulo();
			} 
			else if (command.equals("=")) {
				calc2.equals();
			} 
			else if (command.equals("DEL")) {
				calc2.clear();
			}
			else if (command.equals("HEX")) {
				switchSystem();
			}

		}

		redisplay();
	}

	@Override
	protected void redisplay() {
		if (hex) {
			int hexInput = calc.getDisplayValue();
			display.setText("" + Integer.toHexString(hexInput).toUpperCase());
		} else {
			display.setText("" + calc.getDisplayValue());
		}
	}

	private void switchSystem() {
		JPanel buttonPanel = getButtonPenel();
		if (hex) {
			contentPane.remove(buttonPanel);
			hex = false;
			contentPane.add(buttonPanel, BorderLayout.CENTER);
		}	
		else {
			contentPane.remove(buttonPanel);
			hex = true;
			contentPane.add(buttonPanel, BorderLayout.CENTER);
		}
	}

}
