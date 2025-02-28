/*You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
We can only use the following functions on this stack S.
is_empty(S) : Tests whether stack is empty or not.
push(S) : Adds a new element to the stack.
pop(S) : Removes top element from the stack.
top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.
Note :
1) Use of any loop constructs like while, for..etc is not allowed. 
2) The stack may contain duplicate integers.
3) The stack may contain any integer i.e it may either be negative, positive or zero.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= 'T' <= 100
1 <=  'N' <= 100
1 <= |'V'| <= 10^9
Where |V| denotes the absolute value of any stack element.
Time limit: 1 sec
Sample Input 1:
1
5
5 -2 9 -7 3
Sample Output 1:
9 5 3 -2 -7
Explanation of Sample Input 1:
9 Is the largest element, hence it’s present at the top. Similarly 5>3, 3>-2 and -7 being the smallest element is present at the last.  */


import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
		if(!stack.isEmpty()){
			int top=stack.pop();
			sortStack(stack);
			sort(stack,top);
		}
	}
	public static void sort(Stack<Integer>stack,int value){
		if(stack.isEmpty() || stack.peek()<=value){
			stack.push(value);
		}else{
			int temp = stack.pop();
            sort(stack, value);
            stack.push(temp);
		}
	}

}
