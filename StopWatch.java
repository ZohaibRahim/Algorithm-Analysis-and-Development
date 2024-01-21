public class StopWatch {
    private long startTime;
    private double elapsedTime;

    // Creates a new StopWatch, which is initially stopped with zero elapsed time.
    public StopWatch() {
        this.elapsedTime = 0;
        this.startTime = 0;
    }

    // Returns the elapsed CPU time in seconds at the time of the call.
    public double elapsed() {
        return this.elapsedTime;
    }

    // Returns true if the stopwatch is running.
    public boolean isRunning() {
        return this.startTime != 0;
    }

    // Starts the stop watch. Has no effect if the stop watch is already started. Does not reset the time. Returns this.
    public StopWatch start() {
        if (!isRunning()) {
            this.startTime = System.nanoTime();
        }
        return this;
    }

    // Stops the stop watch. Has no effect if the stop watch is already stopped. Does not reset the time. Returns this.
    public StopWatch stop() {
        if (isRunning()) {
            this.elapsedTime += (System.nanoTime() - this.startTime);
            this.startTime = 0;
        }
        return this;
    }

    // Resets the elapsed time to zero. Neither starts nor stops the stop watch. Returns this.
    public StopWatch reset() {
        this.elapsedTime = 0;
        this.startTime = 0;
        return this;
    }
}
/** ACCURACY OF THE STOPWATCH:
    The accuracy of the StopWatch class is ensured through the use of System.nanoTime() for measuring elapsed time,
    providing a high level of precision suitable for capturing short durations. The consistent storage of elapsed time
    in nanoseconds eliminates the need for unit conversions, maintaining a uniform basis for time comparisons.
    The start() and stop() methods correctly handle the start and stop logic, contributing to accurate elapsed time
    calculations. The reset() method efficiently resets both elapsed time and start time, offering a clean slate for
    subsequent measurements. The return type clarity of start() and stop() methods allows for a fluent interface and
    clear usage. Overall, the StopWatch class is designed to provide reliable and accurate timing measurements.

 ADDITION:
 Size	Time (ns)
 8	    2200.0
 16	    6050.0
 64	    13250.0
 128	15900.0
 512	10500.0
 1024	16700.0

 Size (bits) vs. Time (ns):
    As the size of the numbers increases, the time taken for addition also generally increases.

 Scaling Factor:
    When you double the size (bits) from 8 to 16, the time approximately triples (e.g., 2200.0 ns to 6050.0 ns).
    Similarly, when you double the size from 16 to 64, the time approximately doubles (e.g., 6050.0 ns to 13250.0 ns).

 Factor of 4 Increase:
     If you increase the problem size by a factor of 4 (e.g., from 8 to 32 bits or from 16 to 64 bits), the running time might increase roughly by a factor of 4, considering the trend observed in the provided data.


 MULTIPLICATION:
 Size	Time (ns)
 8	    6000.0
 16	    2650.0
 64	    4700.0
 128	2200.0
 512	11000.0
 1024	38550.0

 Size (bits) vs. Time (ns):
     Similar to addition, as the size of the numbers increases, the time taken for multiplication generally increases.

 Scaling Factor:
    Doubling the size from 8 to 16 bits leads to a significant decrease in time (e.g., 6000.0 ns to 2650.0 ns).
    The time seems to increase as the size goes from 16 to 64 bits and further increases for larger sizes.

 Factor of 4 Increase:
    Increasing the problem size by a factor of 4 may not result in a consistent increase in running time. The trend
    is not strictly linear, and the relationship might be influenced by various factors.


 OVERALL:
 Complexity:
    The running times for both addition and multiplication operations do not exhibit a simple linear relationship with
    the problem size.

 Algorithmic Complexity:
     The observed patterns suggest that the operations might have a higher-than-linear complexity, possibly related to
    the algorithms used for addition and multiplication.

 Optimizations:
    The running times may also be influenced by internal optimizations implemented in the BigInteger class or the Java
    runtime environment.

 Asymptotic Behavior:
     Asymptotically, the running time may approach a polynomial or even exponential relationship with the problem size.

 In summary, the running times for addition and multiplication do not seem to exhibit a straightforward linear
 relationship with the problem size, suggesting more complex underlying factors influencing the performance.
 The functional relation between problem size and running time may involve higher-order complexities or optimizations
 implemented in the BigInteger class.
 */
