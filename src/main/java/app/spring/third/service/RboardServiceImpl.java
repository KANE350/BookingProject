package app.spring.third.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Page;
import app.spring.third.dto.ReviewBoard;
import app.spring.third.dto.Reviewfile;
import app.spring.third.repository.RboardRepositroy;
import app.spring.third.repository.ReviewfileRepository;

@Service
public class RboardServiceImpl implements RboardService {

	@Autowired
	private RboardRepositroy rboardRepository;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private ReviewfileRepository reviewfileRepository;
	
	
	
	@Override
	public List<ReviewBoard> selectlist(Page page) {
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
				int totalCnt = rboardRepository.selectTotalCnt(page);
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
				return rboardRepository.selectList(page);
			}
	@Override
	public ErrorCode insert(ReviewBoard reviewboard) throws Exception {
		
		rboardRepository.insert(reviewboard);
		
		reviewFilesSave(reviewboard);
		
		return ErrorCode.SUCCESS_ADD;
	}
	
	
	//조회수
	@Override
	public int update_readcnt(int board_idx) {
		
		return rboardRepository.update_readcnt(board_idx);
	}
	
	
	//한건조회(게시글 상세보기)
	@Override
	public ReviewBoard selectOne(int board_idx) {
		// TODO Auto-generated method stub
		return rboardRepository.selectOne(board_idx);
	}
	
	//삭제
	@Override
	public ErrorCode delete(int board_idx) {
		
		rboardRepository.delete(board_idx);
		return ErrorCode.SUCCESS_REMOVE;
	}
	@Override
	public ErrorCode update(ReviewBoard reviewBoard, List<Integer> removeFiles) throws Exception {
		
		//1) 게시물 수정
		rboardRepository.update(reviewBoard);
		
		//2) 게시물 파일 db삭제
		
				if(removeFiles!=null) {
					for(int rf_idx:removeFiles) {
						reviewfileRepository.delete(rf_idx);
					}
				}
		
		//3) 파일 업로드
				reviewFilesSave(reviewBoard);
				
		return ErrorCode.SUCCESS_MODIFY;
	}
	
	
	private void reviewFilesSave(ReviewBoard reviewBoard ) throws Exception {
		//파일을 저장
		List<MultipartFile> files = reviewBoard.getFiles();
		for(MultipartFile file:files) {
			String filename = fileService.fileUpload(file);
			if(filename.equals("")) continue; //파일이름이 공백일 경우 저장하지 않는다
			
			// 게시물파일 객체생성
			Reviewfile reviewFile = new Reviewfile();
			reviewFile.setBoard_idx(reviewBoard.getBoard_idx());
			reviewFile.setRf_filename(filename);
			
			reviewfileRepository.insert(reviewFile);
		}
}
	@Override
	public int updateLikeCnt(int board_idx) {
		// TODO Auto-generated method stub
		return rboardRepository.updateLikeCnt(board_idx);
	}

}
