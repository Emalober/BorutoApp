package com.emalober.borutoapp.presentation.home


import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
) {
    HomeContent {}
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeContent(
    onSearchClicked: () -> Unit
) {

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = onSearchClicked
            )
        }
    ) {}
}

@Composable
@Preview
fun HomeContentPreview() {
    HomeContent {}
}
