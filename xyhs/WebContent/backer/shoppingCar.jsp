<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style2.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>
	<jsp:include page="/backer/login_header.jsp"></jsp:include>
	<div class="banner_x center">
		<div class="wdgwc fl ml40">我的购物车</div>
		<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
		<div class="clear"></div>
	</div>
	<div class="xiantiao"></div>
	<div class="gwcxqbj">
		<div class="gwcxd center">
			<div class="top2 center">
				<div class="sub_top fl">
					<input type="checkbox" value="quanxuan" class="quanxuan" id="selectAll" onclick="checkAll()"/>全选
				</div>
				<div class="sub_top fl">商品名称</div>
				<div class="sub_top fl">单价</div>
				<div class="sub_top fl">数量</div>
				<div class="sub_top fl">小计</div>
				<div class="sub_top fr">操作</div>
				<div class="clear"></div>
			</div>
			<table>
			<c:forEach items="${goodList}" var="cargood">
			<c:forEach items="${cargood.goods }" var="goods">
				<div class="content2 center">
                     
					<div class="sub_content fl ">
						<input type="text" value="${goods.price}" hidden>
						<input type="checkbox" value="quanxuan" class="quanxuan" name="checkboxBtn"/>
					 </div>
					<div class="sub_content fl">
						<img src="${goods.goodsImg }" width="80" height="80">
					</div>
					<div class="sub_content fl ft20">${goods.goodsName }</div>
					<div class="sub_content fl ">${goods.price }元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="${cargood.goodsNum  }" step="1" min="1" onchange="change(this)">
					</div>
					<div class="sub_content fl"><span>${goods.price*cargood.goodsNum }元</span></div>
					<div class="sub_content fl">
					    <input type="text" value="${goods.goodsId }" hidden>
						<a href="javascript:" onclick="deleteGoods(this)">×</a>
					</div>
					<div class="clear"></div>

				</div>
				</c:forEach>
			</c:forEach>
			<tr align="center" valign="top" style="font-size: 14px;">
				<td colspan="11">共<span style="color: red;">${totalPage}</span>页&nbsp;共<span style="color: red;">${total}</span>有条记录&nbsp;当前是第<span style="color: red;">${currentPage}</span>页&nbsp;
					<c:choose>
						<c:when test="${currentPage != 1 }">
							<a style="color: #00F;" onmouseout="this.style.color='#00F'"
								onmousemove="this.style.color='#F00'"
								href="${pageContext.request.contextPath}/showShoppingCar.action?userId=${cookie.userId.value }&page=${currentPage-1}">上一页</a>
						</c:when>
						<c:otherwise>
						            上一页
						        </c:otherwise>
					</c:choose> &nbsp; <c:choose>
						<c:when test="${currentPage != totalPage }">
							<a style="color: #00F;" onmouseout="this.style.color='#00F'"
								onmousemove="this.style.color='#F00'"
								href="${pageContext.request.contextPath}/showShoppingCar.action?userId=${cookie.userId.value }&page=${currentPage+1}">下一页</a>
						</c:when>
						<c:otherwise>
							   下一页 
							</c:otherwise>
					</c:choose>&nbsp;
				</td>
			</tr>
			</table>
		</div>
		<div class="jiesuandan mt20 center">
			<div class="tishi fl ml20">
				<ul>
					<li><a
						href="${pageContext.request.contextPath }/mainGoods.action">继续购物</a></li>
					<li>|</li>
					<li>共<span>${total }</span>件商品，已选择<span id="gNum">0</span>件
					</li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="jiesuan fr">
				<div class="jiesuanjiage fl">
					合计（不含运费）：<span id="priceSum">0元</span>
				</div>
				<div class="jsanniu fr">
					<input class="jsan" type="submit" name="jiesuan" value="去结算" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<jsp:include page="/backer/footer.jsp"></jsp:include>
	<script type="text/javascript">
	    $("input[name='checkboxBtn']").click(function() {
		var selectAll=document.getElementById('selectAll');
		
		/* var priceSum = parseInt($("#priceSum").text());
		var goodsSum = parseInt($("#gNum").text());
		 if(selectAll.checked){
			 $("#priceSum").text((priceSum - parseInt($(this).prev().val()))+"元");
		 }else{
			 $("#priceSum").text((priceSum + parseInt($(this).prev().val()))+"元");
		 } */
		var all = $("input[name='checkboxBtn']").length;
		var select = $("input[name='checkboxBtn']:checked").length;
		if(all == select) {
		selectAll.checked=true;
		} else if(select == 0) {
		selectAll.checked=false;
		} else {
		selectAll.checked=false;
		}
		compute();
		});

		function checkAll() {
		var selectAll=document.getElementById('selectAll');
		var checkboxs=document.getElementsByName('checkboxBtn');
		var priceSum = 0;
		var num = 1;
		  for(var i=0;i<checkboxs.length;i++)
		  {   
			
		      checkboxs[i].checked=selectAll.checked;
		      num = parseInt($(checkboxs[i]).parent().next().next().next().next().children().val());
		      $(checkboxs[i]).parent().next().next().next().next().next().children().text($(checkboxs[i]).prev().val()*num+"元");
		      priceSum = priceSum + parseInt($(checkboxs[i]).prev().val()*num);
		  }
		 if(selectAll.checked){
			 $("#gNum").text(checkboxs.length);
			 $("#priceSum").text(priceSum+"元");
		 }else{
			 $("#gNum").text(0);
			 $("#priceSum").text(0+"元");
		 }
		  
		}
		
		function compute(){
			var checkboxs=document.getElementsByName('checkboxBtn');
			var pSum = 0;
			var nSum = 0;
			var num = 1;
			  for(var i=0;i<checkboxs.length;i++)
			  {
			      if(checkboxs[i].checked){
				    num = parseInt($(checkboxs[i]).parent().next().next().next().next().children().val());
				    pSum += parseInt($(checkboxs[i]).prev().val()*num);
				    $(checkboxs[i]).parent().next().next().next().next().next().children().text($(checkboxs[i]).prev().val()*num+"元");
				    nSum++;
					}
			  }
			 $("#gNum").text(nSum);
			 $("#priceSum").text(pSum+"元");
		}
		
		function change(obj){
			var price = parseInt($(obj).parent().prev().text());
			var num = parseInt($(obj).val());
			$(obj).parent().next().text(price*num+ "元");
		}

	   
		function deleteGoods(obj) {
			var id = $(obj).prev().val();
			layer.confirm('确定要移除该商品吗？', {
				  
				  btn: ['确定','取消'] //按钮
				}, function(){
					 $.ajax({
						 type: 'POST',
						 url:"${pageContext.request.contextPath }/deleteGoodsForCar.action",
						 data: {
							 id:id
						 },
						 success:function(data){
							 if(data=="success"){
								 $(obj).parent().parent().remove();
						 		layer.msg('成功移除', {icon: 1,time:1000});
							 }else if(data=="fail"){
								 layer.msg('移除失败',{icon:2,time:1000});
							 }
						 }
					 }) 
				  
				})
		}
	</script>
</body>
</html>