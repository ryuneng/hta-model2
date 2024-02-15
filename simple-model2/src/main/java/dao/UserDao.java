package dao; // 20240215

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.IbatisUtil;
import vo.User;

public class UserDao {
	// ibatis 호출(조립), 기능을 제공해주는 객체 - 읽기 전용
	private final SqlMapClient ibatis = IbatisUtil.getSqlMapClient();
	
	public User getUserById(String id) throws SQLException {
		return (User) ibatis.queryForObject("users.getUserById", id);
	}
	
	public User getUserByEmail(String email) throws SQLException {
		return (User) ibatis.queryForObject("users.getUserByEmail", email);
	}
	
	public void insertUser(User user) throws SQLException {
		ibatis.insert("users.insertUser", user);
	}
}
