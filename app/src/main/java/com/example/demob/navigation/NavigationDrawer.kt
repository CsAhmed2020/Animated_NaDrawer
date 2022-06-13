package com.example.demob.navigation


import androidx.compose.foundation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.demob.R
import com.example.demob.ui.theme.ContentColor
import com.example.demob.ui.theme.ImageStrockColor



@ExperimentalMaterial3Api
@Composable
fun NavigationDrawer(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        contentAlignment = Alignment.TopCenter
                    ){
                        Image(painter = painterResource(id =R.drawable.avatar), contentDescription = "profile Image",
                            modifier = Modifier
                                .border(width = 2.dp, color = ImageStrockColor, shape = CircleShape)
                                .size(60.dp))

                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_monochrome_photos_24),
                            contentDescription ="Pick Image",
                            tint = ContentColor,
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color.Transparent)
                                .align(alignment = Alignment.BottomCenter)
                                .offset(x = (20).dp))

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "أحمد عبدالرحمن",
                        color = ContentColor,
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "مطور تطبيقات الأندرويد",color = ContentColor)
                }

            }
            NavigationItem(
                resId = R.drawable.ic_baseline_home_24,
                text = stringResource(R.string.home),
                itemColor = ImageStrockColor,
                topPadding = 10.dp
            ) {
                navController.navigate(route = Screen.HomeScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_task_alt_24,
                text = stringResource(R.string.tasks)
            ) {
                navController.navigate(route = Screen.TasksScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_video_call_24,
                text = stringResource(R.string.video)
            ) {
                navController.navigate(route = Screen.LiveScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_call_24,
                text = stringResource(id = R.string.call)
            ) {
                navController.navigate(route = Screen.CallScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_home_24,
                text = stringResource(R.string.home),
                topPadding = 20.dp
            ) {
                navController.navigate(route = Screen.HomeScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_task_alt_24,
                text = stringResource(R.string.tasks)
            ) {
                navController.navigate(route = Screen.TasksScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_video_call_24,
                text = stringResource(R.string.video)
            ) {
                navController.navigate(route = Screen.LiveScreen.route)
            }
            NavigationItem(
                resId = R.drawable.ic_baseline_call_24,
                text = stringResource(id = R.string.call)
            ) {
                navController.navigate(route = Screen.CallScreen.route)
            }

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomStart)
            .background(MaterialTheme.colorScheme.secondary)
            )
        {
            Text(text =stringResource(id = R.string.closeDrawer),
                color = ContentColor,
            modifier = Modifier.padding(vertical = 10.dp,horizontal = 8.dp))
        }

    }


}