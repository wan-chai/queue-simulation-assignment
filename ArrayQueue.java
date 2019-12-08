package algoAssignmentA;

public class ArrayQueue implements Queue {
	  private Object[] a;
	  private int front, back;
	
	public ArrayQueue(int capacity) {
	  a = new Object[capacity];
	}
	
	public void add(Object object) {
	  if (back == a.length) resize();
	  a[back++] = object;
	}
	
	public Object first() {
	  if (size()==0) throw new IllegalStateException("queue is empty");
	  return a[front];
	}

	public boolean isEmpty() {
		  return (size() == 0);
		}
		
		public Object remove() {
		  if (size()==0) throw new IllegalStateException("queue is empty");
		  Object object=a[front];
		  a[front++]=null;
		  return object;
		}
		
		public int size() {
		  return back - front;
		}
		private void resize() {
		  Object[] aa = a;
		  a = new Object[2*aa.length];
		  System.arraycopy(aa, front, a, 0, size());
		}
		}
