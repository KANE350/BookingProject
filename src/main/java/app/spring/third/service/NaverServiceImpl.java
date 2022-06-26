package app.spring.third.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Member;
import app.spring.third.repository.MemberRepository;

@Service
public class NaverServiceImpl implements NaverService{
	private static final Logger logger = LoggerFactory.getLogger(NaverServiceImpl.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	//네이버 로그인
	@Override
	public ErrorCode naverLogin(String code, String state, HttpSession session){
		//토큰생성(토큰을 이용해서 개인정보 얻을수 있다)
		String accesstoken = getAccessToken(code, state);

		//개인정보얻기
		Member member = getUserInfo(accesstoken);
		
		//네이버간편가입 정보 db에서 조회
		Member dbmember = memberRepository.selectOne(member.getMember_id());
		if (dbmember!=null) { //이미가입이 되어 있다면
			//네이버 간편가입한 회원이 아니라면
			if (!dbmember.getMember_simplejoin().equals("1")) {
				return ErrorCode.ERROR_NO_NAVER_JOIN;
			}else {
				//이미 간편가입 으로 가입
				session.setAttribute("member_id", member.getMember_id()); //세션저장(로그인)
				return ErrorCode.SUCCESS_NAVER_LOGIN;
			}
		}		
		//가입된 정보가 없다면 저장
		insert_simplejoin(member);
		session.setAttribute("member_id", member.getMember_id());//세션저장(로그인)
		return ErrorCode.SUCCESS_NAVER_JOIN;
		
	}
	
	
	@Override
	public Map<String, String> getApiUrl() throws Exception {
		//네이버 로그인을 위한 apiUrl과 state 리턴
		Map<String, String> rmap = new HashMap<>();
	    String clientId = "PwNXcuaPKMBEhstThs8g";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = URLEncoder.encode("http://localhost:8081/myapp/naverCallback", "UTF-8"); //나의 콜백주소
	    //인증값(state)생성
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    //session.setAttribute("state", state);
	    rmap.put("apiURL", apiURL);
	    rmap.put("state", state);
		    
		return rmap;
	}

	private String getAccessToken(String code, String state) {
		// accessToken반환 
		//토큰 가져오기
	    String clientId = "PwNXcuaPKMBEhstThs8g";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "3H1vZyicAE";//애플리케이션 클라이언트 시크릿값";
	    String accesstoken = "";
	    try {
		    String redirectURI = URLEncoder.encode("http://localhost:8081/myapp/naverCallback", "UTF-8");
		    String apiURL;
		    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		    apiURL += "client_id=" + clientId;
		    apiURL += "&client_secret=" + clientSecret;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&code=" + code;
		    apiURL += "&state=" + state;

	    	URL url = new URL(apiURL);
	    	HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    	con.setRequestMethod("GET");
	    	int responseCode = con.getResponseCode();
	    	BufferedReader br;
	    	if(responseCode==200) { // 정상 호출
	    		br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    	} else {  // 에러 발생
	    		br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    	}
	    	String inputLine;
	    	StringBuffer res = new StringBuffer();
	    	while ((inputLine = br.readLine()) != null) {
	    		res.append(inputLine);
	    	}
	    	br.close();
	    	if(responseCode==200) {
	    		//json파싱 : access_token토큰 얻기
	    		JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
	    		accesstoken = (String) object.get("access_token");
	    	}
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	    
		return accesstoken;
	}

	private Member getUserInfo(String accesstoken) {
		// 토큰을이용해서 개인정보 요청

		Member member = null; //반환

		String header = "Bearer " + accesstoken; // Bearer 다음에 공백 추가
        String apiURL = "https://openapi.naver.com/v1/nid/me";
        HttpURLConnection con = null;
        BufferedReader br = null;
		try {
		    URL url = new URL(apiURL);
		    con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			
			//json파싱
	    	JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
	    	object = (JSONObject) object.get("response");
	    	String id = (String) object.get("id");
	    	String email = (String) object.get("email");
	    	String name = (String) object.get("name");
	    	
	    	//멤버객체를 생성
	    	member = new Member();
	    	member.setMember_id(email);
	    	member.setMember_name(name);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (con != null) con.disconnect();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//개인정보 반환
		return member;
		
	}
	
	private void insert_simplejoin(Member member) {
		//네이버간편가입
		member.setMember_simplejoin("1");
		// 네이버 간편가입 데이터 db에 저장
		int cnt = memberRepository.insert_simplejoin(member);
		 	
	}
	
	
	
	

}

