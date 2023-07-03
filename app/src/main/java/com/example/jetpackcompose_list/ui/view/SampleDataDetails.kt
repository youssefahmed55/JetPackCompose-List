package com.example.jetpackcompose_list.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_list.R
import com.example.jetpackcompose_list.response.SampleData
import com.example.jetpackcompose_list.ui.theme.Purple40
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Preview(showBackground = true, device = "id:Nexus One")
@Composable
fun SampleDataDetails(data: SampleData = SampleData("java", "Programming Language")) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.sdp)
                .background(Purple40)
                .wrapContentSize(Alignment.Center),
            text = "Jetpack Compose List Details",
            color = Color.White,
            fontSize = 20.ssp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(20.sdp))
        Image(
            modifier = Modifier
                .width(70.sdp)
                .height(70.sdp)
                .clip(RoundedCornerShape(5.sdp)),
            painter = painterResource(id = R.drawable.baseline_code_24),
            contentDescription = "image"
        )

        Spacer(modifier = Modifier.padding(15.sdp))

        Text(text = data.name, fontSize = 15.ssp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.padding(10.sdp))
        Text(
            text = data.desc,
            fontSize = 15.ssp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )

    }

}