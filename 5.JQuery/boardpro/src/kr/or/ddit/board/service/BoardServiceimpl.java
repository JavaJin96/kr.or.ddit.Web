package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoimpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceimpl implements IBoardService {
	
	private static BoardServiceimpl service;
	private BoardDaoimpl dao;
	
	public BoardServiceimpl() {
		dao = BoardDaoimpl.getInstance();
	}
	
	public static BoardServiceimpl getInstance () {
		if(service == null) {
			service = new BoardServiceimpl();
		}
		return service;
	}
	
	

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return dao.deleteBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		return dao.insertReply(vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		return dao.updateReply(vo);
	}

	@Override
	public int deleteReply(int renum) {
		return dao.deleteReply(renum);
	}

	@Override
	public int hitUp(int num) {
		return dao.hitUp(num);
	}



	@Override
	public int countBoard() {
		return dao.countBoard();
	}

	
	// 검색 없는 리스트 페이지
	//=======================================================
	
	@Override
	public List<BoardVO> selectBoard() {
		return dao.selectBoard();
	}
	
	@Override
	public List<BoardVO> selectBoard2(Map<String, Object> map) {
		//selectByPage : 검색없는 페이지별 리스트
		return dao.selectBoard2(map);
	}
	public Map<String, Object> pageInfo(int page) {
		// 전체글개수 가져오기
		int count = countBoard();
		
		// 한 페이지당 출력할 글 개수 : 3
		int perList = 3;
		
		// 한 화면에 출력할 페이지 개수
		int perPage = 2;
		
		// 전체페이지 구하기
		int totalPage = (int)Math.ceil((double)count / perList);
		
		// 시작글과 끝글 구하기
		// 보여줄 rownum번호
		int start = (page-1) * perList + 1;		
		int end = start + perList -1;
		if(end > count) end = count;
		
		// 보여줄 page번호
		int startPage = ((page-1) / perPage * perPage) + 1;
		int endPage = startPage + perPage -1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		
		
		return map;
	}
	
	//=======================================================
	
	// 검색 포함된 페이지별 리스트
	//=====================================================
	@Override
	public List<BoardVO> selectBoard3(Map<String, Object> map) {
		//SelectByPS
		return dao.selectBoard3(map);
	}

	@Override
	public int searchCount(Map<String, Object> map) {
		// 전체글개수 가져오기 : 검색조건에 따라서
		return dao.searchCount(map);
	}

	@Override
	public Map<String, Object> pageInfo(Map<String, Object> map) {
		// parameter map - cpage, stype, sword
		// 전체글개수 가져오기
		int count = this.searchCount(map);

		// 한 페이지당 출력할 글 개수 : 3
		int perList = 3;

		// 한 화면에 출력할 페이지 개수
		int perPage = 2;

		// 전체페이지 구하기
		int totalPage = (int) Math.ceil((double) count / perList);
		
		int page = (int)map.get("cpage");
		// 시작글과 끝글 구하기
		// 보여줄 rownum번호
		int start = (page - 1) * perList + 1;
		int end = start + perList - 1;
		if (end > count)
			end = count;

		// 보여줄 page번호
		int startPage = ((page - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		Map<String, Object> rmap = new HashMap<>();
		rmap.put("start", start);
		rmap.put("end", end);
		rmap.put("startPage", startPage);
		rmap.put("endPage", endPage);
		rmap.put("totalPage", totalPage);

		return rmap;
	}
	//=====================================================

	@Override
	public List<ReplyVO> listReply(int bonum) {
		
		return dao.listReply(bonum);
	}

}
