package com.example.petsshop.homeSections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petsshop.R
import com.example.petsshop.data.ManageList
import com.example.petsshop.ui.theme.DarkYellow

@Composable
fun Manage() {
    val manageList = listOf(
        ManageList("All", R.drawable.home),
        ManageList("Cat", R.drawable.cat_1),
        ManageList("Dog", R.drawable.dog_1),
        ManageList("Whale", R.drawable.whale_1)
    )

    var selectedCategory by remember { mutableStateOf(manageList[0]) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(manageList.size) { index ->
            val category = manageList[index]
            var isSelected by remember { mutableStateOf(category == selectedCategory) }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(8.dp)
                ) {
                    IconButton(
                        onClick = {
                            isSelected = !isSelected
                            if (isSelected) {
                                selectedCategory = category
                            }
                        },
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isSelected) DarkYellow else Color.White)
                            .size(64.dp)
                    ){
                        Icon(
                            imageVector = ImageVector.vectorResource(id = category.icon),
                            contentDescription = null,
                            tint = if (isSelected) Color.White else Color.Gray
                        )
                    }
                    Text(
                        text = category.name,
                        color = if (isSelected) Color.Black else Color.Gray,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }

}

