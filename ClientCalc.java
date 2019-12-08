package algoAssignmentA;

public class ClientCalc {
	  private int id;
	  private int startTime;

	  public ClientCalc(int id, int time) {
	    this.id = id;
	    System.out.printf("%s arrived at time %d.%n", this, time);
	  }

	  public void setStartTime(int time) {
	    startTime = time;
	  }

	  public int getStartTime() {
		  return startTime;
	  }

	  public String toString() {
	    return "#" + id;
	  }
	}