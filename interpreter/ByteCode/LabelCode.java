package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label; // label name.
    @Override
    public void execute(VirtualMachine x){
        // execute is empty due to Label only being a place holder.
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        label = arguments.get(0);
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "LABEL " + label;
    }
    // method used to get original label.
     public String getLabel(){
         return label;   
    }
}
