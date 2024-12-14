package com.example.igmc.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.igmc.R
import com.example.igmc.data.NavItem
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun HomeScreen() {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home,0),
        NavItem("News", Icons.Default.Notifications,5),
        NavItem("Join", Icons.Default.Add,0),
        NavItem("Friens", Icons.Default.Place,0)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        NavigationBar {
            navItemList.forEachIndexed { index, navItem ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {
                              selectedIndex = index
                    },
                    icon = {
                        BadgedBox(badge = {
                            if (navItem.badgeCount > 0)
                            Badge(){
                                Text(text = navItem.badgeCount.toString())
                            }
                        }) {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        }

                         },
                    label = {
                        Text(text = navItem.label)
                    })
            }
        }
    })
    { innerpadding ->
        ContentScreen(modifier = Modifier  .padding(innerpadding), selectedIndex)
    }

}



@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int ){
when(selectedIndex){
    0 -> Home()
    1 -> News()
    2 -> Join()
    3 -> AboutUs()
    }
}