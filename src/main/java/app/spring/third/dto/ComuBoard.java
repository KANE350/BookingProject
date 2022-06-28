package app.spring.third.dto;

import java.util.Date;

public class ComuBoard {
	private int cboard_idx;
	private String cboard_id;
	private String cboard_title;
	private String cboard_content;
	private Date cboard_regidate;
	private Date cboard_modidate;
	private int cboard_views;
	private int cboard_likes;
	public ComuBoard(int cboard_idx, String cboard_id, String cboard_title, String cboard_content, Date cboard_regidate,
			Date cboard_modidate, int cboard_views, int cboard_likes) {
		super();
		this.cboard_idx = cboard_idx;
		this.cboard_id = cboard_id;
		this.cboard_title = cboard_title;
		this.cboard_content = cboard_content;
		this.cboard_regidate = cboard_regidate;
		this.cboard_modidate = cboard_modidate;
		this.cboard_views = cboard_views;
		this.cboard_likes = cboard_likes;
	}
	public ComuBoard() {
		super();
	}
	public int getCboard_idx() {
		return cboard_idx;
	}
	public void setCboard_idx(int cboard_idx) {
		this.cboard_idx = cboard_idx;
	}
	public String getCboard_id() {
		return cboard_id;
	}
	public void setCboard_id(String cboard_id) {
		this.cboard_id = cboard_id;
	}
	public String getCboard_title() {
		return cboard_title;
	}
	public void setCboard_title(String cboard_title) {
		this.cboard_title = cboard_title;
	}
	public String getCboard_content() {
		return cboard_content;
	}
	public void setCboard_content(String cboard_content) {
		this.cboard_content = cboard_content;
	}
	public Date getCboard_regidate() {
		return cboard_regidate;
	}
	public void setCboard_regidate(Date cboard_regidate) {
		this.cboard_regidate = cboard_regidate;
	}
	public Date getCboard_modidate() {
		return cboard_modidate;
	}
	public void setCboard_modidate(Date cboard_modidate) {
		this.cboard_modidate = cboard_modidate;
	}
	public int getCboard_views() {
		return cboard_views;
	}
	public void setCboard_views(int cboard_views) {
		this.cboard_views = cboard_views;
	}
	public int getCboard_likes() {
		return cboard_likes;
	}
	public void setCboard_likes(int cboard_likes) {
		this.cboard_likes = cboard_likes;
	}
	@Override
	public String toString() {
		return "ComuBoard [cboard_idx=" + cboard_idx + ", cboard_id=" + cboard_id + ", cboard_title=" + cboard_title
				+ ", cboard_content=" + cboard_content + ", cboard_regidate=" + cboard_regidate + ", cboard_modidate="
				+ cboard_modidate + ", cboard_views=" + cboard_views + ", cboard_likes=" + cboard_likes + "]";
	}
	
	
}
