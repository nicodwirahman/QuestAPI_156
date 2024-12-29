package com.example.p12.ui.View

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.p12.ui.ViewModel.InsertUiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertUiEvent: InsertUiEvent,
    modifier: Modifier,
    onValueChange:(InsertUiEvent)->Unit={},
    enabled: Boolean = true
){

}
