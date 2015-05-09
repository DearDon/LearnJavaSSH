# learnSSH 
这是一个用来学习SSH三大框架的仓库。</br>
由于版权原因，没有直接把随书源码传上来，仓库记录的是自己学习每章时改写的代码。</br>
下面写下学习过程的记录。
<h3>案例中用的mysql的配套数据库表:</h3>
database ssh,其下table customer,包含custname(unique) char(20),pwd char(45),age int,address char(45)</br>
</br>
<h3>log01(2015/05/08):</h3>
    今天终于把第一章的struts2快速入门搞定了，基于struts2完成了一个简单的login应用，由于只是为了体验struts2的工作方法和模式，整个应用的功能很简单，都没有用到数据库。其实本质上struts2框架就是对servlet进行了一些封装，我们知道简单说来servlet就是在JavaSE基础上加上了与web浏览器打交道的功能(通过httprequest或httpresponse)。struts2框架就是为了将该过程分离，使得MVC中的M业务逻辑能从servlet中脱离，完全用JavaSE实现。由于servlet获得http的参数时还是挺繁琐的，重复代码很多，重复编程的大忌。所以struts2加入了一个浏览器与业务逻辑程序的中间媒介，通过MVC中的C控制层(过滤器，拦截器，Action)来完成servlet中的http部分的功能，成功得到浏览器请求中各参数合适形式后，交给适当的M层中的JavaSE程序。M层执行完指定适当的V显示层再次通过C层传至浏览器。总之在struts2的框架中，与浏览器交互的请求和响应都是通过C层的中间过程。这也是struts2框架的意义所在，将web应用中服务器端程序与浏览器的交互通过C层完成，分离出了应用程序核心的M层，可单独用JavaSE编写。这除了简化一些http代码，更重要的是模块分离使得单独用JavaSE中的方法调试M层成为可能，而在之前未分离的情况下必须通过http请求才能使应用程序执行，调试的目标性不强。由于struts2框架只是封闭的servlet类，使用struts2框架只要在web程序中导入适当的包，并配置好struts.xml，过滤器等就ok，不用单独安装其它程序。</br>
    另外说一下，学习过程序中遇到的问题，第一次用struts2框架时，即便是很简单的应用，最常见的问题是访问时404错误。这个问题最常见的情况是需要的包未导入全，xml配置不正确。具体要看运行出错时console的出错提示而定。自己当时就是遇到了struts2.xml配置中extends="struts-default"这句多写了个s，使default写成了defaults，导致一直404找不到文件。总之细看console的出错提示，刚开始的出错一般都是文件存放位置不对，配置不正确或必要文件缺失。</br>
