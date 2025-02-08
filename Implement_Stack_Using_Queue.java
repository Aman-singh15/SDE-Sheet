/*Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
Implement the MyStack class:
void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:
You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
Example 1:
Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]
Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False   */

class MyStack {
      Queue<Integer>queue1;
       Queue<Integer>queue2;
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        if(queue1.isEmpty()){
          return -1;
        }
          int ans=-1;
       while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
         ans = queue1.poll(); //last element
        Queue<Integer> temp = queue1; //Swapping queues
        queue1 = queue2;
        queue2 = temp;
        return ans;
    }
    
    public int top() {
        if(queue1.isEmpty()){
          return -1;
        }

          int ans=-1;
     while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
         ans = queue1.poll(); //last element
        queue2.offer(ans); 
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return ans;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
