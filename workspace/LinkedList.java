/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  ListNode head;
  //constructors go here
  public LinkedList() {
    head = null;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line) {
    ListNode current = head;
    //if the list is empty
    if(current == null){
      head = new ListNode(line, null);
      return head;
    }
    //if we need to insert at the first spot 
    if(current.getValue().toLowerCase().compareTo(line.toLowerCase()) > 0){
      ListNode newNode = new ListNode(line, current);
      head = newNode;
      return newNode;
    }
    //general insertion with no special case
    while(current.getNext() != null) {
      if(current.getNext().getValue().toLowerCase().compareTo(line.toLowerCase()) > 0){
        ListNode newNode = new ListNode(line, current.getNext());
        current.setNext(newNode);
        return newNode;
      }
      current = current.getNext();
    }
    //if node needs to be inserted at the end
    ListNode newNode = new ListNode(line, null);
    current.setNext(newNode);
    return newNode;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line) {
    ListNode prev = head;
    //if the list is empty
    if(prev == null) {
      return null;
    }

    ListNode current = prev.getNext();
    
    //if removing the head
    if(prev.getValue().equals(line)){
      head = prev.getNext();
      return prev;
    }
    //general case
    while(current.getNext() != null) {
      if(current.getValue().equals(line)){
        prev.setNext(current.getNext());
        return current;
      }
      else{
        prev = current;
        current = current.getNext();
      }
    }
    //if last node needs to be removed
    if(current.getValue().equals(line)){
      prev.setNext(null);
      return current;
    }
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues(){
    ListNode current = head;
    String str = "";
    while(current != null) {
      str += current.getValue() + " ";
      current = current.getNext();
    }
    return str;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear(){
    head = null;
  }
}
