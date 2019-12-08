package algoAssignmentA;
public interface Server {
    public int getMeanServiceTime();
    public int getStopTime();
    public boolean isIdle();
    public void startServing(Client[] clients, int t);
    public void stopServing(int t);
 }
