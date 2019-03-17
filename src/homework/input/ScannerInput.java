/**
 * 
 */
package homework.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author winy  
 * @date 2019年3月17日
 * 
 * Get input from scanner.
 */
public class ScannerInput implements Input {

    /*
      End the input action when input line is blank  or 'exit'
     */
    @Override
    public List<String> getContent() {
        List<String> contents = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        for (String input = scan.nextLine().trim(); input != null && !"".equals(input)
                && !"exit".equalsIgnoreCase(input);) {
            contents.add(input);
            input = scan.nextLine().trim();
        }
        return contents;
    }

}
