package com.stu12345678.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController




// Importa la función DatePickerDialog desde tu paquete


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    val image: Painter = painterResource(id = R.drawable.red_star)
    val sizeTop: Dp = 40.dp
    val filmGallery: Painter = painterResource(id = R.drawable.films_gallery)
    val savedFilms: Painter = painterResource(id = R.drawable.saved_films)
    val calendar: Painter = painterResource(id = R.drawable.calendar)

    val sizeFirst = 50.dp
    val sizeSecond = 90.dp
    val sizeThird = 50.dp

    var isSearchViewVisible by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    val screenHeight = LocalConfiguration.current.screenHeightDp.toFloat()

    val middleGradientStartY = 0.5f // Inicio del degradado gris oscuro, en la mitad de la pantalla
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF000020), // Color gris oscuro
            Color(0xFF000056), // Color intermedio
            Color.White
        ),
        startY = screenHeight * middleGradientStartY,
        endY = screenHeight // Ajustado para que el degradado llegue hasta el final de la pantalla
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF000020),
                    titleContentColor = Color(0xFFFAFAFA),
                ),
                modifier = Modifier.height(100.dp), // Aumenta la altura del TopAppBar
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isSearchViewVisible) {
                            TextField(
                                value = searchText,
                                onValueChange = { newText -> searchText = newText },
                                label = { androidx.compose.material3.Text("Search") },
                                modifier = Modifier
                                    .height(200.dp)
                                    .weight(5f) // Ocupa todo el espacio disponible
                                    .align(Alignment.CenterVertically), // Alinea el TextField en el centro verticalmente
                                shape = RoundedCornerShape(20)
                            )
                        } else {
                            Spacer(modifier = Modifier.weight(1f)) // Agrega un espacio en la parte izquierda
                            Image(
                                painter = painterResource(id = R.drawable.cineworld1), // Cambia la imagen a cineworld.png
                                contentDescription = "Cineworld",
                                modifier = Modifier
                                    .size(200.dp) // Aumenta el tamaño de la imagen
                                    .align(Alignment.Bottom) // Alinea la imagen con la parte inferior
                            )
                            Spacer(modifier = Modifier.weight(1f)) // Agrega un espacio en la parte derecha
                        }
                    }
                },
                actions = {
                    Spacer(modifier = Modifier.height(200.dp)) // Agrega un espacio en la parte superior del icono de búsqueda
                    IconButton(onClick = { isSearchViewVisible = !isSearchViewVisible }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                    }
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF000020),
                contentColor = Color(0xFFFAFAFA),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = filmGallery,
                        contentDescription = "First_Image",
                        modifier = Modifier
                            .size(sizeFirst)
                            .clickable {
                                // Add your action here
                                println("Image clicked!")
                            }
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = savedFilms,
                        contentDescription = "Second_Image",
                        modifier = Modifier
                            .size(sizeSecond)
                            .clickable {
                                // Add your action here
                                println("Image clicked!")
                            }
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Image(
                        painter = calendar,
                        contentDescription = "Third_Vector",
                        modifier = Modifier
                            .size(sizeThird)
                            .clickable {
                                // Add your action here
                                println("Image clicked!")
                            }
                    )
                }
            }
        },


        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(brush = gradient),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            // Botón 1
                            ToMovie1Button(
                                onClick = {
                                    navController.navigate(Routes.Movie1.route)
                                },
                                buttonWidth = 215.dp, // Ancho del botón
                                buttonHeight = 350.dp, // Alto del botón
                                imageId = R.drawable.movie1, // ID de la imagen a mostrar en el botón
                                cornerRadius = 16.dp // Radio de esquina del botón
                            )

                            // Botón 2
                            ToMovie2Button(
                                onClick = {
                                    navController.navigate(Routes.Movie2.route)
                                },
                                buttonWidth = 215.dp, // Ancho del botón
                                buttonHeight = 350.dp, // Alto del botón
                                imageId = R.drawable.movie2, // ID de la imagen a mostrar en el botón
                                cornerRadius = 16.dp // Radio de esquina del botón
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre las filas

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            // Botón 3
                            ToMovie3Button(
                                onClick = {
                                    navController.navigate(Routes.Movie3.route)
                                },
                                buttonWidth = 215.dp, // Ancho del botón
                                buttonHeight = 350.dp, // Alto del botón
                                imageId = R.drawable.movie3, // ID de la imagen a mostrar en el botón
                                cornerRadius = 16.dp // Radio de esquina del botón
                            )

                            // Botón 4
                            ToMovie4Button(
                                onClick = {
                                    navController.navigate(Routes.Movie4.route)
                                },
                                buttonWidth = 215.dp, // Ancho del botón
                                buttonHeight = 350.dp, // Alto del botón
                                imageId = R.drawable.movie4, // ID de la imagen a mostrar en el botón
                                cornerRadius = 16.dp // Radio de esquina del botón
                            )
                        }
                    }
                }
            }
        }
    )
}