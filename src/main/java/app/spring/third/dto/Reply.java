package app.spring.third.dto;

import java.util.Date;

public class Reply {
	private int reply_idx;
	private	int board_idx;
	private String reply_id;
	private String reply_content;
	private String reply_ip;
	private	int restep;
	private int relevel;
	private	Date reply_regidate;
	private Date reply_modidate;
	public Reply(int reply_idx, int board_idx, String reply_id,String reply_ip, String reply_content, int restep, int relevel,
			Date reply_regidate, Date reply_modidate) {
		super();
		this.reply_idx = reply_idx;
		this.board_idx = board_idx;
		this.reply_id = reply_id;
		this.reply_ip = reply_ip;
		this.reply_content = reply_content;
		this.restep = restep;
		this.relevel = relevel;
		this.reply_regidate = reply_regidate;
		this.reply_modidate = reply_modidate;
	}
	public Reply() {
		super();
	}
	public int getReply_idx() {
		return reply_idx;
	}
	public void setReply_idx(int reply_idx) {
		this.reply_idx = reply_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public Date getReply_regidate() {
		return reply_regidate;
	}
	public void setReply_regidate(Date reply_regidate) {
		this.reply_regidate = reply_regidate;
	}
	public Date getReply_modidate() {
		return reply_modidate;
	}
	public void setReply_modidate(Date reply_modidate) {
		this.reply_modidate = reply_modidate;
	}
	public String getReply_ip() {
		return reply_ip;
	}
	public void setReply_ip(String reply_ip) {
		this.reply_ip = reply_ip;
	}
	@Override
	public String toString() {
		return "Reply [reply_idx=" + reply_idx + ", board_idx=" + board_idx + ", reply_id=" + reply_id
				+ ", reply_content=" + reply_content + ", reply_ip=" + reply_ip + ", restep=" + restep + ", relevel="
				+ relevel + ", reply_regidate=" + reply_regidate + ", reply_modidate=" + reply_modidate + "]";
	}
	
	
	
	
	
}
