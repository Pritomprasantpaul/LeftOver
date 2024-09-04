package com.demo.rough;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading{

	public static void main(String[] args) throws Exception {
		Runnable r = () -> {
			System.out.println("Hello");
		};
		
		Thread thread = new Thread(r);
		thread.start();
		
		
		Callable<String[]> c = () -> {
			String data = System.getenv("VARNAME");
			String[] arr = { data };
			return data!=null?arr:null;
		};
		
		System.out.println(c.call());
		
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute( () ->
			System.out.println("Asnchronous Task")
				);
		service.shutdown();
		
		ExecutorService  service2 = Executors.newScheduledThreadPool(4);
		System.out.println( service2.toString() );
		service2.execute( () ->
				System.out.println("Execute \n"+service2.submit( () ->
				System.out.println("Run")
						))
				);
		service2.shutdown();
		System.out.println(service2.toString());
	}
}
