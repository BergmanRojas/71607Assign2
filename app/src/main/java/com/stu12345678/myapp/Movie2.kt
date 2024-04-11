package com.stu12345678.myapp

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun Movie2(navController: NavController) {

    val seatsRemaining = remember { mutableStateOf(Random.nextInt(0, 16)) }

    val seatsSelected = remember { mutableStateOf(mutableListOf<Int>()) }

    val showSeatSelection = remember { mutableStateOf(false) }

    val showConfirmation = remember { mutableStateOf(false) }

    val seatStates = remember { mutableStateOf(List(15) { false }) }

    val backgroundImage: Painter = painterResource(id = R.drawable.background_image_movie2)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = { showSeatSelection.value = true },
                colors = ButtonDefaults.buttonColors(Color(0xFF000020)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 10.dp)
            ) {
                androidx.compose.material3.Text(
                    "Buy Ticket",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        IconButton(
            onClick = { navController.navigate(Routes.HomePage.route) },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .border(
                    width = 5.dp,
                    color = Color.White.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(percent = 20)
                )
        ) {
            Icon(
                painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Back",
                tint = Color.White
            )
        }
        if (showSeatSelection.value) {
            // Show a dialog with the seat selection options
            Dialog(onDismissRequest = { showSeatSelection.value = false }) {
                Column(
                    modifier = Modifier.background(Color.Gray.copy(alpha = 0.5F))
                ) {
                    Text(
                        text = "Seats",
                        color = Color.White,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Please select the seats you prefer on the map.",
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(Modifier.size(20.dp).background(Color(0xFF000020)))
                        Text("Available", color = Color.White, fontSize = 14.sp)
                        Box(Modifier.size(20.dp).background(Color.Gray))
                        Text("Selected", color = Color.White, fontSize = 14.sp)
                        Box(Modifier.size(20.dp).background(Color.Red))
                        Text("Booked", color = Color.White, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        for (row in 0 until 5) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                for (seat in 0 until 3) {
                                    val seatIndex = row * 3 + seat
                                    Button(
                                        onClick = {
                                            val newSeatStates = seatStates.value.toMutableList()
                                            newSeatStates[seatIndex] = true
                                            seatStates.value = newSeatStates
                                            if (!seatsSelected.value.contains(seatIndex + 1)) {
                                                seatsSelected.value.add(seatIndex + 1)
                                            }
                                            seatsRemaining.value = 15 - seatsSelected.value.size
                                        },
                                        colors = ButtonDefaults.buttonColors(if (seatStates.value[seatIndex]) Color.DarkGray else Color(0xFF000020)), // Change the button color to DarkGray if the seat is selected
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .width(95.dp)
                                            .height(30.dp)
                                    ) {
                                        Text(text = " ${seatIndex + 1}")
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Selected Seat(s): ${seatsSelected.value.sorted().joinToString(", ")}",
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {

                            showSeatSelection.value = false
                            showConfirmation.value = true
                        },
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp, vertical = 10.dp)
                    ) {
                        Text(
                            "Confirm Seats",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            /* Handle reset action here */
                            seatsSelected.value.clear()
                            seatStates.value = List(15) { false }
                            seatsRemaining.value = 15
                        },
                        colors = ButtonDefaults.buttonColors(Color.LightGray),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp, vertical = 10.dp)
                    ) {
                        Text(
                            "Reset",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        if (showConfirmation.value) {

            Dialog(onDismissRequest = { showConfirmation.value = false }) {
                Column(
                    modifier = Modifier.background(Color.Gray.copy(alpha = 0.5F))
                ) {
                    Text(
                        text = "Confirmation",
                        color = Color.White,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "You have selected ${seatsSelected.value.size} seat(s): ${seatsSelected.value.sorted().joinToString(", ")}.",
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${seatsRemaining.value} seat(s) remaining.",
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { /* Handle payment action here */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFF000020)),
                        modifier = Modifier
                            .fillMaxWidth() // Make the button wider
                            .padding(horizontal = 18.dp, vertical = 10.dp) // Adjust dimensions
                    ) {
                        Text(
                            "PAYMENT",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}