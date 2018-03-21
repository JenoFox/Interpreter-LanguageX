package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode{
    private int arg1; // int data field to store offset.
    private String ID; // string data field for name of variable being loaded.
    @Override // Load from offset arg1 onto top of stack.
    public void execute(VirtualMachine x){
        x.loadRunStack(arg1);
    }
    @Override // Initialize the data fields from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        arg1 = Integer.parseInt(arguments.get(0));
        ID = arguments.get(1);
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "LOAD " + arg1 + " " + ID + "    <load " + ID + ">";
    }
}
