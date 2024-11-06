Currency Converter App
======================

Overview
--------

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

Screenshots
-----------

* * * * *
