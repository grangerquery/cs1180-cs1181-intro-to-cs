public class Driver {

	/**
	 * Displays all the items in a linked list then prints out the second-to-last
	 * item.
	 * 
	 * @author Brayden Granger
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("Falcons");
		list.add("Bears");
		list.add("Titans");
		list.add("Eagles");
		list.add("Panthers");
		list.add("Cowboys");
		list.add("Steelers");
		list.add("49ers");
		list.add("Vikings");
		list.add("Saints");
		list.add("Seahawks");

		System.out.println("Full list:\n");
		list.print();
		System.out.println();
		System.out.println("The penultimate item is " + list.getPenultimate());
	}
}