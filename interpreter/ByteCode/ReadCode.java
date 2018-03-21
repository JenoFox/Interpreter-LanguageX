package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.*;

public class ReadCode extends ByteCode{
    @Override // Read in input from the user.
    public void execute(VirtualMachine x){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter one integer value: ");
        x.pushRunStack(in.nextInt());
    }
    @Override 
    public void initialize(ArrayList<String> arguments){
        // no arguments to initialize.
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "READ";
    }
}