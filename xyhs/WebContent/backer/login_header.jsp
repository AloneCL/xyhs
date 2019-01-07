<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div class="top center">
		<div class="left fl">
			<ul>
				<li><a href="${pageContext.request.contextPath }/mainGoods.action" target="_blank">商城首页</a></li>
				<li>|</li>
				<li><a href="">MIUI</a></li>
				<li>|</li>
				<li><a href="">米聊</a></li>
				<li>|</li>
				<li><a href="">游戏</a></li>
				<li>|</li>
				<li><a href="">多看阅读</a></li>
				<li>|</li>
				<li><a href="">云服务</a></li>
				<li>|</li>
				<li><a href="">金融</a></li>
				<li>|</li>
				<li><a href="">小米商城移动版</a></li>
				<li>|</li>
				<li><a href="">问题反馈</a></li>
				<li>|</li>
				<li><a href="">Select Region</a></li>
			</ul>
		</div>

		<div class="right fr topbar-info">
			<div class="gouwuche fr">
				<a href="">购物车</a>
			</div>
			<div class="fr">

				<span id="userspan" class="user"> <a rel="nofollow"
					class="user-name" href="https://my.mi.com/portal" target="_blank">
						<span class="name">${cookie.userName.value }</span> <i
						class="iconfont"></i>
				</a>
					<ul class="user-menu">
						<li><a rel="nofollow" href="${pageContext.request.contextPath}/userInfo.action"
							target="_blank">个人中心</a></li>
						<li><a rel="nofollow"
							href="https://order.mi.com/user/comment" target="_blank">评价晒单</a>
						</li>
						<li><a rel="nofollow"
							href="https://order.mi.com/user/favorite" target="_blank">我的喜欢</a>
						</li>
						<li><a rel="nofollow" href="https://account.xiaomi.com/"
							target="_blank">小米账户</a></li>
						<li><a rel="nofollow" href="${pageContext.request.contextPath}/logOut.action">退出登录</a></li>
					</ul>
				</span> <span class="message"> <a rel="nofollow"
					data-href="//order.mi.com/message/list" class="link link-order"
					data-login="true">消息通知 <i class="J_miMessageTotal"></i>
				</a>
				</span> <a rel="nofollow" class="link link-order"
					href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value }" target="_blank">我的订单</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</header>
<div class="banner_x center">
	<a href="${pageContext.request.contextPath }/mainGoods.action" target="_blank"><div class="logo fl"></div></a>
	<a href=""><div class="ad_top fl"></div></a>
	<div class="nav fl">
		<ul>
			<li><a href="">小电器</a></li>
			<li><a href="">书籍</a></li>
			<li><a href="">小书桌</a></li>
			<li><a href="">实用小工具</a></li>
			<li><a href="">服装</a></li>
			<li><a href="">复习资料/笔记</a></li>
			<li><a href="">洗漱品</a></li>
			<li><a href="">服务</a></li>
			<li><a href="">社区</a></li>
		</ul>
	</div>
	<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
</div>
