package algoAssignmentA;


public class ServerCalc {
	  private ClientCalc client;
	  private int id;
	  private int stopTime = -1;
	  private double meanServiceTime;
	  private ExponentialRandom random;

	  public ServerCalc(int id, double meanServiceTime) {
	    this.id = id;
	    this.meanServiceTime = meanServiceTime;
	    this.random = new ExponentialRandom(meanServiceTime);
	  }

	  public double getMeanServiceTime() {
	    return meanServiceTime;
	  }

	  public int getStopTime() {
	    return stopTime;
	  }

	  public boolean isIdle() {
	    return client == null;
	  }

	  public void startServing(ClientCalc client, int time) {
	    this.client = client;
	    this.client.setStartTime(time);
	    this.stopTime = time + random.nextInt();
	    System.out.printf("%s started serving client %s at time %d, stop time %d.%n",
	        this, client, time, this.stopTime);
	  }
	    
	  public void stopServing(int time) {
	    System.out.printf("%s stopped serving client %s at time %d.%n",
	        this, client, time);
	    client = null;
	  }

	  public String toString() {
	    return "Server " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(id);
	  }
	}