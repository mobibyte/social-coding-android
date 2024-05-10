@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.example.app.ui.theme.AppTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MomoNav()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MomoNav() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navigationController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    //Navigation
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            //nav drawer
            ModalDrawerSheet {
                LazyColumn (
                    modifier = Modifier.padding(top = 16.dp, end = 30.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    item {
                        NavigationDrawerItem(
                            label = { Text("Home") },
                            selected = currentRoute(navigationController) == Screens.Home.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.Home.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                        )
                    }
                    item {
                        NavigationDrawerItem(
                            label = { Text("About") },
                            selected = currentRoute(navigationController) == Screens.About.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.About.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Share, contentDescription = "About") }
                        )
                    }
                    item {
                        NavigationDrawerItem(
                            label = { Text("Officers") },
                            selected = currentRoute(navigationController) == Screens.Officers.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.Officers.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Person, contentDescription = "Officers") }
                        )
                    }
                    item {
                        NavigationDrawerItem(
                            label = { Text("Events") },
                            selected = false,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    openUrl("https://codewith.mobi/src/events/events.html", context)
                                }
                            },
                            icon = { Icon(Icons.Default.DateRange, contentDescription = "Events") }
                        )
                    }
                    item {
                        NavigationDrawerItem(
                            label = { Text("Apps") },
                            selected = currentRoute(navigationController) == Screens.Apps.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.Apps.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Create, contentDescription = "Apps") }
                        )
                    }
                }
            }
        }
    ) {
        //top bar navigation
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                CenterAlignedTopAppBar(
                    //colors for nav bar
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    //title for bar
                    title = {
                        Text(
                            "Momoapp",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navigationController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "localized Desc"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            },
        ) { paddingValues ->
            //navigation composable
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen,
                modifier = Modifier.padding(paddingValues),
            ) {
                composable(Screens.Home.screen) { Home(navController = navigationController) }
                composable(Screens.About.screen) { About(navController = navigationController) }
                composable(Screens.Officers.screen) { Officers(navController = navigationController) }
                composable(Screens.Apps.screen) { Apps(navController = navigationController) }
            }
        }

    }
}

// Helper function to get the current route
@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}