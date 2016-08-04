package com.example.hadis.summary.interfaces;

import rx.functions.Func1;

/**
 * @author hadis on 16.7.26.
 */

//例子结构：
//{
//        "resultCode": 0,
//        "resultMessage": "成功",
//        "data": {}
//        }
//
//        我们想要对resultCode和resultMessage先做一个判断，因为如果resultCode == 0代表success，那么resultCode != 0时data一般都是null。
//
//        Activity或Fragment对resultCode和resultMessage基本没有兴趣，他们只对请求状态和data数据感兴趣。
//
//        基于这种考虑，我们在resultCode != 0的时候，抛出个自定义的ApiException。这样就会进入到subscriber的onError中，我们可以在onError中处理错误信息。
//
//        另外，请求成功时，需要将data数据转换为目标数据类型传递给subscriber，因为，Activity和Fragment只想拿到和他们真正相关的数据。
//
//        使用Observable的map方法可以完成这一功能。
//
//        在HttpMethods中创建一个内部类HttpResultFunc，代码如下：
//
///**
// * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
// *
// * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
// */
public class HttpResultFunc<T> implements Func1<HttpNewsResult<T>, T> {

    @Override
    public T call(HttpNewsResult<T> httpNewsResult) {

//        if (httpNewsResult.getStatus() != 1) {
////            new ApiException(httpResult.getResultCode());
//            throw new ApiException(httpNewsResult.getStatus());//这里ApiException是自定义的，不知道怎么搞。。等等吧
//        }
//        return httpNewsResult.getData();


        return httpNewsResult.getData();
    }
}
