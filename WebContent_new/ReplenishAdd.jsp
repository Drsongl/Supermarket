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
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Sno.value)){  
   alert("需要填入员工学号！"); 
   return false;
   }
   if(isNull(form1.Sname.value)){
   alert("需要填入员工姓名！");
   return false;
   }
   if(isNull(form1.Sgrade.value)){
   alert("需要选择员工年级！");
   return false;
   }
   if(isNull(form1.Sjob.value)){
   alert("需要选择员工职位！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加员工</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="WorkerAddSave.action" onSubmit="return mycheck()" >
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="33%" height="30" align="right">&nbsp;</td>
                      <td width="67%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td height="30" align="right"><span style="color:red;">*</span>供应商名称：</td>
                      <td><select name="Prono" id="Prono">
                          <option value="">请选择</option>
                          <s:iterator id="aa" value="list1">
                          <option value="${Prono}">${Proname}</option>
                          </s:iterator>
                          </select>
                      </td>
                    </tr>
                    <tr>
                        <td height="30" align="right"><span style="color:red;">*</span>商品名称：</td>
                        <td><select name="Pno" id="Pno">
                            <option value="">请选择</option>
                            <s:iterator id="aa" value="list2">
                            <option value="${Pno}">${Pname}</option>
                            </s:iterator>
                            </select>
                        </td>
                      </tr>
                    <tr>
                        <td height="30" align="right"><span style="color:red;">*</span>进货数量：</td>
                        <td><input name="Inum" type="text" class="text2" id="Inum"></td>
                    </tr>
                    <tr>
                        <td height="30" align="right"><span style="color:red;">*</span>进货价：</td>
                        <td><input name="Grossprice" type="text" class="text2" id="Grossprice"></td>
                    </tr>
                    
                    <tr>
                      <td height="30" align="right"><span style="color:red;">*</span>进货负责员工：</td>
                      <td><input name="Sno" type="text" class="text2" id="Sno"></td>
                    </tr>
                
                    <tr>
                      <td height="30" align="right"><span style="color:red;">*</span>进货日期：</td>
                      <td><input name="Idate" type="text" class="text2" id="Idate"></td>
                    </tr>
                    <tr>
                      <td height="30">&nbsp;</td>
                      <td><input type="submit" name="button" id="button" value="添加商品">
                        &nbsp;&nbsp;
                        <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                    </tr>
                  </table>
                </form>
              </td>
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
