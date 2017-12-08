package filter;

import java.util.List;

/**
 * Created by licheng on 12/8/17.
 * 判断标准
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
