package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        for (int i = 0; i < framePointer.size(); i++) {
            //System.out.println()
            System.out.print("[");
            // Check if its the last frame pointer. Do Dump accordingly.
            if ((i + 1) < framePointer.size()) {
                for (int j = framePointer.get(i); j < framePointer.get(i + 1); j++) {
                    if (j + 1 == framePointer.get(i + 1)) {
                        System.out.print("" + runTimeStack.get(j));
                    } else {
                        System.out.print("" + runTimeStack.get(j) + ",");
                    }
                }
            } else {
                for (int k = framePointer.get(i); k < runTimeStack.size(); k++) {
                    if (k + 1 == runTimeStack.size()) {
                        System.out.print("" + runTimeStack.get(k));
                    } else {
                        System.out.print("" + runTimeStack.get(k) + ",");
                    }
                }
            }
            System.out.print("] ");
        }
        System.out.println("");
    }

    public int peek() {
        return (int)runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop() {
        int poppedItem = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return poppedItem;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {
        framePointer.add(offset);
    }

    public void popFrame() {
        int returnVal = pop();
        int count = runTimeStack.size();
        //System.out.println("RunSTack size is: " +(runTimeStack.size()));
        while (count > framePointer.peek()) {
            //System.out.print("  i is:   " + count);
            pop();
            count--;
        }
        framePointer.pop();
        push(returnVal);
    }

    public int store(int offset) {
        int returnVal = pop();
        pop();
        runTimeStack.add(framePointer.peek() + offset, returnVal);
        return returnVal;
    }

    public int load(int offset) {
        int temp = (int) runTimeStack.get(offset + framePointer.peek());
        push(temp);
        return temp;
    }

    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }

    public int topStack() {
        return runTimeStack.size() - 1;
    }

    public int getSize() {
        return runTimeStack.size();
    }

    public int getFrame() {
        return framePointer.peek();
    }
    
    public ArrayList getRunTimeStack(){
        return runTimeStack;
    }
}
