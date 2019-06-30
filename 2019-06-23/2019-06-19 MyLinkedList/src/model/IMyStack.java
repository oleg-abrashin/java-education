package model;

public interface IMyStack<T> {
	
	void push(T data); //push the data specified onto the stack
	T peek();			// retrieves but not removes the upper element
	T pop();			// retrieves and removes the upper element
	
	int deep(T data); // 1-based   returns the deep of the first occurrence of
						//			the specified data and -1 if the data doesn't
						//			present in the stack
	int size();			// returns the number of the elements in the stack

}
