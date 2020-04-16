package xavier.Interest.polymerization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xavier.Interest.polymerization.entity.DisperseData;
import xavier.Interest.polymerization.entity.Rule;

import java.util.List;

public class HandlerTest {
    Logger logger = LoggerFactory.getLogger(HandlerTest.class);
    private List<DisperseData> disperseDataList;
    private Rule rule;

    @BeforeAll
    public static void initAll() {

    }

    @BeforeEach
    public void init() {
        logger.debug(this.getClass().getName());
    }


    @Test
    public void testExecute() {
        Handler handler = new Handler();
        handler.execute(disperseDataList, rule);
    }
}
