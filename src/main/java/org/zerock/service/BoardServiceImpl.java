package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Service 
@Log4j 
public class BoardServiceImpl implements BoardService {

	/* 
	 * Auto working in Spring 4.3 up Version
	 */
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
		//log.info("register...... @ @ @ @ " + board)
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get......" + bno);

		return mapper.read(bno);

	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno) == 1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		// TODO Auto-generated method stub
//		
//		//log.info("getList★★★★★★★★★★★★★★★")
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with Criteria : " + cri);
		
		return mapper.getListWithPaging(cri);
	}
}
	
	

