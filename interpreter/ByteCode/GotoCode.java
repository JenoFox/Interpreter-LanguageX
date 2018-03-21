package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends ByteCode{
    private String label; // original label given.
    private int newAddress; // used to store resolved address.
    @Override // Jump to label given, using resolved address.
    public void execute(VirtualMachine x){
        x.setPC(newAddress);
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        label = arguments.get(0);
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "GOTO " + label;
    }
    // method used to get original label.
     public String getLabel(){
         return label;   
    }
     // method used to set new resolved address.
    public void setLabel(int address){
        newAddress = address;
    }
}
