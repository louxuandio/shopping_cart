package com.example.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingcart.ui.theme.ShoppingCartTheme
import kotlinx.coroutines.launch
//reference: My shopping cart on Amazon
//I finish this one very quickly, basically just copy some code pieces from the previous projects and do some revise

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ){
                    Text("Dio's Shopping Cart",
                        modifier = Modifier.padding(16.dp),
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        ))
                    Row (
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Image(
                            painter = painterResource(com.example.shoppingcart.R.drawable.bagimage),
                            contentDescription = "item Photo1",
                            modifier = Modifier
                                .size(80.dp)
                        )
                        Column (
                            modifier = Modifier.padding(24.dp),
                            verticalArrangement = Arrangement.Center
                        ){
                            Text("15 XX-Large Plastic Storage Bags",
                                modifier = Modifier)
                            Text("$23.99",
                                modifier = Modifier,
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }

                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        color = Color.Gray,
                        thickness = 1.dp)

                    Row (
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Image(
                            painter = painterResource(com.example.shoppingcart.R.drawable.instax),
                            contentDescription = "item Photo2",
                            modifier = Modifier
                                .size(80.dp)
                        )
                        Column (
                            modifier = Modifier.padding(24.dp),
                            verticalArrangement = Arrangement.Center
                        ){
                            Text("Fujifilm Instax Mini Instant Camera Film",
                                modifier = Modifier)
                            Text("$44.79",
                                modifier = Modifier,
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        color = Color.Gray,
                        thickness = 1.dp)
                    Text("Subtotal $71.94",
                        modifier = Modifier.padding(16.dp),
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    //The next part is copied from the Profile project, and I just changed the texts and color
                    val scope = rememberCoroutineScope()
                    var checkout = remember { mutableStateOf(false) }
                    val snackbarHostState = remember { SnackbarHostState() }

                    Button(
                        onClick = {
                            //snackbar written by ChatGPT
                            scope.launch {
                                snackbarHostState.showSnackbar("Orderd")
                            }
                            checkout.value = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            //color code by ChatGPT
                            containerColor = if (checkout.value) Color.Transparent else Color.Green,
                            contentColor = if (checkout.value) Color.Gray else Color.Black
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (checkout.value) "Thank You for your ordering!" else "Checkout")
                    }

                    //snackbar written by ChatGPT
                    SnackbarHost(hostState = snackbarHostState)
                }
            }
        }
    }
}

