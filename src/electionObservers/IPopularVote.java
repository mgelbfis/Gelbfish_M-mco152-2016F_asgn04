package electionObservers;

import java.util.ArrayList;

public interface IPopularVote {
	
	
	
	/*for each state separately:
	return arrays with the number of votes per state that 
	are parallel to the ArrayList<USstate> states in the
	observable (and obviously to the ones pulled by the observers)
	*/
	public ArrayList<Long> stateRepVote(ArrayList<USstate> states);
	public ArrayList<Long> stateDemVote(ArrayList<USstate> states);
	
	//for all states together
	public Long allTogetherRep(ArrayList<USstate> states);
	public Long allTogetherDem(ArrayList<USstate> states);

}
