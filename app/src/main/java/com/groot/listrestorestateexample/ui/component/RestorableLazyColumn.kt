package com.groot.listrestorestateexample.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.groot.listrestorestateexample.dto.ListLoadingState
import com.groot.listrestorestateexample.vm.ScrollPositionViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged


@Composable
fun RestorableLazyColumn(
    modifier: Modifier = Modifier,
    viewModel: ScrollPositionViewModel,
    listLoadingState: State<ListLoadingState>,
    content: LazyListScope.() -> Unit,
) {
    val listState = rememberLazyListState()
    val hasRestoredScroll = rememberSaveable { mutableStateOf(false) }

    // Restore scroll once when recomposed and items are loaded
    LaunchedEffect(hasRestoredScroll.value) {
        if (!hasRestoredScroll.value) {
            listState.scrollToItem(
                viewModel.scrollIndex.value,
                viewModel.scrollOffset.value
            )
            hasRestoredScroll.value = true
        }
    }

    // Save scroll state on scroll change
    LaunchedEffect(listState) {
        snapshotFlow {
            listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset
        }
            .distinctUntilChanged()
            .collectLatest { (index, offset) ->
                viewModel.saveScrollPosition(index, offset)
            }
    }


    when (listLoadingState.value) {
        ListLoadingState.COMPLETED -> {
            LazyColumn(
                state = listState,
                modifier = modifier,
                content = content
            )
        }

        ListLoadingState.NO_RECORD_FOUND -> {
            //show no record found
        }

        else -> {
            //show loader
        }
    }

}
