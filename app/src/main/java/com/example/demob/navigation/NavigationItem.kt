package com.example.demob.navigation


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.demob.ui.theme.ContentColor
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.google.accompanist.flowlayout.MainAxisAlignment


@ExperimentalMaterial3Api
@Composable
fun NavigationItem(
    resId: Int,
    text: String,
    topPadding: Dp = 10.dp,
    itemColor:Color = ContentColor,
    itemClicked: () -> Unit
) {
    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = topPadding)
            .clickable { itemClicked() }
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 8.dp,
            mainAxisSize = SizeMode.Wrap,
            mainAxisAlignment = MainAxisAlignment.End
        ){
            AssistChip(
                onClick = { },
                colors = AssistChipDefaults.assistChipColors(
                    trailingIconContentColor = itemColor,
                ),
                border = AssistChipDefaults.assistChipBorder(
                    borderWidth = 0.dp,
                    borderColor = Color.Transparent
                ),
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = resId),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(text = text,color = itemColor)
                }
            )
        }
    }
}