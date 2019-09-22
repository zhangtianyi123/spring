package zty.practise.originalSpring.aop;

public class Coder {

	private Computer computer;
	
	public Coder(Computer computer) {
		this.computer = computer;
	}
	
	public void code() {
		computer.start();
		System.out.println("编码...");
		computer.stop();
	}
	
	public void onlyCode() {
		System.out.println("只是编码...");
	}
}
