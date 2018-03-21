package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.*;

public class ReturnCode extends ByteCode {
    private String label; // string used for original label, truncated form used for baseID.
    private String baseID; // string for baseID name of function.
    private int val; // int to show what value is being returned upon call.
    
    @Override // Return from original function. Pop the framePointer and return value to top of stack.
    public void execute(VirtualMachine x) {
        val = x.peekRunStack(); // used within toString() to show value returned.
        x.setPC(x.popReturnAddress()); // set PC to correct location.
        x.popFrameRunStack();
    }

    @Override // Initialize the data fields, If multiple arguments initialize two data fields.
    public void initialize(ArrayList<String> arguments) {
        if (arguments.size() == 1) {
            label = arguments.get(0);
            StringTokenizer tokenizer = new StringTokenizer(label, "<", false);
            baseID = tokenizer.nextToken();
        } else {
            label = "";
        }
    }

    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString() {
        if (label.equals("")) {
            return "RETURN " + "     exit: " + val;
        } else {
            return "RETURN " + label + "    exit " + baseID + ": " + val;
        }
    }
}
