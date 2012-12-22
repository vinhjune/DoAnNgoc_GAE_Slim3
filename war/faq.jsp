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
%><!DOCTYPE html>
<!--[if IE]><![endif]-->
<html lang="en">

<head>
<meta charset="utf-8" />
<title>PTIT Tour</title>
<!--<meta http-equiv="X-UA-Compatible" content="IE=7" />-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="Description"
	content="Adventure tours, rafting, diving, bungee jumping, skydiving and cycling worldwide." />
<meta name="Keywords"
	content="Adventure travel, adventure tours, walking tours, bike tours, sightseeing tours, bus tours, city tours, budget travel, backpacking, last minute vacations, hiking, white water rafting, whitewater rafting, river rafting, scuba diving, sky diving, trekking, safaris, water skiing, alpine skiing, kayaking, activity holiday, water activities, outdoor activities, online travel, adventure tours, backpacker activities in Europe, backpacker activities in Asia, backpacker activities in Africa, backpacker activities in Australia, backpacker activities in North America, backpacker activities in South America" />
<meta name="msvalidate.01" content="B062587789B141D9BF3FED9B67A6B3F6" />

<link rel="stylesheet"
	href="/css/global_deployed.css"
	type="text/css" />
<link rel="stylesheet" href="css/tours_deployed.css" type="text/css" />





<link rel="stylesheet" href="css/tours_new.css" type="text/css" />




<!--[if IE 6]><link rel="stylesheet" href="http://scd.hwstatic.com/static/styles/cdn/1.19.3.1/ie6_deployed.css" type="text/css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" href="http://scd.hwstatic.com/static/styles/cdn/1.19.3.1/ie7_deployed.css" type="text/css" media="all"><![endif]-->

<script src="javascripts/datetimepicker_css.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8"
	src="/javascripts/jquery.1.4.2.min.js"></script>
<script src="javascripts/datetimepicker_css.js" type="text/javascript"></script>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-152421-29']);
	_gaq.push(['_trackPageLoadTime']);
	_gaq.push(['_setAllowHash', false]);
	_gaq.push(['_setDomainName', '.hostelworld.com']);

	_gaq.push(['_trackPageview']);

mvt_affiliate = 0;
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
<body class="home">

	<!--/#flags-->
	<div id="login" style="display: none;">
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
				</div>
			</div>
			<!-- #login-form -->
			<div id="pwd-form" class="login-mod" style="display: none;">
				<div class="login-wrap">
					<form
						action="#"
						method="post">
						<fieldset>
							<input id="emailadr" name="email" type="text"
								value="Email Address" autocomplete="off" /> <input
								type="hidden" name="defaultEmailValue" value="Email Address"
								id="defaultEmailValue" /> <input class="login-btn"
								type="submit" value="Send" />
						</fieldset>
					</form>
					<a id="return-to-login" href="#">Return to login form?</a>
				</div>
				<p>Enter the email address you have registered with us..&raquo;</p>
			</div>
			<!-- #pwd-form -->
		</div>
		<!-- #login-panel -->
	</div>
	<!-- #login -->
	<script type="text/javascript">
		
		$(document).ready(function(){


			<!-- Top Rated Accordion -->
			$(".toprated_list").hide();

			$("#toprated1, #toprated2").show();
			$("#toprated_head1, #toprated_head2").addClass("close");

			$(".toprated_head").click(function(){
				$(this).next(".toprated_list").slideToggle(250);
				$(this).toggleClass("close");
			});

			$('.toprated_head a').click(function(e){
				e.stopPropagation();
				return true;
			});


		});
		
		</script>

	<div id="holder">

		<div id="header">
			<div class="inner">
				<a href="index" title="Hostelworld Tours & Activities - Book Online"
					id="logo" class="transparency">hostelworld.com</a>
				<ul class="top transparency">
					<%
						if (loggedin.equals("true")) {
					%>
					<li>Xin chào ${username},</li>
					<%} else {%>
					<li><a href="register" title="Register" id="">Đăng ký</a></li>
					<%}
					%>
					<li>
						<%
							if (loggedin.equals("true")) {
						%> <a href="logout"
						title="Login to My World" id="">Thoát</a> <%
 	} else {
 %> <a href="#" title="Login to My World"
						id="header_login_link">Đăng nhập</a> <%
 	}
 %>
					</li>
				</ul>

				<p class="header-tagline">
					<img src=""
						alt="" />
				</p>



				<ul id="main-nav">
					<li><a href="index" title="Home">Trang chủ<span class="tab"></span></a></li>
					<li><a href="listTours" title="List Tours">Danh sách tours<span
							class="tab"></span></a></li>
					<%
						if (userType.equals("congTy")) {
					%>
					<li class="item53"><a href="addDiaDiem"> <span>Thêm địa điểm</span></a></li>
					<li class="item53"><a href="addTour"><span>Thêm tour Tour</span></a></li>
					<%
						}
					%>
										<%if (loggedin.equals("true")){ %>
					<li><a href="/manageBooking" title="My bookings">Giao dịch của tôi<span class="tab"></span></a></li>
					<%} %>
					<li><a href="/about" title="About">Giới thiệu<span
							class="tab"></span></a></li>
					<li><a href="/faq" title="FAQ">Hỏi & Đáp<span class="tab"></span></a></li>
				</ul>

			</div>
		</div>
		<!-- /header -->

		<div class="background">
			<div class="container">
				<div class="content">
					<div class="pagecontent">

						<div class="pagetop" style="margin-bottom: 105px;">
							<div class="topheading">
								<h1>Thêm yêu Việt Nam mỗi sớm mai thức dậy</h1>
							</div>
							<div class="search-strip">
								<form name="tourSearch" action="timTour" id="tour-search-form">

									<div id="searchTooltip">
										<div id="enterLocation">To view prices and availability,
											please enter a location.</div>
									</div>

									<ul style="margin-top: 5px;">

										<li class="roundback bigdropdownleft">
											<div>
												<select id="diemXP" name="diemXP">
													<option value="">Xuất phát </option>
													<c:forEach var="xp" items="${diaDiem}">
														<option value="${f:h(xp.name)}">${f:h(xp.name)}</option>
													</c:forEach>
												</select>
											</div>
										</li>

										<li class="roundback bigdropdownright">
											<div>
												<select id="diemDich" name="diemDich">
													<option value="">Điểm đích</option>
													<c:forEach var="dich" items="${diaDiem}">
														<option value="${f:h(dich.name)}">${f:h(dich.name)}</option>
													</c:forEach>
												</select>
											</div>
										</li>

									</ul>
									<ul style="margin-top: 5px;">
										<li class="roundback bigdropdownleft">
											<div>
												<select>
													<option value="">Công ty</option>
													<c:forEach var="cty" items="${listCty}">
														<option value="${f:h(cty.username)}">${f:h(cty.username)}</option>
													</c:forEach>
												</select>
											</div>
										</li>
										<li class="roundback bigdropdownright">
											<div>
												<input type="text" id="ngayXP" name="ngayXP" style="width: 180px" value="Ngày khởi hành" onclick="this.value='';"/> <img
													src="images/cal.gif"
													onclick="javascript:NewCssCal('ngayXP','ddMMyyyy','dropdown',false,'24','','future')"
													style="cursor: pointer" />

											</div>
										</li>
										<li class="roundback bigdropdownleft">
											<div>
												<input type="text" id="thoiGian" name="thoiGian" style="width: 200px" value="Thời gian (Ngày)" onclick="this.value='';"/>
											</div>
										</li>
									</ul>
									<ul style="margin-top: 5px;">

										<li class="roundback bigdropdownright">
											<div>
												<input type="text" id="gia" name="gia" style="width: 200px" value="Giá (VNĐ)" onclick="this.value='';"/>
											</div>
										</li>

										

										<li id="datesbutton">
											<div>
												<button id="tour-search-submit" rel="no-follow"
													type="submit" title="Find Tours">Tìm</button>
											</div>
										</li>
										<br style="clear: both;">

									</ul>

								</form>
							</div>
							<br style="clear: both;">

						</div>

						<div id="tours">

							<div class="pageright" style="margin-left: 0; float: left;">

								<div class="best-selling">
									<h2 style="margin-left: 10px; margin-top: 0px;text-align: center">Câu hỏi thường gặp</h2>
										<!-- ten, ctyName, moTa, thoiGian, gia, ngayXP, soLuong, ddXP, ddDich,--> 
		<div class="greybox rounded" style="padding:10px; width:600px;">
   				
						<p><a style="font-size: 12pt; font-weight: bold" href="#1. Tôi phải làm thế nào để sử dụng PTIT Tour?">1. Tôi phải làm thế nào để sử dụng PTIT Tour?</a><br/>
						<a style="font-size: 12pt; font-weight: bold" href="#2. Tôi có phải trả thêm phí dịch vụ nào khi đặt mua tour không?">2. Tôi có phải trả thêm phí dịch vụ nào khi đặt mua tour không?</a><br/>
						<a style="font-size: 12pt; font-weight: bold" href="#3. Tôi muốn quảng cáo cho tour du lịch của công ty tôi, tôi phải làm gì?">3. Tôi muốn quảng cáo cho tour du lịch của công ty tôi, tôi phải làm gì?</a><br/>
						<a style="font-size: 12pt; font-weight: bold" href="#4. Tôi vừa đăng ký mua tour, tôi phải thanh toán thế nào?">4. Tôi vừa đăng ký mua tour, tôi phải thanh toán thế nào?</a><br/></p>
						<br style="clear:both;">
						<br style="clear:both;">
						<p><a style="font-size: 12pt; font-weight: bold" name="1. Tôi phải làm thế nào để sử dụng PTIT Tour?">1. Tôi phải làm thế nào để sử dụng PTIT Tour?</a><br/>
						Bạn có thể sử dụng PTIT Tour để tìm thông tin về các tour du lịch ngay lập tức. Để có thể sử dụng toàn bộ các chức năng của PTIT Tour, trước hết bạn phải tạo một tài khoản (miễn phí) tại PTIT tour.<br/></p>
						<p><a style="font-size: 12pt; font-weight: bold" name="2. Tôi có phải trả thêm phí dịch vụ nào khi đặt mua tour không?">2. Tôi có phải trả thêm phí dịch vụ nào khi đặt mua tour không?</a><br/>
						Các dịch vụ của PTIT Tour hoàn toàn miễn phí cho khách du lịch. Giá tour mà bạn nhìn thấy là giá cuối cùng bạn phải trả.<br/></p>
						<p><a style="font-size: 12pt; font-weight: bold" name="3. Tôi muốn quảng cáo cho tour du lịch của công ty tôi, tôi phải làm gì?">3. Tôi muốn quảng cáo cho tour du lịch của công ty tôi, tôi phải làm gì?</a><br/>
						Bạn phải đăng ký tài khoản công ty du lịch (miễn phí) với chúng tôi. Chúng tôi sẽ liên hệ trực tiếp với các bạn để xác thực thông tin trong tối đa 7 ngày kể từ ngày bạn đăng ký.<br/></p>
						<p><a style="font-size: 12pt; font-weight: bold" name="4. Tôi vừa đăng ký mua tour, tôi phải thanh toán thế nào?">4. Tôi vừa đăng ký mua tour, tôi phải thanh toán thế nào?</a><br/>
						Hiện tại PTIT Tour chỉ giúp bạn giữ chỗ trước. Trong tối đa 7 ngày, bạn phải liên hệ trực tiếp với công ty cung cấp tour để tiến hành thanh toán. Mọi giao dịch giữa khách hàng và công ty du lịch đều được thực hiện trực tiếp không qua trung gian.<br/>
						Trong thời gian tới, PTIT Tour sẽ tiến hành triển khai chức năng thanh toán trực tuyến. Chúng tôi hy vọng bạn sẽ tiếp tục ủng hộ và sử dụng dịch vụ của chúng tôi.<br/></p>
						 
			<br style="clear:both;">
		</div>
		<br style="clear:both;">
								</div>



								<script type="text/javascript">

$(document).ready(function(){

	$('.tour-cat').click(function(){


		$('.best-selling .right').hide();
		$('.best-selling .tour-cat').removeClass('active');

		$(this).next('.right').show();
		$(this).addClass('active');

		return false;

	});

});

</script>

							</div>
							<div id="twocol_left" class="pageleft" style="float: right">
								<div class="mapsearch">
									<h2>Map Search</h2>
									<ul>
										<li class="" id="eu"
											onmouseover="showcontinent('eu'); return false;"><a
											href="http://www.hostelworld.com/hostels/map/europe"
											title="Europe Hostels">Europe</a></li>
										<li>-</li>
										<li class="" id="na"
											onmouseover="showcontinent('na'); return false;"><a
											href="http://www.hostelworld.com/hostels/map/north-america"
											title="North America Hostels">North America</a></li>
										<li>-</li>
										<li class="" id="sa"
											onmouseover="showcontinent('sa'); return false;"><a
											href="http://www.hostelworld.com/hostels/map/south-america"
											title="South America Hostels">South America</a></li>
										<li>-</li>
										<li class="" id="as"
											onmouseover="showcontinent('as'); return false;"><a
											href="http://www.hostelworld.com/hostels/map/asia"
											title="Asia Hostels">Asia</a></li>
										<li>-</li>
										<li class="" id="oc"
											onmouseover="showcontinent('oc'); return false;"><a
											href="http://www.hostelworld.com/hostels/map/oceania"
											title="Oceania Hostels">Oceania</a></li>
										<li>-</li>
										<li class="" id="af"
											onmouseover="showcontinent('af'); return false;"><a
											href="http://www.hostelworld.com/hostels/map/africa"
											title="Africa Hostels">Africa</a></li>
										<br style="clear: both;">
									</ul>
									<div class="worldmap">
										<div id="regions">
											<a href="http://www.hostelworld.com/hostels/map/europe"
												title="Europe Hostels" id="europe"
												onmouseover="showcontinent('eu'); return false;">Europe
												Hostels</a> <a
												href="http://www.hostelworld.com/hostels/map/north-america"
												title="North America Hostels" id="northAmerica"
												onmouseover="showcontinent('na'); return false;">North
												America Hostels</a> <a
												href="http://www.hostelworld.com/hostels/map/south-america"
												title="South America Hostels" id="southAmerica"
												onmouseover="showcontinent('sa'); return false;">South
												America Hostels</a> <a
												href="http://www.hostelworld.com/hostels/map/asia"
												title="Asia Hostels" id="asia"
												onmouseover="showcontinent('as'); return false;">Asia
												Hostels</a> <a
												href="http://www.hostelworld.com/hostels/map/oceania"
												title="Oceania Hostels" id="oceania"
												onmouseover="showcontinent('oc'); return false;">Oceania
												Hostels</a> <a
												href="http://www.hostelworld.com/hostels/map/africa"
												title="Africa Hostels" id="africa"
												onmouseover="showcontinent('af'); return false;">Africa
												Hostels</a>
										</div>
									</div>
								</div>
								<div class="panel-region-separator"></div>
								<div class="topcities">
									<h2>Top Cities in Vietnam</h2>
									<ul>
										<li><span><strong>Per Night</strong></span><strong>City</strong></li>
										<li><span> VND83926.33</span> <a title="Ho Chi Minh "
											href="http://www.hostelworld.com/hostels/Ho-Chi-Minh/Vietnam">Ho
												Chi Minh</a></li>
										<li><span> VND124122.63</span> <a title="Hanoi "
											href="http://www.hostelworld.com/hostels/Hanoi/Vietnam">Hanoi</a>
										</li>
										<li><span> VND88343.51</span> <a title="Hoi An "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Hoi-An/ChosenCountry.Vietnam">Hoi
												An</a></li>
										<li><span> VND100049.02</span> <a title="Nha Trang "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Nha-Trang/ChosenCountry.Vietnam">Nha
												Trang</a></li>
										<li><span> VND41521.45</span> <a title="Hue "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Hue/ChosenCountry.Vietnam">Hue</a>
										</li>
										<li><span> VND136269.86</span> <a title="Sapa "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Sapa/ChosenCountry.Vietnam">Sapa</a>
										</li>
										<li><span> VND77300.57</span> <a title="Ninh Binh "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Ninh-Binh/ChosenCountry.Vietnam">Ninh
												Binh</a></li>
										<li><span> VND287876.40</span> <a title="Phan Thiet "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Phan-Thiet/ChosenCountry.Vietnam">Phan
												Thiet</a></li>
										<li><span> VND386502.85</span> <a title="Can Tho "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Can-Tho/ChosenCountry.Vietnam">Can
												Tho</a></li>
										<li style="border: 0px none;"><span> VND224392.51</span>
											<a title="Da Nang "
											href="http://www.hostelworld.com/findabed.php/ChosenCity.Da-Nang/ChosenCountry.Vietnam">Da
												Nang</a></li>
									</ul>
								</div>
								<div class="panel-region-separator"></div>
								<a 
									href="#"><img alt="Explore Great Britain"
									src="/images/hcm.png"></a>
								


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
							</div>
							<br style="clear: both;"> <br style="clear: both;">

						</div>
						<!-- /tours -->

					</div>
					<!-- /pagecontent -->

				</div>
				<!-- /content -->

			</div>
			<!-- /container -->

		</div>
		<!-- /background -->

	</div>
	<!-- /holder -->


	<div class="footer-corp">
		<p>Copyright © 2012 PTIT Tour By Cao Bao Ngoc. All rights
			reserved.</p>
	</div>

	<a class="feedback-tab" href="/feedback">Please give us your
		feedback</a>

	<script type="text/javascript"
		src="javascripts/translations.en.js"></script>

	<script type="text/javascript"
		src="javascripts/global_deployed.js"></script>
	<script type="text/javascript"
		src="javascripts/tours_deployed.js"></script>

	<script type="text/javascript">
			HwReg.loadRegister({"TourCities":{"":[""],"Argentina":["Buenos Aires","Mendoza","Paran\u00e1","Rosario"],"Armenia":["Yerevan"],"Australia":["Adelaide","Alice Springs","Cairns","Currumbin","Darwin","Melbourne","Mission Beach","Perth","Surfers Paradise","Sydney","Whitsundays"],"Austria":["Salzburg"],"Belarus":["Minsk"],"Belgium":["Bruges"],"Bolivia":["La Paz","Potosi"],"Brazil":["Rio de Janeiro"],"Bulgaria":["Plovdiv","Sofia"],"Cambodia":["Phnom Penh","Siem Reap"],"Canada":["Toronto"],"Chile":["La Serena","Santiago","Valparaiso"],"China":["Beijing","Chengdu","Chongqing","Dalian","Datong","Guangzhou","Guilin","Hangzhou","Harbin","Hohhot","Huangshan","Jinan","Kunming","Lhasa","Qingdao","Shanghai","Suzhou","Urumqi","Xi'an","Xian","Zhangjiajie"],"Colombia":["Bogota"],"Costa Rica":["Cahuita","Drake Bay","Drake Bay Osa","La Fortuna","Playa del Coco Guanacaste","Playas del Coco","Puerto Viejo","Puntarenas","San Jose","Tamarindo"],"Croatia":["Dubrovnik"],"Czech Republic":["Prague"],"Denmark":["Copenhagen"],"Ecuador":["Canoa","Galapagos Islands","Quito","Quito, Ba\u00f1os, Riobamba, Cuenca"],"Egypt":["Alexandria","Aswan","Bahariya Oasis","Cairo","Dahab","Giza","Luxor","Nuweiba","Port Said","Safaga","Sharm El Sheikh","Siwa","Taba","sinai"],"El Salvador":["San Salvador"],"England":["London","Oxford"],"Fiji":["Nadi","Taveuni Island"],"France":["CANNES","Gourdon","Nice","Paris","Saint Tropez"],"Germany":["Berlin","Frankfurt","Munich","Nuremberg"],"Greece":["Athens","Santorini"],"Guatemala":["Panajachel"],"Hungary":["Budapest"],"Iceland":["Reykjavik"],"India":["Agra","Ahmedabad","Alleppey","Bikaner","Chennai","Cochin","Darjeeling","Delhi","Dharamshala","Jaipur","Jaisalmer","Jodhpur","Manali","Mumbai","New Delhi","Shimla","Udaipur"],"Indonesia":["Bali","Kuta"],"Ireland":["Cork","Dublin","Galway","Killarney"],"Israel":["Dead Sea","Jerusalem","eilat"],"Italy":["FIRENZE","Florence","Milan","Pisa","Rimini","Rome","SIENA","Venice","reggio calabria"],"Jamaica":["Ocho Rios"],"Japan":["Mount Fuji"],"Jordan":["Amman","Aqaba","Petra","Wadi Rum"],"Kenya":["Nairobi"],"Laos":["Luang Prabang","Vientiane"],"Malaysia":["Kuala Lumpur"],"Mexico":["Guadalajara","Mexico City"],"Monaco":["MONACO"],"Morocco":["Atlas Mountains","Marrakech"],"Nepal":["Kathmandu","Pokhara"],"Netherlands":["Amsterdam"],"New Zealand":["Auckland","Christchurch","Nelson","Wellington"],"Northern Ireland":["Belfast"],"Panama":["Colon","Panama"],"Peru":["Arequipa","Cusco","Iquitos","Lima","Ollantaytambo","Puerto Maldonado","Puno"],"Poland":["Krakow","Warsaw"],"Portugal":["Lisbon"],"Romania":["Brasov"],"Russia":["Saint Petersburg","St Petersburg"],"Scotland":["Edinburgh","Glasgow"],"South Africa":["Cape Town","Nelspruit","Stellenbosch"],"South Korea":["Jeju Island","Seoul"],"Spain":["Barcelona","Madrid","Seville"],"Sri Lanka":["Colombo","Kandy"],"Taiwan":["Taipei"],"Tanzania":["Arusha"],"Thailand":["Bangkok","Chiang Mai"],"Turkey":["Antalya","Bodrum","Bursa","CANAKKALE","Cappadocia","Fethiye","Istanbul","Izmir","Kusadasi","Marmaris","Olympos","PAMUKKALE","Selcuk"],"USA":["Las Vegas","Los Angeles","New York","San Diego","San Francisco","Washington DC"],"Uruguay":["Montevideo","Punta del Este"],"Vietnam":["DA LAT","Ha Long","Hanoi","Ho Chi Minh","NHA TRANG","Sapa","hue"],"Wales":["Cardiff","London"],"Zambia":["Mfuwe"]}});
		HwReg.set('baseUrl','http://www.hostelworld.com');
	HwReg.set('homepageUrl','http://www.hostelworld.com/');
	HwReg.set('hostelsUrl','http://www.hostelworld.com/hostels');
	HwReg.set('currentBaseUrl','http://www.hostelworld.com');
	HwReg.set('rootCookieDomain','.hostelworld.com');
	HwReg.set('language','en');
	HwReg.set('controller', "tours");
	HwReg.set('action', "index");
	HwReg.set('staticImageURI', 'http://icd.hwstatic.com/static/images/1.19.3.1/');
	HwReg.set('dayNames', ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']);
	HwReg.set('abbrDayNames', ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']);
	HwReg.set('monthNames', ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']);
	HwReg.set('abbrMonthNames', ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']);
</script>





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

	<script type="text/javascript"
		src="javascripts/s_code.js"></script>
	<script language="JavaScript" type="text/javascript">
/* You may give each page an identifying name, server, and channel on the next lines. */
s.channel = 'tours';
s.eVar33 = 'hostelworld.com';
s.eVar34 = 'english site';
s.eVar45 = '-';
s.events = 'event3';
s.pageName = 'tours';
s.prop26 = 'hostelworld.com';
s.prop28 = 'english';
s.prop36 = 'logged out';
s.prop44 = 'tours';
/************* DO NOT ALTER ANYTHING BELOW THIS LINE ! **************/
//Added type checking in case the s_code file is blocked (HW-3228)
if(typeof(s.t) === 'function'){var s_code=s.t();if(s_code)document.write(s_code)}</script>
	<script language="JavaScript" type="text/javascript">
if(navigator.appVersion.indexOf('MSIE')>=0)document.write(unescape('%3C')+'\!-'+'-')
</script>
	<!--/DO NOT REMOVE/-->
	<!-- End SiteCatalyst code version: H.21. -->
	<script type="text/javascript">
$.getScript(
	'http://s7.addthis.com/js/250/addthis_widget.js?async=1#pubid=hostelworld',
	function() {
		addthis.init();
	}
);
</script>

	<!--[if IE 6]>
<script src="http://scd.hwstatic.com/static/js/1.19.3.1/jquery.ifix.js"></script>
<![endif]-->


	<!--

	<script>
		$(function() {
			$('#background-15').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-adventure.jpg)");
			});

			$('#background-3').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-bus.jpg)");
			});

			$('#background-4').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-bike.jpg)");
			});

			$('#background-2').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-adrenaline.jpg)");
			});

			$('#background-5').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-culture.jpg)");
			});

			$('#background-17').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-sightseeing.jpg)");
			});

			$('#background-10').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-walking.jpg)");
			});

			$('#background-11').click(function(){
				$(".container").css("background-image", "url(/static/images/tours/massiveback-watersports.jpg)");
			});

		});


	</script>

-->

</body>
</html>

