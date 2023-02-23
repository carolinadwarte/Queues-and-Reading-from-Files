/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Carolina Duarte
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {
	private QueueElement<T> front;//reference to the front of the queue
	private QueueElement<T> tail;//reference to the end of the queue



	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		this.front = null;
		this.tail = null;
	}

	/**
	 * Checks if the queue is empty
	 * @return true if the queue is empty
	 */
	public boolean isEmpty () {
		return ((front == null) && (tail == null));
	}


	/**
	 * Method to look at the first object of the queue
	 * @return the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.front.getElement();
	}

	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		this.front = this.front.getNext();
		if (isEmpty()){
			this.tail=null;
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 * @param element of type T
	 */
	public void enqueue (T element) {
		if (element==null){
			throw new NullPointerException();
		}
		QueueElement<T> newNode = new QueueElement<>(element,null);
		if (isEmpty()){
			this.front = newNode;
			this.tail = newNode;
		}else {
			this.tail.setNext(newNode);
		}
		this.tail = newNode;
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		while (this.front!=null){
			System.out.println(this.front.getElement());
			front = this.front.getNext();
		}
	}
}