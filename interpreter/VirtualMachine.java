package interpreter;

import java.util.*;
import interpreter.ByteCode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;
    private Stack returnAddrs;
    private boolean isRunning;
    private Program program;
    private boolean isDumpOn;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (isDumpOn) {
                System.out.println(code);
                runStack.dump(); // check that the operation is correct.
            }
            pc++;
        }
    }

    public int peekRunStack() {
        return runStack.peek();
    }

    public int popRunStack() {
        return runStack.pop();
    }

    public int pushRunStack(int i) {
        return runStack.push(i);
    }

    public void newFrameAtRunStack(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popFrameRunStack() {
        runStack.popFrame();
    }

    public int storeRunStack(int offset) {
        return runStack.store(offset);
    }

    public int loadRunStack(int offset) {
        return runStack.load(offset);
    }

    public void setPC(int i) {
        pc = i;
    }

    public int getPC() {
        return pc;
    }

    public void pushReturnAddress() {
        returnAddrs.push(getPC());
    }

    public int popReturnAddress() {
        return (int) returnAddrs.pop();
    }

    public void setIsRunningFalse() {
        isRunning = false;
    }

    public int getTopRunStack() {
        return runStack.topStack();
    }

    public void getRunStackDump() {
        runStack.dump();
    }

    public int getRunSize() {
        return runStack.getSize();
    }

    public int getFramePeek() {
        return runStack.getFrame();
    }

    public void setDumpOn(boolean on) {
        isDumpOn = on;
    }
    public ArrayList getRunStack(){
        return runStack.getRunTimeStack();
    }

}
