package xavier.Interest.polymerization.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Optional;

public final class DataUtil {
    private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

    /**
     * 将输入参数转换为字符串字面量，如果输入为null，返回defValue
     *
     * @param number   待转换值
     * @param defValue 默认值
     * @return number的字面量
     */
    public static String numberValueToString(Number number, String defValue) {
        if (number==null) {
            logger.debug("input value is null,user default value【{}】", defValue);
            return defValue;
        } else{
            return number.toString();
        }
    }

    /**
     * 将输入参数转换为字符串字面量，如果输入为null，返回null
     *
     * @param number 待转换值
     * @return number的字面量
     */
    public static String numberValueToString(Number number) {
        return numberValueToString(number, null);
    }

    /**
     * BigDecimal类型的加法，返回值可能是null。Optional能高效解决null问题吗
     * @param bigDecimals
     * @return
     */
    public static BigDecimal bigDecimalAdd(BigDecimal... bigDecimals){
        BigDecimal result = null;
        for (BigDecimal bigDecimal : bigDecimals) {
            if (result == null){
                result = bigDecimal;
            }else {
                if (bigDecimal != null){
                    result.add(bigDecimal);
                }
            }
        }
        return result;
    }
}
