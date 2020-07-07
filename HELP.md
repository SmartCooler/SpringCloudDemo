# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)


#创建gitclub账号并创建仓库

https://www.cnblogs.com/wangju/p/11807557.html


#上传代码

https://www.cnblogs.com/meiyanstar/p/12982395.html

步骤：
(a). 找到具有.git目录，且进行更改/添加的代码路径，点击Git bash here
(b). cd test
(c). git init
(d). git add .        （注：别忘记后面的 . ，此操作是把Test文件夹下面的文件都添加进来）
(e). git commit  -m  "提交信息"  （注：“提交信息”里面换成你需要，如“first commit”）
(f). git push -u origin master   （注：此操作目的是把本地仓库push到github上面，此步骤需要你输入帐号和密码）

注意，第一次提交使用git push -u origin master，以后用 git push就可以了。不然会报错“Your branch is ahead of 'origin/master' by 1 commit.”这个错误，  解决办法就是 执行 git fetch ，然后重新提交。

注意：不能随便使用git init这样也容易报错，会commit报错，而且要在变更的目录下进行命令操作，不要在最外层操作。