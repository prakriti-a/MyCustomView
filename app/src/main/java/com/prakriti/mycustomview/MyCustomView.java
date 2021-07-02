package com.prakriti.mycustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCustomView extends View {

    // acc to custom_view_attributes.xml values
    private int viewColor, textColor;
    private String viewText;

    private Paint paintObject;

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paintObject = new Paint();
        // init var
        // pass attribute set, name of styleable defined in xml, def styl attr & res
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0);
        try {
            viewColor = typedArray.getInt(R.styleable.MyCustomView_viewColor, 0);
            textColor = typedArray.getInt(R.styleable.MyCustomView_textColor, 0);
            viewText = typedArray.getString(R.styleable.MyCustomView_viewText);
        }
        catch (Exception e) {
            typedArray.recycle(); // cant used typed array again after calling this
        }
    }

    // to draw custom view on screen, use onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // to make something that is not provided by default android library of views
        paintObject.setStyle(Paint.Style.FILL);
        paintObject.setAntiAlias(true);
        paintObject.setColor(viewColor);

        canvas.drawCircle(300, 300, 200, paintObject);
        paintObject.setColor(textColor);
        paintObject.setTextAlign(Paint.Align.CENTER);
        paintObject.setTextSize(40);
        canvas.drawText(viewText, 300, 300, paintObject);
    }

    public int getViewColor() {
        return viewColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public String getViewText() {
        return viewText;
    }

    public void setViewColor(int viewColor) {
        this.viewColor = viewColor;
        // redraw view with changes
        invalidate(); // invalidates the whole view
        requestLayout(); // redraw view
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
        requestLayout();
    }

    public void setViewText(String viewText) {
        this.viewText = viewText;
        invalidate();
        requestLayout();
    }
}
