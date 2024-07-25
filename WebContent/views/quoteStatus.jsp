<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>견적서 현황</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/9f79df219d.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4 text-center"><b>견적서 현황</b></h2>
        <form action="quoteStatus" method="post">
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>구분</b></legend>
                <div class="col-sm-10">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="내역">
                        <label class="form-check-label">내역</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="집계">
                        <label class="form-check-label">집계</label>
                    </div>
                    <select class="form-select my-2" name="quoteTypeDropDown" style="max-width: 800px;">
                        <option value="line">일별</option>
                        <option value="line">월별</option>
                        <option value="line">라인별</option>
                        <option value="line">전표별</option>
                        <option value="line">품목별</option>
                        <option value="line">전표별품목별</option>
                        <option value="line">거래처별</option>
                        <option value="line">담당자별</option>
                    </select>
                    <span class="badge text-bg-secondary">비교기간</span>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="사용안함">
                        <label class="form-check-label">사용안함</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="전년동일기간">
                        <label class="form-check-label">전년동일기간</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="전월동일기간">
                        <label class="form-check-label">전월동일기간</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="전주동일기간">
                        <label class="form-check-label">전주동일기간</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="전일동일기간">
                        <label class="form-check-label">전일동일기간</label>
                    </div>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>기준일자</b></legend>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="quoteDate" name="quoteDate" required>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>내.외자구분</b></legend>
                <div class="col-sm-10">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="전체">
                        <label class="form-check-label">전체</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="내자">
                        <label class="form-check-label">내자</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="quoteType" value="외자">
                        <label class="form-check-label">외자</label>
                    </div>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>창고</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="Warehouse" placeholder="창고">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>프로젝트</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="customerCode" placeholder="프로젝트">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>거래처</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="Customers" placeholder="거래처">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>품목코드</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="ItemCode" placeholder="품목코드">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>오더관리번호</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="OrderID" placeholder="오더관리번호">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>담당자</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="PIC" placeholder="담당자">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>거래처관리담당자</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="PICforCustomer" placeholder="거래처관리담당자">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>외화종류</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="ForeignCurrencyType" placeholder="외화종류">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>거래유형</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="TransactionType" placeholder="거래유형">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>새로운 항목 추가</b></legend>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="NewItem" placeholder="새로운 항목 추가" required>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>규격</b></legend>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="Specification" placeholder="규격" required>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>수량</b></legend>
                <div class="col-sm-10">
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Qty.frist" placeholder="수량">
                        </div>
                        <div class="col text-center">
                            ~
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Qty.last">
                        </div>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>단가</b></legend>
                <div class="col-sm-10">
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Price.frist" placeholder="단가">
                        </div>
                        <div class="col text-center">
                            ~
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Price.last">
                        </div>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>공급가액</b></legend>
                <div class="col-sm-10">
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Amount.frist" placeholder="공급가액">
                        </div>
                        <div class="col text-center">
                            ~
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Amount.last">
                        </div>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>부가세</b></legend>
                <div class="col-sm-10">
                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Tax.frist" placeholder="부가세">
                        </div>
                        <div class="col text-center">
                            ~
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" aria-label="Tax.last">
                        </div>
                    </div>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>진행상태</b></legend>
                <div class="col-sm-10">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="quotePS_All" value="전체">
                        <label class="form-check-label">전체</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="quotePS_e-Approval" value="결재중">
                        <label class="form-check-label">결재중</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="quotePS_Unconfirmed" value="미확인">
                        <label class="form-check-label">미확인</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="quotePS_Confirmed" value="확인">
                        <label class="form-check-label">확인</label>
                    </div>
                    <div class="input-group mt-2">
                        <span class="badge text-bg-secondary me-2">확인-진행상태</span>
                        <input class="form-control" type="text" name="Confirm-PS" placeholder="확인-진행상태">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
        
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>최초작성자</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="Creator" placeholder="최초작성자">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <fieldset class="row mb-4">
                <legend class="col-form-label col-sm-2 pt-0"><b>최종수정자</b></legend>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input class="form-control" type="text" name="LastModifier" placeholder="최종수정자">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </fieldset>
            
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary px-5">저장</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
