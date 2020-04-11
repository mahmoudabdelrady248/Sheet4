import java.util.Scanner;

public class Q6 {
	class Node{
		int data;Node next;
	}Node front,rear;
	class element{
		int min,max;
	}
	public static void main(String[]args) {
		
			Q6 queue=new Q6();Scanner input=new Scanner(System.in);
		    int []a= {3,2,1,5,4};
		    for(int i=0;i<a.length;i++) queue.enqueue(a[i]);
		    int quiry=3;
		    for(int i=0;i<quiry;i++) {
		    	try {
		    		int sum=input.nextInt();
			    	while(queue.sum()!=sum) {
			    		int difference=queue.MinAndMaxElement().max-queue.MinAndMaxElement().min;
						queue.dequeue(queue.getIndex(queue.MinAndMaxElement().min));
						queue.dequeue(queue.getIndex(queue.MinAndMaxElement().max));
						queue.enqueue(difference);
					}
			    	queue.show();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Value is not found");
				}
		    	
		    }input.close();
		
		
    }
	public void enqueue(int element) {
		Node node=new Node();node.data=element;
		if(front==null&&rear==null) {front=node;rear=node;}
		else {rear.next=node;;rear=node;}
	}
	public void dequeue(int index) {
		Node n=front;int size=0;
		while(n!=null) {size++;n=n.next;}n=front;
		if(index==0&&size==1) {front=n.next;n.next=null;rear=n.next;n.next=null;}
		else if(index==0&&size!=1) {front=n.next;n.next=null;}
		else if(index==size-1) {
			for(int i=0;i<index-1;i++) n=n.next;
			Node m=n.next;Node l=m.next;n.next=l;rear=n;
		}
		else {
			for(int i=0;i<index-1;i++) n=n.next;
			Node m=n.next;Node l=m.next;n.next=l;
		}
	}
	public element MinAndMaxElement() {
		if(front==null&&rear==null) throw new NullPointerException();
		else {
			int min=front.data,max=front.data;Node n=front;
			while(n.next!=null) {
				if(n.next.data<min) {min=n.next.data;n=n.next;}
				else if(n.next.data>max) {max=n.next.data;n=n.next;}
				else n=n.next;
			}
			element b=new element();b.min=min;b.max=max;
			return b;
		}
	}
	public int getIndex(int element) {
		Node n=front;int index=0;
		while(n.data!=element) {index++;n=n.next;}
		return index;
	}
	public int sum() {
		int sum=0;Node n=front;
		while(n!=null) {sum+=n.data;n=n.next;}
		return sum;
	}
	public void show() {
		Node n=front;
		while(n.next!=null) {System.out.println(n.data);n=n.next;}
		System.out.println(n.data);
	}

}
