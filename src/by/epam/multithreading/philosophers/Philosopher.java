package by.epam.multithreading.philosophers;

import java.util.Random;

import org.apache.log4j.Logger;

/*
 * Comments for this class are the same as logger messages.
 */

public class Philosopher implements Runnable {
	
	private final static Logger logger = Logger.getRootLogger();

	private String name;
	private Fork bigFork;
	private Fork littleFork;
	private boolean intellectualize = true;
	private Random random;

    public Philosopher(String name, Fork fork1, Fork fork2) {
        this.name = name;
        this.random = new Random();
        if (fork1.getForkId() > fork2.getForkId()) {
            this.bigFork = fork1;
            this.littleFork = fork2;
        } else {
            this.bigFork = fork2;
            this.littleFork = fork1;
        }
    }

    @Override
    public void run() {
        logger.debug("Philosopher " + name + " sitting at the table.");

        try {
            while (intellectualize) {
            	int thinkingTime = random.nextInt(3000);
                logger.debug("Philosopher " + name + " will be thinking next " + thinkingTime + " ms.");
                Thread.sleep(thinkingTime);

                // Philosopher takes a little fork (and temporary locks it), or waits until the fork will be free.
                synchronized (littleFork) {
                    logger.debug("Philosopher " + name + " took little fork.");
                    Thread.sleep(200);
                    
                    // Philosopher takes a big fork (and temporary locks it), or waits until the fork will be free.
                    synchronized (bigFork){
                        logger.debug("Philosopher " + name + " took big fork.");
                        
                        // Philosopher holds time for meal, using two forks (both forks locked by this philosopher).
                        int eatingTime = random.nextInt(3000);
                        logger.debug("Philosopher " + name + " will be eating next " + eatingTime + " ms.");
                        Thread.sleep(eatingTime);
                    }
                    
                    logger.debug("Philosopher " + name + " finish eating and put big fork at the table.");
                }
                
                logger.debug("Philosopher " + name + " put little fork at the table too.");
                // Philosopher unlocks two forks.
            }
            
            logger.debug("Philosopher " + name + " finish intellectualize.");
        
        } catch (InterruptedException e) {
            logger.error("Philosopher " + name + " unexpectedly died.");
        }
    }

    public void stopIntellectualize() {
    	intellectualize = false;
    }
}
