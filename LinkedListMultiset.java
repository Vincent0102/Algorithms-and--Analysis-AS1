import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T> {
	protected Node<T> mHead;

	public LinkedListMultiset() {
		mHead = null;
	} // end of LinkedListMultiset()

	public void add(T item) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Node<T> newNode = new Node(item);

		if (mHead == null){
			mHead = newNode;
		}
		else{
			Node<T> currNode = mHead;
			Node<T> prevNode = null;
			while (currNode != null) {
				if (currNode.getValue().equals(item))
				{
					int temp = currNode.getCount();
					temp++;
					currNode.setCount(temp);
					return;
				}
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			prevNode.setNext(newNode);
		}
	} // end of add()

	public int search(T item) {
		Node<T> currNode = mHead;
		int temp = 0;

		while (currNode != null) {
			if (currNode.getValue().equals(item)) {
				temp = currNode.getCount();
				return temp;
			}
			currNode = currNode.getNext();
		}
		return temp;
	} // end of add()

	// removes one of the specified item
	public void removeOne(T item) {

		Node<T> currNode = mHead;
		Node<T> prevNode = null;

		while (currNode != null) {
			if (currNode.getValue().equals(item)) {
				int count = currNode.getCount();
				if (count == 1) {
					if (currNode == mHead) {
						mHead = currNode.getNext();
					} else {
						prevNode.setNext(currNode.getNext());
					}
				}
				count--;
				currNode.setCount(count);
				return;
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}
	} // end of removeOne()

	// removes all of the specified item
	public void removeAll(T item) {

		Node<T> currNode = mHead;
		Node<T> prevNode = null;

		while (currNode != null) {
			if (currNode.getValue().equals(item)) {
				if (currNode == mHead) {
					mHead = currNode.getNext();
				} else {
					prevNode.setNext(currNode.getNext());
				}
				return;
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}
	} // end of removeAll()

	public void print(PrintStream out) {

		Node<T> currNode = mHead;

		while (currNode != null) {
			out.println(currNode.getValue() + printDelim + currNode.getCount());
			currNode = currNode.getNext();
		}
	}
	// end of print()

	/**
	 * Node type, inner private class.
	 */
	@SuppressWarnings("hiding")
	private class Node<T> {
		/** Stored value of node. */
		protected T mValue;
		/** Reference to next node. */
		protected Node<T> mNext;
		/** Counter for the item. */
		int mCount;

		public Node(T value) {
			mValue = value;
			mNext = null;
			mCount = 1;
		}

		public T getValue() {
			return mValue;
		}

		public int getCount() {
			return mCount;
		}

		public Node<T> getNext() {
			return mNext;
		}

		public void setValue(T value) {
			mValue = value;
		}

		public void setNext(Node<T> next) {
			mNext = next;
		}

		public void setCount(int count) {
			mCount = count;
		}
	} // end of inner class Node

} // end of class LinkedListMultiset