package com.yang.mvp.annotation.activity
import com.mvp.annotation.MvpAnnotation
import com.yang.mvp.annotation.R
import com.yang.mvp.annotation.mvp.presenter.MainPresenter
import com.yang.mvp.annotation.mvp.view.IMainView
import com.youngmanster.collection_kotlin.base.baseview.IBaseActivity
import com.youngmanster.collection_kotlin.mvp.BasePresenter
import com.youngmanster.collection_kotlin.mvp.BaseView

/**
 * Created by yangy
 *2020/10/12
 *Describe:
 */
@MvpAnnotation(prefixName = "Main"
    ,basePresenterClazz = BasePresenter::class
    ,baseViewClazz = BaseView::class)
class MainActivity:IBaseActivity<MainPresenter>(),IMainView {
    /**
     * 布局文件加载
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    /**
     * 初始化参数
     */
    override fun init() {
        defineActionBarConfig
            .setTitleColor(this,R.color.white)
            .hideBackBtn()
            .setTitle("MVP注解快速生成")
    }

    /**
     * 请求数据
     */
    override fun requestData() {

    }

    override fun onError(errorMsg: String) {

    }


}