package com.example.jetpackcompose_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose_list.response.SampleData
import com.example.jetpackcompose_list.ui.theme.JetPackComposeListTheme
import com.example.jetpackcompose_list.ui.view.SampleDataDetails
import com.example.jetpackcompose_list.ui.view.SampleList
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeListTheme {
                NavigatePage()
            }
        }
    }
}

@Preview(showBackground = true, device = "id:Nexus One")
@Composable
fun NavigatePage() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "sample_data") {
        composable("sample_data") { SampleList(navHostController) }
        composable("sample_detail/{item}", arguments = listOf(
            navArgument("item") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            navBackStackEntry?.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, SampleData::class.java)
                SampleDataDetails(data = item)
            }

        }
    }

}

