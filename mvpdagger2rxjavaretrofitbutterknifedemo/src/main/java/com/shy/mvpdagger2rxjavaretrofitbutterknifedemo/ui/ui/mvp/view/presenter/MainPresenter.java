package com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view.presenter;

import android.util.Log;

import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.Bean.News;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.MyKey;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.NetWork.NewsApiService;
import com.shy.mvpdagger2rxjavaretrofitbutterknifedemo.ui.ui.mvp.view.MainView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * Created by ShangHongYu on 2017/3/1.
 */

public class MainPresenter {
    private MainView mainView;
    private  NewsApiService newsApiService;
    public MainPresenter(MainView mainView, NewsApiService newsApiService) {
        this.mainView = mainView;
        this.newsApiService=newsApiService;
    }
    public void getNews(){
        newsApiService.getNews(MyKey.MYKEY,20,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mainView.onError(e.toString());
                    }

                    @Override
                    public void onNext(News news) {
                        Log.i("tag", "onNext: "+news);
                        mainView.onSuccess(news);
                    }
                });
    }
}
