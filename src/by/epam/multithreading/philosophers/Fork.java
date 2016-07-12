package by.epam.multithreading.philosophers;

/*
 * RESOURCE HIERARCHY SOLUTION
 * This solution assigns a partial order to the resources (the forks), and establishes the convention 
 * that all resources will be requested in ORDER, and that no two resources unrelated by order will ever be 
 * used by a single unit of work at the same time. Here, the resources (forks) will be numbered 
 * 1 through 5 and each philosopher will always pick up the lower-numbered fork first, and then 
 * the higher-numbered fork, from among the two forks he plans to use - and will return in the reverse order.
 */

public class Fork {
	private int id;

	public Fork(int id) {
		this.id = id;
	}

	public int getForkId() {
		return id;
	}

	public void setForkId(int id) {
		this.id = id;
	}
}
