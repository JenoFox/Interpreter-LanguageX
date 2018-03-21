package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode{
    private int numPopped; // int for number of levels to be popped.
    @Override // Loop to pop until number of levels have been reached
    public void execute(VirtualMachine x){ 
       // Two condition must be true. Cannot pop more than stack size, and cannot pop through a frame.
       for(int i = 0; i < numPopped && x.getRunSize() != x.getFramePeek(); i++){
            x.popRunStack();
        }
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
       numPopped = Integer.parseInt(arguments.get(0));
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "POP " + numPopped;
    }
}
