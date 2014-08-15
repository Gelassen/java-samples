<!-- login\register dialog-->

var test = "/templates/login/login-register-overlay.html"

var autocompleteData = ["Web Development","Web Development","Web Development  Web developer","Web Developer | Web Developers","Web Development","web development","Web Development  Web developer","Web Developer","Web Development","The Web Developers List of Resources.","Web Developing","Web Development","web development","Web Development","Web Development","Web Design, Web Development","Web Development","web developers","Web Development","120+ Web Development Resources - Web Development Toolbox","Web Development Project Estimator","The Best Web Development Frameworks","Web Development"];	



	
	var navigationJson =     [{
	"id"	: "categories",
	"title" : "Categories",
	"subitems": [
	    {
		"title" : "Client-side development",
		"url"	: "#"
	    },
	    {
		"title" : "Java",
		"url"	: "#"
	    },
	    {
		"title" : ".Net",
		"url"	: "#"
	    },
	    {
		"title" : "Web-Design",
		"url"	: "#"
	    }
	]
    },
    {
	"id"	: "advertisment",
	"title" : "Advertisment",
	"subitems": [
	    {
		"title" : "Buy something",
		"description"	: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod",
		"url"	: "#"
	    },
	    {
		"title" : "Another adwords",
		"description"	: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod",
		"url"	: "#"
	    },
	    {
		"title" : "Programatic magic",
		"description"	: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod",
		"url"	: "#"
	    }
	]
    },
    {
	"id"	: "activities",
	"title" : "Activities",
	"subitems": [
	    {
		"title" : "Team Work",
		"url"	: "#"
	    },
	    {
		"title" : "Reflecsion",
		"url"	: "#"
	    },
	    {
		"title" : "Readings",
		"url"	: "#"
	    }
	]
    },
    {
	"id"	: "stat",
	"title" : "Statistics",
	"subitems": [
	    {
		"title" : "Total met programmers",
		"url"	: "#"
	    },
	    {
		"title" : "Programmers left",
		"url"	: "#"
	    },
	    {
		"title" : "Now reading books",
		"url"	: "#"
	    }
	]
    }
	];

var newsStub = [
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web Development",
         "title":"Web Development",
         "submit_date":1297960290,
         "media":0,
         "diggs":2,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/web_development_78\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_78",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.mycomputer2u.com\/intranet\/web-development",
         "href":"http:\/\/digg.com\/news\/business\/web_development_78",
         "id":"20110217163130:91270526-07e8-4012-b0e9-bdf54f1617f4",
         "user":{
            "name":"chooi82",
            "links":[
               {
                  "date":1306324180,
                  "href":"http:\/\/www.retirementguide2u.com\/",
                  "description":"Retirement Planning Guide"
               },
               {
                  "date":1306324180,
                  "href":"http:\/\/www.retirementguide2u.com\/mortgage\/",
                  "description":"Best Mortgage Deals"
               },
               {
                  "date":1306324180,
                  "href":"http:\/\/www.retirementguide2u.com\/credit\/",
                  "description":"Credit Card Settlements"
               }
            ],
            "registered":1288404522,
            "profileviews":0,
            "fullname":"Jack Ooi",
            "icon":"http:\/\/cdn3.diggstatic.com\/user\/20101030020842:43fa9269-9e69-432c-b0ed-37168b154a9d\/l.1857482254.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web development is a broad term for any activity related to developing a web site for the World Wide Web or an intranet",
         "title":"Web Development",
         "submit_date":1302002353,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_85\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_85",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.getleadsfast.com\/web_site_info\/web_development.php",
         "href":"http:\/\/digg.com\/news\/business\/web_development_85",
         "id":"20110405111914:22a88e61-5bce-4a33-83a7-0e2649f7a6ac",
         "user":{
            "name":"cragshaw",
            "links":[

            ],
            "registered":1301645931,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"The project is an eCommerce website, a web store with a unique distribution system and innovative ideas that would take web shopping to the next level.  What technologies will be used and whether the website will be build on top of an os\/proprietary eCommerce system (eg. Magento) or our own would be decided with the person we are lookingfor, responsible for the development.Until project becomes profitable there will be no income.  We need a person who is driven by the idea and not money!  When the project becomes profitable we expect the developer to head the development department.If you are ",
         "title":"Web Development  Web developer",
         "submit_date":1293018091,
         "media":0,
         "diggs":9,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_web_developer\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_development_web_developer",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/forums.phoenixwebsolutions.net\/viewtopic.php?t=290&#38;p=421#p421",
         "href":"http:\/\/digg.com\/news\/technology\/web_development_web_developer",
         "id":"20101222114140:52be5ce7-541f-40ec-8b05-e2554cd010ba",
         "user":{
            "name":"jaimin26783",
            "links":[

            ],
            "registered":1273346038,
            "profileviews":0,
            "fullname":"Jaimin Patel",
            "icon":"http:\/\/cdn1.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"The team of web developers make sure the target website is designed according to the business functions. web developer australia are more specialised in the activities involved in web development and web designing.",
         "title":"Web Developer | Web Developers",
         "submit_date":1301089717,
         "media":0,
         "diggs":1,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_developer_web_developers\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_developer_web_developers",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.ictquotes.com.au\/footer\/10\/Website-Development.html",
         "href":"http:\/\/digg.com\/news\/technology\/web_developer_web_developers",
         "id":"20110325214835:076b6a55-bf23-437c-ade9-17bd9bc03c2c",
         "user":{
            "name":"jessycallins",
            "links":[

            ],
            "registered":1290709246,
            "profileviews":0,
            "fullname":"ICT australia",
            "icon":"http:\/\/cdn1.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"Web Development through esquisite design.",
         "title":"Web Development",
         "submit_date":1299118289,
         "media":0,
         "diggs":2,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn2.diggstatic.com\/story\/web_development_81\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_development_81",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.avero.co.nz\/web-development\/",
         "href":"http:\/\/digg.com\/news\/technology\/web_development_81",
         "id":"20110303021129:c70a0fa9-2817-4eb8-afdf-628b8f81aa20",
         "user":{
            "name":"TechHead10",
            "links":[

            ],
            "registered":1299117835,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn1.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Agriya are an offshore web development company based in India. We design, develop, intuitive, mobile and SEO friendly applications to help companies take advantage of the power in social and business collaboration.t ",
         "title":"web development",
         "submit_date":1299574501,
         "media":0,
         "diggs":2,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_83\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_83",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.pulldownit.com\/forum\/index.php?action=profile;u=91647;sa=summary",
         "href":"http:\/\/digg.com\/news\/business\/web_development_83",
         "id":"20110308085501:d818c6b9-b5f3-4bee-9d97-2e94e53b3e05",
         "user":{
            "name":"sathyaraj2",
            "links":[

            ],
            "registered":1298291941,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn1.diggstatic.com\/user\/20110221123901:6f4b16e4-7484-498a-af5a-5a3390275edf\/l.3665326677.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"The project is an eCommerce website, a web store with a unique distribution system and innovative ideas that would take web shopping to the next level.  What technologies will be used and whether the website will be build on top of an os\/proprietary eCommerce system (eg. Magento) or our own would be decided with the person we are lookingfor, responsible for the development.Until project becomes profitable there will be no income.  We need a person who is driven by the idea and not money!  When the project becomes profitable we expect the developer to head the development department.If you are ",
         "title":"Web Development  Web developer",
         "submit_date":1293018092,
         "media":0,
         "diggs":6,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn2.diggstatic.com\/story\/web_development_web_developer_2\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_development_web_developer_2",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/forums.phoenixwebsolutions.net\/viewtopic.php?t=290&#38;p=421#p421",
         "href":"http:\/\/digg.com\/news\/technology\/web_development_web_developer_2",
         "id":"20101222114142:b2ef1371-6d4d-4433-b7b3-22bb39951378",
         "user":{
            "name":"jaimin26783",
            "links":[

            ],
            "registered":1273346038,
            "profileviews":0,
            "fullname":"Jaimin Patel",
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"Web developer's website: tricks about HTML, css, PHP, Mysql",
         "title":"Web Developer",
         "submit_date":1303994557,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn2.diggstatic.com\/story\/web_developer_35\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_developer_35",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/htm-php-sql.blogspot.com\/",
         "href":"http:\/\/digg.com\/news\/technology\/web_developer_35",
         "id":"20110428124237:e70054f5-d9da-470d-861d-33044a853db1",
         "user":{
            "name":"vilceloiu",
            "links":[

            ],
            "registered":1223033154,
            "profileviews":0,
            "fullname":"Stefan Vilceloiu",
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web design Brisbane: Puremedia is a long standing web design and development company located in Brisbane, specialising in result driven websites and online applications.",
         "title":"Web Development",
         "submit_date":1303027016,
         "media":5,
         "diggs":1,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_87\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_87",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.puremedia.com.au\/",
         "href":"http:\/\/digg.com\/news\/business\/web_development_87",
         "id":"20110417075656:758c5b6b-3e6c-4257-9adc-ef49c4bccbe6",
         "user":{
            "name":"gsinc",
            "links":[

            ],
            "registered":1302076446,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "description":"This page is huge. Everything you can imagine form FF plugins to Ruby. This page has it all.",
         "title":"The Web Developers List of Resources.",
         "submit_date":1168998379,
         "media":0,
         "diggs":1690,
         "comments":43,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/The_Web_Developers_List_of_Resources\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/story\/The_Web_Developers_List_of_Resources",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.devlisting.com\/",
         "href":"http:\/\/digg.com\/news\/story\/The_Web_Developers_List_of_Resources",
         "id":"20070116174619:1192862",
         "user":{
            "name":"sicc",
            "links":[

            ],
            "registered":1166252935,
            "profileviews":0,
            "fullname":"Sic",
            "icon":"http:\/\/cdn2.diggstatic.com\/user\/862924\/l.925176830.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"LightNEasy was created for developing and maintaining private or small commercial websites.",
         "title":"Web Developing",
         "submit_date":1302854067,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/web_developing_3\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_developing_3",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/lightneasy.org\/punbb\/profile.php?id=30376",
         "href":"http:\/\/digg.com\/news\/business\/web_developing_3",
         "id":"20110415075427:4c251b35-fc19-4f98-a7a5-4608470b96fd",
         "user":{
            "name":"cerim",
            "links":[

            ],
            "registered":1300685283,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn2.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web Development: Vidushi Infotech SSP Pvt Ltd,India  provides services of  Customized Software Development, Web Development,Graphic Design, Web Application Maintenance and Support, SEO Services, SMO Services. Visit Our Website for more information: http:\/\/www.vidushiinfotech.com\/contactus.asp , Contact No.( 91 20 30621921\/2), Skype ID:avadhutvit,Thank You.",
         "title":"Web Development",
         "submit_date":1299493514,
         "media":0,
         "diggs":2,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_82\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_82",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.vidushiinfotech.com\/FAQ.asp",
         "href":"http:\/\/digg.com\/news\/business\/web_development_82",
         "id":"20110307102514:ee80a80f-1e6d-4e91-9cc6-9784b01c9471",
         "user":{
            "name":"bookmarkingseo",
            "links":[

            ],
            "registered":1284028140,
            "profileviews":0,
            "fullname":"BOOKMARKINGSEOEXPERT",
            "icon":"http:\/\/cdn3.diggstatic.com\/user\/20100909102900:d2ad924c-0432-41de-8983-f9e039ffce05\/l.2240075851.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"web development",
         "title":"web development",
         "submit_date":1306261750,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/web_development_92\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_development_92",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/sitenetltd.blogspot.com\/2011\/05\/blog-post.html",
         "href":"http:\/\/digg.com\/news\/technology\/web_development_92",
         "id":"20110524182910:bf58e27b-7c18-4d6b-a79b-e7f0d3de7ee1",
         "user":{
            "name":"eran01",
            "links":[

            ],
            "registered":1306261578,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn1.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web Developer in Johannesburg, South Africa specialising in web development involving eMarketing and web design.",
         "title":"Web Development",
         "submit_date":1303588361,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_88\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_88",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.increative.co.za",
         "href":"http:\/\/digg.com\/news\/business\/web_development_88",
         "id":"20110423195241:8e934a07-708f-4791-84f5-adac2472570d",
         "user":{
            "name":"increativesa",
            "links":[

            ],
            "registered":1300140965,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn1.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"Our web development team can create custom web applications and implement web based tools to help you better market your products & services.",
         "title":"Web Development",
         "submit_date":1305029603,
         "media":0,
         "diggs":1,
         "comments":1,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_development_89\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_development_89",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.dynamicdreamz.com\/web_development",
         "href":"http:\/\/digg.com\/news\/technology\/web_development_89",
         "id":"20110510121323:a84c7109-fffe-4698-afa9-cc491afe0b27",
         "user":{
            "name":"ddwordpressdevelopment",
            "links":[

            ],
            "registered":1305029191,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn1.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"Technology"
         },
         "description":"Web Design & Development has never been simpler. Our Website Designs are affordable & most importantly search engine friendly. For professional Web Design, Development and Search Engine Optimisation (SEO) that is affordable & professional Call 1300 448 184.",
         "title":"Web Design, Web Development",
         "submit_date":1282304573,
         "media":0,
         "diggs":107,
         "comments":5,
         "thumbnail":{
            "src":"http:\/\/cdn2.diggstatic.com\/story\/Web_Design_Web_Development_5\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"Technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/Web_Design_Web_Development_5",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.zeidanconsulting.com",
         "href":"http:\/\/digg.com\/news\/technology\/Web_Design_Web_Development_5",
         "id":"20100820114253:23356142",
         "user":{
            "name":"zeidanconsultin",
            "links":[

            ],
            "registered":1256188709,
            "profileviews":0,
            "fullname":"George Zeidan",
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web Development",
         "title":"Web Development",
         "submit_date":1306012201,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/web_development_90\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_90",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.dianysmedia.info\/web-development\/",
         "href":"http:\/\/digg.com\/news\/business\/web_development_90",
         "id":"20110521211001:655e06c5-ed1a-44dc-aea5-fddf8029aa38",
         "user":{
            "name":"dianysmedia",
            "links":[
               {
                  "date":1306324180,
                  "href":"http:\/\/www.tablatiptigla.info",
                  "description":"Tabla tip tigla"
               }
            ],
            "registered":1298754362,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn2.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"technology"
         },
         "description":"Agriya's web developers specialize in web application development such as php project development and development.",
         "title":"web developers",
         "submit_date":1299235197,
         "media":0,
         "diggs":2,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn3.diggstatic.com\/story\/web_developers_4\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/web_developers_4",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.noobtoob.com\/forum\/profile.php?mode=viewprofile&u=12951",
         "href":"http:\/\/digg.com\/news\/technology\/web_developers_4",
         "id":"20110304103957:5b287b47-48e6-47f1-a34f-f6dcb1f17742",
         "user":{
            "name":"sureshshan",
            "links":[
               {
                  "date":1306324180,
                  "href":"http:\/\/www.agriya.com",
                  "description":"Link Name"
               }
            ],
            "registered":1295615473,
            "profileviews":0,
            "fullname":"suresh",
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web Development",
         "title":"Web Development",
         "submit_date":1306013772,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/web_development_91\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_91",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.dianysmedia.info\/web-development\/",
         "href":"http:\/\/digg.com\/news\/business\/web_development_91",
         "id":"20110521213612:22fe5385-0bf3-4624-a476-65f6936be8c8",
         "user":{
            "name":"dianysmedia",
            "links":[
               {
                  "date":1306324180,
                  "href":"http:\/\/www.tablatiptigla.info",
                  "description":"Tabla tip tigla"
               }
            ],
            "registered":1298754362,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn2.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "description":"\"...a list of over 120 web development resources to make your life easier.\"",
         "title":"120+ Web Development Resources - Web Development Toolbox",
         "submit_date":1185620101,
         "media":0,
         "diggs":1262,
         "comments":28,
         "thumbnail":{
            "src":"http:\/\/cdn2.diggstatic.com\/story\/120_Web_Development_Resources_Web_Development_Toolbox\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/story\/120_Web_Development_Resources_Web_Development_Toolbox",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/mashable.com\/2007\/07\/28\/web-development\/",
         "href":"http:\/\/digg.com\/news\/story\/120_Web_Development_Resources_Web_Development_Toolbox",
         "id":"20070728035501:2608527",
         "user":{
            "name":"dimmerswitch",
            "links":[

            ],
            "registered":1150720265,
            "profileviews":0,
            "fullname":"Darrell",
            "icon":"http:\/\/cdn2.diggstatic.com\/user\/341337\/l.1999444553.png"
         }
      },
      {
         "status":"upcoming",
         "description":"The Web Development Project Estimator is a simple tool that allows web designers and site developers to quickly and thoroughly estimate the time and materials required for a proposed web project.",
         "title":"Web Development Project Estimator",
         "submit_date":1231858131,
         "media":0,
         "diggs":340,
         "comments":15,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/Web_Development_Project_Estimator\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/story\/Web_Development_Project_Estimator",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/estimator.astuteo.com\/",
         "href":"http:\/\/digg.com\/news\/story\/Web_Development_Project_Estimator",
         "id":"20090113064851:10457817",
         "user":{
            "name":"bitcrave",
            "links":[

            ],
            "registered":1231857931,
            "profileviews":0,
            "fullname":"",
            "icon":"http:\/\/cdn2.diggstatic.com\/img\/user\/l.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Technology",
            "short_name":"Technology"
         },
         "description":"Web Development Framework is a software framework that is designed to support the development of a Websites, Web applications and Web services. Many frameworks",
         "title":"The Best Web Development Frameworks",
         "submit_date":1277887457,
         "media":0,
         "diggs":180,
         "comments":13,
         "thumbnail":{
            "src":"http:\/\/cdn1.diggstatic.com\/story\/The_Best_Web_Development_Frameworks\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Technology",
            "short_name":"Technology"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/technology\/The_Best_Web_Development_Frameworks",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.webdesignish.com\/the-best-web-development-frameworks.html",
         "href":"http:\/\/digg.com\/news\/technology\/The_Best_Web_Development_Frameworks",
         "id":"20100630084417:22273706",
         "user":{
            "name":"compleatang",
            "links":[

            ],
            "registered":1265278404,
            "profileviews":0,
            "fullname":"Casey Kuhlman",
            "icon":"http:\/\/cdn3.diggstatic.com\/user\/6663505\/l.1365590086.png"
         }
      },
      {
         "status":"upcoming",
         "container":{
            "name":"Business",
            "short_name":"business"
         },
         "description":"Web development is making a single page of text to establishing more complex Internet based sites which is also the definite assemble of the whole website like writing mark up and coding.",
         "title":"Web Development",
         "submit_date":1302679437,
         "media":0,
         "diggs":1,
         "comments":0,
         "thumbnail":{
            "src":"http:\/\/cdn2.diggstatic.com\/story\/web_development_86\/t.png",
            "contentType":"image\/png",
            "originalheight":300,
            "height":62,
            "width":62,
            "originalwidth":300
         },
         "topic":{
            "name":"Business",
            "short_name":"business"
         },
         "shorturl":{
            "short_url":"http:\/\/digg.com\/news\/business\/web_development_86",
            "view_count":0
         },
         "promote_date":null,
         "link":"http:\/\/www.syntacticsinc.com\/content_section.php\/Web-Design",
         "href":"http:\/\/digg.com\/news\/business\/web_development_86",
         "id":"20110413072357:f697fe98-96ea-4733-b37a-4145ab08e969",
         "user":{
            "name":"staciejortega",
            "links":[

            ],
            "registered":1300172295,
            "profileviews":0,
            "fullname":null,
            "icon":"http:\/\/cdn3.diggstatic.com\/img\/user\/l.png"
         }
      }
   ];
	
$.ajaxSetup ({
	cache: false
});

$(function() {	
	
	$(window).bind("popstate", function() {
		console.log("call: popstate");
		// update page
		var url = $(location).attr('hash');
		var page = url.substring(url.indexOf("#")+1);
		$('div').postloader('update', page, $("#pagenumspan"));

	});
	
	$("#prev").click(function() {
		$('div').postloader('previouspage');
		$('div').postloader('pagenumber', $("#pagenumspan"));
	});
	
	$("#next").click(function() {
		$('div').postloader('nextpage');
		$('div').postloader('pagenumber', $("#pagenumspan"));
	});

	var decoratedNews = new Array();

	for (var item in newsStub) {
		var temp = newsStub[item].submit_date;
		newsStub[item].submit_date = new Date(1000*temp).toString();
		decoratedNews.push(newsStub[item]);
	}
	
	var url = $(location).attr('hash');
	var page = url.substring(url.indexOf("#")+1);
	console.log(page);
	
	$('div').postloader('init', $("#newsposts"), '/templates/news-item.html', decoratedNews, page);
	$('div').postloader('load', $("#newsposts"), '/templates/news-item.html', decoratedNews);
	$('div').postloader('pagenumber', $("#pagenumspan"));
	
	$.get('/templates/nav-cats.html', function(templates) {
		$.tmpl(templates, navigationJson).appendTo("#navaccordion")
	});
	
	$("#loginLink").click(function() {
		$("#dialog").dialog().load(test);
	});
	
	function regexp(o, n, regexp) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			<!--updateTips(n);-->
			return false;
		} else {
			return true;
		}
	}
	
	$('body').on('click', "#logbtn", function() {
		var bValid = true;
		bValid = bValid && (
			regexp(
				$("#flogin"), 
				"Login should a valid emal or contain numbers and chars", 
				/^[_\.0-9a-zA-Z-]+$/)
			||
			regexp(
				$("#flogin"), 
				"Login should a valid emal or contain numbers and chars", 
				/^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i)
			);
		bValid = bValid && regexp(
			$("#fpass"),
			"Password must contain only numbers and chars", 
			/^[a-zA-Z]{3,16}$/);
		if (bValid) {
			$("#hlogin").html(function() {
				var name = $("#flogin").val();
				return "<p>You are logged in as <a id=\"loginLink\" href=\"#\">" + name + "</a></p>";
			});
			$("#dialog").closest('.ui-dialog-content').dialog('close');
		}
	});
	
	$("#regbutton").click(function() {
		var bValid = true;
		bValid = bValid && regexp("#femail", 
			"Email should a valid emal", 
			/^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i);
		bValid = bValid && regexp("#floginnew",
			"Login contain numbers and chars", 
			/^[a-zA-Z]{3,16}$/);
	});
	

	
	$( "#pojam" ).autocomplete({
		source: autocompleteData,
		select: function(event, ui) {
			$("#searchform").submit();
		}
	});
	
	
});