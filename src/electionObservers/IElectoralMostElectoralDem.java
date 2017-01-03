package electionObservers;

import java.util.ArrayList;

public class IElectoralMostElectoralDem implements IElectoralVote {

	public USstate findMostElectoralVotes(ArrayList<USstate> states)
	{
		USstate mostElectoral = states.get(0);
	
		for(int i = 1; i<states.size(); i++)
		{
			if(states.get(i).getElectoralVotes()
					>mostElectoral.getElectoralVotes())
			{
				mostElectoral = states.get(i);
			}
		}
			
		return mostElectoral;
	}
	
	@Override
	public ArrayList<Character> stateEVote(ArrayList<USstate> states) {
		
		ArrayList<Character> electoral = new ArrayList<Character>();
	
		USstate mostElectoral = findMostElectoralVotes(states);
		
		for(USstate u: states)
		{
			if(u.equals(mostElectoral))
			{
				electoral.add('D');
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
		
		USstate mostElectoral = findMostElectoralVotes(states);
		
		for(USstate u: states)
		{
			if(u.equals(mostElectoral))
			{
				allElectoral += u.getElectoralVotes();
			}
			
			else if(u.getDemVotes()>u.getRepVotes())
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
	
		USstate mostElectoral = findMostElectoralVotes(states);
		
		for(USstate u: states)
		{
			if(!(u.equals(mostElectoral))){
				if(u.getRepVotes()>u.getDemVotes())
				{
					allElectoral += u.getElectoralVotes();
				}
			}
		}
		return allElectoral;
	}

	
	
}
