package xavier.Interest.polymerization.entity;

/**
 * 汇总类型
 */
public enum OverType {
    NORMAL("NORMAL", 0),
    UP_OVER1("UP_OVER1", 1),
    UP_OVER2("UP_OVER2", 2),
    UP_OVER3("UP_OVER3", 3),
    DOWN_OVER1("DOWN_OVER1", -1),
    DOWN_OVER2("DOWN_OVER2", -2),
    DOWN_OVER3("DOWN_OVER3", -3),
    ;
    private String message;
    private Integer level;

    OverType(String message, Integer level) {
        this.message = message;
        this.level = level;
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
