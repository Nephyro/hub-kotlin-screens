package com.example.hubexerccioskotlin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BasicFormIdade (navController: NavController, modifier: Modifier = Modifier) {

    var idade by remember {
        mutableStateOf(0)
    }

    Column(
        modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Texto de cabeçalho
        Column(
//            modifier
//                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Qual é a sua idade?",
                color = Color.Blue,
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp
            )
            Text(
                text = "Aperte os botões para informar a sua idade",
                fontSize = 17.sp
            )
        }
//==========================================/==========================================//

        Spacer(modifier = Modifier.height(20.dp))

//        Variável que receberá a idade informada pelo usuário através dos botões
        Box() {
            Text(text = idade.toString(), fontSize = 50.sp)
        }
//==========================================/==========================================//

//        Configuração dos botões de incremento e decremento de idade
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                onClick = { idade = (idade - 1).coerceIn(0, 180) }, // Limite inferior e superior de idade usando coerceIn que significa "dentro do intervalo"
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 40.sp
                )
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                onClick = {
//                    Condicional para não ultrapassar a idade máxima
                    if (idade < 180)
                        idade++
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 40.sp
                )
            }
        }
//==========================================/==========================================//

//      Área de condição para mostrar a mensagem de maior ou menor de idade
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (idade < 18) {
                    "Você é MENOR de idade"
                } else {
                    "Você é MAIOR de idade"
                },
                fontSize = 30.sp,
                color = Color.Blue
            )
        }
//==========================================/==========================================//

    }
}