package electionObservers;

import java.util.Observable;
import java.util.Observer;

public class AllRealNewsObserver extends ElectionObserver implements Observer{

	public AllRealNewsObserver(Observable observable) {
		super(observable);
		this.popularVote = new IPopularHonest();
		this.electoralVote = new IElectoralHonest();
	}

}
