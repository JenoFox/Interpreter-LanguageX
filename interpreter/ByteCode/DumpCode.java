package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String dumpStatus; // Label given to DumpCode. Either "ON" or "OFF".

    @Override // If dumpStatus is "ON" set dump within VM. Else turn off dump within vm.
    public void execute(VirtualMachine x) {
        if (dumpStatus.equals("ON")) {
            x.setDumpOn(true);
        }
        else if(dumpStatus.equals("OFF")){
            x.setDumpOn(false);
        }
    }
    @Override // Initialize the data field from correct position within ArrayList.
    public void initialize(ArrayList<String> arguments) {
        dumpStatus = arguments.get(0);
    }
    
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString() {
        return "DUMP " + dumpStatus;
    }
}
