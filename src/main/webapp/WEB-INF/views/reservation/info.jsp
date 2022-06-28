<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Heroic Features - Start Bootstrap Template</title>
<!-- Bootstrap icons-->
<link rel="icon" type="image/x-icon" href="${path}/resources/image/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${path}/resources/css/reservstyles.css" rel="stylesheet" />
</head>
<title>Insert title here</title>
</head>
<body>



<!-- 	   Responsive navbar
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Blog</a></li>
                    </ul>
                </div>
            </div>
        </nav> -->
	<%@ include file="../header.jsp" %>

	<!-- Sidebar-->
	<div class="d-flex" id="wrapper">
		 <div class="border-end bg-white" id="sidebar-wrapper">
			<%@ include file="../sidebar.jsp" %>
		</div> 
	
		
		<div id="content00">
			<div id="sh_content_title">
				<p>
					<b>기본 정보</b><br>
				</p>
			</div>
			<h3>기본사항</h3>
			<div class="img_txt">
				<div class="left20 mat20 mobile_none">
					<img src="${path}/resources/image/info1.jpg" alt="x" 	width="100" height="100">
					<div class="right80">
						<ul class="basic mab40">
							<li>예약은 인터넷을 통해 365일 언제나 가능합니다.</li>
							<li>예약하신 분과 이용요금을 입금하신 분이 다른 경우 반드시 안내전화로 연락주시기 바랍니다.</li>
							<li>사정상 객실요금 입금이 지연될 경우, 안내전화로 연락주시면 상담 후 조치해 드립니다.</li>
							<li class="rd">
								예약후 요금을 전액 입금하셔야 예약이 완료되며 요금 미입금시(24시간이 지나면) 자동 취소됩니다.
							</li>
							<li class="rd">
								입실시간은 이용당일 14:30 부터 22:00까지 입니다. 22:00 이후 휴양림에 도착시에는 사전 연락을 주시기 바랍니다.
							</li>
							<li>
								11:00 ~ 14:30까지는 객실 및 주변 청소시간이므로 입실 허용시간 이전에 도착하셔도 입실이 	어렵습니다. 협조 바랍니다.
							</li>
							<li><span class="rd">
								퇴실시간은 마지막 이용일 오전 11:00 까지</span> 입니다. 
								<span class="bl">객실정리 후 퇴실점검을 받으셔야 하며,</span> 점검 후 객실키를 반납해 주시기 바랍니다.
							</li>
							<li> 퇴실하실때 모든 쓰레기는 분리수거하여 쓰레기장 또는 주차장으로 운반해 주시고 사용하신 식기류도 세척해 	주시기 바랍니다.</li>
							<li>예약인원에서 인원이 추가되었을 경우 미리 말씀하셔야 하며 최대인원 초과 시는 입실에 제한을 받을 수	있습니다.</li>
							<li>상황 인원에 따라서 요금이 약간 변동이 있을 수도 있습니다.</li>
						</ul>
					</div>
				</div>
			</div>
		
		
		<span class="line_dot"></span>
		<h3>예약금 결제</h3>
		<div class="img_txt">
			<div class="left20 mat20 mobile_none">
				<img src="${path}/resources/image/info2.jpg" alt=""
					width="140" height="140">
			</div>
			<div class="right80">
				<ul class="basic mab40">
					<li>예약금 결제는 신용카드, 무통장입금을 통해서 가능합니다.</li>
					<li>신용카드 : 예약자께서는 카드 결제 승인후 예약상황(예약및취소)을 통한 재확인(예약완료)바랍니다.</li>
					<li>무통장입금 : 예약 결제 대금을 예약자가 등록한 송금계좌로 입금하는 방식으로 유치자연휴양림에서 통장확인
						후 입금확인이 가능합니다.</li>
					<li><span class="rd">예약후 24시간 이내 입금 확인되지 않을 경우 예약이 자동
							취소됩니다.</span>
						<ul>
							<li class="bl">은행 : 농협</li>
							<li class="bl">계좌번호 : 301-0265-3564-61</li>
							<li class="bl">예금주 : 금진임업영농조합법인</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<span class="line_dot"></span>
		<h3>유의사항</h3>
		<div class="img_txt">
			<div class="left20 mat20 mobile_none">
				<img src="${path}/resources/image/info3.jpg" alt=""
					width="140" height="140">
			</div>
			<div class="right80">
				<ul class="basic mab40">
					<li>애완동물과 함께 입실하실 수 없습니다.</li>
					<li>보호자를 동반하지 않은 미성년자의 이용은 불가합니다.</li>
					<li>객실 내에서는 절대 금연이며 삼겹살 등의 육류를 직화방식으로 조리하실 수 없습니다.</li>
					<li>이용 중 비치된 집기나 시설물을 파손시 별도로 말씀해 주셔야 합니다.</li>
					<li>이용객의 부주의로 인한 사고에 대해서는 책임을 지지 않습니다.</li>
					<li>무분별한 오락 및 음주, 고성방가 등 다른 이용객에게 불쾌감을 주는 행동은 삼가주시기 바랍니다.</li>
				</ul>
			</div>
		</div>
		<span class="line_dot"></span>
		<h3>예약취소 및 예약내용 변경</h3>
		<div class="img_txt">
			<div class="left20 mat20 mobile_none">
				<img src="${path}/resources/image/info4.jpg" alt=""
					width="140" height="140">
			</div>
			<div class="right80 yc">
				<ul class="basic mat40">
					<li class="rd">예약의 취소 및 예약내용의 변경은 '온라인예약' 메뉴(예약확인/취소)에서 하시면
						됩니다.</li>
					<li>예약의 취소나 변경시 환불금액은 <span class="rd">입력하신 계좌번호로 환불</span>되오니
						정보를 정확하게 입력하셔야 합니다.
					</li>
					<li>예약을 취소하실 경우 취소시기에 따라 아래와 같이 사용 예정일을 기준으로 위약금이 부과 됩니다.</li>
					<li>※ 예약금환불시 송금수수료가 공제됩니다.</li>
				</ul>
			</div>
		</div>
		<span class="line_dot"></span>
		<h3>환불기준(위약금 부과)</h3>
		<div class="img_txt">
			<div class="left20 mat20 mobile_none">
				<img src="${path}/resources/image/info5.jpg" alt=""
					width="140" height="140">
			</div>
			<div class="right80 yc">
				<ul class="basic mat50">
					<li>올바른 예약문화의 정착을 위하여 불가피한 조치이오니 양해부탁드립니다.</li>
					<li class="rd">예약후 날짜변경, 객실변경은 예약취소후 다시 예약하셔야합니다.</li>
					<li>객실과 날짜는 예약전 신중히 생각하시고 결정해주시기 바랍니다.</li>
				</ul>
				<ul class="basic">
					<li>예약일로부터 10일전까지 : <span class="rd fw5">100%환불</span></li>
					<li>예약일로부터 9일전까지 : <span class="rd fw5">90%환불</span></li>
					<li>예약일로부터 8일전까지 : <span class="rd fw5">80%환불</span></li>
					<li>예약일로부터 7일전까지 : <span class="rd fw5">70%환불</span></li>
					<li>예약일로부터 6일전까지 : <span class="rd fw5">60%환불</span></li>
					<li>예약일로부터 5일전까지 : <span class="rd fw5">50%환불</span></li>
					<li>예약일로부터 4일전까지 : <span class="rd fw5">40%환불</span></li>
					<li>예약일로부터 3일전까지 : <span class="rd fw5">30%환불</span></li>
					<li>예약일로부터 2일전까지 : <span class="rd fw5">20%환불</span></li>
					<li>예약일로부터 1일전까지 : <span class="rd fw5">10%환불</span></li>
					<li>당일취소 : 미환불</li>
				</ul>
				<ul class="basic mat30">
					<li>천재지변 등 그 밖에 불가항력의 사유로 인하여 사용이 불가능하게 된 경우 전액 환불</li>
					<li>사용일이 지날 때까지 취소 또는 사용하지 아니하였을 경우에는 전액 환불하지 아니합니다. <span
						class="rd fw5 next">(예약금 환불시 송금수수료가 공제됩니다.)</span></li>
					<li>환불은 예약취소일부터 7일 이내에 예약자에게 환불하는 것을 원칙으로 합니다</li>
				</ul>
			</div>
		</div>
	
	 
	 </div>
	<!-- Footer-->
	</div>
	 
	
	<!-- Footer -->
	<%@ include file="../footer.jsp" %>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="${path}/resources/js/scripts.js"></script>

</body>
</html>