package electionObservers;

import java.util.Observable;
import java.util.Observer;

public class AllDemocratObserver extends ElectionObserver implements Observer{

	public AllDemocratObserver(Observable observable) {
		super(observable);
		this.popularVote = new IPopularDemocrat();
		this.electoralVote = new IElectoralMostElectoralDem();
	}

}
