package com.example.jetpackcompose_list.ui.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.jetpackcompose_list.R
import com.example.jetpackcompose_list.response.SampleData
import com.example.jetpackcompose_list.ui.theme.Purple40
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Preview(showBackground = true, device = "id:Nexus One")
@Composable
fun SampleList(navController: NavController? = null) {

    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "Data.json")
    val gson = Gson()
    val listSampleType = object : TypeToken<List<SampleData>>() {}.type
    var sampleData: List<SampleData> = gson.fromJson(dataFileString, listSampleType)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.sdp)
                .background(Purple40)
                .wrapContentSize(Alignment.Center),
            text = "List With JetPackCompose",
            color = Color.White,
            fontSize = 20.ssp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(modifier = Modifier.padding(10.sdp)) {
            items(sampleData) { data ->
                SampleDataListItem(data, navController)
            }
        }

    }


}

@Composable
fun SampleDataListItem(data: SampleData, navController: NavController?) {
    Card(modifier = Modifier
        .clickable {
            val itemVal = Gson().toJson(data)
            navController?.navigate("sample_detail/${itemVal}")
        }
        .padding(10.sdp)
        .wrapContentSize(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.sdp),
        shape = RoundedCornerShape(5.sdp)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .width(70.sdp)
                    .height(70.sdp)
                    .clip(RoundedCornerShape(5.sdp)),
                painter = painterResource(id = R.drawable.baseline_code_24),
                contentDescription = "image"
            )

            Column(modifier = Modifier.padding(10.sdp)) {
                Text(text = data.name, fontSize = 15.ssp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(5.sdp))
                Text(text = data.desc, fontSize = 15.ssp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}
