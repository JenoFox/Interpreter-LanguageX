package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends ByteCode{
    private String label; // original label given.
    private int newAddress; // used to store resolved address.
    
    @Override // If condition is false, jump to label using resolved address. If not go to next bytecode.
    public void execute(VirtualMachine x){
        if(x.popRunStack() == 0){
            x.setPC(newAddress);
        }
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        label = arguments.get(0);
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "FALSEBRANCH " + label;
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
