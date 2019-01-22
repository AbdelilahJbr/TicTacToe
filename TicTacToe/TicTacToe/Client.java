package TicTacToe;

import javax.swing.JOptionPane;



import jade.core.AID;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;
import jade.wrapper.PlatformController;

public class Client extends Agent {
	
	private WindowGame frame;
    public AID opponentAid;
    
	@Override
	protected void setup() {
		
		choiceGui myGui = new choiceGui();
		myGui.showGui();
	}
	
	 public void createOpponentAgent(Object[] arg)
	    {
		 System.out.println("in client header: " +arg[0]);
	        String agentName="myOpponent";
	        	        
	        
	        
	        Runtime rt=Runtime.instance();
	        AgentController ac;
	        ContainerController cc;
	        Profile p = new ProfileImpl();
	        cc=rt.createMainContainer(p);	        
	        try
	        {System.out.println("in client befor creating : " +arg[0]);
	        
	            cc.createNewAgent(agentName, Opponent.class.getName(), arg).start();
	            System.out.println("in client: " +arg[0]);
	           /* String mainName=getName();
	            int index=mainName.indexOf('@');
	            String tail=mainName.substring(index);
	            agentName+=tail;
	            opponentAid=new AID(agentName, AID.ISGUID);*/
	        }
	        catch (ControllerException ex)
	        {
	            JOptionPane.showMessageDialog(frame, "An Error While Creating Opponent Agent Occured\n\n"+ex.getLocalizedMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	        }
	    }
	

}
