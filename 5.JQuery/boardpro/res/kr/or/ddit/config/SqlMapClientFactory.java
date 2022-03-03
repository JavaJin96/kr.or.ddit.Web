package kr.or.ddit.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;
	
	
	
	// static초기화 블럭 - {} 초기화 블럭 - 생성자 호출의 순서대로 객체가 생성된다.
	// static이 붙은 초기화 블럭은 객체를 초기화할때 맨처음 한번만 생성된다.
	// {} 은 new로 생성될 때마다 매번 생성된다. 
	static {
		try {
			
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);;
			
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return smc;
	}
	
	
	
}
