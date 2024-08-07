<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적서 입력</title>
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

/* 추가적인 스타일링 */
.form-row {
	display: flex;
	justify-content: space-between;
	margin-bottom: 1rem;
}

.form-group {
	flex-basis: 48%;
}
</style>

</head>
<body>

	<div class="main-content">
		<div class="container mt-5">
			<h2 class="mb-4 text-center">
				<b>견적서 입력</b>
			</h2>
			<form action="quoteInput.do" method="post">
				<input type="hidden" name="action" value="insert" />

				<!-- 일자 및 거래처 행 -->
				<div class="form-row">
					<div class="form-group">
						<label for="quoteDate" class="form-label">일자</label> <input
							type="date" class="form-control" id="quoteDate" name="quoteDate"
							required>
						<c:if test="${errors.quoteDate}">
						</c:if>
					</div>
					<div class="form-group">
						<label for="customerCode" class="form-label">거래처</label>
						<div class="input-group">
							<input type="text" class="form-control" id="customerCode"
								name="customerCode" readonly required>
							<button type="button" class="btn btn-outline-secondary"
								onclick="window.open('customerSearch.do', '_blank', 'width=800,height=600');">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</div>
				</div>

				<!-- 담당자 및 출하창고 행 -->
				<div class="form-row">
					<div class="form-group">
						<label for="employeeCode" class="form-label">담당자</label>
						<div class="input-group">
							<input type="text" class="form-control" id="employeeCode"
								name="employeeCode" readonly required>
							<button type="button" class="btn btn-outline-secondary"
								onclick="window.open('employeeSearch.do', '_blank', 'width=800,height=600');">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</div>
					<div class="form-group">
						<label for="warehouseCode" class="form-label">출하창고</label> <select
							class="form-control" id="warehouseCode" name="warehouseCode">
							<option value="">선택</option>
							<option value="WH001">창고1</option>
							<option value="WH002">창고2</option>
						</select>
					</div>
				</div>

				<!-- 거래유형 및 통화 행 -->
				<div class="form-row">
					<div class="form-group">
						<label for="transactionTypeCode" class="form-label">거래유형</label> <select
							class="form-control" id="transactionTypeCode"
							name="transactionTypeCode">
							<option value="">선택</option>
							<option value="TT001">부가세 적용</option>
							<option value="TT002">부가세 미적용</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exchangeRateCode" class="form-label">통화</label>
						
						
						
						 <select
							class="form-control" id="exchangeRateCode"
							name="exchangeRateCode">
							<option value="">선택</option>
							<option value="USD">미국 달러</option>
							<option value="KRW">한국 원화</option>
						</select>
					</div>
				</div>

				<!-- <div class="form-group">
						<label for="employeeCode" class="form-label">담당자</label>
						<div class="input-group">
							<input type="text" class="form-control" id="employeeCode"
								name="employeeCode" readonly required>
							<button type="button" class="btn btn-outline-secondary"
								onclick="window.open('employeeSearch.do', '_blank', 'width=800,height=600');">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</div> -->

				<!-- 프로젝트 및 유효 기간 행 -->
				<div class="form-row">
					<div class="form-group">
						<label for="projectCode" class="form-label">프로젝트</label>
						<div class="input-group">
							<input type="text" class="form-control" id="projectCode"
								name="projectCode" readonly>
							<button type="button" class="btn btn-outline-secondary"
								onclick="window.open('projectSearch.do', '_blank', 'width=800,height=600');">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</div>
					<div class="form-group">
						<label for="validityPeriod" class="form-label">유효 기간</label> <input
							type="date" class="form-control" id="validityPeriod"
							name="validityPeriod" value="${quoteInput.validityPeriod}" />
						<c:if test="${errors.validityPeriod}">
							<div class="alert alert-danger mt-2">유효 기간은 필수 입력 항목입니다.</div>
						</c:if>
					</div>
				</div>

				<!-- 견적 금액 합계 -->
				<div class="mb-3 row">
					<label for="totalAmount" class="col-sm-2 col-form-label">견적
						금액 합계</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="totalAmount"
							name="totalAmount" value="${quoteInput.totalAmount}" readonly
							required />
						<c:if test="${errors.totalAmount}">
							<div class="alert alert-danger mt-2">유효한 견적 금액을 입력해 주세요.</div>
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
										id="productCode" name="productCode" readonly></td>
									<td><input type="text" class="form-control"
										id="productName" name="productName" readonly></td>
									<td><input type="text" class="form-control"
										id="productStandard" name="productStandard" readonly></td>
									<td><input type="number" class="form-control"
										id="quantity" name="quantity" min="1" required></td>
									<td><input type="number" class="form-control"
										id="sellingPrice" name="sellingPrice" readonly></td>
									<td><input type="number" class="form-control"
										id="supplyAmount" name="supplyAmount" readonly></td>
									<td><input type="number" class="form-control" id="vat"
										name="vat" readonly></td>
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
			const supplyAmount = parseFloat((unitPrice * quantity).toFixed(2)); // 소수점 2자리까지
			const vat = parseFloat((supplyAmount * 0.1).toFixed(2)); // 부가세율 10%, 소수점 2자리까지

			document.getElementById('supplyAmount').value = supplyAmount;
			document.getElementById('vat').value = vat;
			document.getElementById('totalAmount').value = (supplyAmount + vat);
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
