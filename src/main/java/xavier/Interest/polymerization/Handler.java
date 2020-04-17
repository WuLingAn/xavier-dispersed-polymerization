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

        PolymerizationData polymerizationData = null;
        for (int i = 0; i < values.size(); i++) {
            DisperseData disperseData = values.get(i);
            IRuleConfig<DisperseData> ruleConfig = match(disperseData);
        }
        return PolymerizationDataList;
    }

    @Override
    public IRuleConfig<DisperseData> match(DisperseData data) {

        return null;
    }
}
