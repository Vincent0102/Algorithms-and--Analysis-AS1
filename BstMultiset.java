import java.io.PrintStream;
import java.util.*;

//Code that implements a BST implementation of a multiset. 

public class BstMultiset<T> extends Multiset<T> {
	private Node<T> mNode;

	public BstMultiset() {
		mNode = new Node<T>(null);
	} // end of BstMultiset()

	@SuppressWarnings({ "unchecked", "rawtypes"})
	public void add(T item) {
		Node<T> pointer = mNode;
		Node<T> newNode = new Node<T>(item);

		if (mNode.getElement()==null) {
			mNode=newNode; //when using pointer, cannot use ==
		} else {
			while (pointer.getLeftNode() != null || pointer.getRightNode() != null) {
				if (((Comparable) item).compareTo((Comparable) pointer.getElement()) > 0
						&& pointer.getRightNode() != null) {
					pointer = pointer.getRightNode();
				} else if (((Comparable) item).compareTo((Comparable) pointer.getElement()) < 0
						&& pointer.getLeftNode() != null) {
					pointer = pointer.getLeftNode();
				} else {
					break;
				}
			} // find the one smaller than element and left==null, bigger than element and
				// right==null, equal to element, left and right are null

			if (pointer.getElement().equals(item)) {
				pointer.addCount();
			} else if (((Comparable) item).compareTo((Comparable) pointer.getElement()) > 0
					&& pointer.getRightNode() == null) {
				pointer.setRightNode(newNode);
			} else if (((Comparable) item).compareTo((Comparable) pointer.getElement()) < 0
					&& pointer.getLeftNode() == null) {
				pointer.setLeftNode(newNode);
			}
		}
	} // end of add()

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int search(T item) {
		Node<T> pointer = mNode;
		
		while(pointer != null) {
			if (((Comparable)item).compareTo((Comparable) pointer.getElement()) < 0) {
				pointer = pointer.getLeftNode();
			} else if (((Comparable)item).compareTo((Comparable) pointer.getElement()) > 0) {
				pointer = pointer.getRightNode();
			} else {
				return pointer.getCount();
			}
		}
		return 0;
			
	} // end of add()

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void removeOne(T item) {
		Node<T> pointer = mNode;
		
		while (pointer != null) {
			if (((Comparable) item).compareTo((Comparable) pointer.getElement()) < 0) {
				pointer = pointer.getLeftNode();
			} else if (((Comparable)item).compareTo((Comparable) pointer.getElement()) > 0) {
				pointer = pointer.getRightNode();
			} else {
				if (pointer.getCount() == 1) {
					removeAll(item);
				} else {
					pointer.reduceCount();
				}
				return;
			}
		}
	} // end of removeOne()

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void removeAll(T item) {
		Node currNode = mNode;
		Node pointer = null;
		Node pointerParent = null;
		Node currParentNode = null;

		while (currNode != null) {
			if (((Comparable)item).compareTo((Comparable) currNode.getElement()) < 0) {
				currParentNode = currNode;
				currNode = currNode.getLeftNode();
			} else if (((Comparable)item).compareTo((Comparable) currNode.getElement()) > 0) {
				currParentNode = currNode;
				currNode = currNode.getRightNode();
			} else {//get the point
				
				if (currNode.getRightNode() != null) {//right not null
					pointerParent = currNode;
					pointer = currNode.getRightNode();
					
					while (pointer.getLeftNode() != null) {
						pointerParent = pointer;
						pointer = pointer.getLeftNode();
					}//until left=null
					
					if (currNode == mNode) {	
						mNode.setElement((T)pointer.getElement());
						mNode.setCount(pointer.getCount());
					}
					else {
						if(currParentNode.getLeftNode()==currNode) {
							currParentNode.getLeftNode().setElement(pointer.getElement());
							currParentNode.getLeftNode().setCount(pointer.getCount());
						}
						else if(currParentNode.getRightNode()==currNode) {
							currParentNode.getRightNode().setElement(pointer.getElement());
							currParentNode.getRightNode().setCount(pointer.getCount());
						}//update currNode
					}
					
					//sort below
					if(pointer.getRightNode()==null) {//pointer has right condition
						if(pointerParent.getLeftNode()==pointer) {
							pointerParent.setLeftNode(null);
						}
						else if(pointerParent.getRightNode()==pointer) {
							pointerParent.setRightNode(null);
						}
					}
					else if(pointer.getRightNode()!=null) {//pointer has not right condition
						if(pointerParent.getLeftNode()==pointer) {
							pointerParent.setLeftNode(pointer.getRightNode());
						}
						else if(pointerParent.getRightNode()==pointer) {
							pointerParent.setRightNode(pointer.getRightNode());
						}
					}
				}
				else if(currNode.getRightNode() == null && currNode.getLeftNode() != null) {//right null, left not null
					Node L = currNode.getLeftNode();
					if (currNode == mNode) {
						mNode = L;  
					}
					else {
						if(currParentNode.getLeftNode()==currNode) {
							currParentNode.setLeftNode(L);
						}
						else if(currParentNode.getRightNode()==currNode) {
							currParentNode.setRightNode(L);
						}
					}					
				}
				else if(currNode.getRightNode() == null && currNode.getLeftNode() == null) {//right and left null
					if (currNode == mNode) {
						mNode.setElement(null);
						mNode.setCount(0);
					}
					else {
						if(currParentNode.getLeftNode()==currNode) {
							currParentNode.setLeftNode(null);
						}
						else if(currParentNode.getRightNode()==currNode) {
							currParentNode.setRightNode(null);
						}
					}
				}
				return;
			}
		}
		
	} // end of removeAll()

	
	
	public void print(PrintStream out) {
		if (mNode != null) {
			printRecrusion(mNode, out);
		}
	} // end of print()
	
	
	@SuppressWarnings("rawtypes")
	private void printRecrusion(Node currNode, PrintStream out) {
		if (currNode != null) {
			printRecrusion(currNode.getLeftNode(), out);
			out.println(currNode.getElement() + printDelim + currNode.getCount());
			printRecrusion(currNode.getRightNode(), out);
		}
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T element;
		private Node<T> leftNode;
		private Node<T> rightNode;
		private int count;

		public Node(T element) {
			this.element = element;
			if(element==null) {
				this.count = 0;
			}
			else {
				this.count = 1;
			}
			this.leftNode = null;
			this.rightNode = null;
		}

		public T getElement() {
			return element;
		}

		public Node<T> getLeftNode() {
			return leftNode;
		}

		public Node<T> getRightNode() {
			return rightNode;
		}

		public int getCount() {
			return count;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public void setLeftNode(Node<T> leftNode) {
			this.leftNode = leftNode;
		}

		public void setRightNode(Node<T> rightNode) {
			this.rightNode = rightNode;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public void addCount() { // more efficient
			this.count++;
		}

		public void reduceCount() {
			this.count--;
		}

	}// end of print()

} // end of class BstMultiset
