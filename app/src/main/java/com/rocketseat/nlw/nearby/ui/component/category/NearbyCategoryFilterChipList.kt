package com.rocketseat.nlw.nearby.ui.component.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rocketseat.nlw.nearby.data.model.NearbyCategory

@Composable
fun NearbyCategoryFilterChipList(modifier: Modifier = Modifier,
                                 categories:List<NearbyCategory>,
                                 onSelectedCategoryChange:(NearbyCategory)->Unit) {
    var selectedCategoryId by remember {
        mutableStateOf(categories.firstOrNull()?.id.orEmpty())
    }

    LaunchedEffect(key1 = selectedCategoryId) {
        val selectedCategoryOrNull = categories.find{it.id==selectedCategoryId}

        selectedCategoryOrNull?.let {
            onSelectedCategoryChange(it)
        }
    }

    LazyRow(
        modifier=modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(items=categories, key = {it.id}){
                NearbyCategoryFilterChip(category = it, isSelected = it.id==selectedCategoryId, onClick = {
                    isSelected ->
                    if(isSelected) selectedCategoryId = it.id
                }) 
            }
        }

}

@Preview
@Composable
private fun NearbyCategoriFilterChipListPreview() {

    NearbyCategoryFilterChipList(modifier = Modifier.fillMaxWidth(), categories = listOf(
        NearbyCategory(id="1", name = "Alimentação"),
        NearbyCategory(id="2", name = "Compras"),
        NearbyCategory(id="3", name = "Hospedagem"),
        NearbyCategory(id="4", name = "Supermecado"),


    ), onSelectedCategoryChange = {})

}