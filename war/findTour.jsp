<%@page pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<% 
String loggedin = session.getAttribute("loggedin").toString();
String username = session.getAttribute("username").toString();
String userType = session.getAttribute("userType").toString();
String date = session.getAttribute("date").toString(); 
%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb"
	dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/constant.css" rel="stylesheet" type="text/css" />
<link href="css/template.css" rel="stylesheet" type="text/css" />
<script src="javascripts/jquery-1.4.1-vsdoc.js" type="text/javascript"></script>
<script src="javascripts/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="javascripts/jquery-impromptu.3.1.min.js"
	type="text/javascript"></script>
<script src="javascripts/MyPrompt.js" type="text/javascript"></script>
<script src="javascripts/datetimepicker_css.js" type="text/javascript"></script>
<link href="MyPrompt.css" rel="stylesheet" type="text/css" />
<title>PTIT Tour - Tim Tour</title>
<script type="text/javascript">
function myFunction()
{
alert("'Outside information of the responser' [[this is not Implemented yet]]");
}
</script>
</head>
<body id="body" class="body">
	<div class="main png">
		<div class="indent">
			<div class="width">
				<div id="top">
					<div id="top-left">
						<div id="top-right">
							<div id="logo" title="Good Start">
								<div class="space">
									<a href="index"> <img src="images/logo.png"
										alt="Good Start" /></a>
								</div>
							</div>
							<div id="search">
								<div class="module-search">
									<div class="search">
										<div class="search-input">
											<input name="searchword" id="mod_search_searchword"
												maxlength="20" alt="Search" class="inputbox" type="text"
												size="20" value="search..."
												onblur="if(this.value=='') this.value='search...';"
												onfocus="if(this.value=='search...') this.value='';" />
										</div>
										<div class="search-button">
											<input type="image" value="Search" class="button"
												src="images/searchButton.gif" />
										</div>
									</div>
									<input type="hidden" name="task" value="search" /> <input
										type="hidden" name="option" value="com_search" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="header">&nbsp;</div>
				<div id="mid">
					<table class="width">
						<tr>
							<td>
								<div class="topmenu-left png"></div>
							</td>
							<td class="module-topmenu">
								<div id="topmenu">
									<ul class="menu-nav">
										<li class="item28"><a href="index"><span>Home</span></a></li>
										<li class="item29"><a href="listTours"><span>List Tours</span></a></li>
										<li class="item18"><a href="findTour"><span>Find Tour</span></a></li>
										<%
										if (userType.equals("congTy")){ %>
											<li class="item30"><a href="addPhuongTien"><span>Add Vehicle</span></a></li>
											<li class="item53"><a href="addDiaDiem"> <span>Add Place</span></a></li>
											<li class="item53"><a href="addTour"><span>Add Tour</span></a></li>
										<%
										} %>
									</ul>
								</div>
								<div id="links">
									<div class="moduletable_menu">
										<ul class="menu">
											<%
											if (loggedin.equals("true")) { %>
											<li>Hello ${username}, </li>
												<li class="item40"><a href="logout"><span>Logout</span></a></li>
											<%
											} else { %>
											<li class="item40"><a href="register"><span>Register</span> </a></li>
											<li class="item38"><a href="login"><span>Login</span> </a></li>
											<%
											} %>
										</ul>
									</div>
								</div>
							</td>
							<td>
								<div class="topmenu-right png"></div>
							</td>
						</tr>
					</table>
				</div>
				<div class="wrapper-top">
					<div class="wrapper-right">
						<div class="wrapper-left">
							<div class="wrapper-bottom">
								<div class="wrapper-top-left">
									<div class="wrapper-top-right">
										<div class="wrapper-bottom-left">
											<div class="wrapper-bottom-right">
												<div class="width">
													<table class="width">
														<tr>
															<td class="content">
																<div class="moduletable" style="width: 100%">
																	<h3>
																		Tim tour <br />
																	</h3>
																	<div
																		style="padding-left: 4px; padding-top: 4px; width: 550px;">
																		${error}
																	</div>
																	<div
																		style="padding-left: 4px; width: 530px; height: 800px">
																		<br /> <br />
																		
	<form method="post" action="timTour">
		<input type="checkbox" id="diemXP_chk" name="diemXP_chk"> Diem XP 
		<select id="diemXP" name="diemXP">
			<option value=""></option>
			<c:forEach var="xp" items="${diaDiem}">
				<option value="${f:h(xp.name)}">${f:h(xp.name)}</option>
			</c:forEach>
		</select>
		<font color="red">${errorDiemXP}</font><br/>
		<input type="checkbox" id="diemDich_chk" name="diemDich_chk"> Diem Dich 
		<select id="diemDich" name="diemDich">
			<option value=""></option>
			<c:forEach var="dich" items="${diaDiem}">
				<option value="${f:h(dich.name)}">${f:h(dich.name)}</option>
			</c:forEach>
		</select><br/>
		
		<input type="checkbox" id="ngayXP_chk" name="ngayXP_chk"> Ngay XP 
		<input type="text" id="ngayXP" name="ngayXP"/>
		<img src="images/cal.gif" onclick="javascript:NewCssCal('ngayXP','ddMMyyyy','dropdown',false,'24','','future')" style="cursor:pointer"/>
		<br/>
		
		<input type="checkbox" id="thoiGian_chk" name="ngayXP_chk"> Thoi gian 
		<input type="text" id="thoiGian" name="thoiGian"/><br/>
		
		<input type="checkbox" id="gia_chk" name="gia_chk"> Gia
		<input type="text" id="gia" name="gia"/><br/>
		
		<input type="checkbox" id="diemXP_chk" name="diemXP_chk"> Cong Ty 
		<select id="cty" name="cty">
			<option value=""></option>
			<c:forEach var="cty" items="${listCty}">
				<option value="${f:h(cty.username)}">${f:h(cty.username)}</option>
			</c:forEach>
		</select><br/>
		
		<input type="submit" value="Tim"/><br/>
	</form>
					</div>

																</div>
																<div class="indent2">
																	<div class="width">
																		<table class="blog" cellpadding="0" cellspacing="0">
																			<tr>
																				<td valign="top">
																					<div>
																						<div class="border-top">
																							<div class="border-left">
																								<div class="border-right">
																									<div class="border-bottom">
																										<div class="corner-top-left">
																											<div class="corner-top-right">
																												<div class="corner-bottom-left">
																													<div class="corner-bottom-right">
																														<div class="width">
																															<div class="title-bg">
																																<table class="contentpaneopen">
																																	<tr>
																																		<td class="contentheading"
																																			width="100%"></td>
																																	</tr>
																																</table>
																															</div>
																															<table class="contentpaneopen">
																																<tr>
																																	<td valign="top" colspan="2"
																																		class="article_indent"></td>
																																</tr>
																															</table>
																														</div>
																													</div>
																												</div>
																											</div>
																										</div>
																									</div>
																								</div>
																							</div>
																						</div>
																						<span class="article_separator">&nbsp;</span>
																					</div>
																					<div></div>
																					<div></div>
																				</td>
																			</tr>
																			<tr>
																				<td valign="top">
																					<table width="100%" cellpadding="0" cellspacing="0">
																						<tr>
																							<td valign="top" width="100%"
																								class="article_column">
																								<div class="border-top">
																									<div class="border-left">
																										<div class="border-right">
																											<div class="border-bottom">
																												<div class="corner-top-left">
																													<div class="corner-top-right">
																														<div class="corner-bottom-left">
																															<div class="corner-bottom-right">
																																<div class="width">
																																	<div class="title-bg">
																																		<table class="contentpaneopen">
																																			<tr>
																																				<td class="contentheading"
																																					width="100%"></td>
																																			</tr>
																																		</table>
																																	</div>
																																	<table class="contentpaneopen">
																																		<tr>
																																			<td valign="top" colspan="2"
																																				class="article_indent">
																																				<p></p>

																																			</td>
																																		</tr>
																																	</table>
																																</div>
																															</div>
																														</div>
																													</div>
																												</div>
																											</div>
																										</div>
																									</div>
																								</div> <span class="article_separator">&nbsp;</span>
																								<div></div>
																								<div></div>
																							</td>
																						</tr>
																					</table>
																				</td>
																			</tr>
																		</table>
																	</div>
																</div>
															</td>
															<td>
																<div class="column-top" id="right">
																	<div class="column-right">
																		<div class="column-left">
																			<div class="column-bottom">
																				<div class="column-top-left">
																					<div class="column-top-right">
																						<div class="column-bottom-left">
																							<div class="column-bottom-right">
																								<div class="width">
																									<div class="module">
																										<div class="first">
																											<div class="sec">
																												<h3>Advertisments</h3>
																												<div class="box-indent">
																													<div class="width">
																														<ul>
																															<li>Reserved for Advertisements</li>
																														</ul>
																													</div>
																												</div>
																											</div>
																										</div>
																									</div>
																								</div>
																							</div>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="footer">
					<div class="space">Copyright © 2012 PTIT Tour By Cao Bao Ngoc. All rights
						reserved.</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>



