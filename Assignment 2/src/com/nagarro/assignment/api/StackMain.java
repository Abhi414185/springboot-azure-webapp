package com.nagarro.assignment.api;

import java.util.*;
import com.nagarro.assignment.services.impl.*;

public class StackMain {

	public static void main(String[] args) {
		
		Scanner obj=new Scanner(System.in);
		
		Sstack s=new Sstack();
		
		while(true) {	
			System.out.println("\n1.Push");
			System.out.println("2.Pop");
			System.out.println("3.Peek");
			System.out.println("4.Sort");
			System.out.println("5.Contains");
			System.out.println("6.Traverse");
			System.out.println("7.Reverse");
			System.out.println("8.Centre");
			System.out.println("9.Size");
			System.out.println("10.Exit");
			
			try{System.out.print("Enter your choice : ");
				int choice=obj.nextInt();
			
			switch(choice) 
			{
				case 1: System.out.print("enter element:");
						int item=obj.nextInt();
						s.push(item);
						break;
						
				case 2: item=s.pop();
						break;
						
				case 3: item=s.peek();
						System.out.println("Peek item:"+item);
						break;
						
				case 4: s.sortList();
						break;
						
				case 5: System.out.println("Enter the element to search:");
						int data=obj.nextInt();
						if(s.search(data))
							System.out.println("Yes");
						else
							System.out.println("No");
						break;
							
				case 6:	s.display();
						break;
				case 7: s.reverseIterate();		
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
