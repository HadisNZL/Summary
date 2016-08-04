package com.example.hadis.summary.utils;

import android.text.TextUtils;

import com.example.hadis.summary.bean.LoginResultBean;
import com.google.gson.Gson;

/**
 * @author hadis on 16.4.19.
 */
public class ParserBase {

    public static LoginResultBean.T parserTFromJson(String pJsonStr, Class pClass) {

        LoginResultBean.T _T;

        try {

            if (!TextUtils.isEmpty(pJsonStr)) {

                Gson _Gson = new Gson();

                _T = (LoginResultBean.T) _Gson.fromJson(pJsonStr, pClass);

            } else {

                _T = null;

            }

        } catch (Exception e) {

            e.printStackTrace();

            _T = null;

        }

        return _T;

    }
}
