package me.camilo.ortiz.facebook.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PostActions(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LikeButton(
            isLiked = isLiked,
            onClick = onLikeClick,
        )
        CommentButton(
            onClick = onCommentClick,
        )
        ShareButton(
            onClick = onShareClick,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostActionsPreview() {
    PostActions()
}
