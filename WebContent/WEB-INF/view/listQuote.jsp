<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적서 조회</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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
	<div class="accordion-container">
		<div class="accordion" id="accordionPanelsStayOpenExample">
			<!-- 견적서 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#quoteAccordion"
						aria-expanded="true" aria-controls="quoteAccordion">견적서</button>
				</h2>
				<div id="quoteAccordion" class="accordion-collapse collapse show">
					<div class="accordion-body">
						<a href="${pageContext.request.contextPath}/quoteList.do"
							class="clickable-item">견적서 조회</a> <a
							href="${pageContext.request.contextPath}/quoteInput.do"
							class="clickable-item">견적서 입력</a> <a
							href="${pageContext.request.contextPath}/quoteStatus"
							class="clickable-item">견적서 현황</a> <a
							href="${pageContext.request.contextPath}/unorderedStatus"
							class="clickable-item">미주문 현황</a>
					</div>
				</div>
			</div>
			<!-- 주문서 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#orderAccordion"
						aria-expanded="false" aria-controls="orderAccordion">주문서
					</button>
				</h2>
				<div id="orderAccordion" class="accordion-collapse collapse">
					<div class="accordion-body">
						<a href="${pageContext.request.contextPath}/orderView"
							class="clickable-item">주문서 조회</a> <a
							href="${pageContext.request.contextPath}/orderInput"
							class="clickable-item">주문서 입력</a> <a
							href="${pageContext.request.contextPath}/orderStatus"
							class="clickable-item">주문서 현황</a> <a
							href="${pageContext.request.contextPath}/orderShipping"
							class="clickable-item">주문서 출고처리</a> <a
							href="${pageContext.request.contextPath}/unsoldStatus"
							class="clickable-item">미판매현황</a>
					</div>
				</div>
			</div>
			<!-- 판매 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#salesAccordion"
						aria-expanded="false" aria-controls="salesAccordion">판매</button>
				</h2>
				<div id="salesAccordion" class="accordion-collapse collapse">
					<div class="accordion-body">
						<a href="${pageContext.request.contextPath}/salesView"
							class="clickable-item">판매 조회</a> <a
							href="${pageContext.request.contextPath}/salesInput"
							class="clickable-item">판매 입력</a> <a
							href="${pageContext.request.contextPath}/salesInput2"
							class="clickable-item">판매 입력2</a> <a
							href="${pageContext.request.contextPath}/salesPriceChange"
							class="clickable-item">판매단가 일관변경</a> <a
							href="${pageContext.request.contextPath}/salesStatus"
							class="clickable-item">판매 현황</a> <a
							href="${pageContext.request.contextPath}/paymentView"
							class="clickable-item">결제 내역 조회</a> <a
							href="${pageContext.request.contextPath}/paymentComparison"
							class="clickable-item">결제 내역 자료비교</a>
					</div>
				</div>
			</div>
			<!-- 출하지시서 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#shipmentOrderAccordion"
						aria-expanded="false" aria-controls="shipmentOrderAccordion">
						출하지시서</button>
				</h2>
				<div id="shipmentOrderAccordion" class="accordion-collapse collapse">
					<div class="accordion-body">
						<a href="${pageContext.request.contextPath}/shipmentOrderView"
							class="clickable-item">출하지시서 조회</a> <a
							href="${pageContext.request.contextPath}/shipmentOrderInput"
							class="clickable-item">출하지시서 입력</a> <a
							href="${pageContext.request.contextPath}/shipmentOrderStatus"
							class="clickable-item">출하지시서 현황</a>
					</div>
				</div>
			</div>
			<!-- 출하 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#shipmentAccordion"
						aria-expanded="false" aria-controls="shipmentAccordion">
						출하</button>
				</h2>
				<div id="shipmentAccordion" class="accordion-collapse collapse">
					<div class="accordion-body">
						<a href="${pageContext.request.contextPath}/shipmentView"
							class="clickable-item">출하 조회</a> <a
							href="${pageContext.request.contextPath}/shipmentInput"
							class="clickable-item">출하 입력</a> <a
							href="${pageContext.request.contextPath}/shipmentStatus"
							class="clickable-item">출하 현황</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</head>
<body>
	<div class="main-content">
		<h2 class="d-inline">견적서 조회</h2>
		<div class="d-inline">
			<form action="${pageContext.request.contextPath}/quoteSearch.do"
				method="get" class="d-inline">
				<input type="text" class="form-control d-inline" name="searchQuery"
					style="width: 200px;" placeholder="검색창." aria-label="Search">

				<button type="button" class="btn btn-primary"
					onclick="openSearchPopup()">검색</button>

				<script>
    function openSearchPopup() {
        window.open('quoteDetailSearch.do', 'popup', 'width=800,height=600,scrollbars=yes,resizable=yes');
    }
</script>
			</form>
		</div>

		<form id="deleteForm"
			action="${pageContext.request.contextPath}/quoteDelete.do"
			method="post">
			<div class="mt-3">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="checkAll"
								aria-label="전체 선택"></th>
							<th class="text-center">일자-No.</th>
							<th class="text-center">거래처명</th>
							<th class="text-center">담당자명</th>
							<th class="text-center">품목명</th>
							<th class="text-center">유효기간</th>
							<th class="text-center">견적금액합계</th>
							<th class="text-center">진행상태</th>
							<th class="text-center">생성한 전표</th>
							<th class="text-center">인쇄</th>
						</tr>
					</thead>
					<c:if test="${quotePage.hasNoArticles()}">
						<tr>
							<td colspan="10">견적서가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="quote" items="${quotePage.content }">
						<tr>
							<td class="text-center"><input type="checkbox"
								class="rowCheck" name="quote_no" value="${quote.quote_no}"
								aria-label="선택"></td>
							<td><a
								href="${pageContext.request.contextPath}/quoteModify.do?quote_no=${quote.quote_no}">
									<fmt:formatDate value="${quote.quoteDate}"
										pattern="yyyy-MM-dd-${quote.quote_no}" />
							</a></td>
							<td>${quote.customerCode}</td>
							<td>${quote.employeeCode}</td>
							<td>${quote.productCode}</td>
							<td><fmt:formatDate value="${quote.validityPeriod}"
									pattern="yyyy-MM-dd" /></td>
							<td class="text-end">${quote.totalAmount}</td>
							<td class="text-center">${quote.status}</td>
							<td class="text-center">${quote.createdVoucher}</td>
							<td class="text-center"><button class="btn btn-secondary">인쇄</button></td>
						</tr>
					</c:forEach>
					<c:if test="${quotePage.hasArticles()}">
						<tr>
							<td colspan="10"><c:if test="${quotePage.startPage > 5}">
									<a href="quoteList.do?pageNo=${quotePage.startPage - 5}">[이전]</a>
								</c:if> <c:forEach var="pNo" begin="${quotePage.startPage}"
									end="${quotePage.endPage}">
									<a href="quoteList.do?pageNo=${pNo}">[${pNo}]</a>
								</c:forEach> <c:if test="${quotePage.endPage < quotePage.totalPages}">
									<a href="quoteList.do?pageNo=${quotePage.startPage + 5}">[다음]</a>
								</c:if></td>
						</tr>
					</c:if>
				</table>
			</div>

			<div class="text-start">
				<a href="${pageContext.request.contextPath}/quoteInput.do"
					class="btn btn-success">신규</a>
				<!-- 신규 버튼 추가 -->
				<button type="button" class="btn btn-danger"
					onclick="confirmDelete()">삭제</button>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


	<!-- 삭제 확인 및 선택 체크박스 스크립트 -->
	<script>
        document.getElementById('checkAll').addEventListener('click', function() {
            var checkboxes = document.querySelectorAll('.rowCheck');
            for (var checkbox of checkboxes) {
                checkbox.checked = this.checked;
            }
        });

        function confirmDelete() {
            var checkboxes = document.querySelectorAll('.rowCheck:checked');
            if (checkboxes.length === 0) {
                alert('리스트에 선택된 자료가 없습니다.\n체크박스에 체크한 후 다시 시도 바랍니다.');
            } else {
                if (confirm('선택한 전표를 삭제 하겠습니까?')) {
                    document.getElementById('deleteForm').submit();
                }
            }
        }
    </script>


	<!-- 모달 창 -->
	<div class="modal fade" id="searchModal" tabindex="-1"
		aria-labelledby="searchModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="searchModalLabel">상세 검색</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<!-- 상세 검색 폼 -->
					<form id="searchForm"
						action="${pageContext.request.contextPath}/detailedSearch.do"
						method="get">
						<div class="row">
							<!-- 일자 -->
							<div class="col-md-6 mb-3">
								<label for="quoteDate" class="form-label">시작 일자</label> <input
									type="date" class="form-control" id="quoteDate"
									name="startDate">
							</div>
							<div class="col-md-6 mb-3">
								<label for="quoteDate" class="form-label">종료 일자</label> <input
									type="date" class="form-control" id="quoteDate" name="endDate">
							</div>
						</div>
						<div class="row">
							<!-- 거래처명 -->
							<div class="col-md-6 mb-3">
								<label for="customerName" class="form-label">거래처명</label> <input
									type="text" class="form-control" id="customerName"
									name="customerName">
							</div>
							<!-- 담당자명 -->
							<div class="col-md-6 mb-3">
								<label for="employeeName" class="form-label">담당자명</label> <input
									type="text" class="form-control" id="employeeName"
									name="employeeName">
							</div>
						</div>
						<div class="row">
							<!-- 품목명 -->
							<div class="col-md-6 mb-3">
								<label for="productName" class="form-label">품목명</label> <input
									type="text" class="form-control" id="productName"
									name="productName">
							</div>
							<!--     유효기간
                            <div class="col-md-6 mb-3">
                                <label for="validityPeriod" class="form-label">유효기간</label>
                                <input type="text" class="form-control" id="validityPeriod" name="validityPeriod">
                            </div> -->
						</div>
						<div class="row">
							<!-- 견적금액합계 -->
							<div class="col-md-6 mb-3">
								<label for="minTotalAmount" class="form-label">최소 견적금액합계</label>
								<input type="number" class="form-control" id="minTotalAmount"
									name="minTotalAmount" step="0.01" min="0">
							</div>
							<div class="col-md-6 mb-3">
								<label for="maxTotalAmount" class="form-label">최대 견적금액합계</label>
								<input type="number" class="form-control" id="maxTotalAmount"
									name="maxTotalAmount" step="0.01" min="0">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary"
						onclick="document.getElementById('searchForm').submit();">검색</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
