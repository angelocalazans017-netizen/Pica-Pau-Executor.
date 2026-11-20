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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File

private val Bg = Color(0xFF090611)
private val Purple = Color(0xFFB45CFF)
private val Cyan = Color(0xFF54E6FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createConfigFiles()
        setContent { PicaPauApp() }
    }

    private fun createConfigFiles() {
        val folder = File(filesDir, "PicaPau")
        folder.mkdirs()
        val config = File(folder, "config.json")
        if (!config.exists()) {
            config.writeText(
                """{
  "app_name": "Pica Pau Executor",
  "theme": "neon-purple",
  "license_duration_days": 7,
  "profile_image": "images/profile.png"
}"""
            )
        }
        File(folder, "images").mkdirs()
        val keyInfo = File(folder, "key.json")
        if (!keyInfo.exists()) keyInfo.writeText(
            """{"key": "", "activated_at": null, "expires_at": null}"""
        )
    }
}

@Composable
private fun PicaPauApp() {
    var key by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Aguardando configuração da Key") }

    MaterialTheme(colorScheme = darkColorScheme(
        background = Bg, surface = Color(0xFF171024),
        primary = Purple, secondary = Cyan
    )) {
        Box(
            modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(listOf(Color(0xFF211035), Bg, Color(0xFF080D18)))
            ).padding(22.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Text("PICA PAU", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Black)
                Text("EXECUTOR", color = Purple, fontSize = 19.sp, fontWeight = FontWeight.Bold, letterSpacing = 6.sp)
                Text("NEON PURPLE EDITION", color = Cyan, fontSize = 11.sp, letterSpacing = 3.sp)
                Spacer(Modifier.height(10.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xCC171024)),
                    shape = RoundedCornerShape(22.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text("LICENÇA", color = Purple, fontWeight = FontWeight.Bold)
                        OutlinedTextField(
                            value = key, onValueChange = { key = it },
                            label = { Text("Digite sua Key") },
                            singleLine = true, modifier = Modifier.fillMaxWidth()
                        )
                        Button(
                            onClick = { status = if (key.isBlank()) "Digite uma Key primeiro" else "Key recebida — configure a validação no projeto" },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Purple)
                        ) { Text("ATIVAR KEY", color = Color.White, fontWeight = FontWeight.Bold) }
                        Text(status, color = Cyan, fontSize = 12.sp)
                    }
                }
                Text("Configuração local criada na primeira abertura.", color = Color.LightGray, fontSize = 11.sp)
                Text("Build inicial de interface — sem execução de scripts Roblox.", color = Color.Gray, fontSize = 10.sp)
            }
        }
    }
}
