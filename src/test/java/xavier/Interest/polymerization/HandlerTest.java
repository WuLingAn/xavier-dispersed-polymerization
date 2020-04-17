package xavier.Interest.polymerization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xavier.Interest.polymerization.builder.IRule;
import xavier.Interest.polymerization.entity.DisperseData;

import java.util.ArrayList;
import java.util.List;

public class HandlerTest {
    static final Logger logger = LoggerFactory.getLogger(HandlerTest.class);
    private static List<DisperseData> disperseDataList;
    private IRule rule;

    @BeforeAll
    public static void initAll() {
        disperseDataList = new ArrayList<>();
        disperseDataList.add(new DisperseData(12.5, Tools.strToLocalDate("2020-04-12 12:00:01")));
    }

    @BeforeEach
    public void init() {
        logger.debug(this.getClass().getName());
    }

    @Test
    public void testExecute() {

    }
}
