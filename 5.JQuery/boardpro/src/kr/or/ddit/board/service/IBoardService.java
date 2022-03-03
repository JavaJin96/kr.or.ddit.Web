package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	
	// 전체 리스트 가져오기 
	public List<BoardVO> selectBoard (); 
		
	// 페이지별 리스트 가져오기 - 검색포함안됨 - board2 - boardpage.jsp - ListPage.do
	public List<BoardVO> selectBoard2 (Map<String, Object> map);
	
	// 전체 글수 가져오기 - 검색포함안됨
	public int countBoard();
	
	
	// 페이지 정보 얻기 (Start, End, Start, End, totalpage)
	public Map<String, Object> pageInfo(int page);
	
	//================================================================
	
	// 페이지별 리스트 가져오기 - 검색 포함 - boardserach - boardpage.jsp
	public List<BoardVO> selectBoard3 (Map<String, Object> map);
	
	// 전체 글수 가져오기 - 검색포함
	public int searchCount (Map<String, Object> map);
	
	// 페이지 정보 얻기 (Start, End, Start, End, totalpage) - 검색포함
	public Map<String, Object> pageInfo(Map<String, Object> map);

	//================================================================
	
	// 글 저장
	public int insertBoard(BoardVO vo);
	
	// 글 삭제
	public int deleteBoard(BoardVO vo);
	
	// 글 수정
	public int updateBoard(BoardVO vo);
	
	// 댓글 등록 - renum 리턴한다.
	public int insertReply(ReplyVO vo);
	
	// 댓글 수정
	public int updateReply(ReplyVO vo);
	
	// 댓글 삭제
	public int deleteReply(int renum);
	
	// 조회수 증가
	public int hitUp(int num);
	
	// 댓글 리스트
	public List<ReplyVO> listReply(int bonum);
	


	
}
