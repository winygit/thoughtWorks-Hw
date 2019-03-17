/**
 * 
 */
package homework.rule;

import java.util.HashMap;
import java.util.Map;

import homework.symbol.Symbol;

/*
 * @author winy  
 * @date 2019年3月17日
 */
public class Rules {

    // galaxy unit -- romance symbols
    public final Map<String, Symbol> galaxyUnitSymbolsMap = new HashMap<String, Symbol>();
    // resource--Credits per unit
    public final Map<String, Double> resourceCreditsMap = new HashMap<String, Double>();


    private Rules() {

    }

    public static Rules getInstance() {
        return Holder.instance;
    }

    static class Holder {
        public static Rules instance = new Rules();

    }

}
