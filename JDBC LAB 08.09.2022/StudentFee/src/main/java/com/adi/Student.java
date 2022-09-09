package com.adi;


 
public class Student {   // main class
	// took non-primitive data type variables
	Long studentId;
	Character studentGrade;
	Double monthlyFees;
	Boolean isScholarshipEligible;
	Double Fees;
	Long maths;
	Double english;
	
	public static void main(String[] args) {   // main method
		Student s = new Student();
		// called all method with parameter
		s.calculateFeesStructure(234, 'C', 600, true);
		s.calculateFeesStructure(115, 'B', 909.50, true);
		s.calculateFeesStructure(980, 'G', 1810, false);
		s.compareMarks(85, 65);
		s.compareMarks(56, 98);
		s.compareMarks(84, 84);
		s.validateFees((double) 500);
	}
	// method to calculate fees 
	void calculateFeesStructure(long studentId,char studentGrade,double monthlyFees,boolean isScholarshipEligible) {
		// condition & logic
		System.out.println("------------ Calculate Fees -----------");
		if(studentId!= 0 && studentGrade =='A' && isScholarshipEligible == true) {
			Fees = monthlyFees- monthlyFees *10/100;
			System.out.println("10 % of fees is exempted, the calculated fees is "+Fees);
		}
		else if(studentId!= 0 && studentGrade =='B' && isScholarshipEligible == true) {
			Fees = monthlyFees- monthlyFees *8/100;
			System.out.println("8 % of fees is exempted, the calculated fees is "+Fees);
		}
		else if(studentId!= 0 && studentGrade =='C' && isScholarshipEligible == true) {
			Fees = monthlyFees- monthlyFees *6/100;
			System.out.println("6 % of fees is exempted, the calculated fees is "+Fees);
		}
		else if(studentId!= 0 && studentGrade =='D' && isScholarshipEligible == true) {
			Fees = monthlyFees- monthlyFees *4/100;
			System.out.println("4 % of fees is exempted, the calculated fees is "+Fees);
		}
		else {
			System.out.println("Not Eligible for Exemption.");
		}
	}
	// method to compare marks
	void compareMarks(long math,double english) {
		
		System.out.println("\n----------Copmpare marks----------");
		// condition
		if(english>math) {
			System.out.println("English mark is higher than Maths");
		}
		if(english<math) {
			System.out.println("Maths mark is higher than English");
		}
		if(english==math) {
			System.out.println("Both Are Equal");
		}
	}
	// method to validate fees
	void validateFees(Double Fees) {
		System.out.println("\n----------Validate Fees----------");
		// condition
		if (Fees.isInfinite()) {
			System.out.println("Fees is infinite");
		}
		else if (!Fees.isInfinite()) {
			System.out.println("Fees is not infinite");
		}
	}
}
