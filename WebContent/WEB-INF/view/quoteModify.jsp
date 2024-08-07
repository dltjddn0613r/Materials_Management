<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적서 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.5.0/font/bootstrap-icons.min.css">

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

	<div class="main-content">
		<div class="container mt-5">
			<h2 class="mb-4 text-center">
				<b>견적서 수정</b>
			</h2>
			<form action="quoteModify.do" method="post">
				<input type="hidden" name="action" value="modify" />

				<!-- 거래처 코드 -->
				<div class="mb-3">
					<label for="customerCode" class="form-label">거래처 코드</label>
					<div class="input-group">
						<input type="text" class="form-control" id="customerCode"
							name="customerCode" value="${quote.customerCode}" readonly required>
						<!-- 돋보기 버튼으로 customerSearch.jsp로 이동 -->
						<button type="button" class="btn btn-outline-secondary"
							onclick="window.open('customerSearch.do', '_blank', 'width=800,height=600');">
							<i class="bi bi-search"></i>
							<!-- 돋보기 아이콘 -->
						</button>
					</div>
				</div>

				<!-- 담당자 코드 -->
				<div class="mb-3">
					<label for="employeeCode" class="form-label">담당자 코드</label>
					<div class="input-group">
						<input type="text" class="form-control" id="employeeCode"
							name="employeeCode" value="${quote.employeeCode}" readonly required>
						<button type="button" class="btn btn-outline-secondary"
							onclick="window.open('employeeSearch.do', '_blank', 'width=800,height=600');">
							<i class="bi bi-search"></i>
							<!-- 돋보기 아이콘 -->
						</button>
					</div>
				</div>

				<!-- 유효 기간 -->
				<div class="mb-3 row">
					<label for="validityPeriod" class="col-sm-2 col-form-label">유효
						기간</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="validityPeriod"
							name="validityPeriod" value="${quote.validityPeriod}" required />
						<c:if test="${errors.validityPeriod}">
						</c:if>
					</div>
				</div>

				<!-- 견적 금액 합계 -->
				<div class="mb-3 row">
					<label for="totalAmount" class="col-sm-2 col-form-label">견적
						금액 합계</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="totalAmount"
							name="totalAmount" value="${quote.totalAmount}" required />
						<c:if test="${errors.totalAmount}">
						</c:if>
					</div>
				</div>

				<!-- 진행 상태 -->
				<div class="mb-3 row">
					<label for="status" class="col-sm-2 col-form-label">진행 상태</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="status" name="status"
							value="${quote.status}" required />
						<c:if test="${errors.status}">
						</c:if>
					</div>
				</div>

				<!-- 생성한 전표 -->
				<div class="mb-3 row">
					<label for="createdVoucher" class="col-sm-2 col-form-label">생성한
						전표</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="createdVoucher"
							name="createdVoucher" value="${quote.createdVoucher}" required />
						<c:if test="${errors.createdVoucher}">
						</c:if>
					</div>
				</div>

				<!-- 품목 테이블 -->
				<div class="mb-3">
					<label class="form-label"><b>품목 정보</b></label>
					<div class="input-group">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>품목 코드</th>
									<th>품목명</th>
									<th>규격</th>
									<th>수량</th>
									<th>단가</th>
									<th>공급가격</th>
									<th>부가세</th>
									<th>검색</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="text" class="form-control"
										id="productCode" name="productCode" value="${quote.productCode}" readonly></td>
									<td><input type="text" class="form-control"
										id="productName" name="productName" value="${quote.productName}" readonly></td>
									<td><input type="text" class="form-control"
										id="productStandard" name="productStandard" value="${quote.productStandard}" readonly></td>
									<td><input type="number" class="form-control"
										id="quantity" name="quantity" value="${quote.quantity}" min="1" required></td>
									<td><input type="number" class="form-control"
										id="sellingPrice" name="sellingPrice" value="${quote.sellingPrice}" readonly></td>
									<td><input type="number" class="form-control"
										id="supplyAmount" name="supplyAmount" value="${quote.supplyAmount}" readonly></td>
									<td><input type="number" class="form-control" id="vat"
										name="vat" value="${quote.vat}" readonly></td>
									<td>
										<!-- 품목 검색 버튼 -->
										<button type="button" class="btn btn-outline-secondary"
											onclick="window.open('productSearch.do', '_blank', 'width=800,height=600');">
											<i class="bi bi-search"></i>
											<!-- 돋보기 아이콘 -->
										</button>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<!-- 추가된 필드 -->
				<div class="mb-3 row">
					<label for="warehouseCode" class="col-sm-2 col-form-label">출하 창고 코드</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="warehouseCode" name="warehouseCode" value="${quote.warehouseCode}"  />
						<c:if test="${errors.warehouseCode}">
						</c:if>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="transactionTypeCode" class="col-sm-2 col-form-label">거래 유형 코드</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="transactionTypeCode" name="transactionTypeCode" value="${quote.transactionTypeCode}"  />
						<c:if test="${errors.transactionTypeCode}">
						</c:if>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="exchangeRateCode" class="col-sm-2 col-form-label">통화 코드</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="exchangeRateCode" name="exchangeRateCode" value="${quote.exchangeRateCode}"  />
						<c:if test="${errors.exchangeRateCode}">
						</c:if>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="projectCode" class="col-sm-2 col-form-label">프로젝트 코드</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="projectCode" name="projectCode" value="${quote.projectCode}"  />
						<c:if test="${errors.projectCode}">
						</c:if>
					</div>
				</div>

				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary px-5">저장</button>
				</div>
			</form>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		// 단가와 수량에 따라 공급가격 및 부가세를 자동으로 계산하는 스크립트
		document.getElementById('quantity').addEventListener('input',
				calculateTotals);

		function calculateTotals() {
			const unitPrice = parseFloat(document
					.getElementById('sellingPrice').value) || 0;
			const quantity = parseInt(document.getElementById('quantity').value) || 0;
			const supplyAmount = unitPrice * quantity;
			const vat = supplyAmount * 0.1; // 부가세율 10% 가정

			document.getElementById('supplyAmount').value = supplyAmount
					.toLocaleString();
			document.getElementById('vat').value = vat.toLocaleString();
			document.getElementById('totalAmount').value = (supplyAmount + vat)
					.toLocaleString();
		}
	</script>
	<script>
		// 품목 선택 시 부모 창에 값 설정
		function selectProduct(productCode, productName, productStandard,
				sellingPrice) {
			// 품목 정보를 부모 창의 폼 필드에 설정
			window.opener.document.getElementById('productCode').value = productCode;
			window.opener.document.getElementById('productName').value = productName;
			window.opener.document.getElementById('productStandard').value = productStandard;
			window.opener.document.getElementById('sellingPrice').value = sellingPrice;
			window.close(); // 팝업 창 닫기
		}
	</script>
</body>
</html>
