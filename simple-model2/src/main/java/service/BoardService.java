package service; // 20240215

import java.util.List;
import java.util.Map;

import dao.BoardDao;
import dto.BoardListDto;
import dto.Pagination;
import vo.Board;

public class BoardService {

	private final BoardDao boardDao = new BoardDao();
	
	public BoardListDto getBoardList(int currentPage, Map<String, Object> param) throws Exception {
		int totalRows = boardDao.getTotalRows();
		
		// 1. 페이지네이션 객체에 페이지 담기
		Pagination pagination = new Pagination(currentPage, totalRows);
		param.put("begin", pagination.getBegin());
		param.put("end", pagination.getEnd());
		
		// 2. Board 리스트 객체 획득
		List<Board> boards = boardDao.getAllBoards(param);
		
		// 3. BoardListDto에 1,2번 객체 담기
		BoardListDto dto = new BoardListDto();
		dto.setItems(boards);
		dto.setPagination(pagination);
		
		return dto;
	}

	public void save(Board board) throws Exception {
		boardDao.insertBoard(board);
	}

	public Board getBoardDetail(int no) throws Exception {
		Board board = boardDao.getBoardByNo(no);	  // 1. 상세정보 조회
		board.setReadCount(board.getReadCount() + 1); // 2. 조회수 1 증가
		boardDao.updateBoard(board);				  // 3. 기존 상세정보 업데이트(조회수 증가용 업데이트 따로 만들 필요x) 
		
		return board;
	}
	
	public void deleteBoardByNo(int no) throws Exception {
		Board board = boardDao.getBoardByNo(no);
		board.setDeleted("Y");
		boardDao.updateBoard(board);
	}

	public void update(int no, String title, String content) throws Exception {
		Board board = boardDao.getBoardByNo(no);
		board.setTitle(title);
		board.setContent(content);
		boardDao.updateBoard(board);
		
	}
}
