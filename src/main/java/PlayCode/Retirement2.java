package PlayCode;

import java.util.*;
class Retirement2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("How much money will you contribute every year? ");
		double payment = in.nextDouble();

		System.out.print("Interest rate in %: ");
		double interestRate = in.nextDouble();

		double balance = 0;
		int year = 0;

		String input;
		do{
			//balance += payment;
			balance = balance + payment;
			double interest = balance * interestRate / 100;
			//balance += interest;
			balance = balance + interest;

			year++;

			System.out.printf("After year %d, your balance is %,.2f%n", year , balance);

			System.out.print("Ready to retire? (y/n) ");
			input = in.next();
		}
		while(input.equals("n"));
	}
}
