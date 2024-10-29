package com.example.businesscard

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFC9F0E3))
            .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(modifier = Modifier.width(40.dp))
        Row() {
            BusinessCardMain(
                fullName = stringResource(id = R.string.full_name),
                title = stringResource(id = R.string.title)
            )
        }
        Row {
            BusinessCardContact()
        }
    }
}

@Composable
private fun BusinessCardMain(
    fullName: String,
    title: String,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.card_logo),
            contentDescription = "Business Card Logo",
            modifier = Modifier.width(80.dp)
        )
        Text(
            text = fullName,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(top = 6.dp, bottom = 6.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFA7745B),
        )
    }
}

@Composable
private fun BusinessCardContact() {
    Column(modifier = Modifier.fillMaxWidth()) {
        BusinessCardContactItem(
            iconPainter = painterResource(id = R.drawable.mobile),
            text = stringResource(id = R.string.mobile),
        )
        BusinessCardContactItem(
            iconPainter = painterResource(id = R.drawable.email),
            text = stringResource(id = R.string.email),
        )
        BusinessCardContactItem(
            iconPainter = painterResource(id = R.drawable.website),
            text = stringResource(id = R.string.website),
        )
    }
}

@Composable
private fun BusinessCardContactItem(
    iconPainter: Painter,
    text: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 15.dp, start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BusinessCardContactIcon(
            iconPainter = iconPainter,
        )
        BusinessCardContactText(
            text = text,
        )
    }
}


@Composable
private fun BusinessCardContactIcon(
    iconPainter: Painter,
) {
    Icon(
        painter = iconPainter,
        contentDescription = "Interface Icon",
        tint = Color(0xFFA7745B),
        modifier = Modifier
            .width(24.dp)
            .height(24.dp)
    )
}

@Composable
private fun BusinessCardContactText(
    text: String,
) {
    Text(
        text = text,
        color = Color.DarkGray,
        fontSize = 18.sp,
        modifier = Modifier.padding(start = 30.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}