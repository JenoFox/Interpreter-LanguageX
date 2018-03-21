package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode{
    private String bop; // BOP string, such as "+" or "-" for example...
    @Override // Pop two top levels of runTime stack, then do the BOP based up what data field bop contains.
    public void execute(VirtualMachine x){
        int operand1 = x.popRunStack();
        int operand2 = x.popRunStack();
        // Lower level is always first (op2 bop op1)
        if(bop.equals("+"))
            x.pushRunStack(operand2 + operand1);
        else if(bop.equals("-"))
            x.pushRunStack(operand2 - operand1);
        else if(bop.equals("*"))
            x.pushRunStack(operand2 * operand1);
        else if(bop.equals("/"))
            x.pushRunStack(operand2 / operand1);
        else if(bop.equals("==")){
            if(operand2 == operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals("!=")){
            if(operand2 != operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals("<")){
            if(operand2 < operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals("<=")){
            if(operand2 <= operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals("==")){
            if(operand2 == operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals(">")){
            if(operand2 > operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals(">=")){
            if(operand2 >= operand1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals("&")){ // logical operator not BOP
            if((operand2 == 1) && (operand1 == 1))
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else if(bop.equals("|")){ // logical operator not BOP
            if(operand2 == 1 || operand1 == 1)
                x.pushRunStack(1);
            else
                x.pushRunStack(0);
        }
        else
            System.out.println("Invalid BOP!"); // If bop is an invalid token print error message.
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments){
        bop = arguments.get(0);
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "BOP " + bop;
    }
}
