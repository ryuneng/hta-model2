package service; // 20240215

import dao.UserDao;
import vo.User;

public class UserService {
	// 영속화 계층 호출(조립), 기능을 제공해주는 객체 - 읽기 전용
	private final UserDao userDao = new UserDao();
	
	/**
	 * 신규 사용자 정보를 전달받아서 가입처리한다.
	 * @param user 신규 사용자 정보
	 * @throws SQLException
	 */
	public void register(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			throw new RuntimeException("사용자 정보가 이미 존재합니다.");
		}
		savedUser = userDao.getUserByEmail(user.getEmail());
		if (savedUser != null) {
			throw new RuntimeException("사용자 정보가 이미 존재합니다.");
		}
		
		userDao.insertUser(user);
	}
}
