package rockpaperscissors.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import rockpaperscissors.controller.RPSController;

public class RPSPanel extends JPanel
{
	private RPSController baseCotroller;
	private SpringLayout startLayout;
	private JButton rockButton;
	private JButton scissorsButton;
	private JButton paperButton;
	private JLabel userChoiceLabel;
	private JLabel aiChoiceLabel;
	private JLabel currentResultLabel;
	private JLabel statsLabel;
	private String[] aiChoices;
	private int numberOfWins;
	private int numberOfLosses;
	private int numberOfTies;
	
	
	public RPSPanel(RPSController baseController)
	{
		this.baseCotroller = baseController;
		numberOfWins = 0;
		numberOfLosses = 0;
		numberOfTies = 0;
		aiChoices = new String[3];
		aiChoices[0] = "Rock";
		aiChoices[1] = "Paper";
		aiChoices[2] = "Scissors";
		
		startLayout = new SpringLayout();
		rockButton = new JButton("Rock");
		scissorsButton = new JButton("Scissors");
		paperButton = new JButton("Paper");
		userChoiceLabel = new JLabel("Me");
		aiChoiceLabel = new JLabel("Computer");
		currentResultLabel = new JLabel("");
		statsLabel = new JLabel("Number of Wins:" + Integer.toString(numberOfWins) + "     " + "Number Of Losses:" + Integer.toString(numberOfLosses) + "     " + "Number Of Ties:" + Integer.toString(numberOfTies));

		
		setupPanel();
		setupLayout();
		setupListners();
	}
	
	public void setupPanel()
	{
		this.setSize(500, 500);
		this.setFocusable(true);
		this.setLayout(startLayout);
		this.add(rockButton);
		this.add(scissorsButton);
		this.add(paperButton);
		this.add(userChoiceLabel);
		this.add(aiChoiceLabel);
		this.add(currentResultLabel);
		this.add(statsLabel);
	}
	
	public void setupLayout()
	{
		startLayout.putConstraint(SpringLayout.EAST, scissorsButton, -25, SpringLayout.EAST, this);
		startLayout.putConstraint(SpringLayout.NORTH, rockButton, 0, SpringLayout.NORTH, scissorsButton);
		startLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 0, SpringLayout.NORTH, paperButton);
		startLayout.putConstraint(SpringLayout.WEST, paperButton, 212, SpringLayout.WEST, this);
		startLayout.putConstraint(SpringLayout.SOUTH, paperButton, -10, SpringLayout.SOUTH, this);
		startLayout.putConstraint(SpringLayout.WEST, userChoiceLabel, 140, SpringLayout.WEST, this);
		startLayout.putConstraint(SpringLayout.NORTH, aiChoiceLabel, 0, SpringLayout.NORTH, userChoiceLabel);
		startLayout.putConstraint(SpringLayout.EAST, aiChoiceLabel, -147, SpringLayout.EAST, this);
		startLayout.putConstraint(SpringLayout.WEST, currentResultLabel, 0, SpringLayout.WEST, paperButton);
		startLayout.putConstraint(SpringLayout.WEST, rockButton, 10, SpringLayout.WEST, this);
		startLayout.putConstraint(SpringLayout.NORTH, currentResultLabel, 122, SpringLayout.SOUTH, statsLabel);
		startLayout.putConstraint(SpringLayout.NORTH, userChoiceLabel, 213, SpringLayout.SOUTH, statsLabel);
		startLayout.putConstraint(SpringLayout.NORTH, statsLabel, 46, SpringLayout.NORTH, this);
		startLayout.putConstraint(SpringLayout.WEST, statsLabel, 95, SpringLayout.WEST, this);
	}
	
	public void setupListners()
	{
		rockButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				userChoiceLabel.setText("Me: " + "Rock");
				int randomPosition = (int) (Math.random()*3);
				String aiCurrentChoice = aiChoices[randomPosition];
				aiChoiceLabel.setText("Computer: " + aiCurrentChoice);
				if(aiCurrentChoice.equals("Rock"))
				{
					numberOfTies++;
					currentResultLabel.setText("You tied");
				}
				else if(aiCurrentChoice.equals("Paper"))
				{
					numberOfLosses++;
					currentResultLabel.setText("You lost");
				}
				else if(aiCurrentChoice.equals("Scissors"))
				{
					numberOfWins++;
					currentResultLabel.setText("You won");
				}
				statsLabel.setText("Number of Wins:" + Integer.toString(numberOfWins) + "     " + "Number Of Losses:" + Integer.toString(numberOfLosses) + "     " + "Number Of Ties:" + Integer.toString(numberOfTies));
			}
			
		});
		
		scissorsButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				userChoiceLabel.setText("Me: " + "Scissors");
				int randomPosition = (int) (Math.random()*3);
				String aiCurrentChoice = aiChoices[randomPosition];
				aiChoiceLabel.setText("Computer: " + aiCurrentChoice);
				if(aiCurrentChoice.equals("Rock"))
				{
					numberOfLosses++;
					currentResultLabel.setText("You lost");
				}
				else if(aiCurrentChoice.equals("Paper"))
				{
					numberOfWins++;
					currentResultLabel.setText("You won");
				}
				else if(aiCurrentChoice.equals("Scissors"))
				{
					numberOfTies++;
					currentResultLabel.setText("You tied");
				}
				statsLabel.setText("Number of Wins:" + Integer.toString(numberOfWins) + "     " + "Number Of Losses:" + Integer.toString(numberOfLosses) + "     " + "Number Of Ties:" + Integer.toString(numberOfTies));
			}
			
		});
		
		paperButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				userChoiceLabel.setText("Me: " + "Paper");
				int randomPosition = (int) (Math.random()*3);
				String aiCurrentChoice = aiChoices[randomPosition];
				aiChoiceLabel.setText("Computer: " + aiCurrentChoice);
				if(aiCurrentChoice.equals("Rock"))
				{
					numberOfWins++;
					currentResultLabel.setText("You won");
				}
				else if(aiCurrentChoice.equals("Paper"))
				{
					numberOfTies++;
					currentResultLabel.setText("You tied");
				}
				else if(aiCurrentChoice.equals("Scissors"))
				{
					numberOfLosses++;
					currentResultLabel.setText("You lost");
				}
				statsLabel.setText("Number of Wins:" + Integer.toString(numberOfWins) + "     " + "Number Of Losses:" + Integer.toString(numberOfLosses) + "     " + "Number Of Ties:" + Integer.toString(numberOfTies));
			}
			
		});
	}
}
