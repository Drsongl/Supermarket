<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学校超市管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Offtime.value)){  
   alert("请输入解决时间！"); 
   return false;
   }
   if(isNull(form1.Sno.value)){
   alert("请输入负责员工编号！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">学校超市管理系统</td>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">更新消费者建议状态</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="AdviceUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">意见编码：</td>
                    <td><input name="Ono" type="text" readonly="readonly" id="Ono" value="<s:property value='cnbean.Ono'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">消费者学号：</td>
                    <td><input name="Cno" type="text" class="text2" id="Cno" readonly="readonly" value="<s:property value='cnbean.Cno'/>"></td>
                  </tr>
                  <tr>
                    <td height="60" align="right">建议内容：</td>
                    <td><input name="Oname" type="text" class="text2" id="Oname" readonly="readonly" value="<s:property value='cnbean.Oname'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">提出时间：</td>
                    <td><input name="Ontime" type="text" class="text2" id="Ontime" readonly="readonly" value="<s:property value='cnbean.Ontime'/>"></td>
                  </tr>

                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>负责员工：</td>
                    <td><select name="Sno" id="Sno">
                      <option value="">请选择</option>
                      <s:iterator id="aa" value="list"> <!--here list should be producttreebean-->
                        <option value="${Sno}"> ${Sname}</option>
                      </s:iterator>
                    </select></td>
                  </tr>

                  <tr>
                      <td height="30" align="right"><span style="color:red;">*</span>建议状态：</td>
                      <td><input name="Ostatus" type="text" class="text2" id="Ostatus" readonly="readonly" value="1">1代表完成建议，自动填充</td>
                  </tr>
                  
                
                 
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="确认修改">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
