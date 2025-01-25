/**
 * Represents a list of Nodes. 
 */
public class LinkedList {
	
	private Node first; // pointer to the first element of this list
	private Node last;  // pointer to the last element of this list
	private int size;   // number of elements in this list
	
	/**
	 * Constructs a new list.
	 */ 
	public LinkedList () {
		first = null;
		last = first;
		size = 0;
	}
	
	/**
	 * Gets the first node of the list
	 * @return The first node of the list.
	 */		
	public Node getFirst() {
		return this.first;
	}

	/**
	 * Gets the last node of the list
	 * @return The last node of the list.
	 */		
	public Node getLast() {
		return this.last;
	}
	
	/**
	 * Gets the current size of the list
	 * @return The size of the list.
	 */		
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public void setLast(Node last) {
		this.last = last;
	}
	
	/**
	 * Gets the node located at the given index in this list. 
	 * 
	 * @param index
	 *        the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 * @return the node at the given index
	 */		
	public Node getNode(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException(
					"index must be between 0 and size");
		}
		//// Replace the following statement with your code
		Node cur = this.first;  
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
	
		return cur;
		}
	
	/**
	 * Creates a new Node object that points to the given memory block, 
	 * and inserts the node at the given index in this list.
	 * <p>
	 * If the given index is 0, the new node becomes the first node in this list.
	 * <p>
	 * If the given index equals the list's size, the new node becomes the last 
	 * node in this list.
     * <p>
	 * The method implementation is optimized, as follows: if the given 
	 * index is either 0 or the list's size, the addition time is O(1). 
	 * 
	 * @param block
	 *        the memory block to be inserted into the list
	 * @param index
	 *        the index before which the memory block should be inserted
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than the list's size
	 */
	public void add(int index, MemoryBlock block) {
		//// Write your code here
   
    Node node = new Node(block);

    
    if (index == 0) 
	{
        node.next = this.first;
        this.first = node;
        if (this.size == 0) 
		{
            this.last = node;
        }
    } 
    else if (index == size) 
	{
        if (this.first == null) 
		{
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            this.last = node;
        }
    } 
    else {
        Node cur = this.first;
        for (int i = 0; i < index - 1; i++) 
		{
            cur = cur.next;
        }
        // Insert new node after current node
        node.next = cur.next;
        cur.next = node;
    }

    size++;
	}

	/**
	 * Creates a new node that points to the given memory block, and adds it
	 * to the end of this list (the node will become the list's last element).
	 * 
	 * @param block
	 *        the given memory block
	 */
	public void addLast(MemoryBlock block) {

		add(size, block);

	}
	
	/**
	 * Creates a new node that points to the given memory block, and adds it 
	 * to the beginning of this list (the node will become the list's first element).
	 * 
	 * @param block
	 *        the given memory block
	 */
	public void addFirst(MemoryBlock block) {

		add(0, block);
	}

	/**
	 * Gets the memory block located at the given index in this list.
	 * 
	 * @param index
	 *        the index of the retrieved memory block
	 * @return the memory block at the given index
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than or equal to size
	 */
	public MemoryBlock getBlock(int index) 
	{
		if (index < 0 || index >= this.getSize()) {
			throw new IllegalArgumentException("index must be between 0 and size");
		}
	
		if (this.first == null) {
			throw new IllegalArgumentException("index must be between 0 and size");
		}
	
		Node current = this.first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
	
		return current.block;
	}	

	/**
	 * Gets the index of the node pointing to the given memory block.
	 * 
	 * @param block
	 *        the given memory block
	 * @return the index of the block, or -1 if the block is not in this list
	 */
	public int indexOf(MemoryBlock block) 
	{
		
		Node cur = this.first;
		int index = 0;
	
		
		while (cur != null) 
		{
			if (cur.block.equals(block)) 
			{
				return index; 
			}
			cur = cur.next;  
			index++;  
		}

		return -1;
	}

	/**
	 * Removes the given node from this list.	
	 * 
	 * @param node
	 *        the node that will be removed from this list
	 */
public void remove(Node node) 
{
    if (node == null) 
    {
        throw new NullPointerException("Node cannot be null");
    }

    if (first == null) 
    {
        return;
    }

    if (node == this.first) 
    {
        this.first = this.first.next;
        if (this.first == null) 
        { 
            this.last = null;
        }
    } else 
    {
        Node cur = this.first;
        while (cur != null && cur.next != node) 
        {
            cur = cur.next;
        }

        if (cur != null && cur.next == node) 
        {
            cur.next = node.next;  
            if (node == this.last) 
            {
                this.last = cur;
            }
        }
    }

    size--;
}

	/**
	 * Removes from this list the node which is located at the given index.
	 * 
	 * @param index the location of the node that has to be removed.
	 * @throws IllegalArgumentException
	 *         if index is negative or greater than or equal to size
	 */
	public void remove(int index) {
		
			if (index == 0) 
			{
				first = first.next;  
				if (first == null) 
				{  
					last = null;
				}
			} else 
			{
				
				Node cur = first;
				for (int i = 0; i < index - 1; i++) 
				{
					cur = cur.next; 
				}
		
				
				Node nodeRemove = cur.next;
				cur.next = nodeRemove.next;  
		
				
				if (nodeRemove == last) 
				{
					last = cur;  
				}
			}

			size--;
	}

	/**
	 * Removes from this list the node pointing to the given memory block.
	 * 
	 * @param block the memory block that should be removed from the list
	 * @throws IllegalArgumentException
	 *         if the given memory block is not in this list
	 */
	public void remove(MemoryBlock block) 
	{
		if (block == null) {
			throw new IllegalArgumentException("Memory block cannot be null");
		}
	
		if (this.first == null) 
		{
			throw new IllegalArgumentException("Memory block not found in list");
		}
	
		if (this.first.block.equals(block)) 
		{
			first = this.first.next;
			if (this.first == null) {
				this.last = null;
			}
			size--;
			return;
		}
	
		Node cur = this.first;
		while (cur != null && cur.next != null) 
		{
			if (cur.next.block.equals(block)) 
			{
				Node nodeRemove = cur.next;
				cur.next = cur.next.next;
	
				if (nodeRemove == this.last) 
				{
					this.last = cur;
				}
	
				size--;
				return;
			}
			cur = cur.next;
		}
	
		throw new IllegalArgumentException("Memory block not found in list");
	}

	/**
	 * Returns an iterator over this list, starting with the first element.
	 */
	public ListIterator iterator(){
		return new ListIterator(first);
	}
	
	/**
	 * 
	 */
	public String toString() {
		
		String result = "";
		Node cur = this.first; 
		while (cur != null) 
		{
			result += cur.toString(); 
			if (cur.next != null) 
			{
				result += " -> "; 
			}
			cur = cur.next;
		}
		return result;
	}
}