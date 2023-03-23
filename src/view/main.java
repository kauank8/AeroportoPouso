package view;

import java.util.concurrent.Semaphore;

import controller.PousoController;

public class main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		Semaphore semaforo1 = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore(2);
		for(int i=0; i<12;i++) {
			Thread decolagem = new PousoController(i,semaforo,semaforo1,semaforo2);
			decolagem.start();
		}
	}

}
