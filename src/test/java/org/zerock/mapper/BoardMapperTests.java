package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


/*
 * RunWith, ContextConfiguration을 쓰는 이유 : Test step 이기 때문.  
 */

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

/*
 * BoaradMapper Interface에서 구현체를 '주입 받아' 동작
 */
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}

//	@Test
//	public void testGetList() {
//
//		mapper.getList().forEach(row -> log.info(row));
//
//	}
//	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new title");
//		board.setContent("new content");
//		board.setWriter("jayas");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//	}
//	
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new title");
//		board.setContent("new content");
//		board.setWriter("jayas");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void testRead() {
//		// test about object number existed.
//		BoardVO board = mapper.read(5L);
//		
//		log.info(board);
//	}
//	
//	@Test
//	public void testDelete() {
//		log.info("Delete COUNT : " + mapper.delete(21L));
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		// check Bno number that whether existed or not
//		board.setBno(23L);
//		board.setTitle("modified title");
//		board.setContent("m/content");
//		board.setWriter("user99");
//		
//		int count = mapper.update(board);
//		log.info("UPDATE COUNT : " + count);
//	}
	
}
