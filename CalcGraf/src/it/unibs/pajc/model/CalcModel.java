package it.unibs.pajc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CalcModel {
	private HashMap <String, OperatoreBinario> operators=new HashMap<>();

	public CalcModel() {
		this.operators.put("+",(a,b) -> a+b);
		this.operators.put("-",(a,b) -> a-b);
		this.operators.put("/",(a,b) -> a/b);
		this.operators.put("*",(a,b) -> a*b);
		
	}
	
	// Stack notazione polacca inversa
	
	private class CompEl{
		final Double value;
		final OperatoreBinario operator;
		final String operatorSymbol; 
		
		CompEl(Double value){
			this.value = value;
			this.operator = null;
			this.operatorSymbol = null;
		}
		
		
		CompEl(OperatoreBinario operator, String operatorSymbol) {
			this.value= null;
			this.operator = operator;
			this.operatorSymbol= operatorSymbol;
		}
		
		boolean isOperator() {return operator!=null; }
		
		boolean isOperand() { return value != null; }
		
		public String toString() {
			return isOperand() ? Double.toString(value) : operatorSymbol;
		}
	}
	
	private Stack<CompEl> compStack = new Stack<>();
	
	public void pushOperator(String operatorSymbol) {
		OperatoreBinario op = operators.get(operatorSymbol);
		if(op == null) {
			return;
		}
		compStack.add(new CompEl(op,operatorSymbol));
	}
	
	public void pushOperand(Double value ) {
		compStack.add(new CompEl(value));
		
	}
	
	//Restituisce una stringa contenente gli operatori gestiti

	public String listOperators() {
		StringBuilder strbl = new StringBuilder();
		
		for(String operator : operators.keySet()) {
			strbl.append(operator.toString()).append(" ");
		}
		return strbl.toString().trim();
	}
	
	//Restituisce tutti gli input inseriti dall'utente
	
	public String dump() {
		StringBuilder sb= new StringBuilder();
		for(CompEl ce: compStack) {
			sb.append(ce.toString()).append(" ");
		}
		return sb.toString().trim();

		
	}
	//Non lo inizializzo perche voglio valorizzare lo stack solo durante le operazioni
	private Stack<CompEl> wStack;
	
	public double eval() {
		wStack = (Stack<CompEl>)compStack.clone();
		double res = eval_internal();
		return res;
	}
	
	private double eval_internal() {	
		
		CompEl compEl= wStack.pop();
		if(compEl.isOperand()) {
			return compEl.value;
		}else if(compEl.isOperand()) {
			OperatoreBinario op= compEl.operator;
		
			double val1 = eval_internal();
			double val2 = eval_internal();
			
			return op.eval(val1, val2);
					
		}
		
		return Double.NaN;
	
	}
	
	
}
