package net.mikeski.problem.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Copyright Mike Baranski ()mike.baranski ... gmail.com)
 * <p>
 * Class ComplaintMapperTest created by mike 9/22/20 8:37 PM
 */
@SpringBootTest
public class ComplaintMapperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintMapperTest.class);
    @Autowired ComplaintMapper complaintMapper;

    @Test
    public void mapperAutowires(){
        Assertions.assertNotNull(complaintMapper);
    }

    @Test
    public void test_getIssueCounts(){
        List<Pair<String, Long>> issueCounts = complaintMapper.getIssueCounts();
        assertEquals(1, issueCounts.size());
        for(Pair<String, Long> p : issueCounts){
            assertNotNull(p);
        }

        String issue = complaintMapper.getIssue();
        assertEquals(issue, issueCounts.get(0).getFirst());
    }
}
