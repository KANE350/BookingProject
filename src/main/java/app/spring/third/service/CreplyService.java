package app.spring.third.service;

import java.util.List;

import app.spring.third.dto.ComuReply;



public interface CreplyService {

	int insert(ComuReply creply);

	List<ComuReply> selectList(int cboard_idx);

	int delete(int creply_idx);

	int update(ComuReply creply);

}
