// Wellington Pereira Silva - 201935041

import org.junit.Test;
import java.io.*;
import static com.google.common.truth.Truth.assertThat;

public class UnitTest {

    @Test
    public void output() throws Exception {
        File inputFile = openFile("src/test/data/sample3.txt");
        assertThat(inputFile.isFile()).isTrue();

        String[] argv = new String[] {inputFile.getPath()};

        CalculatorInit.main(argv);
    }

    private File openFile(String pathName) throws IOException {
        String path = pathName;

        File file = new File(path);
        if (!file.isFile()) {
            throw new FileNotFoundException(path);
        }
        return file;
    }

}