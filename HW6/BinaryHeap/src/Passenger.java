import java.util.*;

/** A class to represent a passenger.
 *  @author Koffman & Wolfgang
 * */

public class Passenger implements Comparable<Passenger> {

    // Data Fields
    /** The ID number for this passenger. */
    private int passengerId;

    /** The time needed to process this passenger. */
    private int processingTime;

    /** The time this passenger arrives. */
    private int arrivalTime;

    /** The maximum time to process a passenger. */
    private static int maxProcessingTime = 32;

    /** The sequence number for passengers. */
    private static int idNum = 0;

    /** Create a new passenger.
     @param arrivalTime The time this passenger arrives */
    public Passenger(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        processingTime = 1 + (new Random()).nextInt(maxProcessingTime);
        passengerId = ++idNum;
    }

    /** Get the arrival time.
     @return The arrival time */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /** Get the processing time.
     @return The processing time */
    public int getProcessingTime() {
        return processingTime;
    }

    /** Get the passenger ID.
     @return The passenger ID */
    public int getId() {
        return passengerId;
    }

    /** Set the maximum processing time*/
    public static void setMaxProcessingTime(int maxProcessTime) {
        maxProcessingTime = maxProcessTime;
    }

    /**Get the max processing time for each passenger
     @return maxProcessingTime return value*/
    public static int getMaxProcessingTime(){
        return maxProcessingTime;
    }

    /***
     * Overriden compareTo method by me
     * This method needed when the each Passenger item added to the
     * Binary Tree its adds according to the this method's comparison
     * @param passenger
     * @return
     */
    @Override
    public int compareTo(Passenger passenger) {
        if (this.processingTime > passenger.processingTime)
            return -1;
        if (this.processingTime < passenger.processingTime)
            return  1;
        return 0;
    }

    /**
     * Overriden toString method of the Passenger
     * @return
     */
    @Override
    public String toString(){
        return "" + passengerId;
    }
}
