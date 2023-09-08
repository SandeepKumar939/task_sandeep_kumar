package com.example.unify_task_sandeep_kumar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
) {


    Text(
        text = textValue,
        fontSize = textSize,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = fontWeight,
        color = colorValue
    )

}

@Composable
fun CardComponent(imageResource: Int) {


    Card(
        modifier = Modifier
            .size(130.dp)
            .padding(20.dp)
            .wrapContentHeight()
            .wrapContentWidth()
            .background(color = Color.White),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "payment option image",
            modifier = Modifier
                .size(160.dp)
                .padding(8.dp),

            )
    }
}