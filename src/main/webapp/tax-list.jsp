<%--
  Created by IntelliJ IDEA.
  User: Dung
  Date: 4/21/2019
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Danh sách thuế</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet"/>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>


<div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="adjust-nav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="assets/img/logo.png"/>
                </a>
            </div>

            <span class="logout-spn">
                  <a href="#" style="color:#fff;">LOGOUT</a>

                </span>
        </div>
    </div>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li class="active-link">
                    <a href="list-taxes"><i class="fa fa-bar-chart-o"></i>Danh sách thuế</a>
                </li>

                <li>
                    <a href="tax-config"><i class="fa fa-edit"></i>Cấu hình thuế </a>
                </li>
            </ul>
        </div>

    </nav>
    <!-- /. NAV SIDE  -->

    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="text-center">DANH SÁCH THUẾ</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr/>
            <div class="row">
                <div class="col-md-12">
                    <div class="text-center">
                        <form action="list-taxes" method="post">
                            Lọc kết quả theo:

                            <select name="select-year" style="height: 36px;">

                                <c:forEach items="${years}" var="year">
                                    <option value="${year}" ${ (year == cyear) ? 'selected' : '' }>${year}</option>
                                </c:forEach>

                            </select>

                            <select name="select-month" style="height: 36px;">

                                <c:forEach begin="1" end="12" var="month">

                                    <option value="${month}" ${ (month == cmonth) ? 'selected' : '' }>Tháng ${month}</option>

                                </c:forEach>
<%--                                --%>
<%--                                <option value="1">Tháng 1</option>--%>
<%--                                <option value="2">Tháng 2</option>--%>
<%--                                <option value="3">Tháng 3</option>--%>
<%--                                <option value="4">Tháng 4</option>--%>
<%--                                <option value="5">Tháng 5</option>--%>
<%--                                <option value="6">Tháng 6</option>--%>
<%--                                <option value="7">Tháng 7</option>--%>
<%--                                <option value="8">Tháng 8</option>--%>
<%--                                <option value="9">Tháng 9</option>--%>
<%--                                <option value="10">Tháng 10</option>--%>
<%--                                <option value="11">Tháng 11</option>--%>
<%--                                <option value="12">Tháng 12</option>--%>

                            </select>
                            <input type="submit" value="Đồng ý"/>
<%--                            <button type="submit" class="btn-primary">Đồng ý</button>--%>
                        </form>
                    </div>
                </div>
            </div>

            <hr/>

            <c:if test="${userTaxes == null}">

                <div class="row">
                    <div class="col-lg-12 col-md-12">
                        <p class="text-center">Không có dữ liệu, vui lòng thử lại!</p>
                    </div>
                </div>

            </c:if>
            <c:if test="${userTaxes != null}">

                <div class="row">
                    <div class="col-lg-12 col-md-12">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th rowspan="2">#</th>
                                <th rowspan="2">Họ tên</th>
                                <th rowspan="2">Chức vụ</th>
                                <th rowspan="2">MST</th>
                                <th rowspan="2">Lương</th>
                                <th colspan="4" class="text-center">Khoản giảm trừ</th>
                                <th rowspan="2">Thuế phải nộp</th>
                            </tr>
                            <tr>
                                <th>Bản thân</th>
                                <th>Tiền ăn</th>
                                <th>Người PT</th>
                                <th>Giảm trừ PT</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="count" value="1" scope="page"></c:set>
                            <c:forEach items="${userTaxes}" var="ut">
                                <tr>
                                    <td>${count }</td>
                                    <td>${ut.hoTen}</td>
                                    <td>${ut.chucVu}</td>
                                    <td>${ut.mst}</td>
                                    <td><fmt:formatNumber type="number" pattern="###,###" value="${ut.luong}"></fmt:formatNumber></td>
                                    <td><fmt:formatNumber type="number" pattern="###,###" value="${ut.giamTruBanThan}"></fmt:formatNumber></td>
                                    <td><fmt:formatNumber type="number" pattern="###,###" value="${ut.tienAn}"></fmt:formatNumber></td>
                                    <td>${ut.soNguoiPhuThuoc}</td>
                                    <td><fmt:formatNumber type="number" pattern="###,###" value="${ut.giamTruPhuThuoc}"></fmt:formatNumber></td>
                                    <td><fmt:formatNumber type="number" pattern="###,###" value="${ut.thuePhaiNop}"></fmt:formatNumber></td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page"></c:set>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>

            </c:if>

            <div class="row">
                <div class="col-md-12 text-center">
                    <a href="export?cmd=all${cyear != null? '&year=':''}${cyear!=null ? cyear : ''}${cmonth != null? '&month=':''}${cmonth!=null? cmonth :''}"><button type="button" class="btn btn-primary">Xuất báo cáo</button></a>
                    <a href="export?cmd=top${cyear != null? '&year=':''}${cyear!=null ? cyear : ''}${cmonth != null? '&month=':''}${cmonth!=null? cmonth :''}"><button type="button" class="btn btn-warning">5 người nộp thuế cao nhất</button></a>
                </div>
            </div>

            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<div class="footer">


    <div class="row">
        <div class="col-lg-12">
            &copy; 2014 yourdomain.com | Design by: <a href="http://binarytheme.com" style="color:#fff;"
                                                       target="_blank">www.binarytheme.com</a>
        </div>
    </div>
</div>


<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assets/js/custom.js"></script>

<!-- Tooltip -->
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

</body>
</html>

