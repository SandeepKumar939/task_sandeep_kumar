package com.example.unify_task_sandeep_kumar.screens

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unify_task_sandeep_kumar.R
import com.example.unify_task_sandeep_kumar.utils.AppConstants
import com.example.unify_task_sandeep_kumar.model.User
import com.example.unify_task_sandeep_kumar.ui.theme.Unify_Task_Sandeep_KumarTheme
import com.example.unify_task_sandeep_kumar.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Unify_Task_Sandeep_KumarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * hide status bar
                     */
                    WindowCompat.setDecorFitsSystemWindows(window, false)
                    window.setFlags(
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    )

                    MyApp()
                }
            }
        }
    }

    @Composable
    fun MyApp() {


        /**
         * here initializing  user view model
         * Here consume the flow of user data from user view model,
         * the below code is for populating the data as list
         * below code is commenting
         */
        val userViewModel: UserViewModel = viewModel()
        val users: State<List<User>> = userViewModel.users.collectAsState()
        Log.d("DATA", users.value.toString())


//        LazyColumn(content = {
//            items(users.value.size) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(20.dp, 8.dp, 20.dp, 8.dp),
//                    colors = CardDefaults.cardColors(Color.White),
//                    elevation = CardDefaults.cardElevation(8.dp)
//                ) {
//                    Text(
//                        text = users.value[it].name,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp),
//                        style = MaterialTheme.typography.bodyLarge,
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//        })

        /**
         *the below code is for UI
         */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(
                    enabled = true,
                    state = rememberScrollState()
                )
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 8.dp, 8.dp, 8.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "9:41", modifier = Modifier.padding(20.dp, 8.dp, 20.dp, 8.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Box(modifier = Modifier.padding(0.dp, 8.dp, 20.dp, 8.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_signal_cellular_alt_24),
                                    contentDescription = "left arrow",


                                    )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_wifi_24),
                                    contentDescription = "left arrow",


                                    )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_battery_full_24),
                                    contentDescription = "left arrow",
                                    modifier = Modifier.rotate(90f)

                                )

                            }
                        }

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.top_back),
                            contentDescription = "left arrow",
                            modifier = Modifier.padding(20.dp, 0.dp, 8.dp, 0.dp)
                        )
                        Text(
                            text = "Mandate  Details",
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 0.dp, 0.dp, 8.dp),
                            textAlign = TextAlign.Center
                        )
                    }

                }

            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .wrapContentHeight()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(Color.White),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()

                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            TextComponent(
                                AppConstants.validTill, 12.sp, Color.Black, FontWeight.Normal
                            )
                            TextComponent(
                                AppConstants.validTillValue, 12.sp, Color.Black, FontWeight.Bold
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            TextComponent(
                                AppConstants.upToAmount, 12.sp, Color.Black, FontWeight.Normal
                            )
                            TextComponent(
                                AppConstants.upToAmountValue, 12.sp, Color.Black, FontWeight.Bold
                            )
                        }


                    }
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .fillMaxSize()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    ) {
                        TextComponent(
                            AppConstants.frequency, 12.sp, Color.Black, FontWeight.Normal
                        )
                        TextComponent(
                            AppConstants.frequencyValue, 12.sp, Color.Black, FontWeight.Bold
                        )
                    }
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(colorResource(R.color.info_color))

                    ) {

                        Row(
                            modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_info_24),
                                contentDescription = "info",
                                modifier = Modifier.padding(0.dp, 0.dp, 5.dp, 0.dp)
                            )
                            BoldLastWordCompose()
                        }
                    }

                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
            ) {
                TextComponent(
                    AppConstants.autoPaymentOptoions, 14.sp, Color.Black, FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier
                        .size(130.dp)
                        .padding(20.dp)
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .border(
                            BorderStroke(2.dp, colorResource(id = R.color.card_stroke_color)),
                            shape = MaterialTheme.shapes.medium
                        ),
                    elevation = CardDefaults.cardElevation(20.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.airtel_card_color)),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.airtel),
                        contentDescription = "payment option image",
                        modifier = Modifier
                            .size(160.dp)
                            .padding(8.dp),

                        )
                }

                CardComponent(imageResource = R.drawable.fp)
                CardComponent(imageResource = R.drawable.mtn)

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
            ) {
                TextComponent(
                    AppConstants.payUsing, 14.sp, Color.Black, FontWeight.Bold
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 8.dp, 20.dp, 20.dp)
                    .border(
                        BorderStroke(0.1.dp, colorResource(id = R.color.card_stroke_color)),
                        shape = MaterialTheme.shapes.medium
                    ),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(Color.White),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.airtel_logo),
                            contentDescription = "right arrow",
                            modifier = Modifier.size(24.dp)
                        )

                        TextComponent(
                            AppConstants.airtelMoney, 14.sp, Color.Black, FontWeight.Normal
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.baseline_chevron_right_24),
                        contentDescription = "right arrow"
                    )

                }
            }
        }


    }

    @Composable
    fun BoldLastWordCompose() {
        val text by remember { mutableStateOf(AppConstants.info) }

        val words = text.split(" ")
        val lastWord = words.takeLast(2).joinToString(" ")

        val annotatedText = buildAnnotatedString {

            append("")
            append(words.dropLast(2).joinToString(" "))
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(" $lastWord")
            }
        }

        Text(
            text = annotatedText, fontSize = 12.sp, color = Color.Black
        )
    }


    @Composable
    @Preview(showBackground = true)
    fun MyAppPreview() {
        MyApp()
    }


}

