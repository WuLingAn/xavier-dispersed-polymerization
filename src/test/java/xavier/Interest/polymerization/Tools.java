package xavier.Interest.polymerization;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xavier.Interest.polymerization.entity.DisperseData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试用工具类
 */
public class Tools {
    private static final Logger logger = LoggerFactory.getLogger(Tools.class);

    public static LocalDateTime strToLocalDate(String str){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime= LocalDateTime.parse(str,dateTimeFormatter);

        return  dateTime;
    }

    public static String localDateFormat(LocalDateTime ldt){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return dateTimeFormatter.format(ldt);
    }

    public static List<DisperseData> generateData(Double startValue,Double step,int valueCount){
        List<DisperseData> datas = new ArrayList<>();
        LocalDateTime dt = LocalDateTime.now();
        for (int i = 0; i < valueCount; i++) {
            DisperseData disperseData = new DisperseData();
            dt = dt.plusMinutes(1);
            disperseData.setDataDate(dt);
            datas.add(disperseData);
            disperseData.setDataValue(startValue + step*i);
        }

        System.out.println(datas);
        return datas;
    }

    //
    public static List<DisperseData> generateData(Double maxValue,Double minValue,
                                                  int groups,int groupLength,int typeNum){
        List<DisperseData> datas = new ArrayList<>();
        Double allRange = maxValue - minValue;
        Double partRange = allRange / groups;
        Double[] allRangeMinValue = new Double[groups];
        for (int i = 0; i < groups; i++) {
            allRangeMinValue[i] = minValue + i*partRange;
        }
        LocalDateTime dt = LocalDateTime.now();
        for (int i = 0; i < typeNum; i++) {
            int index = (int)(Math.random()*groups);
            Double thisMinValue = allRangeMinValue[index];
            for (int j = 0; j < groupLength; j++) {
                DisperseData disperseData = new DisperseData();
                disperseData.setDataValue(thisMinValue + Math.random() * partRange);
                dt = dt.plusMinutes(1);
                disperseData.setDataDate(dt);
                datas.add(disperseData);
            }
        }
        logger.debug(datas.toString());
        return datas;
    }

    @Test
    public void testGenerateData(){
        List<DisperseData> disperseDataList = generateData(100.0, 0.0, 5, 5, 10);
    }
}
