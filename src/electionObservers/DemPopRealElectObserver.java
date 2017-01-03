package electionObservers;

import java.util.Observable;
import java.util.Observer;

public class DemPopRealElectObserver extends ElectionObserver implements Observer{

	public DemPopRealElectObserver(Observable observable) {
		super(observable);
		this.popularVote = new IPopularDemocrat();
		this.electoralVote = new IElectoralHonest();
	}

}
