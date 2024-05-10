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
            .padding(45.dp)
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
                modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp)
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
            .padding(top = 16.dp, ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //title
        item {
            Text(
                text = "Meet our Officers!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(5.dp),
            )
        }

        //Diego Vester
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

        //Trevor Reigh
        item {
            val socialMediaLinkTrevor = listOf(
                SocialMediaLink(
                    icon = R.drawable.instagram_icon,
                    url = "https://codewith.mobi/apps/trevorddr5/trevy.html",
                    contentDescription = "instagram"
                ),
                SocialMediaLink(
                    icon = R.drawable.linkedin_business_network_social_icon,
                    url = "https://codewith.mobi/apps/trevorddr5/trevy.html",
                    contentDescription = "instagram"
                ),
                SocialMediaLink(
                    icon = R.drawable.github_icon,
                    url = "https://codewith.mobi/apps/trevorddr5/trevy.html",
                    contentDescription = "instagram"
                ),
            )

            OfficerTemp(
                pfp = R.drawable.trevor_pfp,
                name = "Trevor Reigh",
                title = "Vice President",
                description = "I am a dedicated follower of the church of Long Long live MOBI, and Long live Long!\n" +
                        "\"woah I know that guy he's so cool\" – everyone\n",
                socialMediaLinks = socialMediaLinkTrevor
            )
        }

        //Devrat Patel
        item {
            val socialMediaLinkDevrat = listOf(
                SocialMediaLink(
                    icon = R.drawable.linkedin_business_network_social_icon,
                    url = "https://www.linkedin.com/in/devratpatel/",
                    contentDescription = "linkedin"
                ),
                SocialMediaLink(
                    icon = R.drawable.github_icon,
                    url = "https://github.com/DevratPatel",
                    contentDescription = "github"
                ),
            )

            OfficerTemp(
                pfp = R.drawable.devrat_pfp,
                name = "Devrat Patel",
                title = "Sr. Developer + Marketing",
                description = "\n" +
                        "\n" +
                        "Howdy Hey \uD83D\uDC4B\uD83C\uDFFB , I'm Devrat. I'm a computer science " +
                        "major student. I joined Mobi in my freshman year (i'm still a freshman lol) " +
                        "through social coding! I casually play badminton \uD83C\uDFF8. I'm a big Minions fan!!" +
                        " I encourage everyone to join Mobi and learn together. ",
                socialMediaLinks = socialMediaLinkDevrat
            )
        }

        //Ayden Koyanagi
        item {
            val socialMediaLinkAyden = listOf(
                SocialMediaLink(
                    icon = R.drawable.instagram_icon,
                    url = "https://www.instagram.com/mediocre_music_man_koiboi?igsh=aHJ3NXUyNWQwaWYz",
                    contentDescription = "instagram"
                ),
                SocialMediaLink(
                    icon = R.drawable.linkedin_business_network_social_icon,
                    url = "https://www.linkedin.com/in/ayden-koyanagi?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app",
                    contentDescription = "linkedin"
                ),
            )

            OfficerTemp(
                pfp = R.drawable.ayden_pfp,
                name = "Ayden Koyanagi",
                title = "Sr. Developer + Marketing",
                description = " Hi! I'm Ayden, currently in my third year at UTA, studying computer science, " +
                        "and in my first year with MOBI. I'm most passionate about bridging the gap between " +
                        "technology and creative art. Some of my hobbies include creating music, cooking, " +
                        "and following Formula 1! ",
                socialMediaLinks = socialMediaLinkAyden
            )
        }

        //Viraj Sabhaya
        item {
            val socialMediaLinkViraj = listOf(
                SocialMediaLink(
                    icon = R.drawable.linkedin_business_network_social_icon,
                    url = "https://www.linkedin.com/in/vsabhaya23/",
                    contentDescription = "Linkedin"
                ),
                SocialMediaLink(
                    icon = R.drawable.github_icon,
                    url = "https://github.com/virajsabhaya23",
                    contentDescription = "Github"
                ),
            )

            OfficerTemp(
                pfp = R.drawable.viraj,
                name = "Viraj Sabhaya",
                title = "Jr. Developer",
                description = "I'm a senior pursuing Computer Science at UT Arlington, deeply engaged " +
                        "in software development and research projects at the IT Lab. Specializing in AI," +
                        " SaaS, data analysis, and software development, I'm driven to explore innovative" +
                        " solutions and collaborate on impactful projects that push the boundaries of technology. ",
                socialMediaLinks = socialMediaLinkViraj
            )
        }

        //Ashly Andrews
        item {
            val socialMediaLinkAshley = listOf(
                SocialMediaLink(
                    icon = R.drawable.github_icon,
                    url = "https://github.com/codewithashley",
                    contentDescription = "Github"
                ),
            )

            OfficerTemp(
                pfp = R.drawable.ash,
                name = "Ashley Andrews",
                title = "Jr. Developer",
                description = "Ciao! I'm Ashley a freshman software engineering student at UTA. " +
                        "I'm passionate about learning more about cybersecurity and software engineering. " +
                        "As a newly elected officer of MOBI I hope to develop my skillsets and contribute to the club." +
                        " Current languages I'm learning: C, Python, Italian and German. ",
                socialMediaLinks = socialMediaLinkAshley
            )
        }
        

        
    }
}

