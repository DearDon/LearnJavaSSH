# learnSSH 
这是一个用来学习SSH三大框架的仓库。</br>
由于版权原因，没有直接把随书源码传上来，仓库记录的是自己学习每章时改写的代码。</br>
下面写下学习过程的记录。
####案例中用的mysql的配套数据库表:
database ssh,其下table customer,包含custname(unique) char(20),pwd char(45),age int,address char(45)</br>
####log01(2015/05/08):
今天终于把第一章的struts2快速入门搞定了，基于struts2完成了一个简单的login应用，由于只是为了体验struts2的工作方法和模式，整个应用的功能很简单，都没有用到数据库。其实本质上struts2框架就是对servlet进行了一些封装，我们知道简单说来servlet就是在JavaSE基础上加上了与web浏览器打交道的功能(通过httprequest或httpresponse)。struts2框架就是为了将该过程分离，使得MVC中的M业务逻辑能从servlet中脱离，完全用JavaSE实现。由于servlet获得http的参数时还是挺繁琐的，重复代码很多，重复编程的大忌。所以struts2加入了一个浏览器与业务逻辑程序的中间媒介，通过MVC中的C控制层(过滤器，拦截器，Action)来完成servlet中的http部分的功能，成功得到浏览器请求中各参数合适形式后，交给适当的M层中的JavaSE程序。M层执行完指定适当的V显示层再次通过C层传至浏览器。总之在struts2的框架中，与浏览器交互的请求和响应都是通过C层的中间过程。这也是struts2框架的意义所在，将web应用中服务器端程序与浏览器的交互通过C层完成，分离出了应用程序核心的M层，可单独用JavaSE编写。这除了简化一些http代码，更重要的是模块分离使得单独用JavaSE中的方法调试M层成为可能，而在之前未分离的情况下必须通过http请求才能使应用程序执行，调试的目标性不强。由于struts2框架只是封闭的servlet类，使用struts2框架只要在web程序中导入适当的包，并配置好struts.xml，过滤器等就ok，不用单独安装其它程序。</br>
另外说一下，学习过程序中遇到的问题，第一次用struts2框架时，即便是很简单的应用，最常见的问题是访问时404错误。这个问题最常见的情况是需要的包未导入全，xml配置不正确。具体要看运行出错时console的出错提示而定。自己当时就是遇到了struts2.xml配置中extends="struts-default"这句多写了个s，使default写成了defaults，导致一直404找不到文件。总之细看console的出错提示，刚开始的出错一般都是文件存放位置不对，配置不正确或必要文件缺失。</br>
####log02(2015/05/09):
今天学完了第二、三、四章。但只把第二章相关的改写代码同步到了库，第三、四章内容较少，直接在这里写下记录就不上传代码了。</br>
首先说第二章，该章主要大致讲了下三类控制器，没有深入讲细节，这一章主要是用struts2框架实现 了用户登陆功能，以及在M层与mysql的交互(按功能共分为了action,dao,exception,service,vo五个包)，虽然该章没有深入讲struts2的内容，但项目的M层基本实现，跨出了第一步，在M层用JDBC连接了MYSQL，加入了不少包(dao,vo,exception)来规范完成这一功能，后面只要把该系统的注册和查看信息功能实现就行。</br>
再来说下第三章，该章节深入讲了拦截器，其自定义的方式就是自己写个java类，实现struts2 API提供的拦截器接口，特别要重写该实现中的intercept方法。拦截器是在action调用前后搭配用的，在用java类实现了拦截器后，使用时要先在struts.xml中定义自定义的拦截器(栈)的名字，然后依旧在struts.xml中设置该拦截器(栈)要与哪个action搭配使用,所谓的拦截器栈就是一系列的拦截器按顺序组合在一起，调用时会依次进行调用。由于struts.xml中定义的包继承了struts-default.xml，默认是整个包内的action都使用了struts-default.xml中定义的defaultStack拦截器栈的。但当自己设置了某个action使用特定的拦截器时，想仍旧使用defaultStack就必须显示指定。</br>
最后说一下第四章，这部分主要讲Action的，Action完成了表单参数封装，业务逻辑调用及根据业务层结果实现页面导航选择输出，可以说是控制层中工作最多的，而且基本都要用户自己实现。这里说实现是因为struts2API定义了Action的接口，但是由于提供的接口的默认功能很少，且基本没什么意义，所以也规定可以不实现该Action接口，而直接自己新建按一定规范要求写的类(要求完成表单变量的get,set等封闭功能，并且其中有个返回值为String的无参数方法，该方法默认名为execute)。当该Action规范类中的执行方法不为execute时(有时不想用该名，或该中有很多个完成不同功能的执行方法，不可能都叫execute)，在调用使用时必须显示说明方法名，这有两大类方法，第一类为在struts.xml中定义Action类名称与类名时同时设置method为该执行方法名，这种方法还能用通配符一次设置该类中多个执行方法的对应名称，第二类方法是在JSP文件中设置，这又分为两种小方法，一种是在表单的action名称设置处将action名称改为actionname!methodname的方式设置，另一种是表单的提交submit项中加入method参数设置。</br>
####log03(2015/05/11):
刚完成了第五章的内容，并根据所学的改写了自己的代码，目前该程序除之前做的登陆之外，还完成了注册及查看其它新户的信息(简易交友系统的基本功能实现了)。这一章主要讲的是如何在Action类中与Servlet API交互，由于struts2框架是MVC框架，为了M层为完全的普通JavaSE程序，在C层必然要实现客户端http与java交互的功能，这主要在过滤器，拦截器中自动实现了。但在C层的第三部分Action类中，是C层中直接调用M层的一部分，由于基本需要用户自己改写，为了单元测试方便，最好是能与servlet解耦，也成为普通的JavaSE程序。通常情况下这确实是可以的，拦截器可以直接把表单元素传给Action类，Action类完全不用知道这些变量来自于网络表单，在它看来与普通Java类中的参数传递没有什么不同。但是有的时候要求得到更多信息，这时第一种方式是使用ActionContext类，该类是Action运行时的上下文(好专业...)，其中包含了会话、请求参数等信息。所以通过该ActionContext对象可方便的获得或设置请求、会话、上下文中的属性，注意是操作它们的属性，来进行值传递。这种通过ActionContext来完成Action与ServletAPI交互的方式的好处是，Action依然与Servlet没什么关系，可当作普通Java程序运行，测试。第二种方式是使用ServletActionContext，这种方式从名字中可以发现比第一种方式多了个Servlet，也暗示了它与Servlet是耦合的，必须要在网络容器(如tomcat)下进行测试，但由于它利用了Servlet技术，可以直接获得请求、会话或上下文对象，并对其进行操作。第一种方式并没有获得这些网络对象，而是通过这些网络对象相关联的Map对象来操作其属性。第三种方式是IoC(Inverse of Control)控制反转方式，这会在Spring部分学习。Action类通过实现一系列的XXXAware接口，可以获得XXX网络对象(XXX可为ServletResponse,ServletRequest,ServletContext)，这是系统容器装配好的。在Action类的execute方法中便可以直接操作这些对象，由于要直接操作这些网络对象，并且还需要系统容器为其装配控制，所以也是与Servlet耦合的，比第二种方式更耦合得紧密，但使用也更为方便。本章完成查看其它用户信息的时候就是通过第一种ActionContext的方式在request属性中传递了所有用户信息集合，并传递到jsp进行显示。</br>
另外要注意的是，在jsp显示所有用户信息时，为了代码简洁，兼容性好，没有手动一行行输出用户信息，而是类似for循环的方式输出，这用到了JSTL标签库和EL迭代功能。EL(Expression Language)是一种表达式语言,如果只是使用EL表达式，不需要引入任何jar包，只要jsp/servlet容器实现了J2EE1.4/servlet2.4、JSP2.0规范就可以。但是要使用JSTL标签库，必须要有jstl.jar,standard.jar两个jar包和标签库对应的tld文件(用来配置与jar包中定义的java类功能中对应的标签名，有点类似xml文件的作用)，所需文件
[下载地址](http://tomcat.apache.org/taglibs/standard)。两个jar包直接放在工程lib目录或其它目录再导入工程的library库中都行。而对应tld(有多个tld后缀的文件，一起放在tld目录下)的文件夹拷到工程的WEB-INF目录下即可。另外有一个小细节，JSTL目前有1.0和1.1版(好象1.2版也出来了，没用过)，它们是不同的。它们的tld文件中设置的uri都不一样，在1.0版中为<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>，而1.1版为<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>。这在导致在jsp页面设置默认引用的uri要对应改到，否则找不到对应标签库。
####log04(2015/05/12):
上午学习了第六、七章的内容，这两章对所做的项目案例并没有太大改动，也没有新增什么功能，所以学习的代码没有push到github上来。记录一下学习体验，学完后发现第五、六、七章内容都是很相关的，讨论的都是Action类中存取、传递值或对象的一些技术手段，所以对这三章分别评价下，好对Action类传递值的技术了解更系统。由于Action类是C层中最底下的一层，直接与M层和V层打交道，所以对这几层间的值传递功能有很大需求。第五章主要说的是Action利用ServletAPI完成客户端传来的各种网络对象获取，并将其转交给M层处理。由于要获得网络对象，这与Servlet功能紧密相关，除了ActionContext方式外，ServletActionContext和IoC方式要求Action类与Servlet相耦合，使得测试运行必须在系统容器中进行。第六章则介绍了另一种交互技术，通过拦截器在Action执行前后帮助封装网络的请求参数(Field_Driven方式)或对象(Model-Driven方式)，由于这都是通过拦截器来调用实现封装的，所以在Action类中要按规范定义请求的参数或对象，并设置好对应的setXXX(在Action之前的拦截器用来往Action类中传递值)和getXXX(在Action之后的拦截器用来调用方便取出Action类中的属性值，好传递给之后的jsp文件等)，这种交互技术的存取值都是通过拦截器完成的，所以Action类可完全与Servlet节耦，方便单元测试。第七章更进一步利用第六章的技术，将Action类的属性进一步开发，除了第六章讲的封装客户端传来的请求参数或对象，还可以封装struts.xml中配置的参数，或自己在Action类中自定义属性(这时该属性可以没有setXXX方法，因为不需要上层传值过来，也就是不用拦截器为其赋值，但要想将该属性传给之后调用的jsp，必须要有getXXX方法，这样之后的拦截器才能取出该值传给对应的jsp)。由于Action的属性可以封闭如此多东西（网络请求范围内的参数和对象，或自定义的配置参数、属性），所以Action属性显然可以用于在不同文件或层之间进行传值用，可以实现客户端传来的网络对象（参数）、M层的对象（参数）、V层的对象（参数）间的传递和交互。第七章最后还详细介绍了Jsp如何通过getXXX方法获得Action请求范围内属性值。</br>
综合第五、六、七章的技术，总结一下。Action类有两大类传值方式：一类是通过ServletAPI的方式，这种方式通常与Servlet耦合(ActionContext方式除外，但只能操作请求属性)，也因此具有Servlet的网络特性，可以全面地操作网络请求、会话和上下文对象。另一类是通过Action类属性的封装，这种方式由于利用拦截器完成属性封装，所以Action类与Servlet是解耦的，也因此Servlet的功能较少，仅能获取网络请求的对象或参数(至少书中没说可以操作会话或上下文对象，可以是因为网络请求的操作要求最频繁，所以在Action类属性的封闭方法中实现了网络请求范围的操作，当然如何第二类方法要是还能操作会话或上下文对象的话，几乎完全替代了第一类方法的功能，还保证解耦，那应该也就不需要第一大类方法了，所以估计是实现不了)，但是Action类属性很灵活，可以自定义除网络传递来的对象外的任意对象，并保存于请求范围属性中，只要满足getXXX要求，都能传递给之后的jsp等文件。所以简单一句话就是第一类方式在Action类中操作网络对象比较强大，第二类方式操作自定义的对象或网络请求对象比较灵活。
