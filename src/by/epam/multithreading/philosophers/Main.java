package by.epam.multithreading.philosophers;

public class Main {
	
	public static void main(String[] args) {
		
		Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosopher philosopher1 = new Philosopher("#1", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("#2", fork2, fork3);
        Philosopher philosopher3 = new Philosopher("#3", fork3, fork4);
        Philosopher philosopher4 = new Philosopher("#4", fork4, fork5);
        Philosopher philosopher5 = new Philosopher("#5", fork5, fork1);

        new Thread(philosopher1).start();
        new Thread(philosopher2).start();
        new Thread(philosopher3).start();
        new Thread(philosopher4).start();
        new Thread(philosopher5).start();

        try {
            Thread.sleep(7000);
            
            philosopher1.stopIntellectualize();
            philosopher2.stopIntellectualize();
            philosopher3.stopIntellectualize();
            philosopher4.stopIntellectualize();
            philosopher5.stopIntellectualize();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}
