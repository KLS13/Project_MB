<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/layout/header.jsp"/>

<link href="https://fonts.googleapis.com/css?family=Cute+Font&display=swap" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<img src="./images/비비.jpg" style="width:300px; height:300px"/>
<h1>후원금액</h1>
<input type="text" name="dona" id="dona" />
<button type="button" id="check_module">후원</button>
<br />
<h2 style="font-family:'Cute Font'">강아지들의 상처를 치유하는 견사랑을 실천해주세요..</h2>
<br />
<script>
$("#check_module").click(function () {
var IMP = window.IMP; 
IMP.init("imp86730542"); 

IMP.request_pay({
pg: 'html5_inicis', 

pay_method: 'phone',

merchant_uid: 'merchant_' + new Date().getTime(),

name: '후원하기',

amount: $('#dona').val(), 

buyer_email: '',
buyer_name: '${sessionScope.loginDto.mName}',
buyer_tel: '',
buyer_addr: '',
buyer_postcode: '',

}, function (rsp) {
console.log(rsp);
if (rsp.success) {
var msg = '결제가 완료되었습니다.';
msg += '고유ID : ' + rsp.imp_uid;
msg += '상점 거래ID : ' + rsp.merchant_uid;
msg += '결제 금액 : ' + rsp.paid_amount;
location.href='/Project_MB/indexPage.me';
} else {
var msg = '결제에 실패하였습니다.';
msg += '에러내용 : ' + rsp.error_msg;
}
alert(msg);
});
});
</script>
<jsp:include page="/layout/footer.jsp"/>