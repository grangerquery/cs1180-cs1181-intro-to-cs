public class LinkedList {
	private Node head;
	private Node tail;

	public void add(String item) {
		Node newItem = new Node(item);

		// handles the case where the new item
		// is the only thing in the list
		if (head == null) {
			head = newItem;
			tail = newItem;
			return;
		}

		tail.next = newItem;
		tail = newItem;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.println(current.item);
			current = current.next;
		}
	}

	/**
	 * Gets the item of the second-to-last node in the linked list
	 * 
	 * @return The item of the penultimate node
	 */
	public String getPenultimate() {
		Node current = head;
		String penultimate = "";

		// Checks if the linked list is empty or only has one node
		if (head == tail) {
			return null;
		}
		// Finds the penultimate item
		else {
			while (current.next.next != null) {
				penultimate = current.next.item;
				current = current.next;
			}
			return penultimate;
		}
	}

	class Node {
		String item;
		Node next;

		public Node(String item) {
			this.item = item;
			this.next = null;
		}
	}
}