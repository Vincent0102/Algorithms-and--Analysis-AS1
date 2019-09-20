# Algorithms-and--Analysis-AS1
Assignment 1 : Basic sorting Algorithm
Implementation include:
  • Singly linked list: 
  • Sorted (singly) linked list
  • Binary search tree.
  
 Each of them support the following operations:
• Create an empty multiset (implemented as a constructor that takes zero arguments).
• Add an element.
• Search for an element.
• Remove all instances of an element.
• Remove one instance of an element.
• Print out the multiset.

• Singly linked list. Nodes of the linked list should store an element and the number of instances of that element in the multiset.
• Sorted singly linked list. The (singly) linked list should always be maintained in ascending order after any operation, and nodes of the linked list should store an element and the number of instances of that element in the multiset. Operations that can take advantage of, or need to maintain, the ascending ordering of the list should do so. These include:
  -adding an element;
  -searching for an element;
  -removal of element(s).
• Binary search tree (BST), which does not necessary have to be balanced. Nodes of the tree should store an element and the number of instances of that element in the multiset. Otherwise, the BST should have usual semantics of \left subtree contain values that are less than to the parent node" and \right subtree contains values that are greater than the parent node."

Operations Details
Operations to perform on the implemented multiset abstract data type are specified on the command line. They are in the following format:
    <operation> [arguments] 
where operation is one of fA, S, RA, RO, P, Qg and arguments is for optional arguments of some of the operations. The operations take the following form:
• A <element> { add element into the multiset.
• S <element> { search for the number of instances that element have in the multiset and prints this number out. See below for the required format.
• RA <element> { delete all instances of element from the multiset.
• RO <element> { delete one instance of element from the multiset.
• P { prints the contents of the multiset. See below for the required format. The elements can be printed in any order.
• Q { quits the program
  
  For more detail read assignment1.pdf
