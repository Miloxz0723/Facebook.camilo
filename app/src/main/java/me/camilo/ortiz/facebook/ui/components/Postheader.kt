package me.camilo.ortiz.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
    userName: String = "Miloxz",
    timeAgo: String = "Hace 2 horas",
    onMoreClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono de usuario/perfil
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(40.dp),
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Nombre y hora en columna
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = userName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = timeAgo,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        // Ícono de los 3 puntos en la parte derecha
        IconButton(onClick = onMoreClick) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Más opciones",
                tint = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostHeaderPreview() {
    PostHeader()
}
