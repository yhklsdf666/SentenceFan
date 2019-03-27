package com.yhklsdf.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yhklsdf.R
import com.yhklsdf.mvp.model.YiYanSentence

class SentenceAdapter(private val context : Context?,data : MutableList<YiYanSentence>)
    :BaseQuickAdapter<YiYanSentence,BaseViewHolder>(R.layout.item_sentence_list,data){
    override fun convert(helper: BaseViewHolder?, item: YiYanSentence?) {
        helper ?: return
        item ?: return
        helper.setText(R.id.tv_sentence,item.sentence)
    }
}