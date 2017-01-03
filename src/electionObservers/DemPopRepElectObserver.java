package electionObservers;

import java.util.Observable;
import java.util.Observer;

public class DemPopRepElectObserver extends ElectionObserver implements Observer{

	public DemPopRepElectObserver(Observable observable) {
		super(observable);
		this.popularVote = new IPopularDemocrat();
		this.electoralVote = new IElectoralDemSmallestSplit();
	}

}