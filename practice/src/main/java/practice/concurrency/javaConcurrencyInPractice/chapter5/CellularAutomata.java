package practice.concurrency.javaConcurrencyInPractice.chapter5;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class CellularAutomata {
	
	public static void main(String[] args){
		Board mainBoard = new Board(0,0);
		CellularAutomata obj = new CellularAutomata(mainBoard,10);
		obj.start();
		while(!mainBoard.isDone()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(mainBoard.getZ());
	}
	
	private final Board mainBoard;
	private final CyclicBarrier barrier;
	private final Worker[] workers;
	
	public CellularAutomata(Board board,int count){
		this.mainBoard = board;
		this.barrier = new CyclicBarrier(count,new Runnable(){
			public void run(){
				mainBoard.commitNewValues();
			}
		});
		this.workers = new Worker[count];
		for (int i=0;i<count;i++){
			workers[i] = new Worker(mainBoard.getSubBoard(i,i));
		}
	}
	
	
	private class Worker implements Runnable{
		private final Board board;
		public Worker(Board board){
			this.board = board;
		}
		
		public void run(){

				int x = board.getX();
				int y = board.getY();
				board.setNewValue(computeValue(x,y));
				try {
					barrier.await();
				} catch (InterruptedException ex){
					return;
				}catch(BrokenBarrierException ex){
					return;
				}
		}
		
		private int computeValue(int x,int y){
			return x+y;
		}
	}
	
	public void start(){
		for (int i=0;i<workers.length;i++){
			new Thread(workers[i]).start();
		}
		mainBoard.waitForConvergence();
	}
	
}

class Board {
	private volatile boolean done = false;
	private volatile int x;
	private volatile int y;
	private volatile int z;
	public void waitForConvergence(){}
	List<Board> lst = new CopyOnWriteArrayList<Board>();
	
	public boolean isDone(){
		return done;
	}
	public Board(int x,int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public int getZ(){
		return z;
	}
	
	public void setNewValue(int value){
		z = value;
	}
	
	public Board getSubBoard(int x,int y){
		Board sub = new Board(x,y);
		lst.add(sub);
		return sub;
	}
	
	public void commitNewValues(){
		for(Board b:lst){
			z += b.getZ();
		}
		done = true;
	}
}

