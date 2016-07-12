package by.epam.multithreading.philosophers;

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
