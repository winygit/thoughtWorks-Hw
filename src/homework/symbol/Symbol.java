/**
 * 
 */
package homework.symbol;

/*
 * @author winy  
 * @date 2019年3月17日
 */
public enum Symbol {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int val;

    private Symbol(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static int fromChar(char c) {
        String s = c + "";
        for (Symbol symbol : Symbol.values()) {
            if (s.equals(symbol.name())) {
                return symbol.val;
            }
        }

        return -1;
    }

}
