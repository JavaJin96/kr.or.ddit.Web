package kr.or.ddit.join.service;

import java.util.List;

import kr.or.ddit.join.dao.IMemberDao;
import kr.or.ddit.join.dao.MemberDaoimpl;
import kr.or.ddit.join.vo.MemberVO;
import kr.or.ddit.join.vo.ZipVO;

// 1. 자신의 객체를 생성하여 리턴
// 2. dao객체 얻어오기
public class MemberServiceimpl implements IMemberService {
	
	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceimpl() {
		
		dao = MemberDaoimpl.getInstance();
		
	}
	
	public static IMemberService getInstance() {
		
		if(service == null) {
			service = new MemberServiceimpl();
		}
		
		return service;
	}                                    
	
	
	@Override
	public String selectById(String id) {		
		return dao.selectById(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		return dao.selectByDong(dong); 
	}

	@Override
	public String insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		
		return dao.selectAll();
	}

}
