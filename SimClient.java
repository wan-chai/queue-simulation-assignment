package algoAssignmentA;
public class SimClient implements Client {
  int id, arrivalTime=-1;
static int startTime=-1;
static int stopTime=-1;
  
  public SimClient(int id, int t) {
    this.id = id;
    arrivalTime = t;
    System.out.println(this + " arrived at time " + t);  }
  
  public static int getStartTime() {
    return startTime;  
    }
  
  public static int getStopTime() {
    return stopTime;  
    }
  
  public void setStartTime(int t) {
    startTime = t;  
    }
  
  public void setStopTime(int t) {
    stopTime = t;  
    }
  
  public String toString() {
    return "Client " + id;  
  } 
}
