package com.project.mb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.mb.config.DBService;
import com.project.mb.dto.BoardDto;

public class BoardDao {

	// Field
	private SqlSessionFactory factory = null;
	
	// Singleton
	private BoardDao() {
		factory = DBService.getFactory();
	}
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance() {
		return dao;
	}
	
	// Method
	public List<BoardDto> getBoardList(Map<String, Integer> map) {
		SqlSession sqlSession = factory.openSession();
		List<BoardDto> list = sqlSession.selectList("select_board_by_map", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalRecord() {
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.selectOne("select_total_record");
		sqlSession.close();
		return result;
	}
	
	public int getInsertBoard(BoardDto bDto) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.insert("insert_board", bDto);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	public BoardDto getBoardBybIdx(int bIdx) {
		SqlSession sqlSession = factory.openSession();
		BoardDto bDto = sqlSession.selectOne("select_board_by_bIdx",bIdx);
		sqlSession.close();
		return bDto;
	}
	
	public int getDeleteBoard(BoardDto bDto) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.update("update_board_for_delete", bDto);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	public int getUpdateHit(int bIdx) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.update("update_hit", bIdx);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
		
	}
	
	public int getInsertReply(BoardDto bDto) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.insert("insert_reply", bDto);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	public int getUpdateStep(BoardDto bDto) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.update("update_bStep", bDto);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	public List<BoardDto> getMyBoardList(Map<String, String> map) {
		SqlSession sqlSession = factory.openSession();
		List<BoardDto> list = sqlSession.selectList("select_myboard_by_map", map);
		sqlSession.close();
		return list;
	}
	
	public int getMyRecord(String mId) {
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.selectOne("select_my_record", mId);
		sqlSession.close();
		return result;
	}
	
}