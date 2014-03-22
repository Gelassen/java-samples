<%@ page import="java.util.Iterator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<%--    <link type="text/css" rel="stylesheet" href="style.css" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="hello/js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="hello/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="hello/js/jquery-galleryview-1.0.1/jquery.galleryview-1.0.1-pack.js"></script>
    <script type="text/javascript" src="hello/js/jquery-galleryview-1.0.1/jquery.timers-1.1.2.js"></script>
    <style type="text/css">
        body {
            background: #444;
            color: white;
        }
        #gallery_wrap {
            width: 820px;
            height: 368px;
            padding: 25px;
/*            background: url(img/border.png) top left no-repeat;*/
        }
        a:link,a:visited {
            color: #ddd !important;
            text-decoration: underline;
        }
        a:hover {
            text-decoration: none;
        }
        h3 {
            border-bottom-color: white;
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function(){
            $('#photos').galleryView({
                panel_width: 800,
                panel_height: 300,
                frame_width: 100,
                frame_height: 38,
                transition_speed: 1200,
                background_color: '#222',
                border: 'none',
                easing: 'easeInOutBack',
                pause_on_hover: true,
                nav_theme: 'custom'
            });
        });
    </script>--%>
<title>App store</title>
</head>
<body>
	<h1>Popular</h1>

<%--    <div id="gallery_wrap">
        <div id="photos" class="galleryview">
            <div class="panel">
                <img src="img/01.jpg" />
                <div class="panel-overlay">
                    <h2>Effet du soleil sur le paysage</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/tomharry" target="_blank">tomharry</a>.  View full-size photo <a href="http://www.sxc.hu/photo/158829" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/02.jpg" />
                <div class="panel-overlay">
                    <h2>Eden</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/emsago" target="_blank">emsago</a>.  View full-size photo <a href="http://www.sxc.hu/photo/152865" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/03.jpg" />
                <div class="panel-overlay">
                    <h2>Snail on the Corn</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/baines" target="_blank">baines</a>.  View full-size photo <a href="http://www.sxc.hu/photo/34453" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/04.jpg" />
                <div class="panel-overlay">
                    <h2>Flowers</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/jazza" target="_blank">jazza</a>.  View full-size photo <a href="http://www.sxc.hu/photo/990169" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/06.jpg" />
                <div class="panel-overlay">
                    <h2>Alone Beach 2B</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/sgursozlu" target="_blank">sgursozlu</a>.  View full-size photo <a href="http://www.sxc.hu/photo/738279" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/05.jpg" />
                <div class="panel-overlay">
                    <h2>Sunrise Trees</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/a_glitch" target="_blank">a_glitch</a>.  View full-size photo <a href="http://www.sxc.hu/photo/289581" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/07.jpg" />
                <div class="panel-overlay">
                    <h2>Waterfall</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/thesaint" target="_blank">thesaint</a>.  View full-size photo <a href="http://www.sxc.hu/photo/174331" target="_blank">here</a>.</p>

                </div>
            </div>
            <div class="panel">
                <img src="img/08.jpg" />
                <div class="panel-overlay">
                    <h2>Death Valley</h2>
                    <p>Photo by <a href="http://www.sxc.hu/profile/djkmart" target="_blank">djkmart</a>.  View full-size photo <a href="http://www.sxc.hu/photo/270109" target="_blank">here</a>.</p>

                </div>
            </div>
            <ul class="filmstrip">
                <li><img src="img/frame2-01.jpg" alt="Effet du soleil" title="Effet du soleil" /></li>
                <li><img src="img/frame2-02.jpg" alt="Eden" title="Eden" /></li>
                <li><img src="img/frame2-03.jpg" alt="Snail on the Corn" title="Snail on the Corn" /></li>
                <li><img src="img/frame2-04.jpg" alt="Flowers" title="Flowers" /></li>
                <li><img src="img/frame2-06.jpg" alt="Alone Beach" title="Alone Beach" /></li>
                <li><img src="img/frame2-05.jpg" alt="Sunrise Trees" title="Sunrise Trees" /></li>

                <li><img src="img/frame2-07.jpg" alt="Waterfall" title="Waterfall" /></li>
                <li><img src="img/frame2-08.jpg" alt="Death Valley" title="Death Valley" /></li>
            </ul>
        </div>
    </div>--%>

    <div>

        <table align="center">
            <tr>
                <c:forEach items="${popular}" var="popularApp">
                    <td><a href="/details/${popularApp.id}"><img src="/images/${popularApp.id}" alt="no image"></a></td>
                </c:forEach>
            </tr>
        </table>
            <%--<center><img src="/images/0" alt="no image"></center>--%>
        </p>
    </div>

    <table>
        <tr>
            <td>
                <%--define categories--%>
                <div align="left">
                    <hr width="200" align="left"/>
                    <c:forEach items="${categories}" var="category">
                        <p><a href="/category/${category}">${category}</a></p>
                        <hr width="200" align="left"/>
                    </c:forEach>
                    <a href="/upload">Upload new application</a>
                </div>
            </td>
            <td>
                <%--define app items--%>
                <div width="1300" align="right">
                    <table>
                        <c:forEach items="${applications}" var="application">
                            <tr>
                                <td>
                                    <p><img src="/images/preview/${application.id}" align="left" alt="no image"></p>
                                </td>
                                <td>
                                    <p><a href="/details/${application.id}">${application.name}</a></p>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</body>
</html>
