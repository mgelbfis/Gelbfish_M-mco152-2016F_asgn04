package electionObservers;

import java.util.ArrayList;

public class ElectionMain {
	
	public static void main(String[] args){

		ArrayList<USstate> states = new ArrayList<USstate>();
		states.add(new USstate("NY", 29L));
		states.add(new USstate("CA", 55L));
		states.add(new USstate("FL", 29L));
		states.add(new USstate("OH", 18L));
		states.add(new USstate("TX", 38L));
		
		
		ElectionObservable president = new ElectionObservable(states);
		
		new AllRealNewsObserver(president);
		new AllDemocratObserver(president);
		new AllRepublicanObserver(president);
		new DemPopRealElectObserver(president);
		new DemPopRepElectObserver(president);
		
		
		president.addVotes("NY", 50L, 60L);
		president.setVotes("NY", 60L, 70L);
		president.addVotes("CA", 60L, 15L);
		president.addVotes("FL", 40L, 40L);
		president.addVotes("NY", 20L, 0L);
		president.addVotes("OH", 140L, 320L);
		president.addVotes("TX", 50L, 80L);
		
				
		
	}
	

	
}
