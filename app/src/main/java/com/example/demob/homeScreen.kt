package com.example.demob

import android.widget.TextView
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.navigation.NavHostController
import com.example.demob.navigation.NavigationDrawer

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavHostController){

    val scaffoldState = rememberScaffoldState()

    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState)
    {
        NavigationDrawer(navController = navController)
        BodyContent( scaffoldState = scaffoldState,navController = navController)
    }

}

@ExperimentalMaterial3Api
@Composable
fun BodyContent(scaffoldState: ScaffoldState, navController: NavHostController) {
    var navigateClick by remember { mutableStateOf(false) }
    val offSetAnim by animateDpAsState(targetValue = if (navigateClick) -(120).dp else 0.dp)
    val scaleAnim by animateFloatAsState(targetValue = if (navigateClick) 0.5f else 1.0f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scale(scaleAnim)
            .offset(x = offSetAnim)
            .clip(if (navigateClick) RoundedCornerShape(30.dp) else RoundedCornerShape(0.dp))
            .background(MaterialTheme.colorScheme.onBackground)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 10.dp),
            horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navigateClick = !navigateClick
            }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "navigate icon",tint = MaterialTheme.colorScheme.primary)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = MaterialTheme.shapes.medium.copy(all = CornerSize(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxWidth()
                ) {
                    AndroidView(
                        factory = { context ->
                            TextView(context).apply {
                                text = HtmlCompat.fromHtml("<string><big><b><span style = \"color:#FFFFFF\">Don't miss this offer </span><span style = \"color:#191D11\">    60%  </span></b></big></string>",
                                    HtmlCompat.FROM_HTML_MODE_LEGACY)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .width(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Text(
                            text = "Get Now",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.6f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.offer_image),
                        contentDescription = "Delivery Image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Categories",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(modifier = Modifier.padding(horizontal = 10.dp))
        {
            items(8) { index ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            if (index == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer
                        )
                        .wrapContentWidth()
                ) {
                    FilterChip(selected = index == 0,
                        modifier = Modifier.fillMaxWidth(),
                        colors = FilterChipDefaults.filterChipColors(
                            labelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            selectedContainerColor = MaterialTheme.colorScheme.primary
                        ),
                        border = FilterChipDefaults.filterChipBorder(
                            borderWidth = 0.dp,
                            borderColor = Color.Transparent,
                        ),
                        onClick = {},
                        leadingIcon = {
                            Image(
                                painter = painterResource(
                                    id = when(index) {
                                        0  -> R.drawable.men
                                        1  -> R.drawable.men
                                        2 -> R.drawable.women
                                        3 -> R.drawable.children
                                        else -> R.drawable.bags
                                    }
                                ),
                                contentDescription = "Category Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                            )
                        },
                        label = {
                            Text(
                                text = when(index) {
                                    0 -> "All"
                                    1 -> "Men"
                                    2 -> "Women"
                                    3-> "Children"
                                    else -> "Bags"
                                },
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow{
            items(8) { index ->
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .wrapContentHeight()
                        .padding(start = 5.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(
                                id = when(index){
                                    0 -> R.drawable.jacket
                                    1 -> R.drawable.men
                                    3 -> R.drawable.bags
                                    4 -> R.drawable.coat
                                    else -> R.drawable.children
                                }
                            ),
                            contentDescription = "Category Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(120.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = when (index) {
                                0 -> "Mens Jacket"
                                1 -> "Summer Shirt"
                                3 -> "Laptop Bag"
                                4 -> "Winter Coat"
                                else -> "Baby Shirt"
                            },
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        AndroidView(
                            factory = { context ->
                                TextView(context).apply {
                                    text = if (index % 2 == 0) {
                                        HtmlCompat.fromHtml("<string><b><span style = \"color:#000000\"><big><big>200 </big></big></span><span style = \"color:#F54748\"><big> L.E </big></span></b></string>",
                                            HtmlCompat.FROM_HTML_MODE_LEGACY)
                                    } else {
                                        HtmlCompat.fromHtml("<string><b><span style = \"color:#000000\"><big><big>300 </big></big></span><span style = \"color:#F54748\"><big> L.E </big></span></b></string>",
                                            HtmlCompat.FROM_HTML_MODE_LEGACY)
                                    }
                                }
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                text = "Best Sale",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 10.dp)
            )
            AssistChip(
                onClick = {},
                label = {
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription ="View All Icon")
                },
                colors = AssistChipDefaults.assistChipColors(
                    trailingIconContentColor = MaterialTheme.colorScheme.primary,
                    labelColor = MaterialTheme.colorScheme.primary
                ),
                border = AssistChipDefaults.assistChipBorder(
                    borderColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow{
            items(8) { index ->
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .wrapContentHeight()
                        .padding(start = 5.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(
                                id = when(index){
                                    0 -> R.drawable.children
                                    1 -> R.drawable.women
                                    3 -> R.drawable.men
                                    4 -> R.drawable.coat
                                    else -> R.drawable.jacket
                                }
                            ),
                            contentDescription = "Category Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(120.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = when (index) {
                                0 -> "Baby Shirt"
                                1 -> "Summer Dress"
                                3 -> "Summer Shirt"
                                4 -> "Winter Coat"
                                else -> "Mens Jacket"
                            },
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        AndroidView(
                            factory = { context ->
                                TextView(context).apply {
                                    text = if (index % 2 == 0) {
                                        HtmlCompat.fromHtml("<string><b><span style = \"color:#000000\"><big><big>200 </big></big></span><span style = \"color:#F54748\"><big> L.E </big></span></b></string>",
                                            HtmlCompat.FROM_HTML_MODE_LEGACY)
                                    } else {
                                        HtmlCompat.fromHtml("<string><b><span style = \"color:#000000\"><big><big>300 </big></big></span><span style = \"color:#F54748\"><big> L.E </big></span></b></string>",
                                            HtmlCompat.FROM_HTML_MODE_LEGACY)
                                    }
                                }
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}