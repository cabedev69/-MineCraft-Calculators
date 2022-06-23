import javax.swing.*;
import java.awt.event.*;  

public class GUIMain implements ActionListener
{
	JFrame frame;
	JButton railButton;
	JButton netherButton;
	
	private enum Actions 
	{
		RAILS,
		NETHER
	}
	
	public static void main(String[] args)
	{
		new GUIMain();
	}
	
	public GUIMain()
	{
		frame = new JFrame();
		
		railButton = new JButton("Rail Calculator");
		railButton.setBounds(100, 100, 150, 40);
		railButton.addActionListener(this);
		
		railButton.setActionCommand(Actions.RAILS.name());
		
		netherButton = new JButton("Nether Calculator");
		netherButton.setBounds(550, 100, 150, 40);
		netherButton.addActionListener(this);
		
		netherButton.setActionCommand(Actions.NETHER.name());
		
		
		frame.add(railButton);
		frame.add(netherButton);
		
		frame.setTitle("Minecraft Calculator");
		frame.setSize(800, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals(Actions.RAILS.name()))
		{
			frame.setVisible(false);
			new GUIRail();
		}
		if (e.getActionCommand().equals(Actions.NETHER.name()))
		{
			frame.setVisible(false);
			new GUINether();
		}
	}
	
}
