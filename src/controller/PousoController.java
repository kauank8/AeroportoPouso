package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PousoController extends Thread {
	private int aviao;
	private Semaphore semaforo;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private static int pista=0;
			
	public PousoController(int aviao,Semaphore semaforo,Semaphore semaforo1,Semaphore semaforo2) {
		this.aviao=aviao;
		this.semaforo=semaforo;
		this.semaforo1=semaforo1;
		this.semaforo2=semaforo2;
	}
	
	@Override
	public void run() {
		try {
			semaforo2.acquire();
			Decolar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo2.release();
		}
	}
	
	private void Decolar() {
		Random gerador =new Random();
		pista=gerador.nextInt(2)+1;
		if(pista==1) {
			try {
				semaforo1.acquire();
				System.out.println("O Aviao:" +aviao+ " entrou na pista norte" );
				InicioDecolagem();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo1.release();
			}
		}
			if(pista==2) {
				try {
					semaforo.acquire();
					System.out.println("O Aviao:" +aviao+ " entrou na pista sul" );
					InicioDecolagem();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaforo.release();
				}
		}

	}
	
	public void InicioDecolagem() {
		Random gerador =new Random();
		int tempo;
		//manobrar
		tempo=gerador.nextInt(4)+3;
		System.out.println("O Aviao:" +aviao+ " iniciou a manobra, aguarde: " + tempo+" segundos");
			try {
				sleep(tempo*1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//taxiar
			tempo=gerador.nextInt(5)+5;
			System.out.println("O Aviao:" +aviao+ " iniciou a taxiar, aguarde: " + tempo+" segundos");
			
			try {
				sleep(tempo*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//decolagem
			tempo=gerador.nextInt(4)+1;
			System.out.println("O Aviao:" +aviao+ " iniciou a decolagem, aguarde: " + tempo+" segundos");
			
			try {
				sleep(tempo*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Afastamento
			tempo=gerador.nextInt(5)+3;
			System.out.println("O Aviao:" +aviao+ " iniciou o afastamento, aguarde: " + tempo+" segundos");
			
			try {
				sleep(tempo*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("O Aviao:" + aviao + " Saiu");
			
	}
}
