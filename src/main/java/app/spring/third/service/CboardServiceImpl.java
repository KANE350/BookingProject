package app.spring.third.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.ComuBoard;
import app.spring.third.dto.Page;
import app.spring.third.repository.CboardRepository;

@Service
public class CboardServiceImpl implements CboardService {

	@Autowired
	private CboardRepository cboardRepository; 
	
	
	
	@Override
	public List<ComuBoard> selectlist(Page page) {
		//페이징처리
		int curPage = page.getCurPage();
		int perPage = page.getPerPage();
		int perBlock = page.getPerBlock();
		
		//1)게시물의 시작번호
		int startNum = (curPage-1) * perPage + 1;
		
		//2)게시물의 끝번호
		int endNum = startNum + perPage -1 ;
		
		//3)페이지블럭의 시작페이지
		int startPage = curPage - ((curPage-1)%perBlock);
		//4)페이지블럭의 끝페이지
		int endPage = startPage + perBlock - 1;
		
		
		
		//5)전체페이지 수
		int totalCnt = cboardRepository.selectTotalCnt(page);
		int totPage = totalCnt/perPage;
		if(totalCnt%perPage!=0) totPage++; // 나머지가 있으면 +1
		if(endPage>totPage) endPage=totPage; 
		//endPage는 totPage보다 작거나 같아야 한다
			
		
		//page 세팅
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setTotPage(totPage);
		return cboardRepository.selectList(page);
	}
	

	@Override
	public ErrorCode insert(ComuBoard comuboard) {
		System.out.println(comuboard);
		cboardRepository.insert(comuboard);
		
		return ErrorCode.SUCCESS_ADD;
	}

	@Override
	public int update_readcnt(int cboard_idx) {
		
		return cboardRepository.update_readcnt(cboard_idx);
	}

	@Override
	public ComuBoard selectOne(int cboard_idx) {
		// TODO Auto-generated method stub
		return cboardRepository.selectOne(cboard_idx);
	}

	@Override
	public ErrorCode delete(int cboard_idx) {
		cboardRepository.delete(cboard_idx);
		return ErrorCode.SUCCESS_REMOVE;
	}

	@Override
	public ErrorCode update(ComuBoard comuboard) {
		cboardRepository.update(comuboard);
		return ErrorCode.SUCCESS_MODIFY;
	}

}
