package com.sree.programs.datastructures.graph;

class CheckDFS {
	static class Stack<V> {
	    private int maxSize;
	    private int top;
	    private V[] array;
	    private int currentSize;

	    /*
	    Java does not allow generic type arrays. So we have used an
	    array of Object type and type-casted it to the generic type V.
	    This type-casting is unsafe and produces a warning.
	    Un-comment the line below and execute again to see the warning.
	    */
	    @SuppressWarnings("unchecked")
	    public Stack(int maxSize) {
	        this.maxSize = maxSize;
	        this.top = -1; //initially when stack is empty
	        array = (V[]) new Object[maxSize];//type casting Object[] to V[]
	        this.currentSize = 0;
	    }

	    public int getCurrentSize() {
	        return currentSize;
	    }

	    //returns the maximum size capacity
	    public int getMaxSize() {
	        return maxSize;
	    }

	    //returns true if Stack is empty
	    public boolean isEmpty() {
	        return top == -1;
	    }

	    //returns true if Stack is full
	    public boolean isFull() {
	        return top == maxSize - 1;
	    }

	    //returns the value at top of Stack
	    public V top() {
	        if (isEmpty())
	            return null;
	        return array[top];
	    }

	    //inserts a value to the top of Stack
	    public void push(V value) {
	        if (isFull()) {
	            System.err.println("Stack is Full!");
	            return;
	        }
	        array[++top] = value; //increments the top and adds value to updated top
	        currentSize++;
	    }

	    //removes a value from top of Stack and returns
	    public V pop() {
	        if (isEmpty())
	            return null;
	        currentSize--;
	        return array[top--]; //returns value and top and decrements the top
	    }

	}

    public static String dfsTraversal(Graph g, int source) {

        String result = "";
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[num_of_vertices];

        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>(num_of_vertices);

        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
            result += String.valueOf(current_node);

            //Visit the node
            visited[current_node] = true;
            
            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] !=null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    stack.push(temp.data);
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

        System.out.println(dfsTraversal(g, 0));
  }
}
