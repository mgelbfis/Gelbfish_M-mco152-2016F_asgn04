package electionObservers;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Date;

public abstract class ElectionObserver implements Observer{

	protected IPopularVote popularVote;
	protected IElectoralVote electoralVote;
	protected ArrayList<USstate> states;
	
	
	public ElectionObserver(Observable observable)
	{
		observable.addObserver(this);
		this.states = new ArrayList<USstate>();
	}
	
	
	public void update(Observable observable, Object stateObject)
	{
		if (observable instanceof ElectionObservable)
		{
			ElectionObservable electionObservable = (ElectionObservable) observable;
			//THE PULL...(every observer needs all the data about all the states)
			this.states = electionObservable.getStates();
			display();
		}
	}
	
	public void display()
	{
		StringBuffer info = new StringBuffer();
		info.append("\nReport on each state's popular vote: \n");
		info.append(getStatePopularData());
		info.append("\nPrediction of each state's electoral "
				+ "votes (Democrat/Republican/Equal):\n");
		info.append(getStateElectoralData());
		info.append("\nReport on the total popular vote:\n");
		info.append(getTotalPopularData());
		info.append("\nPrediction of the total electoral vote:\n");
		info.append(getTotalElectoralData());
		info.append(getMessage());
		System.out.println(info.toString());
	}
	
	private String getTotalElectoralData() 
	{
		StringBuffer te = new StringBuffer();
		te.append("\n\tTotal Predicted Republican: ");
		te.append(this.electoralVote.allTogRep(this.states));
		te.append("\n\tTotal Predicted Democrat: ");
		te.append(this.electoralVote.allTogDem(this.states));
		return te.toString();
	}

	private String getTotalPopularData() {
		StringBuffer tp = new StringBuffer();
		tp.append("\n\tTotal Republican: ");
		tp.append(this.popularVote.allTogetherRep(this.states));
		tp.append("\n\tTotal Democrat: ");
		tp.append(this.popularVote.allTogetherDem(this.states));
		return tp.toString();
	}

	private String getStateElectoralData() {
		StringBuffer sElect = new StringBuffer();
		ArrayList<Character> stateE = this.electoralVote.stateEVote(this.states);
		for(int i=0; i<stateE.size(); i++)
		{
			sElect.append("\n\t");
			sElect.append(this.states.get(i).getName());
			sElect.append(": ");
			sElect.append(stateE.get(i));
		}
		return sElect.toString();
	}

	private String getStatePopularData() {
		StringBuffer sPop = new StringBuffer();
		ArrayList<Long> stateRPop = this.popularVote.stateRepVote(this.states);
		ArrayList<Long> stateDPop = this.popularVote.stateDemVote(this.states);
		for(int i=0; i<stateRPop.size(); i++)
		{
			sPop.append("\n\t");
			sPop.append(this.states.get(i).getName());
			sPop.append(": \n\t\tRepublican Votes: ");
			sPop.append(stateRPop.get(i));
			sPop.append("\n\t\tDemocrat Votes: ");
			sPop.append(stateDPop.get(i));
		}
		return sPop.toString();
	}

	public String getMessage()
	{
		StringBuffer legals = new StringBuffer();
		legals.append("\n\nCurrent Time: ");
		Date now = new Date();
		legals.append(now.toString());
		legals.append("\n\nNotice: All reports are purely observational"
				+ " and not legally binding in any way" );
		return legals.toString();
	}
}
