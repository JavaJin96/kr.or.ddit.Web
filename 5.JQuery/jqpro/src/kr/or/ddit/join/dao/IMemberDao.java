package kr.or.ddit.join.dao;

import java.util.List;

import kr.or.ddit.join.vo.MemberVO;
import kr.or.ddit.join.vo.ZipVO;

public interface IMemberDao {

	// 중복검색
	public String selectById(String id);
	
	// 우편번호 검색
	public List<ZipVO> selectByDong (String dong);
	
	// 회원가입
	public String insertMember (MemberVO vo);
	
	public List<MemberVO> selectAll();
}
