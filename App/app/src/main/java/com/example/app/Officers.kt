package com.example.app

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

fun openUrl(url: String, context: Context) {
    val browserIntent = CustomTabsIntent.Builder().build()
    browserIntent.launchUrl(context, Uri.parse(url))
}

data class SocialMediaLink(
    val icon: Int,
    val url: String,
    val contentDescription: String? = null
)

@Composable
fun OfficerTemp(
    pfp: Int,
    name: String,
    title: String,
    description: String,
    socialMediaLinks: List<SocialMediaLink>,
    context: Context = LocalContext.current
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // PFP, Name, Title, and Description
            //pfp
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(170.dp)
                    // 2. Box for Image Shaping
                    .clip(MaterialTheme.shapes.extraLarge),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = pfp,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(5.dp)
                )
            }
            //name
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(5.dp)
            )
            //title
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(5.dp)
            )
            //descriptions
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(5.dp)
            )

            //website where i got the icons: https://www.iconfinder.com/search?q=instagram&category=social-media&price=free
            // Social Media Links
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)
            ) {
                socialMediaLinks.forEach { socialMediaLink ->
                    IconButton(
                        onClick = { openUrl(socialMediaLink.url, context) }
                    ) {
                        Icon(
                            painterResource(id = socialMediaLink.icon),
                            contentDescription = socialMediaLink.contentDescription
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Officers(navController: NavHostController, context: Context = LocalContext.current) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Diego
        item {
            val socialMediaLinkDiego = listOf(
                SocialMediaLink(
                    icon = R.drawable.github_icon,
                    url = "https://github.com/diegovester",
                    contentDescription = "Github"
                ),
            )
            
            OfficerTemp(
                pfp = R.drawable.diego_pfp,
                name = "Diego Vester",
                title = "President",
                description = "I was inspired by Mobi during my freshman year to make apps outside " +
                        "of class. My passion for helping people has led me to fundraise for non-profits " +
                        "and work with startups. Hopefully, I can inspire others to be creative and collaborate.\n",
                socialMediaLinks = socialMediaLinkDiego
            )
        }
        

        
    }
}

