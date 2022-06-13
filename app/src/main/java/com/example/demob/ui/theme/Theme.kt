package com.example.demob.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val LightColorPalette = lightColorScheme(
    primary = IconBack,
    onPrimary = Color.White,
    secondary = ContainerBackground,
    onSecondary = Color.White,
    primaryContainer = ContainerBackground,
    onPrimaryContainer = Color.White,
    background = BackgroundColor,
    onBackground = Color.White
)

@Composable
fun DemoBTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val useDynamicColors = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors =
        when {
            useDynamicColors && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
            useDynamicColors && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
            else -> LightColorPalette
        }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}