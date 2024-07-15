package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = leitor.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = leitor.next().charAt(0);
			System.out.print("Name: ");
			leitor.nextLine();
			String name = leitor.nextLine();
			System.out.print("Anual income R$: ");
			double income = leitor.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures R$: ");
				double healthExpenditures = leitor.nextDouble();
				list.add(new Individual(name, income, healthExpenditures));
			} else if (type == 'c') {
				System.out.print("Number of company: ");
				int number = leitor.nextInt();
				list.add(new Company(name, income, number));
			}
		}

		System.out.println();
		double sum = 0;
		System.out.println("TAXED PAID:");
		for (TaxPayer payer : list) {
			double tax = payer.tax();
			System.out.println(payer.toString());
			sum += tax;
		}

		System.out.println();
		System.out.println("Total Taxes: " + String.format("%.2f", sum));

		leitor.close();
	}

}
