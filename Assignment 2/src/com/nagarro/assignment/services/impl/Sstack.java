package com.nagarro.assignment.services.impl;
import java.util.*;

import com.nagarro.assignment.services.impl.Llist.Node;

public class Sstack {
	
	private Node top;
	private int nodesCount;
	
	public Sstack() {
		this.top=null;
		this.nodesCount=0;
		
	}
	
	public boolean search(int x) {
		Node current=top;
		while(current!=null) {
			if(current.data==x)
				return true;
			current=current.next;
		}
		return false;
	}
	
	public void push(int x) {
		Node node=new Node();
			System.out.println("Inserting"+ x);
			
			node.data=x;
			
			node.next=top;
			
			top=node;
			this.nodesCount +=1;
		
		}
	public boolean isEmpty() {
		return top==null;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("The Stack Is Empty");
		}
		return top.data;
		
	}
	
	public void centre() {
		int count =0;
		Node mid= top;
		
		while(top!=null) {
			if((count % 2)==1)
				mid=mid.next;
			++count;
			top=top.next;
		}
		
		if(mid!=null) {
			System.out.println("Centre element is :"+ mid.data);
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
		}
		int top=peek();
		System.out.println("Removing"+top);
		this.nodesCount -=1;
		this.top=(this.top).next;
		return top;
	}
	
	public void size() {
		System.out.println("Size is:"+ this.nodesCount);
	}
	
	public void sortList() {
		Node current=top;
		Node index=null;
		int temp;
		
		if(top==null) {
			return;
		}
		
		else {
			while(current!=null) {
				index=current.next;
				
				while(index!=null) {
					if(current.data>index.data) {
						temp=current.data;
						current.data=index.data;
						index.data=temp;
					}
					index=index.next;
				}
				current=current.next;
			}
		}
	}
	public void display() {
		Node temp=top;
		while(temp!=null) {
			System.out.print(temp.data + "->");
			temp=temp.next;
		}
		System.out.println("End");
	}
	
	public void reverseIterate() {
		if(top==null || top.next==null) {
			return;
		}
		Node prevNode=top;
		Node currNode=top.next;
		while(currNode!=null) {
			Node nextNode=currNode.next;
			currNode.next=prevNode;
			

			prevNode=currNode;
			currNode=nextNode;
		}
		top.next=null;
		top=prevNode;
	}

class Node{
	int data;
	Node next;
 }
}
