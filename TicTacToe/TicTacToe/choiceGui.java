package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import TicTacToe.WindowGame.Mode;



public class choiceGui extends JFrame{


	private String level;
	private String algo;
	private int width; 
	private int i;
	private Client clientAgent=new Client();
	public choiceGui(){
		
		JLabel gameLevel  = new JLabel("Choose gameLevel");
		JLabel algorithm = new JLabel("algorithm");
		JButton playButton=new JButton("play");

		JComboBox<String> levels = new JComboBox<>();
		levels.addItem("3");
		levels.addItem("4");
		levels.addItem("5");
		levels.setPreferredSize(new Dimension(110,30));
		JComboBox<String> algorithms = new JComboBox<>();
		algorithms.addItem("MinMax");
		algorithms.addItem("alphaBeta");
		algorithms.setPreferredSize(new Dimension(110,30));
		
		JLabel background =null ;
		setLayout(new BorderLayout());
		java.net.URL imgURL = getClass().getResource("..\\Assets\\imageFinal.PNG");
		if (imgURL != null) {
			 background=new JLabel(new ImageIcon(imgURL));
	    } else {
	        System.err.println("Couldn't find file: ");
	    }
		
		add(background);
		background.setLayout(new FlowLayout(FlowLayout.LEFT,250,29));
		background.add(levels);
		background.add(algorithms);
		//playButton.setAlignmentX(CENTER_ALIGNMENT);
		background.add(playButton);

		playButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				try
				{
					 level = String.valueOf(levels.getSelectedItem());
					 algo= String.valueOf(algorithms.getSelectedItem());
					 if("3".equals(level)){
						 width = 450 ;
						 i=0;
					 }else if("4".equals(level)){
						 width=600;
						 i=1;
					 }
					 else {
						 width=750;
						 i=2;
					 }
				
					 dispose();
			         //SwingUtilities.invokeLater(() -> new WindowGame(Mode.AI,level,algo,width,i));
					 Object[] arg = new Object[5];
					 arg[0]=Mode.AI;
					 arg[1]=level;
					 arg[2]=algo;
					 arg[3]=width;
					 arg[4]=i;
					 System.out.println("in args: " +arg[0]);
					 System.out.println("in args: " +arg[1]);
					 System.out.println("in args: " +arg[2]);
					 System.out.println("in args: " +arg[3]);
					 System.out.println("in args: " +arg[4]);
					 clientAgent.createOpponentAgent(arg);
					 
			         
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(choiceGui.this,"Invalid values. " + e.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
		
	}
	
	public String getLevel() {
		return level;
	}

	public String getAlgo() {
		return algo;
	}
		
	public void showGui()
	{
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) screenSize.getWidth() / 2;
		int centerY = (int) screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2,centerY - getHeight() / 2);
		super.setVisible(true);
	}
	
	
}
