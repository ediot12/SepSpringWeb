package Ajax.Controller;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CityDAO extends SqlSessionDaoSupport {

	public List<String> getListData(String string) {
		List<String> sido = getSqlSession().selectList(string);
		return sido;
	}

	public List<String> getListData(String string, String city) {
		List<String> selectcity = getSqlSession().selectList(string, city);
		return selectcity;
	}

}
