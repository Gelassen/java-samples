package com.dataart.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RssParser {

    private final static Logger logger = LoggerFactory.getLogger(RssParser.class);

    private final static String STRING_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";

    private SimpleDateFormat format;

    private URL url;

    public RssParser(String url) {
        try {
            this.url = new URL(url);
            this.format = new SimpleDateFormat(STRING_DATE_FORMAT, Locale.US);
        } catch (MalformedURLException e) {
            logger.error("Failed to create url", e);
        }
    }

    public synchronized List<Feed> parse() throws SAXException, ParserConfigurationException, IOException {
        List<Feed> feedList = new ArrayList<Feed>();
        if (null == url)
            return feedList;

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        final int statusCode = conn.getResponseCode();
        if (HttpURLConnection.HTTP_OK == statusCode) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(conn.getInputStream());

            NodeList nodelist = doc.getElementsByTagName("item");
            final int size = nodelist.getLength();
            for (int i = 0; i < size; i++) {
                Node node = nodelist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList guidList = element.getElementsByTagName("guid");
                    NodeList titleList = element.getElementsByTagName("title");
                    NodeList linkList = element.getElementsByTagName("link");
                    NodeList descList = element.getElementsByTagName("description");
                    NodeList pubDateList = element.getElementsByTagName("pubDate");

                    Feed feed = new Feed();
                    feed.setId(i);
                    feed.setGuid(guidList.item(0).getChildNodes().item(0).getNodeValue());
                    feed.setMainLink(url.toString());
                    feed.setTitle(titleList.item(0).getChildNodes().item(0).getNodeValue());
                    feed.setLink(linkList.item(0).getChildNodes().item(0).getNodeValue());
                    feed.setDescription(descList.item(0).getChildNodes().item(0).getNodeValue());

                    final long currentTime = System.currentTimeMillis();
                    feed.setDate(String.valueOf(currentTime));

                    String pubDate = pubDateList.getLength() == 0 ?
                            "Wrong format of date" :
                            pubDateList.item(0).getChildNodes().item(0).getNodeValue();
                    try {
                        pubDate = String.valueOf(format.parse(pubDate).getTime());
                    } catch (ParseException e) {
                        logger.error("Unable to write date as a string", e);
                    }
                    feed.setPubDate(pubDate);

                    feedList.add(feed);
                }
            }
        }
        conn.disconnect();
        return feedList;
    }

}
