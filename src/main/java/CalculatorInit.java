import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;


public class CalculatorInit {
    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromStream(new FileInputStream(args[0]));

        CalculatorLexer lexer = new CalculatorLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);


        ParseTree tree = parser.prog();

        CalculatorSuperiorVisitor visitor = new CalculatorSuperiorVisitor();
        visitor.visit(tree);
    }
}