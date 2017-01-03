package electionObservers;

import java.util.Observable;
import java.util.Observer;

public class AllRepublicanObserver extends ElectionObserver implements Observer{

	public AllRepublicanObserver(Observable observable) {
		super(observable);
		this.popularVote = new IPopularRepublican();
		this.electoralVote = new IElectoralStateAutoRep();
	}

}
