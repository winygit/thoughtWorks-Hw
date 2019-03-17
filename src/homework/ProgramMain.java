/**
 * 
 */
package homework;


import java.io.File;

import homework.input.TextFileInput;
import homework.output.Output;
import homework.output.ScannerOutput;
import homework.service.WinyProcessInput;
import homework.symbol.WinySymbolsParse;

/*
 * @author winy  
 * @date 2019年3月17日
 */
public class ProgramMain {


    public static void main(String[] args) {
        /*
         * read input from scanner. 
         */
        // Output output = new ScannerOutput(new ScannerInput(), new
        // WinyProcessInput(new WinySymbolsParse()));

        /*
         * read input from path : D:\\input2.txt
         */
        Output output = new ScannerOutput(new TextFileInput(new File("D:\\input2.txt")),
                new WinyProcessInput(new WinySymbolsParse()));
        output.output();
    }

}
