# PriceTextView
PriceTextView will be lifesaver for e-commerce and price included applications.

# How to Install
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.Colibri91:PriceTextView:0.1.0'
	}

# Usage
After importing the library you can set PriceTextView attributes. 

Attributes :

- textfont (You can give your .ttf file name)
- isStrikethrough (boolean option)
- currency (string option and you can add whatever you want)
- currencyPositionToLeft (default state is false, you can move currency left of your price)
- removeSpaceBetweenCurrencyAndPrice (if you do not want space between price and curency, you can set this true)

```
  <com.mertdolar.PriceTextView
                android:id="@+id/tvUserName"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:textfont="modern_pro.ttf"
                app:isStrikethrough="true"
                app:currency="$"
                app:currencyPositionToLeft="true"
                app:removeSpaceBetweenCurrencyAndPrice="true"/>
```
