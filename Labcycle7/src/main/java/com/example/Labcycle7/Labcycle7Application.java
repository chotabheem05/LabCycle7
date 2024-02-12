package com.example.Labcycle7;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Labcycle7Application {

	public static void main(String[] args) {
		
				ConfigurableApplicationContext context = SpringApplication.run(Labcycle7Application.class, args);
				CustomerService customerService = context.getBean(CustomerService.class);
				Scanner scanner = new Scanner(System.in);
				while (true) 
				{
					System.out.println("\nMenu:");
					System.out.println("1. Add Customer");
					System.out.println("2. View All Customers");
					System.out.println("3. Update Customer");
					System.out.println("4. Delete Customer");
					System.out.println("5. Exit");
					System.out.print("Enter your choice: ");
					int choice = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character
					switch (choice) 
					{
						case 1:
								System.out.print("Enter customer first name: ");
									String fname = scanner.nextLine();
								System.out.print("Enter customer last name: ");
									String lname = scanner.nextLine();
								customerService.addCustomer(fname, lname);
								System.out.println("Customer added successfully!");
						break;
						case 2:
								System.out.println("=======Customer Details========");
								customerService.getAllCustomers().forEach(System.out::println);
						break;
						case 3:
								System.out.print("Enter customer id to update: ");
									long updateId = scanner.nextLong();
									scanner.nextLine(); 
								System.out.print("Enter updated name: ");
									String updatedFName = scanner.nextLine();
								System.out.print("Enter updated email: ");
									String updatedLName = scanner.nextLine();
								customerService.updateCustomer(updateId, updatedFName, updatedLName);
								System.out.println("Customer updated successfully!");
						break;
						case 4:
								System.out.print("Enter customer id to delete: ");
									long deleteId = scanner.nextLong();
								customerService.deleteCustomer(deleteId);
								System.out.println("Customer deleted successfully!");
						break;
						case 5:
								System.out.println("Exiting the program.");
								context.close();
								System.exit(0);
						break;
						default:
								System.out.println("Invalid choice. Please enter a number between 1 and 5.");
						}
					}
				}
	}


