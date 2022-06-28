package com.emalober.borutoapp.presentation.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.emalober.borutoapp.R
import com.emalober.borutoapp.ui.theme.BorutoAppTheme
import com.emalober.borutoapp.ui.theme.Purple500
import com.emalober.borutoapp.ui.theme.Purple700

@Composable
fun SplashScreen() {
    Splash()
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(
                if (isSystemInDarkTheme()) {
                    Brush.verticalGradient(listOf(Purple700, Color.Black))
                } else {
                    Brush.verticalGradient(listOf(Purple700, Purple500))
                }
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_logo)
        )
    }
}

@Composable
@Preview
fun SplashPreview() {
    BorutoAppTheme {
        Splash()
    }
}
@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashDarkPreview() {
    BorutoAppTheme {
        Splash()
    }
}