package me.camilo.ortiz.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.camilo.ortiz.facebook.ui.screens.FacebookLoginScreen
import me.camilo.ortiz.facebook.ui.screens.FacebookRecoverPasswordScreen
import me.camilo.ortiz.facebook.ui.screens.FacebookRegisterScreen
import me.camilo.ortiz.facebook.ui.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val myNavController = rememberNavController()

            NavHost(
                navController = myNavController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login") {
                    FacebookLoginScreen(
                        onClickRegister = {
                            myNavController.navigate(route = "register")
                        },
                        onClickIniciarSesion = {
                            myNavController.navigate(route = "feed")
                        },
                        onClickForgotPassword = {
                            myNavController.navigate(route = "recover_password")
                        }
                    )
                }
                composable(route = "register") {
                    FacebookRegisterScreen(
                        onClickBack = {
                            myNavController.popBackStack()
                        }
                    )
                }
                composable(route = "recover_password") {
                    FacebookRecoverPasswordScreen(
                        onClickBack = {
                            myNavController.popBackStack()
                        },
                        onSendRecovery = { inputData ->
                            // Enviar datos al servicio de autenticación y volver al login
                            myNavController.popBackStack()
                        }
                    )
                }
                composable(route = "feed") {
                    FeedScreen()
                }
            }
        }
    }
}