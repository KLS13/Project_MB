package com.project.mb.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.mb.config.DBService;
import com.project.mb.dto.MemberDto;

public class MemberDao {
	// Field
		private SqlSessionFactory factory = null;
		
		// Singleton
		private MemberDao() {
			factory = DBService.getFactory();
		}
		private static MemberDao dao = new MemberDao();
		public static MemberDao getInstance() {
			return dao;
		}
		
		public int getInsertJoin(MemberDto mDto) {
			SqlSession sqlSession = factory.openSession(false);
			int result = sqlSession.update("member_join",mDto);
			if(result > 0 ) {
				sqlSession.commit();
			}
			sqlSession.close();
			return result;
		}	
		
		public MemberDto getMemberId(String mId) {
			SqlSession sqlSession = factory.openSession();
			MemberDto dto = sqlSession.selectOne("select_mId", mId);
			sqlSession.close();
			return dto;
		}
		
		public MemberDto getMemberLogin(MemberDto mDto) {
			SqlSession sqlSession = factory.openSession();
			MemberDto dto = sqlSession.selectOne("select_Login", mDto);
			sqlSession.close();
			return dto;
		}
		
}
