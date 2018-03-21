package interpreter.ByteCode;

import java.util.*;
import interpreter.*;

public abstract class ByteCode {
    // Only two methods are shared between all bytecodes.
    // execute each unique function for each bytecode.
    // initialize each object dynamically, each bytecode can contain a different 
    // number of arguments.
    public abstract void execute(VirtualMachine x); // Inherited and implemented by each bytecode
    public abstract void initialize(ArrayList<String> arguments); // Inherited and implemented by each bytecode
}