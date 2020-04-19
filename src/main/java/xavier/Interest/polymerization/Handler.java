package xavier.Interest.polymerization;

import xavier.Interest.polymerization.builder.IHandler;
import xavier.Interest.polymerization.builder.IRule;
import xavier.Interest.polymerization.builder.IRuleConfig;
import xavier.Interest.polymerization.entity.DisperseData;
import xavier.Interest.polymerization.entity.PolymerizationData;

import java.util.ArrayList;
import java.util.List;

public class Handler implements IHandler<PolymerizationData, DisperseData> {

    private IRule rule;

    private Handler(IRule rule) {
        this.rule = rule;
    }

    public static Handler getInstance(IRule rule) {
        return new Handler(rule);
    }

    @Override
    public List<PolymerizationData> execute(List<DisperseData> values) {
        List<PolymerizationData> PolymerizationDataList =
                new ArrayList<>();
        DefaultPolymerizationBuilder builder = DefaultPolymerizationBuilder.getInstance();

        PolymerizationData currentPolymerizationData = null;
        IRuleConfig<DisperseData> currentConfig = null;
        for (int i = 0; i < values.size(); i++) {
            DisperseData disperseData = values.get(i);
            IRuleConfig<DisperseData> thisConfig = match(disperseData);
            // 初始化
            if(currentPolymerizationData == null && thisConfig != null){
                // 当前
                currentPolymerizationData = builder.createData(disperseData,thisConfig.getType());
                // 添加到结果集合
                PolymerizationDataList.add(currentPolymerizationData);
            }else if(currentPolymerizationData != null || thisConfig != null){
                // currentPolymerizationData != null && thisConfig != null
                // currentPolymerizationData != null && thisConfig == null
                // 无匹配，结束掉
                if(thisConfig == null){
                    builder.closeDate(currentPolymerizationData,disperseData);
                    currentPolymerizationData = null;
                }else if(thisConfig == currentConfig){
                    builder.updateDate(currentPolymerizationData,disperseData);
                }else{
                    // thisConfig != currentConfig != null
                    // 发生变更
                    // 1.结束掉
                    builder.closeDate(currentPolymerizationData,disperseData);
                    // 2. 初始化一个新的
                    currentPolymerizationData = builder.createData(disperseData,thisConfig.getType());
                    PolymerizationDataList.add(currentPolymerizationData);
                }
            }
            currentConfig = thisConfig;
        }
        return PolymerizationDataList;
    }

    @Override
    public IRuleConfig<DisperseData> match(DisperseData data) {
        return rule.match(data);
    }
}
