package zty.practise.originalSpring.beans;

public class ManualInjectionTest {

	public static void main(String[] args) {
		LuweiCompany company = new LuweiCompany(new JavaDeveloper());
		company.code();
	}
}
