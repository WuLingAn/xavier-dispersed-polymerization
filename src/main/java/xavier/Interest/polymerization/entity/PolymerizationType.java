package xavier.Interest.polymerization.entity;

import xavier.Interest.polymerization.builder.IPolymerizationType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 枚举的扩展性不好，做一个伪枚举对象
 */
public final class PolymerizationType implements IPolymerizationType {
    private String name;
    private String message;
    private Integer level;

    public static final List<PolymerizationType> DEFAULT_TYPES;
    static {
        PolymerizationType[] typeArr
                = {
                new PolymerizationType("DOWN_OVER3", -3),
                new PolymerizationType("DOWN_OVER2",-2),
                new PolymerizationType("DOWN_OVER1", -1),
                new PolymerizationType("NORMAL", 0),
                new PolymerizationType("UP_OVER1", 1),
                new PolymerizationType("UP_OVER2",2),
                new PolymerizationType("UP_OVER3", 3),



        };
        DEFAULT_TYPES = Collections.unmodifiableList(Arrays.asList(typeArr));
    }

    public PolymerizationType[] createTypes(String[] names,Integer[] levels){
        int minSize = Math.min(names.length,levels.length);
        PolymerizationType[] polymerizationTypes = new PolymerizationType[minSize];
        for (int i = 0; i < minSize; i++) {
            polymerizationTypes[i] = new PolymerizationType(names[i],levels[i]);
        }
        return polymerizationTypes;
    }

    /**
     * 构建list
     * @param polymerizationTypes
     * @return
     */
    public List<PolymerizationType> createTypes(PolymerizationType... polymerizationTypes){
        return Collections.unmodifiableList(Arrays.asList(polymerizationTypes));
    }

    public PolymerizationType(String name, Integer level) {
        this.name = name;
        this.message = name;
        this.level = level;
    }

    public PolymerizationType(String name, String message, Integer level) {
        this.name = name;
        this.message = message;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
