package com.rocketseat.nlw.nearby.data.model

import androidx.annotation.DrawableRes
import com.rocketseat.nlw.nearby.R

enum class NearbyCategoryFilterChipView (
    val description:String,
    @DrawableRes val icon:Int
)
{

    ALIMENTACAO(description="Alimentação", icon = R.drawable.ic_tools_kitchen_2),
    COMPRAS(description = "Compras",icon=R.drawable.ic_shopping_bag),
    HOSPEDAGEM(description = "Hospedagem",icon=R.drawable.ic_bed),
    SUPERMECADO(description = "Supermecado",icon=R.drawable.ic_shopping_cart);

    companion object{
        fun fromDescription(description: String):NearbyCategoryFilterChipView?{
            return entries.find {it.description==description}
        }
    }

}