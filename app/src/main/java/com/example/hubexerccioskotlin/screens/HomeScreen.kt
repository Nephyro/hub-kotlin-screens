package com.example.hubexerccioskotlin.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hubexerccioskotlin.ui.theme.Righteous

@Composable
fun Home (navController: NavController, modifier: Modifier = Modifier) {
    val gardientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(239, 247, 207), // Cor inicial (bege)
            Color(255, 255, 255)  // Cor final (Branco)
        )
    )

    var textFieldValue by remember {
        mutableStateOf("")
    }

    val quantidade = remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var lembrar by remember {
        mutableStateOf(false)
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetCompose by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }

    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }

    var favorito by remember {
        mutableStateOf(false)
    }

    Column(
        modifier
            .fillMaxSize()
//            .background(Color(239, 247, 207))
//            .background(brush = gardientBrush)
            .background(color = corFundo),
    ) {
        Text(
            text = "Exercícios android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            text = "com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        TextField(
            value = textFieldValue,
            onValueChange = { novoValor ->
                textFieldValue = novoValor
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            label = {
                Text(text = "Nome e sobrenome")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone pessoa",
//                    tint = Color(0xFF3DDC84)
                    tint = Color(66, 133, 244)
                )
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = quantidade.value,
            onValueChange = { novoValor ->
                quantidade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text(text = "Qual a quantidade?")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Red,
                unfocusedPlaceholderColor = Color.Magenta
            ),
            singleLine = true  // Limita a quantidade de linhas para apenas uma linha e bloqueia o enter
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Digite seu email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone pessoa",
                    tint = Color(66, 133, 244)
                )
            },
            shape = RoundedCornerShape(
                topStart = 32.dp,
//                topEnd = 32.dp,
//                bottomStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                focusedLabelColor = Color.Blue,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = lembrar,
                onCheckedChange = { lembrar = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "Lembrar de mim")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jetCompose,
                onCheckedChange = { jetCompose = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "Jetpack Compose")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = android,
                onCheckedChange = { android = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "Android")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = { sistemaSelecionado = 1 }
            )

            Text(text = "MacOs")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = { sistemaSelecionado = 2 }
            )

            Text(text = "Windows")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 3,
                onClick = { sistemaSelecionado = 3 }
            )

            Text(text = "Linux")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { navController.navigate("ex03") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Green
                ),
                border = BorderStroke(4.dp, Color.Red),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)
            ) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Star")
                Text(text = "Clique aqui!")
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color.Cyan
                }
            ) {
                Text(text = "Outro botão")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    corFundo = Color(239, 247, 207)
                }
            ) {
                Text(text = "Voltar fundo")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

//          Condição ternária (if else) em imagem           //
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (favorito) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
//                        efeito ao clicar na imagem
                        .clickable {
                            favorito = false    // Troca o valor da variável favorito para false
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon"
                )
            } else {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favorito = true // Troca o valor da variável favorito para true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Border Icon"
                )
            }
        }
//====================================================/====================================================//

    }
}
