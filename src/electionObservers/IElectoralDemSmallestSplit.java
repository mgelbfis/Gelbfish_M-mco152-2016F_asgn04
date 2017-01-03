package electionObservers;

import java.util.ArrayList;

public class IElectoralDemSmallestSplit implements IElectoralVote{

	public USstate findSmallestDemLead(ArrayList<USstate> states)
	{
		int index = 0;
		Long smallestLead = 0L;
		for(int i = 0; i < states.size(); i++){
			
			//just to minimize method calls
			Long temp = states.get(i).getDemVotes()
					-states.get(i).getRepVotes();
			
			if(temp > 0 && temp < smallestLead)
			{
				smallestLead = temp;
				index = i;
			}
				
		}
		return states.get(index);
	}
	
	@Override
	public ArrayList<Character> stateEVote(ArrayList<USstate> states) {
		
		ArrayList<Character> electoral = new ArrayList<Character>();

		USstate smLd = findSmallestDemLead(states);
		
		for(USstate u: states)
		{
			if(u.equals(smLd))
			{
				electoral.add('=');
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
		
		USstate smLd = findSmallestDemLead(states);
		
		for(USstate u: states)
		{
			if(u.equals(smLd)){
				allElectoral += u.getElectoralVotes()/2; 
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
	
		USstate smLd = findSmallestDemLead(states);
		
		for(USstate u: states)
		{
			if(u.equals(smLd))
			{
				allElectoral += (u.getElectoralVotes()/2) + (u.getElectoralVotes()%2);
			}
			else if(u.getRepVotes()>u.getDemVotes())
			{
				allElectoral += u.getElectoralVotes();
			}
		}
		return allElectoral;
	}


}
