package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode {
    private Integer arg1; // Literal Integer value.
    private String ID = ""; // ID used if LIT has a variable name such as LIT 2 x, where x is ID.

    @Override // push arg1 onto the top of the stack.
    public void execute(VirtualMachine x) {
        x.pushRunStack(arg1);
    }

    @Override // If mnultiple arguements initialize BOTH data fields, else only arg1.
    public void initialize(ArrayList<String> arguments) {
        if (arguments.size() > 1) {
            arg1 = Integer.parseInt(arguments.get(0));
            ID = arguments.get(1);
        } else {
            arg1 = Integer.parseInt(arguments.get(0));
        }
    }

    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString() {
        if (ID.equals("")) { // If no ID only print according to specified format.
            return "LIT " + arg1;
        } else { // else print ID according to specified format.
            return "LIT " + arg1 + " " + ID+ "   int " + ID;
        }
    }
}
