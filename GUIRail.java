import javax.swing.*;
import java.awt.event.*;  

/*
 * Program created to calculate various Minecraft things.
 * By Cabe and Joe
 */

public class GUIRail implements ActionListener
{
	JFrame frame;
	
	JTextField x1, x2, z1, z2;
	
	JLabel x1L, x2L, z1L, z2L;
	
	JButton runButton;
	JButton backButton;
	
	JTextArea result;
	
	private enum Actions 
	{
		RUN,
		BACK
	}
	
	public GUIRail()
	{
		frame = new JFrame();
		
		x1 = new JTextField();
		x1.setBounds(100, 50, 100, 20);
		
		z1 = new JTextField();
		z1.setBounds(100, 100, 100, 20);
		
		x2 = new JTextField();
		x2.setBounds(100, 200, 100, 20);
		
		z2 = new JTextField();
		z2.setBounds(100, 250, 100, 20);
		
		x1L = new JLabel("X Start:");
		x2L = new JLabel("X End:");

		z1L = new JLabel("Z Start:");
		z2L = new JLabel("Z End:");
		
		x1L.setBounds(50, 50, 100, 20);
		z1L.setBounds(50, 100, 100, 20);
		
		x2L.setBounds(50, 200, 100, 20);
		z2L.setBounds(50, 250, 100, 20);
		
		runButton = new JButton("Run");
		runButton.setBounds(100, 300, 100, 20);
		runButton.addActionListener(this);
		runButton.setActionCommand(Actions.RUN.name());
		
		result = new JTextArea();
		result.setBounds(100, 400, 600, 300);
		result.setEditable(false);
		
		backButton = new JButton("Back");
		backButton.setBounds(100, 725, 100, 20);
		backButton.addActionListener(this);
		backButton.setActionCommand(Actions.BACK.name());
		
		frame.add(x1);
		frame.add(x2);
		frame.add(z1);
		frame.add(z2);
		
		frame.add(x1L);
		frame.add(x2L);
		frame.add(z1L);
		frame.add(z2L);
		
		frame.add(runButton);
		frame.add(backButton);
		
		frame.add(result);
		
		frame.setTitle("Rail Calculator");
		frame.setSize(800, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(3);
	}
	
	public void calculateRails(int xStart, int xEnd, int zStart, int zEnd)
	{
		//int y1=0;
		//int y2=0;
		int totalBlocksMoved=(Math.abs(xStart-xEnd)+Math.abs(zStart-zEnd));
		int neededPRails = (int) Math.ceil(totalBlocksMoved/5) ;
		int neededRails = (4 * neededPRails) ;
		
		String calculations = "The rail you would like to build will cover a distance of: " + totalBlocksMoved + " blocks" +
				"\nIt will require " + neededRails  +" Rails and " + neededPRails + " Powered Rails." +
				"\nSo long as you use a slope of m=1/2 (y=mx+b)." + 
				"\nYou should place 1 Powered Rail between every 4 Normal Rails.";
		
		result.setText(calculations);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals(Actions.BACK.name()))
		{
			frame.setVisible(false);
			new GUIMain();
		}
		
		else if (e.getActionCommand().equals(Actions.RUN.name()))
		{
			String xB = x1.getText();
			String xE = x2.getText();
			
			String zB = z1.getText();
			String zE = z2.getText();
			
			int a = Integer.parseInt(xB);
			int b = Integer.parseInt(xE);
			
			int c = Integer.parseInt(zB);
			int d = Integer.parseInt(zE);
			
			calculateRails(a, b, c, d);
		}	
	}
}
