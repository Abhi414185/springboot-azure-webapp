package com.nagarro.assignment.api;

import java.util.Scanner;

import com.nagarro.assignment.services.impl.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		
		PriorityQueue q =new PriorityQueue();
		q.createPriorityQueue();
		
		while(true) {	
			System.out.println("\n1.Push");
			System.out.println("2.Pop");
			System.out.println("3.Peek");
			System.out.println("4.Traverse");
			System.out.println("5.Quit");
			
		try {
			System.out.print("Enter your choice : ");
			int choice=obj.nextInt();

			switch(choice) 
			{
				case 1: System.out.print("enter element:");
						int nItems=obj.nextInt();
						q.insert(nItems);
						break;
				case 2: nItems=q.remove();
						if(nItems==0){
							System.out.println("Queue is underflow");
						}
						else {
							System.out.println("Popped item:"+nItems);
						}
				
						break;
				case 3: nItems=q.peek();
						if(nItems==0){
							System.out.println("Queue is underflow");
						}
						else {
							System.out.println("Peek item:"+nItems);
						}
						break;
				case 4: q.printPriorityQueue();
						break;
				case 5:System.exit(1);
				
				default:System.out.println("Wrong Choice");
			}
		}catch(Exception e) {
			System.out.println("\nWrong choice! Please enter correct option number");
			break;
		}
	}
}

}
