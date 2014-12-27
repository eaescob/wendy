package com.wendy.sales;

import java.util.Scanner;

public class TotalSales {
	public static final int TOTAL_SALESPEOPLE = 4;
	public static final int TOTAL_PRODUCTS = 5;
	public static double[][] sales = new double[TOTAL_SALESPEOPLE][TOTAL_PRODUCTS];
	
	public static void getProductsSale(Scanner scanner, int salesPerson) {
		System.out.printf("Obtaining total sales for sales person %d%n", salesPerson+1);
		
		for(int x = 0; x < TOTAL_PRODUCTS; x++) {
			System.out.printf("Enter total monthly sales for product %d: ", x+1);
			double productSales = scanner.nextDouble();
			sales[salesPerson][x] = productSales;
		}
	}
	
	public static void showOutput() {
		double[] totalProducts = new double[TOTAL_PRODUCTS];
		double[] totalSalesPerson = new double[TOTAL_SALESPEOPLE];
		
		System.out.print("  "); //align headers
		//create a column heading for each sales person
		for (int x = 0; x < TOTAL_SALESPEOPLE; x++) {
			System.out.printf("%d\t", x+1);
		}
		
		System.out.println("Total");
		
		for (int product = 0; product < TOTAL_PRODUCTS; product++) {
			System.out.printf("%d ", product+1);
			for( int person = 0; person < TOTAL_SALESPEOPLE; person++) {
				System.out.printf("%.2f\t", sales[person][product]);
				totalSalesPerson[person] += sales[person][product];
				totalProducts[product] += sales[person][product];
			}
			
			System.out.printf("%.2f", totalProducts[product]);
			System.out.printf("%n");
		}
		
		System.out.print("  ");
		for (int  x = 0; x < TOTAL_SALESPEOPLE; x++) {
			System.out.printf("%.2f\t", totalSalesPerson[x]);
		}
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		System.out.println("Capturing monthly sales by sales person per product");
		Scanner scanner = new Scanner(System.in);
		
		for (int x = 0; x < TOTAL_SALESPEOPLE; x++) {
			getProductsSale(scanner, x);
		}
		
		showOutput();
	}
}
