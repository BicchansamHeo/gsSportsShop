<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="ico/favicon.png">
        <title>Invent - Responsive Multi-Purpose Theme</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="plugins/prettyPhoto/css/prettyPhoto.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/ui.totop.css" rel="stylesheet">
        <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
        <link href="css/extralayers.css" rel="stylesheet">
        <link href="plugins/rs-plugin/css/settings.css" rel="stylesheet">
        <!-- Font Awesome  -->
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <!-- Custom Stylesheet For This Template -->
        <link href="css/stylesheet.css" rel="stylesheet">
        <link href="css/skins.css" rel="stylesheet">
        <!-- Google Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Raleway:400,900,800,700,600,500,300,200,100" rel="stylesheet" type="text/css">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.min.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="wide color-skin-1 color-pattern-1">
        <div id="page" class="hfeed site">
            <header id="masthead" class="site-header" role="banner">
                <nav class="navbar navbar-default navbar-static-top" role="navigation">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="index.html">
                                <img alt="Brand" src="img/logo-dark.png">
                            </a>
                        </div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse navbar-ex1-collapse">
                            <span class="search-toggle visible-lg-block"><i class="fa fa-search"></i></span>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="index.html">Home</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Features <i class="fa fa-angle-double-down"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="elements.html">UI Elements</a></li>
                                        <li><a href="buttons.html">Buttons</a></li>

                                        <li><a href="pricing.html">Pricing Tables: 3 Columns</a></li>
                                        <li><a href="pricing2.html">Pricing Tables: Alternative</a></li>
                                        <li><a href="pricing3.html">Pricing Tables: 4 Columns</a></li>
                                        <li><a href="icons.html">Icons</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-double-down"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">About Us</a></li>
                                        <li><a href="services.html">Services</a></li>
                                        <li><a href="team.html">Our Team: 3 Columns</a></li>
                                        <li><a href="team2.html">Our Team: Alternative</a></li>
                                        <li><a href="faqs.html">FAQs</a></li>
                                        <li><a href="error.html">Error 404</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown active">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <i class="fa fa-angle-double-down"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="portfolio-2.html">Portfolio: 2 Columns</a></li>
                                        <li class="active"><a href="portfolio-3.html">Portfolio: 3 Columns</a></li>
                                        <li><a href="portfolio-4.html">Portfolio: 4 Columns</a></li>
                                        <li><a href="portfolio-item.html">Portfolio: Single Item</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <i class="fa fa-angle-double-down"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="blog.html">Blog: Left Sidebar</a></li>
                                        <li><a href="blog2.html">Blog: Right Sidebar</a></li>
                                        <li><a href="blog3.html">Blog: 3 Columns</a></li>
                                        <li><a href="blog4.html">Blog: 2 Columns</a></li>
                                        <li><a href="post.html">Post: Left Sidebar</a></li>
                                        <li><a href="post2.html">Post: Right Sidebar</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Contact <i class="fa fa-angle-double-down"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="contact.html">Contact: Default</a></li>
                                        <li><a href="contact2.html">Contact: Alternative</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <!-- /.nav -->
                        </div>
                        <!-- /.navbar-collapse -->
                    </div>
                    <!-- /.container -->
                </nav>
                <!-- /.navbar -->
            </header>
            <!-- /#masthead -->
            <header id="header-search-box" class="search-box-wrapper">
                <div class="container">
                    <div class="search-box">
                        <button type="button" class="close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <form role="form">
                            <div class="input-group">
                                <span class="input-group-btn">
                                    <button class="btn btn-default btn-lg" type="button"><i class="fa fa-search"></i></button>
                                </span>
                                <input type="text" class="form-control input-lg" placeholder="Search">
                            </div>
                        </form>
                    </div>
                </div>
            </header>
            <!-- /#header-search-box -->
            <header class="archive-header">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <h4 class="archive-title">Portfolio: 3 Columns</h4>
                        </div>
                        <!-- /.col-sm-6 -->
                        <div class="col-xs-6 hidden-xs">
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Portfolio</a></li>
                                <li class="active">Portfolio: 3 Columns</li>
                            </ol>
                        </div>
                        <!-- /.col-xs-6 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container -->
            </header>
            <!-- /.archive-header -->
            <div id="main" class="wrapper" >
                <div class="container">
                    <section class="portfolio-filter section type2">
                        <ul class="nav nav-pills">
                            <li class="active"><a href="#" data-filter="*">All</a></li>
                            <li><a href="#" data-filter=".artwork">Artwork</a></li>
                            <li><a href="#" data-filter=".creative">Creative</a></li>
                            <li><a href="#" data-filter=".nature">Nature</a></li>
                            <li><a href="#" data-filter=".outside">Outside</a></li>
                            <li><a href="#" data-filter=".photography">Photography</a></li>
                        </ul>
                    </section>
                    <!-- /.portfolio-filter -->
                    <section class="portfolio section type3">
                        <div class="row">
                            <div class="portfolio-container" style="margin-right: -1px;">
                            <c:forEach var="list" items="${ConferenceList}" varStatus="status">
                           		 <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img1.jpg" class="img-responsive" alt="1st Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img1.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">${list.confName}	</a></h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                                
                                 <!-- /.portfolio-item-wrapper -->
                                <!-- <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper nature outside">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img2.jpg" class="img-responsive" alt="2nd Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img2.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Eu decore iisque sit.</a></h5>
                                        </div>
                                    </div>
                                </div> -->
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper photography artwork">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img3.jpg" class="img-responsive" alt="3rd Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img3.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Illum dolorum accommodare.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper creative nature">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img4.jpg" class="img-responsive" alt="4th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img4.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Eu aeque nusquam mea, ne est.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper nature">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img5.jpg" class="img-responsive" alt="5th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img5.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Mei no modo vitae mentitum.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img6.jpg" class="img-responsive" alt="6th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img6.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Ludus periculis mediocritatem.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper nature outside">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img7.jpg" class="img-responsive" alt="7th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img7.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">An vidit mucius animal eam.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper photography artwork">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img8.jpg" class="img-responsive" alt="8th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img8.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Vis nibh zril pertinacia no.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper creative nature">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img9.jpg" class="img-responsive" alt="9th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img9.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Ex veniam philosophia nam.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper nature">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img10.jpg" class="img-responsive" alt="10th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img10.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Facer volumus ei his.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img11.jpg" class="img-responsive" alt="11th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img11.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Nam timeam noluisse ad.</a></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portfolio-item-wrapper -->
                                <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper nature outside">
                                    <div class="portfolio-item type2">
                                        <div class="portfolio-thumb">
                                            <img src="img/general/img12.jpg" class="img-responsive" alt="12th Portfolio Thumb">
                                            <div class="image-overlay"></div>
                                            <a href="img/general/img12.jpg" data-rel="prettyPhoto[pp_gal]" class="portfolio-zoom"><i class="fa fa-eye"></i></a>
                                            <a href="portfolio-item-1.html" class="portfolio-link"><i class="fa fa-link"></i></a>
                                        </div>
                                        <div class="portfolio-details">
                                            <div class="portfolio-meta">
                                                <span class="portfolio-date"><i class="fa fa-clock-o"></i> <a href="#">&nbsp; 21 August, 2014</a></span>
                                                <span class="portfolio-likes"><i class="fa fa-heart-o"></i> <a href="#">&nbsp; 17</a></span>
                                            </div>
                                            <h5 class="portfolio-title"><a href="">Ea animal facilisi patrioque pri.</a></h5>
                                        </div>
                                    </div>
                                </div>-
                                <!-- /.portfolio-item-wrapper -->
                            </div>
                            <!-- /.portfolio-container -->
                        </div>
                        <!-- /.row -->
                    </section>
                    <!-- /.portfolio -->
                </div>
            </div>
            <!-- /#main -->
            <footer id="colophon" class="site-footer" role="contentinfo">
                <div id="supplementary">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3">
                                <aside class="widget widget-about">
                                    <img class="brand" alt="Brand" src="img/logo-white.png" width="145">
                                    <p>Lorem ipsum dolor sit amet, no consequat ullamcorper nec, te commune constituto intellegebat eam. Soleat populo id nec. Est in altera vocibus, et vim iudico adolescens, mel no discere mediocritatem.</p>
                                </aside>
                                <!-- /.widget-about -->
                                <aside class="widget widget-social">
                                    <h5 class="widget-title">Stay Connected</h5>
                                    <ul class="social-links">
                                        <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a class="google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
                                        <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a class="pinterest" href="#"><i class="fa fa-pinterest"></i></a></li>
                                        <li><a class="rss" href="#"><i class="fa fa-rss"></i></a></li>
                                    </ul>
                                </aside>
                                <!-- /.widget-social -->
                            </div>
                            <!-- /.col-md-3 -->
                            <div class="col-md-3">
                                <aside class="widget widget-posts">
                                    <div class="subpage-title">
                                        <h5>Recent Posts</h5>
                                    </div>
                                    <ul class="recent-posts">
                                        <li>
                                            <img src="img/recent-posts/img1.jpg" alt="Post Image">
                                            <h5>
                                                <a href="post-1.html">The Ultimate Guide to Adjustment Layers – Vibrance</a>
                                                <small><i class="fa fa-clock-o"></i> 20 August, 2013</small>
                                            </h5>
                                        </li>
                                        <li>
                                            <img src="img/recent-posts/img2.jpg" alt="Post Image">
                                            <h5>
                                                <a href="post-1.html">Complete Guide to What’s New in Adobe Photoshop 14.1</a>
                                                <small><i class="fa fa-clock-o"></i> 15 August, 2013</small>
                                            </h5>
                                        </li>
                                        <li>
                                            <img src="img/recent-posts/img3.jpg" alt="Post Image">
                                            <h5>
                                                <a href="post-1.html">How to Integrate Lightroom Into Your Photoshop Workflow</a>
                                                <small><i class="fa fa-clock-o"></i> 10 August, 2013</small>
                                            </h5>
                                        </li>
                                    </ul>
                                </aside>
                                <!-- /.widget-posts -->
                            </div>
                            <!-- /.col-md-3 -->
                            <div class="col-md-3">
                                <aside class="widget widget-tagcloud">
                                    <div class="subpage-title">
                                        <h5>Tags</h5>
                                    </div>
                                    <ul class="tag-links">
                                        <li><a href="#">photoshop</a></li>
                                        <li><a href="#">html</a></li>
                                        <li><a href="#">css</a></li>
                                        <li><a href="#">html5</a></li>
                                        <li><a href="#">css3</a> </li>
                                        <li><a href="#">illustration</a></li>
                                        <li><a href="#">javascript</a></li>
                                        <li><a href="#">jquery</a></li>
                                        <li><a href="#">bootstrap 2</a></li>
                                        <li><a href="#">bootstrap 3</a></li>
                                        <li><a href="#">php</a></li>
                                        <li><a href="#">mysql</a></li>
                                        <li><a href="#">wordpress</a></li>
                                        <li><a href="#">ajax</a></li>
                                        <li><a href="#">webmatrix</a></li>
                                    </ul>
                                </aside>
                                <!-- /.widget-tagcloud -->
                            </div>
                            <!-- /.col-md-3 -->
                            <div class="col-md-3">
                                <aside class="widget widget-flickr">
                                    <div class="subpage-title">
                                        <h5>Flickr Photos</h5>
                                    </div>
                                    <ul class="flickr-photos-list"></ul>
                                </aside>
                                <!-- /.widget-flickr -->
                            </div>
                            <!-- /.col-md-3 -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container -->
                </div>
                <!-- /#supplementary -->
                <div id="site-info">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-6">
                                <div class="footer-info-wrapper">
                                    <span>Emphatic. © 2014. All Rights Reserved. v1.0.0 currently!</span>
                                </div>
                            </div>
                            <!-- /.footer-info-wrapper -->
                            <div class="col-xs-12 col-sm-6">
                                <div class="footer-links-wrapper">
                                    <ul class="list-inline">
                                        <li><a href="#">Privacy Policy</a></li>
                                        <li><a href="#">Terms Of Service</a></li>
                                        <li><a href="#">Disclaimer</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- /.footer-links-wrapper -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container -->
                </div>
                <!-- /.site-footer -->
            </footer>
            <!-- /#site-info -->
        </div>
        <!-- /#page -->
        <div class="skin-chooser-wrap visible-lg-block">
            <span class="skin-chooser-toggle"><i class="fa fa-cog"></i></span>
            <section class="section">
                <h4>Style Switcher</h4>
            </section>
            <section class="section">
                <h6>Layout Options</h6>
                <p>Which layout option you want to use?</p>
                <p><a id="boxed" class="btn adv-default squre btn-xs" href="#" role="button">Boxed</a><em>&nbsp; or &nbsp;</em><a id="wide" class="btn adv-primary squre btn-xs" href="#" role="button">Wide</a></p>
            </section>
            <section class="section">
                <h6>Color Schemes</h6>
                <p>Which theme color you want to use? Here are some predefined colors.</p>
                <ul class="list-inline">
                    <li id="color-skin-1" class="color-skin active"></li>
                    <li id="color-skin-2" class="color-skin"></li>
                    <li id="color-skin-3" class="color-skin"></li>
                    <li id="color-skin-4" class="color-skin"></li>
                    <li id="color-skin-5" class="color-skin"></li>
                </ul>
            </section>
            <section class="section">
                <h6>Patterns</h6>
                <p>You can choose between four patterns.</p>
                <ul class="list-inline">
                    <li id="color-pattern-1" class="color-pattern active"></li>
                    <li id="color-pattern-2" class="color-pattern"></li>
                    <li id="color-pattern-3" class="color-pattern"></li>
                    <li id="color-pattern-4" class="color-pattern"></li>
                    <li id="color-pattern-5" class="color-pattern"></li>
                </ul>
            </section>
        </div>
        <!-- Bootstrap JS & Others JavaScript Plugins -->
        <!-- Placed At The End Of The Document So Page Loads Faster -->
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/jquery-migrate-1.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
        <script src="plugins/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
        <script src="plugins/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
        <script src="plugins/prettyPhoto/js/jquery.prettyPhoto.js"></script>
        <script src="js/jquery.carouFredSel-6.2.1-packed.js"></script>
        <script src="js/jflickrfeed.min.js"></script>
        <script src="js/easing.js"></script>
        <script src="js/jquery.ui.totop.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/jquery.fitvids.js"></script>
        <!-- Custom Script For This Template -->
        <script src="js/script.js"></script>
    </body>
</html>