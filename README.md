Currency Converter App
======================

Overview
--------

[![Demo video](demo.gif)](demo.mp4)

The **Currency Converter App** allows users to convert an amount from one currency to another. It supports real-time currency rate updates and provides a simple, easy-to-use interface to perform currency conversions.

### Features:

-   Convert an amount from one currency to another.
-   Display real-time conversion rates using up-to-date data.
-   Support multiple currencies with a dynamic list of options.
-   Clean and user-friendly design.
-   Displays conversion results in an easy-to-read format.

* * * * *

Installation
------------

1.  **Clone the repository** or **download** the project:

    `https://github.com/phuonnngminh/currency-converter.git`

2.  Open the project in **Android Studio**.

3.  Make sure to add any required dependencies in your `build.gradle` file. You may need to add a network permission for fetching data:

    `<uses-permission android:name="android.permission.INTERNET"/>`

* * * * *

Usage
-----

1.  **Open the app**.
2.  Choose the **source currency** (the currency you want to convert from) from the dropdown list.
3.  Choose the **target currency** (the currency you want to convert to) from the dropdown list.
4.  **Enter the amount** you want to convert.
5.  **Press the "Convert" button** to get the result.
6.  The conversion result will be displayed left of the button, showing the converted amount in the target currency.

* * * * *

Technologies Used
-----------------

-   **Kotlin** - Primary language for development.
-   **Android SDK** - For building the Android app.
-   **Jetpack Compose** / **XML Layouts** - For UI components and layout management.
-   **Hilt** - For dependency injection.
-   **Coroutine** - For asynchronous tasks (fetching currency rates).
-   **Retrofit** - For API calls to fetch real-time exchange rates.
-   **ConstraintLayout** - For flexible and responsive layout design.

* * * * *

Challenges and Notes
--------------------

- **Free API Restriction**: The free tier of the currency API doesn’t allow direct conversions between arbitrary currency pairs. To work around this, I had to first convert from the source currency to EUR, then from EUR to the target currency.

- **Learning MVVM and Hilt**: This project was my first time using the MVVM (Model-View-ViewModel) architecture and dependency injection with Hilt. Getting familiar with this design pattern and Hilt's injection setup took some time but improved the app’s structure and testability.

- **Working with Retrofit**: Integrating Retrofit for API calls was a learning curve. Configuring it to handle network responses and managing errors gracefully added to the challenge.

* * * * *
