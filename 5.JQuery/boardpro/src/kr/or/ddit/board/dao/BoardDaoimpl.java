package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.config.SqlMapClientFactory;

public class BoardDaoimpl implements IBoardDao {
	
	private static BoardDaoimpl dao;
	SqlMapClient smc;
	
	public BoardDaoimpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BoardDaoimpl getInstance() {
		if(dao == null) {
			dao = new BoardDaoimpl();
		}
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectBoard() {
		List<BoardVO> list =  new ArrayList<>();
		try {
			 list = smc.queryForList("board.selectBoard");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> selectBoard2(Map<String, Object> map) {
		List<BoardVO> list = null;
		
		try {
			list = smc.queryForList("board.selectBoard2", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int renum = 0;
		
		try {
			renum = (int) smc.insert("board.insertReply" , vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return renum;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		int result = 0;
		
		try {
			
			result = smc.update("board.updateReply", vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	@Override
	public int hitUp(int num) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int countBoard() {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("board.countBoard");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> selectBoard3(Map<String, Object> map) {
		List<BoardVO> list = new ArrayList<>();
		
		try {
			
			list = smc.queryForList("board.selectBoard3",map);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public int searchCount(Map<String, Object> map) {
		int cnt = 0;
		try {
			
			cnt = (int) smc.queryForObject("board.searchCount", map);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		List<ReplyVO> list = new ArrayList<>();
		
		try {
			list = smc.queryForList("board.listReply", bonum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int deleteReply(int renum) {
		int result = 0;
		
		try {
			
			result = smc.delete("board.deleteReply", renum);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	


}
