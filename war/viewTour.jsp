<%@page pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% 
String loggedin = session.getAttribute("loggedin").toString();
String username = session.getAttribute("username").toString();
String userType = session.getAttribute("userType").toString();
String date = session.getAttribute("date").toString(); 
String action = "";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PTIT Tour</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta name="Description" content="Online confirmed bookings for backpacker hostels around the world. Hostel reviews, City guides, sightseeing, entertainment and backpacking information for hostels and backpacker tours around the world." />
<meta name="Keywords" content="hostels, backpacking, country name, city name,and other cities in the country, budget accommodation, cheap lodgings, bookings, online bookings, hostel bookings, city guides, vacations, student travel, budget travel, backpacker tours, bus tours, hostelling, youth hostels, Australia, new Zealand, usa, America, Canada, Europe, South America, Africa, adventure travel, backpackers" />

<meta name="robots" content="noodp">

<link type="image/x-icon" href="/images/favicon.ico" rel="shortcut icon" />

<!-- CSS from libraries.xml -->
<link rel="stylesheet" href="/css/global_deployed.css" type="text/css" />
<link rel="stylesheet" href="css/homepage_deployed.css" type="text/css" />


<!--[if IE 6]><link rel="stylesheet" href="http://scd.hwstatic.com/static/styles/cdn/1.19.3.1/ie6_deployed.css" type="text/css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" href="http://scd.hwstatic.com/static/styles/cdn/1.19.3.1/ie7_deployed.css" type="text/css" /><![endif]-->
<!--[if IE]><link rel="stylesheet" href="http://scd.hwstatic.com/static/styles/cdn/1.19.3.1/ie_homepage_deployed.css" type="text/css" /><![endif]-->


	<link rel="canonical" href="http://www.hostelworld.com/" />
	<script type="text/javascript" src="/javascripts/jquery.1.4.2.min.js"></script>
	<script src="javascripts/datetimepicker_css.js" type="text/javascript"></script>
<script type="text/javascript">
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-152421-29']);
_gaq.push(['_trackPageLoadTime']);
_gaq.push(['_setAllowHash', false]);
_gaq.push(['_setDomainName', '.hostelworld.com']);
_gaq.push(['_trackPageview']);
</script>


<!-- Start Visual Website Optimizer Code -->
<![if gte IE 8]>
<script type='text/javascript'>
var _vis_opt_account_id = 4356;
var _vis_opt_protocol = (('https:' == document.location.protocol) ? 'https://' : 'http://');
document.write('<s' + 'cript src="' + _vis_opt_protocol + 'dev.visualwebsiteoptimizer.com/deploy/js_visitor_settings.php?v=1&a='+_vis_opt_account_id+'&url='+encodeURIComponent(document.URL)+'&random='+Math.random()+'" type="text/javascript">' + '<\/s' + 'cript>');
</script>
<script type='text/javascript'>
if(typeof(_vis_opt_settings_loaded) == "boolean") { document.write('<s' + 'cript src="' + _vis_opt_protocol + 'd5phz18u4wuww.cloudfront.net/vis_opt_no_jquery.js" type="text/javascript">' + '<\/s' + 'cript>'); }
// if your site already has jQuery 1.4.2, replace vis_opt.js with vis_opt_no_jquery.js above - JS: replaced
</script>
<script type='text/javascript'>
if(typeof(_vis_opt_settings_loaded) == "boolean" && typeof(_vis_opt_top_initialize) == "function"){ _vis_opt_top_initialize();
vwo_$(document).ready(function() { _vis_opt_bottom_initialize(); }); }
</script>
<![endif]>
<!-- End Visual Website Optimizer Code -->
</head>

<body >
<!--/#flags--><div id="login" style="display: none;">
	<div id="login-panel">
		<div id="login-form" class="login-mod">
			
						<div class="login-wrap">
								 <form action="dangNhap" method="post">
					 <input type="text" name="username" value="username/email address" id="username" autocomplete="off" onclick="this.value='';"/>
					 <input type="password" name="password" value="" id="password" />
					 <input type="hidden" name="redirect_url" value="/" id="redirect_url" />
                     <input type="hidden" name="defaultUsernameValue" value="username/email address" id="defaultUsernameValue" />
					 <input class="login-btn" type="submit" value="Đăng nhập" />
				 </form>
				<a id="forgot-password-link" href="https://vsecure.hostelworld.com/myworld/myaccount/forgottenpassword">Forgot your password?</a>
							</div>
						<p>Already a member? Sign in over here &raquo;</p>
					</div>
		<!-- #login-form -->
		<div id="pwd-form" class="login-mod" style="display: none;">
			<div class="login-wrap">
				<form action="https://vsecure.hostelworld.com/myworld/myaccount/forgottenpassword" method="post">
					<fieldset>
						<input id="emailadr" name="email" type="text" value="Email Address" autocomplete="off" />
                        <input type="hidden" name="defaultEmailValue" value="Email Address" id="defaultEmailValue" />
						<input class="login-btn" type="submit" value="Send" />
					</fieldset>
				</form>
				<a id="return-to-login" href="#">Return to login form?</a> </div>
			<p>Enter the email address you have registered with us..&raquo;</p>
		</div>
		<!-- #pwd-form -->
	</div>
	<!-- #login-panel -->
</div>
<!-- #login -->	<div id="holder">
		<div id="header">
			<div class="inner">
				<a href="/" id="logo" class="transparency" title="Online bookings at Over 27,000 Hostels Worldwide - Over 2 Million Customer Reviews">hostelworld.com</a>
				<ul class="top transparency">
				
					
					<%
											if (loggedin.equals("true")) { %>
											<li><a href="#" title="" id="">Xin chào ${username} /</a> </li><%
											} else {%>
											<li><a href="register" title="Register" id="" >Đăng ký /</a></li>
											<%} %>
					<!--  	    <li><a href="/myworld" title="Travel Network - Manage Bookings" id="header_login_link">My World</a></li> -->

					<li>
					<%
											if (loggedin.equals("true")) { %>
												<a href="logout" title="Login to My World" id="">Thoát</a>
											<%
											} else { %>
											<a href="#" title="Login to My World" id="header_login_link">Đăng nhập</a>
											<%
											} %>
					</li>
				</ul>

	<p class="header-tagline"><img src="" alt="" /></p>

<ul id="main-nav">
	<li><a href="index" title="Home">Trang chủ<span class="tab"></span></a></li>
	<li><a href="listTours" title="List Tours">Danh sách tours<span class="tab"></span></a></li>
	<%
	if (userType.equals("congTy")){ %>
		<li class="item53"><a href="addDiaDiem"> <span>Thêm địa điểm</span></a></li>
		<li class="item53"><a href="addTour"><span>Thêm Tour</span></a></li>
	<%
	} %>
	<%if (loggedin.equals("true")){ %>
	<li><a href="/manageBooking" title="My bookings">Giao dịch của tôi<span class="tab"></span></a></li>
	<%} %>
	<li><a href="/about" title="About">Giới thiệu<span class="tab"></span></a></li>
	<li><a href="/faq" title="FAQ">Hỏi & Đáp<span class="tab"></span></a></li>
	</ul>

</div>
</div>
<!-- /header -->
<div class="background" id="home-wrap">
	<div class="container">
		<div class="content">
			<div class="pagetop">
				<div class="splodge">
<form id="search_home" name="search_home" method="get" action="timTour" autocomplete="off">
	
	
	<div id="searchTooltip"><div id="enterLocation">To view prices and availability, please enter a location.</div><div id="selectPropertyType">Please select a property type.</div></div>

	<ul>
		<li class="roundback bigdropdownleft">
			<div>
				 <select id="diemXP" name="diemXP" style="width: 225px">
					<option value="">Xuất phát</option>
					<c:forEach var="xp" items="${diaDiem}">
						<option value="${f:h(xp.name)}">${f:h(xp.name)}</option>
					</c:forEach>
				</select>
				<font color="red">${errorDiemXP}</font><br/>
			</div>
		</li>
		<li class="roundback bigdropdownright">
			<div>
				<select id="diemDich" name="diemDich" style="width: 225px">
			<option value="">Điểm đích</option>
			<c:forEach var="dich" items="${diaDiem}">
				<option value="${f:h(dich.name)}">${f:h(dich.name)}</option>
			</c:forEach>
		</select>
			</div>
		</li>
		<li class="roundback bigdropdownleft">
			<div>				
				 <select id="cty" name="cty" style="width: 225px">
			<option value="">Công Ty</option>
			<c:forEach var="cty" items="${listCty}">
				<option value="${f:h(cty.username)}">${f:h(cty.username)}</option>
			</c:forEach>
		</select>
			</div>
		</li>
		<li class="roundback bigdropdownright">
			<div>				
				<input type="text" id="ngayXP" name="ngayXP" value="Ngày khởi hành" style="width: 200px" onclick="this.value='';" />
				<img src="images/cal.gif" onclick="javascript:NewCssCal('ngayXP','ddMMyyyy','dropdown',false,'24','','future')" style="cursor:pointer"/>
			</div>
		</li>
		<li class="roundback bigdropdownright">
			<div>
			<input type="text" id="gia" name="gia" value="Giá (VNĐ)" style="width: 225px" onclick="this.value='';"/>
			</div>
		</li>
		<li class="roundback bigdropdownleft">
			<div>
			<input type="text" id="thoiGian" name="thoiGian" style="width: 225px" value="Thời gian (Ngày)" onclick="this.value='';"/>
			</div>
		</li>
	</ul>
	<ul class="searchbutton">
		<li id="datesbutton" style="margin-left:200px">
			<div>
				<button title="Search" type="submit" rel="no-follow" id="find-hostels-btn" tabindex="15">Search</button>
			</div>
		</li>
	</ul>

	<ul id="group_message" class="groupmessage">
		<li>NOTE: 9 or more guests qualifies as a group booking, change the number of guests to return to normal search.</li>
	</ul>

</form>
</div><div class="panel-region-separator"></div><div class="messaging">
                                                	<h1>Hãy cùng chúng tôi<br/>Khám phá Việt Nam</h1>
                                                    <h2>PTIT Tour mang đến cho bạn</h2>
                                                    <ul>
                                                    <li><span>Chất lượng tốt nhất với giá rẻ nhất</span></li>
                                                    <li><span>Những trải nghiệm thú vị nhất</span></li>
                                                    <li><span>Hoàn toàn miễn phí</span></li>
                                                    </ul>
                                                </div> <!-- /messaging -->				<br style="clear:both;" />
			</div>
			<div class="pagecontent" id="main">
				<div class="pageleft" id="twocol_left">
					<a href="#" ><img src="/images/hcm.png" alt="Explore Great Britain" /></a><div class="panel-region-separator"></div>
	
<div class="mapsearch">
	<h2>Map Search</h2>
	<ul>
		<li onmouseover="showcontinent('eu'); return false;" id="eu" class=""><a title="Europe Hostels" href="http://www.hostelworld.com/hostels/map/europe">Europe</a></li>
		<li>-</li>
		<li onmouseover="showcontinent('na'); return false;" id="na" class=""><a title="North America Hostels" href="http://www.hostelworld.com/hostels/map/north-america">North America</a></li>
		<li>-</li>
		<li onmouseover="showcontinent('sa'); return false;" id="sa" class=""><a title="South America Hostels" href="http://www.hostelworld.com/hostels/map/south-america">South America</a></li>
		<li>-</li>
		<li onmouseover="showcontinent('as'); return false;" id="as" class=""><a title="Asia Hostels" href="http://www.hostelworld.com/hostels/map/asia">Asia</a></li>
		<li>-</li>
		<li onmouseover="showcontinent('oc'); return false;" id="oc" class=""><a title="Oceania Hostels" href="http://www.hostelworld.com/hostels/map/oceania">Oceania</a></li>
		<li>-</li>
		<li onmouseover="showcontinent('af'); return false;" id="af" class=""><a title="Africa Hostels" href="http://www.hostelworld.com/hostels/map/africa">Africa</a></li>
		<br style="clear: both;">
	</ul>

	<div class="worldmap">
		<div id="regions">
			<a onmouseover="showcontinent('eu'); return false;" id="europe" title="Europe Hostels" href="http://www.hostelworld.com/hostels/map/europe">Europe Hostels</a>
			<a onmouseover="showcontinent('na'); return false;" id="northAmerica" title="North America Hostels" href="http://www.hostelworld.com/hostels/map/north-america">North America Hostels</a>
			<a onmouseover="showcontinent('sa'); return false;" id="southAmerica" title="South America Hostels" href="http://www.hostelworld.com/hostels/map/south-america">South America Hostels</a>
			<a onmouseover="showcontinent('as'); return false;" id="asia" title="Asia Hostels" href="http://www.hostelworld.com/hostels/map/asia">Asia Hostels</a>
			<a onmouseover="showcontinent('oc'); return false;" id="oceania" title="Oceania Hostels" href="http://www.hostelworld.com/hostels/map/oceania">Oceania Hostels</a>
			<a onmouseover="showcontinent('af'); return false;" id="africa" title="Africa Hostels" href="http://www.hostelworld.com/hostels/map/africa">Africa Hostels</a>
		</div>
	</div>
</div>


<script type="text/javascript">
function showcontinent(continent) {
	$(".worldmap").attr('class', 'worldmap ' + continent);
	$("#eu, #af, #oc, #na, #sa, #as").removeClass("activemap");
	$("#" + continent).addClass("activemap");
}
$(document).ready(function(){
	$('.mapsearch').mouseout(function(){
		$("#eu, #af, #oc, #na, #sa, #as").removeClass("activemap");
		$(".worldmap").attr('class', 'worldmap');
	});
});
</script>
<div class="panel-region-separator"></div>		
			

<div class="panel-region-separator"></div><div class="topcities">
	<h2>Top Cities in Vietnam</h2>
	<ul>
		<li><span><strong>Per Night</strong></span><strong>City</strong></li>
				<li >
									<span> VND83926.33</span>
																<a href="http://www.hostelworld.com/hostels/Ho-Chi-Minh/Vietnam" title="Ho Chi Minh ">Ho Chi Minh</a>
		</li>
				<li >
									<span> VND124122.63</span>
																<a href="http://www.hostelworld.com/hostels/Hanoi/Vietnam" title="Hanoi ">Hanoi</a>
		</li>
				<li >
									<span> VND88343.51</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Hoi-An/ChosenCountry.Vietnam" title="Hoi An ">Hoi An</a>
		</li>
				<li >
									<span> VND100049.02</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Nha-Trang/ChosenCountry.Vietnam" title="Nha Trang ">Nha Trang</a>
		</li>
				<li >
									<span> VND41521.45</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Hue/ChosenCountry.Vietnam" title="Hue ">Hue</a>
		</li>
				<li >
									<span> VND136269.86</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Sapa/ChosenCountry.Vietnam" title="Sapa ">Sapa</a>
		</li>
				<li >
									<span> VND77300.57</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Ninh-Binh/ChosenCountry.Vietnam" title="Ninh Binh ">Ninh Binh</a>
		</li>
				<li >
																<span> VND287876.40</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Phan-Thiet/ChosenCountry.Vietnam" title="Phan Thiet ">Phan Thiet</a>
		</li>
				<li >
																<span> VND386502.85</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Can-Tho/ChosenCountry.Vietnam" title="Can Tho ">Can Tho</a>
		</li>
				<li style="border: 0px none;">
																<span> VND224392.51</span>
																<a href="http://www.hostelworld.com/findabed.php/ChosenCity.Da-Nang/ChosenCountry.Vietnam" title="Da Nang ">Da Nang</a>
		</li>
			</ul>
</div>
<div class="panel-region-separator"></div>			</div>
<div class="pageright" id="onecol_right">
	<h2 style="text-align: center">${f:h(tour.ten)}</h2>
	<!-- 
	<span><a style="float:right;" title="More tours" class="more" href="listTours">Find more tours</a></span>
	 -->
		<!-- ten, ctyName, moTa, thoiGian, gia, ngayXP, soLuong, ddXP, ddDich,--> 
		<div class="greybox rounded" style="padding:10px; width:600px;">
		<%if (userType.equals("khach")) 
					action = "buyTour";%>
			<form action="<%=action%>?key=${f:h(tour.key)}&no=1" method="post">
				<span class="gia rounded">${f:h(tour.gia)} VNĐ</span>
				<table cellpadding="10" cellspacing="0" border-spacing="-1" width="65%" style="border-collapse:separate;border-spacing: 10px;">
				<tr><td>Xuất phát</td>
					<td><a href="viewDiaDiem?dd=${f:h(tour.ddXP)}">${f:h(tour.ddXP)}</a></td>
					<td>Đích đến</td>
					<td><a href="viewDiaDiem?dd=${f:h(tour.ddDich)}">${f:h(tour.ddDich)}</a></td></tr>
				<tr><td>Công ty</td>
					<td><a href="/viewProfile?profile=${f:h(tour.ctyName)}">${f:h(tour.ctyName)}</a></td></tr>
				<tr><td>Ngày khởi hành</td>
					<td><fmt:formatDate value="${tour.ngayXP}" pattern="dd-MM-yyyy" /></td>
					<td>Thời gian</td>
					<td>${f:h(tour.thoiGian)} ngày</td></tr></table>
				<img src="${f:h(tour.bigThumbnailUrl)}"><br/><br/>
				${tour.moTa}<br/>
				<%if (userType.equals("khach")) {%>
				<ul class="searchbutton">
				<li id="muabutton" style="margin-left:200px">
				<div>
				<button id="find-hostels-btn" tabindex="15" rel="no-follow" type="submit" title="Mua">Mua</button>
				</div>
				</li>
				</ul>
				
				<%} %>
			</form>
			<br style="clear:both;">
		</div>
		<br style="clear:both;">
	
</div>
				<br style="clear:both;" />
			</div> <!-- /pagecontent -->
			<br style="clear:both;" />
			        </div> <!-- /content -->
	</div> <!-- /container -->
</div> <!-- /background -->
</div><!-- /footer -->

<div class="footer-corp">
	<p>
		Copyright © 2012 PTIT Tour By Cao Bao
						Ngoc. All rights reserved.</p>
</div>

<a class="feedback-tab" href="/feedback">Please give us your feedback</a>

	<script type="text/javascript" src="/javascripts/translations.en.js"></script>

		<script type="text/javascript" src="/javascripts/global_deployed.js"></script>
	<!-- <script type="text/javascript" src="http://scd.hwstatic.com/static/js/1.19.3.1/homepage_deployed.js"></script> -->

<script type="text/javascript">
		HwReg.set('baseUrl','http://www.hostelworld.com');
	HwReg.set('homepageUrl','http://www.hostelworld.com/');
	HwReg.set('hostelsUrl','http://www.hostelworld.com/hostels');
	HwReg.set('currentBaseUrl','http://www.hostelworld.com');
	HwReg.set('rootCookieDomain','.hostelworld.com');
	HwReg.set('language','en');
	HwReg.set('controller', "");
	HwReg.set('action', "");
	HwReg.set('staticImageURI', 'http://icd.hwstatic.com/static/images/1.19.3.1/');
	HwReg.set('dayNames', ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']);
	HwReg.set('abbrDayNames', ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']);
	HwReg.set('monthNames', ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']);
	HwReg.set('abbrMonthNames', ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']);
</script>



<!-- mediaTagging -->
			<!--
Start of DoubleClick Floodlight Tag: Please do not remove
Activity name of this tag: All Pages
URL of the webpage where the tag is expected to be placed: http://www.hostelworld.com
This tag must be placed between the <body> and </body> tags, as close as possible to the opening tag.
Creation Date: 11/29/2011
-->
<script type="text/javascript">
var axel = Math.random() + "";
var a = axel * 10000000000000;
document.write('<iframe src="http://fls.doubleclick.net/activityi;src=3431726;type=retar564;cat=allpa328;ord=' + a + '?" width="1" height="1" frameborder="0" style="display:none"></iframe>');
</script>
<noscript>
<iframe src="http://fls.doubleclick.net/activityi;src=3431726;type=retar564;cat=allpa328;ord=1?" width="1" height="1" frameborder="0" style="display:none"></iframe>
</noscript>
<!-- End of DoubleClick Floodlight Tag: Please do not remove --> 
	<!-- end mediaTagging -->


<script type="text/javascript">
$(function() {
	var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
});
</script>

<script type="text/javascript">
$(function() {
	var r = escape(document.referrer), rand = Math.random();
	var halb = new Image(), nvtr = new Image();

	nvtr.src = "/s/vtracker.php?T=V&S=HOSTELWORLD&N=" + window.location.host + '&R=' + r + '&rand=' + rand;
	halb.src = "//secure.webresint.com/writrak.php?T=V&S=HOSTELWORLD&ChosenCity=&UserID=&SubID=&ServerName=www.hostelworld.com&Pos=&SO=&M=&N=" + window.location.host + '&R=' + r + '&rand=' + rand;

});
</script>
<!-- SiteCatalyst code version: H.22.
Copyright 1996-2010 Adobe, Inc. All Rights Reserved
More info available at http://www.omniture.com -->

<script type="text/javascript" src="/javascripts/s_code.js"></script>
<script language="JavaScript" type="text/javascript">
/* You may give each page an identifying name, server, and channel on the next lines. */
s.campaign = '';
s.channel = 'booking flow';
s.eVar33 = 'hostelworld.com';
s.eVar34 = 'english site';
s.eVar45 = '-';
s.pageName = 'home page';
s.prop11 = 'www.hostelworld.com';
s.prop26 = 'hostelworld.com';
s.prop28 = 'english';
s.prop36 = 'logged out';
s.prop44 = 'home';
/************* DO NOT ALTER ANYTHING BELOW THIS LINE ! **************/
//Added type checking in case the s_code file is blocked (HW-3228)
if(typeof(s.t) === 'function'){var s_code=s.t();if(s_code)document.write(s_code)}</script>
<script language="JavaScript" type="text/javascript">
if(navigator.appVersion.indexOf('MSIE')>=0)document.write(unescape('%3C')+'\!-'+'-')
</script><!--/DO NOT REMOVE/-->
<!-- End SiteCatalyst code version: H.21. -->
<script language="javascript" type="text/javascript" charset="utf-8" src="/javascripts/jscountriescities-en.js"></script>


		
				
						

		
				


		
				

														<!--***********************
								Load site-wide scripts
								***********************-->
								<script type="text/javascript">
								$(document).ready(function() {

										function handleForgotPassword() {
											// Remove all previous messages
											$('div#pwd-form div.error').remove();

											if ($('form#password-form input[name="email"]').val() == '') {
												// Remove all previous messages
												$('div#pwd-form div.error').remove();
												$('div#pwd-form').prepend('<div class="error">You did not enter your username</div>').hide().fadeIn();

											} else {
												$('form#password-form').submit();
											}
										}


// Have to use the .filter() function because chained class selectors (Eg: form#login-form.ajax) don't work in IE6
$('form.ajax').filter('#password-form').unbind();
$('form.ajax').filter('#password-form').submit(function () {
		handleForgotPassword();
		return false;
		});

});
</script>

<script type="text/javascript">
$(document).ready(function(){
	var googleHtml = '<div style="width:75px; float:right;"><g:plusone size="medium" href="http://www.hostelworld.com"></g:plusone></div>';
	var facebookHtml = '<div style="float:right; width:85px;"><iframe src="http://www.facebook.com/plugins/like.php?href=http%3A%2F%2Fwww.hostelworld.com&send=false&layout=button_count&width=100&show_faces=true&action=like&colorscheme=light&font&height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:100px; height:21px;" allowTransparency="true"></iframe></div>';
	$('#social-tags').html(googleHtml + facebookHtml);
	(function() {
		var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
		po.src = 'https://apis.google.com/js/plusone.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
	})();
});
</script>

</body>
</html>
