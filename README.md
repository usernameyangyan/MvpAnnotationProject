![Travis](https://img.shields.io/badge/release-1.0.0-green.svg)
![Travis](https://img.shields.io/badge/llicense-MIT-green.svg)
![Travis](https://img.shields.io/badge/build-passing-green.svg)

#### 更多交流请加微信公众号
![](https://upload-images.jianshu.io/upload_images/4361802-88c89753c38ddf70.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###  推荐文件
>Android X库之前版本可使用Collection-Android：[https://juejin.im/post/6844903585227112462](https://juejin.im/post/6844903585227112462)

> Collection-iOS库:[https://juejin.im/post/6844904062786207751](https://juejin.im/post/6844904062786207751)

> Collection-kotlin库:[https://www.jianshu.com/p/a6cb49532760](https://www.jianshu.com/p/a6cb49532760)

###  Mvpprocessor其它地址
> ######  简书：https://www.jianshu.com/p/5eef120714fe
> ######  掘金地址：https://juejin.im/post/6882950031213592590/


> Mvpprocessor主要是解决使用MVP的使用需要手动进行创建对应的文件问题，提供通过注解快速生成对应文件，该项目主要是配合框架Collection-kotlin(github地址：[https://github.com/usernameyangyan/Collection-Android-kotlin](https://github.com/usernameyangyan/Collection-Android-kotlin))进行开发

> ###### github地址：[https://github.com/usernameyangyan/MvpAnnotationProject](https://github.com/usernameyangyan/MvpAnnotationProject)

###  更新说明
#### v1.0.0
> 1.增加V模块和P模块的文件通过注解方式快速生成
> 2.生成的文件支持生成java和kotlin


###  框架的引入

kotlin项目引入：
>  implementation 'com.youngman.mvp:mvpprocessor:1.0.0'
>  kapt 'com.youngman.mvp:mvpprocessor:1.0.0'

java项目引入：
>  implementation 'com.youngman.mvp:mvpprocessor:1.0.0'
>  annotationProcessor 'com.youngman.mvp:mvpprocessor:1.0.0'

#### 注解MvpAnnotation属性介绍
| 属性 | 作用 | 
| :-----| :---- | 
|prefixName | 模块的功能名称，会根据这个名字生成对应的xxxPresenter 、IxxxView|
|basePresenterClazz | 要生成的presenter类的父类|
|baseViewClazz | 需要生成的view接口的父类|
|language | 选择生成java文件还是kotlin文件,默认生成kotlin文件|

#### 结合框架Collection-kotlin使用流程
#####  (1)使用前配置（app中的build.gradle）
    defaultConfig {
        applicationId "com.yang.mvp.annotation"
        minSdkVersion 19
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled true

        //使用需要配置的地方
        javaCompileOptions{
            annotationProcessorOptions{
                includeCompileClasspath = true
                arguments = ["mvp_create_package_path": "com.yang.mvp.annotation",
                             "project_java_path" : file("src/main/java").getAbsolutePath()]
            }
        }
    }

- mvp_create_package_path：项目包结构路径，一般和包名一致
- project_java_path：项目java模块的绝对路径
#####  (2)代码使用

    @MvpAnnotation(prefixName = "Main"
    ,basePresenterClazz = BasePresenter::class
    ,baseViewClazz = BaseView::class)
    class MainActivity:IBaseActivity<MainPresenter>(),IMainView {
    }

  #####  (3)生成文件结构
![](https://upload-images.jianshu.io/upload_images/4361802-627961a8d644691f.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

  #####  (4)MainPresenter

    class MainPresenter : BasePresenter<IMainView>() { 
    }

 #####  (5)IMainView

    interface IMainView :BaseView{
    }


####  本文章会根据需要持续更新，建议点赞收藏，便于查看。也欢迎大家提出更多建议。

