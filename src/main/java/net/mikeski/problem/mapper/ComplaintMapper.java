package net.mikeski.problem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.StringTypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Copyright Mike Baranski ()mike.baranski ... gmail.com)
 * <p>
 * Class ComplaintMapper created by mike 9/22/20 8:24 PM
 */
@Mapper
public interface ComplaintMapper {
    static final Logger LOGGER = LoggerFactory.getLogger(ComplaintMapper.class);

    @Results({
            @Result(column = "first", property = "first", typeHandler = StringTypeHandler.class)
    })
    @Select("select issue as first, count(*) as second from complaints group by issue order by 2 desc;")
    public List<Pair<String, Long>> getIssueCounts();

    @Select("select issue from complaints limit 1;")
    public String getIssue();

    @Select("select issue as first, count(*) as second from complaints group by issue order by 2 desc;")
    public List<Pair<String, Long>> getIssueCountsWithDefaultMapper();

}
