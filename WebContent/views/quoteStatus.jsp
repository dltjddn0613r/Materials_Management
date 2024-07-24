<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적서 현황</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/9f79df219d.js" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h2 class="mt-5"><b>견적서 현황</b></h2>
		<form action="quoteStatus" method="post"><br>
		
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>구분</b></legend>
    <div class="col-sm-10">
      <div class="form-check">
      	<input type="radio" name="quoteType" value="quoteType"> 내역
		<input type="radio" name="quoteType" value="quoteType"> 집계<br>
		<select name="quoteTypeDropDown" style="width: 800px;">
					<option value="line">일별</option>
					<option value="line">월별</option>
					<option value="line">라인별</option>
					<option value="line">전표별</option>
					<option value="line">품목별</option>
					<option value="line">전표별품목별</option>
					<option value="line">거래처별</option>
					<option value="line">담당자별</option>
		</select><br>
		<span class="badge text-bg-secondary">비교기간</span>
				<input type="radio" name="quoteType" value="quoteType"> 사용안함
				<input type="radio" name="quoteType" value="quoteType"> 전년동일기간
				<input type="radio" name="quoteType" value="quoteType"> 전월동일기간
				<input type="radio" name="quoteType" value="quoteType"> 전주동일기간
				<input type="radio" name="quoteType" value="quoteType"> 전일동일기간<br>
      </div>
    </div>
 	</fieldset>

	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>기준일자</b></legend>
    <div class="col-sm-10">
		<input type="date" class="form-control" id="quoteDate" name="quoteDate" required>
    </div>
 	</fieldset>
	
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>내.외자구분</b></legend>
    <div class="col-sm-10">
		<input type="radio" name="quoteType" value="quoteType"> 전체
		<input type="radio" name="quoteType" value="quoteType"> 내자
		<input type="radio" name="quoteType" value="quoteType"> 외자<br>
    </div>
 	</fieldset>

	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>창고</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="Warehouse" placeholder="창고" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>프로젝트</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="customerCode" placeholder="프로젝트" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>거래처</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="Customers" placeholder="거래처" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>품목코드</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="ItemCode" placeholder="품목코드" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>오더관리번호</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="OrderID" placeholder="오더관리번호" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>담당자</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="PIC" placeholder="담당자" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>거래처관리담당자</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="PICforCustomer" placeholder="거래처관리담당자" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>외화종류</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="ForeignCurrencyType" placeholder="외화종류" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>거래유형</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="TransactionType" placeholder="거래유형" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>새로운 항목 추가</b></legend>
    <div class="col-sm-10">
		<input type="text" class="form-control" id="customerCode" name="TransactionType" placeholder="새로운 항목 추가" required>
    </div>
 	</fieldset>

 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>규격</b></legend>
    <div class="col-sm-10">
		<input type="text" class="form-control" id="customerCode" name="TransactionType" placeholder="규격" required>
    </div>
 	</fieldset>
						
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>수량</b></legend>
    <div class="col-sm-10">
      <div class="form-check">
			<div class="row">
 			 	<div class="col">
    			<input type="text" class="form-control" aria-label="Qty.frist" placeholder="수량">
 			 	</div>
 			 	~
 			 	<div class="col">
  			  	<input type="text" class="form-control" aria-label="Qty.last">
  				</div>
				</div>
      		</div>
    	</div>
 	</fieldset>
 	
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>단가</b></legend>
    <div class="col-sm-10">
      <div class="form-check">
			<div class="row">
 			 	<div class="col">
    			<input type="text" class="form-control" aria-label="Price.frist" placeholder="단가">
 			 	</div>
 			 	~
 			 	<div class="col">
  			  	<input type="text" class="form-control" aria-label="Price.last">
  				</div>
				</div>
      		</div>
    	</div>
 	</fieldset>
 	
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>공급가액</b></legend>
    <div class="col-sm-10">
      <div class="form-check">
			<div class="row">
 			 	<div class="col">
    			<input type="text" class="form-control" aria-label="Amount.frist" placeholder="공급가액">
 			 	</div>
 			 	~
 			 	<div class="col">
  			  	<input type="text" class="form-control" aria-label="Amount.last">
  				</div>
				</div>
      		</div>
    	</div>
 	</fieldset>
 	
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>부가세</b></legend>
    <div class="col-sm-10">
      <div class="form-check">
			<div class="row">
 			 	<div class="col">
    			<input type="text" class="form-control" aria-label="Tax.frist" placeholder="부가세">
 			 	</div>
 			 	~
 			 	<div class="col">
  			  	<input type="text" class="form-control" aria-label="Tax.last">
  				</div>
				</div>
      		</div>
    	</div>
 	</fieldset>
			
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>새로운 항목 추가</b></legend>
    <div class="col-sm-10">
		<input type="text" class="form-control" id="customerCode" name="TransactionType" placeholder="새로운 항목 추가" required>
    </div>
 	</fieldset>
	
	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>진행상태</b></legend>
    <div class="col-sm-10">
      <div class="form-check">
      	<input type="checkbox" name="quotePS_All" value="quotePS"> 전체
      	<input type="checkbox" name="quotePS_e-Approval" value="quotePS"> 결재중
      	<input type="checkbox" name="quotePS_Unconfirmed" value="quotePS"> 미확인
		<input type="checkbox" name="quotePS_Confirmed" value="quotePS"> 확인<br>
			<form class="search-box" action="" method="get" >
				<span class="badge text-bg-secondary">확인-진행상태</span>
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="Confirm-PS" placeholder="확인-진행상태" style="width: 900px;">
			</form>
      </div>
    </div>
 	</fieldset>

 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>최초작성자</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
				<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="Creator" placeholder="최초작성자" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>
 	
 	<fieldset class="row mb-3">
    <legend class="col-form-label col-sm-2 pt-0"><b>최종수정자</b></legend>
    <div class="col-sm-10">
    	<form class="search-box" action="" method="get" >
    			<button class="search-btn" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<input class="search-txt" type="text" name="Last Modifier" placeholder="최종수정자" style="width: 1020px;">
		</form>
    </div>
 	</fieldset>



			<button type="submit" class="btn btn-primary">저장</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
