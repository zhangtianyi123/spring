package zty.practise.originalSpring.beans;

public class LuweiCompany implements Produce {

	private Developer developer;
	
	public LuweiCompany(Developer developer) {
        this.developer = developer;
    }
    
    public void code() {
    	developer.work();
    }
}
