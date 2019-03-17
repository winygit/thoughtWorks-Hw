/**
 * 
 */
package homework.symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import homework.exception.HomeWorkException;

/*
 * @author winy  
 * @date 2019年3月17日
 */
public class WinySymbolsParse implements SymbolsParse {

    @Override
    public void check(String symbols) throws HomeWorkException {

        if (!symbols.matches("[IVXLCDM]+")) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }

        // "I", "X", "C", and "M" can be repeated three times in succession, but
        // no more.
        Pattern p = Pattern.compile("[IXCV]{4}");
        if (p.matcher(symbols).find()) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }

        // "D", "L", and "V" can never be repeated
        p = Pattern.compile("[DLV]{2}");
        if (p.matcher(symbols).find()) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }

        // "I" can be subtracted from "V" and "X" only
        p = Pattern.compile("I[LCDM]");
        if (p.matcher(symbols).find()) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }

        // "X" can be subtracted from "L" and "C" only
        p = Pattern.compile("X[DM]");
        if (p.matcher(symbols).find()) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }

        /*
         * "V", "L", and "D" can never be subtracted.
         */
        p = Pattern.compile("(V[XLCDM])|(L[CDM])|(DM)");
        if (p.matcher(symbols).find()) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }

        // Only one small-value symbol may be subtracted from any large-value
        // symbol
        p = Pattern.compile("(I{2,}[VXLCDM])|(V{2,}[XLCDM])|(X{2,}[LCDM])|(L{2,}[CDM])|(C{2,}[DM])|(D{2,}M)");
        if (p.matcher(symbols).find()) {
            throw new HomeWorkException("Invalid Symbols:" + symbols);
        }
    }


    @Override
    public int parse2ArabicNumber(String symbols) throws HomeWorkException {

        symbols = symbols.trim();

        check(symbols);

        List<Integer> nums = new ArrayList<Integer>();

        int pre = 0;
        for (int i = 1; pre < symbols.length(); i++) {

            if (pre == symbols.length() - 1) {
                nums.add(Symbol.fromChar(symbols.charAt(pre++)));
                continue;
            } else if (pre == i) {
                continue;
            }

            if (Symbol.fromChar(symbols.charAt(pre)) >= Symbol.fromChar(symbols.charAt(i))) {
                nums.add(Symbol.fromChar(symbols.charAt(pre)));
                pre = i;
            } else {
                nums.add(Symbol.fromChar(symbols.charAt(i)) - Symbol.fromChar(symbols.charAt(pre)));
                pre = i + 1;
            }
        }

        return nums.stream().mapToInt(x -> x).sum();

    }

}
