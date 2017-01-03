package electionObservers;

import java.util.ArrayList;

public class IElectoral2PercToDem implements IElectoralVote{

	@Override
	public ArrayList<Character> stateEVote(ArrayList<USstate> states) {
		
		ArrayList<Character> electoral = new ArrayList<Character>();
				
		for(USstate u: states)
		{
			if((u.getDemVotes()+(u.getRepVotes()*.02))
					>(u.getRepVotes()*.98))
			{
				electoral.add('D');
			}
			else if((u.getDemVotes()+(u.getRepVotes()*.02))
					<(u.getRepVotes()*.98))
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
				if((u.getDemVotes()+(u.getRepVotes()*.02))
						>(u.getRepVotes()*.98))
				{
					allElectoral += u.getElectoralVotes();
				}
				//if equal, doesn't count anywhere
		}
		return allElectoral;
	}

	@Override
	public Long allTogRep(ArrayList<USstate> states) {
		
		Long allElectoral = 0L;
		
		for(USstate u: states)
		{
			if((u.getDemVotes()+(u.getRepVotes()*.02))
					<(u.getRepVotes()*.98))
			{
				allElectoral += u.getElectoralVotes();
			}
		}
		return allElectoral;
	}

	
}
