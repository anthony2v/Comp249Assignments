/**
 * Anthony van Voorst - 40001890
 * COMP 249
 * Assignment #4 Part 2
 * April 10, 2019
 * This CellList class is a linked list that has one inner class called CellNode. It is a basic linked list with each
 * CellNode holding a CellPhone object.
 */

public class CellList implements Cloneable {
    private class CellNode implements Cloneable{
		private CellPhone PhoneObject;
		private CellNode next;
		private CellNode(){
			PhoneObject = null;
			next = null;
		}
		private CellNode(CellPhone PhoneObject, CellNode next){
			this.PhoneObject = PhoneObject;
			this.next = next;
			size++;
		}
		private CellNode(CellNode otherCellNode){
			this(otherCellNode.PhoneObject, otherCellNode.next);
		}
		protected CellNode clone(){
			return new CellNode(this);
		}
        private CellPhone getPhoneObject() {
			return PhoneObject;
		}
        private void setPhoneObject(CellPhone phoneObject) {
			PhoneObject = phoneObject;
		}
        private CellNode getNext() {
			return next;
		}
        private void setNext(CellNode next) {
			this.next = next;
		}
	}
	private CellNode head;
	private int size;

    /**
     * Default constructor for CellList.
     */
	public CellList(){
		head = null;
		size = 0;
	}

    /**
     * Copy constructor for CellList.
     * @param otherCellList The CellList object to be copied.
     */
	public CellList(CellList otherCellList){
		this.head = otherCellList.head;
		this.size = otherCellList.size;
    }

	/**
	 *
	 * @return Current size of the calling CellList.
	 */
	public int getSize(){
	    return size;
    }

    /**
     * Adds a CellNode to the start of the list with the specified data. The added CellNode will be the first node on
     * the list.
     * @param cellPhoneToAdd The corresponding CellPhone that's to be added to the list.
     */
	public void addToStart(CellPhone cellPhoneToAdd){
		CellNode temp = new CellNode(cellPhoneToAdd, head); //Turns the old head into the next the node.
		head = temp; //Makes CellPhoneToAdd the head of the list.
		temp = null;
	}

    /**
     * Iterates through the CellList and deletes the CellPhone at the given index. It will do add the CellNode to the
     * head of the list if the CellList is empty.
     * @param cellPhoneToInsert
     * @param indexNumber
     * @throws NoSuchElementException
     */
	public void insertAtIndex(CellPhone cellPhoneToInsert, int indexNumber) throws NoSuchElementException{
        CellNode temp = head;
        if (indexNumber == 0 || indexNumber == size)
        	addToStart(cellPhoneToInsert);
        else if (indexNumber < 0 || indexNumber > size)
            throw new NoSuchElementException();
        else if (cellPhoneToInsert == null);
        else{
			int counter = 1;
            while(temp != null){
            	if(counter == indexNumber - 1){
            		temp.next = new CellNode(cellPhoneToInsert, temp.next);
            		return;
				}
            	temp = temp.next;
				counter++;
			}
        }
    }

	/**
	 * Iterates through the CellList and deletes the CellPhone at the given index. It will do nothing if the CellList
	 * is empty.
	 * @param indexNumber The position of the CellNode to be deleted.
	 * @throws NoSuchElementException Thrown if the given index is out of bounds.
	 */
	public void deleteFromIndex(int indexNumber) throws NoSuchElementException{
		CellNode temp = head;
		if (indexNumber == 0)
			deleteFromStart();
		else if (indexNumber < 0 || indexNumber > size)
			throw new NoSuchElementException();
		else{
			int counter = 1;
			while(temp != null){
				if(counter == indexNumber - 1){
				    if (counter == size - 1)
				        temp.next = null;
				    else
					    temp.next = temp.next.next;
					size--;
					return;
				}
				temp = temp.next;
				counter++;
			}
		}
    }

    /**
     * Removes the head CellNode and returns true if the list contains at least one node. Returns false otherwise.
     * @return Confirmation that the list still has CellNodes.
     */
    public boolean deleteFromStart(){
	    if (head != null){
	        head = head.getNext();
	        size--;
	        return true;
        }
	    else
	        return false;
    }

	/**
	 * Iterates through the CellList and replaces the CellPhone at the given index. It will do nothing if the CellList
	 * is empty.
	 * @param newCellPhone The CellPhone used to replace the one at the index.
	 * @param indexNumber The position of the CellNode to be replaced.
	 * @throws NoSuchElementException Thrown if the given index is out of bounds.
	 */
	public void replaceAtIndex(CellPhone newCellPhone, int indexNumber) throws NoSuchElementException{
		CellNode temp = head;
		if (indexNumber == 0)
			head =  new CellNode(newCellPhone, temp.next);
		else if (indexNumber < 0 || indexNumber > size)
			throw new NoSuchElementException();
		else if (newCellPhone == null);
		else{
			int counter = 1;
			while(temp != null){
				if(counter == indexNumber - 1){
				    if(counter == size - 1)
					    temp.next = new CellNode(newCellPhone, null);
				    else
                        temp.next = new CellNode(newCellPhone, temp.next.next);
					size--;
					return;
				}
				temp = temp.next;
				counter++;
			}
		}
    }

    /**
     * Finds the first CellNode containing the target serial number, and returns a reference to that CellNode. If the
     * target is not in the list, null is returned. This causes a privacy leak because it returns a reference to a
     * private CellNode object. The fix should be to return a deep copy of the CellNode.
     * @param target The serial number that is being searched for.
     * @return The memory address of the CellNode with the target serial number.
     */
    public CellNode find(long target){
    	int iterations = 0;
	    CellNode position = head;
	    long numberAtPosition;
	    while(position != null){ //this is the way you traverse an entire linked list
	        numberAtPosition = position.PhoneObject.getSerialNum();
            if(numberAtPosition == target) {
				System.out.println("Iterations performed for find(): " + iterations);
            	return position;
            }
            position = position.getNext();
            iterations++;
        }
		System.out.println("Iterations performed for find(): " + iterations);
	    return null; //target was not found
    }

	/**
	 * This makes use of find() to see if the given serial number is part of the CellList.
	 * @param target The serial number of the CellPhone that's being looked for.
	 * @return True if the CellPhone is in the CellList, false otherwise.
	 */
	public boolean contains(long target){
        return (find(target) != null);
    }

	/**
	 * This will display the contents of the calling CellList in a readable fashion.
	 */
	public void showContents(){
		CellNode temp = head; //Gets the first CellNode in the list.
		if(temp == null)
			System.out.println("There is nothing to display; list is empty.");
		else {
			System.out.println("The current size of the list is " + size + ". Here are the contents of the list.");
			int counter = 0;
			while(temp != null){ //Loops until there are no further CellNodes.
				System.out.print(temp.PhoneObject + " ---> ");
				temp = temp.next; //Gets the next CellNode in the list.
				counter++;
				if(counter % 3 == 0)
					System.out.println(); //Creates a new line after every 3 CellNodes.
			}
		}
	}

	/**
	 * Compares 2 CellList object for equality.
	 * @param otherObject The other CellList to test for equality.
	 * @return True if the 2 lists are equal. False otherwise.
	 */
	public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            CellList otherCellList = (CellList)otherObject;
            if(size != otherCellList.size)
                return false;
            CellNode position = head;
            CellNode otherPosition = otherCellList.head;
            while(position != null){
                if(!position.getPhoneObject().equals(otherPosition.getPhoneObject()))
                    return false;
                position = position.next;
                otherPosition = otherPosition.next;
            }
            return true; //No mismatch found.
        }
    }
}
