package practice.concurrency.javaConcurrencyInPractice.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
		public ProductInfo call() throws Exception {
			return loadProductInfo();
		}
	});

	public final Thread thread = new Thread(future);

	public void start() {
		thread.start();
	}

	public ProductInfo loadProductInfo() {
		return null;
	}

	public ProductInfo get() throws InterruptedException {
		try{
			return future.get();
		} catch(ExecutionException e){
			return null;
		}
		
	}
}

class ProductInfo {

}