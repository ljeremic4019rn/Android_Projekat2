package com.example.rmaproject2.ui.view.Login

import android.icu.number.Notation.simple
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rmaproject2.R
import com.example.rmaproject2.ui.theme.Purple500

@Composable
fun LoginPagee(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember { mutableStateOf("")}
    val passwordVal = remember { mutableStateOf("")}

    val passwordVisiblity = remember { mutableStateOf(false)}

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {

            }

            Spacer(modifier = Modifier.padding(20.dp))

            Scaffold (
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "RAF Student Helper",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.padding(20.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address") },
                            placeholder = { Text(text = "Email Address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it},
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisiblity.value = !passwordVisiblity.value
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.password_eye),
                                        contentDescription = "password",
                                        tint = if (passwordVisiblity.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            visualTransformation = if (passwordVisiblity.value)
                                VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(
                            onClick = {
                                if (emailVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter email address!", Toast.LENGTH_SHORT).show()
                                } else if (passwordVal.value.isEmpty()) {
                                    Toast.makeText(context, "Please enter the password", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Logged Successfully!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Sign In", fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Text(
                            text = "Create an Account?",
                            modifier = Modifier
                                .clickable {
                                    navController.navigate("register_page")
                                }
                        )

                        Spacer(modifier = Modifier.padding(20.dp))
                    }
                }
            }
        }
    }
}