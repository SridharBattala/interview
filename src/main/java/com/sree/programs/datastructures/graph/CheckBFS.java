package com.sree.leave.programs.datastructures.graph;

class CheckBFS {
	 static class Queue<V> {
	    private int maxSize;
	    private V[] array;
	    private int front;
	    private int back;
	    private int currentSize;

	    /*
	    Java does not allow generic type arrays. So we have used an
	    array of Object type and type-casted it to the generic type V.
	    This type-casting is unsafe and produces a warning.
	    Un-comment the line below and execute again to see the warning.
	    */
	    @SuppressWarnings("unchecked")
	    public Queue(int maxSize) {
	        this.maxSize = maxSize;
	        array = (V[]) new Object[maxSize];
	        front = 0;
	        back = -1;
	        currentSize = 0;
	    }

	    public int getMaxSize() {
	        return maxSize;
	    }

	    public int getCurrentSize() {
	        return currentSize;
	    }

	    public boolean isEmpty() {
	        return currentSize == 0;
	    }

	    public boolean isFull() {
	        return currentSize == maxSize - 1;
	    }

	    public void enqueue(V value) {
	        if (isFull())
	            return;
	        back = (back + 1) % maxSize; //to keep the index in range
	        array[back] = value;
	        currentSize++;
	    }

	    public V dequeue (){
	        if(isEmpty())
	            return null;

	        V temp = array[front];
	        front = (front + 1) % maxSize; //to keep the index in range
	        currentSize--;

	        return temp;
	    }
	}
    public static String bfsTraversal(Graph g, int source) {

        String result = "";
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you enqueue it into queue
        boolean[] visited = new boolean[num_of_vertices];

        //Create Queue for Breadth First Traversal and enqueue source in it
        Queue<Integer> queue = new Queue<Integer>(num_of_vertices);

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {

            //Dequeue a vertex/node from queue and add it to result
            int current_node = queue.dequeue();

            result += String.valueOf(current_node);

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then enqueue them in the Queue
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //Visit the current Node
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result;
    }
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);


        System.out.println(bfsTraversal(g, 0));
  }
}
