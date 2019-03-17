package homework.symbol;

import homework.exception.HomeWorkException;

public interface SymbolsParse {

    /*
     *  check whether the symbols is valid
     */
    void check(String symbols) throws HomeWorkException;

    /*
     * parse Symbols to number 
     */
    int parse2ArabicNumber(String symbols) throws HomeWorkException;
}
