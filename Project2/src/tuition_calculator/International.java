package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class International extends NonResident{
	@Override
	public String toString()
	{
		
	}
	
	@Override
	public void tuitionDue()
	{
		this.getProfile().setTuition(29737 + 3268 + 2650);
		if (this.getProfile().isStudyingAbroad() == true)
			this.getProfile().setTuition(this.getProfile().getTuition() - 29737);
	}
}
