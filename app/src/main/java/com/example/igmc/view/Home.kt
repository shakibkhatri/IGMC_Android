package com.example.igmc.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.igmc.R
import kotlinx.coroutines.delay

@Composable
fun Home(){

    Column(
        modifier = Modifier
            .padding(12.dp),
        Arrangement.Top,
        Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.logo), contentDescription = "Logo")
        Text(text = "IGMC", fontSize = 50.sp)

        Spacer(modifier = Modifier.padding(30.dp))

        var images = listOf(R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4)
        ImageAnimation(imageList = images)
    }


}
    @Composable
    fun ImageAnimation(imageList: List<Int>) {

        var currentImage by remember {
            mutableStateOf(0)
        }
        LaunchedEffect(Unit) {
            while (true) {
                delay(2000L)
                currentImage = (currentImage + 1) % imageList.size
            }
        }
        val imagePainter = painterResource(id = imageList[currentImage])
        Image(painter = imagePainter, contentDescription = null)

    }