package com.yhklsdf.mvp.model.bean

import cn.bmob.v3.BmobUser

data class User(
        var name : String,
        var headPortrait : String
) : BmobUser()