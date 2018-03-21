package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    private int arg1; // data field for the number of Args needed for interpreted function.
    @Override // when ARGS bytecode called a new frame is created to fit the number of args needed by the function.
    public void execute(VirtualMachine x){
            x.newFrameAtRunStack(x.getTopRunStack()-arg1+1); // Add 1 to set correct spot of new frame.
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        arg1 = Integer.parseInt(arguments.get(0));
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "ARGS " + arg1;
    }
}
