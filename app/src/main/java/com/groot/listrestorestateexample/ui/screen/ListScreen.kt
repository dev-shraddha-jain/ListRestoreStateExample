package com.groot.listrestorestateexample.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.groot.listrestorestateexample.dto.Quote
import com.groot.listrestorestateexample.navigation.NavDest
import com.groot.listrestorestateexample.navigation.navigate
import com.groot.listrestorestateexample.ui.component.RestorableLazyColumn
import com.groot.listrestorestateexample.vm.QuotesViewModel
import com.groot.listrestorestateexample.vm.ScrollPositionViewModel


@Composable
fun ListScreen(
    navController: NavController,
    scrollVm: ScrollPositionViewModel = viewModel(),
    quotesVm: QuotesViewModel = viewModel()
) {

    val list = quotesVm.quoteList.collectAsStateWithLifecycle()
    val listLoadingState = quotesVm.listLoadingState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            RestorableLazyColumn(
                viewModel = scrollVm,
                listLoadingState = listLoadingState,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                itemsIndexed(list.value ?: listOf()) { index: Int, item: Quote ->
                    Row(
                        modifier = Modifier
                            .height(45.dp)
                            .clickable {
                                navigate(navController, item, NavDest.listScreen, NavDest.detailScreen, false)
                            }
                    ) {
                        Text(
                            text = "$index :  ${item.text}",
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    }

                    HorizontalDivider()
                }
            }
        }
    }
}
