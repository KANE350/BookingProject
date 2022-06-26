package app.spring.third.dto;

import java.util.Date;

public class Member {


	int member_idx;
	String member_name;
	String member_id;
	String member_pw;
	String member_phone;
	String member_birth;
	String member_level;
	Date member_regidate;
	String member_emailauth;
	String member_simplejoin;
	public Member() {
		super();
	}
	public Member(int member_idx, String member_name, String member_id, String member_pw, String member_phone,
			String member_birth, String member_level, Date member_regidate, String member_emailauth,
			String member_simplejoin) {
		super();
		this.member_idx = member_idx;
		this.member_name = member_name;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_phone = member_phone;
		this.member_birth = member_birth;
		this.member_level = member_level;
		this.member_regidate = member_regidate;
		this.member_emailauth = member_emailauth;
		this.member_simplejoin = member_simplejoin;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_level() {
		return member_level;
	}
	public void setMember_level(String member_level) {
		this.member_level = member_level;
	}
	public Date getMember_regidate() {
		return member_regidate;
	}
	public void setMember_regidate(Date member_regidate) {
		this.member_regidate = member_regidate;
	}
	public String getMember_emailauth() {
		return member_emailauth;
	}
	public void setMember_emailauth(String member_emailauth) {
		this.member_emailauth = member_emailauth;
	}
	public String getMember_simplejoin() {
		return member_simplejoin;
	}
	public void setMember_simplejoin(String member_simplejoin) {
		this.member_simplejoin = member_simplejoin;
	}
	@Override
	public String toString() {
		return "Member [member_idx=" + member_idx + ", member_name=" + member_name + ", member_id=" + member_id
				+ ", member_pw=" + member_pw + ", member_phone=" + member_phone + ", member_birth=" + member_birth
				+ ", member_level=" + member_level + ", member_regidate=" + member_regidate + ", member_emailauth="
				+ member_emailauth + ", member_simplejoin=" + member_simplejoin + "]";
	}
	
	
	
}