package electionObservers;

import java.util.ArrayList;

public interface IElectoralVote {

	/*for each state separately:
	returns array of char = D/R = whichever side the votes will go to
	Array is parallel to the ArrayList<USstate> states in the
	observable (and obviously to the ones pulled by the observers)
	*/
	public ArrayList<Character> stateEVote(ArrayList<USstate> states);
	
	//all together, how many will each side have
	public Long allTogDem(ArrayList<USstate> states);
	public Long allTogRep(ArrayList<USstate> states);
	
	
}
