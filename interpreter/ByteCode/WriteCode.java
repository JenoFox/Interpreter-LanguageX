package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode{
    @Override // Print value at the top of the stack onto the console.
    public void execute(VirtualMachine x){
        System.out.println(x.peekRunStack());
    }
    @Override
    public void initialize(ArrayList arguments){
        // no arguments to initiliaze.
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "WRITE";
    }
}
