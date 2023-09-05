package com.nagarro.assignment.services.impl;
import java.util.*;

public class Llist {
	
	Scanner sc=new Scanner(System.in);
	
	private Node head;
	private Node tail;
	private int size;
	static int arr[];
	
	//creating the list:-
	
	public void listCreate() {
		arr=new int[size];
		this.size=0;
	}
	
	public void centre() {
		int count =0;
		Node mid= head;
		
		while(head!=null) {
			if((count % 2)==1)
				mid=mid.next;
			++count;
			head=head.next;
		}
		
		if(mid!=null) {
			System.out.println("Centre element is :"+ mid.data);
		}
	}
	
	public void size() {
		int size=0;
		for(Node a=head;a.next!=null;a=a.next) {
			size++;
		}
		System.out.println("Size of list is :"+ size);
	}
	
	public boolean search(int x) {
		Node current=head;
		while(current!=null) {
			if(current.data==x)
				return true;
			current=current.next;
		}
		return false;
	}
	
	//sorting the list:-
	
	public void sortList() {
		Node current=head;
		Node index=null;
		int temp;
		
		if(head==null) {
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
	
	//deleting 1st element from list:-
	
	public int deleteFirst() {
		int data=head.data;
		head=head.next;
		if(head==null) {
			tail=null;
		}
		size--;
		return data;
	}
	
	//deleting last element from list:-
	
	public int deleteLast() {
		if(size<=1) {
			return deleteFirst();
		}
		
		Node secondLast=get(size-2);
		int data=tail.data;
		tail=secondLast;
		tail.next=null;
		return data;
		
	}
	
	public Node get(int index) {
		Node node=head;
		for(int i=0;i< index;i++) {
			node=node.next;
		}
		return node;
	}
	
	//deleting element from a specific location of list
	
	public int deleteSpecificLocation(int index) {
		
		if(index==0) {
			return deleteFirst();
		}
		if(index==size-1) {
			return deleteLast();
		}
		
		Node prev=get(index-1);
		int data=prev.next.data;
		
		prev.next=prev.next.next;
		
		return data;
		
		
	}
	
	// inserting element in a specific location of list
	
	public void insertSpecificLocation(int data,int index) {
		if(index==0) {
			insertFirst(data);
			return;
		}
		if(index==size) {
			insertLast(data);
			return;
		}
		Node temp=head;
		for(int i=1;i<index;i++) {
			temp=temp.next;
		}
		
		Node node=new Node(data,temp.next);
		temp.next=node;
		
		size++;
	}
	
	//inserting element at first position
	
	public void insertFirst(int data) {
		Node node=new Node(data);
		node.next=head;
		head=node;
		
		if(tail==null) {
			tail=head;
		}
		
		size +=1;
	}
	
	//inserting element at last position
	
	public void insertLast(int data) {
		if(tail==null) {
			insertFirst(data);
			return;
		}
		Node node = new Node(data);
		tail.next=node;
		tail=node;
		size++;
	}
	
	// displaying the list
	
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data + "->");
			temp=temp.next;
		}
		System.out.println("End");
	}
	
	public void reverseIterate() {
		if(head==null || head.next==null) {
			return;
		}
		Node prevNode=head;
		Node currNode=head.next;
		while(currNode!=null) {
			Node nextNode=currNode.next;
			currNode.next=prevNode;
			

			prevNode=currNode;
			currNode=nextNode;
		}
		head.next=null;
		head=prevNode;
	}
	
	public class Node{
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data=data;
		}
		
		public Node(int data,Node next){
				this.data=data;
				this.next=next;
		}
	}

	
	


}
