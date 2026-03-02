package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {

    var billInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var splitInput by remember { mutableStateOf("") }
    var roundTip by remember { mutableStateOf(false) }

    val billAmount = billInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val splitCount = splitInput.toIntOrNull()?.takeIf { it > 0 } ?: 1

    var tipAmount = billAmount * (tipPercent / 100)

    if (roundTip) {
        tipAmount = ceil(tipAmount)
    }

    val totalAmount = billAmount + tipAmount
    val perPersonAmount = totalAmount / splitCount

    val currencyFormatter = NumberFormat.getCurrencyInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Tip Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Bill Input
        OutlinedTextField(
            value = billInput,
            onValueChange = { billInput = it },
            label = { Text("Bill Amount") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tip Percentage Input
        OutlinedTextField(
            value = tipInput,
            onValueChange = { tipInput = it },
            label = { Text("Tip Percentage") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Split Between People
        OutlinedTextField(
            value = splitInput,
            onValueChange = { splitInput = it },
            label = { Text("Number of People") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Round Tip Switch
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Round Tip")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = roundTip,
                onCheckedChange = { roundTip = it }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Results
        Text("Tip Amount: ${currencyFormatter.format(tipAmount)}")
        Text("Total Amount: ${currencyFormatter.format(totalAmount)}")
        Text("Per Person: ${currencyFormatter.format(perPersonAmount)}")
    }
}

@Preview(showBackground = true)
@Composable
fun TipCalculatorPreview() {
    TipCalculatorTheme {
        TipCalculatorApp()
    }
}