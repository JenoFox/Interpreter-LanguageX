package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CallCode extends ByteCode {

    private String label; // String for original label argument tokenized in BCL. 
    private int newAddress; // int for storing resolved address from resolveAddress() in Program.
    private String baseID; // ID of the base function name.
    private String args; // Args that the function will be using (parameters of function).

    @Override // Jump to label of function. Execute the function.
    public void execute(VirtualMachine x) {
        x.pushReturnAddress(); // Save the pc into the stack to remember its location upon return bytecode.
        x.setPC(newAddress); // set the pc to jump to resolved address.
        args = ""; // reinitialize args String each time this specific Call object is called.
        // Loop to obtain the correct parameters within the function to be displayed in DUMP ON.
        for (int i = x.getFramePeek(); i < x.getRunSize(); i++) {
            if (i + 1 == x.getRunSize()) {
                args = args + x.getRunStack().get(i); // If last number don't do comma.
            } else {
                args = args + x.getRunStack().get(i) + ", "; // Not last number do comma in between.
            }
        }
    }

    @Override // Initializing data fields.
    public void initialize(ArrayList<String> arguments) {
        label = arguments.get(0); // original label Call uses.
        StringTokenizer tokenizer = new StringTokenizer(label, "<", false); // used to get base function name.
        baseID = tokenizer.nextToken(); // base function name saved into baseID.
    }

    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString() {
        return "CALL " + label + "   " + baseID + "(" + args + ")";
    }
    // Function used to return the original label associated with CallCode object.
    public String getLabel() {
        return label;
    }
    // Function used to set the new resolved address.
    public void setLabel(int address) {
        newAddress = address;
    }
}
