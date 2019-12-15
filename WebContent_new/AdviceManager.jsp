<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生超市管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">学生超市管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">消费者建议管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="AdviceManager.action">
                  <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="22%" height="30" style="padding-left:20px;"> 功能导航： </td>
                      <td width="78%">查询：
                        <select name="SearchRow" id="SearchRow">
                    
                          <option value="Ostatus">处理状态</option>
                          <option value="Sno">负责员工编号</option>
                          <option value="Cno">消费者学号</option>
                         
                        </select>
                        <input name="SearchKey" type="text" class="text1" id="SearchKey">
                        <input type="submit" name="button" id="button" value="点击查询"></td>
                    </tr>
                  </table>
                </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>建议编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>消费者学号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>建议内容</strong></td>
                    <td bgcolor="#D5E4F4"><strong>建议时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>解决时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>建议状态</strong></td>
                    <td bgcolor="#D5E4F4"><strong>负责员工编号</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Ono}</td>
                      <td align="center">${Cno}</td>
                      <td align="center">${Oname}</td>
                      <td align="center">${Ontime}</td>
                      <td align="center">${Offtime}</td>
                      <td align="center">${Ostate}</td>
                      <td align="center">${Sno}</td>
                      
                      <td align="center"><a href="AdviceUpdate.action?Ono=${Ono}">更新状态</a> </td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
