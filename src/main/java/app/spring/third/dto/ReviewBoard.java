package app.spring.third.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReviewBoard {
	private int board_idx;
	private String room_name;
	private String board_id;
	private String board_title;
	private String board_content;
	private Date board_regidate;
	private Date board_modidate;
	private int board_views;
	private int board_likes;
	
	private List<MultipartFile> files;
	
	
	
	
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public ReviewBoard(int board_idx, String room_name, String board_id, String board_title, String board_content,
			Date board_regidate, Date board_modidate, int board_views, int board_likes) {
		super();
		this.board_idx = board_idx;
		this.room_name = room_name;
		this.board_id = board_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regidate = board_regidate;
		this.board_modidate = board_modidate;
		this.board_views = board_views;
		this.board_likes = board_likes;
	}
	public ReviewBoard() {
		super();
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_regidate() {
		return board_regidate;
	}
	public void setBoard_regidate(Date board_regidate) {
		this.board_regidate = board_regidate;
	}
	public Date getBoard_modidate() {
		return board_modidate;
	}
	public void setBoard_modidate(Date board_modidate) {
		this.board_modidate = board_modidate;
	}
	public int getBoard_views() {
		return board_views;
	}
	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}
	public int getBoard_likes() {
		return board_likes;
	}
	public void setBoard_likes(int board_likes) {
		this.board_likes = board_likes;
	}
	@Override
	public String toString() {
		return "ReviewBoard [board_idx=" + board_idx + ", room_name=" + room_name + ", board_id=" + board_id
				+ ", board_title=" + board_title + ", board_content=" + board_content + ", board_regidate="
				+ board_regidate + ", board_modidate=" + board_modidate + ", board_views=" + board_views
				+ ", board_likes=" + board_likes + ", files=" + files + "]";
	}
	
	
	
}
