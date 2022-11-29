package com.composebottomnavigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.composebottomnavigation.screens.model.BottomNavItem

@Composable
fun BottomNavigationMenu(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    BottomNavMenuItem(item = item, isSelected = selected)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavMenuItem(item: BottomNavItem, isSelected: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (item.badgeCount > 0) {
            BadgeBox(
                badgeContent = {
                    Text(text = item.badgeCount.toString())
                }
            ) {
                Icon(imageVector = item.icon, contentDescription = item.name)
            }
        } else {
            Icon(imageVector = item.icon, contentDescription = item.name)
        }
        if (isSelected) {
            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
        }
    }
}