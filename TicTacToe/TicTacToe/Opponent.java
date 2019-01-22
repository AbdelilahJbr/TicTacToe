package TicTacToe;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.wrapper.ControllerException;
import jade.wrapper.PlatformController;

public class Opponent extends Agent{
	@Override
	protected void setup() {
		
		//SwingUtilities.invokeLater(() -> new WindowGame(Mode.AI,level,algo,width,i));
		System.out.println("in opp :"+ this.getArguments()[0]);
		
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("playing");
		sd.setName("JADE-gamePlaying");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
		
		SwingUtilities.invokeLater(() -> new WindowGame(this.getArguments()));
		
	}
	protected void takeDown() {
		// Deregister from the yellow pages
		try {
			DFService.deregister(this);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
		// Close the GUI
		// Printout a dismissal message
		System.out.println("opponent-agent "+getAID().getName()+" terminating.");
	}
}
