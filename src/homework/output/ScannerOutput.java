package homework.output;

import java.util.List;

import homework.input.Input;
import homework.service.ProcessInput;

/*
 * @author winy  
 * @date 2019年3月17日
 * 
 * Directly output the result to the scanner .
 * 
 */
public class ScannerOutput implements Output {

    private Input input;
    private ProcessInput processInput;

    public ScannerOutput(Input input, ProcessInput processInput) {
        super();
        this.input = input;
        this.processInput = processInput;
    }

    @Override
    public void output() {
        List<String> inputs = input.getContent();
        System.out.println("input:");
        inputs.stream().forEach(System.out::println);

        /*inputs.sort((o1, o2) -> o1.endsWith("?") ? 1 : -1);
        
        System.out.println("\ninput---- :");
        inputs.stream().forEach(System.out::println);*/

        System.out.println("\nOutput:");
        inputs.stream().forEach(x -> {
            if (x != null && !"".equals(x)) {
                String rs = processInput.parse(x);
                if (rs != null) {
                    System.out.println(processInput.parse(x));
                }
            }
        });
    }

}
