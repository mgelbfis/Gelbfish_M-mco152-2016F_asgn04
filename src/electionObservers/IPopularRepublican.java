package electionObservers;

import java.util.ArrayList;
import java.lang.Math;

public class IPopularRepublican implements IPopularVote{

	@Override
	public ArrayList<Long> stateRepVote(ArrayList<USstate> states) 
	{
		//parallel to names of states
		ArrayList<Long> stateVotes = new ArrayList<Long>();
		for(USstate u: states){
			stateVotes.add(u.getRepVotes());
		}
		return stateVotes;
	}

	@Override
	public ArrayList<Long> stateDemVote(ArrayList<USstate> states) 
	{
		//parallel to names of states
		ArrayList<Long> stateVotes = new ArrayList<Long>();
		for(USstate u: states){
			stateVotes.add(Math.round(u.getDemVotes()*.95));
		}
		return stateVotes;
	}

	@Override
	public Long allTogetherRep(ArrayList<USstate> states) 
	{
		Long allVotes = 0L;
		for(USstate u: states){
			allVotes += u.getRepVotes();
		}
		return allVotes;
	}

	@Override
	public Long allTogetherDem(ArrayList<USstate> states) {
		Long allVotes = 0L;
		for(USstate u: states){
			allVotes += u.getDemVotes();
		}
		return Math.round(allVotes*.95);
	}

}
