# 💰 Tip Calculator App

A modern **Tip Calculator Android App** built using **Jetpack Compose (Material 3)**.

This app allows users to:

- Enter a bill amount
- Enter tip percentage
- Split the bill between multiple people
- Round the tip amount
- View tip, total, and per-person amount in currency format

---

## 📱 Features

✅ Calculate Tip Amount  
✅ Calculate Total Amount (Bill + Tip)  
✅ Split Bill Between People  
✅ Round Tip Option (Switch)  
✅ Currency Formatting  
✅ Built with Jetpack Compose  
✅ Material 3 UI  

---

## 🛠 Tech Stack

- **Language:** Kotlin  
- **UI Toolkit:** Jetpack Compose  
- **Design:** Material 3  
- **Minimum SDK:** 24  
- **Compile SDK:** 35  
- **Android Gradle Plugin:** 8.7.3  
- **Gradle Version:** 8.10  

---

## 🧠 How It Works

### 1️⃣ User Inputs
- Bill Amount
- Tip Percentage
- Number of People
- Round Tip (ON/OFF)

### 2️⃣ Calculations

```kotlin
val tipAmount = billAmount * (tipPercent / 100)
val totalAmount = billAmount + tipAmount
val perPersonAmount = totalAmount / splitCount
