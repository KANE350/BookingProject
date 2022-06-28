<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Bootstrap Template</title>
<style>
#wrapper {
	width: 600px;
	margin: 0 auto;
}
</style>
<!-- Bootstrap icons-->
<link rel="icon" type="image/x-icon"
	href="${path}/resources/images/favicon.ico" />
<script type="text/javascript" src="${path}/resources/js/home.js"></script>

</head>
<body>

	<div class="container">
		<%@include file="header.jsp"%>

		<!-- Page content-->
		<div class="container mt-5">
			<div class="row">
				<div class="col-lg-8">
					<!-- Post content-->
					<article>
						<!-- Post header-->
						<header class="mb-4">
							<!-- Post title-->
							<h1 class="fw-bolder mb-1">게하 어때</h1>
							<!-- Post meta content-->
							<div class="text-muted fst-italic mb-2">고단한 여행에 지친 당신, 게하
								어때?</div>
						</header>

						<div id="wrapper">
							<div class="bxslider">
								<div>
									<img src="${path}/resources/images/guesthouse1.jpg">
								</div>
								<div>
									<img src="${path}/resources/images/guesthouse3.jpg">
								</div>
								<div>
									<img src="${path}/resources/images/guesthouse2.jpg">
								</div>

							</div>
						</div>


						<!-- Post content-->
						<section class="mb-5">
							<p class="fs-5 mb-4">
								게하 어때에 방문하신, 혹은 방문 예정이신 여러분 모두 환영합니다. <br>저희 게하어때는 여러분들에게
								잠깐의 하룻밤이 아닌, 여러분들의 추억의 한 조각이 될 수 있도록 최선을 다하고 있습니다.
							</p>
							<h2 class="fw-bolder mb-4 mt-5">첫째, 조식 서비스</h2>
							<p class="fs-5 mb-4">
								고단한 여행길, 든든히 속을 채우실 수 있게 조식 서비스를 제공하고 있습니다. <br>체크인한 당일 저녁
								7시 전까지 1층 카운터에 요청하시면, 다음날 오전 8시~11시 사이에 따뜻한 조식을 드실 수 있습니다.
							</p>
							<h2 class="fw-bolder mb-4 mt-5">둘째, 관광 서비스</h2>
							<p class="fs-5 mb-4">
								저희는 당일 숙박 예정이신 분들을 대상으로 신청을 받아 인원이 5인 이상인 경우, 소정의 금액을 받아 저녁 관광
								가이드를 해드리고 있습니다. <br>숙박 당일 문자를 받으시고, 희망하시는 분들만 3000원의 금액과 함께
								신청해주시면 됩니다.
							</p>
							<h2 class="fw-bolder mb-4 mt-5">셋째, 무료 세탁 서비스</h2>
							<p class="fs-5 mb-4">
								더러워진 옷을 저녁 7시 전까지 스태프에게 전달해주시면, 다음날 아침 세탁하여 뽀송한 상태로 돌려드립니다. <br>여러분들의
								여행이 한결 즐거울 수 있도록, 저희 게하어때는 최선을 다하겠습니다.
							</p>
						</section>
					</article>
				</div>
			</div>
		</div>
		<!--부트스트랩-->
		<!-- Footer-->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Your How
					about Geha</p>
			</div>
		</footer>
		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>



	</div>
</body>
</html>