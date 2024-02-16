package controllers; // 20240215

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jhta.model2.annotation.Controller;
import kr.co.jhta.model2.annotation.RequestMapping;
import kr.co.jhta.model2.constant.HttpMethod;
import service.UserService;
import vo.User;

@Controller
public class HomeController {
	// 요청 핸들러 메소드 정의
	// 서비스 계층 호출(조립), 기능을 제공해주는 객체 - 읽기 전용
	private final UserService userService = new UserService();
	
	// 동작방식 : 1)home.do라는 메시지가 오면 2)이 메소드를 실행 3)그리고 home.jsp로 내부이동
	@RequestMapping(path = "/home.do")
	public String home(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "home.jsp";
	}
	
	// 홈에서 로그인 버튼 눌렀을 때
	@RequestMapping(path = "/login.do")
	public String loginform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "loginform.jsp";
	}
	
	// loginform에서 로그인 눌렀을 때
	@RequestMapping(path = "/login.do", method = HttpMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		try {
			User user = userService.login(id, password); // Service에게 로그인 체크를 수행해달라고 요청
			HttpSession session = req.getSession();
			session.setAttribute("LOGIN_USER", user);
			
			return "redirect:home.do";
		} catch (Exception ex) {
			return "redirect:login.do?error=fail";
		}
		
	}
	
	@RequestMapping(path = "/logout.do")
	public String logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate(); // 세션을 무효화시키는 메소드
		}
		
		return "redirect:home.do";
	}
	
	// home.jsp의 회원가입 링크 눌렀을 때
	@RequestMapping(path = "/register.do", method = HttpMethod.GET)
	public String form(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "registerform.jsp";
	} 
	
	// registerform.jsp의 회원가입 버튼 클릭했을 때
	@RequestMapping(path = "/register.do", method = HttpMethod.POST)
	public String register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 요청파라미터값 조회하기(회원가입 폼에서 submit 시 입력받은 값들을 해당 변수(id, password, name....)로 가져올 수 있음)
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setTel(tel);
		user.setEmail(email);
		
		userService.register(user);
		
		return "redirect:home.do"; // 재요청 URL 응답을 보냄
	}
}
