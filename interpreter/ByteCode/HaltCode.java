package interpreter.ByteCode;

import java.util.*;
import interpreter.*;

public class HaltCode extends ByteCode{
    // no data fields for Halt
    @Override // terminate program within VM.
    public void execute(VirtualMachine x){
        x.setIsRunningFalse();
    }
    @Override
    public void initialize(ArrayList<String> arguments){
        // empty list due to no args
    }
    @Override // Used when dumping, formatted as specified within Assignment 3 PDF.
    public String toString(){
        return "HALT";
    }
}
