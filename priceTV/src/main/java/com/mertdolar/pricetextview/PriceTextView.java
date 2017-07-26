package com.mertdolar.pricetextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by rifatmertdolar on 25/07/2017.
 */

public class PriceTextView extends TextView {


    public PriceTextView(Context context) {
        super(context);
    }

    public PriceTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        readAttrs(context,attrs);
    }

    public PriceTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttrs(context,attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PriceTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        readAttrs(context,attrs);
    }

    private void readAttrs(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PriceTextView);
        if(a == null)
        {
            return;
        }

        String fontName = a.getString(R.styleable.PriceTextView_textfont);
        boolean strikethrough = a.getBoolean(R.styleable.PriceTextView_isStrikethrough,false);
        String currency = a.getString(R.styleable.PriceTextView_currency);
        boolean currencyPosition = a.getBoolean(R.styleable.PriceTextView_currencyPositionToLeft,false);
        boolean removeSpaceBetweenCurrencyAndPrice = a.getBoolean(R.styleable.PriceTextView_removeSpaceBetweenCurrencyAndPrice,false);

        Typeface font;
        if (fontName != null) {
            try{
                font = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+ fontName);
                this.setTypeface(font);
            }
            catch (Exception ex)
            {
                Log.e("Error",ex.getMessage());
            }
        }

        if(strikethrough)
            this.setPaintFlags(this.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        if(currency == null)
            currency = "₺";

        if(removeSpaceBetweenCurrencyAndPrice)
        {
            if(!currencyPosition)
                this.setText(this.getText().toString() + currency);
            else
                this.setText(currency + this.getText().toString());
        }
        else
        {
            if(!currencyPosition)
                this.setText(this.getText().toString() + " " + currency);
            else
                this.setText(currency + " " + this.getText().toString());
        }

        a.recycle();
    }
}