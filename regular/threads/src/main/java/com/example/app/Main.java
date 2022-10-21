package com.example.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();	
		
		main.countByAnonimousMethod(main, 2);
//		main.countByCustomThread(main, 2);
//		main.countByCustomRunnable(main, 2);
//		main.countByExecutorService(main, 2);
		
	}
	
	public void countByAnonimousMethod(Main main, int threadsCount) {
		
		Thread thread;
		for (int i = 1; i <= threadsCount; i++) {
			thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					main.count();				
				}
				
			});
			thread.setName("Thread-" + i);
			thread.start();
		}
			
	}
	
	public void countByCustomThread(Main main, int threadsCount) {
		
		Thread thread;
		for (int i = 1; i <= threadsCount; i++) {
			thread = new CustomThread(main);
			thread.setName("Thread-" + i);
			thread.start();
		}
			
	}
	
	public void countByCustomRunnable(Main main, int threadsCount) {
		
		Thread thread;
		for (int i = 1; i <= threadsCount; i++) {
			thread = new Thread(new CustomRunnable(main));
			thread.setName("Thread-" + i);
			thread.start();
		}
			
	}
	
	public void countByExecutorService(Main main, int threadsCount) {
			
		ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
		for (int i = 1; i <= threadsCount; i++) {
			
			final int index = i;
			
			executorService.submit(() -> {
		        final Thread currentThread = Thread.currentThread();
		        currentThread.setName("Thread-" + index);
		        main.count();
		    });
			
		}
		executorService.shutdown();		
			
	}
	
	// ***** HELP METHODS ***** //
	
	public void count() {
		
		for (int i = 1; i < 101; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i );
		}
		
	}

}

class CustomThread extends Thread {
	
	private Main main;

	public CustomThread(Main main) {
		this.main = main;		
	}	
	
	@Override
	public void run() {
		main.count();				
	}
	
}

class CustomRunnable implements Runnable {
	
	private Main main;
	
	public CustomRunnable(Main main) {
		this.main = main;
	}

	@Override
	public void run() {
		main.count();				
	}
	
}