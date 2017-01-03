package electionObservers;

import java.util.ArrayList;

public class IElectoralStateAutoRep implements IElectoralVote{

	@Override
	public ArrayList<Character> stateEVote(ArrayList<USstate> states) {
		
		ArrayList<Character> electoral = new ArrayList<Character>();
				
		for(USstate u: states)
		{
			if(u.getName().equals("TX"))
			{
				electoral.add('R');
			}
			else if(u.getDemVotes()>u.getRepVotes())
			{
				electoral.add('D');
			}
			else if(u.getRepVotes()>u.getDemVotes())
			{
				electoral.add('R');
			}
			//if the votes are exactly equal, =, for equal chance
			else
			{
				electoral.add('=');
			}
		}
		
		return electoral;
	}

	@Override
	public Long allTogDem(ArrayList<USstate> states) {
		Long allElectoral = 0L;
		for(USstate u: states)
		{
			if(!(u.getName().equals("TX")))
			{
				
				if(u.getDemVotes()>u.getRepVotes())
				{
					allElectoral += u.getElectoralVotes();
				}
				//if equal, doesn't count anywhere
			}	
		}
		return allElectoral;
	}

	@Override
	public Long allTogRep(ArrayList<USstate> states) {
		
		Long allElectoral = 0L;
	
		
		for(USstate u: states)
		{
			if(u.getName().equals("TX"))
			{
				allElectoral += u.getElectoralVotes();
			}	
			
			else if(u.getRepVotes()>u.getDemVotes())
			{
				allElectoral += u.getElectoralVotes();
			}
		}
		return allElectoral;
	}

}

