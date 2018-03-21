package interpreter;

import interpreter.ByteCode.*;
import java.util.*;

public class Program {

    private final ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public ArrayList getProgram() {
        return this.program;
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted
     * into correct addresses so the VirtualMachine knows what to set the
     * Program Counter(PC) HINT: make note what type of data-stucture bytecodes
     * are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        HashMap<String, Integer> labeladdress = new HashMap<>(); // create HashMap to store key and values.
        String LabelArgs; // String of label names.
        // Loop to obtain all names of labels and their addresses.
        for (int i = 0; i < program.getSize(); i++) {
            if (this.program.get(i).getClass().getName().equals("interpreter.ByteCode.LabelCode")) {
                LabelArgs = ((LabelCode) program.program.get(i)).getLabel();
                labeladdress.put(LabelArgs, i);
            }
        }
        // Loop to check if codes are jumping codes. If so then change label into resolved address form HashMap.
        for (int i = 0; i < program.getSize(); i++) {
            //CALLCODE
            if (program.program.get(i).getClass().getName().equals("interpreter.ByteCode.CallCode")) {
                CallCode callCode = ((CallCode) program.program.get(i));
                LabelArgs = callCode.getLabel();
                callCode.setLabel(labeladdress.get(LabelArgs)); //the hashmap assigns the index of the LABEL args
            }
            //GOTOCODE
            if (program.program.get(i).getClass().getName().equals("interpreter.ByteCode.GotoCode")) {
                GotoCode gotocode = ((GotoCode) this.program.get(i));
                LabelArgs = gotocode.getLabel();
                gotocode.setLabel(labeladdress.get(LabelArgs)); //the hashmap assigns the index of the LABEL args
            }
            //FALSEBRANCHCODE
            if (program.program.get(i).getClass().getName().equals("interpreter.ByteCode.FalseBranchCode")) {
                FalseBranchCode fbc = ((FalseBranchCode) program.program.get(i));
                LabelArgs = fbc.getLabel();
                fbc.setLabel(labeladdress.get(LabelArgs)); //the hashmap assigns the index of the LABEL args
            }
        }
    }
}
