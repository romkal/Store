package org.mobilenativefoundation.store.notes.android.lib.fig

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import org.mobilenativefoundation.store.notes.android.lib.fig.color.Colors
import org.mobilenativefoundation.store.notes.android.lib.fig.color.LocalColors
import org.mobilenativefoundation.store.notes.android.lib.fig.color.asMaterialColors
import org.mobilenativefoundation.store.notes.android.lib.fig.color.updateColorsFrom
import org.mobilenativefoundation.store.notes.android.lib.fig.shape.LocalShapes
import org.mobilenativefoundation.store.notes.android.lib.fig.typography.LocalTypography
import org.mobilenativefoundation.store.notes.android.lib.fig.typography.Typography
import org.mobilenativefoundation.store.notes.android.lib.fig.typography.asMaterialTypography

@Composable
fun FigTheme(
    typography: Typography = Fig.Typography,
    colors: Colors = Fig.Colors,
    shapes: Shapes = Fig.Shapes,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography,
        LocalShapes provides shapes
    ) {
        MaterialTheme(
            colors = rememberedColors.asMaterialColors(),
            typography = typography.asMaterialTypography(),
            shapes = shapes,
            content = content
        )
    }
}