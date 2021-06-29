package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

//	@Select("SELECT * FROM tbl_board") 
// 쿼리가 여러 줄이 될 경우, 관리하기가 어려우니
// 따로 관리할 수 있는 파일을 만들어 둘 것
	public List<BoardVO> getList();
	
	// INSERT INTO tbl_board (title, content, writer) 
		// VALUES (#{title}, #{content}, #{writer})
		public int insert(BoardVO board);
		/*
			String sql = "INSERT INTO tbl_board (title, content, writer) VALUES (?, ?, ?) ";
			...
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			
			pstmt.executeUpdate();
		 */
	
		public int insertSelectKey(BoardVO board);
		
		public BoardVO read(long bno);
		
		public int delete(long bno);
		
		public int update(BoardVO board);
}