<%@ page import="com.dataart.training.FeedRow" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.dataart.training.Feed" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.dataart.training.beans.Account" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Rss reader</title>

    <script type="text/javascript">

        function decorate(cb, element, id, link) {
            //alert('run');
            cb = document.getElementById(cb);
            element = document.getElementById(element);
            if (cb.checked) element.style.display = "none";
            else element.style.display = "block";
            updateFeed(id, link);
        }

        function updateFeed(id, link) {
            var xmlReq = new XMLHttpRequest();
            xmlReq.onreadystatechange = getReadyStateHandler(xmlReq, handler);

            xmlReq.open("POST","/updateFeed", true );
            xmlReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlReq.send("?&id=" + id + "&feed=" + link);

        }

        function getReadyStateHandler(req, responseXmlHandler) {

            if (req.readyState == 4) {
                if (req.status == 200) {
                    responseXmlHandler(req.responseXML);
                } else {
                    alert("HTTP error: "+req.status);
                }
            }
        }

        function handler() {

        }

    </script>
</head>
<style type="text/css">
    div.custom {
        width: 300px; /* Ширина слоя */
        /*       border: 4px solid black; *//* Параметры границы */
        margin: 0 auto
    }

    div.main {
        position: relative;
        /*          border: 4px solid black;*/
        margin-left: 20%;
        margin-right: 20%;
        height: 100px;
        /*width: 10px;*/
    }

    div.left {
        /*          border: 4px solid black;*/
        float: left;
        width: 19%;
    }

    div.right {
                  /*border: 4px solid black;*/
        float: right;
        width: 79%;
    }

    div.clear {
        clear: both;
    }
        /*
        body {
            margin: 0px;
        }*/

    div.head {
        position: relative;
        /*       border: 4px solid black;*/
        margin-left: 20%;
        margin-right: 20%;
        height: 20px;
    }

    div.feeds {
        /*position: relative;*/
        /*border: 4px solid black;*/
        /*margin-left: 20%;*/
        float: left;
        width: 19%;
    }

    .viewed {
        color: 	#A9A9A9;
    }

    .button {
        margin: 10px;
    }


</style>
<body>
<%--<h3 class="main"><%=HelloServlet.getMessage()%></h3>  --%>
<jsp:useBean id="account" scope="session" class="com.dataart.training.beans.Account" />
<jsp:useBean id="user" scope="session" class="com.dataart.training.beans.User" />
<jsp:useBean id="state" scope="session" class="com.dataart.training.beans.State" />
<jsp:useBean id="feed" scope="session" class="com.dataart.training.Feed" />


    <p>hello world</p>

<%--<div align="left" class="head">--%>
    <%--<c:set var="currentFeed" value="currentFeed" scope="request"/>--%>
    <%--<c:if test="${empty requestScope.currentFeed}">--%>
        <%--<c:set var="currentFeed" value="${requestScope.currentFeed}" scope="session" />--%>
    <%--</c:if>--%>


    <%--<c:set var="userId" value="${account.userId}"/>--%>
    <%--<c:when test="${userId == '0'}">--%>
        <%--<c:set var="currentFeed" value="${''}" scope="session" />--%>
    <%--</c:when>--%>

    <%--    <%
        HttpSession ses = request.getSession();
        String currentFeed = (String) request.getAttribute("currentFeed");
        if (null != currentFeed) {
            ses.setAttribute("currentFeed", currentFeed);
        }

        Boolean isLogin = (Boolean) request.getAttribute("isLogin");
        int userId = account.getUserId();
        if (userId == 0) {
            ses.setAttribute("currentFeed", "");
    %>--%>


    <%--   <% } else { %>--%>

    <%--<div>--%>
        <%--<a href="/authorization.jsp">Login</a> <a href="/registration.jsp">Registration</a>--%>
    <%--</div>--%>

    <%--<div>--%>

    <%--</div>--%>

    <%--<c:otherwise>--%>
        <%--<div class="left">--%>
            <%--<c:set var="login" value="login" scope="request" />--%>
            <%--<c:if test="${empty login}">--%>
                <%--<c:set var="login" value="${login}" scope="session" />--%>
            <%--</c:if>--%>

            <%--<p>Hello <a href="/logout"><c:out value="login" /></a></p>--%>
            <%--<a href="/addFeed.jsp">Add feed</a> <a href="/deleteFeed.jsp">Remove feed</a>--%>
        <%--</div>--%>
    <%--</c:otherwise>--%>


<%--    <div class="left">
        <%
            String login = (String) request.getAttribute("login");
            if (null != login) {
                ses.setAttribute("login", login);
            }

        %>
        <p>Hello <a href="/logout"><%= ses.getAttribute("login")%></a></p>
        <a href="/addFeed.jsp">Add feed</a> <a href="/deleteFeed.jsp">Remove feed</a>
    </div>--%>
<%--    <% }
    %>--%>

<%--</div>--%>

<%--<div class="clear"></div>--%>

<%--<div >--%>
    <%--<c:when test="${userId != '0'}">--%>
        <%--<div align="left" class="head">--%>
            <%--<form method="post" action="/cache">--%>
                <%--<input type="submit" value="Cache it!" style="margin-top: 10px">--%>
            <%--</form>--%>
        <%--</div>--%>

        <%--<div align="right" class="head">--%>
            <%--<c:if test="${empty currentFeed}">--%>
                <%--<c:set var="currentPage" value="${account.getShowedPage}" />--%>
                <%--<c:when test="${currentFeed != 'all'}">--%>
                    <%--Sorted by: <a href="/rssreader?sort=DESC">newest</a> <a href="/rssreader?sort=ASC">oldest</a>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<c:url var="newer" value="${currentPage}">--%>
                        <%--<c:param name="sort" value="DESC"/>--%>
                    <%--</c:url>--%>
                    <%--<c:url var="older" value="${currentPage}">--%>
                        <%--<c:param name="sort" value="ASC"/>--%>
                    <%--</c:url>--%>
                    <%--Sorted by: <a href="/rssreader/${newer}">newer</a> <a href="/rssreader/${older}">older</a>--%>
                <%--</c:otherwise>--%>
            <%--</c:if>--%>


<%--            <%String feed = (String) request.getAttribute("currentFeed");
                if (null != feed) {
                    int currentPage = account.getShowedPage();
                    if (feed.equals("all")){%>
            Sorted by: <a href="/rssreader?sort=DESC">newest</a> <a href="/rssreader?sort=ASC">oldest</a>
            <%  } else { %>
            Sorted by: <a href="/rssreader/<%=feed.concat("?sort=DESC")%>">newer</a> <a href="/rssreader/<%=feed.concat("?sort=ASC")%>">older</a>
            <%  }
            }%>--%>
        <%--</div>--%>
    <%--</c:when>--%>
<%--</div>--%>


<%--<div align="center" class="main">--%>

    <%--<div id="sources" align="left" class="feeds">--%>
        <%--<c:set var="acc" value="${account}" scope="session"/>--%>
        <%--<c:when test="${empty acc}">--%>
            <%--<c:set var="links" value="${account.links}"/>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
             <%--<c:set var="links" value="${account.links}"/>--%>
        <%--</c:otherwise>--%>
        <%--<c:forEach var="link" items="${links}" varStatus="true">--%>
            <%--<p>--%>
                <%--<a href="/rssreader/${link.value}">${link.key}</a>--%>
            <%--</p>--%>
        <%--</c:forEach>--%>
 <%--       <%
            Account acc = (Account) session.getAttribute("account");
            Map<String, String> links = acc == null ? account.getLinks() : acc.getLinks();
            Iterator i = links.entrySet().iterator();
            for (; i.hasNext();) {
                Map.Entry link = (Map.Entry) i.next();
        %>
        <p>
            <a href="/rssreader/<%=link.getValue()%>"><%=link.getKey()%></a>
        </p>
        <%
            }
        %>--%>

    <%--</div>--%>

    <%--<div id="view-pager" class="right">--%>
        <%--<div id="expanded_feedRow">--%>

            <%--<c:if test="${!empty requestScope.feeds}">--%>
                <%--<c:forEach var="feed" items="${feeds}" varStatus="true">--%>
                    <%--<p>--%>
                        <%--<a href="${feed.link}">${feed.title}</a>--%>
                        <%--<c:set var="id" value="${feed.id}"/>--%>
                        <%--<c:set var="guid" value="${feed.guid}"/>--%>
                        <%--<c:set var="row" value="row_${feed.id}"/>--%>
                        <%--<input--%>
                                <%--type='checkbox'--%>
                                <%--id='${id}'--%>
                                <%--<c:if test="${feed.isViewed}">--%>
                                    <%--checked="checked"--%>
                                <%--</c:if>--%>
                                <%--onclick='decorate("${id}", "${row}", "${id}", "${guid}");'/>--%>
                    <%--</p>--%>
                    <%--<div id='${row}'  >--%>
                        <%--<p>${feed.description}</p>--%>
                        <%--<p><%=new Date(Long.valueOf(feed.getPubDate()))%></p>--%>

                    <%--</div>--%>
                    <%--<script>--%>
                        <%--decorate("${id}", "${row}", "${id}", "${guid}");--%>
                    <%--</script>--%>
                <%--</c:forEach>--%>
            <%--</c:if>--%>
            <%--<c:otherwise>--%>
                <%--<h4>Content is not available ${testBean.secondProperty}</h4>--%>
            <%--</c:otherwise>--%>
            <%--<c:if test="${!empty userId}">--%>
                <%--<div align="center" >--%>
                    <%--<p>--%>
                        <%--<c:if test="${!empty currentFeed}">--%>
                            <%--<c:if test="${currentFeed == 'all'}">--%>
                                <%--<c:if test="${currentPage > '0'}">--%>
                                    <%--<a href="/rssreader?page=${currentPage - '1'}">previous</a>--%>
                                <%--</c:if>--%>
                                <%--${currentPage}--%>
                                <%--<a href="/rssreader?page=${currentPage + '1'}%>">next </a>--%>
                            <%--</c:if>--%>
                            <%--&lt;%&ndash;<c:otherwise>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<c:if test="${currentPage > '0'}" >&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<c:url var="link" value="${currentFeed}">&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<c:param name="page" value="${currentPage-1}"></c:param>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</c:url>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage-1))%>">previous</a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<%if (currentPage > 0) {%><a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage-1))%>">previous</a> <%}%>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<%=currentPage%>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage+1))%>">next</a>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</c:otherwise>&ndash;%&gt;--%>
                        <%--</c:if>--%>
                        <%--<%String link = (String) request.getAttribute("currentFeed");--%>
                            <%--if (null != link) {--%>
                                <%--int currentPage = account.getShowedPage();--%>
                                <%--if (link.equals("all")){%>--%>
                        <%--<%if (currentPage > 0) {%><a href="/rssreader?page=<%=currentPage - 1%>">previous</a> <%}%>--%>
                        <%--<%=currentPage%>--%>
                        <%--<a href="/rssreader?page=<%=currentPage + 1%>">next </a>--%>
                        <%--<%  } else { %>--%>
                        <%--<%if (currentPage > 0) {%><a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage-1))%>">previous</a> <%}%>--%>
                        <%--<%=currentPage%>--%>
                        <%--<a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage+1))%>">next</a>--%>
                        <%--<%  }--%>
                        <%--}%>--%>
                    <%--</p>--%>
                <%--</div>--%>
            <%--</c:if>--%>
<%--            <%
                List<Feed> feeds = (List<Feed>) request.getAttribute("feeds");
                if (feeds != null) {
                    for (Feed feed : feeds) {
            %>

            <p>
                <a href="<%=feed.getLink()%>"><%=feed.getTitle()%></a>

                <%
                    //String currentFeed = (String) request.getAttribute("currentFeed");
                    final int id = feed.getId();
                    final String guid = feed.getGuid();
                    final int checkbox = id;
                    final String row = "row_".concat(String.valueOf(feed.getId()));

                    //if (feed.isViewed()) {
                %>
                <input
                    type='checkbox'
                    id='<%=checkbox%>'
                    <% if (feed.isViewed()) { %>
                    checked="checked"
                    <% } %>
                    onclick='decorate("<%=checkbox%>", "<%=row%>", "<%=id%>", "<%=guid%>");'/>


            </p>
            <div id='<%=row%>'  >
                <p><%=feed.getDescription()%></p>
                <p><%=new Date(Long.valueOf(feed.getPubDate()))%></p>

            </div>
            <script>
                decorate("<%=checkbox%>", "<%="row_".concat(String.valueOf(feed.getId()))%>", "<%=id%>", "<%=guid%>");
            </script>
                <%
                        }
                    } else {
                %>
            <h4>Content is not available ${testBean.secondProperty}</h4>
                <%
                    }
                %>--%>

            <%--<%--%>
                <%--if (userId != 0) { %>--%>
            <%--<div align="center" >--%>
                <%--<p>--%>
                <%--<%String link = (String) request.getAttribute("currentFeed");--%>
                    <%--if (null != link) {--%>
                        <%--int currentPage = account.getShowedPage();--%>
                        <%--if (link.equals("all")){%>--%>
                            <%--<%if (currentPage > 0) {%><a href="/rssreader?page=<%=currentPage - 1%>">previous</a> <%}%>--%>
                            <%--<%=currentPage%>--%>
                            <%--<a href="/rssreader?page=<%=currentPage + 1%>">next </a>--%>
                     <%--<%  } else { %>--%>
                            <%--<%if (currentPage > 0) {%><a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage-1))%>">previous</a> <%}%>--%>
                            <%--<%=currentPage%>--%>
                            <%--<a href="/rssreader/<%=link.concat("?page=" + String.valueOf(currentPage+1))%>">next</a>--%>
                <%--<%  }--%>
                <%--}%>--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--<% }--%>
            <%--%>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class='clear'> </div>--%>

<%--</div>--%>

</body>
</html>