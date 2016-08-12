
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UIPractice extends JFrame{

JButton calculateButton;
JLabel num1Label, num2Label, howManyLabel;
JTextField inputNum1, inputNum2;
JCheckBox dollars, commas;
JRadioButton add, sub, mult, div;
JSlider howMany;

double num1, num2, num3;
	
public static void main(String[] args)
{
 new UIPractice();
}

public UIPractice()
{	
	//The Panel
	JPanel mainPanel = new JPanel();

	//Number Panel
	JPanel inputPanel = new JPanel();
	Border inputBorder = BorderFactory.createTitledBorder("Number Calculator!");
	
	inputPanel.setBorder(inputBorder);	
	num1Label = new JLabel("Number 1:");
		inputPanel.add(num1Label);
	inputNum1 = new JTextField("", 5);
		inputPanel.add(inputNum1);
	num2Label = new JLabel("Number 2:");
		inputPanel.add(num2Label);
	inputNum2 = new JTextField("", 5);
		inputPanel.add(inputNum2);
	
	//Format Panel
	JPanel formatPanel = new JPanel();
	Border formatBorder = BorderFactory.createTitledBorder("Format");
		formatPanel.setBorder(formatBorder);
	dollars = new JCheckBox("Dollars");
		formatPanel.add(dollars);
	commas = new JCheckBox("Commas");
		formatPanel.add(commas, true); //this makes it selected by default
	
	//Operation Panel
	add = new JRadioButton("Add");
	sub = new JRadioButton("Subtract");
	mult = new JRadioButton("Multiply");
	div = new JRadioButton("Divide");
		ButtonGroup operation = new ButtonGroup();
			operation.add(add);
			operation.add(sub);
			operation.add(mult);
			operation.add(div);
	JPanel operPanel = new JPanel();
	Border operationsBorder = BorderFactory.createTitledBorder("Operation");
		operPanel.setBorder(operationsBorder);
		operPanel.add(add);
		operPanel.add(sub);
		operPanel.add(mult);
		operPanel.add(div);
	add.setSelected(true);
	
	//BUTTON
	ButtonHandler BH = new ButtonHandler();
	calculateButton = new JButton("Calculate");
	calculateButton.addActionListener(BH);
	
	//Add all panels
	mainPanel.add(inputPanel);
	mainPanel.add(formatPanel);
	mainPanel.add(operPanel);
	mainPanel.add(calculateButton);

	//Define Window
	this.setSize(400,225);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Practice UI");
	this.setResizable(false);
	this.add(mainPanel);
	this.setVisible(true);
}

public class ButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			num1 = Double.parseDouble(inputNum1.getText());
			num2 = Double.parseDouble(inputNum2.getText());
		}
		catch(NumberFormatException excep)
		{
			JOptionPane.showMessageDialog(UIPractice.this, "Please Enter a Number", "Error", JOptionPane.ERROR_MESSAGE);
			inputNum1.setText("");
			inputNum2.setText("");
		}
		
		if(add.isSelected())
		{
			num3 = (num1+num2);
		}
		else if(sub.isSelected())
		{
			num3 = (num1-num2);
		}
		else if(mult.isSelected())
		{
			num3 = (num1*num2);
		}
		else if(div.isSelected())
		{
			num3 = (num1/num2);
		}
		
		if(dollars.isSelected())
		{
			NumberFormat numFormat = NumberFormat.getCurrencyInstance();
			JOptionPane.showMessageDialog(UIPractice.this, numFormat.format(num3), "Solution", JOptionPane.INFORMATION_MESSAGE);;
		}
		else if(commas.isSelected())
		{
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			JOptionPane.showMessageDialog(UIPractice.this, numFormat.format(num3), "Solution", JOptionPane.INFORMATION_MESSAGE);;
		}	
		else
		{
			JOptionPane.showMessageDialog(UIPractice.this, num3, "Solution", JOptionPane.INFORMATION_MESSAGE);;
		}
	}
}
}
