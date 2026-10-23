package me.camilo.ortiz.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    userName: String = "Miloxz",
    timeAgo: String = "3 pokedias",
    postText: String = "por fin termine estoooo",
    imageUrl: String = "https://picsum.photos/600/400",
    likeCount: Int = 24,
    commentCount: Int = 3,
    isLiked: Boolean = false,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onMoreClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Encabezado del Post
            PostHeader(
                userName = userName,
                timeAgo = timeAgo,
                onMoreClick = onMoreClick,
            )

            // Texto del Post
            Text(
                text = postText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface,
            )

            // Imagen del Post cargada con Coil
            AsyncImage(
                model = imageUrl,
                contentDescription = "Imagen de la publicación",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop,
            )

            // Estadísticas (Likes y Comentarios)
            PostStats(
                likeCount = likeCount,
                commentCount = commentCount,
            )

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 12.dp),
                thickness = 0.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
            )

            // Acciones del Post (Me gusta, Comentar, Compartir)
            PostActions(
                isLiked = isLiked,
                onLikeClick = onLikeClick,
                onCommentClick = onCommentClick,
                onShareClick = onShareClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}
