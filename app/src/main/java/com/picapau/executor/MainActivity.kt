
package com.picapau.executor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val NeonPurple = Color(0xFFB000FF)
private val DarkBackground = Color(0xFF10051C)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var key by remember { mutableStateOf("") }
            var status by remember {
                mutableStateOf("Insira sua Key para começar")
            }

            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = NeonPurple,
                    background = DarkBackground,
                    surface = Color(0xFF21102F)
                )
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkBackground
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "🐦 PICA PAU",
                            color = NeonPurple,
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Black
                        )

                        Text(
                            text = "EXECUTOR",
                            color = Color.White,
                            fontSize = 18.sp,
                            letterSpacing = 6.sp
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Card(
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF21102F)
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "VALIDAÇÃO DE KEY",
                                    color = NeonPurple,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                OutlinedTextField(
                                    value = key,
                                    onValueChange = { key = it },
                                    label = { Text("Digite sua Key") },
                                    singleLine = true
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Button(
                                    onClick = {
                                        status = if (key.isBlank()) {
                                            "Digite uma Key primeiro"
                                        } else {
                                            "Validação ainda não configurada"
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = NeonPurple
                                    )
                                ) {
                                    Text("VERIFICAR KEY")
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = status,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Biblioteca e organização de scripts",
                            color = Color.LightGray,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "PICA PAU EXECUTOR • V1.0",
                            color = NeonPurple,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }
    }
}
