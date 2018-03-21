package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode{
    private int arg1; // int value for storing the offset.
    private String ID; // name of variable being stored.
    private int val; // int value that is being stored.
    @Override // Pop the top of the stack and store it into the offset location.
    public void execute(VirtualMachine x){
       val = x.storeRunStack(arg1);
    }
    @Override // Initialize the data fields from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        arg1 = Integer.parseInt(arguments.get(0));
        ID = arguments.get(1);
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "STORE " + arg1 + " " + ID + "   " + ID + " = " + val;
    }
}