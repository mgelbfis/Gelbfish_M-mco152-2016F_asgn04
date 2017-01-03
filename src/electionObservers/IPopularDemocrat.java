package electionObservers;

import java.util.ArrayList;

public class IPopularDemocrat implements IPopularVote{

	/*
	 NOTICE: this strategy ignores the state with the most
	 Republican votes when calculating the total vote, but 
	 still includes the state when it lists each state separately
		The instructions didn't sound like this strategy was meant 
		to be used when reporting states separately. 
	 */
	
	@Override
	public ArrayList<Long> stateRepVote(ArrayList<USstate> states) {
		//parallel to names of states
		ArrayList<Long> stateVotes = new ArrayList<Long>();
		for(USstate u: states)
		{
				stateVotes.add(u.getRepVotes());
		}
		
		return stateVotes;
	}

	@Override
	public ArrayList<Long> stateDemVote(ArrayList<USstate> states) {
		//parallel to names of states
				ArrayList<Long> stateVotes = new ArrayList<Long>();
				for(USstate u: states){
					stateVotes.add(u.getDemVotes());
				}
				return stateVotes;
	}

	@Override
	public Long allTogetherRep(ArrayList<USstate> states) {
		Long allVotes = 0L;
		Long max = states.get(0).getRepVotes();
		for(USstate u: states){
			allVotes += u.getRepVotes();
			if(u.getRepVotes()>max)
			{
				max = u.getRepVotes();
			}
		}
		allVotes -= max;
		return allVotes;
	}

	@Override
	public Long allTogetherDem(ArrayList<USstate> states) {
		Long allVotes = 0L;
		for(USstate u: states){
			allVotes += u.getDemVotes();
		}
		return allVotes;
	}
	
}
