package rockpaperscissors.view;

import javax.swing.JFrame;

import rockpaperscissors.controller.RPSController;

public class RPSFrame extends JFrame
{
	private RPSPanel basePanel;

	public RPSFrame(RPSController baseController)
	{
		basePanel = new RPSPanel(baseController);
		
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setResizable(false);
		setVisible(true);
	}
}
