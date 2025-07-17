package com.groot.listrestorestateexample.vm

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel


class ScrollPositionViewModel(
) : ViewModel() {

    var scrollIndex = mutableIntStateOf(0)
    var scrollOffset = mutableIntStateOf(0)

    fun saveScrollPosition(index: Int, offset: Int) {
        if (scrollIndex.intValue != index || scrollOffset.intValue != offset) {
            scrollIndex.intValue = index
            scrollOffset.intValue = offset
        }
    }
}