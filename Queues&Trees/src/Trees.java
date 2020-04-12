public class Trees {
	class Node{
		Object data;Node leftchild,rightchild;
	}Node root,extraroot;int count1=0,count2=0;
	
     public void add(Object element,Node rootexplorer) {
    	 Node node=new Node();node.data=element;
    	 if(rootexplorer==null) root=node;
    	 else {
    		if((int)node.data<(int)rootexplorer.data) {
    			 if(rootexplorer.leftchild==null) rootexplorer.leftchild=node;
    			 else add(node.data,rootexplorer.leftchild);
    		 }
    		 else {
    			 if(rootexplorer.rightchild==null) rootexplorer.rightchild=node;
    			 else add(node.data,rootexplorer.rightchild); 
    		 }
    	 }
	  
     }
     public void addextra(Object element,Node rootexplorer) {
    	 Node node=new Node();node.data=element;
    	 if(rootexplorer==null) extraroot=node;
    	 else {
    		if((int)node.data<(int)rootexplorer.data) {
    			 if(rootexplorer.leftchild==null) rootexplorer.leftchild=node;
    			 else add(node.data,rootexplorer.leftchild);
    		 }
    		 else {
    			 if(rootexplorer.rightchild==null) rootexplorer.rightchild=node;
    			 else add(node.data,rootexplorer.rightchild); 
    		 }
    	 }
	  
     }
     
     public void add(Object element) {
    	 add(element, root);
     }
     public void addextra(Object element) {
    	 addextra(element,extraroot);
     }
     public void preorder(Node rootexplorer) {
    	 System.out.println(rootexplorer.data);
    	 if(rootexplorer.leftchild==null&&rootexplorer.rightchild==null) {}
    	 else if(rootexplorer.leftchild==null) swap(rootexplorer.rightchild);
     	 else if(rootexplorer.rightchild==null) swap(rootexplorer.leftchild);
    	 else {
    		preorder(rootexplorer.leftchild);
    		preorder(rootexplorer.rightchild);
    	 }
     }
    public void preorder() {
    	preorder(root);
    }
    public void postorder(Node rootexplorer) {
    	if(rootexplorer.leftchild==null&&rootexplorer.rightchild==null) {
    		System.out.println(rootexplorer.data);
    	}
    	else if(rootexplorer.leftchild==null) swap(rootexplorer.rightchild);
    	else if(rootexplorer.rightchild==null) swap(rootexplorer.leftchild);
    	else {
    		postorder(rootexplorer.leftchild);
    		postorder(rootexplorer.rightchild);
    		System.out.println(rootexplorer.data);
    	}
    }
    public void postorder() {
    	postorder(root);
    }
    public void inorder(Node rootexplorer) {
    	if(rootexplorer.leftchild==null&&rootexplorer.rightchild==null) {
    		System.out.println(rootexplorer.data);
    	}
    	else if(rootexplorer.leftchild==null) swap(rootexplorer.rightchild);
    	else if(rootexplorer.rightchild==null) swap(rootexplorer.leftchild);
        else {
    		inorder(rootexplorer.leftchild);
    		System.out.println(rootexplorer.data);
    		inorder(rootexplorer.rightchild);
    	}
    }
    public void inorder() {
    	inorder(root);
    }
    public void countLeafAndInternalNodes(Node rootexplorer) {
    	if(rootexplorer.leftchild==null&&rootexplorer.rightchild==null) {
    		count1++;
    	}
    	else if(rootexplorer.leftchild==null) swap(rootexplorer.rightchild);
    	else if(rootexplorer.rightchild==null) swap(rootexplorer.leftchild);
        else {
    		countLeafAndInternalNodes(rootexplorer.leftchild);
    		count2++;
    		countLeafAndInternalNodes(rootexplorer.rightchild);
    	}
    	
    }
    public Node swap(Node rootexplorer) {
    	if(rootexplorer.leftchild==null&&rootexplorer.rightchild==null) {
    		return rootexplorer;
    	}
    	else if(rootexplorer.leftchild==null) swap(rootexplorer.rightchild);
    	else if(rootexplorer.rightchild==null) swap(rootexplorer.leftchild);
    	else {
    		Node node1=swap(rootexplorer.leftchild);
    		Node node2=swap(rootexplorer.rightchild);
    		Object temp=node1.data;
    		node1.data=node2.data;
    		node2.data=temp;
    	}
    	return rootexplorer;
    }
    public boolean equivalent(Node rootexplorer1,Node rootexplorer2) {
    	if(rootexplorer1==null&&rootexplorer2==null) return true;
    	if(rootexplorer1!=null&&rootexplorer2!=null) {
    		return(rootexplorer1.data==rootexplorer2.data&&
    				equivalent(rootexplorer1.leftchild, rootexplorer2.leftchild)&&
    				equivalent(rootexplorer1.rightchild, rootexplorer2.rightchild));
    	}return false;
    }
}
