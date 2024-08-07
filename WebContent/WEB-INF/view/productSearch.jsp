<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* 기본 레이아웃 스타일 */
body {
	display: flex; /* Flexbox를 사용하여 레이아웃 구성 */
	min-height: 100vh; /* 최소 높이를 화면 전체로 설정 */
	margin: 0; /* 기본 여백 제거 */
}

.accordion-container {
	width: 250px; /* 사이드바 너비 설정 */
	background-color: #f8f9fa; /* 배경색 설정 */
	padding: 10px; /* 여백 추가 */
	position: fixed; /* 고정 위치 설정 */
	height: 100%; /* 화면 높이에 맞춤 */
	overflow-y: auto; /* 세로 스크롤 추가 */
}

.main-content {
	margin-left: 250px; /* 사이드바 너비만큼 여백 추가 */
	padding: 20px; /* 여백 추가 */
	width: calc(100% - 250px); /* 사이드바를 제외한 너비 설정 */
}

.clickable-item {
	display: block; /* 블록 레벨 요소로 설정 */
	padding: 10px; /* 여백 추가 */
	margin-bottom: 5px; /* 하단 여백 추가 */
	background-color: #e9ecef; /* 배경색 설정 */
	border: 1px solid #dee2e6; /* 테두리 설정 */
	border-radius: 5px; /* 모서리 둥글게 */
	text-decoration: none; /* 링크 기본 스타일 제거 */
	color: #000; /* 텍스트 색상 설정 */
}

.clickable-item:hover {
	background-color: #d8d8d8; /* 호버 시 배경색 변경 */
}
</style>

</head>
<body>
	<div class="container mt-5">
			<h2 class="mb-4 text-center">
			<b>품목 검색</b>
		</h2>
		<div class="d-flex justify-content-center mb-3">
			<form action="productSearch.do" method="get" class="d-inline">
				<input type="text" class="form-control d-inline" name="searchQuery"
					style="width: 200px;" placeholder="검색창." aria-label="Search"
					value="${searchQuery}">
				<button type="submit" class="btn btn-primary">검색</button>
			</form>
		</div>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>품목 코드</th>
					<th>품목명 [규격명]</th>
				</tr>
			</thead>

			<tbody>
				<!-- 품목 리스트 -->
				<c:forEach var="product" items="${productPage.content}">
					<tr>
						<td><a href="#"
							onclick="selectProduct('${product.productCode}', '${product.productName}', '${product.standard}', '${product.sellingPrice}')">
								${product.productCode} </a></td>
						<td>${product.productName}[${product.standard}]</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="10"><c:if test="${productPage.startPage > 5}">
							<a href="productSearch.do?pageNo=${productPage.startPage - 5}">[이전]</a>
						</c:if> <c:forEach var="pNo" begin="${productPage.startPage}"
							end="${productPage.endPage}">
							<a href="productSearch.do?pageNo=${pNo}">[${pNo}]</a>
						</c:forEach> <c:if test="${productPage.endPage < productPage.totalPages}">
							<a href="productSearch.do?pageNo=${productPage.startPage + 5}">[다음]</a>
						</c:if></td>
				</tr>

			</tbody>
		</table>

		<div class="text-start">
			<a href="addProduct.do" class="btn btn-success">신규</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		// 부모 창의 필드를 업데이트하고 창을 닫는 함수
		function selectProduct(productCode, productName, productStandard,
				sellingPrice) {
			// 부모 창의 품목 코드 필드에 선택한 코드 값을 설정
			window.opener.document.getElementById('productCode').value = productCode;
			window.opener.document.getElementById('productName').value = productName;
			window.opener.document.getElementById('productStandard').value = productStandard;
			window.opener.document.getElementById('sellingPrice').value = sellingPrice;
			window.close(); // 현재 창 닫기
		}
	</script>
</body>
</html>
