<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<table style = "width:155; border:0; cellspacing:0; cellpadding:0;">
            <tr>
              <td height="31" align="center" background="Images/left1.jpg"><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table style = "width:150; border:0; cellspacing:0; cellpadding:0;">
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="Index.jsp">首页</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%if(session.getAttribute("type").toString().equals("1")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ProductManager.action">商品信息管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="WorkerManager.action">员工信息管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StorageManager.action">商品库存管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="AdviceWorker.action">消费者意见管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="SaleManager.action">销量管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ReplenishManager.action">进货信息管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <%}%>




                <%if(session.getAttribute("type").toString().equals("2")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ProductWorker.action">商品信息管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StorageWorker.action">商品库存管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="AdviceStudent.action">消费者意见管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="SaleManager.action">销量管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ReplenishWorker.action">进货信息管理</a></td>
                </tr>
                <tr>
                    <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                  </tr>
                <%}%>


                
                <%if(session.getAttribute("type").toString().equals("3")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="Advice.action">消费者建议</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ProductWorker.action">商品信息</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ConsumerLog.action">个人消费记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="rank.action">销售榜</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                

                <%}%>

                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="PersonalUpdate.action">用户信息更改</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>