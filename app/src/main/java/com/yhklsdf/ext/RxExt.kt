package com.yhklsdf.ext

import com.yhklsdf.app.App
import com.yhklsdf.base.IModel
import com.yhklsdf.base.IView
import com.yhklsdf.rx.SchedulerUtils
import com.yhklsdf.utils.NetworkUtil
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.sr(
        model : IModel?,
        view : IView?,
        isShowLoading : Boolean = true,
        onSuccess : (T) -> Unit
) {
    val subscribe: Any = this.compose(SchedulerUtils.ioToMain())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                    view?.hideLoading()
                }

                override fun onSubscribe(d: Disposable) {
                    if (isShowLoading) {
                        view?.showLoading()
                    }
                    model?.addDisposable(d)
                    if (!NetworkUtil.isNetworkAvailable(App.instance)) {
                        onComplete()
                    }
                }

                override fun onNext(t: T) {
                    onSuccess.invoke(t)
                }

                override fun onError(e: Throwable) {
                    view?.hideLoading()
                    //TODO 加网络错误处理类
                    view?.showError("好像出问题了呢！")
                }
            })
}