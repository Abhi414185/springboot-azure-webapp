package com.nagarro.assignment.api;

import java.util.Scanner;

import com.nagarro.assignment.services.impl.Qqueue;

public class QueueMain {
	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		
		Qqueue s=new Qqueue();
		
		while(true) {	
			System.out.println("\n1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Peek");
			System.out.println("4.Traverse");
			System.out.println("5.Reverse");
			System.out.println("6.Sort");
			System.out.println("7.Contains");
			System.out.println("8.Centre");
			System.out.println("9.size");
			System.out.println("10.exit");
			
			try{System.out.print("Enter your choice : ");
				int choice=obj.nextInt();
			
			switch(choice) 
			{
				case 1: System.out.print("enter element:");
						int data=obj.nextInt();
						s.enqueue(data);
						break;
						
				case 2: data=s.dequeue();
						System.out.println("removed item:"+data);
						break;
						
				case 3: data=s.peek();
						System.out.println("Peek item:"+data);
						break;
						
				case 4: s.display();
						break;
						
				case 5: s.reverseIterate();
						break;
				
				case 6: s.sortList();
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
