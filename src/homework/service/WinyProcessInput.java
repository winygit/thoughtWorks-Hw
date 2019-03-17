/**
 * 
 */
package homework.service;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homework.exception.HomeWorkException;
import homework.rule.Rules;
import homework.symbol.Symbol;
import homework.symbol.SymbolsParse;

/*
 * @author winy  
 * @date 2019年3月17日
 */
public class WinyProcessInput implements ProcessInput {

    private SymbolsParse symbolsParse;

    private Rules rules = Rules.getInstance();

    public WinyProcessInput(SymbolsParse symbolsParse) {
        this.symbolsParse = symbolsParse;
    }

    @Override
    public String parse(String inputLine) throws HomeWorkException {

        try {
            String x = inputLine.trim();
            // such as: glob is I
            if (x.matches("\\w+\\s+is\\s+[IVXLCDM]")) {
                String[] strs = x.split("\\s+is\\s+");
                rules.galaxyUnitSymbolsMap.put(strs[0].trim(), Symbol.valueOf(strs[1].trim()));
                return null;
            }

            // such as: glob glob Silver is 34 Credits
            if (x.matches("(\\w+\\s+)+is\\s+\\d+\\s+Credits")) {
                String[] strs = x.split("\\s+is\\s+");

                String[] strRs = strs[0].split("\\s+");
                StringBuilder rsNum = new StringBuilder();
                for (int i = 0; i < strRs.length - 1; i++) {
                    // Galaxy 单位 翻译成罗马字母单位, 形成表示数字的串
                    rsNum.append(rules.galaxyUnitSymbolsMap.get(strRs[i]).name());
                }

                // 计算阿拉伯数量
                int quantity = symbolsParse.parse2ArabicNumber(rsNum.toString());

                // 对应的credits
                int creditsQuantity = 1;
                Matcher matcher = Pattern.compile("\\d+\\s+").matcher(strs[1]);
                if (matcher.find()) {
                    creditsQuantity = Integer.parseInt(matcher.group().trim());
                }

                rules.resourceCreditsMap.put(strRs[strRs.length - 1], (double) creditsQuantity / quantity);

                return null;
            }

            // such as: how much is pish tegj glob glob ?
            if (x.matches("how\\s+much\\s+is.*?")) {
                String obj = x.replaceAll("how\\s+much\\s+is", "").replace("?", "").trim();
                String strs[] = obj.split("\\s");
                StringBuilder rsNum = new StringBuilder();
                for (int i = 0; i < strs.length; i++) {
                    // Galaxy 单位 翻译成罗马字母单位, 形成表示数字的串
                    rsNum.append(rules.galaxyUnitSymbolsMap.get(strs[i]).name());
                }
                // 计算阿拉伯数
                int quantity = symbolsParse.parse2ArabicNumber(rsNum.toString());

                return MessageFormat.format("{0} is {1}", obj, quantity);
            }

            // such as: how many Credits is glob prok Silver ?
            if (x.matches("how\\s+many\\s+Credits\\s+is.*?")) {
                String obj = x.replaceAll("how\\s+many\\s+Credits\\s+is", "").replace("?", "").trim();
                String strs[] = obj.split("\\s");

                StringBuilder rsNum = new StringBuilder();
                for (int i = 0; i < strs.length - 1; i++) {
                    // Galaxy 单位 翻译成罗马字母单位, 形成表示数字的串
                    rsNum.append(rules.galaxyUnitSymbolsMap.get(strs[i]).name());
                }
                // 计算阿拉伯数量
                int quantity = symbolsParse.parse2ArabicNumber(rsNum.toString());

                double rs = rules.resourceCreditsMap.get(strs[strs.length - 1]) * quantity;

                return MessageFormat.format("{0} is {1} Credits", obj, rs);
            }

            return "I have no idea what you are talking about";

        } catch (Exception e) {
            return "I have no idea what you are talking about";
        }

    }

}
