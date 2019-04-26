<%--
  Created by IntelliJ IDEA.
  User: Dung
  Date: 4/21/2019
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Cấu hình thuế</title>
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
                <li>
                    <a href="list-taxes"><i class="fa fa-bar-chart-o"></i>Danh sách thuế</a>
                </li>

                <li class="active-link">
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
                    <h2 class="text-center">QUẢN LÝ CẤU HÌNH THUẾ</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr/>

            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <h5 class="text-center">MỨC CHỊU THUẾ</h5>
                    <table class="table table-striped table-bordered table-hover text-center">
                        <thead>
                        <tr>
                            <th class="text-center">Mức chịu thuế/tháng (triệu VNĐ)</th>
                            <th class="text-center">Thuế suất (%)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Đến 5</td>
                            <td>5</td>
                        </tr>
                        <tr>
                            <td>Trên 5 đến 10</td>
                            <td>10</td>
                        </tr>
                        <tr>
                            <td>Trên 10 đến 18</td>
                            <td>15</td>
                        </tr>
                        <tr>
                            <td>Trên 18 đến 32</td>
                            <td>20</td>
                        </tr>
                        <tr>
                            <td>Trên 32 đến 52</td>
                            <td>25</td>
                        </tr>
                        <tr>
                            <td>Trên 52 đến 80</td>
                            <td>30</td>
                        </tr>
                        <tr>
                            <td>Trên 80</td>
                            <td>35</td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <div class="col-lg-6 col-md-6">
                    <h5 class="text-center">CÁC KHOẢN GIẢM THUẾ</h5>
                    <form class="form-horizontal" action="tax-config" method="POST">
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="gtBanThan">Bản thân (VNĐ):</label>
                            <div class="col-sm-8">
                                <input type="number" min="1000" max="100000000" step="1000" required class="form-control" id="gtBanThan" placeholder="Khoản giảm trừ bản thân" name="banThan" value="${taxConfig.banThan}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="gtPhuThuoc">Phụ thuộc (VNĐ/n):</label>
                            <div class="col-sm-8">
                                <input type="number" min="1000" max="100000000" step="1000" required class="form-control" id="gtPhuThuoc" placeholder="Khoản giảm trừ phụ thuộc" name="phuThuoc" value="${taxConfig.phuThuoc}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="gtTienAn">Tiền ăn (VNĐ):</label>
                            <div class="col-sm-8">
                                <input type="number" min="1000" max="100000000" step="1000" required class="form-control" id="gtTienAn" placeholder="Khoản giảm trừ tiền ăn" name="tienAn" value="${taxConfig.tienAn}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <button type="submit" class="btn btn-primary">Lưu khoản giảm thuế</button>
                            </div>
                        </div>
                    </form>

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


</body>
</html>

