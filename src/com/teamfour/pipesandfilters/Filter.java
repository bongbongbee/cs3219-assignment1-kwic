package com.teamfour.pipesandfilters;

public abstract class Filter implements Runnable {
	protected Pipe input_, output_;
	private boolean started;
	
	public Filter(Pipe input, Pipe output) {
		input_ = input;
		output_ = output;
	}
	
	public void start() {
		//System.out.println("thread has started---------------------------------------------------------------------------------------");

		if (!started) {
			Thread thread = new Thread(this);
			thread.start();

			started = true;
		}
	}
	public void stop() {
		//System.out.println("thread has stopped*********************************************************************************************");
		started = false;
	}
	public void run() {
		transform();
	}
	protected abstract void transform();
}
