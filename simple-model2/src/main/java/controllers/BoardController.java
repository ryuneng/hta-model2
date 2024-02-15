package controllers; // 20240215

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.model2.annotation.Controller;
import kr.co.jhta.model2.annotation.RequestMapping;
import service.BoardService;
import vo.Board;

@Controller
@RequestMapping(path = "/board")
public class BoardController {
	
	private final BoardService boardService = new BoardService();
	
	@RequestMapping(path = "/list.do")
	public String list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Board> boardList = boardService.getBoardList();
		req.setAttribute("boardList", boardList);
		
		return "board/list.jsp";
	}
}
