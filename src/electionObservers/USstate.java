package electionObservers;

public class USstate {
	
	/*
	All number values are Longs instead
	of Integers because math.round (which I used for calculations)
	Returns a long and I don't want to keep casting
	*/
	
	private String Name;
	private Long repVotes;
	private Long demVotes;
	private Long electoralVotes;
	
	//if instantiating before any votes counted
	public USstate(String Name, Long eV)
	{
		//if this were real, would make a state enum so that 
		//only a real state could be entered
		this.Name = Name;
		this.electoralVotes = eV;
		this.repVotes = 0L;
		this.demVotes = 0L;
	}
	
	//if some counting already happened
	public USstate(String Name, Long eV, Long rV, Long dV)
	{
		this(Name, eV);
		this.repVotes = rV;
		this.demVotes = dV;
	}
	
	//add, not just getters just in case user wants to add instead of reset
	
	public void addDemVotes(Long dV)
	{
		demVotes += dV;
	} 
	
	public void addRepVotes(Long rV)
	{
		repVotes += rV;
	}
	
	//don't think you can add electoral votes during an election
	//if necessary, will use setElectoralVotes
	
	public String getName()
	{
		return this.Name;
	}
	
	public Long getRepVotes()
	{
		return this.repVotes;
	}
	
	public Long getDemVotes()
	{
		return this.demVotes;
	}
	
	public Long getElectoralVotes()
	{
		return this.electoralVotes;
	}
	
	//shouldn't be able to change name
	
	public void setRepVotes(Long resetRV)
	{
		this.repVotes = resetRV;
	}
	
	public void setDemVotes(Long resetDV)
	{
		this.demVotes = resetDV;
	}
	
	public void setElectoralVotes(Long resetEV)
	{
		this.electoralVotes = resetEV;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof USstate){
			if(((USstate) o).getName().equals(this.getName()))
			{
				return true;
			}
		}
		
		return false;
	}
}
