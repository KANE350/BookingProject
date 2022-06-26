package app.spring.third.service;

import javax.servlet.http.HttpSession;

import app.spring.third.advice.ErrorCode;


public interface LoginService {
	ErrorCode loginCheck(String member_id, String member_pw, HttpSession session);
	
}
