import java.io.PrintStream;
import java.util.*;

//Code that implements a sorted linked list implementation of a multiset.

public class SortedLinkedListMultiset<T> extends Multiset<T> {
	private Node<T> mNode;

	public SortedLinkedListMultiset() {
		mNode = new Node<T>(null); //give the element null, not whole node
	} // end of SortedLinkedListMultiset()

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(T item) {
		Node<T> pointer = mNode;
		Node<T> newNode = new Node<T>(item);
		
		//first node is null
		while(pointer.nextNode!=null) {
			if(((Comparable)item).compareTo((Comparable)pointer.getNextNode().getElement()) > 0) {
				pointer=pointer.getNextNode();
			}
			else {
				break;
			}
		}//find the one newNode that nextNode == null or newNode is smaller than or equal to pointer's nextNode;
		
		if(pointer.getNextNode()!=null && item.equals(pointer.getNextNode().getElement())){
			pointer.getNextNode().addCount();
		}//find the equal one and add to it
		else {
			if(pointer.getNextNode()!=null) {
				newNode.setNextNode(pointer.getNextNode());
			}//find the newNode is small than pointer's nextNode, and newNode point to pointer's nextNode
			pointer.setNextNode(newNode);
		}//pointer point to newNode
	}// end of add()

	public int search(T item) {
		Node<T> pointer = mNode.getNextNode(); //the first node is null
		
		while(pointer!=null) {
			if(pointer.getElement().equals(item)) {
				return pointer.getCount();
			}
			pointer = pointer.getNextNode();
		}
		return 0;		
	} // end of add()

	public void removeOne(T item) {
		Node<T> pointer = mNode;
		
		while(pointer.getNextNode()!=null) {
			if(pointer.getNextNode().getElement().equals(item)) { //or use compareTo
				if(pointer.getNextNode().getCount()==1) {
					Node<T> temp= pointer.getNextNode();
					pointer.setNextNode(temp.getNextNode());
					temp=null;
					break;
				}//find the one needed to remove; pointer point to nextNode's nextNode
				else {
					pointer.getNextNode().reduceCount();
				}
			}
			pointer=pointer.getNextNode();  //out of if, all operate
		}
	} // end of removeOne()

	public void removeAll(T item) {
		Node<T> pointer = mNode;
		
		while(pointer.getNextNode()!=null) {
			if(pointer.getNextNode().getElement().equals(item)) {
				Node<T> temp= pointer.getNextNode();
				pointer.setNextNode(temp.getNextNode());
				temp=null;
				break;
			}
			else {
				pointer=pointer.getNextNode();
			}
		}
	} // end of removeAll()

	public void print(PrintStream out) {
		Node<T> pointer = mNode.getNextNode();

		while (pointer != null) {
			out.println(pointer.getElement() + printDelim + pointer.getCount());
			pointer = pointer.getNextNode();
		}
	}// end of print()


	@SuppressWarnings("hiding")
	private class Node<T> {
		private T element;
		private int count;
		private Node<T> nextNode;
		
		public Node(T element) {
			this.element=element;
			this.count=1;
			this.nextNode=null;
		}
		
		public T getElement() {
			return element;
		}
		public int getCount() {
			return count;
		}
		public Node<T> getNextNode() {
			return nextNode;
		}
		public void setElement(T element) {
			this.element = element;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}
		
		public void addCount() { 
			this.count++;
		}
		
		public void reduceCount() {
			this.count--;
		}
	}

} // end of class SortedLinkedListMultiset