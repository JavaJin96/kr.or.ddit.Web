package kr.or.ddit.join.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sun.security.sasl.ClientFactoryImpl;

import kr.or.ddit.config.SqlMapClientFactory;
import kr.or.ddit.join.vo.MemberVO;
import kr.or.ddit.join.vo.ZipVO;

// 1. 자신의 객체를 생성해서 리턴(싱글톤)
// 2. SqlMapClient 객체
public class MemberDaoimpl implements IMemberDao {
	
	private SqlMapClient smc;
	
	
	// A is B (상속의 개념)
	private static IMemberDao dao;
	
	// 일반 생성자는 일반적인 객체 생성
	private MemberDaoimpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	// 자기자신을 생성해서 리턴하는 과정(싱글톤)
	public static IMemberDao getInstance() {
		
		if(dao == null) {
			dao = new MemberDaoimpl();			
		}
		
		return dao;
	}
	
	
	@Override
	public String selectById(String id) {
		String resId = null;
		
		try {
			resId = (String) smc.queryForObject("join.selectById", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resId;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		List<ZipVO> list = null;
		
		try {
			
			list = smc.queryForList("join.selectByDong", dong);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) {
		String res = null;
		
		try {
			
			res = (String) smc.insert("join.insertMember", vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return res;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		
		try {
			list = smc.queryForList("join.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

}















