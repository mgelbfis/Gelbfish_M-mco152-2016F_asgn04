package electionObservers;

import java.util.ArrayList;
import java.util.Observable;

public class ElectionObservable extends Observable{

	private ArrayList<USstate> states;
	
	public ElectionObservable(ArrayList<USstate> states){
		this.states = new ArrayList<USstate>();
		for(USstate u: states)
		{
			this.states.add(u);
		}
	}
	
	public void votesChanged()
	{
		setChanged();
		notifyObservers();
	}
	
	//Was going to make this method take parallel arrays so it could take more than
	//one state at once, but figured usually not more than one state updating within a few seconds
	public void addVotes(String Name, Long addDemVotes, Long addRepVotes)
	{
		for(int i=0; i<states.size(); i++)
		{
			if(states.get(i).getName().equals(Name))
			{
				states.get(i).addRepVotes(addRepVotes);
				states.get(i).addDemVotes(addDemVotes);
				break;
			}
		}
		votesChanged();
	}
	
	//has a setVotes method also
	public void setVotes(String Name, Long setDemVotes, Long setRepVotes)
	{
		for(int i=0; i<states.size(); i++)
		{
			if(states.get(i).getName().equals(Name))
			{
				states.get(i).setRepVotes(setRepVotes);
				states.get(i).setDemVotes(setDemVotes);
				break;
			}
		}
		votesChanged();
	}
	
	/*
	This is set up for the observers to pull.
	If not all the observers needed the whole array, I would 
	set up different getters for different info and take greater
	advantage of the pull.
	*/
	public ArrayList<USstate> getStates()
	{
		//returning a deep copy of the states
		ArrayList<USstate> oStates = new ArrayList<USstate>();
		for(USstate s: states){
			oStates.add(s);
		}
		return oStates;
	}
}
