package it.unibs.pajc.calc;

public class CalcCLIApp {

	public static void main(String[] args) {
		
		CalcModel model= new CalcModel();

		model.pushOperator("+");
		model.pushOperand(2.);
		model.pushOperand(3.);

		
		
		System.out.println(model.listOperators());
		System.out.println(model.dump());
		System.out.println(model.eval());
		//System.out.println(model.du
		
		
		
	}

}
