package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.ByteCode.*;

public class ByteCodeLoader extends Object {

    private final BufferedReader byteSource;
    private Program program;
    private StringTokenizer tokenizer;
    private static final String DELIM = " ";

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time. For each
     * line it should: Tokenize string to break it into parts. Grab correct
     * class name for the given bytecode from CodeTable create an instance of
     * the bytecode class name returned from code table. Parse any additional
     * arguments for the given bytecode and send them to the newly created
     * bytecode instance via the init function.
     * @return 
     */
    public Program loadCodes() {
        String nextLine;
        String codeClass;
        ArrayList<String> args; // args to initialize bytecodes arguments.
        program = new Program();
        while (true) {
            try {
                nextLine = byteSource.readLine(); // get next line.
                if (nextLine == null) { // make sure line isn't null.
                    break;
                }
                tokenizer = new StringTokenizer(nextLine, DELIM, false); // tokenize
                while (tokenizer.hasMoreTokens()) {
                    codeClass = CodeTable.getClassName(tokenizer.nextToken()); 
                    try { // reflection to instantiate objects.
                        ByteCode bytecode = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());
                        args = new ArrayList<>();
                        while (tokenizer.hasMoreTokens()) {
                            args.add(tokenizer.nextToken()); // add args into arguments of bytecodes.
                        }
                        bytecode.initialize(args); // initialize bytecodes.
                        this.program.getProgram().add(bytecode); // add into program arrayList.
                    } catch (Exception e) {
                        System.out.println("Error in BCL instantiating.");
                    }
                }
            } catch (IOException e) {
                break;
            }
        }
        this.program.resolveAddrs(this.program); // call to resolve addresses.
        return this.program;
    }
}
