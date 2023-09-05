package com.nagarro.assignment.services.impl;
import java.util.*;


public class Qqueue {

		static Node head=null;
		static Node tail=null;
		
		public boolean isEmpty() {
			return head==null & tail==null;
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
		
		public void enqueue(int data) {
			Node newNode=new Node(data);
			if(tail==null) {
				tail=head=newNode;
				return;
			}
			tail.next=newNode;
			tail=newNode;
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
		
		
		public int dequeue() {
			if(isEmpty()) {
				System.out.println("No data");
				return -1;
			}
			int front =head.data;
			if(head==tail) {
				tail=null;
			}
			head=head.next;
			return front;
			
		}
		
		public int peek() {
			if(isEmpty()) {
				System.out.println("No data");
				return -1;
			}
			return head.data;
		}
		
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
	}
class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
		next=null;
	}
}
