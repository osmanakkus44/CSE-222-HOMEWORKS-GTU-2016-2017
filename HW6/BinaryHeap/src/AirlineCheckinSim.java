/**
 * This is very simple AirlineCheckSimulator written by me to run the serving
 * simulator.
 */
public class AirlineCheckinSim {

    /*The reference to construct the BinaryHeap Tree */
    private BinaryHeap<Passenger> myHeap = new BinaryHeap<>();

    private int totalTime = 5;

    int time = 0;

    /**
     * This function adds news passenger as the value of the total time
     * to test them
     */
    public void runSimulation(){
        for (time = 0; time < totalTime; time++) {
            myHeap.addNewPassenger(time);
        }
        makeTheServe();
    }

    /***
     * This function accepts poll a new passenger for serving
     * as priority value after each poll the smallest value served by this
     * function
     */
    private void makeTheServe(){
        System.out.println(myHeap);
        while(!myHeap.isEmpty()){
            myHeap.poll();
            System.out.println(myHeap);
        }
    }
}
