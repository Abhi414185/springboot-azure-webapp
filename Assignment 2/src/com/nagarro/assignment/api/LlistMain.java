package com.nagarro.assignment.api;

import java.util.Scanner;

import com.nagarro.assignment.services.impl.Llist;

public class LlistMain {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int choice;
		Llist s=new Llist();
		s.listCreate();
		
		
		
			while(true) {	
				System.out.println("\n1.Add element");
				System.out.println("2.Insert element");
				System.out.println("3.Delete element");
				System.out.println("4.Reverse");
				System.out.println("5.Sort");
				System.out.println("6.Traverse");
				System.out.println("7.Contains");
				System.out.println("8.Centre");
				System.out.println("9.Size");
				System.out.println("10.Quit");
				
				try{
					System.out.print("Enter your choice : ");
					choice=obj.nextInt();
	
				switch(choice) 
				{
					case 1: System.out.print("enter element:");
							int data=obj.nextInt();
							s.insertLast(data);
							break;
					
					case 2:	System.out.println("Enter the element to add:");
							int ele=obj.nextInt();
							System.out.println("Enter the position to add:");
							int pos=obj.nextInt();
							s.insertSpecificLocation(ele, pos);
							break;
							
					case 3: System.out.println("Enter the position to delete element:");
							int delPos=obj.nextInt();
							s.deleteSpecificLocation(delPos);
							break;
						
					case 4:	s.reverseIterate();
						
					case 5: s.sortList();
						
					case 6: System.out.print("list:\n");
							s.display();
							break;
							
					case 7: System.out.println("Enter the element to search:");
							int item=obj.nextInt();
							if(s.search(item))
								System.out.println("Yes");
							else
								System.out.println("No");
							break;
					
					case 8: s.centre();
							break;
						
					case 9: s.size();
							break;
						
					case 10: System.exit(1);
					
					default:System.out.println("Wrong Choice");
					
					}
				}catch(Exception e) {
					System.out.println("\nWrong choice! Please enter correct option number");
					break;
			}
		}
	}
}

		

		
		


