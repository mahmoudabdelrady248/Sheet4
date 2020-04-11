public class Q2a {
	int front=-1,rear=-1,r=0;Object[]a=new Object[100];
	public static void main(String[]args) {
		try {
			Q2a queue=new Q2a();
			queue.enqueue(4);queue.enqueue(5);queue.enqueue(6);
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Queue is empty");
		}
		
	}
	public void enqueue(Object element) {
		if(front==-1&&rear==-1) {front++;rear++;r++;a[rear]=element;}
		else {rear++;r++;a[rear]=element;}
	}
	public Object dequeue() {
		if(r!=0) {
			int i=0;Object element=a[front];
			while(i<r-1) {a[i]=a[i+1];i++;}
			a[rear]=null;rear--;r--;
			return element;
		}
		else throw new NullPointerException();
	}

}
