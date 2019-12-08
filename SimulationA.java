package algoAssignmentA;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Simulation {
  static int numServers;
  static int numClients;
  static int meanServiceTime;
  static int meanInterarrivalTime;
  static ServerCalc[] servers;
  static ClientCalc[] clients;
  public static Queue<ClientCalc> queue = new ArrayDeque<ClientCalc>();

  static java.util.Random randomArrival;
  static java.util.Random randomService;

  static int timeWaited;
  static int totWaitTime = 0;
  static int clock = 0;
  static double averageTimeWaited;
  public static int avgWaitTime;
  public static void main(String[] args) {
	  init(args);
  }

  
static void init(String[] args) {
    if (args.length<4) {
      System.out.println("Usage: java Simulation Single Queue Many Servers ");
      System.out.println(" e.g.: java Simulation 3 100 12 4");
      //System.exit(0);
    }
    @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
    int min1 = 30,min2 = 120;
    int max1 = 45,max2 = 600;    
    int x = (int) ((Math.random()*((max1-min1)+1))+min1);
    int x1 = (int) ((Math.random()*((max2-min2)+1))+min2);
    
    System.out.println("Enter number of Servers: ");
    numServers = scan.nextInt();
    System.out.println("Enter number of Clients: ");
    numClients = scan.nextInt();

    meanServiceTime = x1;
    meanInterarrivalTime = x;

    servers = new ServerCalc[numServers];
    clients = new ClientCalc[numClients];
    randomService = new ExponentialRandom(meanServiceTime);
    randomArrival = new ExponentialRandom(meanInterarrivalTime);
    


      System.out.println("     Number of servers = " + numServers); 
      System.out.println("     Number of clients = " + numClients); 
      System.out.println("     Mean service time = " + meanServiceTime); 
      System.out.println("     Mean interarrival time = " + meanInterarrivalTime); 

      for (int i=0; i<numServers; i++) {
          int meanServiceTime = randomService.nextInt();
          servers[i] = new ServerCalc(i, meanServiceTime);
          System.out.printf("Mean service time for %s: %4.1f%n",
              servers[i], servers[i].getMeanServiceTime());    

        }
     
      int nextArrivalTime = 0;
      for (int t=0, clientId=0; clientId < numClients; t++) {
        if (t == nextArrivalTime) {

          nextArrivalTime = t + randomArrival.nextInt();
          ClientCalc client = clients[clientId] = new ClientCalc(++clientId, t);        
          queue.add(client);

          System.out.println("\tClient queue: " + queue);
          avgWaitTime = nextArrivalTime/numClients;
        }
     
        for (ServerCalc server : servers) {

      	  if (t == server.getStopTime()) {
      	      if (t == nextArrivalTime) {
      	          nextArrivalTime = t + randomArrival.nextInt();
      	          ClientCalc client = clients[clientId] = new ClientCalc(++clientId, t);
      	          queue.add(client);
      	          System.out.println("\tClient queue: " + queue);

      	      
      	        }
            server.stopServing(t);
         
          }
          if (server.isIdle() && !queue.isEmpty()) {
            ClientCalc client = (ClientCalc)queue.remove();
	          timeWaited = nextArrivalTime - client.getStartTime();
	          totWaitTime = totWaitTime + timeWaited;
            System.out.println("\tClient queue: " + queue);
            server.startServing(client,t);
			
            
          }
        }

}	averageTimeWaited = ((double)totWaitTime) / numClients ;
System.out.println("Average time waited = " + averageTimeWaited);
      }

}
