package com.thechance.task_week9

fun PostModel.toHomeItem(): HomeItem<Any> {
    return HomeItem(this, HomeItemType.TYPE_POST)
}