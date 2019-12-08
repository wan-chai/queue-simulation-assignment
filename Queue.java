package algoAssignmentA;

/**
2 * The <code>Queue</code> interface specifies the basic operations
3 * of a first-in-first-out (FIFO) containers.
4 */
 public interface Queue {

 /**
8 * Adds the specified element to the back of this queue.
9 *
10 * @param object the element to be added to this queue.
11 */
 public void add(Object object);

 /**
15 * Returns the element at the front of this queue.
16 *
17 * @return the element at the front of this queue.
18 * @throws IllegalStateException if this queue is empty
19 */
 public Object first();

 /**
23 * Removes and returns the element at the front of this queue.
24 *
25 * @return the element at the front of this queue.
26 * @throws IllegalStateException if this queue is empty
27 */
 public Object remove();

 /**
31 * Returns the number of elements in this queue.
32 *
33 * @return the number of elements in this queue.`
34 */
 public int size();

public boolean isEmpty();
 }
