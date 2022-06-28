package app.spring.third.dto;

import java.util.Date;

public class ComuReply {
	private int creply_idx;
	private	int cboard_idx;
	private String creply_id;
	private String creply_content;
	private	int cr_restep;
	private int cr_relevel;
	private	Date cr_reply_regidate;
	private Date cr_reply_modidate;
	public ComuReply(int creply_idx, int cboard_idx, String creply_id, String creply_content, int cr_restep,
			int cr_relevel, Date cr_reply_regidate, Date cr_reply_modidate) {
		super();
		this.creply_idx = creply_idx;
		this.cboard_idx = cboard_idx;
		this.creply_id = creply_id;
		this.creply_content = creply_content;
		this.cr_restep = cr_restep;
		this.cr_relevel = cr_relevel;
		this.cr_reply_regidate = cr_reply_regidate;
		this.cr_reply_modidate = cr_reply_modidate;
	}
	public ComuReply() {
		super();
	}
	public int getCreply_idx() {
		return creply_idx;
	}
	public void setCreply_idx(int creply_idx) {
		this.creply_idx = creply_idx;
	}
	public int getCboard_idx() {
		return cboard_idx;
	}
	public void setCboard_idx(int cboard_idx) {
		this.cboard_idx = cboard_idx;
	}
	public String getCreply_id() {
		return creply_id;
	}
	public void setCreply_id(String creply_id) {
		this.creply_id = creply_id;
	}
	public String getCreply_content() {
		return creply_content;
	}
	public void setCreply_content(String creply_content) {
		this.creply_content = creply_content;
	}
	public int getCr_restep() {
		return cr_restep;
	}
	public void setCr_restep(int cr_restep) {
		this.cr_restep = cr_restep;
	}
	public int getCr_relevel() {
		return cr_relevel;
	}
	public void setCr_relevel(int cr_relevel) {
		this.cr_relevel = cr_relevel;
	}
	public Date getCr_reply_regidate() {
		return cr_reply_regidate;
	}
	public void setCr_reply_regidate(Date cr_reply_regidate) {
		this.cr_reply_regidate = cr_reply_regidate;
	}
	public Date getCr_reply_modidate() {
		return cr_reply_modidate;
	}
	public void setCr_reply_modidate(Date cr_reply_modidate) {
		this.cr_reply_modidate = cr_reply_modidate;
	}
	@Override
	public String toString() {
		return "C_reply [creply_idx=" + creply_idx + ", cboard_idx=" + cboard_idx + ", creply_id=" + creply_id
				+ ", creply_content=" + creply_content + ", cr_restep=" + cr_restep + ", cr_relevel=" + cr_relevel
				+ ", cr_reply_regidate=" + cr_reply_regidate + ", cr_reply_modidate=" + cr_reply_modidate + "]";
	}
	
	
}
