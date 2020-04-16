package xavier.Interest.polymerization.basic;

public final class DataUtil {
    public final static String STR_0 = "0";

    /**
     * 将输入参数转换为字符串字面量，如果输入为null，返回defValue
     *
     * @param number   待转换值
     * @param defValue 默认值
     * @return number的字面量
     */
    public static String numberValueToString(Number number, String defValue) {
        return number == null ? defValue : number.toString();
    }

    /**
     * 将输入参数转换为字符串字面量，如果输入为null，返回"0"
     *
     * @param number 待转换值
     * @return number的字面量
     */
    public static String numberValueToString(Number number) {
        return numberValueToString(number, STR_0);
    }
}
